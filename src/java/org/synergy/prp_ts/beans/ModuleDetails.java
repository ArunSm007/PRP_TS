package org.synergy.prp_ts.beans;

import java.util.List;

public class ModuleDetails {

	private int moduleId;
	private String moduleName;
	private List<AssessmentDetails> assessments;
	private float logicalBuildingDuration;
	private float moduleDuration;
	private String categoryId;
	private String streamId;
	private List<SubModuleDetails> subModules;

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

    public List<AssessmentDetails> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<AssessmentDetails> assessments) {
        this.assessments = assessments;
    }

    public float getLogicalBuildingDuration() {
        return logicalBuildingDuration;
    }

    public void setLogicalBuildingDuration(float logicalBuildingDuration) {
        this.logicalBuildingDuration = logicalBuildingDuration;
    }

    public float getModuleDuration() {
        return moduleDuration;
    }

    public void setModuleDuration(float moduleDuration) {
        this.moduleDuration = moduleDuration;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
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