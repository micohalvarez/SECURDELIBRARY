package app.com.controller;

import app.com.model.Resource;
import app.com.model.User;
import app.com.service.ResourceDAO;
import app.com.service.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    @RequestMapping(value={"/search"}, method = RequestMethod.POST)
    public ModelAndView search(ModelAndView model, @ModelAttribute User user, HttpServletRequest request){
        String keyword = request.getParameter("keyword");
        String rb = request.getParameter("inlineRadioOptions");
        List<Resource> bookList = null;

        if(rb.contains("1")){
            System.out.println("keyword");
           bookList =  resourceDAO.getBooks(keyword);
        }
        else if(rb.contains("2")){
            System.out.println("Title");
            bookList = resourceDAO.getBooksByTitle(keyword);

        }
            else if(rb.contains("3")){
            System.out.println("AUTHOR");
            bookList = resourceDAO.getBooksByAuthor(keyword);
        }

        System.out.println(bookList.size());

        model.addObject("bookList",bookList);
        model.addObject("user",user);
        model.setViewName("home");
        return model;


    }
}
