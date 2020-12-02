package de.limago.jpademo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import de.limago.jpademo.models.Customer;
import de.limago.jpademo.models.Customer_;
import de.limago.jpademo.models.Product;
import de.limago.jpademo.models.Product_;
import de.limago.jpademo.models.Supplier;
import de.limago.jpademo.models.Supplier_;

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

//    	CriteriaBuilder cb = em.getCriteriaBuilder();
//    	CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
//    	Root<Customer> customerRoot = cq.from(Customer.class);
//    	cq.select(customerRoot);
//    	Predicate p1 = cb.like(customerRoot.get(Customer_.COUNTRY), "U%");
//    	Predicate p2 = cb.like(customerRoot.get(Customer_.COMPANY_NAME), "w%");
// //   	Predicate p3= cb.and(p1,p2);
//    	
//    	Predicate p3 = cb.conjunction();
//    	p3 = cb.or(p3,p1);
//    	p3 = cb.or(p3,p2);
//    	
//    	//cq.where(p3);
//    	cq.where(customerRoot.get(Customer_.CITY).in("London","Paris","Berlin"));
//    	
//    	TypedQuery<Customer> query = em.createQuery(cq);
//    	List<Customer> customers = query.getResultList();
//    	
//    	customers.forEach(System.out::println);
    	
//    	CriteriaBuilder cb = em.getCriteriaBuilder();
//    	CriteriaQuery<Product> cq = cb.createQuery(Product.class);
//    	Root<Product> productRoot = cq.from(Product.class);
//    	cq.select(productRoot);
//    	
//    	
//    	//cq.where(p3);
//    	cq.where(cb.greaterThanOrEqualTo(productRoot.get(Product_.unitPrice),new BigDecimal(100)));
//    	
//    	TypedQuery<Product> query = em.createQuery(cq);
//    	List<Product> products = query.getResultList();
//    	
//    	products.forEach(System.out::println);
    	
    	
//     	CriteriaBuilder cb = em.getCriteriaBuilder();
//     	// Legt ergenistyp fest
//    	CriteriaQuery<TinyCustomer> cq = cb.createQuery(TinyCustomer.class);
//    	// repräsentiert die Ausgangstabelle
//    	Root<Customer> customerRoot = cq.from(Customer.class);
//    	cq.multiselect(
//    			customerRoot.get(Customer_.customerID),
//    			customerRoot.get(Customer_.companyName),
//    			customerRoot.get(Customer_.city),
//    			//customerRoot.get(Customer_.phone)
//    			cb.literal("Hallo")
//    			);
//    
//      	TypedQuery<TinyCustomer> query = em.createQuery(cq);
//    	List<TinyCustomer> customers = query.getResultList();
//    	
//    	customers.forEach(System.out::println);
 
//    	CriteriaBuilder cb = em.getCriteriaBuilder();
//    	
//    	ParameterExpression<String> cityParameter = cb.parameter(String.class);
//    	
//    	CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
//    	Root<Customer> customerRoot = cq.from(Customer.class);
//    	cq.select(customerRoot);
//    	Predicate p1 = cb.like(customerRoot.get(Customer_.COUNTRY), "U%");
//    	Predicate p2 = cb.like(customerRoot.get(Customer_.COMPANY_NAME), "w%");
// //   	Predicate p3= cb.and(p1,p2);
//    	
//    	Predicate p3 = cb.conjunction();
//    	p3 = cb.or(p3,p1);
//    	p3 = cb.or(p3,p2);
//    	
//    	//cq.where(p3);
//    	cq.where(cb.equal(customerRoot.get(Customer_.city), cityParameter));
//    	
//    	TypedQuery<Customer> query = em.createQuery(cq);
//    	query.setParameter(cityParameter, "Berlin");
//    	List<Customer> customers = query.getResultList();
//    	
//    	customers.forEach(System.out::println);

//    	CriteriaBuilder cb = em.getCriteriaBuilder();
//    	
//    	
//    	CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
//    	Root<Customer> customerRoot = cq.from(Customer.class);
//    	Join<Customer, Order> orderRoot = customerRoot.join(Customer_.orders);
//    	
//    	cq.select(customerRoot);
//    	//cq.where(cb.equal(orderRoot.get(Order_.SHIP_NAME), "Berlin"));
//    	cq.where(cb.equal(customerRoot.get(Customer_.city), "Berlin"));
//    	TypedQuery<Customer> query = em.createQuery(cq);
//    	
//    	List<Customer> customers = query.getResultList();
//    	
//    	customers.forEach(System.out::println);
//
    	
//    	CriteriaBuilder cb = em.getCriteriaBuilder();
//    	
//    	
//    	CriteriaQuery<Object []> cq = cb.createQuery(Object[].class);
//    	Root<Customer> customerRoot = cq.from(Customer.class);
//    	Join<Customer, Order> orderRoot = customerRoot.join(Customer_.orders, JoinType.LEFT);
//    	Join<Order, Order_detail> orderDetailRoot = orderRoot.join(Order_.orderDetails, JoinType.LEFT);
//    	
//    	cq.multiselect(customerRoot.get(Customer_.COMPANY_NAME), cb.sum(cb.prod(orderDetailRoot.get(Order_detail_.quantity), orderDetailRoot.get(Order_detail_.unitPrice))));
//    	//cq.where(cb.equal(orderRoot.get(Order_.SHIP_NAME), "Berlin"));
//    	//cq.where(cb.equal(customerRoot.get(Customer_.city), "Berlin"));
//    	cq.groupBy(customerRoot.get(Customer_.COMPANY_NAME));
//    	cq.orderBy(cb.asc(cb.sum(cb.prod(orderDetailRoot.get(Order_detail_.quantity), orderDetailRoot.get(Order_detail_.unitPrice)))));
//    	
//    	TypedQuery<Object []> query = em.createQuery(cq);
//    	
//    	List<Object []> customers = query.getResultList();
//    	
//    	for (Object[] objects : customers) {
//			
//			System.out.println(String.format("Firma = %-40s Umsatz = %7.2f", objects[0],objects[1]));
//		}
//
//
    	
//    	CriteriaBuilder cb = em.getCriteriaBuilder();
//    	CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
//    	Root<Customer> customerRoot = cq.from(Customer.class);
//    	
//    	Subquery<String> citySubquery = cq.subquery(String.class);
//    	Root<Supplier> supplierRoot = citySubquery.from(Supplier.class);
//    	citySubquery.select(supplierRoot.get(Supplier_.city));
//    	
//    	
//    	cq.select(customerRoot);
//    	cq.where(customerRoot.get(Customer_.CITY).in(citySubquery));
//    	
//    	TypedQuery<Customer> query = em.createQuery(cq);
//    	List<Customer> customers = query.getResultList();
//    	
//    	customers.forEach(System.out::println);
//    	/*
//    	 * 
//    	 * select productname from products where UnitPrice >= (select avg(unitprice) from products)
//;
//
//    	 */

//    	CriteriaBuilder cb = em.getCriteriaBuilder();
//    	CriteriaQuery<Product> cq = cb.createQuery(Product.class);
//    	Root<Product> proRoot = cq.from(Product.class);
//    	
//    	Subquery<Double> productSubquery = cq.subquery(Double.class);
//    	Root<Product> productSubqueryRoot = productSubquery.from(Product.class);
//    	productSubquery.select(cb.avg(productSubqueryRoot.get(Product_.unitPrice)));
//    	
//    	
//    	cq.select(proRoot);
//    	cq.where(cb.gt(proRoot.get(Product_.unitPrice), productSubquery));
//    	
//    	TypedQuery<Product> query = em.createQuery(cq);
//    	List<Product> products = query.getResultList();
//  	
//    	products.forEach(System.out::println);
    	
    	
    	Product p = em.find(Product.class, 1);
    	System.out.println(p);
    	
    	transaction.commit();
    	em.close();
    	
    }
}
