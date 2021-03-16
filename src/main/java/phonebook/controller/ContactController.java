package phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import phonebook.entity.Contact;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {
    private List<Contact> contacts;

    public ContactController(){
        this.contacts = new ArrayList<>();
    }


    @GetMapping("/")
    public ModelAndView getAll(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        modelAndView.addObject("contacts", this.contacts);

        return modelAndView;
    }

    @PostMapping("/")
    public String save(Contact contact){
        this.contacts.add(contact);
        return "redirect:/";
    }

    @DeleteMapping("/")
    public String delete(Contact contact){
        contacts.remove(contact);
        return "redirect:/";
    }
}
