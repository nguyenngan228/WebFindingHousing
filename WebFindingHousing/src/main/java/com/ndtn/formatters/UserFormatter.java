/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.formatters;

import com.ndtn.pojo.User;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author thanh
 */
public class UserFormatter implements Formatter<User>{

    @Override
    public String print(User user, Locale locale) {
        return String.valueOf(user.getId());
    }

    @Override
    public User parse(String id, Locale locale) throws ParseException {
        User u = new User();
        u.setId(Integer.parseInt(id));
        return u;
    }
}
