package com.discover.epp.service.impl;

import com.discover.epp.service.TransacationdetailsService;
import com.discover.epp.domain.Transacationdetails;
import com.discover.epp.repository.TransacationdetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing Transacationdetails.
 */
@Service
@Transactional
public class TransacationdetailsServiceImpl implements TransacationdetailsService {

    private final Logger log = LoggerFactory.getLogger(TransacationdetailsServiceImpl.class);

    private final TransacationdetailsRepository transacationdetailsRepository;

    public TransacationdetailsServiceImpl(TransacationdetailsRepository transacationdetailsRepository) {
        this.transacationdetailsRepository = transacationdetailsRepository;
    }

    /**
     * Save a transacationdetails.
     *
     * @param transacationdetails the entity to save
     * @return the persisted entity
     */
    @Override
    public Transacationdetails save(Transacationdetails transacationdetails) {
        log.debug("Request to save Transacationdetails : {}", transacationdetails);
        return transacationdetailsRepository.save(transacationdetails);
    }

    /**
     * Get all the transacationdetails.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Transacationdetails> findAll(Pageable pageable) {
        log.debug("Request to get all Transacationdetails");
        return transacationdetailsRepository.findAll(pageable);
    }

    /**
     * Get one transacationdetails by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Transacationdetails findOne(Long id) {
        log.debug("Request to get Transacationdetails : {}", id);
        return transacationdetailsRepository.findOne(id);
    }

    /**
     * Delete the transacationdetails by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Transacationdetails : {}", id);
        transacationdetailsRepository.delete(id);
    }
}
