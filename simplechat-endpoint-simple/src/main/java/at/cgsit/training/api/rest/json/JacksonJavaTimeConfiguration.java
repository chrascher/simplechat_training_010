package at.cgsit.training.api.rest.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Register jackson as object mapper
 */
@Provider
public class JacksonJavaTimeConfiguration implements ContextResolver<ObjectMapper> {

  private final ObjectMapper mapper;

  public JacksonJavaTimeConfiguration() {

    mapper = new ObjectMapper();

    // mapper.registerModule(new JSR310Module());

    JavaTimeModule javaTimeModule=new JavaTimeModule();
    // Hack time module to allow 'Z' at the end of string (i.e. javascript json's)
    javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ISO_DATE_TIME));
    mapper.registerModule(javaTimeModule);
    
    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

  }

  @Override
  public ObjectMapper getContext(Class<?> type) {
    return mapper;
  }
}
