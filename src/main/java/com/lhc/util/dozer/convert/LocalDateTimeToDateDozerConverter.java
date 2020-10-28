package com.lhc.util.dozer.convert;

import org.dozer.DozerConverter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Author lhc
 * @Date 2020-10-27 20:56
 **/
public class LocalDateTimeToDateDozerConverter extends DozerConverter<LocalDateTime, Date> {
    public LocalDateTimeToDateDozerConverter() {
        super(LocalDateTime.class, Date.class);
    }

    @Override
    public LocalDateTime convertFrom(Date source, LocalDateTime destination) {
        return LocalDateTime.ofInstant(source.toInstant(), ZoneId.systemDefault());
    }

    @Override
    public Date convertTo(LocalDateTime source, Date destination) {
        return Date.from(source.atZone(ZoneId.systemDefault()).toInstant());
    }

}