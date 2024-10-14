package com.takima.backskeleton;

import com.takima.backskeleton.dao.LivreDao;
import com.takima.backskeleton.exceptions.ServiceException;
import com.takima.backskeleton.models.Livres;
import com.takima.backskeleton.services.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

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
