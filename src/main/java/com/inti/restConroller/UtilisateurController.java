package com.inti.restConroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Role;
import com.inti.entities.Utilisateur;
import com.inti.entities.Utilisateur;
import com.inti.service.interfaces.IUtilisateurService;

@RestController
public class UtilisateurController {
	@Autowired
	IUtilisateurService userService;

	@RequestMapping(value = "users", method = RequestMethod.GET)
	public List<Utilisateur> findAll() {
		return userService.findAll();
	}

	@RequestMapping(value = "users/{idUtilisateur}", method = RequestMethod.GET)
	public Utilisateur findOne(@PathVariable("idUtilisateur") Long id) {
		return userService.findOne(id);
	}

	@RequestMapping(value = "users", method = RequestMethod.POST)
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur user) {
		return userService.save(user);
	}

	@RequestMapping(value = "users/{idUtilisateur}", method = RequestMethod.DELETE)
	public void deleteUtilisateur(@PathVariable("idUtilisateur") Long id) {
		userService.delete(id);
	}
	@RequestMapping(value = "users/{idUtilisateur}", method = RequestMethod.PUT)
	public Utilisateur updateUtilisateur(@PathVariable("idUtilisateur") Long id, @RequestBody Utilisateur user) {
		Utilisateur currentUtilisateur= userService.findOne(id);
		currentUtilisateur.setNomUtilisateur(user.getNomUtilisateur());
		currentUtilisateur.setPrenomUtilisateur(user.getPrenomUtilisateur());
		currentUtilisateur.setUsername(user.getUsername());
		currentUtilisateur.setPassword(user.getPassword());
		currentUtilisateur.setDateNaissance(user.getDateNaissance());
		currentUtilisateur.setImage(user.getImage());
		currentUtilisateur.setRoles(user.getRoles());
		return userService.save(currentUtilisateur);
	}
}
