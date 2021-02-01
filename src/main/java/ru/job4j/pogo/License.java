package ru.job4j.pogo;

import java.util.Date;

/**
 * 2. Модель данных. [#395278]
 */

public class License {
    private String owner;
    private String model;
    private String code;
    private Date created;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}

