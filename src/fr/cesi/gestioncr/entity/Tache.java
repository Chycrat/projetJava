package fr.cesi.gestioncr.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tache")
public class Tache implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_tache;
	private String nom_tache;
	private String description;
	private Date deadline;
	@ManyToOne
	@JoinColumn(name="id_reunion")
	private Reunion reunion;
	public Long getId_tache() {
		return id_tache;
	}
	public void setId_tache(Long id_tache) {
		this.id_tache = id_tache;
	}
	public String getNom_tache() {
		return nom_tache;
	}
	public void setNom_tache(String nom_tache) {
		this.nom_tache = nom_tache;
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
	public Reunion getReunion() {
		return reunion;
	}
	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}
	

	
}
