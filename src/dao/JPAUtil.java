package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtil {
public static EntityManagerFactory factory;
//to disallow creating objects by other classes.

    private JPAUtil() {
    }
//maling the Hibernate SessionFactory object as singleton

    public static synchronized EntityManagerFactory getEntityManagerFactory() {

        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("GestionParascolaire");
        }
        return factory;
    }
}
