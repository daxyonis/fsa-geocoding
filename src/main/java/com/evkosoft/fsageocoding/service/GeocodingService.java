package com.evkosoft.fsageocoding.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.evkosoft.fsageocoding.GeocodeProperties;
import com.evkosoft.fsageocoding.model.Fsa;
import com.evkosoft.fsageocoding.resource.GeocodeResponse;
import com.evkosoft.fsageocoding.resource.PlaceResponse;

@Service
@Transactional
public class GeocodingService {

	private Logger log = LoggerFactory.getLogger(GeocodingService.class);

	private final GeocodeProperties geocodeProperties;

	private WebClient placeWebClient;

	private WebClient geoWebClient;

	public GeocodingService(GeocodeProperties geocodeProperties) {
		this.geocodeProperties = geocodeProperties;
		placeWebClient = WebClient.create(geocodeProperties.getPlaceUrl());
		geoWebClient = WebClient.create(geocodeProperties.getUrl());
	}

	/**
	 * Update every FSA with geocoding coordinates (latitude, longitude)
	 * 
	 * @param allFsas
	 */
	public void updateAllFsasGeocoding(List<Fsa> fsaList) {

		for (Fsa fsa : fsaList) {
			updateFsaCoordinates(fsa);
		}

	}

	/**
	 * Update geocoding coordinates for an Fsa
	 * 
	 * @param fsa
	 */
	private void updateFsaCoordinates(Fsa fsa) {

		// First get the place id
		String placeId = getPlaceId(fsa);
		if (placeId != null) {
			GeocodeResponse geoResponse = geoWebClient.get()
					.uri(uriBuilder -> uriBuilder.path("/json").queryParam("place_id", placeId)
							.queryParam("key", geocodeProperties.getKey()).build())
					.accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(GeocodeResponse.class).block();

			if (geoResponse != null) {
				log.info("Reponse status: {}", geoResponse.getStatus());
				log.info("Got geocode for placeId {}", placeId);
				fsa.setLatitude(geoResponse.getResults().get(0).getGeometry().getLocation().getLat());
				fsa.setLongitude(geoResponse.getResults().get(0).getGeometry().getLocation().getLng());
			} else {
				log.error("No geocode returned for placeId {}", placeId);
			}
		}
	}

	/**
	 * Get the place id for one FSA
	 * 
	 * @param fsa the FSA object
	 * 
	 * @return the list of place ids corresponding to the FSAs
	 */
	private String getPlaceId(Fsa fsa) {
		PlaceResponse placeResponse = placeWebClient.get()
				.uri(uriBuilder -> uriBuilder.path("/json").queryParam("input", fsa.getCode())
						.queryParam("key", geocodeProperties.getKey()).build())
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(PlaceResponse.class).block();

		if (placeResponse.getPredictions() != null && placeResponse.getPredictions().size() > 0) {
			log.info("Get place status={}", placeResponse.getStatus());
			log.info("Downloaded place id for fsa {}", fsa.getCode());
			return placeResponse.getPredictions().get(0).getPlaceId();
		} else {
			log.info("No predictions returned");
			return null;
		}
	}

}
