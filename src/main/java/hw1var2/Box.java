package hw1var2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Fruit> {
    Integer size;
    List<T> arrFruits = new ArrayList<>();


    Box(){this.size=10;}
    Box(int size){this.size=size;}

    private boolean checkFreeSpace(Box<T> box, int amount){
    return (amount<(box.size-box.arrFruits.size()));
    }

    public void putFruits(T... fruits){
        if(checkFreeSpace(this, fruits.length)){
            Collections.addAll(arrFruits,fruits);
           /* for (int i=0;i<arrFruits.size();i++) {
                System.out.println(arrFruits.get(i).getClass());
            }*/
        }else{
            throw new ArrayIndexOutOfBoundsException("В коробке нет столько свободного места");
        }
    }

    public Float getWeight(){
        float result=0f;
        for (int i=0;i<arrFruits.size();i++){
            result+=this.arrFruits.get(i).getWeight();
        }
        return result;
    }

    public boolean compareIsHeavier(Box<? extends Fruit> otherBox) throws Exception {
        if (this.equals(otherBox)){
            throw new Exception("Это одна и та же коробка");
        }else {
            return (this.arrFruits.size() > otherBox.arrFruits.size());
        }
    }

    public void replaceFruits(Box<T> newBox, int amount) {
        if (amount > this.arrFruits.toArray().length) {
            throw new ArrayIndexOutOfBoundsException("В первой коробке нет столько фруктов");
        } else {
            if (checkFreeSpace(newBox, amount)) {
                for (int i = 0; i < amount; i++) {
                    newBox.putFruits(arrFruits.remove(0));
                }
            }else{
                throw new ArrayIndexOutOfBoundsException("Во второй коробке нет столько места");
            }
        }
    }
}

