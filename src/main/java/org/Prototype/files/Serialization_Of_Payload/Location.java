package org.Prototype.files.Serialization_Of_Payload;

public class Location {
    private double lat;
    private double lng;

    public Location() {
        // Default constructor
    }
    public Location(double v, double v1) {
    this.lat  = v;
        this.lng = v1;
    }


    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
