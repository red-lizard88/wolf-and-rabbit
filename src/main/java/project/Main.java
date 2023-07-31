package project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> animalsNameList = Arrays.asList("Волк", "Кролик");
        List<Animal> animalsList = new ArrayList<>();

        AnimalFactoryAbstract creator = new AnimalFactory();
//        Animal ilya = creator.createAnimal("Волк");
//
//        Animal ann = creator.createAnimal("Кролик");

        //System.out.println("Start: " + ilya);
       // System.out.println("Start: " + ann);





//        for (int i = 0; i < 10; i++) {
//
//        Position newPosition = ilya.move(ilya.getPosition());
//        Position newPosition2 = ann.move(ann.getPosition());
//        ilya.setPosition(newPosition);
//        ann.setPosition(newPosition2);
//
//        System.out.println("End: " + ilya);
//        System.out.println("End: " + ann);
//        }

        for (int i = 0; i < 3; i++) { // идем по строка
            for (int j = 0; j < 5; j++) { // идем по столбцам
                Position position = new Position(j, i);

                System.out.println(position);
                for (var animalName: animalsNameList) {
                   Animal animal =  creator.createAnimal(animalName);
                   animal.setPosition(position);
                    System.out.println(animal);
                }


                //wolf.move(wolf.maxStep);
                //System.out.println("Пришел-в-X:" + wolf.move(wolf.maxStep).get(0) + ", Пришел-в-Y:" + wolf.move(wolf.maxStep).get(1));
            }
        }

    }

}
