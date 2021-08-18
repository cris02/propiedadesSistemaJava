/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repasojava.principal;

import com.repasojava.properties.ConfigProperties;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aguilar
 */
public class Main {
    
    private static final String FILE_LANGUAGE_PROP = "language_@selection.properties";
    private static final String FILE_LANGUAGE_DEFAULT = "ES";
    
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            Properties propertiesLanguage = new Properties();
            String fileName = "config.properties";
            Scanner teclado = new Scanner(System.in);
            
            properties.load(ConfigProperties.getResourceAsInputStream(fileName));
            
            System.out.println("Idioma de la pagina web: " + properties.get("language"));
            System.out.println("Sistema: " + properties.get("appName"));
            System.out.println("Nombre de la empresa: " + properties.get("enterprise"));
            
            System.out.println("*************************************************************");
            System.out.println("Seleccione el idioma de la app");
            System.out.println("ES.Espanol o EN.Inges");
            String idioma = teclado.nextLine();
            
            if (idioma.length() > 2) {
                idioma = idioma.substring(0, 2).toUpperCase();
                propertiesLanguage.load(ConfigProperties.getResourceAsInputStream(
                        FILE_LANGUAGE_PROP.replace(@selection, idioma)));
            } else {
                idioma = FILE_LANGUAGE_DEFAULT;
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
