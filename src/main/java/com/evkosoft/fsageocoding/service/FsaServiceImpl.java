package com.evkosoft.fsageocoding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evkosoft.fsageocoding.model.Fsa;
import com.evkosoft.fsageocoding.repository.FsaRepository;

@Service
@Transactional
public class FsaServiceImpl implements FsaService {

	@Autowired
	private FsaRepository fsaRepository;

	@Autowired
	private GeocodingService geocodingService;

	@Override
	public void updateAllFsaGeocoding() {
		List<Fsa> allFsas = fsaRepository.findAll();
		geocodingService.updateAllFsasGeocoding(allFsas);
		fsaRepository.saveAll(allFsas);
	}

}
