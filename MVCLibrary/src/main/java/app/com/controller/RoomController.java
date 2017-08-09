package app.com.controller;

import app.com.model.Room;
import app.com.model.User;
import app.com.service.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Micoh F Alvarez on 8/9/2017.
 */
@Controller
public class RoomController {
    @Autowired
    private RoomDAO rs;

    @RequestMapping(value={"/reserveRoom"}, method = RequestMethod.POST)
    public ModelAndView reserveRoom(ModelAndView model, @ModelAttribute User user) {


        List<Room> room = rs.getAllRooms();
        return null;
    }
}
