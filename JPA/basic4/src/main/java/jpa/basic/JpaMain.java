// src/main/java/jpa.basic/JpaMain.java
package jpa.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main( String[] args ) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_mysql");
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction tx = em.getTransaction();
    	tx.begin();
    	
    	try {
    		Player player = new Player();
    		player.setName("이대호");
    		player.setPosition("공격수");
    		
    		Manager manager = new Manager();
    		manager.setName("오타니");
    		manager.setYear(1000);
    		
    		em.persist(player);
    		em.persist(manager);
    		
        	tx.commit();
    	} catch (Exception e) {
    		e.printStackTrace();
    		tx.rollback();
    	} finally {
    		em.close();
    	}
    	emf.close();
    }
}
