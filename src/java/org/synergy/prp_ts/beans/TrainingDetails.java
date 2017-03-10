package org.synergy.prp_ts.beans;

import java.util.Date;
import java.util.List;

public class TrainingDetails {

	private String trainingId;
	private String categoryId;
	private String streamId;
        private String venueId;
        private List<BatchDetails> batchDetailses;
        private List<ScheduleDetails> scheduleDetailses;
	private Date fromDate;
	private Date toDate;

        public List<ScheduleDetails> getScheduleDetailses() {
            return scheduleDetailses;
        }

        public void setScheduleDetailses(List<ScheduleDetails> scheduleDetailses) {
            this.scheduleDetailses = scheduleDetailses;
        }

        public String getVenueId() {
            return venueId;
        }

        public void setVenueId(String venueId) {
            this.venueId = venueId;
        }

        public List<BatchDetails> getBatchDetailses() {
            return batchDetailses;
        }

        public void setBatchDetailses(List<BatchDetails> batchDetailses) {
            this.batchDetailses = batchDetailses;
        }
        
        public String getTrainingId() {
            return trainingId;
        }

        public void setTrainingId(String trainingId) {
            this.trainingId = trainingId;
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

        public Date getFromDate() {
            return fromDate;
        }

        public void setFromDate(Date fromDate) {
            this.fromDate = fromDate;
        }

        public Date getToDate() {
            return toDate;
        }

        public void setToDate(Date toDate) {
            this.toDate = toDate;
        }

	public String[] getAll() {
		// TODO - implement TrainingDetails.getAll
		throw new UnsupportedOperationException();
	}

	public void setAll(String[] details) {
		// TODO - implement TrainingDetails.setAll
		throw new UnsupportedOperationException();
	}

}