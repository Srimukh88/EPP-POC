package com.discover.epp.web.rest;

import com.discover.epp.TransacationdetailsApp;

import com.discover.epp.domain.Transacationdetails;
import com.discover.epp.repository.TransacationdetailsRepository;
import com.discover.epp.service.TransacationdetailsService;
import com.discover.epp.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static com.discover.epp.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the TransacationdetailsResource REST controller.
 *
 * @see TransacationdetailsResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TransacationdetailsApp.class)
public class TransacationdetailsResourceIntTest {

    private static final Integer DEFAULT_LOCAL_DATE_TIME = 1;
    private static final Integer UPDATED_LOCAL_DATE_TIME = 2;

    private static final Integer DEFAULT_DEBIT_FEE_AMOUNT_MARK = 1;
    private static final Integer UPDATED_DEBIT_FEE_AMOUNT_MARK = 2;

    private static final Integer DEFAULT_TRACE_TITLE_D_4 = 1;
    private static final Integer UPDATED_TRACE_TITLE_D_4 = 2;

    private static final Integer DEFAULT_TRACE_TITLE_D_3 = 1;
    private static final Integer UPDATED_TRACE_TITLE_D_3 = 2;

    private static final Integer DEFAULT_REJECTT_DESCRIPTION = 1;
    private static final Integer UPDATED_REJECTT_DESCRIPTION = 2;

    private static final String DEFAULT_CVV_CVC_RESULT = "AAAAAAAAAA";
    private static final String UPDATED_CVV_CVC_RESULT = "BBBBBBBBBB";

    private static final Integer DEFAULT_RESPONSE_CODE = 1;
    private static final Integer UPDATED_RESPONSE_CODE = 2;

    private static final Integer DEFAULT_CARD_BANK = 1;
    private static final Integer UPDATED_CARD_BANK = 2;

    private static final Integer DEFAULT_ACQ_IA_AMT_MARK = 1;
    private static final Integer UPDATED_ACQ_IA_AMT_MARK = 2;

    private static final Integer DEFAULT_SWITCH_DATE_TIME = 1;
    private static final Integer UPDATED_SWITCH_DATE_TIME = 2;

    @Autowired
    private TransacationdetailsRepository transacationdetailsRepository;

    @Autowired
    private TransacationdetailsService transacationdetailsService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restTransacationdetailsMockMvc;

    private Transacationdetails transacationdetails;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final TransacationdetailsResource transacationdetailsResource = new TransacationdetailsResource(transacationdetailsService);
        this.restTransacationdetailsMockMvc = MockMvcBuilders.standaloneSetup(transacationdetailsResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Transacationdetails createEntity(EntityManager em) {
        Transacationdetails transacationdetails = new Transacationdetails()
            .localDateTime(DEFAULT_LOCAL_DATE_TIME)
            .debitFeeAmountMark(DEFAULT_DEBIT_FEE_AMOUNT_MARK)
            .traceTitleD4(DEFAULT_TRACE_TITLE_D_4)
            .traceTitleD3(DEFAULT_TRACE_TITLE_D_3)
            .rejecttDescription(DEFAULT_REJECTT_DESCRIPTION)
            .cvvCvcResult(DEFAULT_CVV_CVC_RESULT)
            .responseCode(DEFAULT_RESPONSE_CODE)
            .cardBank(DEFAULT_CARD_BANK)
            .acqIAAmtMark(DEFAULT_ACQ_IA_AMT_MARK)
            .switchDateTime(DEFAULT_SWITCH_DATE_TIME);
        return transacationdetails;
    }

    @Before
    public void initTest() {
        transacationdetails = createEntity(em);
    }

    @Test
    @Transactional
    public void createTransacationdetails() throws Exception {
        int databaseSizeBeforeCreate = transacationdetailsRepository.findAll().size();

        // Create the Transacationdetails
        restTransacationdetailsMockMvc.perform(post("/api/transacationdetails")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(transacationdetails)))
            .andExpect(status().isCreated());

        // Validate the Transacationdetails in the database
        List<Transacationdetails> transacationdetailsList = transacationdetailsRepository.findAll();
        assertThat(transacationdetailsList).hasSize(databaseSizeBeforeCreate + 1);
        Transacationdetails testTransacationdetails = transacationdetailsList.get(transacationdetailsList.size() - 1);
        assertThat(testTransacationdetails.getLocalDateTime()).isEqualTo(DEFAULT_LOCAL_DATE_TIME);
        assertThat(testTransacationdetails.getDebitFeeAmountMark()).isEqualTo(DEFAULT_DEBIT_FEE_AMOUNT_MARK);
        assertThat(testTransacationdetails.getTraceTitleD4()).isEqualTo(DEFAULT_TRACE_TITLE_D_4);
        assertThat(testTransacationdetails.getTraceTitleD3()).isEqualTo(DEFAULT_TRACE_TITLE_D_3);
        assertThat(testTransacationdetails.getRejecttDescription()).isEqualTo(DEFAULT_REJECTT_DESCRIPTION);
        assertThat(testTransacationdetails.getCvvCvcResult()).isEqualTo(DEFAULT_CVV_CVC_RESULT);
        assertThat(testTransacationdetails.getResponseCode()).isEqualTo(DEFAULT_RESPONSE_CODE);
        assertThat(testTransacationdetails.getCardBank()).isEqualTo(DEFAULT_CARD_BANK);
        assertThat(testTransacationdetails.getAcqIAAmtMark()).isEqualTo(DEFAULT_ACQ_IA_AMT_MARK);
        assertThat(testTransacationdetails.getSwitchDateTime()).isEqualTo(DEFAULT_SWITCH_DATE_TIME);
    }

    @Test
    @Transactional
    public void createTransacationdetailsWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = transacationdetailsRepository.findAll().size();

        // Create the Transacationdetails with an existing ID
        transacationdetails.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restTransacationdetailsMockMvc.perform(post("/api/transacationdetails")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(transacationdetails)))
            .andExpect(status().isBadRequest());

        // Validate the Transacationdetails in the database
        List<Transacationdetails> transacationdetailsList = transacationdetailsRepository.findAll();
        assertThat(transacationdetailsList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllTransacationdetails() throws Exception {
        // Initialize the database
        transacationdetailsRepository.saveAndFlush(transacationdetails);

        // Get all the transacationdetailsList
        restTransacationdetailsMockMvc.perform(get("/api/transacationdetails?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(transacationdetails.getId().intValue())))
            .andExpect(jsonPath("$.[*].localDateTime").value(hasItem(DEFAULT_LOCAL_DATE_TIME)))
            .andExpect(jsonPath("$.[*].debitFeeAmountMark").value(hasItem(DEFAULT_DEBIT_FEE_AMOUNT_MARK)))
            .andExpect(jsonPath("$.[*].traceTitleD4").value(hasItem(DEFAULT_TRACE_TITLE_D_4)))
            .andExpect(jsonPath("$.[*].traceTitleD3").value(hasItem(DEFAULT_TRACE_TITLE_D_3)))
            .andExpect(jsonPath("$.[*].rejecttDescription").value(hasItem(DEFAULT_REJECTT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].cvvCvcResult").value(hasItem(DEFAULT_CVV_CVC_RESULT.toString())))
            .andExpect(jsonPath("$.[*].responseCode").value(hasItem(DEFAULT_RESPONSE_CODE)))
            .andExpect(jsonPath("$.[*].cardBank").value(hasItem(DEFAULT_CARD_BANK)))
            .andExpect(jsonPath("$.[*].acqIAAmtMark").value(hasItem(DEFAULT_ACQ_IA_AMT_MARK)))
            .andExpect(jsonPath("$.[*].switchDateTime").value(hasItem(DEFAULT_SWITCH_DATE_TIME)));
    }

    @Test
    @Transactional
    public void getTransacationdetails() throws Exception {
        // Initialize the database
        transacationdetailsRepository.saveAndFlush(transacationdetails);

        // Get the transacationdetails
        restTransacationdetailsMockMvc.perform(get("/api/transacationdetails/{id}", transacationdetails.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(transacationdetails.getId().intValue()))
            .andExpect(jsonPath("$.localDateTime").value(DEFAULT_LOCAL_DATE_TIME))
            .andExpect(jsonPath("$.debitFeeAmountMark").value(DEFAULT_DEBIT_FEE_AMOUNT_MARK))
            .andExpect(jsonPath("$.traceTitleD4").value(DEFAULT_TRACE_TITLE_D_4))
            .andExpect(jsonPath("$.traceTitleD3").value(DEFAULT_TRACE_TITLE_D_3))
            .andExpect(jsonPath("$.rejecttDescription").value(DEFAULT_REJECTT_DESCRIPTION))
            .andExpect(jsonPath("$.cvvCvcResult").value(DEFAULT_CVV_CVC_RESULT.toString()))
            .andExpect(jsonPath("$.responseCode").value(DEFAULT_RESPONSE_CODE))
            .andExpect(jsonPath("$.cardBank").value(DEFAULT_CARD_BANK))
            .andExpect(jsonPath("$.acqIAAmtMark").value(DEFAULT_ACQ_IA_AMT_MARK))
            .andExpect(jsonPath("$.switchDateTime").value(DEFAULT_SWITCH_DATE_TIME));
    }

    @Test
    @Transactional
    public void getNonExistingTransacationdetails() throws Exception {
        // Get the transacationdetails
        restTransacationdetailsMockMvc.perform(get("/api/transacationdetails/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateTransacationdetails() throws Exception {
        // Initialize the database
        transacationdetailsService.save(transacationdetails);

        int databaseSizeBeforeUpdate = transacationdetailsRepository.findAll().size();

        // Update the transacationdetails
        Transacationdetails updatedTransacationdetails = transacationdetailsRepository.findOne(transacationdetails.getId());
        // Disconnect from session so that the updates on updatedTransacationdetails are not directly saved in db
        em.detach(updatedTransacationdetails);
        updatedTransacationdetails
            .localDateTime(UPDATED_LOCAL_DATE_TIME)
            .debitFeeAmountMark(UPDATED_DEBIT_FEE_AMOUNT_MARK)
            .traceTitleD4(UPDATED_TRACE_TITLE_D_4)
            .traceTitleD3(UPDATED_TRACE_TITLE_D_3)
            .rejecttDescription(UPDATED_REJECTT_DESCRIPTION)
            .cvvCvcResult(UPDATED_CVV_CVC_RESULT)
            .responseCode(UPDATED_RESPONSE_CODE)
            .cardBank(UPDATED_CARD_BANK)
            .acqIAAmtMark(UPDATED_ACQ_IA_AMT_MARK)
            .switchDateTime(UPDATED_SWITCH_DATE_TIME);

        restTransacationdetailsMockMvc.perform(put("/api/transacationdetails")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedTransacationdetails)))
            .andExpect(status().isOk());

        // Validate the Transacationdetails in the database
        List<Transacationdetails> transacationdetailsList = transacationdetailsRepository.findAll();
        assertThat(transacationdetailsList).hasSize(databaseSizeBeforeUpdate);
        Transacationdetails testTransacationdetails = transacationdetailsList.get(transacationdetailsList.size() - 1);
        assertThat(testTransacationdetails.getLocalDateTime()).isEqualTo(UPDATED_LOCAL_DATE_TIME);
        assertThat(testTransacationdetails.getDebitFeeAmountMark()).isEqualTo(UPDATED_DEBIT_FEE_AMOUNT_MARK);
        assertThat(testTransacationdetails.getTraceTitleD4()).isEqualTo(UPDATED_TRACE_TITLE_D_4);
        assertThat(testTransacationdetails.getTraceTitleD3()).isEqualTo(UPDATED_TRACE_TITLE_D_3);
        assertThat(testTransacationdetails.getRejecttDescription()).isEqualTo(UPDATED_REJECTT_DESCRIPTION);
        assertThat(testTransacationdetails.getCvvCvcResult()).isEqualTo(UPDATED_CVV_CVC_RESULT);
        assertThat(testTransacationdetails.getResponseCode()).isEqualTo(UPDATED_RESPONSE_CODE);
        assertThat(testTransacationdetails.getCardBank()).isEqualTo(UPDATED_CARD_BANK);
        assertThat(testTransacationdetails.getAcqIAAmtMark()).isEqualTo(UPDATED_ACQ_IA_AMT_MARK);
        assertThat(testTransacationdetails.getSwitchDateTime()).isEqualTo(UPDATED_SWITCH_DATE_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingTransacationdetails() throws Exception {
        int databaseSizeBeforeUpdate = transacationdetailsRepository.findAll().size();

        // Create the Transacationdetails

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restTransacationdetailsMockMvc.perform(put("/api/transacationdetails")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(transacationdetails)))
            .andExpect(status().isCreated());

        // Validate the Transacationdetails in the database
        List<Transacationdetails> transacationdetailsList = transacationdetailsRepository.findAll();
        assertThat(transacationdetailsList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteTransacationdetails() throws Exception {
        // Initialize the database
        transacationdetailsService.save(transacationdetails);

        int databaseSizeBeforeDelete = transacationdetailsRepository.findAll().size();

        // Get the transacationdetails
        restTransacationdetailsMockMvc.perform(delete("/api/transacationdetails/{id}", transacationdetails.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Transacationdetails> transacationdetailsList = transacationdetailsRepository.findAll();
        assertThat(transacationdetailsList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Transacationdetails.class);
        Transacationdetails transacationdetails1 = new Transacationdetails();
        transacationdetails1.setId(1L);
        Transacationdetails transacationdetails2 = new Transacationdetails();
        transacationdetails2.setId(transacationdetails1.getId());
        assertThat(transacationdetails1).isEqualTo(transacationdetails2);
        transacationdetails2.setId(2L);
        assertThat(transacationdetails1).isNotEqualTo(transacationdetails2);
        transacationdetails1.setId(null);
        assertThat(transacationdetails1).isNotEqualTo(transacationdetails2);
    }
}
