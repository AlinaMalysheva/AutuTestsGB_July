package hw2;

import java.io.*;

public class Homework2 {

    public static class AppData {

        private String[] header;
        private int[][] data;

        public AppData() { }

        public void setHeader(String[] header) {
            this.header = header;
        }

        public void setData(int[][] data) {
            this.data = data;
        }

        @Override
        public String toString() {
            String headers = "Заголовок: ";
            for (int i = 0; i < header.length; i++) {
                headers += header[i] + " ";
            }
            if(this.data != null){
                String data = "\nДанные:\n";
                for (int i = 0; i < this.data.length; i++) {
                    for (int j = 0; j < this.data[i].length; j++) {
                        data += this.data[i][j] + " ";
                    }
                    data += System.getProperty("line.separator");
                }
                return headers + data;
            } else{
                return headers;}
        }
    }

    public static void main(String[] args) {
        String filename = "AppData.csv";
        String[] data={"Value 1;Value 2;Value 3","300;400;3","1;2000;444","200;2300;3","32;2000;444"};
        writeDataInFail(filename,data);
        System.out.println(readData(filename));
    }

    public static void writeDataInFail(String filename, String[] data) {
        String lineSeparator = System.getProperty("line.separator");
        try (FileOutputStream out = new FileOutputStream(filename)) {
            for (int i = 0; i < data.length; i++) {
                out.write(data[i].getBytes());
                out.write(lineSeparator.getBytes());
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static AppData readData(String filename)  {
        AppData readedFile = new AppData();
        int lines = 0;
        int columns =0;
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            //считаю столбцы
            String str = in.readLine();
            String[] headers = str.split(";");
            readedFile.setHeader(headers);
            columns = headers.length;
            //считаю строки

            while ((str = in.readLine()) != null) {
                lines++;
                //
            }
        }catch(IOException e){
            e.printStackTrace();
        }
            try (BufferedReader in2 = new BufferedReader(new FileReader(filename))) {
            int[][]data=new int[lines][columns];
            int j = 0;
            String str = in2.readLine();
            while ((str=in2.readLine()) != null){
                String[] tokens = str.split(";");
                int[] newDataLine = new int[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    newDataLine[i]=Integer.parseInt(tokens[i]);
                }
                for (int i = 0; i <newDataLine.length ; i++) {
                    data[j][i] = newDataLine[i];
                }
                j++;
            }
            readedFile.setData(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readedFile;
    }
}