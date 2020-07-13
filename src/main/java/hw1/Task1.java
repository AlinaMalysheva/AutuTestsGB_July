package hw1;
//Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1<T>{

    private T[] task1Arr;

    public Task1(T... elms){
        this.task1Arr=elms;
    }

    public void changElms(int a, int b){
        T buffer = this.task1Arr[a-1];
        this.task1Arr[a-1]=this.task1Arr[b-1];
        this.task1Arr[b-1]=buffer;
    }

    public String getTask1Arr() {
        return Arrays.toString(task1Arr);
    }

    public int getLength(){
        return task1Arr.length;
    }

}

