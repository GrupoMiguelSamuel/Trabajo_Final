package dacd.cabeza;

import java.util.List;

public class XoteloResponse {
	private String error;
	private long timestamp;
	private Result result;

	// Getters y Setters
	public String getError() { return error; }
	public void setError(String error) { this.error = error; }

	public long getTimestamp() { return timestamp; }
	public void setTimestamp(long timestamp) { this.timestamp = timestamp; }

	public Result getResult() { return result; }
	public void setResult(Result result) { this.result = result; }

	public static class Result {
		private String chk_in;
		private String chk_out;
		private List<HotelRate> rates;

		// Getters y Setters
		public String getChk_in() { return chk_in; }
		public void setChk_in(String chk_in) { this.chk_in = chk_in; }

		public String getChk_out() { return chk_out; }
		public void setChk_out(String chk_out) { this.chk_out = chk_out; }

		public List<HotelRate> getRates() { return rates; }
		public void setRates(List<HotelRate> rates) { this.rates = rates; }
	}
}