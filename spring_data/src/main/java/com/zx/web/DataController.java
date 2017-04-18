package com.zx.web;

import com.zx.dao.PersonRepository;
import com.zx.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Credittone on 2017/4/10.
 */
@Controller
public class DataController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/auto")
    public String auto(Model model,Person person){
        Page<Person> pagePeople = personRepository.findByAuto(person,new PageRequest(0,10));
        model.addAttribute("person",person);
        return "person";
    }
}
