package hzy.entity;

import java.util.Date;

public class Bespeak {
    private Integer id;

    private Integer hid;

    private String cardId;

    private Integer did;

    private Date bespeakTime;

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

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Date getBespeakTime() {
        return bespeakTime;
    }

    public void setBespeakTime(Date bespeakTime) {
        this.bespeakTime = bespeakTime;
    }
}