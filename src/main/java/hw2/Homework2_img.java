//второе
package hw2;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.util.Arrays;

public class Homework2_img {

    public static void main(String[] args) throws IOException {
        String pathToPic = "./src/main/resources/secret.png";
        String secretText = "Koatyl";
        putPasswordInFile(secretText, pathToPic);
        takePasswordFromFile(pathToPic);
    }

    public static void putPasswordInFile(String password, String pathToPic) throws IOException {
        byte[] byteArrayLength = password.getBytes();
        int stopDot=byteArrayLength.length;

        String password2 = password+"*!#";
        byte[] byteArray = password2.getBytes();
        System.out.println("Секретное слово в виде байт: " + Arrays.toString(byteArray));

        File file = new File(pathToPic);
        BufferedImage sourceImg = ImageIO.read(file);

        int coord = 20;

        for (int i = 0, m = coord; i < byteArray.length; i ++, m += 5) {
            int blue ;
            int red;
            int green;
            //Color color = new Color(sourceImg.getRGB(m, m));
          //  System.out.println("Цвета Г-К-З: " + color.getBlue() + " " + color.getRed() + " " + color.getGreen());
            if(i <stopDot) {
                blue = byteArray[i];
                red = byteArray[i];
                green = byteArray[i];
            } else {
                blue = byteArray[i];
                red = byteArray[++i];
                green = byteArray[++i];
            }
            //System.out.println("Зашифровали: " + blue + " " + red + " " + green);
            Color color = new Color(red, green, blue);
            sourceImg.setRGB(m, m, color.getRGB());
        }

        //Color colortest = new Color(sourceImg.getRGB(20, 20));
        //System.out.println("А сохранилось у нас: " + colortest.getBlue() + " " + colortest.getRed() + " " + colortest.getGreen());
        ImageIO.write(sourceImg, "png", file);
    }


    public static void takePasswordFromFile(String pathToPic) throws IOException {
        File file = new File(pathToPic);
        BufferedImage sourceImg = ImageIO.read(file);
        int coord = 20;
        int stop = 0;
        byte[] byteArr;
        System.out.println("Секретное слово изъятое: ");

        for (int m = coord,i=0; stop == 0; m += 5,i++) {
            Color color = new Color(sourceImg.getRGB(m, m));
            if (color.getBlue() == 42&&color.getRed()==33&&color.getGreen()==35) {
                stop = 1;
                break;
            }
            int result = color.getBlue();
            byte b= (byte)result;
            byte[] bArr = new byte[]{(byte)b};
            String s = new String(bArr);
            System.out.print(s);
        }
    }
}






