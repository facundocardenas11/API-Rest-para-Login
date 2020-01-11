package com.javarevolutions.ws.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path; //Agregue dependencia.
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.javarevolutions.ws.rest.vo.VOUsuario;

@Path("/FacundoCode")
public class ServiceLoginJR {
     
	@POST
	@Path("/validaUsuario")
	@Consumes({MediaType.APPLICATION_JSON}) //Lo que utiliza, la informacion que transifere.
	@Produces({MediaType.APPLICATION_JSON}) //Transforma todo a JSON
	
	public VOUsuario validaUsuario(VOUsuario vo)
	{
		vo.setUserValido(false);
		if (vo.getUsuario().equals("FacundoCardenas") && vo.getPassword().equals("Facundo1997")){
			vo.setUserValido(true);
		}
		vo.setPassword("########################");
		return vo;
	}
}
