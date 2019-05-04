package com.pro.server.util;

import java.util.ArrayList;
import java.util.List;

public class ClientHandler{
    private List<Client> clients=new ArrayList<>();

    public void addClient(Client client){
        clients.add(client);
    }

    public Client getByUserName(String userName){
        for(Client c: clients){
            if(c.getUserName().equals(userName)){
                return c;
            }
        }
        return null;
    }

    public boolean removeClients(Client client){
        for(Client c:clients){
            if(c.equals(client)){
                clients.remove(client);
                return true;
            }
        }
        return false;
    }

    public List<Client> getClients(){
        return clients;
    }
}