package hzy.entity;

import java.util.Date;

public class Bespeak {
    private Integer id;

    private Integer pid;

    private Integer did;

    private Date bespeaktime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Date getBespeaktime() {
        return bespeaktime;
    }

    public void setBespeaktime(Date bespeaktime) {
        this.bespeaktime = bespeaktime;
    }
}