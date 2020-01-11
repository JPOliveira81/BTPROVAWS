/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.btprovaws.hibernateutil;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author João Paulo de Oliveira
 */
public class BTprovaHibernateUtil {
    
    private static String sDriver;
    private static String sURL;
    private static String sUsuario;
    private static String sSenha;
    

    public static Connection getConnection() throws Exception {
        
        sDriver = "org.firebirdsql.jdbc.FBDriver";        
                      
        sURL = "jdbc:firebirdsql:LOCALHOST/3050:C:/BTPROVA.FDB";
        sUsuario = "SYSDBA";
        sSenha = "masterkey";
        
        String charset = "?lc_ctype=WIN1252";
        
        Connection c = null;
        try {
            Class.forName(sDriver);
            c = DriverManager.getConnection(sURL+charset, sUsuario, sSenha);
        } catch (Exception ex) {
            throw new Exception("URL : "+sURL+charset+" \n\t Erro na conexão com o banco de dados - " + ex.toString());
        }
        return c;
    }
    
   
   
     

}
