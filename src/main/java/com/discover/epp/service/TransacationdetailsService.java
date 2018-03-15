package com.discover.epp.service;

import com.discover.epp.domain.Transacationdetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Transacationdetails.
 */
public interface TransacationdetailsService {

    /**
     * Save a transacationdetails.
     *
     * @param transacationdetails the entity to save
     * @return the persisted entity
     */
    Transacationdetails save(Transacationdetails transacationdetails);

    /**
     * Get all the transacationdetails.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<Transacationdetails> findAll(Pageable pageable);

    /**
     * Get the "id" transacationdetails.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Transacationdetails findOne(Long id);

    /**
     * Delete the "id" transacationdetails.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
