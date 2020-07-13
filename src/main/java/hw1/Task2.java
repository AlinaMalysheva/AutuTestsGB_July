package hw1;
//Написать метод, который преобразует массив в ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task2<T> {

    private T[] task2Arr;

    public Task2(T... elms){
        this.task2Arr=elms;
    }

    public void setElemToArr(int i, T el) {
        this.task2Arr[i] = el;
    }

    public String getArr(){
        return Arrays.toString(task2Arr);
    }

    public T[] getPureArr(){
        return task2Arr;
    }

    public List<T> getListArr(){
        List<T> task2List = new ArrayList<>();
        Collections.addAll(task2List, task2Arr);
        return task2List;
    }
    
}
