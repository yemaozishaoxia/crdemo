package org.chatroom.crdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.chatroom.crdemo.dao")
public class CrdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrdemoApplication.class, args);
	}

}
