package com.discover.epp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.discover.epp.domain.Transacationdetails;
import com.discover.epp.service.TransacationdetailsService;
import com.discover.epp.web.rest.errors.BadRequestAlertException;
import com.discover.epp.web.rest.util.HeaderUtil;
import com.discover.epp.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Transacationdetails.
 */
@RestController
@RequestMapping("/api")
public class TransacationdetailsResource {

    private final Logger log = LoggerFactory.getLogger(TransacationdetailsResource.class);

    private static final String ENTITY_NAME = "transacationdetails";

    private final TransacationdetailsService transacationdetailsService;

    public TransacationdetailsResource(TransacationdetailsService transacationdetailsService) {
        this.transacationdetailsService = transacationdetailsService;
    }

    /**
     * POST  /transacationdetails : Create a new transacationdetails.
     *
     * @param transacationdetails the transacationdetails to create
     * @return the ResponseEntity with status 201 (Created) and with body the new transacationdetails, or with status 400 (Bad Request) if the transacationdetails has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/transacationdetails")
    @Timed
    public ResponseEntity<Transacationdetails> createTransacationdetails(@RequestBody Transacationdetails transacationdetails) throws URISyntaxException {
        log.debug("REST request to save Transacationdetails : {}", transacationdetails);
        if (transacationdetails.getId() != null) {
            throw new BadRequestAlertException("A new transacationdetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Transacationdetails result = transacationdetailsService.save(transacationdetails);
        return ResponseEntity.created(new URI("/api/transacationdetails/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /transacationdetails : Updates an existing transacationdetails.
     *
     * @param transacationdetails the transacationdetails to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated transacationdetails,
     * or with status 400 (Bad Request) if the transacationdetails is not valid,
     * or with status 500 (Internal Server Error) if the transacationdetails couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/transacationdetails")
    @Timed
    public ResponseEntity<Transacationdetails> updateTransacationdetails(@RequestBody Transacationdetails transacationdetails) throws URISyntaxException {
        log.debug("REST request to update Transacationdetails : {}", transacationdetails);
        if (transacationdetails.getId() == null) {
            return createTransacationdetails(transacationdetails);
        }
        Transacationdetails result = transacationdetailsService.save(transacationdetails);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, transacationdetails.getId().toString()))
            .body(result);
    }

    /**
     * GET  /transacationdetails : get all the transacationdetails.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of transacationdetails in body
     */
    @GetMapping("/transacationdetails")
    @Timed
    public ResponseEntity<List<Transacationdetails>> getAllTransacationdetails(Pageable pageable) {
        log.debug("REST request to get a page of Transacationdetails");
        Page<Transacationdetails> page = transacationdetailsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/transacationdetails");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /transacationdetails/:id : get the "id" transacationdetails.
     *
     * @param id the id of the transacationdetails to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the transacationdetails, or with status 404 (Not Found)
     */
    @GetMapping("/transacationdetails/{id}")
    @Timed
    public ResponseEntity<Transacationdetails> getTransacationdetails(@PathVariable Long id) {
        log.debug("REST request to get Transacationdetails : {}", id);
        Transacationdetails transacationdetails = transacationdetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(transacationdetails));
    }

    /**
     * DELETE  /transacationdetails/:id : delete the "id" transacationdetails.
     *
     * @param id the id of the transacationdetails to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/transacationdetails/{id}")
    @Timed
    public ResponseEntity<Void> deleteTransacationdetails(@PathVariable Long id) {
        log.debug("REST request to delete Transacationdetails : {}", id);
        transacationdetailsService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
