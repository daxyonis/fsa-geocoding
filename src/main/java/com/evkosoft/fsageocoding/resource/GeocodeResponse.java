package com.evkosoft.fsageocoding.resource;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Object to unmarshal google geocode API response
 * 
 * @author Eva Maciejko
 *
 */
public class GeocodeResponse {

	private List<Result> results;

	private String status;

	public static class Result {

		@JsonProperty("formatted_address")
		private String formattedAddress;

		private Geometry geometry;

		@JsonProperty("place_id")
		private String placeId;

		List<String> types;

		public static class Geometry {

			private Location location;

			public static class Location {

				private BigDecimal lat;

				private BigDecimal lng;

				@JsonProperty("location_type")
				private String locationType;

				public BigDecimal getLat() {
					return lat;
				}

				public void setLat(BigDecimal lat) {
					this.lat = lat;
				}

				public BigDecimal getLng() {
					return lng;
				}

				public void setLng(BigDecimal lng) {
					this.lng = lng;
				}

				public String getLocationType() {
					return locationType;
				}

				public void setLocationType(String locationType) {
					this.locationType = locationType;
				}

			}

			public Location getLocation() {
				return location;
			}

			public void setLocation(Location location) {
				this.location = location;
			}

		}

		public String getFormattedAddress() {
			return formattedAddress;
		}

		public void setFormattedAddress(String formattedAddress) {
			this.formattedAddress = formattedAddress;
		}

		public Geometry getGeometry() {
			return geometry;
		}

		public void setGeometry(Geometry geometry) {
			this.geometry = geometry;
		}

		public String getPlaceId() {
			return placeId;
		}

		public void setPlaceId(String placeId) {
			this.placeId = placeId;
		}

		public List<String> getTypes() {
			return types;
		}

		public void setTypes(List<String> types) {
			this.types = types;
		}

	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
