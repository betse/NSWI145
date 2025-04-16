package mff.betse.nswi145;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

@ApplicationPath("/api")
@OpenAPIDefinition(
		servers = {
			    @Server(
			      description = "Default server",
			      url         = "/08-rest"
			    )
			  },
  info = @Info(
    title       = "Order Service API",
    version     = "v1",
    description = "Simple demo of orders endpoint"
  )
)
public class RestConfig extends ResourceConfig {
    public RestConfig() {
        packages("mff.betse.nswi145");
        register(JacksonFeature.class);
        register(OpenApiResource.class);
    }
}
