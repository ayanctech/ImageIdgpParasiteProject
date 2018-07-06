package com.actech.protozoan_parasite;

/**
 * Created by ACTECH on 6/26/2018.
 */

public class TProperties {

    private String gname,doses,bname,characteristics;

    public TProperties(String gname, String doses, String bname, String characteristics) {
        this.gname = gname;
        this.doses = doses;
        this.bname = bname;
        this.characteristics = characteristics;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getDoses() {
        return doses;
    }

    public void setDoses(String doses) {
        this.doses = doses;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }
}
