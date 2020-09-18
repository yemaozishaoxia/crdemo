package org.chatroom.crdemo.exception;

import org.chatroom.crdemo.enums.ApiMsgEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;


public class Api403Exception extends ApiErrorException  {
  private static final Logger logger = LoggerFactory.getLogger(Api403Exception.class);
  private static final long serialVersionUID = 4316030327356499847L;


  public Api403Exception(ApiMsgEnum apiMsgEnum) {
    super(apiMsgEnum);
    logger.info("exception=" + apiMsgEnum.getCode() + "message=" + apiMsgEnum.getCode());
  }
}
