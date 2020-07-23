package hw3;

import org.sqlite.JDBC;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

public class ServerApp {
    public static void main(String[] args) {

        try( ServerSocket serverSocket = new ServerSocket(6666)){
            System.out.println("Сервер запущен, жду подключения.");
            JDBCApp logs = new JDBCApp();
            Socket client = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            getMessageFromClient(in,logs);
            sendMessageToClient(out,logs);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void getMessageFromClient(DataInputStream in, JDBCApp logs){
        new Thread( ()->{
            while(true){
                String clientResponse = null;
                try {
                    clientResponse = in.readUTF();
                    Date time = new Date();
                    System.out.println("Клиент ответил ("+time+"): "+clientResponse);
                    logs.putDataInLogs(clientResponse,"Client",time.toString());
                    if(clientResponse.equals("log")) {
                        logs.readLogsFromDB();
                    }
                } catch (IOException | SQLException e) {
                    //System.err.println("Клиент отключился, кажется");
                    e.printStackTrace();
                    break;
                }
            }
        }).start();
    }

    private static void sendMessageToClient(DataOutputStream out,JDBCApp logs){
        new Thread( ()->{
            while (true){
                Scanner scanner = new Scanner(System.in);
                try {
                        String servMessage = scanner.next();
                        out.writeUTF(servMessage);
                        Date time = new Date();
                        logs.putDataInLogs(servMessage,"Server",time.toString());
                }catch (IOException | SQLException e){
                        e.printStackTrace();
                }
            }
        }).start();
    }


}
