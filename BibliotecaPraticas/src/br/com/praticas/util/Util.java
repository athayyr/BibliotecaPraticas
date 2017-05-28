/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.praticas.util;

import java.text.SimpleDateFormat;

/**
 *
 * @author VAAR
 */
public class Util {

    
    //Conversoes para datas
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public static String dateToString(java.util.Date data) {
        try {
            return formatter.format(data);
        } catch (Exception e) {
            return null;
        }
    }

    public static java.util.Date stringToDate(String dataStr) {
        try {
            return formatter.parse(dataStr);
        } catch (Exception e) {
            return null;
        }
    }

    public static java.util.Date sqlParaDate(java.sql.Date data) {
        return new java.util.Date(data.getTime());
    }

    public static java.sql.Date dateParaSql(java.util.Date data) {
        return new java.sql.Date(data.getTime());
    }

}
