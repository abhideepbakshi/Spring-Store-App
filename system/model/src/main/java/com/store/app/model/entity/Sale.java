package com.store.app.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SALE database table.
 * 
 */
@Entity
@NamedQuery(name="Sale.findAll", query="SELECT s FROM Sale s")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SALE_ID")
	private int saleId;

	private double discount;

	@Temporal(TemporalType.DATE)
	@Column(name="SALE_DATE")
	private Date saleDate;

	@Column(name="TOTAL_AMT")
	private double totalAmt;

	@Column(name="VAT_AMT")
	private double vatAmt;

	@Column(name="VAT_RATE")
	private double vatRate;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUST_ID")
	private Customer customer;

	//bi-directional many-to-one association to SaleDetl
	@OneToMany(mappedBy="sale")
	private List<SaleDetl> saleDetls;

	public Sale() {
	}

	public int getSaleId() {
		return this.saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public double getDiscount() {
		return this.discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Date getSaleDate() {
		return this.saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public double getTotalAmt() {
		return this.totalAmt;
	}

	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}

	public double getVatAmt() {
		return this.vatAmt;
	}

	public void setVatAmt(double vatAmt) {
		this.vatAmt = vatAmt;
	}

	public double getVatRate() {
		return this.vatRate;
	}

	public void setVatRate(double vatRate) {
		this.vatRate = vatRate;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<SaleDetl> getSaleDetls() {
		return this.saleDetls;
	}

	public void setSaleDetls(List<SaleDetl> saleDetls) {
		this.saleDetls = saleDetls;
	}

	public SaleDetl addSaleDetl(SaleDetl saleDetl) {
		getSaleDetls().add(saleDetl);
		saleDetl.setSale(this);

		return saleDetl;
	}

	public SaleDetl removeSaleDetl(SaleDetl saleDetl) {
		getSaleDetls().remove(saleDetl);
		saleDetl.setSale(null);

		return saleDetl;
	}

}