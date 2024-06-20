package jpa.jpql.entity;

import javax.persistence.*;

@Entity // @Entity: JPA가 관리할 객체
public class Member {
	@Id // @Id: 데이터베이스의 PK와 매핑
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 생성하는데 기준은 DB
	@Column(name = "MEMBER_ID") // DB에 매핑할 컬럼명
	private Long id;
	
	private String username;
	private int age;
	
	@ManyToOne(fetch = FetchType.LAZY) // "이건 FK다", LAZY로 지연 로딩
	@JoinColumn(name = "TEAM_ID") // 연관 관계일 경우 DB의 테이블과 연결할 컬럼명
	private Team team; // 자바스럽게 객체 자체를 담는 필드 선언
	
	public void changeTeam(Team team) {
		this.team = team;
		team.getMembers().add(this); // 양방향일 때는 Memeber와 Team에도 추가해줘야 함
	}
	
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", age=" + age + "]";
	}
	
	
}
