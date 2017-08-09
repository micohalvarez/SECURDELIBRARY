package app.com.controller;

import app.com.model.Resource;
import app.com.model.User;
import app.com.service.ResourceDAO;
import app.com.service.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Micoh F Alvarez on 8/9/2017.
 */
@Controller
public class HomeController {


    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ResourceDAO resourceDAO;

    @RequestMapping("/homepage")
    public void home(ModelAndView model, @ModelAttribute User user){



    }
}
