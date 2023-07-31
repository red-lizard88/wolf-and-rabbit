package project;

import java.security.SecureRandom;
import java.util.List;

import static project.Constants.areaX;
import static project.Constants.areaY;

public abstract class Animal {
    private int maxStep;
    private double weight;
    private Position position;
    private String name;
    private String id;

    private boolean isLive = true;

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean isLive) {
        this.isLive = isLive;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMaxStep() {
        return maxStep;
    }

    public void setMaxStep(int maxStep) {
        this.maxStep = maxStep;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Animal(String name, int maxStep, double weight) {
        this.maxStep = maxStep;
        this.weight = weight;
        this.name = name;
        this.position = new Position(0, 0 );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Animal{"+ "hashCode:"+ hashCode() +
                ", maxStep=" + maxStep +
                ", weight=" + weight +
                ", isLive=" + isLive +
                ", position=" + position +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


//    Position move(Position position) {
//
//        int x = position.getX() + (int) ( Math.random() * 10 );
//        int y = position.getY() + (int) ( Math.random() * 7 );
//        return new Position(x, y);
//    }


    public Position move(int maxStep, Position position) {

        int x = position.getX();
        int y = position.getY();


        // Генерация рандомного шага от минимального равного 1 до максимального
        SecureRandom randomStep = new SecureRandom();
        int minStep = 1;
        int step = randomStep.nextInt(maxStep - minStep + 1) + minStep;

        SecureRandom randomStepXOrY = new SecureRandom();
        SecureRandom randomStepRightOrLeft = new SecureRandom();
        SecureRandom randomStepTopOrBottom = new SecureRandom();

        int oneStepXOrY = randomStepXOrY.nextInt(2); // Если 0 движение по Y, если 1 движение по X
        int oneStepRightOrLeft = randomStepRightOrLeft.nextInt(2); // Если 0 движение вправо, если 1 движение по влево
        int oneTopOrBottom = randomStepTopOrBottom.nextInt(2); // Если 0 движение вверх, если 1 движение по вниз


        System.out.println("Шаг:" + step + ", стартX:" + x + ", стартY:" + y);
        for (int k = 0; k < step; k++) {
            if (oneStepXOrY == 0) {
                if ((y != areaY - 1) && oneStepRightOrLeft == 0) {
                    y = y + 1;
                }else if (y==0 && oneStepRightOrLeft == 0) {
                    y = y + 1;
                }
                else if (y != areaY - 1 && y !=0 && oneStepRightOrLeft == 1) {
                    y = y - 1;
                }else if (y==0 && oneStepRightOrLeft == 1) {
                    y = y + 1;
                } else {
                    y = y - 1;
                }

            } else {
                if ((x != areaX - 1) && oneTopOrBottom == 0) {
                    x = x + 1;
                }else if (x==0 && oneTopOrBottom == 0) {
                    x = x + 1;
                }
                else if (x != areaX - 1 && x !=0  && oneTopOrBottom == 1) {
                    x = x - 1;
                } else if (x==0 && oneTopOrBottom == 1) {
                    x = x + 1;
                }else {
                    x = x - 1;
                }
            }
            oneStepXOrY = randomStepXOrY.nextInt(2); // Выбираем рандомно направление движение по X или Y
            oneStepRightOrLeft = randomStepRightOrLeft.nextInt(2); // Если 0 движение вправо, если 1 движение по влево
            oneTopOrBottom = randomStepTopOrBottom.nextInt(2); // Если 0 движение вверх, если 1 движение по вниз

            position.setX(x);
            position.setY(y);

        }

        return position;
    }




}
