package com.halo.splashloginmotionlayout;

public class Amount {
    String vehiclenumber, policename, fine;

    public Amount(String vehiclenumber, String policename, String fine) {
        this.vehiclenumber = vehiclenumber;
        this.policename = policename;
        this.fine = fine;
    }

    public String getVehiclenumber() {
        return vehiclenumber;
    }

    public String getPolicename() {
        return policename;
    }

    public String getFine() {
        return fine;
    }
}
