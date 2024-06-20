package jpa.jpql.entity;

import java.util.*;

import javax.persistence.*;

@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	@OneToMany(mappedBy = "team") // FK가 아닌 필드에는 mappedBy 속성값으로 FK를 가진 필드명(변수명) 주기
	private List<Member> members = new ArrayList<>();

	public List<Member> getMembers() {
		return members;
	}
	public void setMembers(List<Member> members) {
		this.members = members;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
