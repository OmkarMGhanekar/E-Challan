package com.halo.splashloginmotionlayout;

public class MyListData {
    private String Offence, Section, fine;

    public MyListData(String offence, String section, String fine) {
        this.Offence = offence;
        this.Section = section;
        this.fine = fine;
    }

    public String getOffence() {
        return Offence;
    }

    public void setOffence(String offence) {
        Offence = offence;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }
}
