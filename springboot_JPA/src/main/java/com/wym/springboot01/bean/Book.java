package com.wym.springboot01.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Table(name = "t_book")
@Proxy(lazy = false)
@Entity
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bid")
	private int bid;

	@Column(name = "bname")
	private String bname;

	@Column(name = "price")
	private double price;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getBid() {
		return bid;
	}

	public String getBname() {
		return bname;
	}

	public double getPrice() {
		return price;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
