package de.diedavids.cuba.cefev.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;

@Table(name = "CEFEV_PAYMENTS")
@Entity(name = "cefev$Payments")
public class Payments extends StandardEntity {
    private static final long serialVersionUID = -1856589953384619567L;

    @Column(name = "PAYING_PARTY")
    protected String payingParty;

    @Column(name = "RECEIVING_PARTY")
    protected String receivingParty;

    public void setReceivingParty(Party receivingParty) {
        this.receivingParty = receivingParty == null ? null : receivingParty.getId();
    }

    public Party getReceivingParty() {
        return receivingParty == null ? null : Party.fromId(receivingParty);
    }


    public void setPayingParty(Party payingParty) {
        this.payingParty = payingParty == null ? null : payingParty.getId();
    }

    public Party getPayingParty() {
        return payingParty == null ? null : Party.fromId(payingParty);
    }


}