/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.synergy.prp_ts.beans;

import java.util.Date;

/**
 *
 * @author Arun
 */
public class BatchDurationDetails {
    private int pno;
    private String batchId;
    private Date startDate;
    private Date endDate;
    private String acticityId;

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getActicityId() {
        return acticityId;
    }

    public void setActicityId(String acticityId) {
        this.acticityId = acticityId;
    }
    
}
