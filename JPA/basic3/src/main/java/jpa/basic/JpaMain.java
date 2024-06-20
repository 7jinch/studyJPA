// src/main/java/jpa.basic/JpaMain.java
package jpa.basic;

import java.util.ArrayList;
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
    		Team team1 = new Team();
    		team1.setName("팀 시리우스");
    		em.persist(team1);
    		
    		Team team2 = new Team();
    		team2.setName("팀 ");
    		em.persist(team2);
    		
    		Member member1 = new Member();
    		member1.setUserName("스페셜 위크");
    		member1.setTeam(team1); // 객체지향적인 코드
    		// member.setTeamId(team.getId()); // 데이터베이스 중심 코드
    		em.persist(member1);
    		
    		Member member2 = new Member();
    		member2.setUserName("사일런스 스즈카");
    		member2.setTeam(team1);
    		em.persist(member2);
    		
    		member2.setTeam(team2);
    		
//    		Team findTem = em.find(Team.class, team1.getId());
//    		List<Member> members = findTem.getMembers();
//    		for(Member m : members) System.out.println(m.getUserName());
    		
    		// 1차 캐시에서 찾지 말고 그냥 db에 쿼리 날리라고 써 줌
//    		em.flush();
//    		em.clear();
    		
    		// 멤버 찾기
    		Member findMember = em.find(Member.class, member1.getId());
    		
    		// 데이터베이스 중심 코드
//    		findMember.getTeam().getName(); // 객체지향적인 코드
//    		Long findTeamId = findMember.getTeamId(); // 데이터베이스 중심 코드
//    		Team findTeam = em.find(Team.class, findTeamId);
//    		System.out.println(findTeam.getName());
    		
    		// 객체지향적인 코드
//    		System.out.println(findMember.getTeam().getName() + " : " + findMember.getUserName());
    		
    		// 칮은 팀에 속한 멤버들을 조회하기
//    		Team team2 = findMember.getTeam();
//    		List<Member> members = team2.getMembers();
    		List<Member> members = findMember.getTeam().getMembers();
    		System.out.println("++++++++++++++++++++++++++++++++++++++");
    		System.out.println(findMember.getTeam());
    		System.out.println(team2.getMembers());
//    		for(Member m : members) {
//    			System.out.println(m.getUserName());
//    		}
    		
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
