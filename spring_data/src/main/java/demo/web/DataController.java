package demo.web;

import demo.dao.PersonRepository;
import demo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Credittone on 2017/4/10.
 */
@Controller
public class DataController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/list")
    public String peson(Model model){
        List<Person> personList=  personRepository.findAll();
        model.addAttribute("personList",personList);
        return "list";
    }

    @RequestMapping(value = "/findPerson",method = RequestMethod.POST)
    public String getPerson(Model model,@RequestParam(value = "name") String name){
        Person person = personRepository.findByName(name);
        model.addAttribute("person",person);
        return "person";
    }


//    @Autowired
//    PersonRepository personRepository;
//
//    @RequestMapping("/index")
//    public String index(){
//        return "welcome";
//    }
//
//
//    @RequestMapping("/save")
//    public Person save(String name, String address, Integer age){
//        Person p = personRepository.save(new Person(null,name,age,address));
//        return p;
//    }

    /**
     * 测试findByAddress
     * @param address
     * @return
     */
//    @RequestMapping("/q1")
//    public List<Person> q1(String address){
//        List<Person> people = personRepository.findByAddress(address);
//        return people;
//    }

    /**
     * 测试findByNameAndAddress
     * @param address
     * @return
     */
//    @RequestMapping("/q2")
//    public Person q2(String name,String address){
//        Person people = personRepository.findByNameAndAddress(name,address);
//        return people;
//    }

    /**
     * 测试withNameAndAddressQuery
     */
//    @RequestMapping("/q3")
//    public Person q3(String name,String address){
//        Person p = personRepository.withNameAndAddressQuery(name,address);
//        return p;
//    }

    /**
     * 测试withNameAndAddressNamedQuery
     */
//    @RequestMapping("/q4")
//    public Person q4(String name,String address){
//        Person p =personRepository.withNameAndAddressNamedQuery(name,address);
//        return p;
//    }

    /**
     * 测试排序
     * @return
     */
//    @RequestMapping("/sort")
//    public List<Person> sort(){
//        List<Person> people = personRepository.findAll(new Sort(Sort.Direction.ASC,"age"));
//        return people;
//    }
//
//    /**
//     * 测试分页
//     */
//    @RequestMapping("/page")
//    public Page<Person> page(){
//        Page<Person> pagePeople = personRepository.findAll(new PageRequest(1,2));
//        return pagePeople;
//    }
}
