package dacd.cabeza;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import java.io.IOException;
import java.util.Properties;

public class XoteloApiClient {
	private final OkHttpClient client = new OkHttpClient();
	private final String baseUrl;
	private final String hotelKey;

	public XoteloApiClient() {
		Properties prop = new Properties();
		try {
			prop.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
			baseUrl = prop.getProperty("xotelo.api.base_url");
			hotelKey = prop.getProperty("xotelo.api.hotel_key");
		} catch (IOException e) {
			throw new RuntimeException("Error loading properties", e);
		}
	}

	public XoteloResponse getRates(String checkIn, String checkOut) throws IOException {
		HttpUrl url = HttpUrl.parse(baseUrl).newBuilder()
				.addQueryParameter("hotel_key", hotelKey)
				.addQueryParameter("chk_in", checkIn)
				.addQueryParameter("chk_out", checkOut)
				.build();

		Request request = new Request.Builder()
				.url(url)
				.build();

		try (Response response = client.newCall(request).execute()) {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(response.body().string(), XoteloResponse.class);
		}
	}
}
