package app.com.controller;

import app.com.model.User;
import app.com.service.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value={"/signIn"}, method = RequestMethod.POST)
    public ModelAndView signIn(ModelAndView model, @ModelAttribute User user) {


        return null;
    }
    @RequestMapping(value={"/signUp"}, method = RequestMethod.POST)
    public ModelAndView signUp(@ModelAttribute("user") User user) {
        System.out.print(user.getEmail());
        userdao.addUser(user);
        return new ModelAndView("redirect:/index");
    }
    @RequestMapping(value={"/reguser"}, method = RequestMethod.POST)
    public ModelAndView reguser(ModelAndView model) {
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
