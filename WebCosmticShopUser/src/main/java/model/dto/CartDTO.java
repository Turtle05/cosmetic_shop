package model.dto;

public class CartDTO {

	private String CartID;
	private String ProductGroupName;
	private double  Price;
	private int  Quantity;
	private String ProductID;
	private String Size;
	private int SQuantity;
	private String Image;
	private String PGNAME;
	
	public int getSQuantity() {
		return SQuantity;
	}
	public void setSQuantity(int sQuantity) {
		SQuantity = sQuantity;
	}
	
	public String getCartID() {
		return CartID;
	}
	public void setCartID(String cartID) {
		CartID = cartID;
	}
	public String getProductGroupName() {
		return ProductGroupName;
	}
	public void setProductGroupName(String productGroupName) {
		ProductGroupName = productGroupName;
	}


	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getProductID() {
		return ProductID;
	}
	public void setProductID(String productID) {
		ProductID = productID;
	}
	public String getSize() {
		return Size;
	}
	public void setSize(String size) {
		Size = size;
	}
	
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getPGNAME() {
		return PGNAME;
	}
	public void setPGNAME(String pGNAME) {
		PGNAME = pGNAME;
	}
	
	
	
}
