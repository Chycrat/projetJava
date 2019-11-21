package fr.cesi.gestioncr.entity;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Reunion_Collab implements Serializable {
	
	@ManyToOne
	@JoinColumn(name="collab_id")
	private Collab collab;
	@ManyToOne
	@JoinColumn(name="reunion_id")
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
