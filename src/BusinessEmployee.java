abstract class BusinessEmployee extends Employee {

    public double budget;

    public BusinessEmployee(String name) {
        super(name, 50000);
    }

    public double getRemainingBudget() {
        return this.budget;
    }

    public String employeeStatus() {
        return this.toString() + " with a budget of " + this.budget;
    }
}
