package at.cgsit.training.api.rest.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;


/**
 * 
 * @author Matej Babjak
 *
 */
@Provider
public class JacksonJavaTimeConfiguration implements ContextResolver<ObjectMapper> {
  private final ObjectMapper mapper;

  public JacksonJavaTimeConfiguration() {
    mapper = new ObjectMapper();
    mapper.registerModule(new JSR310Module());
    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
  }

  @Override
  public ObjectMapper getContext(Class<?> type) {
    return mapper;
  }
}
