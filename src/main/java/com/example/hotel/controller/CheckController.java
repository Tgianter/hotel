package com.example.hotel.controller;

import com.alibaba.fastjson.JSON;
import com.example.hotel.dao.TCheckMapper;
import com.example.hotel.model.Room;
import com.example.hotel.model.TCheck;
import com.example.hotel.model.TCheckExample;
import com.example.hotel.model.dto.Order;
import com.example.hotel.service.ClientService;
import com.example.hotel.service.RoomService;
import com.example.hotel.service.TCheckService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/check")
public class CheckController {
    @Autowired
    TCheckMapper checkMapper;
    @Autowired
    TCheckService checkService;
    @Autowired
    RoomService roomService;
    @Autowired
    ClientService clientService;
    @PostMapping("/addCheck")
    public int addCheck(String check){
        TCheck target= JSON.parseObject(check,TCheck.class);
        if(target.getCid()<0||target.getRid()<0||target.getReciepts()<0){
            return 0;
        }else{
            Room room=roomService.selectRoomByTid(target.getRid());
            roomService.updateRoom(new Room(room.getId(),room.getRoomid(),
                    room.getType(),room.getCost(),1));
            return checkService.addTCheck(target);
        }
    }
    @PostMapping("/addOrder")
    public int addOrder(String order){
        Order target=JSON.parseObject(order,Order.class);
        if(target.getCid().equals("")||target.getRid()<0||target.getReciepts()<0){
            return 0;
        }else{
            int cid=clientService.selectById(target.getCid()).getTid();
            int rid=roomService.getRoomById(target.getRid()).getId();
            Room room=roomService.selectRoomByTid(rid);
            roomService.updateRoom(new Room(room.getId(),room.getRoomid(),
                    room.getType(),room.getCost(),1));
            TCheck check=new TCheck(cid,rid,target.getReciepts(),target.getDeposit());
            return checkService.addTCheck(check);
        }
    }
    @DeleteMapping("/deleteCheckByRoomId")
    public int deleteCheckByRid(int roomid){
        Room room=roomService.getRoomById(roomid);
        TCheckExample example=new TCheckExample();
        TCheckExample.Criteria criteria=example.createCriteria();
        criteria.andRidEqualTo(room.getId());
        roomService.updateRoom(new Room(room.getId(),room.getRoomid(),
                room.getType(),room.getCost(),0));
        return checkMapper.deleteByExample(example);
    }
    @DeleteMapping("/deleteCheck")
    public int deleteCheck(@RequestParam("cid") String cid){
        TCheck check=checkService.getTCheckByCid(cid);
        Room room=roomService.selectRoomByTid(check.getRid());
        roomService.updateRoom(new Room(room.getId(),room.getRoomid(),
                room.getType(),room.getCost(),1));
        return checkService.deleteByCid(cid);
    }

    @PutMapping("/updateCheck")
    public int updateCheck(String check){
        TCheck target= JSON.parseObject(check,TCheck.class);
        if(target.getCid()<0||target.getRid()<0||target.getReciepts()<=0){
            return 0;
        }else{
            return checkService.updateTCheck(target);
        }
    }
    @PutMapping("/updateOrder")
    public int updateOrder(String order){
        Order target=JSON.parseObject(order,Order.class);
        if(target.getCid().equals("")||target.getRid()<0||target.getReciepts()<0){
            return 0;
        }else{
            int cid=clientService.selectById(target.getCid()).getTid();
            int rid=roomService.getRoomById(target.getRid()).getId();
            TCheck check=new TCheck(cid,rid,target.getReciepts(),target.getDeposit());
            return checkService.updateTCheck(check);
        }
    }
    //cid为client的cid
    @GetMapping("/getCheckByCid")
    public Order getTCheckByCid(@RequestParam String cid){
        TCheck check=checkService.getTCheckByCid(cid);
        int rid=roomService.selectRoomByTid(check.getRid()).getRoomid();
        return new Order(cid,rid,check.getReciepts(),check.getDeposit());
    }
    //id为Room的roomid
    @GetMapping("/getCheckByRid")
    public PageInfo<Order> getTCheckByRid(int id,int start){
        PageHelper.startPage(start,4);
        List<TCheck> list=checkService.getTChecksByRid(id);
        List<Order> orders=new ArrayList<>();
        for(TCheck check:list){
            String cid=clientService.getClientByTid(check.getCid()).getId();
            Order order=new Order(cid,id,check.getReciepts(),check.getDeposit());
            orders.add(order);
        }
        return new PageInfo<>(orders);
    }

    @GetMapping("/getAllCheck")
    public PageInfo<Order> listAllCheck(int start){
        PageHelper.startPage(start,4);
        List<TCheck> list=checkService.getAllCheck();
        List<Order> orders=new ArrayList<>();
        for(TCheck check:list){
            String cid=clientService.getClientByTid(check.getCid()).getId();
            int rid=roomService.selectRoomByTid(check.getRid()).getRoomid();
            Order order=new Order(cid,rid,check.getReciepts(),check.getDeposit());
            orders.add(order);
        }
        return new PageInfo<>(orders);
    }
}
