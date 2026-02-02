package BTVN01;

public class Lecturer extends Staff{
    private int teachingHours;

    public Lecturer(int id, String name, double baseSalary, int teachingHours) {
        super(id, name, baseSalary);
        this.teachingHours = teachingHours;
    }

    @Override
    public double calculateTotalSalary() {
        return baseSalary + teachingHours * 200000;
    }

    @Override
    public void checkPerformance() {
        System.out.println("Lecturer performance based on teaching hours.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Teaching Hours: " + teachingHours);
        System.out.println("---------------------------");
    }
}
