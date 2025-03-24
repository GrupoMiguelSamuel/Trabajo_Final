package dacd.cabeza;

import dacd.cabeza.api.XoteloApiClient;
import dacd.cabeza.db.DatabaseManager;
import dacd.cabeza.db.RateRepository;
import dacd.cabeza.model.XoteloResponse;

public class XoteloFeederApplication {
	public static void main(String[] args) {
		try {
			DatabaseManager.initializeDB();

			XoteloApiClient apiClient = new XoteloApiClient();
			RateRepository repository = new RateRepository();

			XoteloResponse response = apiClient.getRates("2025-03-25", "2025-03-28");

			if (response.getError() == null) {
				repository.saveRates(
						response.getResult().getRates(),
						response.getResult().getChk_in(),
						response.getResult().getChk_out()
				);
				System.out.println("✅ Datos guardados exitosamente!");
			} else {
				System.out.println("❌ Error en la API: " + response.getError());
			}

		} catch (Exception e) {
			System.err.println("⚠️ Error crítico: ");
			e.printStackTrace();
		}
	}
}
