package si.fri.rso.projekt.buyers.models;


import java.util.Date;

public class Buyer {

    private int buyerId;
    private String firstName;
    private String lastName;
    private Address address;

    Buyer(int id, String first, String last, Address address) {
        this.buyerId = id;
        this.firstName = first;
        this.lastName = last;
        this.address = address;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
