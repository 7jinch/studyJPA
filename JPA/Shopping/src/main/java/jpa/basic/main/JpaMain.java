// src/main/java/jpa.basic/JpaMain.java
package jpa.basic.main;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpa.basic.entity.Address;
import jpa.basic.entity.Album;
import jpa.basic.entity.Book;
import jpa.basic.entity.Member;
import jpa.basic.entity.Movie;

public class JpaMain {
    public static void main( String[] args ) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_mysql");
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction tx = em.getTransaction();
    	tx.begin();
    	
    	try {
    		Album a = new Album();
    		a.setArtist("프로토스");
    		a.setName("3관마 오타니");
    		em.persist(a);
    		
    		Book b = new Book();
    		b.setAuthor("이대호");
    		b.setIsbn("2:5");
    		em.persist(b);
    		
    		Movie m = new Movie();
    		m.setActor("김타니");
    		m.setDirector("뉴진스");
    		em.persist(m);
    		
    		Address address = new Address();
    		address.setCity("달나라");
    		address.setStreet("고요의 바다");
    		address.setZipcode("123456789");
    		
    		Member member = new Member();
    		member.setAddress(address);
    		
    		em.persist(member);
    		
    		
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
