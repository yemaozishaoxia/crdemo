package com.example.chatroom.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 用于封装AJAX调用以后的JSON返回值 其中正确返回值: {state:0, data:返回数据, message:错误消息} 错误返回值: {state:1, data:null,
 * message:错误消息}
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResult<T> {
  public static final Logger logger = LoggerFactory.getLogger(JsonResult.class);
  /** 返回是否成功的状态, 0表示成功, 1或其他值 表示失败 */
  private String code;
  /** 成功时候,返回的JSON数据 */
  private T data;
  /** 是错误时候的错误消息 */
  private String msg;

  public JsonResult(String code, T data, String msg) {
    this.code = code;
    this.data = data;
    this.msg = msg;
  }

  /** 若没有数据返回，默认状态码为0，提示信息为：操作成功！ */
  public JsonResult() {
    this.code = "0";
    this.msg = "操作成功！";
  }

  /**
   * 若没有数据返回，可以人为指定状态码和提示信息
   *
   * @param code
   * @param msg
   */
  public JsonResult(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  /**
   * 有数据返回时，状态码为0，默认提示信息为：操作成功！
   *
   * @param data
   */
  public JsonResult(T data) {
    this.data = data;
    this.code = "0";
    this.msg = "操作成功！";
  }

  /**
   * 有数据返回，状态码为0，人为指定提示信息
   *
   * @param data
   * @param msg
   */
  public JsonResult(T data, String msg) {
    this.data = data;
    this.code = "0";
    this.msg = msg;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  @Override
  public String toString() {
    return "JsonResult{" + "code='" + code + '\'' + ", data=" + data + ", msg='" + msg + '\'' + '}';
  }
}
