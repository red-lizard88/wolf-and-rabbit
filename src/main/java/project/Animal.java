package project;

public abstract class Animal {
    private int maxStep;
    private double weight;
    private Position position;
    private String name;

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
                ", position=" + position +
                ", name='" + name + '\'' +
                '}';
    }


    Position move(Position position) {

        int x = position.getX() + (int) ( Math.random() * 10 );
        int y = position.getY() + (int) ( Math.random() * 7 );
        return new Position(x, y);
    }
}
