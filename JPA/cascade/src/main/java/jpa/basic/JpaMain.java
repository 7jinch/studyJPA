// src/main/java/jpa.basic/JpaMain.java
package jpa.basic;

import java.util.*;
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
    		Child child1 = new Child();
    		Child child2 = new Child();
    		
    		Parent parent = new Parent();
    		parent.addChild(child1);
    		parent.addChild(child2);
    		
    		em.persist(parent);
    		// ManyToOne인 연관 관계에서 One인 필드에 cascade 속성으로 값을 주면 됨
    		// 번거롭게 아래 코드를 작성해 줄 필요 없어짐
//    		em.persist(child1);
//    		em.persist(child2);
    		
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
