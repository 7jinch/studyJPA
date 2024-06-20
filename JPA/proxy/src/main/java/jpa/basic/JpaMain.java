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
    		Team t = new Team();
    		t.setName("톳데 자이언츠");
    		
    		em.persist(t);
    		
    		Member m = new Member();
    		m.setUserName("오타니 쇼헤이");
    		m.setTeam(t);
    		
    		em.persist(m);
    		
    		em.flush(); // 직접 flush 호출 -> 영속성 컨텍스트에 있는 쿼리를 날리고
    		em.clear(); // 영속성 컨텍스트 클리어
    		
    		List<Member> rL = em.createQuery("select m from Member m", Member.class).getResultList();
    		
//    		Member findMember = em.find(Member.class, m.getId());
//    		System.out.println(findMember.getTeam().getClass()); // HibernateProxy
//    		System.out.println(findMember.getTeam().getName()); // 롯데 자이언츠
    		
    		// find 메서드 사용하기
//    		Member findMember = em.find(Member.class, m.getId());
//    		System.out.println(findMember.getName());
    		// find 대신 getReference 메서드 사용하기
//    		Member findMember = em.getReference(Member.class, m.getId());
//    		System.out.println(findMember.getId()); // 쿼리 안 날림 <- getReference를 호출하면서 매개변수로 id를 줬기 떄문에 그걸 저장해놨다가 반환
//    		System.out.println(findMember.getName()); // 이때는 쿼리 날림
//    		System.out.println(findMember.getClass()); // 하이버네이트가 만들어 준 가짜 클래스: HibernateProxy
    		
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