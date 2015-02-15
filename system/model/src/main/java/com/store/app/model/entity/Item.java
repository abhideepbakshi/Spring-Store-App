package com.store.app.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ITEM database table.
 * 
 */
@Entity
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ITEM_ID")
	private int itemId;

	@Column(name="ITEM_BAL")
	private int itemBal;

	@Column(name="ITEM_NAME")
	private String itemName;

	//bi-directional many-to-one association to SaleDetl
	@OneToMany(mappedBy="item")
	private List<SaleDetl> saleDetls;

	public Item() {
	}

	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemBal() {
		return this.itemBal;
	}

	public void setItemBal(int itemBal) {
		this.itemBal = itemBal;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public List<SaleDetl> getSaleDetls() {
		return this.saleDetls;
	}

	public void setSaleDetls(List<SaleDetl> saleDetls) {
		this.saleDetls = saleDetls;
	}

	public SaleDetl addSaleDetl(SaleDetl saleDetl) {
		getSaleDetls().add(saleDetl);
		saleDetl.setItem(this);

		return saleDetl;
	}

	public SaleDetl removeSaleDetl(SaleDetl saleDetl) {
		getSaleDetls().remove(saleDetl);
		saleDetl.setItem(null);

		return saleDetl;
	}

}