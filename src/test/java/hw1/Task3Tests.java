package hw1;

import com.sun.org.apache.xpath.internal.operations.Or;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class Task3Tests  {

    @Test
    public void testPutFruit() throws Exception {
        Box boxAppleFirst = new Box(15);
        /*
        System.out.println("размер коробки " + boxAppleFirst.sizeOfBox);
        System.out.println("Kоличетсво яблок в ней " + ((Integer)(boxAppleFirst.arrFruits.size())));
        System.out.println("Пустого места: " + (boxAppleFirst.sizeOfBox- ((Integer)(boxAppleFirst.arrFruits.size()))));
         // System.out.println("Высчитали " + boxAppleFirst.freeRoom);
       */

        Box boxAppleSecnd = new Box(15);

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();
        boxAppleFirst.putFruit(apple1,apple2,apple3,apple4,apple5);

        System.out.println("В коробке 1: " + boxAppleFirst.arrFruits.toArray().length + " " + boxAppleFirst.typeOfBox);

        boxAppleFirst.replaceFruit(2, boxAppleSecnd);

        System.out.println("В коробке 1: " + boxAppleFirst.arrFruits.toArray().length);
        System.out.println("В коробке 2: " + boxAppleSecnd.arrFruits.toArray().length);

        System.out.println("Вес коробки 1: " + boxAppleFirst.getWeightOfBox());
        System.out.println("Вес коробки 2: " + boxAppleSecnd.getWeightOfBox());

    }

    @Test
    public void compareTest() throws Exception {
        Box boxAppleFirst = new Box(15);
        Box boxAppleSecnd = new Box(15);

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();
        boxAppleFirst.putFruit(apple1,apple2,apple3);
        boxAppleSecnd.putFruit(apple4,apple5);

        Box boxOrange = new Box(10);
        Orange orange1 = new Orange();
        boxOrange.putFruit(orange1);

        System.out.println("Первая коробка яблок весит больше, чем вторая. - " + boxAppleFirst.compare(boxAppleSecnd));
        System.out.println("Вторая коробка яблок весит больше, чем первая. - " + boxAppleSecnd.compare(boxAppleFirst));
        System.out.println("Вторая коробка яблок весит больше, чем корбка апельсинов. - " + boxAppleSecnd.compare(boxOrange));
    }

    @Test(expected = Exception.class)
    public void testCatchExeption() throws Exception {
        Box boxApple = new Box(10);
        Box boxOrange= new Box(10);
        for (int i = 0; i < 5; i++) {
            Apple apple = new Apple();
            boxApple.putFruit(apple);
        }
        for (int i = 0; i < 5; i++) {
            Orange orange = new Orange();
            boxOrange.putFruit(orange);
        }
        System.out.println("В коробке яблок: " + boxApple.arrFruits.toArray().length);
        System.out.println("В коробке апельсинов: " + boxOrange.arrFruits.toArray().length);
        boxApple.replaceFruit(2, boxOrange);
        System.out.println("Если грохнется с иксепшеном, сюда не дойдет");
    }
    @Test
    public void checkEmptyAgain() throws Exception {
        Box boxApple = new Box(1);
        Box boxAppleSec= new Box(1);

        Apple apple = new Apple();
        boxApple.putFruit(apple);

        boxApple.replaceFruit(1,boxAppleSec);

        Orange orange = new Orange();
        boxApple.putFruit(orange);

    }
}