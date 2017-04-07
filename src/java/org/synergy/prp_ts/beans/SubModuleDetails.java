/**
 * 
 * @author Mathankumar
 */
package org.synergy.prp_ts.beans;

import java.util.List;

public class SubModuleDetails {

	private int subModuleId;
	private String subModuleName;
        private List<AssessmentDetails> assessments;
	private float miniprojectDuration;
	private float practiceDuration;

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

    public List<AssessmentDetails> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<AssessmentDetails> assessments) {
        this.assessments = assessments;
    }

    public float getMiniprojectDuration() {
        return miniprojectDuration;
    }

    public void setMiniprojectDuration(float miniprojectDuration) {
        this.miniprojectDuration = miniprojectDuration;
    }

    public float getPracticeDuration() {
        return practiceDuration;
    }

    public void setPracticeDuration(float practiceDuration) {
        this.practiceDuration = practiceDuration;
    }

	

	public String[] getAll() {
		// TODO - implement SubModuleDuration.getAll
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param details
	 */
	public void setAll(String[] details) {
		// TODO - implement SubModuleDuration.setAll
		throw new UnsupportedOperationException();
	}

}