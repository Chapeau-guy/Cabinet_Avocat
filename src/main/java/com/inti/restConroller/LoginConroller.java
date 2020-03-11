package com.inti.restConroller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Utilisateur;
import com.inti.service.interfaces.IUtilisateurService;

@RestController
@RequestMapping(value = "/login")
public class LoginConroller {
	@Autowired
	IUtilisateurService utilisateurService;
	
	public Utilisateur login(Principal principal) {
		return utilisateurService.findOneByUsername(principal.getName());
	}
}
