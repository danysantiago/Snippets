import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


public class maincito {

	public static void main(String[] args){

		if (args.length == 2){
			String url = args[0];
			String filePath = args[1];
			
			try {
				String line;
				StringBuilder sb = new StringBuilder();
				BufferedReader br = new BufferedReader(new FileReader(filePath));
				while ((line=br.readLine()) != null) {
					sb.append(line);
				}

				post(url, sb.toString());

				System.out.println("---DONE---");

			} catch (IOException e) {
				System.out.println("Can't read file...");
				System.exit(1);
			}

		} else {
			System.out.println("Use this app like this:\n post [url] [json-text-file]");
		}

	}

	public static void post(String url, String json){

		HttpClient httpClient = new DefaultHttpClient();

		try {
			HttpPost request = new HttpPost(url);
			StringEntity params = new StringEntity(json);
			request.addHeader("content-type", "application/json");
			request.setEntity(params);
			HttpResponse response = httpClient.execute(request);
			int statusCode = response.getStatusLine().getStatusCode();
			if(statusCode == HttpStatus.SC_OK){

				System.out.println(EntityUtils.toString(response.getEntity()));

			} else {
				System.out.println("Error, HTTP Response Code: " + statusCode);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			System.out.println("Giving URL is Malformed");
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
	}

}
