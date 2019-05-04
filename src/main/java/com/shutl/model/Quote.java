package com.shutl.model;

public class Quote {

    private String pickupPostcode;
    private String deliveryPostcode;
    private Long price;
    private String vehicle;

    public Quote() {
    }


    public Quote(String pickupPostcode, String deliveryPostcode, String vehicle) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
        this.vehicle = vehicle;
    }


    public Quote(String pickupPostcode, String deliveryPostcode, String vehicle, Long price) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
        this.price = price;
        this.vehicle = vehicle;
    }

    public Long calc_delivery_cost() {
        Double markup;
        switch (vehicle) {
            case "bicycle":
                markup = 1.1;
                break;
            case "motorbike":
                markup = 1.15;
                break;
            case "parcel_car":
                markup = 1.20;
                break;
            case "small_van":
                markup = 1.30;
                break;
            case "large_van":
                markup = 1.40;
                break;
            default:
                markup = 1.0;
        }

        String s1 = deliveryPostcode.replaceAll("\\s", "");
        String s2 = pickupPostcode.replaceAll("\\s", "");
        price = Math.abs((Long.valueOf(s1, 36) - Long.valueOf(s2, 36)) / 100000000);

        /*
         *  delivery fee between identical postcodes would always be 0
         *  and since we shouldn't use geolocation I've simply added a minimum fee of 1
         */

        return price < 1 ? (Math.round(1 * markup)) : (Math.round(price * markup));
    }

    public String getPickupPostcode() {
        return pickupPostcode;
    }

    public void setPickupPostcode(String pickupPostcode) {
        this.pickupPostcode = pickupPostcode;
    }

    public String getDeliveryPostcode() {
        return deliveryPostcode;
    }

    public void setDeliveryPostcode(String deliveryPostcode) {
        this.deliveryPostcode = deliveryPostcode;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
}
