/**
 * 
 * @author Mathankumar
 */
package org.synergy.prp_ts.beans;

import java.util.ArrayList;
import java.util.List;

public class SubModuleDetails {

    private int subModuleId;
    private String subModuleName;
    private int assessmentId;

    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }

    public int getSubModuleId() {
        return subModuleId;
    }

    public void setSubModuleId(int subModuleId) {
        this.subModuleId = subModuleId;
    }

    public String getSubModuleName() {
        return subModuleName;
    }

    public void setSubModuleName(String subModuleName) {
        this.subModuleName = subModuleName;
    }

    public String[] getAll() {
            // TODO - implement SubModuleDuration.getAll
            throw new UnsupportedOperationException();
    }

    public void setAll(String[] details) {
            // TODO - implement SubModuleDuration.setAll
            throw new UnsupportedOperationException();
    }

}