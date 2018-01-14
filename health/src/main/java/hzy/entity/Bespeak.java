package hzy.entity;

import java.util.Date;

public class Bespeak {
    private Integer id;

    private Long cardId;

    private Integer did;

    private Date bespeakTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
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