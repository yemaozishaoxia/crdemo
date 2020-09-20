package com.example.chatroom.exception;

import com.example.chatroom.enums.ApiMsgEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Api400Exception extends ApiErrorException  {
  private static final Logger logger = LoggerFactory.getLogger(Api400Exception.class);
  private static final long serialVersionUID = -4328565419581216737L;


  public Api400Exception(ApiMsgEnum apiMsgEnum) {
    super(apiMsgEnum);
    logger.info("exception=" + apiMsgEnum.getCode() + "message=" + apiMsgEnum.getCode());
  }
}
