package de.limago.jpademo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("northwind");
    	
    	Runtime.getRuntime().addShutdownHook(new Thread() 
        { 
          public void run() 
          { 
            System.out.println("Shutdown Hook is running !"); 
            entityManagerFactory.close();
          } 
        }); 
    	
    	
    	EntityManager em = entityManagerFactory.createEntityManager();
    	EntityTransaction transaction = em.getTransaction();
    	transaction.begin();

    	
    	
    
    	em.close();
    	
    }
}
