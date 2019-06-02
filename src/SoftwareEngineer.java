public class SoftwareEngineer extends TechnicalEmployee {

    private int checkins;
    private boolean codeAccess;
    public double bonus;

    public SoftwareEngineer(String name) {
        super(name);
        this.checkins = 0;
        this.codeAccess = false;
    }

    public boolean getCodeAccess() {
        return this.codeAccess;
    }

    public void setCodeAccess(boolean access) {
        if (access) {
            this.codeAccess = true;
        } else {
            this.codeAccess = false;
        }
    }

    public boolean hasCodeAccess() {
        return codeAccess;
    }

    public int getSuccessfulCheckIns() {
        return this.checkins;
    }

    public boolean checkinCode() {
        if (((TechnicalLead) this.getManager()).approveCheckIn(this)) {
            this.checkins++;
            return true;
        } else {
            codeAccess = false;
            return false;
        }
    }


}
