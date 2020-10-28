package com.lhc.util.dozer.convert;

import org.dozer.DozerConverter;

import java.time.LocalDate;

/**
 * @Author lhc
 * @Date 2020-10-27 20:56
 **/
public class LocalDateToLocalDateConverter extends DozerConverter<LocalDate, LocalDate> {
    public LocalDateToLocalDateConverter() {
        super(LocalDate.class, LocalDate.class);
    }

    @Override
    public LocalDate convertFrom(LocalDate source, LocalDate destination) {
        return source;
    }

    @Override
    public LocalDate convertTo(LocalDate source, LocalDate destination) {
        return source;
    }
}