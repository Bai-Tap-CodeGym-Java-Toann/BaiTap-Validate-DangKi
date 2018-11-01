package lanaDrahrepus.controllers;

import lanaDrahrepus.model.SignUp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class SignUpController {

    @GetMapping("/")
    public String root() {
        return "redirect:/signUp";
    }

    @GetMapping("/signUp")
    public ModelAndView toSigupPage() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("signUp", new SignUp());
        return modelAndView;
    }

    @PostMapping("/signUp")
    public ModelAndView signHandle(@Valid
                                   @ModelAttribute("signUp") SignUp signUp,
                                   BindingResult bindingResult) {
        new SignUp().validate(signUp,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("index");
        }
        ModelAndView modelAndView =new ModelAndView("reslut");
        modelAndView.addObject("welcome",signUp.getUsername());
        return modelAndView;
    }

}
