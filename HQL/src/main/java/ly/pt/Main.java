package ly.pt;

import ly.pt.config.FactoryConfiguration;
import ly.pt.entity.Address;
import ly.pt.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        /*Address address = new Address();
        address.setAddressId(1);
        address.setHousingNumber("47/a1");
        address.setStreet("Mastiya");

        Address address2 = new Address();
        address2.setAddressId(2);
        address2.setHousingNumber("47");
        address2.setStreet("wadduwa");

        Student student = new Student();
        student.setStudentId(1);
        student.setName("Gihan");

        List<Address> addresses = new ArrayList<>();
        addresses.add(address);
        addresses.add(address2);

        student.setAddresses(addresses);

        address.setStudent(student);
        address2.setStudent(student);

        session.persist(address);
        session.persist(address2);
        session.persist(student);*/

        /*String hql = "Delete from Address Where addressId = :addressId";
        session.createQuery(hql)
                        .setParameter("addressId",1)
                        .executeUpdate();*/

        /*String hql = "Update Address set street = :street where addressId = :addressId";
        session.createQuery(hql)
                        .setParameter("addressId",2)
                        .setParameter("street", "Wadduwa")
                        .executeUpdate();*/

        /*Query query = session.createQuery("select studentId,name from Student where studentId= ?1");
        query.setParameter(1,"1");

        List<Object[]> studentList = query.list();

        for (Object[] student : studentList) {
            System.out.println("Student ID: " + student[0] + ", Name: " + student[1]);
        }*/

        /*Query query = session.createQuery("SELECT studentId,name FROM Student");
        List<Object[]> studentList = query.list();

        for (Object[] student : studentList) {
            System.out.println("Student ID: " + student[0] + ", Name: " + student[1]);
        }*/

        //Query query=session.createQuery("select a.aid,a.name from Address a inner join Customer c on a.aid = c.cid");

        /*Query query = session.createQuery("SELECT S.studentId, S.name FROM Student S inner join Address A on S.studentId = A.Id");
        List<Object[]> studentList = query.getResultList();*/

        String hql = "SELECT S.studentId, S.name FROM Student S inner join Address A on S.studentId = A.Id";
        List<Object[]> studentList = session.createNativeQuery(hql).getResultList();

        System.out.println(studentList);

        for (Object[] student : studentList) {
            System.out.println("Student ID: " + student[0] + ", Name: " + student[1]);
        }

        transaction.commit();
        session.close();
        
    }
}