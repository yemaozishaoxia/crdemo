package org.chatroom.crdemo.exception;

import org.chatroom.crdemo.enums.ApiMsgEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;


public class Api401Exception extends ApiErrorException {
  private static final Logger logger = LoggerFactory.getLogger(Api401Exception.class);
  private static final long serialVersionUID = -6243356888723091381L;

  public Api401Exception(ApiMsgEnum apiMsgEnum) {
    super(apiMsgEnum);
    logger.info("exception=" + apiMsgEnum.getCode() + "message=" + apiMsgEnum.getCode());
  }
}
