package com.condominio.apicondominio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


@SpringBootTest
class ApicondominioApplicationTests {

	@Test
	void contextLoads() {
		assertDoesNotThrow(() ->ApicondominioApplication.main(new String[]{}));
	}

}
