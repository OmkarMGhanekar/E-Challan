package com.halo.splashloginmotionlayout;

public class AddVehicle {
    String email, fine, name,contact_no,vehicle_no;
    public AddVehicle(String email, String fine, String name, String contact_no, String vehicle_no) {
        this.email = email;
        this.contact_no=contact_no;
        this.fine = fine;
        this.name = name;
        this.vehicle_no=vehicle_no;
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
