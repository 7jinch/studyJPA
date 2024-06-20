package jpa.basic;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import javax.persistence.Column;

@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="USER_NAME", columnDefinition="varchar(100) default 'EMPTY'")
	private String username;
	
	private Integer age;
	
	// Enum 활용: USER 또는 ADMIN으로만 들어감
	@Enumerated(EnumType.STRING)
	private RoleType roleType;
	
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date createDate;
//	
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date lastModifiedDate;
	private LocalDateTime createDate;
	
	private LocalDateTime lastModifiedDate;
	
	@Lob
	private String description;
	
	public Member() {
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
