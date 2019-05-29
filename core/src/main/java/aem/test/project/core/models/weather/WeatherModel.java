package aem.test.project.core.models.weather;

import aem.test.project.core.bean.WeatherItems;
import aem.test.project.core.service.WeatherService;
import com.mashape.unirest.http.JsonNode;
import lombok.Getter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Getter
public class WeatherModel {

    private static final String DEFAULT_CITY = "London";

    @ChildResource
    private String city;

    @Inject
    private WeatherService service;

    private WeatherItems weather;

    @PostConstruct
    public void init() throws RuntimeException {
        service.getWeatherByCity(city);
    }
}