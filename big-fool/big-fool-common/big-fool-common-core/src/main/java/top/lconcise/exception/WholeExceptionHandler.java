package top.lconcise.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import top.lconcise.model.RestResult;
import top.lconcise.model.RestResultUtils;

import java.util.List;

/**
 * @author liusj
 * @date 2020/11/9
 * <p>
 * 全局异常统一处理.
 */
@ControllerAdvice
public class WholeExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WholeExceptionHandler.class);

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    private RestResult handleException(Exception e) {
        LOGGER.error("Exception: " + e);
        return RestResultUtils.failed(e.getMessage());
    }

//    /**
//     * AccessDeniedException
//     * @param e the e
//     * @return R
//     */
//    @ExceptionHandler(AccessDeniedException.class)
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public RestResult handleAccessDeniedException(AccessDeniedException e) {
//        String msg = SpringSecurityMessageSource.getAccessor().getMessage("AbstractAccessDecisionManager.accessDenied",
//                e.getMessage());
//        log.error("拒绝授权异常信息 ex={}", msg, e);
//        return R.failed(e.getLocalizedMessage());
//    }

    /**
     * validation Exception
     *
     * @param exception
     * @return R
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestResult handleBodyValidException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        LOGGER.warn("参数绑定异常,ex = {}", fieldErrors.get(0).getDefaultMessage());
        return RestResultUtils.failed(fieldErrors.get(0).getDefaultMessage());
    }

    /**
     * validation Exception (以form-data形式传参)
     *
     * @param exception
     * @return R
     */
    @ExceptionHandler({BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestResult bindExceptionHandler(BindException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        LOGGER.warn("参数绑定异常,ex = {}", fieldErrors.get(0).getDefaultMessage());
        return RestResultUtils.failed(fieldErrors.get(0).getDefaultMessage());
    }
}
