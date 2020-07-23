package hw3;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) throws IOException {
            Socket socket = new Socket("localhost", 6666);
            System.out.println("Клиент запустился");
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            getMessageFromServer(in);
            sendMessageToServ(out);

    }
    public static void  getMessageFromServer(DataInputStream in){
        new Thread(()->{
            while(true){
                try {
                    System.out.println("Сервер :" + in.readUTF());
                } catch (IOException e) {
                    System.out.println("\nCoединение закрыто");
                    e.printStackTrace();
                    break;
                }
            }
        }

        ).start();
    }

    public static void sendMessageToServ(DataOutputStream out){
        new Thread(()->{
            Scanner scanner = new Scanner(System.in);
            while(true){
                try {
                    out.writeUTF(scanner.nextLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        ).start();
    }
}
