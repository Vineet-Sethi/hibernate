package com.learning.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Alien alien = new Alien();
        alien.setAid(101);
        alien.setaName("UnknownSpecies");
        alien.setColor("Green");
        
        /*
            What if we could persist this directly with a method like save(alien).
            Download dependencies for this - hibernate & mySQL from the official maven repo.
         */
        
        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        session.save(alien);
        
        /*
            The above 4 lines do not work as we have not provided which RDBMS to connect to and which DB to connect to in the
            chosen RDBMS. Also we might need to provide the username and password for that DB.  
         */
    }
}
