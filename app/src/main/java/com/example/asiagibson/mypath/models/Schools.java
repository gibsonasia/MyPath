package com.example.asiagibson.mypath.models;

/**
 * Created by Nesada Koca on 2/18/2017.
 */

public class Schools {

    private String program_site_name;

    private String contact_number;

    private String address;

    private String borough;


    public String getProgram_site_name() {
        return program_site_name;
    }

    public void setProgram_site_name(String program_site_name) {
        this.program_site_name = program_site_name;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }


    @Override
    public String toString() {
        return "ClassPojo [program_site_name = " + program_site_name + ", contact_number = " + contact_number + ", address = " + address + ", borough = " + borough + "]";
    }
}
