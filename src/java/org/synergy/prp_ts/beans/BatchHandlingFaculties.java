package org.synergy.prp_ts.beans;

public class BatchHandlingFaculties {
        private int sno;
	private String facultyId;
	private String moduleId;
	private int moduleType;

        public int getSno() {
            return sno;
        }

        public void setSno(int sno) {
            this.sno = sno;
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

	public void setAll(String[] details) {
		// TODO - implement BatchHandlingFaculties.setAll
		throw new UnsupportedOperationException();
	}

}