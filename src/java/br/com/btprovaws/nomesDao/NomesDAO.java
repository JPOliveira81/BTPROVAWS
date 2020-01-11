/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.btprovaws.nomesDao;

import br.com.btprovaws.hibernateutil.BTprovaHibernateUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João Paulo de Oliveira
 */
public class NomesDAO {
    
    public List<String> listaNomes() throws Exception{
        
        ResultSet rs = null;
        
        PreparedStatement stmt = null;
        
        List<String> listaRet = new ArrayList<String>();

        StringBuilder SQL = new StringBuilder(" SELECT NOME FROM NOMES ");
       

        Connection conn = BTprovaHibernateUtil.getConnection();
                
        stmt = conn.prepareStatement(SQL.toString());            

        rs = stmt.executeQuery();

        while (rs.next()) {
            
            listaRet.add(rs.getString("NOME"));

        }

        rs.close();
        rs = null;
        stmt.close();
        stmt = null;

        SQL.setLength(0);
        SQL = null;

        return listaRet;
    }
    
    
    public void GravaResposta(String resposta) throws Exception{
        
        PreparedStatement stmt = null;

        String SQLDel = "DELETE FROM RESPOSTAS ";
        
        String SQL = "INSERT INTO RESPOSTAS (RESPOSTA) VALUES (?)";       

        Connection conn = BTprovaHibernateUtil.getConnection();
                
        stmt = conn.prepareStatement(SQLDel); 
        
        stmt.execute();
        
        stmt = conn.prepareStatement(SQL);      
        
        stmt.setString(1, resposta);
        
        stmt.execute();
               
        stmt.close();
        
        stmt = null;
        SQL = null;
        
    }
    
    
    
}
