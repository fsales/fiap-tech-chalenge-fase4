package br.com.fsales.nexstream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = TestMongoConfig.class)
class NexStreamApplicationTests {

	@Autowired
	private ReactiveMongoTemplate reactiveMongoTemplate;

	@Test
	void contextLoads() {

	}
}