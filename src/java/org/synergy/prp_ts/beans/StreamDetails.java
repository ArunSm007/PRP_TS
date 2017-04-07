package org.synergy.prp_ts.beans;

import java.util.ArrayList;
import java.util.List;

public class StreamDetails {

    private String streamId;
    private String streamName;
    
    private List<ModuleDetails> moduleDetailses = new ArrayList<>();

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