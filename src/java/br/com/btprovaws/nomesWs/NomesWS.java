/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.btprovaws.nomesWs;

import br.com.btprovaws.nomesDao.NomesDAO;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author João Paulo de Oliveira
 */
@Path("Nomes")
public class NomesWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of NomesWS
     */
    public NomesWS() {
    }

    
    
    /**
     * Metódo get que retorno um json de uma coleção de vinculo
     * @return an instance of java.lang.String
     * @throws java.lang.Exception
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("ListaNomes")
    public String getListaNomes() throws Exception{
        
        NomesDAO dao = new NomesDAO();       
                       
        String nomes = dao.listaNomes().toString();
        
        int tamanho = dao.listaNomes().size();
        
        String retorno = "0";
        
        String respota;

        for (int i = 1; i < tamanho; i++) {
           
            retorno = retorno + ","+Integer.toString(i); 
            
            
        }
        
        respota = "mínimo de operações é : "+Integer.toString(tamanho);
        
        dao.GravaResposta(respota);
        
        retorno = "["+retorno+"] <meta http-equiv=Content-Type content=text/html; charset=utf-8><p><b> mínimo de operações é : "+respota
                +" sendo esse número correspondente ao tamanho da lista </b></p>"+nomes;
        
        return retorno;
        
    }

    
}
