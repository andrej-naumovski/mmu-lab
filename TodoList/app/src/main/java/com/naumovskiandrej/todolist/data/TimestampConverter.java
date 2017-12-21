package com.naumovskiandrej.todolist.data;

import android.arch.persistence.room.TypeConverter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampConverter {
    static DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    @TypeConverter
    public static Date fromTimestamp(String timestamp) {
        if(timestamp != null) {
            try {
                return df.parse(timestamp);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        }
        return null;
    }

    @TypeConverter
    public static String toTimestamp(Date date) {
        if(date != null) {
            return df.format(date);
        }
        return null;
    }
}
