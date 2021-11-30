package com.example.kodillaconverter.controller;

import com.example.kodillaconverter.domain.Car;
import com.example.kodillaconverter.domain.MyCustomClass;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CarConverter implements HttpMessageConverter<Object> {

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return clazz.getName().equals("com.example.kodillaconverter.domain.Car") &&
                mediaType.getSubtype().equals("plain") && mediaType.getType().equals("text");

    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.getName().equals("com.example.kodillaconverter.domain.Car") &&
                mediaType.getSubtype().equals("plain") && mediaType.getType().equals("text");

    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return List.of(MediaType.ALL);
    }

    @Override
    public Object read(Class<?> clazz, HttpInputMessage inputMessage) throws IOException {
        StringBuilder builder = new StringBuilder();

        try (Reader reader = new BufferedReader(
                new InputStreamReader(
                        inputMessage.getBody(),
                        StandardCharsets.UTF_8.name()))) {
            int c = 0;

            while ((c = reader.read()) != -1)
                builder.append((char) c);
        }

        String[] fields = builder.toString().split(" - ");

        return new Car(fields[0], Integer.valueOf(fields[1]),  Integer.valueOf(fields[2]));
    }
    @Override
    public void write(Object o, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

    }
}

