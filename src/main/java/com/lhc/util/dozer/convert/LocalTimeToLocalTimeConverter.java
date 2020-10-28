package com.lhc.util.dozer.convert;

import org.dozer.DozerConverter;

import java.time.LocalTime;

/**
 * @Author lhc
 * @Date 2020-10-27 20:56
 **/
public class LocalTimeToLocalTimeConverter extends DozerConverter<LocalTime, LocalTime> {
    public LocalTimeToLocalTimeConverter() {
        super(LocalTime.class, LocalTime.class);
    }

    @Override
    public LocalTime convertFrom(LocalTime source, LocalTime destination) {
        return source;
    }

    @Override
    public LocalTime convertTo(LocalTime source, LocalTime destination) {
        return source;
    }
}