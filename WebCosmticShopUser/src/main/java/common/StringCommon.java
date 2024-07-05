package common;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class StringCommon {
	public static String convertNumberToString(long number, int digit) {
		number = number + 10000000000000000L;
		String returnedStr = String.valueOf(number);
		return returnedStr.substring(returnedStr.length() - digit);
	}

	public static String convertDoubleToString(double d) {
		return new DecimalFormat("#").format(d);
	}

	public static String convertDoubleToStringWithComma(double d) {

		return new DecimalFormat("###,###").format(d);

	}
	
	 public static String validateDateTime(String input) {
	        // Định dạng đầu vào
	        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
	        // Định dạng đầu ra
	        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("HH:mm 'ngày' d/M/yyyy");

	        // Tiền xử lý để đảm bảo có ba chữ số millisecond
	        if (input != null && input.length() > 19) {
	            String[] parts = input.split("\\.");
	            if (parts.length == 2) {
	                String milliseconds = parts[1];
	                if (milliseconds.length() == 2) {
	                    input = parts[0] + "." + milliseconds + "0";
	                } else if (milliseconds.length() == 1) {
	                    input = parts[0] + "." + milliseconds + "00";
	                }
	            }
	        }

	        try {
	            // Chuyển đổi chuỗi đầu vào thành LocalDateTime
	            LocalDateTime dateTime = LocalDateTime.parse(input, inputFormatter);
	            // Định dạng lại theo yêu cầu
	            return dateTime.format(outputFormatter);
	        } catch (DateTimeParseException e) {
	            // Nếu định dạng đầu vào không đúng, báo lỗi
	            return "Invalid date time format";
	        }
	    }
	 
	 public static String formatCurrency(double amount) {
	        // Tạo đối tượng NumberFormat cho tiền tệ với locale là Việt Nam
	        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
	        // Định dạng số tiền và trả về chuỗi kết quả
	        return currencyFormatter.format(amount);
	    }
	 
}
