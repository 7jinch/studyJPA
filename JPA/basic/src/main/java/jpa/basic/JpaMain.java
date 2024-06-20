// src/main/java/jpa.basic/JpaMain.java
package jpa.basic;

import java.util.List;

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
//    		Member m1 = new Member(300L, "박타니");
//    		Member m2 = new Member(301L, "최타니");
//    		Member m3 = new Member(302L, "정타니");
//    		em.persist(m1);
//    		em.persist(m2);
//    		em.persist(m3);
//    		
//    		List<Member> ml = em.createQuery("select m from Member as m", Member.class)
//    		.getResultList();
//    		
//    		for(Member m : ml) {
//    			System.out.println(m.getId() + ": " + m.getName());
//    		}
//    		
    		// 커밋
        	tx.commit();
    	} catch (Exception e) {
    		tx.rollback();
    	} finally {
    		em.close();
    	}
    	
    	// close
    	emf.close();
    }
}
