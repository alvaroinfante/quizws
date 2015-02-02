/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufpr.quizws.services;

import br.com.ufpr.quizws.model.Pergunta;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Alvaro, Diego e Diullian
 */
@Path("service")
public class Service {

    // Simula base de dados
    private static Map<Integer, Pergunta> perguntas = new HashMap<Integer, Pergunta>();

    // Inserir registros
    static {
        for (int i = 0; i < 10; i++) {
            Pergunta p = new Pergunta();
            int id = i + 1;
            p.setId(id);
            p.setPergunta("Pergunta " + id);

            perguntas.put(id, p);
        }

    }

    @GET
    @Path("/getPerguntaById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pergunta getPerguntaById(@PathParam("id") int id) {
        System.out.println(perguntas.get(id));
        return perguntas.get(id);

    }

}
