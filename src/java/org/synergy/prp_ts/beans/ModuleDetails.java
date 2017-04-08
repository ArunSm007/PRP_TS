/**
 * 
 * @author Mathankumar
 */
package org.synergy.prp_ts.beans;

import java.util.ArrayList;
import java.util.List;

public class ModuleDetails {

    private int moduleId;
    private String moduleName;
    private int assessmentId;
    private List<SubModuleDetails> subModules = new ArrayList<>();

    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public List<SubModuleDetails> getSubModules() {
        return subModules;
    }

    public void setSubModules(List<SubModuleDetails> subModules) {
        this.subModules = subModules;
    }

    public void setAll(String[] details) {
            // TODO - implement ModuleDetails.setAll

    }
    public String[] getAll() {
            // TODO - implement ModuleDetails.setAll
            return null;
    }
}