public class EducationalInstitute {
    public int srNo;
    public String instituteName, city, state, act, ministry;

    public EducationalInstitute(int srNo, String instituteName, String city, String state, String act, String ministry) {
        this.srNo = srNo;
        this.instituteName = instituteName;
        this.city = city;
        this.state = state;
        this.act = act;
        this.ministry = ministry;
    }

    @Override
    public String toString() {
        return "Sr.No.: \t\t" + srNo + "\n" +
                "Name of the Institute: \t" + instituteName + ".\n" +
                "City: \t\t\t" + city + ".\n" +
                "State: \t\t\t" + state + ".\n" +
                "Act: \t\t\t" + act + ".\n" +
                "Ministry: \t\t" + ministry + ".\n\n";
    }

    // Getters for search functionalities
    public String getInstituteName() {
        return instituteName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getAct() {
        return act;
    }

    public String getMinistry() {
        return ministry;
    }
}
