/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.groupgbankappclient;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.ClientResponse;

/**
 *
 * @author Eoin
 */
public class ClientTest {
    
    public static void main(String[] args) {
        Gson gson = new Gson();

        try {
            Client client = Client.create();
            int port = 8080;
            String url = "http://localhost:" + port + "/api/customer/create";

            WebResource webResource = client.resource(url);

            String input = "{\"id\":1,\"name\":\"Eoin\",\"address\":\"Test address\",\"email\":\"test@test.com\", \"password\":\"test\"}";
            Customer c = new Customer(2,"eoin2", "test222", "eoin@live.com", "test222");
            //System.out.println(input);
            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                    .post(ClientResponse.class, c);

            String output = new Gson().toJson(response.getEntity());
            System.out.println(output);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
