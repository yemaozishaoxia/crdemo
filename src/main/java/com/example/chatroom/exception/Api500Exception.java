package com.example.chatroom.exception;

import com.example.chatroom.enums.ApiMsgEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Api500Exception extends ApiErrorException {
  private static final Logger logger = LoggerFactory.getLogger(Api500Exception.class);
  private static final long serialVersionUID = 3194996568714838712L;

  public Api500Exception(ApiMsgEnum apiMsgEnum) {
    super(apiMsgEnum);
    logger.info("exception=" + apiMsgEnum.getCode() + "message=" + apiMsgEnum.getCode());
  }
}
