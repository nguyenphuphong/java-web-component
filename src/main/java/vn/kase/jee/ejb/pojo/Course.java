package vn.kase.jee.ejb.pojo;

import java.io.Serializable;

public class Course implements Serializable {
    private static final long serialVersionUID = 3188290712059616105L;
    
    private Integer id;
    private String title;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
