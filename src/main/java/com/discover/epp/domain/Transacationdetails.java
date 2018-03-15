package com.discover.epp.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Transacationdetails.
 */
@Entity
@Table(name = "transacationdetails")
public class Transacationdetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "local_date_time")
    private Integer localDateTime;

    @Column(name = "debit_fee_amount_mark")
    private Integer debitFeeAmountMark;

    @Column(name = "trace_title_d_4")
    private Integer traceTitleD4;

    @Column(name = "trace_title_d_3")
    private Integer traceTitleD3;

    @Column(name = "rejectt_description")
    private Integer rejecttDescription;

    @Column(name = "cvv_cvc_result")
    private String cvvCvcResult;

    @Column(name = "response_code")
    private Integer responseCode;

    @Column(name = "card_bank")
    private Integer cardBank;

    @Column(name = "acq_ia_amt_mark")
    private Integer acqIAAmtMark;

    @Column(name = "switch_date_time")
    private Integer switchDateTime;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLocalDateTime() {
        return localDateTime;
    }

    public Transacationdetails localDateTime(Integer localDateTime) {
        this.localDateTime = localDateTime;
        return this;
    }

    public void setLocalDateTime(Integer localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Integer getDebitFeeAmountMark() {
        return debitFeeAmountMark;
    }

    public Transacationdetails debitFeeAmountMark(Integer debitFeeAmountMark) {
        this.debitFeeAmountMark = debitFeeAmountMark;
        return this;
    }

    public void setDebitFeeAmountMark(Integer debitFeeAmountMark) {
        this.debitFeeAmountMark = debitFeeAmountMark;
    }

    public Integer getTraceTitleD4() {
        return traceTitleD4;
    }

    public Transacationdetails traceTitleD4(Integer traceTitleD4) {
        this.traceTitleD4 = traceTitleD4;
        return this;
    }

    public void setTraceTitleD4(Integer traceTitleD4) {
        this.traceTitleD4 = traceTitleD4;
    }

    public Integer getTraceTitleD3() {
        return traceTitleD3;
    }

    public Transacationdetails traceTitleD3(Integer traceTitleD3) {
        this.traceTitleD3 = traceTitleD3;
        return this;
    }

    public void setTraceTitleD3(Integer traceTitleD3) {
        this.traceTitleD3 = traceTitleD3;
    }

    public Integer getRejecttDescription() {
        return rejecttDescription;
    }

    public Transacationdetails rejecttDescription(Integer rejecttDescription) {
        this.rejecttDescription = rejecttDescription;
        return this;
    }

    public void setRejecttDescription(Integer rejecttDescription) {
        this.rejecttDescription = rejecttDescription;
    }

    public String getCvvCvcResult() {
        return cvvCvcResult;
    }

    public Transacationdetails cvvCvcResult(String cvvCvcResult) {
        this.cvvCvcResult = cvvCvcResult;
        return this;
    }

    public void setCvvCvcResult(String cvvCvcResult) {
        this.cvvCvcResult = cvvCvcResult;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public Transacationdetails responseCode(Integer responseCode) {
        this.responseCode = responseCode;
        return this;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public Integer getCardBank() {
        return cardBank;
    }

    public Transacationdetails cardBank(Integer cardBank) {
        this.cardBank = cardBank;
        return this;
    }

    public void setCardBank(Integer cardBank) {
        this.cardBank = cardBank;
    }

    public Integer getAcqIAAmtMark() {
        return acqIAAmtMark;
    }

    public Transacationdetails acqIAAmtMark(Integer acqIAAmtMark) {
        this.acqIAAmtMark = acqIAAmtMark;
        return this;
    }

    public void setAcqIAAmtMark(Integer acqIAAmtMark) {
        this.acqIAAmtMark = acqIAAmtMark;
    }

    public Integer getSwitchDateTime() {
        return switchDateTime;
    }

    public Transacationdetails switchDateTime(Integer switchDateTime) {
        this.switchDateTime = switchDateTime;
        return this;
    }

    public void setSwitchDateTime(Integer switchDateTime) {
        this.switchDateTime = switchDateTime;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transacationdetails transacationdetails = (Transacationdetails) o;
        if (transacationdetails.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), transacationdetails.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Transacationdetails{" +
            "id=" + getId() +
            ", localDateTime=" + getLocalDateTime() +
            ", debitFeeAmountMark=" + getDebitFeeAmountMark() +
            ", traceTitleD4=" + getTraceTitleD4() +
            ", traceTitleD3=" + getTraceTitleD3() +
            ", rejecttDescription=" + getRejecttDescription() +
            ", cvvCvcResult='" + getCvvCvcResult() + "'" +
            ", responseCode=" + getResponseCode() +
            ", cardBank=" + getCardBank() +
            ", acqIAAmtMark=" + getAcqIAAmtMark() +
            ", switchDateTime=" + getSwitchDateTime() +
            "}";
    }
}
