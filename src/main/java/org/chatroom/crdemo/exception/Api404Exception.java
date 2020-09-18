package org.chatroom.crdemo.exception;

import org.chatroom.crdemo.enums.ApiMsgEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;


public class Api404Exception extends ApiErrorException {
  private static final Logger logger = LoggerFactory.getLogger(Api404Exception.class);
  private static final long serialVersionUID = 4109282900681088055L;


  public Api404Exception(ApiMsgEnum apiMsgEnum) {
    super(apiMsgEnum);
    logger.info("exception=" + apiMsgEnum.getCode() + "message=" + apiMsgEnum.getCode());
  }
}
