/**
 * 
 * @author Mathankumar
 */
package org.synergy.prp_ts.beans;

import java.util.ArrayList;
import java.util.List;

public class CategoryDetails {

    private String categoryId;
    private String categoryName;
    private List<StreamDetails> streamDetailses = new ArrayList<>();

    public List<StreamDetails> getStreamDetailses() {
        return streamDetailses;
    }

    public void setStreamDetailses(List<StreamDetails> streamDetailses) {
        this.streamDetailses = streamDetailses;
    }
    
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String[] getAll() {
            // TODO - implement CategoryDetails.getAll
            throw new UnsupportedOperationException();
    }

    public void setAll(String[] details) {
            // TODO - implement CategoryDetails.setAll
            throw new UnsupportedOperationException();
    }

}