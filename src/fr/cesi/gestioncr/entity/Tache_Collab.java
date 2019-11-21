package fr.cesi.gestioncr.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tache_collab")
public class Tache_Collab implements Serializable {
	
	@Id
	@ManyToOne
	@JoinColumn(name="collab_id")
	private Collab collab;
	@Id
	@ManyToOne
	@JoinColumn(name="tache_id")
	private Tache tache;
	public Collab getCollab() {
		return collab;
	}
	public void setCollab(Collab collab) {
		this.collab = collab;
	}
	public Tache getTache() {
		return tache;
	}
	public void setTache(Tache tache) {
		this.tache = tache;
	}

}
