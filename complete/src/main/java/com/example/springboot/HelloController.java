package com.example.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ui.Model;

@Controller
public class HelloController {

	// @GetMapping("/")
	// public String index() {
	// 	return "Greetings from Spring Boot!";
    // }
    
    @GetMapping("/")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
    }
    
    @GetMapping("/contact")
    public String contact(Model model){
        return "contact";
    }

    @PostMapping("/contact")
    public String postContact(Model model, @RequestBody Contact contact){
        //Contact create object
        model.addAttribute("email", contact.getEmail());
        model.addAttribute("message",contact.getMessage());
        //return "contact";
        return "fragments/contactResponse ::#contactSuccess";
    }

    @GetMapping("/about")
    public String about(Model model){
        return "about";
    }

    @GetMapping("/blog")
    public String blog(Model model){
        return "blog";
    }

    @PostMapping("/blog")
    public String postBlog(Model model, @RequestBody Blog blog){
        model.addAttribute("message", blog.getMessage());
        return "fragments/blogResponse ::#blogSuccess";
    }
}
