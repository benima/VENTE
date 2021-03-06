package com.g2l2corp.depotvente.model;

public class Produit {
	
	// Definition des ids:
	private static int idProduit = 0;
	
	// Les attributs
	//private String id;
	private int id;
	private String nomProduit;
	private int prixUnitaire;
	private int quantiteProduit;
	private int quantiteVendue;
	private boolean lot;
	private int prixLot;
	private Fournisseur proprietaire;
	private String commentaire;
	private boolean enVente;
	
	// Les Constructeurs:
	public Produit(int id, String nomProduit, int prixUnitaire,
			int quantiteProduit, boolean lot, int prixLot,
			Fournisseur proprietaire, String commentaire, boolean enVente) {
		this.id = id;
		this.idProduit++;
		this.nomProduit = nomProduit;
		this.prixUnitaire = prixUnitaire;
		this.quantiteProduit = quantiteProduit;
		this.lot = lot;
		this.prixLot = prixLot;
		this.proprietaire = proprietaire;
		this.commentaire = commentaire;
		this.enVente = false;
	}

	public Produit(int id, String nomProduit, int prixUnitaire,
			int quantiteProduit, int quantiteVendue,Fournisseur proprietaire, String commentaire) {
		this.id = id;
		this.idProduit++;
		this.nomProduit = nomProduit;
		this.prixUnitaire = prixUnitaire;
		this.quantiteProduit = quantiteProduit;
		this.quantiteVendue = quantiteVendue;
		this.proprietaire = proprietaire;
		this.commentaire = commentaire;
	}
	
	public Produit(String nomProduit, int prixUnitaire,
			int quantiteProduit, boolean lot, int prixLot,
			Fournisseur proprietaire, String commentaire, boolean enVente) {
		this.idProduit++;
		this.id = this.idProduit;
		this.nomProduit = nomProduit;
		this.prixUnitaire = prixUnitaire;
		this.quantiteProduit = quantiteProduit;
		this.lot = lot;
		this.prixLot = prixLot;
		this.proprietaire = proprietaire;
		this.commentaire = commentaire;
		this.enVente = false;
	}
	
	public Produit(String nomProduit, int prixVente,
			int quantiteProduit, Fournisseur proprietaire) {
		this.idProduit++;
		this.id = this.idProduit;
		this.nomProduit = nomProduit;
		this.prixUnitaire = prixVente;
		this.quantiteProduit = quantiteProduit;
		this.proprietaire = proprietaire;
		this.commentaire = "";
		this.enVente = false;
	}
	public Produit(String nomProduit, int prixVente,
			int quantiteProduit, Fournisseur proprietaire,String Comm) {
		this.idProduit++;
		this.id = this.idProduit;
		this.nomProduit = nomProduit;
		this.prixUnitaire = prixVente;
		this.quantiteProduit = quantiteProduit;
		this.proprietaire = proprietaire;
		this.commentaire =Comm;
	}
	
	public Produit(int id, String nomProduit, int prixVente,
			int quantiteProduit, Fournisseur proprietaire) {
		this.idProduit++;
		this.id = id;
		this.nomProduit = nomProduit;
		this.prixUnitaire = prixVente;
		this.quantiteProduit = quantiteProduit;
		this.proprietaire = proprietaire;
		this.commentaire = "";
		this.enVente = false;
	}
	
	// Getters et Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public int getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(int prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public int getQuantiteProduit() {
		return quantiteProduit;
	}

	public void setQuantiteProduit(int quantiteProduit) {
		this.quantiteProduit = quantiteProduit;
	}

	public int getQuantiteVendue() {
		return quantiteVendue;
	}

	public void setQuantiteVendue(int quantiteProduit) {
		this.quantiteVendue = quantiteProduit;
	}
	
	public boolean isLot() {
		return lot;
	}

	public void setLot(boolean lot) {
		this.lot = lot;
	}

	public Fournisseur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Fournisseur proprietaire) {
		this.proprietaire = proprietaire;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public boolean isEnVente() {
		return enVente;
	}

	public void setEnVente(boolean enVente) {
		this.enVente = enVente;
	}
	
	
	// Methode toString
	@Override
	public String toString() {
		return "Produit [id=" + this.id + ", nomProduit=" + nomProduit
				+ ", prixUnitaire=" + prixUnitaire + ", quantiteProduit="
				+ quantiteProduit + ", lot=" + lot
				+ ", proprietaire=" + proprietaire + ", commentaire="
				+ commentaire + ", enVente=" + enVente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((commentaire == null) ? 0 : commentaire.hashCode());
		result = prime * result + (enVente ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + (lot ? 1231 : 1237);
		result = prime * result
				+ ((nomProduit == null) ? 0 : nomProduit.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prixUnitaire);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((proprietaire == null) ? 0 : proprietaire.hashCode());
		result = prime * result + quantiteProduit;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		if (commentaire == null) {
			if (other.commentaire != null)
				return false;
		} else if (!commentaire.equals(other.commentaire))
			return false;
		if (enVente != other.enVente)
			return false;
		if (id != other.id)
			return false;
		if (lot != other.lot)
			return false;
		if (nomProduit == null) {
			if (other.nomProduit != null)
				return false;
		} else if (!nomProduit.equals(other.nomProduit))
			return false;
		if (Double.doubleToLongBits(prixUnitaire) != Double
				.doubleToLongBits(other.prixUnitaire))
			return false;
		if (proprietaire == null) {
			if (other.proprietaire != null)
				return false;
		} else if (!proprietaire.equals(other.proprietaire))
			return false;
		if (quantiteProduit != other.quantiteProduit)
			return false;
		return true;
	}

	public int getPrixLot() {
		return this.prixLot;
	}

}
