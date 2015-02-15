package com.store.app.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ADDRESS database table.
 * 
 */
@Entity
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ADDR_ID")
	private int addrId;

	private String address;

	private String city;

	private String state;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUST_ID")
	private Customer customer;

	public Address() {
	}

	public int getAddrId() {
		return this.addrId;
	}

	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}