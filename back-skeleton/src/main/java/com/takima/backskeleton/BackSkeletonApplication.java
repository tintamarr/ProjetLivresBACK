package com.takima.backskeleton;

import com.takima.backskeleton.dao.LivreDAO;
import com.takima.backskeleton.models.Livres;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class BackSkeletonApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackSkeletonApplication.class, args);

		Livres livre = new Livres("bob", "bib", "bobo", "aaa", LocalDate.parse("2002-05-02"),LocalDate.parse("2002-05-01"), 5.0);
		System.out.println(livre.toString());


	}

}
