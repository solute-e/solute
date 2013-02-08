package com.solute.web.controller.loginpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: jcooky
 * Date: 13. 1. 13.
 * Time: 오후 9:43
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping(value = "/loginpage")
public class LoginPageController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getLoginPage() {
        return new ModelAndView("loginpage")
        			.addObject("body_right", "body/right");
    }
}
