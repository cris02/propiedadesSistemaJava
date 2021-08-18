/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repasojava.principal;

import com.repasojava.properties.ConfigProperties;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aguilar
 */
public class Main {
    
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            String fileName = "config.properties";
            
            properties.load(ConfigProperties.getResourceAsInputStream(fileName));
            
            System.out.println("Idioma de la pagina web: " + properties.get("language"));
            System.out.println("Sistema: " + properties.get("appName"));
            System.out.println("Nombre de la empresa: " + properties.get("enterprise"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
