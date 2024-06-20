package jpa.basic.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Member {
	// PK
	@Id
	@GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;
	
	private String name;
	
	@Embedded
	private Address address;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	// @OneToMany의 fetchType의 기본값은 LAZY
	// Orders도 함께 영속 상태롤 만들기
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Order> Orders = new ArrayList<>();
	
	public List<Order> getOrders() {
		return Orders;
	}
	public void setOrders(List<Order> orders) {
		Orders = orders;
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
