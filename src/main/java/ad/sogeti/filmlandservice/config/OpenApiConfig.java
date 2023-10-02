package ad.sogeti.filmlandservice.config;

import ad.sogeti.filmlandservice.utils.FilmLandConstants;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = FilmLandConstants.FILMLAND_TITLE,
                version = FilmLandConstants.FILMLAND_VERSION
        )
)
public class OpenApiConfig {
}
