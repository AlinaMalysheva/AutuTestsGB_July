package hw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Класс Box, в который можно складывать фрукты.
Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
Для хранения фруктов внутри коробки можно использовать ArrayList;

3.1 Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
3.2 Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
Можно сравнивать коробки с яблоками и апельсинами;
3.3 Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается,
а в другую перекидываются объекты, которые были в первой;

Не забываем про метод добавления фрукта в коробку.
 */
public class Box {
    FruitType typeOfBox;
    List<Fruit> arrFruits = new ArrayList<>();
    int sizeOfBox;
    // сперва сделала отдельный параметр freeRoom, но при использовании его в коде метода checkFreeRoom
    // почему-то всегда высчитывался ноль
    //int freeRoom= (this.sizeOfBox-((Integer)(this.arrFruits.size())));
    boolean isEmpty = true;

    Box(int sizeOfBox){
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
    private boolean checkUniformity(Fruit... fruits){
        FruitType typeFirstEl = fruits[0].type;
        for(int i=1;i<fruits.length;i++){
            if (fruits[i].type != typeFirstEl){
                return false;
            }
        } return true;
    }

    public void putFruit(Fruit... fruits) throws Exception {
        if (!checkUniformity(fruits)){
            throw new ClassCastException("Пытаемся запихать сразу и яблоки и апельсины");
        }

        if(isEmpty || checkFreeRoom(fruits.length)) {
            //System.out.println("Прошла проверка на то, что коробка пуста или места достаточно");
            if(checkBoxType(fruits[0].type)){
                //System.out.println("Прошла проверка на соответствие типа коробки типу фруктов. Запихиваем фрукты в коробку");
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

    public void replaceFruit(int amount, Box box) throws Exception {
        if (amount>arrFruits.toArray().length){
            throw new Exception("В коробке нет столько фруктов");
        }else{
            //System.out.println("Пытаемся переложить " + amount + " " + this.typeOfBox);
            if(box.isEmpty){
               // System.out.println("Коробка была пустой, присвоили ей тип первой коробки");
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

    public boolean compare(Box otherBox){
        return ((this.getWeightOfBox())>(otherBox.getWeightOfBox()));
    }
}
