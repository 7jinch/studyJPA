package jpa.basic;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Manager extends Member {
	private int year; // 경력

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
