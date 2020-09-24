package com.example.chatroom.exception;

import com.example.chatroom.enums.ApiMsgEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Api401Exception extends ApiErrorException {
  private static final Logger logger = LoggerFactory.getLogger(Api401Exception.class);
  private static final long serialVersionUID = -6243356888723091381L;

  public Api401Exception(ApiMsgEnum apiMsgEnum) {
    super(apiMsgEnum);
    logger.info("exception=" + apiMsgEnum.getCode() + "message=" + apiMsgEnum.getCode());
  }
}
