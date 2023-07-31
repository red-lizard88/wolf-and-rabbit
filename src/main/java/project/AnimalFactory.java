package project;

public class AnimalFactory extends AnimalFactoryAbstract {


    public AnimalFactory(String name, int maxStep, double weight) {
        super(name, maxStep, weight);
    }

    public AnimalFactory() {
        super("Фабрика", 0, 0);

    }

    @Override
    public Animal createAnimal(String animalTypes) {
        Animal animal = switch (animalTypes) {
            case "Волк" -> new Wolf();
            case "Кролик" -> new Rabbit();
            default -> null;
        };

        return animal;
    }


}
