package com.lhc.util.dozer.convert;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerConverter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * @Author lhc
 * @Date 2020-10-27 20:58
 **/
public class StringToDateConverter extends DozerConverter<String, Date> {
    public StringToDateConverter() {
        super(String.class, Date.class);
    }

    @Override
    public String convertFrom(Date source, String destination) {
        if (source == null) {
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(source);
        destination = dateTime.toString("yyyy-MM-dd HH:mm:ss");
        return destination;
    }

    @Override
    public Date convertTo(String source, Date destination) {
        DateTimeFormatter dateTimeFormatter;
        if (StringUtils.isBlank(source)) {
            return null;
        }
        if (10 == source.length()) {
            dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        } else if (14 == source.length()) {
            dateTimeFormatter = DateTimeFormat.forPattern("yyyyMMddHHmmss");
        } else {
            dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        }
        DateTime dateTime = dateTimeFormatter.parseDateTime(source);
        destination = dateTime.toDate();
        return destination;
    }
}