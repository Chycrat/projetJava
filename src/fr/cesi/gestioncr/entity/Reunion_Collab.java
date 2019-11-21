package fr.cesi.gestioncr.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reunion_collab")
public class Reunion_Collab implements Serializable {
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_collab")
	private Collab collab;
	@Id
	@ManyToOne
	@JoinColumn(name="id_reunion")
	private Reunion reunion;
	public Collab getCollab() {
		return collab;
	}
	public void setCollab(Collab collab) {
		this.collab = collab;
	}
	public Reunion getReunion() {
		return reunion;
	}
	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}
	
}
