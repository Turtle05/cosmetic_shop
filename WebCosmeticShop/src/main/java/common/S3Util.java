package common;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

public class S3Util {

	public static void uploadFile(String bucketname, String filename, InputStream inputStream)
			throws S3Exception, AwsServiceException, SdkClientException, IOException {
		AwsBasicCredentials awsCreds = AwsBasicCredentials.create(ACCESS_KEY, SECRET_KEY);

		S3Client client = S3Client.builder()
				.region(REGION)
				.credentialsProvider(StaticCredentialsProvider.create(awsCreds))
				.build();

		PutObjectRequest request = PutObjectRequest.builder()
				.bucket(bucketname)
				.key(filename)
				.acl("public-read")
				.build();
		client.putObject(request, RequestBody.fromInputStream(inputStream, inputStream.available()));
		;

	}

	public static String getFileName(Part part) {
		String contentDisposition = part.getHeader("content-disposition");
		int beginIndex = contentDisposition.indexOf("filename") + 10;
		int endIndex = contentDisposition.length() - 1;

		return contentDisposition.substring(beginIndex, endIndex);
	}

}
