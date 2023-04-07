package com.techstore.model.general;

import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@Embeddable
public class InitialDate {
    private Date createAt;
    private Date updateAt;

    public InitialDate() {
    }

    public InitialDate(Date createAt, Date updateAt) {
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    @PrePersist
    protected void onCreate() {
        updateAt = createAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updateAt = new Date();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
