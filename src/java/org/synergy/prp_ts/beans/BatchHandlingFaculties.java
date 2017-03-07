package org.synergy.prp_ts.beans;

public class BatchHandlingFaculties {
        private int type;
	private String batchId;
	private String facultyId;
	private String moduleId;
	private int moduleType;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public int getModuleType() {
        return moduleType;
    }

    public void setModuleType(int moduleType) {
        this.moduleType = moduleType;
    }

        

	public String[] getAll() {
		// TODO - implement BatchHandlingFaculties.getAll
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param details
	 */
	public void setAll(String[] details) {
		// TODO - implement BatchHandlingFaculties.setAll
		throw new UnsupportedOperationException();
	}

}