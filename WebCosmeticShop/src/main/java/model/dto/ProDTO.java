package model.dto;

public class ProDTO {
	
	private String ProductGroupID;
	private String ProductID;
	private String ProductGroupName;
	private String CategoryID;
	private String CategoryName;
	private String BrandID;
	private String BrandName;
	private String CategoryGroupID;
	private String CategoryGroupName;
	private String Des;
	private String Manual;
	
	public String getProductGroupID() {
		return ProductGroupID;
	}
	public void setProductGroupID(String productGroupID) {
		ProductGroupID = productGroupID;
	}
	public String getProductID() {
		return ProductID;
	}
	public void setProductID(String productID) {
		ProductID = productID;
	}
	public String getProductGroupName() {
		return ProductGroupName;
	}
	public void setProductGroupName(String productGroupName) {
		ProductGroupName = productGroupName;
	}
	public String getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(String categoryID) {
		CategoryID = categoryID;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public String getBrandID() {
		return BrandID;
	}
	public void setBrandID(String brandID) {
		BrandID = brandID;
	}
	public String getBrandName() {
		return BrandName;
	}
	public void setBrandName(String brandName) {
		BrandName = brandName;
	}
	public String getCategoryGroupID() {
		return CategoryGroupID;
	}
	public void setCategoryGroupID(String categoryGroupID) {
		CategoryGroupID = categoryGroupID;
	}
	public String getCategoryGroupName() {
		return CategoryGroupName;
	}
	public void setCategoryGroupName(String categoryGroupName) {
		CategoryGroupName = categoryGroupName;
	}
	public String getDes() {
		return Des;
	}
	public void setDes(String des) {
		Des = des;
	}
	public String getManual() {
		return Manual;
	}
	public void setManual(String manual) {
		Manual = manual;
	}
	public String[] getSize() {
		return Size;
	}
	public void setSize(String[] size) {
		Size = size;
	}
	public String[] getPrice() {
		return Price;
	}
	public void setPrice(String[] price) {
		Price = price;
	}
	public Double[] getQuantity() {
		return Quantity;
	}
	public void setQuantity(Double[] quantity) {
		Quantity = quantity;
	}
	public String[] getImages() {
		return Images;
	}
	public void setImages(String[] images) {
		Images = images;
	}
	private String Size[];
	private String Price[];
	private Double Quantity[];
	private String Images[];

	
}
