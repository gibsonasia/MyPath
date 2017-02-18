package com.example.asiagibson.mypath.model;

/**
 * Created by asiagibson on 2/18/17.
 */

public class EsllData {
    private String location_1_location;

    private String contact_number;

    private String program_type;

    private String location_1_city;

    private String location_1_state;

    private String borough_community;

    private String program;

    private String agency;

    private String location_1_zip;

    private String grade_level_age_group;

    private String site_name;

    public String getBorough_community() {
        return borough_community;
    }

    public void setBorough_community(String borough_community) {
        this.borough_community = borough_community;
    }

    public String getSite_name() {
        return site_name;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }

    public String getLocation_1_zip() {
        return location_1_zip;
    }

    public void setLocation_1_zip(String location_1_zip) {
        this.location_1_zip = location_1_zip;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getGrade_level_age_group() {
        return grade_level_age_group;
    }

    public void setGrade_level_age_group(String grade_level_age_group) {
        this.grade_level_age_group = grade_level_age_group;
    }

    public EsllDataLocator getEsllDataLocator() {

        return esllDataLocator;
    }

    public void setEsllDataLocator(EsllDataLocator esllDataLocator) {
        this.esllDataLocator = esllDataLocator;
    }

    public void setLocation_1_location(String location_1_location) {
        this.location_1_location = location_1_location;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getProgram_type() {
        return program_type;
    }

    public void setProgram_type(String program_type) {
        this.program_type = program_type;
    }

    public String getLocation_1_city() {
        return location_1_city;
    }

    public void setLocation_1_city(String location_1_city) {
        this.location_1_city = location_1_city;
    }

    public String getLocation_1_state() {
        return location_1_state;
    }

    public void setLocation_1_state(String location_1_state) {
        this.location_1_state = location_1_state;
    }

    private EsllDataLocator esllDataLocator;

    public String getLocation_1_location ()
    {
        return location_1_location;
    }
}
