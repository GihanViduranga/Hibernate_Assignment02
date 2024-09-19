package ly.pt;


import ly.pt.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        /*String jpql = "INSERT INTO Student (studentId, name) values (:studentId, :name)";
        session.createNativeQuery(jpql)
                .setParameter("studentId", 2)
                .setParameter("name", "Ishani")
                .executeUpdate();*/

        /*String hql = "UPDATE Student set name = :name where studentId = :studentId";
        session.createQuery(hql)
               .setParameter("name", "Viduranga")
               .setParameter("studentId", 1)
               .executeUpdate();*/

        /*String hql = "DELETE FROM Student WHERE studentId = :studentId";
        session.createQuery(hql)
               .setParameter("studentId", 2)
               .executeUpdate();*/

        /*String hql = "SELECT studentId, name FROM Student WHERE studentId = :studentId";
        Query query = session.createQuery(hql);
        query.setParameter("studentId", 1);
        List<Object[]> studentList = query.list();
        for (Object[] student : studentList) {
            System.out.println("Student ID: " + student[0] + ", Name: " + student[1]);
        }*/

        String sql = "SELECT S.studentId , S.name, A.addressId FROM Student S INNER JOIN Address A ON S.studentId = A.Id";
        List<Object[]> resultList = session.createNativeQuery(sql).getResultList();
        for(Object[] student : resultList){
            System.out.println("Student ID: " + student[0] + ", Name: " + student[1] + ", Address ID: " + student[2]);
        }

        transaction.commit();
        session.close();

    }
}