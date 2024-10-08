package com.takima.backskeleton;

import com.takima.backskeleton.models.Utilisateur;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BackSkeletonApplicationTests {

	@Test
	void contextLoads() {
	}

//	@Test
//	void testGettersAndSetters() {
//		// Créer une instance de Utilisateur
//		Utilisateur utilisateur = new Utilisateur();
//
//		// Définir les valeurs
//		utilisateur.setId_utilisateur(1L);
//		utilisateur.setNom("Dupont");
//		utilisateur.setPrenom("Jean");
//		utilisateur.setPseudo("jdupont");
//		utilisateur.setMail("j.dupont@example.com");
//		utilisateur.setDatenaissance(LocalDate.of(1990, 1, 1));
//
//		// Vérifier les valeurs
//		assertEquals(1L, utilisateur.getId_utilisateur());
//		assertEquals("Dupont", utilisateur.getNom());
//		assertEquals("Jean", utilisateur.getPrenom());
//		assertEquals("jdupont", utilisateur.getPseudo());
//		assertEquals("j.dupont@example.com", utilisateur.getMail());
//		assertEquals(LocalDate.of(1990, 1, 1), utilisateur.getDatenaissance());
//	}
//
//	@Test
//	void testConstructor() {
//		// Utiliser le constructeur pour créer un Utilisateur
//		Utilisateur utilisateur = new Utilisateur("Dupont", "Jean", "jdupont", "j.dupont@example.com", LocalDate.of(1990, 1, 1));
//
//		// Vérifier les valeurs
//		assertEquals("Dupont", utilisateur.getNom());
//		assertEquals("Jean", utilisateur.getPrenom());
//		assertEquals("jdupont", utilisateur.getPseudo());
//		assertEquals("j.dupont@example.com", utilisateur.getMail());
//		assertEquals(LocalDate.of(1990, 1, 1), utilisateur.getDatenaissance());
//	}
}
