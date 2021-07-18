package com.demo.mykine.springtxjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.demo.mykine.springtxjpa.dao")
@SpringBootApplication
public class SpringTxJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTxJpaApplication.class, args);
	}

}
