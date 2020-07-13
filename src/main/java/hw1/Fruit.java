package hw1;

public class Fruit {
    FruitType type;
    Float weight;

    public Fruit(FruitType type) {
        this.type=type;
        switch (type) {
            case Apple : this.weight=1.0f; break;
            case Orange:this.weight=1.5f;break;
            default:System.out.println("Неизвестный тип фрукта, внесите в Enum");
        }
    }

    public Float getWeight() {
        return weight;
    }

    public FruitType getType() {
        return type;
    }
}
