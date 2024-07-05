package model.bean;

public class Product {
private String ProductID;
private String ProductName;
private String Size;
private Double Price;
private int Quantity;
private String ProductGroupID;
private String Image;
public String getProductID() {
	return ProductID;
}
public void setProductID(String productID) {
	ProductID = productID;
}
public String getProductName() {
	return ProductName;
}
public void setProductName(String productName) {
	ProductName = productName;
}
public String getSize() {
	return Size;
}
public void setSize(String size) {
	Size = size;
}
public String getProductGroupID() {
	return ProductGroupID;
}
public void setProductGroupID(String productGroupID) {
	ProductGroupID = productGroupID;
}
public String getImage() {
	return Image;
}
public void setImage(String image) {
	Image = image;
}
public Double getPrice() {
	return Price;
}
public void setPrice(Double price) {
	Price = price;
}
public int getQuantity() {
	return Quantity;
}
public void setQuantity(int quantity) {
	Quantity = quantity;
}


}
