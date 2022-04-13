package com.hb1;

public class Product {
private int prodid;
private String prodname;
private int cost;
private int qty;
public Product() {}
public Product(int prodid, String prodname, int cost, int qty) {
	this.prodid = prodid;
	this.prodname = prodname;
	this.cost = cost;
	this.qty = qty;
}
public int getProdid() {
	return prodid;
}
public void setProdid(int prodid) {
	this.prodid = prodid;
}
public String getProdname() {
	return prodname;
}
public void setProdname(String prodname) {
	this.prodname = prodname;
}
public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
@Override
public String toString() {
	return "Product [prodid=" + prodid + ", prodname=" + prodname + ", cost=" + cost + ", qty=" + qty + "]";
}
	


}
