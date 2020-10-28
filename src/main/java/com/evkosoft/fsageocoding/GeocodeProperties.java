package com.evkosoft.fsageocoding;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(value = "application.geocode", ignoreUnknownFields = false)
public class GeocodeProperties {

	private String key;

	private String url;

	private String placeUrl;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPlaceUrl() {
		return placeUrl;
	}

	public void setPlaceUrl(String placeUrl) {
		this.placeUrl = placeUrl;
	}

}
