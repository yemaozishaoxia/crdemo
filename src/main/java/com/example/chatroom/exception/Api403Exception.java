package com.example.chatroom.exception;

import com.example.chatroom.enums.ApiMsgEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Api403Exception extends ApiErrorException {
  private static final Logger logger = LoggerFactory.getLogger(Api403Exception.class);
  private static final long serialVersionUID = 4316030327356499847L;

  public Api403Exception(ApiMsgEnum apiMsgEnum) {
    super(apiMsgEnum);
    logger.info("exception=" + apiMsgEnum.getCode() + "message=" + apiMsgEnum.getCode());
  }
}
