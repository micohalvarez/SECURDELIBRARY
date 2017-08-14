package app.com.controller;

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
import java.util.List;

/**
 * Created by Micoh F Alvarez on 8/9/2017.
 */
@Controller
public class ResourceController {


    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ResourceDAO resourceDAO;


    @RequestMapping(value={"/borrowBook"}, method = RequestMethod.POST)
    public ModelAndView borrowbook(ModelAndView model, @ModelAttribute User user, HttpServletRequest request){
        String keyword = request.getParameter("resourceID");
        int bookid = Integer.parseInt(request.getParameter("bookid"));
        int userid = Integer.parseInt(request.getParameter("userID"));

        Resource book = resourceDAO.getBooks(Integer.parseInt(keyword)).get(0);
        List<Status> status = resourceDAO.getBookStatus(book.getResourceID(),userid);

        model.addObject("userid",userid);
        model.addObject("book",book);
        model.addObject("status",status);
        resourceDAO.borrowBook(bookid,userid);
        return new ModelAndView("redirect:/resource.jsp");

    }

    @RequestMapping(value={"/bookdet"}, method = RequestMethod.POST)
    public ModelAndView bookdet(ModelAndView model, HttpServletRequest request){


        int userid = Integer.parseInt(request.getParameter("userid"));

        List<Resource> resources = resourceDAO.getAllBooks();

        model.addObject("userid",userid);
        model.addObject("resources",resources);
        model.setViewName("bookdetails");
        return model;

    }

    @RequestMapping(value={"/addbook"}, method = RequestMethod.POST)
    public ModelAndView addBook(ModelAndView model, HttpServletRequest request){


        int userid = Integer.parseInt(request.getParameter("userid"));
        System.out.println(userid);

        model.addObject("userid",userid);
        model.addObject("resource", new Resource());
        model.setViewName("bookform");
        return model;

    }

    @RequestMapping(value={"/editbook"}, method = RequestMethod.POST)
    public ModelAndView editBook(ModelAndView model, HttpServletRequest request){

        String keyword = request.getParameter("title");
        keyword = keyword.trim();

        int userid = Integer.parseInt(request.getParameter("userid"));

        Resource book = resourceDAO.getBookByTitle(keyword).get(0);

        List<Status> status = resourceDAO.getBookStatus(book.getResourceID(),userid);
        model.addObject("userid",userid);
        model.addObject("book",book);
        model.addObject("resource", new Resource());
        model.setViewName("editbook");
        return model;

    }
    @RequestMapping(value={"/updatebook"}, method = RequestMethod.POST)
    public ModelAndView updatebook(@ModelAttribute("resource") Resource r,ModelAndView model, HttpServletRequest request){
        int userid = Integer.parseInt(request.getParameter("userid"));
        resourceDAO.editBook(r);
        List<Resource> resources = resourceDAO.getAllBooks();

        model.addObject("userid",userid);
        model.addObject("resources",resources);
        model.setViewName("bookdetails");
        System.out.print(userid+ " YESS");
        return model;

    }
    @RequestMapping(value={"/makebook"}, method = RequestMethod.POST)
    public ModelAndView makebook(@ModelAttribute("resource") Resource r,ModelAndView model, HttpServletRequest request){


        int userid = Integer.parseInt(request.getParameter("userid"));
        resourceDAO.addBook(r);
        List<Resource> resources = resourceDAO.getAllBooks();

        model.addObject("userid",userid);
        model.addObject("resources",resources);
        model.setViewName("home");
        System.out.print(userid+ " YESS");
        return model;

    }

    @RequestMapping(value={"/deletebook"}, method = RequestMethod.POST)
    public ModelAndView deletebook(@ModelAttribute("resource") Resource r,ModelAndView model, HttpServletRequest request){
        System.out.print("DELETE METHOD");

        int userid = Integer.parseInt(request.getParameter("userid"));
        int bookid = Integer.parseInt(request.getParameter("bookid"));

        resourceDAO.deleteBook(bookid);
        List<Resource> resources = resourceDAO.getAllBooks();

        model.addObject("userid",userid);
        model.addObject("resources",resources);
        model.setViewName("home");
        System.out.print(userid+ " YESS");
        return model;

    }
}
