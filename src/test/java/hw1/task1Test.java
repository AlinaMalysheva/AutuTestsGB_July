package hw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// ПРОВЕРКА метода, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class task1Test {

    @DisplayName("Integer") //почему не заработало =(
    //а нельзя параметризовать передачу типа?
    @Test
    public void chngElmsTest() {
        Task1<Integer> testArr1 = new Task1<>(1, 2, 3, 4, 5, 6);
        testArr1.changElms(1,2);
        System.out.println(testArr1.getTask1Arr());
        Assert.assertEquals(testArr1.getTask1Arr(),"[2, 1, 3, 4, 5, 6]");
    }
    @Test
    @DisplayName("String")
    public void chngElmsTest2() {
        Task1<String> testArr1 = new Task1<>("a","Bb","ccc","ddd");
        testArr1.changElms(1,(testArr1.getLength()));
        System.out.println(testArr1.getTask1Arr());
        Assert.assertEquals(testArr1.getTask1Arr(),"[ddd, Bb, ccc, a]");
    }

}