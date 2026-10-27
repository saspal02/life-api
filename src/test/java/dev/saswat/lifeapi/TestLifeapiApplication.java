package dev.saswat.lifeapi;

import org.springframework.boot.SpringApplication;

public class TestLifeapiApplication {

	public static void main(String[] args) {
		SpringApplication.from(LifeapiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
