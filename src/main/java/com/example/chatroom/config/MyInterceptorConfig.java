package com.example.chatroom.config;

import com.example.chatroom.interceptor.AuthenticationInterceptor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class MyInterceptorConfig extends WebMvcConfigurationSupport {
  @Bean
  public AuthenticationInterceptor getAuthenticationInterceptor() {
    return new AuthenticationInterceptor();
  }

  @Bean
  public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
    MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    jsonConverter.setObjectMapper(objectMapper);
    return jsonConverter;
  }

  @Override
  protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    ObjectMapper objectMapper = new ObjectMapper();
    SimpleModule module = new SimpleModule();
    module.addSerializer(new ToStringSerializer(Long.TYPE));
    module.addSerializer(new ToStringSerializer(Long.class));
    module.addSerializer(new ToStringSerializer(BigInteger.class));
    objectMapper
        .getSerializerProvider()
        .setNullValueSerializer(
            new JsonSerializer<Object>() {
              @Override
              public void serialize(
                  Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
                  throws IOException {
                jsonGenerator.writeString("");
              }
            });
    objectMapper.registerModule(module);
    converter.setObjectMapper(objectMapper);
  }

  @Override
  protected void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(getAuthenticationInterceptor()).addPathPatterns("/**");
    super.addInterceptors(registry);
  }
  /**
   * 用来指定静态资源不被拦截，否则继承WebMvcConfigurationSupport这种方式会导致静态资源无法直接访问
   *
   * @param registry
   */
  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    super.addResourceHandlers(registry);
  }
}
