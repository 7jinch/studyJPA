package jpa.basic;

import java.time.LocalDateTime;
import java.util.*;

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
	private Address address;
	
	@ElementCollection
	@CollectionTable(name = "FAVORITE_FOOD", joinColumns = @JoinColumn(name = "MEMBER_ID"))
	@Column(name = "FOOD_NAME")
	private Set<String> favoriteFoods = new HashSet<>();
	
	@ElementCollection
	@CollectionTable(name = "ADDRESS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
	private List<Address> addressHistory = new ArrayList<>();
	
	public Member() {}
	
	public Member(Long id, String userName) {
		this.id = id;
		this.userName = userName;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<String> getFavoriteFoods() {
		return favoriteFoods;
	}

	public void setFavoriteFoods(Set<String> favoriteFoods) {
		this.favoriteFoods = favoriteFoods;
	}

	public List<Address> getAddressHistory() {
		return addressHistory;
	}

	public void setAddressHistory(List<Address> addressHistory) {
		this.addressHistory = addressHistory;
	}
	
}
