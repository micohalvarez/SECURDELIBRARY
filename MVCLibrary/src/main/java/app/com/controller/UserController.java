package app.com.controller;

import app.com.model.User;
import app.com.service.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Micoh F Alvarez on 8/9/2017.
 */
@Controller

public class UserController {
    @Autowired
    private UserDAO userdao;


    @RequestMapping(value={"/"}, method = RequestMethod.POST)
    public ModelAndView init(ModelAndView model) {
        model.addObject("user", new User());
        model.setViewName("index");
        return model;
    }
    @RequestMapping(value={"/signIn"}, method = RequestMethod.POST)
    public ModelAndView signIn(ModelAndView model, @ModelAttribute User user, HttpSession session) {

        User us = userdao.getUserbyUN(user.getUsername()).get(0);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(user.getPassword(), us.getPassword()) && us.getLocked() == 0)
        {

            model.addObject("user",us);
            session.setAttribute("user", us);
            model.setViewName("home");
            return model;

        }
        List<User> users = userdao.getUser(user.getUsername(),user.getPassword());
        if(users.size() > 0) {
            model.addObject("user",users.get(0));
            session.setAttribute("user", users.get(0));
            model.setViewName("home");
            return model;
        }

        userdao.updatelog(us.getUsername());
        session.setAttribute("user", users.get(0));
        model.setViewName("index");

        return model;
    }

    @RequestMapping(value={"/signUp"}, method = RequestMethod.POST)
    public ModelAndView signUp(ModelAndView model,@ModelAttribute("user") User user, HttpServletRequest request) {
    int userType = Integer.parseInt(request.getParameter("userType"));
    if(userType == 1) {
        user.setUserType(1);
    }
        if(userdao.addUser(user) == 1)
            return new ModelAndView("redirect:/index.jsp");
        else {

            model.addObject("usertype", 0);
            model.addObject("user1", new User());
            model.setViewName("register");
            return model;
        }

    }

    @RequestMapping(value={"/reguser"}, method = RequestMethod.POST)
    public ModelAndView reguser(ModelAndView model) {
        model.addObject("usertype", 0);
        model.addObject("user", new User());
        model.setViewName("register");
        return model;
    }
    @RequestMapping(value={"/creuser"}, method = RequestMethod.POST)
    public ModelAndView createUser(ModelAndView model, HttpServletRequest request) {
        String usertype = request.getParameter("admin");
        model.addObject("usertype", usertype);
        model.addObject("user", new User());
        model.setViewName("register");
        return model;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
