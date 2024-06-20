package jpa.basic;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
public class Member {
	@Id
	@GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Embedded
	private Period period;
	@Embedded
	private Address address;
	
	public Member() {}
	
	public Member(Long id, String userName) {
		this.id = id;
		this.userName = userName;
	}
	
	public Period getPeriod() {
		return period;
	}
	public void setPeriod(Period period) {
		this.period = period;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
