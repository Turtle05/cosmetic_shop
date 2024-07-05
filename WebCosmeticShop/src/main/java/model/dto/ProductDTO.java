package model.dto;

public class ProductDTO {
private String ProductGroupID;
private String ProductGroupName;
private String CategoryName;
private String BrandName;
private String Image;
private String CategoryGroupName;

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
public String getCategoryName() {
	return CategoryName;
}
public void setCategoryName(String categoryName) {
	CategoryName = categoryName;
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
public String getCategoryGroupName() {
	return CategoryGroupName;
}
public void setCategoryGroupName(String categoryGroupName) {
	CategoryGroupName = categoryGroupName;
}



}
