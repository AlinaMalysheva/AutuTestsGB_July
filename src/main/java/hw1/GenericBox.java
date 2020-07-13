package hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericBox <T extends Fruit> {
    FruitType typeOfBox;
    List<T> arrFruits = new ArrayList<>();
    int sizeOfBox;
    // сперва сделала отдельный параметр freeRoom, но при использовании его в коде метода checkFreeRoom
    // почему-то всегда высчитывался ноль
    //int freeRoom= (this.sizeOfBox-((Integer)(this.arrFruits.size())));
    boolean isEmpty = true;

    GenericBox(int sizeOfBox){
        this.sizeOfBox=sizeOfBox;
    }

    //проверка на тип коробки, исключающее складирование разных типов фруктов в одну коробку
    private boolean checkBoxType(FruitType type){
        return (this.isEmpty ? true: (type==this.typeOfBox));
    }

    //проверка свободного места в коробке
    private boolean checkFreeRoom(int amount) {return (amount<
            //пришлось убрать, почему не работало - не поняла
            //this.freeRoom
            (this.sizeOfBox-((Integer)(this.arrFruits.size()))));
    }

    //проверка однородности типов фруктов, которые пытаемся положить в корзинку
    private boolean checkUniformity(T... fruits){
        FruitType typeFirstEl = fruits[0].type;
        for(int i=1;i<fruits.length;i++){
            if (fruits[i].type != typeFirstEl){
                return false;
            }
        } return true;
    }

    public void putFruit(T... fruits) throws Exception {
        if (!checkUniformity(fruits)){
            throw new ClassCastException("Пытаемся запихать сразу и яблоки и апельсины");
        }

        if(isEmpty || checkFreeRoom(fruits.length)) {
            if(checkBoxType(fruits[0].type)){
                this.typeOfBox=fruits[0].type;
                isEmpty = false;
                Collections.addAll(arrFruits, fruits);
            } else {
                throw new ClassCastException("В одну коробку одного типа нельзя класть другой тип фруктов");
            }
        } else {
            throw new Exception("Места мало в коробке");
        }
    }

    public void replaceFruit(int amount, GenericBox box) throws Exception {
        if (amount>arrFruits.toArray().length){
            throw new Exception("В коробке нет столько фруктов");
        }else{
            if(box.isEmpty){
                box.typeOfBox=this.typeOfBox;
            }

            if (box.typeOfBox == this.typeOfBox) {
                for (int i = 0; i < amount;i++ ){
                    box.putFruit(arrFruits.remove(0));
                    //System.out.println("Перенесли " + i + " " + box.typeOfBox);
                }
                if(this.arrFruits.toArray().length==0){
                    this.isEmpty=true;
                }
            }else {
                throw new ClassCastException("Нельзя пересыпать. Коробка другого типа");
            }
        }
    }

    public Float getWeightOfBox(){
        return arrFruits.toArray().length * arrFruits.get(0).getWeight();
    }

    public boolean compare(GenericBox otherBox){
        return ((this.getWeightOfBox())>(otherBox.getWeightOfBox()));
    }
}

