package com.example.workerrental.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Objects;

public class MapUtil {
    public static <T> T getObject(Map<String, String> field, String key, Class<T> tClass){
        Object obj = field.getOrDefault(key, null);
            if(obj != null){
                if(tClass.getName().equals("java.lang.Integer")){
                    obj = obj != "" ? Integer.parseInt(obj.toString()) : null;
                }
                else if(tClass.getName().equals("java.lang.Float")){
                    obj = obj != "" ? Float.parseFloat(obj.toString()) : null;
                } else if (tClass.getName().equals("java.lang.String")) {
                    obj = obj.toString();
                } else if (tClass.getName().equals("java.sql.Date")) {
                    if(obj != ""){
                        try{
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            java.util.Date parsedDate = sdf.parse(obj.toString());
                            obj = new java.sql.Date(parsedDate.getTime());
                        }
                        catch (ParseException e){
                            obj = null;
                        }
                    }
                    else{
                        obj = null;
                    }
                }
                return tClass.cast(obj);
            }
        return null;
    }

}
