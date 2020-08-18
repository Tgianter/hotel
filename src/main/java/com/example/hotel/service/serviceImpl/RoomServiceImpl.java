package com.example.hotel.service.serviceImpl;

import com.example.hotel.dao.RoomMapper;
import com.example.hotel.model.Room;
import com.example.hotel.model.RoomExample;
import com.example.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomMapper roomMapper;
    @Override
    public int addRoom(Room room) {
        return roomMapper.insert(room);
    }

    @Override
    public int deleteRoomById(int id) {
        RoomExample example=new RoomExample();
        RoomExample.Criteria criteria=example.createCriteria();
        criteria.andRoomidEqualTo(id);
        return roomMapper.deleteByExample(example);
    }

    @Override
    public int updateRoom(Room room) {
        RoomExample example=new RoomExample();
        RoomExample.Criteria criteria=example.createCriteria();
        criteria.andRoomidEqualTo(room.getRoomid());
        return roomMapper.updateByExampleSelective(room,example);
    }

    @Override
    public Room getRoomById(int id) {
        RoomExample example=new RoomExample();
        RoomExample.Criteria criteria=example.createCriteria();
        criteria.andRoomidEqualTo(id);
        List<Room> list=roomMapper.selectByExample(example);
        if(list.size()<1){
            return null;
        }else{
            return list.get(0);
        }
    }

    @Override
    public Room selectRoomByTid(int tid) {
        RoomExample example=new RoomExample();
        RoomExample.Criteria criteria=example.createCriteria();
        criteria.andIdEqualTo(tid);
        List<Room> list=roomMapper.selectByExample(example);
        if(list.size()<1){
            return null;
        }else{
            return list.get(0);
        }
    }

    @Override
    public List<Room> getRoomsByType(int type) {
        RoomExample example=new RoomExample();
        RoomExample.Criteria criteria=example.createCriteria();
        criteria.andTypeEqualTo(type);
        return roomMapper.selectByExample(example);
    }

    @Override
    public List<Room> getAllRoom() {
        RoomExample example= new RoomExample();
        example.setOrderByClause("roomid asc");
        return roomMapper.selectByExample(example);
    }
}
