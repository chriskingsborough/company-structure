abstract class Employee {

    // class variables
    private static int numEmployees;

    // instance variables
    private String name;
    private double baseSalary;
    private int employeeID;
    private Employee manager;


    public Employee(String name, double baseSalary) {
        numEmployees++;
        this.name = name;
        this.baseSalary = baseSalary;
        this.employeeID = numEmployees;

    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public String getName() {
        return this.name;
    }

    public int getEmployeeID() {
        return this.employeeID;
    }

    public boolean equals(Object other) {

        if (other instanceof Employee) {

            if (this.employeeID == ((Employee) other).employeeID) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public String toString() {
        return this.employeeID + " " + this.name;
    }

    abstract String employeeStatus();

    public Employee getManager() {
        return this.manager;
    }

    public double setBaseSalary(double salary) {
        this.baseSalary = salary;
        return this.baseSalary;
    }

}
