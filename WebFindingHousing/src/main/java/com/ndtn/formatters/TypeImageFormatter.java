/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.formatters;

import com.ndtn.pojo.Typeimage;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author thanh
 */
public class TypeImageFormatter implements Formatter<Typeimage>{

    @Override
    public String print(Typeimage type, Locale locale) {
        return String.valueOf(type.getId());
    }

    @Override
    public Typeimage parse(String id, Locale locale) throws ParseException {
        Typeimage r = new Typeimage();
        r.setId(Integer.parseInt(id));
        return r;
    }
    
}
