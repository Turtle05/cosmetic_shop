package model.bo;



import common.StringCommon;
import common.ValidateCommon;
import model.dao.CreateCategoryDAO;


public class CreateCategoryBO {
	CreateCategoryDAO createCategoryDAO = new CreateCategoryDAO();
	

	
	

	public String insertCat(String catName, String catGroupName) {
		String returnedString = null;
		
		String tempValidate = ValidateCommon.checkRequiredFieldsTest(catName, catGroupName);

        if (!"No Error".equals(tempValidate)) {

                return tempValidate;

        }
        
		for (int i = 1; i <= 10; i++) { // Lặp tối đa 10 lần:

			String lastestCatID = createCategoryDAO.getLastestCatID();
			System.out.println("mã danh mục =" + lastestCatID);
			// Tách Ma và stt ra riêng
			// Tăng số thứ tự lên 1
			// Gộp stt với Ma
			// Truyền mã hh mới vào createProductDAO.insertProduct

			if (lastestCatID == null) {
				lastestCatID = "Cat001";
			} else {
				long orderNumber = Long.valueOf(lastestCatID.substring(3, 6));
				 ++orderNumber;
				 lastestCatID = "Cat" + StringCommon.convertNumberToString(orderNumber, 3);
			}

			String returnedMessage = createCategoryDAO.insertCat(lastestCatID, catName, catGroupName);

			System.out.println("Lần " + i + " --- lastestMaHH --- " + lastestCatID + " --- returnedMessage --- " + returnedMessage);
			
			if ("Duplicate ID Error".equals(returnedMessage)) {
				returnedString = "Duplicate ID Error";
				continue;

			} else if ("No Error".equals(returnedMessage)) {
				returnedString = "No Error";
				break;

			}
			
		}
		return returnedString;
	}

	public String insertCatGroup(String catGroupName) {
		String returnedString = null;
		
		String tempValidate = ValidateCommon.checkRequiredFieldsTest(catGroupName);

        if (!"No Error".equals(tempValidate)) {

                return tempValidate;

        }
		for (int i = 1; i <= 10; i++) { // Lặp tối đa 10 lần:

			String lastestCatGroupID = createCategoryDAO.getLastestCatGroupID();
			System.out.println("mã danh mục =" + lastestCatGroupID);


			if (lastestCatGroupID == null) {
				lastestCatGroupID = "CaG001";
			} else {
				long orderNumber = Long.valueOf(lastestCatGroupID.substring(3, 6));
				 ++orderNumber;
				 lastestCatGroupID = "CaG" + StringCommon.convertNumberToString(orderNumber, 3);
			}

			String returnedMessage = createCategoryDAO.insertCatGroup(lastestCatGroupID, catGroupName);

			System.out.println("Lần " + i + " --- lastestMaHH --- " + lastestCatGroupID + " --- returnedMessage --- " + returnedMessage);
			
			if ("Duplicate ID Error".equals(returnedMessage)) {
				returnedString = "Duplicate ID Error";
				continue;

			} else if ("No Error".equals(returnedMessage)) {
				returnedString = "No Error";
				break;

			}
			
			

		}
		return returnedString;
	}



	

	
}
