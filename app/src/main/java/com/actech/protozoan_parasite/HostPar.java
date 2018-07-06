package com.actech.protozoan_parasite;

/**
 * Created by ACTECH on 6/27/2018.
 */

public class HostPar {
    String animal,organ,type,parname;

    public HostPar(String animal, String organ, String type, String parname) {
        this.animal = animal;
        this.organ = organ;
        this.type = type;
        this.parname = parname;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParname() {
        return parname;
    }

    public void setParname(String parname) {
        this.parname = parname;
    }

}
