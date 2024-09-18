package ly.pt;

import ly.pt.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        /*Student student = new Student();
        student.setStudentId(1);
        student.setName("Gihan");

        Address address1 = new Address(1, "131", "beachRoad", "Moratuwa",student);
        Address address2 = new Address(2, "333", "IJSERoad", "panadura",student);

        Set<Address> AddressSet= new HashSet<Address>();
        AddressSet.add(address1);
        AddressSet.add(address2);
        student.setAddress(AddressSet);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        session.save(address1);
        session.save(address2);

        transaction.commit();
        session.close();*/

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        /*String sql = "INSERT INTO Student (studentId, name) VALUES (:studentId, :name)";

        session.createNativeQuery(sql)
                .setParameter("studentId", 1)
                .setParameter("name","Gihan" )
                .executeUpdate();

        String sql2 = "INSERT INTO Address (addressId, housingNumber, street, student_studentId) VALUES (:addressId, :housingNumber, :street, :student_studentId)";
        session.createNativeQuery(sql2)
                .setParameter("addressId", 3)
                .setParameter("housingNumber", "333")
                .setParameter("street", "IJSERoad")
                .setParameter("student_studentId", 1)
                .executeUpdate();*/


        /*String sql = "Update Student set name = :name where studentId = :studentId";
        session.createNativeQuery(sql)
                        .setParameter("name","Ishani")
                        .setParameter("studentId",1)
                        .executeUpdate();*/

        /*String sql = "Delete Student from student Where studentId = :studentId";
        session.createNativeQuery(sql)
                        .setParameter("studentId",2)
                        .executeUpdate();*/

        /*String sql = "Select * from Student where name = 'ishani'";
        List<Object[]> students = session.createNativeQuery(sql).getResultList();
        for(Object[] student : students){
            System.out.println("Student ID: " + student[0] + ", Name: " + student[1]);
        }*/

        String sql = "SELECT S.studentId , S.name, A.addressId FROM Student S INNER JOIN Address A ON S.studentId = A.student_studentId";

        List<Object[]> resultList = session.createNativeQuery(sql).getResultList();

        for(Object[] student : resultList){
            System.out.println("Student ID: " + student[0] + ", Name: " + student[1] + ", Address ID: " + student[2]);
        }

        transaction.commit();
        session.close();
    }
}