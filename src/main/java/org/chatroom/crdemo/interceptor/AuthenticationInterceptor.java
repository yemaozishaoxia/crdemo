package org.chatroom.crdemo.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import org.chatroom.crdemo.annotation.UnInterception;
import org.chatroom.crdemo.entity.User;
import org.chatroom.crdemo.enums.ApiMsgEnum;
import org.chatroom.crdemo.exception.Api401Exception;
import org.chatroom.crdemo.exception.ApiErrorException;
import org.chatroom.crdemo.service.UserService;
import org.chatroom.crdemo.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

public class AuthenticationInterceptor implements HandlerInterceptor {
  private static final Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);

  @Autowired
  private UserService userService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    // 如果不是映射到方法直接通过,有可能是ResourceHttpRequestHandler
    if (!(handler instanceof HandlerMethod)) {
      return true;
    }
    HandlerMethod handlerMethod = (HandlerMethod) handler;
    Method method = handlerMethod.getMethod();
    String methodName = method.getName();
    logger.info("====拦截到了方法：{}，在该方法执行之前执行====", methodName);

    // 通过方法，可以获取该方法上的自定义注解，然后通过注解来判断该方法是否要被拦截
    // @UnInterception 是我们自定义的注解
    UnInterception unInterception = method.getAnnotation(UnInterception.class);
    if (null != unInterception) {
      return true;
    }
    String token = request.getHeader("Authorization");
    logger.info("Authorization:" + token);
    // 执行认证
    if (token == null) {
      logger.info("Authorization为空，未登录");
      throw new Api401Exception(ApiMsgEnum.AuthenticationNull_EXCEPTION);
    }
// 获取 token 中的 username
    String username;
    try {
      username = JWT.decode(token).getClaim("username").asString();
    } catch (Exception e) {
      logger.info("Authentication超时");
      throw new Api401Exception(ApiMsgEnum.AuthenticationOverTime_EXCEPTION);
    }
    System.out.println(username);
    User return_user = userService.findUserByUsername(username);

    if (return_user==null){
      logger.info(username+"用户不存在");
      throw new Api401Exception(ApiMsgEnum.UserNotExist_EXCEPTION);
    }
    Boolean verify = JwtUtil.isVerify(token, return_user);
    if (!verify) {
      logger.info("Authentication不正确");
      throw new Api401Exception(ApiMsgEnum.AuthenticationNotCorrect_EXCEPTION);
    }else {
      logger.info("Authentication正确。"+"用户是"+username);
    }
    return true;
  }

  @Override
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      ModelAndView modelAndView)
      throws Exception {}

  @Override
  public void afterCompletion(
      HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {}
}
