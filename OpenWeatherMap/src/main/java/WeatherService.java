import com.google.gson.Gson;
import io.javalin.Javalin;
import io.javalin.http.Context;
import model.Model;
import model.WeatherData;
import schemas.WeatherResponse;

import java.io.IOException;
import java.util.List;

public class WeatherService {

    private final Model model;

    public WeatherService(Model model) {
        this.model = model;
    }

    public void start() {
        var app = Javalin.create(/*config*/)
                .get("/api/v1/weather", ctx -> getWeather(ctx))
                .start(7070);
    }

    private void getWeather(Context ctx) throws IOException {
        String city = ctx.req().getParameter("city");
        if (city == null) {
            ctx.res().sendError(400, "Parameter 'city' is required");
            return;
        }

        List<WeatherData> weatherDataList = model.getWeather(city);
        ctx.res().setContentType("application/json");
        ctx.res().getWriter().write(new Gson().toJson(schemaOf(weatherDataList)));
    }

    private WeatherResponse schemaOf(List<WeatherData> weatherDataList) {
        return new WeatherResponse("https://api.openweathermap.org", weatherDataList.size(), map(weatherDataList));
    }

    private List<WeatherResponse.WeatherData> map(List<WeatherData> weatherDataList) {
        WeatherData weather = weatherDataList.get(0);
        return List.of(new WeatherResponse.WeatherData(
                weather.getTempMin(),
                weather.getTempMax(),
                weather.getPressure(),
                weather.getHumidity(),
                weather.getSeaLevel()
        ));
    }
}
