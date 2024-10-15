package com.takima.backskeleton;

import com.takima.backskeleton.services.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackSkeletonApplication {

	private final LivreService livreService;
	@Autowired BackSkeletonApplication(LivreService livreService){
		this.livreService = livreService;
	}

	public static void main(String[] args) {
		SpringApplication.run(BackSkeletonApplication.class, args);
	}

}
