package ly.pt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Set;

@Entity
public class Student {
    @Id
    private int studentId;
    private String name;
    @OneToMany (mappedBy = "student")
    private List<Address> addresses;

    public Student() {
    }

    public Student(int studentId, String name, List<Address> addresses) {
        this.studentId = studentId;
        this.name = name;
        this.addresses = addresses;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }


}
