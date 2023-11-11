package Lducation.demo.configure;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:googlemap.properties")
@Slf4j
@Getter
public class GoogleConfig {

    @Value("${GOOGLE_MAP_SECRET_KEY}")
    private String SECRET_KEY;

}
