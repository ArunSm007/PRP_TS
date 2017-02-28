package org.synergy.prp_ts.beans;

import java.util.List;

public class ModuleDetails {

	private String moduleId;
	private String moduleName;
	private AssessmentDetails assessment;
	private float logicalBuildingDuration;
	private float moduleDuration;
	private CategoryDetails category;
	private StreamDetails stream;
	private List<SubModuleDetails> subModules;

	public void getModuleId() {
		// TODO - implement ModuleDetails.getModuleId
		throw new UnsupportedOperationException();
	}

	public void getModuleName() {
		// TODO - implement ModuleDetails.getModuleName
		throw new UnsupportedOperationException();
	}

	public void getLogicalBuildingDuration() {
		// TODO - implement ModuleDetails.getLogicalBuildingDuration
		throw new UnsupportedOperationException();
	}

	public void getModuleDuration() {
		// TODO - implement ModuleDetails.getModuleDuration
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param moduleId
	 */
	public void setModuleId(String moduleId) {
		// TODO - implement ModuleDetails.setModuleId
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param moduleName
	 */
	public void setModuleName(String moduleName) {
		// TODO - implement ModuleDetails.setModuleName
		throw new UnsupportedOperationException();
	}

	public AssessmentDetails getAssessment() {
		// TODO - implement ModuleDetails.getAssessment
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param assessment
	 */
	public void setAssessment(AssessmentDetails assessment) {
		// TODO - implement ModuleDetails.setAssessment
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param logicalBuildingDuration
	 */
	public void setLogicalBuildingDuration(float logicalBuildingDuration) {
		// TODO - implement ModuleDetails.setLogicalBuildingDuration
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param moduleDuration
	 */
	public void setModuleDuration(float moduleDuration) {
		// TODO - implement ModuleDetails.setModuleDuration
		throw new UnsupportedOperationException();
	}

	public CategoryDetails getCategory() {
		return this.category;
	}

	/**
	 * 
	 * @param category
	 */
	public void setCategory(CategoryDetails category) {
		this.category = category;
	}

	public StreamDetails getStream() {
		return this.stream;
	}

	/**
	 * 
	 * @param stream
	 */
	public void setStream(StreamDetails stream) {
		this.stream = stream;
	}

	public String[] getAll() {
		// TODO - implement ModuleDetails.getAll
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param details
	 */
	public void setAll(String[] details) {
		// TODO - implement ModuleDetails.setAll
		throw new UnsupportedOperationException();
	}

	public List<SubModuleDetails> getSubModules() {
		// TODO - implement ModuleDetails.getSubModules
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param subModules
	 */
	public void setSubModules(List<SubModuleDetails> subModules) {
		this.subModules = subModules;
	}

}