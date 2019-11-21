package fr.cesi.gestioncr.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tache")
public class Tache implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nom;
	private String description;
	private Date deadline;
	@ManyToMany(mappedBy="tache")
	private Collection<Collab> collabs;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public Long getId() {
		return id;
	}
	public Collection<Collab> getCollabs() {
		return collabs;
	}
	public void setCollabs(Collection<Collab> collabs) {
		this.collabs = collabs;
	}
	
	
}