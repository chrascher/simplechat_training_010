package at.cgsit.training.api.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.jboss.resteasy.plugins.providers.jackson.ResteasyJackson2Provider;

public class CustomJacksonProvider extends ResteasyJackson2Provider {

    public static CustomJacksonProvider of() {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaTimeModule dtm = new JavaTimeModule();

        objectMapper.registerModule(dtm);

        CustomJacksonProvider customJacksonProvider = new CustomJacksonProvider();
        customJacksonProvider.setMapper(objectMapper);

        return customJacksonProvider;
    }
}

