/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.Serializable;
import java.sql.Date;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author dragneol
 */
public class FormatUtil implements Serializable {

    /**
     * 
     * @param date is String format yyyy-mm-dd
     * @return java.sql.Date
     * @throws NumberFormatException
     * @throws PatternSyntaxException 
     */
    public static Date parseDate(String date) throws NumberFormatException, PatternSyntaxException {
        int year, month, day;
        String[] tmp = date.split("-");
        year = Integer.parseInt(tmp[0]);
        month = Integer.parseInt(tmp[1]);
        day = Integer.parseInt(tmp[2]);
        return new Date(year - 1900, month - 1, day);
    }
}
