package com.javarevolutions.ws.rest.service;

import com.javarevolutions.ws.rest.vo.VOUsuario;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class RestClient {
	public static void main(String[] args)
	{
		//Codigo para invocar Cliente Rest.
		String urlrestService= "http://localhost:8080/RestJR/rest/FacundoCode/validaUsuario";
		System.out.print("########## Invoke Rest Service: " + urlrestService + "\n");
		VOUsuario vo= new VOUsuario();
		vo.setUsuario("FacundoCardenas");
		vo.setPassword("Facundo1997");
		vo.setUserValido(false);
		
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);
		Client client= Client.create(clientConfig);
		WebResource webResource = client
				.resource(urlrestService);
		ClientResponse response= webResource.type("application/json")
				.post(ClientResponse.class, vo);
		vo= response.getEntity(VOUsuario.class);
		System.out.println("###### Response: [Usuario: " + vo.getUsuario() + "]");
		System.out.println("###### Response: [User is valid:" + vo.isUserValido() +"]");	
	}
}
