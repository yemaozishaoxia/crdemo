package org.chatroom.crdemo.exception;

import org.chatroom.crdemo.enums.ApiMsgEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class Api500Exception extends ApiErrorException {
  private static final Logger logger = LoggerFactory.getLogger(Api500Exception.class);
  private static final long serialVersionUID = 3194996568714838712L;

  public Api500Exception(ApiMsgEnum apiMsgEnum) {
    super(apiMsgEnum);
    logger.info("exception=" + apiMsgEnum.getCode() + "message=" + apiMsgEnum.getCode());
  }
}
