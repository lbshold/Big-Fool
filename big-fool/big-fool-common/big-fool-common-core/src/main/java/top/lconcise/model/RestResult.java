package top.lconcise.model;

import java.io.Serializable;

/**
 * @author liusj
 * @date 2020/11/9
 *
 * Rest请求返回.
 */
public class RestResult<T> implements Serializable {
    private static final long serialVersionUID = -2009822668072034793L;
    private int code;
    private String message;
    private T data;

    public RestResult() {
    }

    public RestResult(int code, String message, T data) {
        this.code = code;
        this.setMessage(message);
        this.data = data;
    }

    public RestResult(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public RestResult(int code, String message) {
        this.code = code;
        this.setMessage(message);
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean ok() {
        return this.code == 0 || this.code == 200;
    }

    public String toString() {
        return "RestResult{code=" + this.code + ", message='" + this.message + '\'' + ", data=" + this.data + '}';
    }

    public static <T> RestResult.ResResultBuilder<T> builder() {
        return new RestResult.ResResultBuilder();
    }

    public static final class ResResultBuilder<T> {
        private int code;
        private String errMsg;
        private T data;

        private ResResultBuilder() {
        }

        public RestResult.ResResultBuilder<T> withCode(int code) {
            this.code = code;
            return this;
        }

        public RestResult.ResResultBuilder<T> withMsg(String errMsg) {
            this.errMsg = errMsg;
            return this;
        }

        public RestResult.ResResultBuilder<T> withData(T data) {
            this.data = data;
            return this;
        }

        public RestResult<T> build() {
            RestResult<T> restResult = new RestResult();
            restResult.setCode(this.code);
            restResult.setMessage(this.errMsg);
            restResult.setData(this.data);
            return restResult;
        }
    }
}
