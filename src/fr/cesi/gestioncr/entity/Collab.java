package fr.cesi.gestioncr.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "collab")
public class Collab implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_collab;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private String email;
	@ManyToOne
	@JoinColumn(name="id_role")
	private Role role;
	
	public Long getId_collab() {
		return id_collab;
	}
	public void setId_collab(Long id_collab) {
		this.id_collab = id_collab;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
