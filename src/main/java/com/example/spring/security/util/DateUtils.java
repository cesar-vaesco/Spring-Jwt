package com.example.spring.security.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DateUtils {

    @Value("$jms.jwt.timezone")//de properties.yml
    private String TIMEZONE;

    //Dar formato a la fecha
    private SimpleDateFormat simpleDateFormat(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        sdf.setTimeZone(TimeZone.getTimeZone(TIMEZONE));
        return sdf;
    }

    // Obtener la fecha en el momento en que se genere el token
    public String getDateString(){
        Date now = new Date();
        return simpleDateFormat().format(now);
    }

    //  Convertir una fecha a milisegundos
    public long getDateMills(){

        Date now = new Date();
        String strDate = simpleDateFormat().format(now);
        Date strNow = new Date();

        try {
            strNow = simpleDateFormat().parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return strNow.getTime();
    }

}
