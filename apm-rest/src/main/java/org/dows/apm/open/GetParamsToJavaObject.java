package org.dows.apm.open;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class GetParamsToJavaObject {
    public static <T> T convertParamsToObject(String paramString, Class<T> clazz) {
        try {
            T obj = clazz.getDeclaredConstructor().newInstance();
            Map<String, String> paramMap = parseParamString(paramString);
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                String fieldName = entry.getKey();
                String fieldValue = entry.getValue();
                try {
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(obj, fieldValue);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Map<String, String> parseParamString(String paramString) {
        Map<String, String> paramMap = new HashMap<>();
        String[] params = paramString.split("&");
        for (String param : params) {
            String[] keyValue = param.split("=");
            if (keyValue.length == 2) {
                try {
                    String key = URLDecoder.decode(keyValue[0], "UTF-8");
                    String value = URLDecoder.decode(keyValue[1], "UTF-8");
                    paramMap.put(key, value);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return paramMap;
    }

    public static void main(String[] args) {
        String paramString = "signature=f464b24fc39322e44b38aa78f5edd27bd1441696&echostr=4375120948345356249&timestamp=1714036504&nonce=1514711492";
        RequestParams requestParams = convertParamsToObject(paramString, RequestParams.class);
        System.out.println(requestParams);
    }
}    