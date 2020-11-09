package top.lconcise.model;

/**
 * @author liusj
 * @date 2020/11/9
 * <p>
 * Rest请求返回工具类.
 */
public class RestResultUtils {
    public RestResultUtils() {
    }

    public static RestResult success() {
        return RestResult.builder().withCode(200).build();
    }

    public static <T> RestResult success(T data) {
        return RestResult.builder().withCode(200).withData(data).build();
    }

    public static <T> RestResult success(int code, T data) {
        return RestResult.builder().withCode(code).withData(data).build();
    }

    public static <T> RestResult failed() {
        return RestResult.builder().withCode(500).build();
    }

    public static <T> RestResult failed(String errMsg) {
        return RestResult.builder().withCode(500).withMsg(errMsg).build();
    }

    public static <T> RestResult failed(int code, T data) {
        return RestResult.builder().withCode(code).withData(data).build();
    }

    public static <T> RestResult failed(int code, T data, String errMsg) {
        return RestResult.builder().withCode(code).withData(data).withMsg(errMsg).build();
    }

    public static <T> RestResult failedWithMsg(int code, String errMsg) {
        return RestResult.builder().withCode(code).withMsg(errMsg).build();
    }
}
