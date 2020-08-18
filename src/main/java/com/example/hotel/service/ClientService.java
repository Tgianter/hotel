package com.example.hotel.service;

import com.example.hotel.model.Client;

import java.util.List;

public interface ClientService {

    int addClient(Client client);
    int deleteClientById(String id);
    int updateClient(Client client);
    Client selectById(String id);
    Client getClientByTid(int tid);
    List<Client> getAllClient();
}
