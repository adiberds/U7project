import java.util.ArrayList;
import java.util.List;

public class Address {
    private int num;
    private String street;
    private String apt;
    private String city;
    private String state;
    private int zip;

    public Address(int num, String street, String apt, String city, String state, int zip) {
        this.num = num;
        this.street = street;
        this.apt = apt;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Address(int num, String street, String city, String state, int zip) {
        this.num = num;
        this.street = street;
        apt = "-1";
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Address(Address address) {
        this.num = address.getNum();
        this.street = address.getStreet();
        this.apt = address.getApt();
        this.city = address.getCity();
        this.state = address.getState();
        this.zip = address.getZip();
    }

    public Address(String address) {
        String[] parts = address.split(", ");

        String[] addressParts = parts[0].split(" ");
        this.num = Integer.parseInt(addressParts[0]);
        this.street = addressParts[1];
        if (addressParts.length > 2 && addressParts[2].equalsIgnoreCase("Apt")) {
            this.apt = addressParts[3];
        } else {
            this.apt = "-1";
        }
        this.city = parts[1];
        String[] stateZip = parts[2].split(" ");
        this.state = stateZip[0];
        this.zip = Integer.parseInt(stateZip[1]);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApt() {
        return apt;
    }

    public void setApt(String apt) {
        this.apt = apt;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String toString() {
        if (!apt.equals("-1")) {
            return num + " " + street + " Apt " + apt + ", " + city + ", " + state + " " + zip;
        }
        return num + " " + street + ", " + city + ", " + state + " " + zip;
    }
}