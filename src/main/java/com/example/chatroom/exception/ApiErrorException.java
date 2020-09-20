package com.example.chatroom.exception;

import com.example.chatroom.enums.ApiMsgEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiErrorException extends RuntimeException {
  private static final Logger logger = LoggerFactory.getLogger(ApiErrorException.class);
  private static final long serialVersionUID = 5801306119629043185L;

  /** 异常码 */
  private String code;
  /** 异常提示信息 */
  private String message;

  public ApiErrorException(ApiMsgEnum apiMsgEnum) {
    this.code = apiMsgEnum.getCode();
    this.message = apiMsgEnum.getMsg();
    logger.info("exception=" + apiMsgEnum.getCode()+"message="+apiMsgEnum.getCode());
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
