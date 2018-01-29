package utils;

/**
 * Result class
 *
 * @author hzy
 * @date 2018/01/19
 */
public class Result {
    /**
     * 是否成功
     */
    private Boolean success;
    /**
     * 影响条数
     */
    private Integer num;
    /**
     * 返回消息
     */
    private String message;
    /**
     * 结果集
     */
    private Object data;
    /**
     * 分页总数
     */
    private Long tatalNum;

    /**
     * token 令牌
     */
    private String token;

    /**
     * 错误代码
     */
    private Integer errorCode;

    public Result(Boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public Result(Boolean success, Object data, Long tatalNum) {
        this.success = success;
        this.data = data;
        this.tatalNum = tatalNum;
    }

    public Result() {
    }

    public Result(Boolean success) {
        this.success = success;
    }

    public Result(Boolean success, Integer errorCode) {
        this.success = success;
        this.errorCode = errorCode;
    }


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTatalNum() {
        return tatalNum;
    }

    public void setTatalNum(Long tatalNum) {
        this.tatalNum = tatalNum;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
