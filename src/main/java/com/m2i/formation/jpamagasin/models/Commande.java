package com.m2i.formation.jpamagasin.models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="commande")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Commande {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@Column(name="numero")
	private int numero;
	@Column(name="date")
	private Timestamp date;
	
	@ManyToMany
	@JoinTable(
			name="commande_has_produit",
			joinColumns= @JoinColumn(name = "commande_id", referencedColumnName = "id"),
			inverseJoinColumns= @JoinColumn(name = "produit_id", referencedColumnName = "id")
	)
	private List<Produit> produits;
}
