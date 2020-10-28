package com.evkosoft.fsageocoding.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FSA = Forward Sortation Area A geographical unit based on the first three
 * characters in a Canadian postal code.
 * 
 * @author Eva Maciejko
 *
 */

@Entity
@Table(name = "fsa")
public class Fsa {

	@Id
	private String code;

	@Column(name = "latitude", columnDefinition = "decimal(65,30)")
	private BigDecimal latitude;

	@Column(name = "longitude", columnDefinition = "decimal(65,30)")
	private BigDecimal longitude;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

}
