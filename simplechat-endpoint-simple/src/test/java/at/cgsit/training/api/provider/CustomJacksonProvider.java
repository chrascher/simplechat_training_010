package at.cgsit.training.api.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.resteasy.plugins.providers.jackson.ResteasyJackson2Provider;

public class CustomJacksonProvider extends ResteasyJackson2Provider {

    public static CustomJacksonProvider of() {
        ObjectMapper objectMapper = new ObjectMapper();
        CustomJacksonProvider customJacksonProvider = new CustomJacksonProvider();
        customJacksonProvider.setMapper(objectMapper);
        return customJacksonProvider;
    }
}

