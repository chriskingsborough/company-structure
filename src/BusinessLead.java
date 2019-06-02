import java.util.*;

public class BusinessLead extends Accountant {

    private int headCount;
    private ArrayList<Accountant> reports = new ArrayList<Accountant>();


    public BusinessLead(String name) {
        super(name);
        this.headCount = 10;
    }

    public boolean hasHeadCount() {
        if (this.reports.size() < this.headCount) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        if (hasHeadCount()) {
            this.reports.add(e);
            this.budget+= e.getBaseSalary() * 1.10;
            e.supportTeam(supportTeam);
            return true;
        } else {
            return false;
        }
    }

    public boolean requestBonus(Employee e, double bonus) {
        if (bonus <= this.budget) {
            e.setBaseSalary(e.getBaseSalary() + bonus);
            this.budget-= bonus;
            return true;
        } else {
            return false;
        }
    }

    public boolean approveBonus(Employee e, double bonus) {
        for (int i = 0; i < reports.size(); i++) {
            if (reports.get(i).equals(e.getManager()) && reports.get(i).approveBonus(bonus)) {
                return true;
            }
        }
        return false;
    }

    public String getTeamStatus() {
        String output = "";
        output += employeeStatus();
        if (reports.size() == 0) {
            output += " and no direct reports yet.";
        }
        else {
            output += " and is managing: \n";
            for (int i = 0; i < reports.size(); i++) {
               output += reports.get(i).employeeStatus() + "\n";
            }
        }
        return output;
    }
}
