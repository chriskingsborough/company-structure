abstract class TechnicalEmployee extends Employee {

    public int checkins;

    public TechnicalEmployee(String name) {
        super(name, 75000);

    }

    public TechnicalEmployee(String name, double baseSalary) {
        super(name, baseSalary);
    }

    public String employeeStatus() {

        return this.toString() + " has " + this.checkins + " successful check ins";
    }

}
