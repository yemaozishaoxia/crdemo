package org.chatroom.crdemo.exception;

import org.chatroom.crdemo.enums.ApiMsgEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;


public class Api400Exception extends ApiErrorException  {
  private static final Logger logger = LoggerFactory.getLogger(Api400Exception.class);
  private static final long serialVersionUID = -4328565419581216737L;


  public Api400Exception(ApiMsgEnum apiMsgEnum) {
    super(apiMsgEnum);
    logger.info("exception=" + apiMsgEnum.getCode() + "message=" + apiMsgEnum.getCode());
  }
}
