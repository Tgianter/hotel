package com.example.hotel.service.serviceImpl;

import com.example.hotel.dao.ClientMapper;
import com.example.hotel.model.Client;
import com.example.hotel.model.ClientExample;
import com.example.hotel.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientMapper clientMapper;
    @Override
    public int addClient(Client client) {
        return clientMapper.insertClient(client);
    }

    @Override
    public int deleteClientById(String id) {
        ClientExample example=new ClientExample();
        ClientExample.Criteria criteria=example.createCriteria();
        criteria.andIdEqualTo(id);
        return clientMapper.deleteByExample(example);
    }

    @Override
    public int updateClient(Client client) {
        return clientMapper.updateByPrimaryKey(client);
    }

    @Override
    public Client selectById(String id) {
        ClientExample example=new ClientExample();
        ClientExample.Criteria criteria=example.createCriteria();
        criteria.andIdEqualTo(id);
        List<Client> clients=clientMapper.selectByExample(example);
        if(clients.size()<1){
            return null;
        }else{
            return clients.get(0);
        }
    }

    @Override
    public Client getClientByTid(int tid) {
        return clientMapper.selectByPrimaryKey(tid);
    }

    @Override
    public List<Client> getAllClient() {
        ClientExample example= new ClientExample();
        example.setOrderByClause("id asc");
        return clientMapper.selectByExample(example);
    }
}
