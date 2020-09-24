package com.example.chatroom.exception;

import com.example.chatroom.enums.ApiMsgEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Api404Exception extends ApiErrorException {
  private static final Logger logger = LoggerFactory.getLogger(Api404Exception.class);
  private static final long serialVersionUID = 4109282900681088055L;

  public Api404Exception(ApiMsgEnum apiMsgEnum) {
    super(apiMsgEnum);
    logger.info("exception=" + apiMsgEnum.getCode() + "message=" + apiMsgEnum.getCode());
  }
}
