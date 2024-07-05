package model.dto;

public class ProductDTO {
	private String ProductGroupID;
	private String ProductGroupName;
	private String ProductGroup;
	private String CategoryName;
	private float  Price;
	private String BrandName;
	private String Image;
	private String ProductID;
	

	public String getProductID() {
		return ProductID;
	}

	public void setProductID(String productID) {
		ProductID = productID;
	}

	public String getProductGroupID() {
		return ProductGroupID;
	}

	public void setProductGroupID(String productGroupID) {
		ProductGroupID = productGroupID;
	}

	public String getProductGroupName() {
		return ProductGroupName;
	}

	public void setProductGroupName(String productGroupName) {
		ProductGroupName = productGroupName;
	}

	public String getProductGroup() {
		return ProductGroup;
	}

	public void setProductGroup(String productGroup) {
		ProductGroup = productGroup;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public String getBrandName() {
		return BrandName;
	}

	public void setBrandName(String brandName) {
		BrandName = brandName;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

}
