package org.arip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Arip Hidayat on 3/30/2017.
 */
@Controller
public class HelloController {

    private static final String ATTRIBUTE = "message";

    private @Autowired HttpServletRequest request;

    @RequestMapping(value = {"/", "hello"}, method = RequestMethod.GET)
    public String getHello(Model model) {
        Message message = (Message) request.getSession().getAttribute(ATTRIBUTE);
        if (message == null) {
            message = new Message("Hello World!");
        }

        model.addAttribute(ATTRIBUTE, message);

        return "hello";
    }

    @RequestMapping(value = "hello/new", method = RequestMethod.GET)
    public String newHello(@ModelAttribute(ATTRIBUTE) Message message) {
        return "form";
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    public String saveHello(@ModelAttribute(ATTRIBUTE) Message message) {
        request.getSession().setAttribute(ATTRIBUTE, message);

        return "redirect:/hello";
    }

    @RequestMapping(value = "hello/remove", method = RequestMethod.GET)
    public String saveHello() {
        request.getSession().removeAttribute(ATTRIBUTE);

        return "redirect:/hello";
    }
}
