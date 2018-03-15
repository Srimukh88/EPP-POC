package com.discover.epp.repository;

import com.discover.epp.domain.Transacationdetails;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Transacationdetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TransacationdetailsRepository extends JpaRepository<Transacationdetails, Long> {

}
