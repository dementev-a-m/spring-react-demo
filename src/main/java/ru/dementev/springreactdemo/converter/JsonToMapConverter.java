package ru.dementev.springreactdemo.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.r2dbc.postgresql.codec.Json;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.io.IOException;
import java.util.Map;

@ReadingConverter
@Slf4j
@RequiredArgsConstructor
public class JsonToMapConverter implements Converter<Json, Map<String, Object>> {

    private final ObjectMapper objectMapper;
    private final TypeReference<Map<String, Object>> typeReference = new TypeReference<>() {
    };

    @Override
    public Map<String, Object> convert(Json source) {
        try {
            return objectMapper.readValue(source.asArray(), typeReference);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
