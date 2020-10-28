package com.evkosoft.fsageocoding.resource;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Object to unmarshal google place autocomplete API response
 * 
 * @author Eva Maciejko
 *
 */
public class PlaceResponse {

	private List<Prediction> predictions;
	private String status;

	public static class Prediction {

		private String description;

		@JsonProperty("place_id")
		private String placeId;

		public Prediction() {
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getPlaceId() {
			return placeId;
		}

		public void setPlaceId(String placeId) {
			this.placeId = placeId;
		}

	}

	public List<Prediction> getPredictions() {
		return predictions;
	}

	public void setPredictions(List<Prediction> predictions) {
		this.predictions = predictions;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
