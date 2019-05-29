package aem.test.project.core.bean;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class WeatherItems {
    @JsonProperty(value = "city")
    private String city;
    @JsonProperty(value = "weather")
    private String weather;
    @JsonProperty(value = "description")
    private String description;
    @JsonProperty(value = "temperature")
    private String temperature;
    @JsonProperty(value = "pressure")
    private String pressure;
    @JsonProperty(value = "humidity")
    private String humidity;
    @JsonProperty(value = "visibility")
    private String visibility;
    @JsonProperty(value = "windSpeed")
    private String windSpeed;
}
