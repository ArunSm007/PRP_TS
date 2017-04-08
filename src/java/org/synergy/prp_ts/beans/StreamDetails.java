package org.synergy.prp_ts.beans;

import java.util.ArrayList;
import java.util.List;

public class StreamDetails {

    private String streamId;
    private String streamName;
    private String categoryId;
    private List<ModuleDetails> moduleDetailses = new ArrayList<>();

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public List<ModuleDetails> getModuleDetailses() {
        return moduleDetailses;
    }

    public void setModuleDetailses(List<ModuleDetails> moduleDetailses) {
        this.moduleDetailses = moduleDetailses;
    }

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

}