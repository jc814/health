package hzy.dto;

import java.util.Date;

public class AdminDTO {
    private Integer id;

    private Integer hid;

    private String name;

    private String photo;

    private Date lastTime;

    private Short type;

    private String nameForToken;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getNameForToken() {
        return nameForToken;
    }

    public void setNameForToken(String nameForToken) {
        this.nameForToken = nameForToken;
    }
}
