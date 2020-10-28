package com.evkosoft.fsageocoding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.evkosoft.fsageocoding.service.FsaService;

@Component
public class FsaCommandLineRunner implements CommandLineRunner {

	@Autowired
	private FsaService fsaService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=========================================> Starting Update All Fsa");
		fsaService.updateAllFsaGeocoding();
	}

}
