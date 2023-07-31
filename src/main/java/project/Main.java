package project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static project.Constants.areaX;
import static project.Constants.areaY;

public class Main {

    public static void main(String[] args) {

        //  List<String> animalsNameList = Arrays.asList("Волк", "Кролик");

        HashMap<String, Integer> animalsMaxCountMap = new HashMap<>();
        animalsMaxCountMap.put("Волк", 30);
        animalsMaxCountMap.put("Кролик", 150);

        HashMap<String, Integer> animalsMaxStepMap = new HashMap<>();
        animalsMaxStepMap.put("Волк", 3);
        animalsMaxStepMap.put("Кролик", 2);


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


        // Создаем объекты животных на начальной арене с максимальным количеством на клетке
        for (int i = 0; i < areaY; i++) { // идем по строка
            for (int j = 0; j < areaX; j++) { // идем по столбцам
                Position position = new Position(j, i);

                //System.out.println(position);
                for (var animalName : animalsMaxCountMap.entrySet()) {

                    for (int m = 0; m < animalName.getValue(); m++) {
                        Animal animal = creator.createAnimal(animalName.getKey());
                        animal.setPosition(position);
                        animal.setId(String.valueOf(j) + i + m);

                        animalsList.add(animal);
                        //System.out.println(animal);
                    }
                }
                //wolf.move(wolf.maxStep);
                //System.out.println("Пришел-в-X:" + wolf.move(wolf.maxStep).get(0) + ", Пришел-в-Y:" + wolf.move(wolf.maxStep).get(1));
            }
        }

//        for (var oneAnimal:animalsList) {
//            System.out.println(oneAnimal);
//        }

        // Движение животных на клетках
        for (var animal : animalsList) {
            for (var animalMaxStep : animalsMaxStepMap.entrySet()) {
                if (animal.getName().equals(animalMaxStep.getKey())) {
                    animal.move(animalMaxStep.getValue(), animal.getPosition());
                }


            }
        }


        for (var oneAnimal : animalsList) {
            System.out.println(oneAnimal);
        }


//        System.out.println(animalsList.get(0).getPosition().getX());
//        System.out.println(animalsList.get(0).getPosition().getY());
//
//        Position positionAfterMove = animalsList.get(0).move(3, animalsList.get(0).getPosition());
//        System.out.println("X после движения:" + positionAfterMove.getX() + ", Y после движения:" + positionAfterMove.getY());
//
//        System.out.println(animalsList.get(0).getPosition().getX());
//        System.out.println(animalsList.get(0).getPosition().getY());
//

    }

}
