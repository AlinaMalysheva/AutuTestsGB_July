package hw1var2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {

    @Test
    void testPutFruits() {
        Box<Apple> appleBox = new Box();
        for(int i = 0;i<2;i++){
            Apple apple =new Apple();
            appleBox.putFruits(apple);
        }
        System.out.println(appleBox.arrFruits.size());
    }

    @Test
    void getWeight() {
        Box<Orange> orangeBox = new Box();
        Orange orange =new Orange();
        orangeBox.putFruits(orange,orange,orange);
        System.out.println("Общий вес: " + orangeBox.getWeight());
    }

    @Test
    void compareIsHeavier() throws Exception {
        Box<Orange> orangeBox = new Box();
        Orange orange =new Orange();
        orangeBox.putFruits(orange,orange,orange);
        System.out.println("Общий вес апельсинов: " + orangeBox.getWeight());

        Box<Apple> appleBox = new Box();
        for(int i = 0;i<2;i++){
            Apple apple =new Apple();
            appleBox.putFruits(apple);
        }
        System.out.println("Общий вес яблок: " + appleBox.getWeight());

        System.out.println("Коробка яблок тяжелее коробки апельсинов? " + appleBox.compareIsHeavier(orangeBox));
        System.out.println("Коробка с апельсинами тяжелее коробки яблок? " + orangeBox.compareIsHeavier(appleBox));
    }
    @Test
    void compareSameBox() throws Exception {
        Box<Orange> orangeBox = new Box();
        Orange orange =new Orange();
        orangeBox.putFruits(orange,orange,orange);
        System.out.println("Общий вес апельсинов: " + orangeBox.getWeight());

        System.out.println("Коробка яблок тяжелее коробки апельсинов? " + orangeBox.compareIsHeavier(orangeBox));

    }

    @Test
    void replaceFruits() {
            Box<Orange> orangeBox = new Box();
            Orange orange =new Orange();
            orangeBox.putFruits(orange,orange,orange);

            Box<Orange> orangeBox1 = new Box();
            orangeBox1.putFruits(orange,orange,orange);

            orangeBox.replaceFruits(orangeBox1, 2);
            System.out.println("В коробке1 было 3 ап, стало: " + orangeBox.arrFruits.size()+
                ". В коробке2 было 3 ап, стало " + orangeBox1.arrFruits.size());


        orangeBox.replaceFruits(orangeBox1,2);

        }

    @Test
    void replaceFruits2() {
        Box<Orange> orangeBox = new Box();
        Orange orange =new Orange();
        orangeBox.putFruits(orange,orange,orange);

        Box<Orange> orangeBox1 = new Box(6);
        orangeBox1.putFruits(orange,orange,orange);

        orangeBox.replaceFruits(orangeBox1, 2);
        System.out.println("В коробке1 было 3 ап, стало: " + orangeBox.arrFruits.size()+
                ". В коробке2 было 3 ап, стало " + orangeBox1.arrFruits.size());

        orangeBox.replaceFruits(orangeBox1,1);

    }
    @Test
    void replaceFruits3() {
        Box<Orange> orangeBox = new Box();
        Orange orange =new Orange();
        orangeBox.putFruits(orange,orange,orange);

        orangeBox.replaceFruits(orangeBox, 2);
        System.out.println("В коробке1 было 3 ап, стало: " + orangeBox.arrFruits.size()+
                ". В коробке2 было 3 ап, стало " + orangeBox.arrFruits.size());


    }
}

