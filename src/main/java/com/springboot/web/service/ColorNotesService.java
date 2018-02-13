package com.springboot.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.validator.internal.engine.messageinterpolation.parser.TokenCollector;
import org.springframework.stereotype.Service;

import com.springboot.web.model.ColorNotes;

@Service
public class ColorNotesService {
    private static List<ColorNotes> ColorNotess = new ArrayList<ColorNotes>();
    private static int ColorNotesCount = 4;

    static {
        ColorNotess.add(new ColorNotes(1, "jaisudha", "Learn Spring Boot", new Date(),
                false));
        ColorNotess.add(new ColorNotes(2, "jaisudha", "Learn Rest API", new Date(), false));
        ColorNotess.add(new ColorNotes(3, "jaisudha", "Learn Microservices", new Date(),
                false));
        ColorNotess.add(new ColorNotes(4, "jaisudha", "Learn Spring Cloud", new Date(),
                false));
    }

    public List<ColorNotes> retrieveColorNotess(String user) {
        List<ColorNotes> filteredColorNotess = new ArrayList<ColorNotes>();
        for (ColorNotes ColorNotes : ColorNotess) {
            if (ColorNotes.getUser().equals(user)) {
                filteredColorNotess.add(ColorNotes);
            }
        }
        return filteredColorNotess;
    }
    public ColorNotes retrieveColorNotesbyid(int id) {
        List<ColorNotes> filteredColorNotess = new ArrayList<ColorNotes>();
        for (ColorNotes colorNotes : ColorNotess) {
            if (colorNotes.getId()== id) {
            	 filteredColorNotess.add(colorNotes);
            	 return colorNotes;
            }
           
        }
        return null;
    }


    public void addColorNotes(String name, String desc, Date targetDate,
            boolean isDone) {
        ColorNotess.add(new ColorNotes(++ColorNotesCount, name, desc, targetDate, isDone));
    }
    
    
    
    public void  updateTodo(ColorNotes cnotes) {
    	ColorNotess.remove(cnotes);
    	ColorNotess.add(cnotes);
    }

    public void deleteColorNotes(int id) {
        Iterator<ColorNotes> iterator = ColorNotess.iterator();
        while (iterator.hasNext()) {
            ColorNotes ColorNotes = iterator.next();
            if (ColorNotes.getId() == id) {
                iterator.remove();
            }
        }
    }
}