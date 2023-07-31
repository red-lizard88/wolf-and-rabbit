package project;

public abstract class AnimalFactoryAbstract extends Animal{

    public AnimalFactoryAbstract(String name, int maxStep, double weight) {
        super(name, maxStep, weight);
    }
    public AnimalFactoryAbstract() {
        super("Фабрика", 0, 0);

    }


    public abstract Animal createAnimal(String animalTypes);


}
