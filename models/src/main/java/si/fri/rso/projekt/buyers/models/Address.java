package si.fri.rso.projekt.buyers.models;

public class Address {

    private String country;
    private String city;
    private String street;
    private int streetNo;


    Address(String country, String city, String street, int streetNo) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.streetNo = streetNo;
    }

    public Address() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(int streetNo) {
        this.streetNo = streetNo;
    }
}
