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
@Table(name = "reunion")
public class Reunion implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_reunion;
	private Date date;
	private String lieu;
	private String objectif;
	private String compte_rendu;
//	@ManyToMany(mappedBy="reunion")
//	private Collection<Collab> collab;
	public Long getId_reunion() {
		return id_reunion;
	}
	public void setId_reunion(Long id_reunion) {
		this.id_reunion = id_reunion;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getObjectif() {
		return objectif;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
	public String getCompte_rendu() {
		return compte_rendu;
	}
	public void setCompte_rendu(String compte_rendu) {
		this.compte_rendu = compte_rendu;
	}

	
	
}
