package br.com.fsales.nexstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
@EnableReactiveMongoAuditing
public class NexStreamApplication {

//	static {
//		BlockHound.install();
//	}

    public static void main(String[] args) {
        SpringApplication.run(NexStreamApplication.class, args);
    }

}
