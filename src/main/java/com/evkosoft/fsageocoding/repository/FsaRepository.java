package com.evkosoft.fsageocoding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evkosoft.fsageocoding.model.Fsa;

@Repository
public interface FsaRepository extends JpaRepository<Fsa, String> {

}
