package com.evkosoft.fsageocoding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.evkosoft.fsageocoding.repository.FsaRepository;
import com.evkosoft.fsageocoding.service.GeocodingService;

@SpringBootTest
class FsaGeocodingApplicationTests {

	private Logger log = LoggerFactory.getLogger(FsaGeocodingApplicationTests.class);

	@Autowired
	private GeocodingService geocodingService;

	@Autowired
	private FsaRepository fsaRepository;

//	@Test
//	void getPlaceIdsTest() {
//		List<String> placeIds = geocodingService.getPlaceIds(fsaRepository.findAll());
//
//		log.info("{} Place IDs found", placeIds.size());
//
//	}

}
