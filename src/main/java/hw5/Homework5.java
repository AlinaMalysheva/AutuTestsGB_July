package hw5;
/*
    Необходимо написать два метода, которые делают следующее:
  1) Создают одномерный длинный массив, например:
  2) Заполняют этот массив единицами.
  3) Засекают время выполнения
  4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
  5) Проверяется время окончания метода System.currentTimeMillis().
 Первый метод подряд, второй тредами
  */
public class Homework5 {

    public static void main(String[] args) throws InterruptedException {
        method1();
        method2();
    }

    public static void method1(){
        final int SIZE = 10_000_000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];
        for (int i = 0; i <SIZE ; i++) {
            arr[i] = 1;
        }
        long time = System.currentTimeMillis();
        for (int i = 0; i <SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
        System.out.println("Время выполенения обработки подряд: " + (System.currentTimeMillis()-time));
    }

    public static  void method2() throws InterruptedException {
        final int SIZE = 10_000_000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];
        for (int i = 0; i <SIZE ; i++) {
            arr[i] = 1;
        }
        long time = System.currentTimeMillis();
        float[] arrFirstPart = new float[HALF];
        float[] arrSecPart = new float[HALF];
        System.arraycopy(arr, 0, arrFirstPart, 0, HALF);
        System.arraycopy(arr, 0, arrSecPart, 0, HALF);
        Thread t1 = new Thread(()->{
            for (int i = 0; i <arrFirstPart.length; i++) {
                arrFirstPart[i] = (float)(arrFirstPart[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i <arrSecPart.length; i++) {
                arrSecPart[i] = (float)(arrSecPart[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.arraycopy(arrFirstPart, 0, arr, 0, arrFirstPart.length);
        System.arraycopy(arrSecPart, 0,arr , arrFirstPart.length, arrSecPart.length);

        System.out.println("Время работы тредами: " +(System.currentTimeMillis()-time));
    }
}
