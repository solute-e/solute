package com.solute.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/mtest")
public class TestController {

    public static class Model {
        private String id;
        private String msg;

        public Model() {
            super();
        }

        public Model(String id, String msg) {
            this.id = id;
            this.msg = msg;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getId() {
            return id;
        }

        public String getMsg() {
            return msg;
        }
    }

    private Map<String, Model> models = new HashMap<String, Model>();
    public TestController() {
        models.put("1", new Model("1", "1이다."));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Model get(@PathVariable String id) {
        return models.get(id);
    }

    @RequestMapping(value = "/{id}/{msg}", method = RequestMethod.PUT)
    public @ResponseBody
    void put(@PathVariable String id, @PathVariable String msg) {

        models.put(id, new Model(id, msg));
    }

    @RequestMapping(value = "/{id}/{msg}", method = RequestMethod.DELETE)
    public @ResponseBody
    void delete(@PathVariable String id) {

        models.remove(id);
    }

    @RequestMapping(value = "/{id}/{msg}", method = RequestMethod.POST)
    public @ResponseBody
    void update(@PathVariable String id, @PathVariable String msg) {

        models.get(id).setMsg(msg);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView getPage() {
        return new ModelAndView("test");
    }
}
