package com.example.hotel.controller;

import com.alibaba.fastjson.JSON;
import com.example.hotel.model.Client;
import com.example.hotel.service.ClientService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @PostMapping("/addClient")
    public int addClient(String client){
        Client target= JSON.parseObject(client,Client.class);
        if(target.getId().equals("")||target.getName().equals("")||target.getAddress().equals("")){
            return 0;
        }else{
            return clientService.addClient(target);
        }
    }
    @DeleteMapping("/deleteClient")
    public int deleteClient(@RequestParam("id") String  id){
        return clientService.deleteClientById(id);
    }
    @PostMapping("/updateClient")
    public int updateClient(String client){
        Client target= JSON.parseObject(client,Client.class);
        if(target.getId().equals("")||target.getName().equals("")||target.getAddress().equals("")){
            return 0;
        }else{
            return clientService.updateClient(target);
        }
    }
    @GetMapping("/getClient")
    public Client selectClient(@RequestParam("id") String id){
        return clientService.selectById(id);
    }
    @GetMapping("/getAllClient")
    public PageInfo<Client> getAllClient(int start){
        PageHelper.startPage(start,4);
        List<Client> list=clientService.getAllClient();
        return new PageInfo<>(list);
    }

}
