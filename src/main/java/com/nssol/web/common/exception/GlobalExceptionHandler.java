package com.nssol.web.common.exception;



import com.nssol.web.common.constants.ResultCodeEnum;
import com.nssol.web.common.util.ExceptionUtil;
import com.nssol.web.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局统一异常
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 未知异常
     * @param e 异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R unknownError(Exception e){
        //记录错误日志，并打印堆栈信息
        log.error(ExceptionUtil.getMessage(e));
        return R.setResult(ResultCodeEnum.UNKNOWN_REASON);
    }
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public R AccessDeniedError(AccessDeniedException e){
        //记录错误日志，并打印堆栈信息
        log.error(ExceptionUtil.getMessage(e));
        return R.setResult(ResultCodeEnum.NO_CORRESPONDING_PERMISSION);
    }

    /**
     * 全局自定义异常
     * @param e 异常
     */
    @ExceptionHandler(value = SkyBootException.class)
    @ResponseBody
    public R customException(SkyBootException e){
        //记录错误日志，并打印堆栈信息
        log.error(ExceptionUtil.getMessage(e));
        return  R.error().message(e.getMessage()).code(e.getCode());
    }
}
