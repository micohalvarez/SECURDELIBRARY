package app.com.service;

import app.com.model.Room;

import java.util.List;

/**
 * Created by Micoh F Alvarez on 8/9/2017.
 */
public interface RoomDAO {

    public void reserveRoom(int roomID, int userID);
    public void freeRoom(int roomID, int userID);
    public List<Room> getFreeRooms(Room room);
    public List<Room> getAllRooms();

}
