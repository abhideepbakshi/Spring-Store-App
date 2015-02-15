package com.store.app.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SALE_DETL database table.
 * 
 */
@Entity
@Table(name="SALE_DETL")
@NamedQuery(name="SaleDetl.findAll", query="SELECT s FROM SaleDetl s")
public class SaleDetl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SALE_DETL_ID")
	private int saleDetlId;

	private double quantity;

	private double rate;

	@Column(name="VAT_RATE")
	private double vatRate;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="ITEM_ID")
	private Item item;

	//bi-directional many-to-one association to Sale
	@ManyToOne
	@JoinColumn(name="SALE_ID")
	private Sale sale;

	public SaleDetl() {
	}

	public int getSaleDetlId() {
		return this.saleDetlId;
	}

	public void setSaleDetlId(int saleDetlId) {
		this.saleDetlId = saleDetlId;
	}

	public double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getVatRate() {
		return this.vatRate;
	}

	public void setVatRate(double vatRate) {
		this.vatRate = vatRate;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Sale getSale() {
		return this.sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

}