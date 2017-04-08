/**
 * 
 * @author Mathankumar
 */
package org.synergy.prp_ts.beans;

import java.util.ArrayList;
import java.util.List;

public class BatchDetails {

	private String batchId;
	private int batchSize;
	private List<BatchEmployeeDetails> batchEmployeeDetailses = new ArrayList<>();
        private List<BatchHandlingFaculties> batchHandlingFacultieses = new ArrayList<>();
        private List<BatchDurationDetails> batchDurationDetailses = new ArrayList<>();

        public List<BatchDurationDetails> getBatchDurationDetailses() {
            return batchDurationDetailses;
        }

        public void setBatchDurationDetailses(List<BatchDurationDetails> batchDurationDetailses) {
            this.batchDurationDetailses = batchDurationDetailses;
        }

        public String getBatchId() {
            return batchId;
        }

        public void setBatchId(String batchId) {
            this.batchId = batchId;
        }

        public int getBatchSize() {
            return batchSize;
        }

        public void setBatchSize(int batchSize) {
            this.batchSize = batchSize;
        }

        public List<BatchEmployeeDetails> getBatchEmployeeDetailses() {
            return batchEmployeeDetailses;
        }

        public void setBatchEmployeeDetailses(List<BatchEmployeeDetails> batchEmployeeDetailses) {
            this.batchEmployeeDetailses = batchEmployeeDetailses;
        }

        public List<BatchHandlingFaculties> getBatchHandlingFacultieses() {
            return batchHandlingFacultieses;
        }

        public void setBatchHandlingFacultieses(List<BatchHandlingFaculties> batchHandlingFacultieses) {
            this.batchHandlingFacultieses = batchHandlingFacultieses;
        }

	public String[] getAll() {
		// TODO - implement BatchDetails.getAll
		throw new UnsupportedOperationException();
	}

	public void setAll(String[] details) {
		// TODO - implement BatchDetails.setAll
		throw new UnsupportedOperationException();
	}

}