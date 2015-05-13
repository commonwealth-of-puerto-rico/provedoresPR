package com.techsummit.provedorespr.model;

import java.util.List;

/**
 * Created by Magnar on 5/13/2015.
 */

public class Provider {

    public List<Provider> providersList;


    public String name;

    public String specialty;

    public String superSpeciality;

    public String county;

    public String phone;

    public String address;

    public String[] coords;

    public String state;
    public String lon;
    public String lat;

    public String getLat() {
        return coords[1];
    }

    public String getLong() {
        return coords[2];
    }
}
