package com.demo.mykine.springtxjpa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.demo.mykine")
@SpringBootTest
class SpringTxJpaApplicationTests {

	@Test
	void contextLoads() {
	}

}
