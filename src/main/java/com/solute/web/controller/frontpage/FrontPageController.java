package com.solute.web.controller.frontpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/frontpage")
public class FrontPageController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getPage() {
        return new ModelAndView("frontpage");
    }
}
