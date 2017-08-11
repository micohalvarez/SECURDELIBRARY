package app.com.controller;

import app.com.model.Comment;
import app.com.model.Resource;
import app.com.model.Status;
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
    @RequestMapping(value={"/gotoRes"}, method = RequestMethod.POST)
    public ModelAndView gotoRes(ModelAndView model, @ModelAttribute User user, HttpServletRequest request){
        String keyword = request.getParameter("resourceID");
        int userid = Integer.parseInt(request.getParameter("userid"));
        keyword = keyword.trim();

        Resource book = resourceDAO.getBookByTitle(keyword).get(0);
        List<Comment> comments;

        List<Status> status = resourceDAO.getBookStatus(book.getResourceID(),userid);
        model.addObject("userid",userid);
        model.addObject("book",book);
        model.addObject("status",status);
        model.setViewName("resource");
        return model;

    }

    @RequestMapping(value={"/search"}, method = RequestMethod.POST)
    public ModelAndView search(ModelAndView model, HttpSession session, HttpServletRequest request){
        String keyword = request.getParameter("keyword");
        String userID = request.getParameter("id");
        User user = (User) session.getAttribute("user");
        System.out.print(user.getFirstname());
        String rb = request.getParameter("inlineRadioOptions");
        List<Resource> bookList = null;

        if(rb.contains("1")){

           bookList =  resourceDAO.getBooks(keyword);
        }
        else if(rb.contains("2")){

            bookList = resourceDAO.getBooksByTitle(keyword);

        }
            else if(rb.contains("3")){

            bookList = resourceDAO.getBooksByAuthor(keyword);
        }


        model.addObject("bookList",bookList);
        model.addObject("userID",userID);
        model.addObject("keyword",keyword);
        model.setViewName("search");
        return model;


    }

}
