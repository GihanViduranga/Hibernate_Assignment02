package ly.pt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Address {
    @Id
    private int addressId;
    private String housingNumber;
    private String street;
    @ManyToOne
    @JoinColumn(name = "Id")
    private Student student;

    public Address() {
    }

    public Address(int addressId, String housingNumber, String street, Student student) {
        this.addressId = addressId;
        this.housingNumber = housingNumber;
        this.street = street;
        this.student = student;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getHousingNumber() {
        return housingNumber;
    }

    public void setHousingNumber(String housingNumber) {
        this.housingNumber = housingNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", housingNumber='" + housingNumber + '\'' +
                ", street='" + street + '\'' +
                ", student=" + student +
                '}';
    }
}
