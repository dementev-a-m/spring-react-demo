package ru.dementev.springreactdemo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.dialect.DialectResolver;
import ru.dementev.springreactdemo.converter.JsonToMapConverter;
import ru.dementev.springreactdemo.converter.MapToJsonConverter;

import java.util.List;

@Configuration
@EnableR2dbcAuditing
public class ReactivePostgresConfig {

    @Bean
    public R2dbcCustomConversions r2dbcCustomConversions(ConnectionFactory connectionFactory, ObjectMapper objectMapper) {
        var dialect = DialectResolver.getDialect(connectionFactory);
        List<Converter<?, ?>> converters = List.of(new JsonToMapConverter(objectMapper),
                new MapToJsonConverter(objectMapper));
        return R2dbcCustomConversions.of(dialect, converters);
    }
}
