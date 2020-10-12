package vn.kase.jee.jms.pojo;

import java.io.Serializable;

public class CourseMessage implements Serializable {
    private static final long serialVersionUID = 5670121788848489728L;

    private String title;
    private String description;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
