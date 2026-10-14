class Employee {
    private final String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() { return name; }

    public double calculatePay() {
        return baseSalary;
    }
}

class Manager extends Employee {
    private final double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculatePay() {
        return super.calculatePay() + bonus;
    }
}

class Developer extends Employee {
    private final int overtimeHours;
    private static final double OVERTIME_RATE = 25.0;

    public Developer(String name, double baseSalary, int overtimeHours) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculatePay() {
        return baseSalary + overtimeHours * OVERTIME_RATE;
    }
}

// NEW: Intern gets a fixed stipend, not a salary
class Intern extends Employee {
    private final double stipend;

    public Intern(String name, double stipend) {
        super(name, 0); // no base salary
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class PayrollDemo {
    public static void main(String[] args) {
        // one array holds all employee types
        Employee[] staff = {
            new Employee("Kudzai", 2000),
            new Manager("Nyasha", 3500, 800),
            new Developer("Tatenda", 3000, 10),
            new Intern("Chipo", 500)
        };

        // the payroll loop is unchanged even though Intern was added
        double total = 0;
        for (Employee e : staff) {
            double pay = e.calculatePay(); // polymorphic dispatch
            System.out.printf("%-10s %8.2f%n", e.getName(), pay);
            total += pay;
        }
        System.out.printf("Total payroll: %.2f%n", total);
    }
}