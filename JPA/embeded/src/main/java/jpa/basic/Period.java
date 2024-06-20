package jpa.basic;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;

//@Embeddable
public class Period {
	private LocalDateTime startDate; // 근무시작일
	private LocalDateTime endDate; // 근무종료일
	
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
}