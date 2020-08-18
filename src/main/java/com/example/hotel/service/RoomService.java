package com.example.hotel.service;

import com.example.hotel.model.Room;

import java.util.List;

public interface RoomService {
    int addRoom(Room room);
    int deleteRoomById(int id);
    int updateRoom(Room room);
    //id为roomid
    Room getRoomById(int id);
    //tid为id
    Room selectRoomByTid(int tid);
    //根据房间类型查找房间，type为房间类型号，1为单人间，2为双人间
    List<Room> getRoomsByType(int type);
    List<Room> getAllRoom();
}
