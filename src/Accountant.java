public class Accountant extends BusinessEmployee {

    private TechnicalLead teamSupported;

    public Accountant(String name) {
        super(name);
        this.budget = 0;
    }

    public String employeeStatus() {
        return super.employeeStatus() + " is supporting " + teamSupported;
    }

    public TechnicalLead getTeamSupported() {
        return this.teamSupported;
    }

    public void supportTeam(TechnicalLead lead) {
        this.teamSupported = lead;


        // zero out budget
        this.budget = 0;
        for (int i=0; i<lead.getReports().size(); i++) {
            SoftwareEngineer s = (SoftwareEngineer) lead.getReports().get(i);
            this.budget += s.getBaseSalary();
        }

        this.budget*= 1.10;
    }

    public boolean approveBonus(double bonus) {
        return bonus <= this.budget && this.teamSupported != null;
    }
}
