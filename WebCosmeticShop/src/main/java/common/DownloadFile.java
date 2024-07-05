package common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;



import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

public class DownloadFile {
	

	
	public static void DownloadFile(String bucketName, String keyName, String folderName ) throws IOException {
		
//		public static void DownloadFile() throws IOException {
		AwsBasicCredentials awsCreds = AwsBasicCredentials.create(ACCESS_KEY, SECRET_KEY);
		
		S3Client client = S3Client.builder()
				 .region(REGION)
				 .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();
//		String bucketName = "trihau.test2";
//		String keyName = "avatar.jpg";
		GetObjectRequest request = GetObjectRequest.builder()
				.bucket(bucketName)
				.key(keyName)
				.build();
		
		ResponseInputStream<GetObjectResponse> inputStream = client.getObject(request);
		
		
		
		// Đặt đường dẫn tường minh tới thư mục dự án
        
		System.out.println("Separatpor : "+ File.separator);
        
        String downloadDirectoryPath = System.getProperty("user.dir") + File.separator + folderName;
        
        // Đảm bảo thư mục tồn tại
        File directory = new File(downloadDirectoryPath);
        if (!directory.exists()) {
            boolean dirCreated = directory.mkdirs(); // Tạo thư mục nếu chưa tồn tại
            if (dirCreated) {
                System.out.println("Directory created: " + downloadDirectoryPath);
            } else {
                System.err.println("Failed to create directory: " + downloadDirectoryPath);
            }
        } else {
            System.out.println("Directory already exists: " + downloadDirectoryPath);
        }

        String outputFilePath = downloadDirectoryPath + File.separator + keyName;
        System.out.println("Output File Path: " + outputFilePath); // In ra đường dẫn tệp đầu ra
		
		
		
		
		
		
		
		
		
		BufferedOutputStream outputStream = new  BufferedOutputStream(new FileOutputStream(outputFilePath));
		
		byte[] buffer = new byte[4069];
		int bytesRead = -1;
		
		while((bytesRead = inputStream.read(buffer)) != -1){
			outputStream.write(buffer,  0, bytesRead);
		
		}


		System.out.println("tải thành công");
		inputStream.close();
		outputStream.close();
		
		
	}
}
