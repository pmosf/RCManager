package com.rcmanager.other;

public class Battery {

    public static final String tableName = "Battery";

    // Labels Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_brand = "brand";

    // property help us to keep data
    private int ID;
    private String brand;
    private String techno;
    private double capacity;
    private double voltage;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTechno() {
        return techno;
    }

    public void setTechno(String techno) {
        this.techno = techno;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }
}
