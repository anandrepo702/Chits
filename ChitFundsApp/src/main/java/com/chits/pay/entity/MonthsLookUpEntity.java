package com.chits.pay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "months_lkp")
public class MonthsLookUpEntity {
	
	@Id
	@Column(name = "month_id")
	private Integer monthId;
	
	@Column(name = "month_year")
	private String monthYear;

	public Integer getMonthId() {
		return monthId;
	}

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthId(Integer monthId) {
		this.monthId = monthId;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}
	
	
	
	
}
