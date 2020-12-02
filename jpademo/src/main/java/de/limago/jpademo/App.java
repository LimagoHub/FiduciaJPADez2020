package de.limago.jpademo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import de.limago.jpademo.models.Bar;
import de.limago.jpademo.models.Barkeeper;
import de.limago.jpademo.models.Tier;
import de.limago.jpademo.models.TinyBar;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fiducia");
    	
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

    	
    	TypedQuery<Barkeeper> query = em.createQuery("SELECT bk FROM Barkeeper bk inner join fetch bk.bar", Barkeeper.class);
    	
//    	query.setMaxResults(20);
//    	query.setFirstResult(20);
    	
    	//query.setParameter("name", "B%");
//    	
    	List<Barkeeper> bars = query.getResultList();
    	bars.forEach(System.out::println);
    
    	em.close();
    	
    	em = entityManagerFactory.createEntityManager();
    	transaction = em.getTransaction();
    	transaction.begin();

    	
    	query = em.createQuery("SELECT bk FROM Barkeeper bk inner join fetch bk.bar", Barkeeper.class);
    	
//    	query.setMaxResults(20);
//    	query.setFirstResult(20);
    	
    	//query.setParameter("name", "B%");
//   
    
    	em.close();
    	
    }
}
