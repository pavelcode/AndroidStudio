package com.cblue.thirdparty.pay.shoppingcart;


public class Goods {
	public Goods(boolean state, String id, String name, String price, int number) {
		super();
		this.state = state;
		this.id = id;
		this.name = name;
		this.price = price;
		this.number = number;
	}


	private String id;
	private String name;
	private int number;
	private String price;
	private boolean state;//是否被选中

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}



}
