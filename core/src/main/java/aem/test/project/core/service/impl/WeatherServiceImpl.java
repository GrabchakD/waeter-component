package aem.test.project.core.service.impl;

import aem.test.project.core.bean.WeatherItems;
import aem.test.project.core.service.WeatherService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.felix.scr.annotations.*;

@Component(immediate = true, metatype = true)
@Service
public class WeatherServiceImpl implements WeatherService {

    private static final String PATH_TO_WEATHER_API = "https://samples.openweathermap.org/data/2.5/weather";
    private static final String APP_ID = "appid";
    private static final String APP_ID_VALUE = "b6907d289e10d714a6e88b30761fae22";

    @Property(name = "path", label = "path", value = PATH_TO_WEATHER_API)
    private String path;

    @Override
    public WeatherItems getWeatherByCity(String city) {
        HttpResponse<JsonNode> response = getWeatherFromApi(city);

        return null;
    }

    private HttpResponse<JsonNode> getWeatherFromApi(String city) {
        try {
            return Unirest.get(path)
                    .header("accept", "application/json")
                    .queryString("q", city)
                    .queryString(APP_ID, APP_ID_VALUE)
                    .asJson();
        } catch (UnirestException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
