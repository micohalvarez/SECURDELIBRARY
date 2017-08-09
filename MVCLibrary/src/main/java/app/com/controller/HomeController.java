package app.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Micoh F Alvarez on 8/9/2017.
 */
@Controller
public class HomeController {

    @RequestMapping(value ="/")
        public String home(){
        return "test";

    }

}
