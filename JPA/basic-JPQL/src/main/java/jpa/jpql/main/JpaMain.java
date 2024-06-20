package jpa.jpql.main;

import javax.persistence.*;

import java.util.*;
import jpa.jpql.entity.Member;
import jpa.jpql.entity.Team;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_mysql"); // EntityManagerFactory 생성(persistence.xml의 유닛 구분 이름을 넣어줌)
		EntityManager em = emf.createEntityManager(); // EntityManager 하나 생성
		EntityTransaction tx = em.getTransaction(); // 트랜잭션 받아오기
		tx.begin(); // 트랜잭션 시작
		
		try {
			Team team = new Team();
			team.setName("롯데 자이언츠");
			em.persist(team);
			
			for(int i = 0; i < 100; i++) {
				Member member = new Member();
				member.setUsername("오타니 " + (i + 1) + "호기");
				member.setAge(i + 1);
//				member.changeTeam(team);
				em.persist(member);
			}
			
			em.flush();
			em.clear();
			
//			List<Member> resuList = em.createQuery("select m from Member m inner join m.team t", Member.class)
//										.getResultList();
			List<Member> resuList = em.createQuery("select m from Member m left outer join m.team t", Member.class)
										.getResultList();
			for(Member m : resuList) {
				System.out.println(m.getUsername());
			}
			
//			List<Member> resutlList = em.createQuery("select m from Member m order by m.age desc", Member.class)
//									.setFirstResult(0) // 처음부터
//									.setMaxResults(10) // 10개만
//									.getResultList(); // 가져와라
//			for(Member m : resutlList) {
//				System.out.println(m.getUsername());
//			}
			
//			List<Member> memberList = em.createQuery("select m from Member m", Member.class).getResultList();

//			TypedQuery<Member> query = em.createQuery("select m from Member m where m.username = :username", Member.class);
//			query.setParameter("username", "오타니");
//			List<Member> members = query.getResultList();
//			for(Member m : members) {
//				System.out.println(m.getUsername());
//			}
			
			// 체이닝
//			Member findMember = em.createQuery("select m from Member m where m.username = :username", Member.class)
//									.setParameter("username", "오타니")
//									.getSingleResult();
//			
//			System.out.println(findMember.getUsername());
			
			
			tx.commit(); // 성공적으로 처리되면 트랜잭션 커밋
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); // 에러나면 rollback
		} finally {
			em.close(); // EntityManager 닫기
		}
		
		emf.close(); // EntityManagerFactory 닫기
	}
}
