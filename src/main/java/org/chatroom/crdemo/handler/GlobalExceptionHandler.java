package org.chatroom.crdemo.handler;

import org.chatroom.crdemo.enums.ApiMsgEnum;
import org.chatroom.crdemo.exception.*;
import org.chatroom.crdemo.pojo.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler  {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * 拦截业务异常，返回业务异常信息
     * @param ex
     * @return
     */
    @ExceptionHandler(Api400Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JsonResult handleApi400(ApiErrorException ex) {
        String code = ex.getCode();
        String message = ex.getMessage();
        return new JsonResult(code, message);
    }

    @ExceptionHandler(Api401Exception.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public JsonResult handleApi401(ApiErrorException ex) {
        String code = ex.getCode();
        String message = ex.getMessage();
        return new JsonResult(code, message);
    }

    @ExceptionHandler(Api403Exception.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public JsonResult handleApi403(ApiErrorException ex) {
        String code = ex.getCode();
        String message = ex.getMessage();
        return new JsonResult(code, message);
    }
    @ExceptionHandler(Api404Exception.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public JsonResult handleApi404(ApiErrorException ex) {
        String code = ex.getCode();
        String message = ex.getMessage();
        return new JsonResult(code, message);
    }

    @ExceptionHandler(Api500Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleApi500(ApiErrorException ex) {
        String code = ex.getCode();
        String message = ex.getMessage();
        return new JsonResult(code, message);
    }
}
