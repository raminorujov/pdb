package az.pdb.userstock.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class SwaggerDocumentationConfig implements SwaggerResourcesProvider {

    // Todo change document
    @Override
    public List get() {
        List resources = new ArrayList();
        resources.add(swaggerResource("Stock Service", "/stock/v2/api-docs", "2.0"));
        resources.add(swaggerResource("User Service", "/user/v2/api-docs", "2.0"));
        resources.add(swaggerResource("User Stock Service", "/user-stock/v2/api-docs", "2.0"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }

}
