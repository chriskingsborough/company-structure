import java.util.*;

public class TechnicalLead extends SoftwareEngineer {


    private int headCount;
    private ArrayList<SoftwareEngineer> reports = new ArrayList<SoftwareEngineer>();

    public TechnicalLead(String name) {
        super(name);
        setBaseSalary(getBaseSalary()*1.3);
        this.headCount = 4;
    }

    public boolean hasHeadCount() {
        if (this.reports.size() < this.headCount) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addReport(SoftwareEngineer report) {
        if (hasHeadCount()) {
            reports.add(report);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList getReports() {
        return reports;
    }

    public boolean approveCheckIn(SoftwareEngineer engineer) {
        if (reports.contains(engineer) && engineer.hasCodeAccess()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean requestBonus(Employee employee, double bonus) {
        if (((Accountant) employee.getManager()).approveBonus(bonus)) {
            ((SoftwareEngineer) employee).bonus  += bonus;
            return true;
        }
        return false;
    }

    public String getTeamStatus() {
        String collective_status = employeeStatus();
        if (this.reports.size() == 0) {
            collective_status += " and no direct reports.";
        } else {
            collective_status += " and is managing:\n";
            for (int i = 0; i < this.reports.size(); i++) {
                collective_status += reports.get(i).employeeStatus();
                collective_status += "\n";
            }
        }

        return collective_status;
    }

}
