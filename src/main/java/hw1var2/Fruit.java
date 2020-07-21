package hw1var2;

public class Fruit {
    String fruitType;
    Float weight;

    Fruit(String fruitType, Float weight){
        this.fruitType=fruitType;
        this.weight=weight;
    }

    public Float getWeight() {
        return weight;
    }

    public String getFruitType() {
        return fruitType;
    }
}
