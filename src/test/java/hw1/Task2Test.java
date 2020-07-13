package hw1;

import org.junit.Test;

import java.util.List;

public class Task2Test {

    @Test
    public void testTask2() {
        Task2 testArr = new Task2(1,2,3,4);
        System.out.println("Был массив: " + testArr.getArr());
        List<?> testList = testArr.getListArr();
        System.out.println("Стал ArrayList:" + testList);
        testArr.setElemToArr(0, 5);
        System.out.println("Поменяли массив: " + testArr.getArr());
        System.out.println("Поменяли лист:" + testArr.getListArr());
        System.out.println("А старый лист тоже остался:" + testList);
        System.out.println(testList instanceof List);
    }


}