package com.inti.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	@Column(unique = true)
	private String username;
	private String password;
	private String sexe;
	private String commentaire;
	
	private boolean enabled = true;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@Lob
	private byte[] image;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "profil", joinColumns = {
			@JoinColumn(name = "id_utilisateur", referencedColumnName = "idUtilisateur") }, inverseJoinColumns = {
					@JoinColumn(name = "id_role", table = "role", referencedColumnName = "idRole") })
	private Set<Role> roles = new HashSet<>();

	public Utilisateur() {
	}



	public Utilisateur(String nomUtilisateur, String prenomUtilisateur, String username, String password, String sexe,
			String commentaire, Date dateNaissance, Set<Role> roles) {
		super();
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.username = username;
		this.password = password;
		this.sexe = sexe;
		this.commentaire = commentaire;
		this.dateNaissance = dateNaissance;
		this.roles = roles;
	}



	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	

	public String getSexe() {
		return sexe;
	}



	public void setSexe(String sexe) {
		this.sexe = sexe;
	}



	public String getCommentaire() {
		return commentaire;
	}



	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}



	@Override
	public String toString() {
		return "Utilisateur [nomUtilisateur=" + nomUtilisateur + ", prenomUtilisateur=" + prenomUtilisateur
				+ ", username=" + username + ", password=" + password + ", enabled=" + enabled + ", dateNaissance="
				+ dateNaissance + ", image=" + Arrays.toString(image) + "]";
	}

}
