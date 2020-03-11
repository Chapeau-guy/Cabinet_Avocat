package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Utilisateur;
import com.inti.repositories.UtilisateurRepository;
import com.inti.service.interfaces.IUtilisateurService;

@Service
public class UtilisateurService implements IUtilisateurService {
	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Override
	public List<Utilisateur> findAll() {
		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur findOne(Long id) {
		return utilisateurRepository.findOne(id);
	}

	@Override
	public Utilisateur save(Utilisateur user) {

		return utilisateurRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		utilisateurRepository.delete(id);

	}

	@Override
	public Utilisateur findOneByUsername(String username) {
		
		return utilisateurRepository.findOneByUsername(username);
	}

}
