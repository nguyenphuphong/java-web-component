package vn.kase.web.pojo;

import org.apache.commons.io.FilenameUtils;

public class Attachment {
    private Integer id;
    private String path;

    public String getFilename() {
        return FilenameUtils.getName(path);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
