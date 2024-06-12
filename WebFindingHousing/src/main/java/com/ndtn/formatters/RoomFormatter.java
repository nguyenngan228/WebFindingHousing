/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndtn.formatters;

import com.ndtn.pojo.Room;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author thanh
 */
public class RoomFormatter implements Formatter<Room>{

    @Override
    public String print(Room room, Locale locale) {
        return String.valueOf(room.getId());
    }

    @Override
    public Room parse(String id, Locale locale) throws ParseException {
        Room r = new Room();
        r.setId(Integer.parseInt(id));
        return r;
    }
    
    
}
