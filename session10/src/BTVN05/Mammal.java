package BTVN05;

public class Mammal extends Animal {
    protected Boolean hasFur;

    public Mammal(String name, int age, Boolean hasFur) {
        super(name,age);
        this.hasFur = hasFur;
    }
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Có lông: " + (hasFur ? "Có" : "Không"));
    }

}
