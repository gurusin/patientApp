package com.opdapp.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyDateDeserializer extends JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException
    {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("your pattern");

        String date = jp.getValueAsString();

        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
        return localDateTime;
    }
}
