package com.lhc.util.dozer.convert;

import org.dozer.DozerConverter;

import java.time.LocalDateTime;

/**
 * @Author lhc
 * @Date 2020-10-27 20:56
 **/
public class LocalDateTimeToLocalDateTimeConverter extends DozerConverter<LocalDateTime, LocalDateTime> {
    public LocalDateTimeToLocalDateTimeConverter() {
        super(LocalDateTime.class, LocalDateTime.class);
    }

    @Override
    public LocalDateTime convertFrom(LocalDateTime source, LocalDateTime destination) {
        return source;
    }

    @Override
    public LocalDateTime convertTo(LocalDateTime source, LocalDateTime destination) {
        return source;
    }
}