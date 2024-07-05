package common;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCommon {
//	public static String validateProduct(String tenHH, String dvt, String donGiaTK, String ghiChu) {
//		if (!checkRequiredFields(tenHH, dvt, donGiaTK)) {
//			return "Required Fields error";
//		}
//		if (!donGiaTK.matches("\\d{4,9}")) {
//			return "Invalid DGTK error";
//		}
//		return "No Error";
//	}
//	
//	public static boolean checkRequiredFields(String ...strings) {
//		String[] strs = strings;
//		boolean validData = true;
//		
//		for(int i = 0; i < strs.length; i++) {
//			if(strs[i] == null || "".equals(strs[i])) {
//				return false;
//			}
//		}
//		return validData;
//	}
	private static final String EMAIL_PATTERN = 
	        "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + 
	        "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	    

		static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	    // Phương thức kiểm tra email và trả về mã lỗi
	    public static String validateEmail(String email) {
	        
	        Matcher matcher = pattern.matcher(email);
	        if (!matcher.matches()) {
	            return "Email Error";
	        }
	        return "No Error";
	    }
	
	
	public static String checkRequiredFieldsTest(String ...strings) {
		String[] strs = strings;
		boolean validData = true;
		
		for(int i = 0; i < strs.length; i++) {
			if(strs[i] == null || "".equals(strs[i])) {
				return "Required Fields Error";
			}
		}
		return "No Error";
	}
	
	
	public static boolean isValidDigitString(String str) {
		return str != null && str.matches("\\d+");
	}
	
	public static String validatePhoneNumber(String phoneNumber) {

		char firstChar = phoneNumber.charAt(0);

        if (phoneNumber.length() != 10 || firstChar != '0') {
            return "Phone Error"; 
        }

        

        
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                return "Phone Error";
            }
        }


        return "No Error";
    }
	
	public static String validatePassword(String password) {
  

        boolean hasUpperCase = false;
        boolean hasDigit = false;

        
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }

        // Kiểm tra các điều kiện chưa thỏa mãn
        if (!hasUpperCase || !hasDigit) {
            return "Password Error"; // Không có ký tự viết hoa
        }

        if (password.length() < 8) {
            return "Password Error"; // Mật khẩu ít hơn 8 ký tự
        }

        return "No Error";
    }
	
	public static String formatStarRate(float starRate, int decimalPlaces) {
        
        StringBuilder pattern = new StringBuilder("#.");
        for (int i = 0; i < decimalPlaces; i++) {
            pattern.append("#");
        }
        DecimalFormat decimalFormat = new DecimalFormat(pattern.toString());
        // Định dạng số sao và trả về chuỗi đã định dạng
        return decimalFormat.format(starRate);
    }
	
	
	public static String validateIntegerString(String input) {
        // Kiểm tra xem chuỗi có phải là số nguyên và lớn hơn 0 hay không
        if (input == null || input.isEmpty()) {
            return "Error";
        }

        try {
            int number = Integer.parseInt(input);
            if (number > 0) {
                return "No Error";
            } else {
                return "Error";
            }
        } catch (NumberFormatException e) {
            return "Error";
        }
    }

}
