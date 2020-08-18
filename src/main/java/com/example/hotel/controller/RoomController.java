package com.example.hotel.controller;

import com.alibaba.fastjson.JSON;
import com.example.hotel.model.Room;
import com.example.hotel.service.RoomService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @PostMapping("/addRoom")
    public int addRoom(String room){
        Room target= JSON.parseObject(room,Room.class);
        if(target.getRoomid()<=0||target.getCost()<=0){
            return 0;
        }else{
            return roomService.addRoom(target);
        }
    }
    @DeleteMapping("/deleteRoom")
    public int deleteRoom(int id){
        return roomService.deleteRoomById(id);
    }

    @PostMapping("/updateRoom")
    public int updateRoom(String room){
        Room target= JSON.parseObject(room,Room.class);
        if(target.getRoomid()<=0||target.getCost()<=0){
            return 0;
        }else{
            return roomService.updateRoom(target);
        }
    }

    @GetMapping("/getRoomById")
    public Room getRoomById(int id){
        return roomService.getRoomById(id);
    }

    @GetMapping("/getRoomsByType")
    public PageInfo<Room> getRoomsByType(int type,int start){
        PageHelper.startPage(start,4);
        List<Room> list=roomService.getRoomsByType(type);
        return new PageInfo<>(list);
    }

    @GetMapping("/getAllRoom")
    public PageInfo<Room> getAllRoom(int start){
        PageHelper.startPage(start,4);
        List<Room> list= roomService.getAllRoom();
        return new PageInfo<>(list);
    }
    @GetMapping("/getRooms")
    public List<Room> getRooms(){
        return roomService.getAllRoom();
    }

}
