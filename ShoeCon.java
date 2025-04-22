package com.exa.shoe_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.exa.shoe_project.Model.User;
import com.exa.shoe_project.Service.ShoeServ;


@Controller
public class ShoeCon {
    @Autowired
    ShoeServ ss;

    @GetMapping("/")
    public String Index() {
        return "index";
    }
    
    @GetMapping("/reg")
    public String View(Model m)
    {
        User sh = new User();
        m.addAttribute("sh", sh);
        return "login";
    }
    
    @PostMapping("/save")
    public String Insert(@ModelAttribute("sh") User s)
    {
        ss.savedata(s);
        return "redirect:/";
    }

    @GetMapping("/view")
    public String ViewData(Model m)
    {
        m.addAttribute("sh", ss.viewdata());
        return "view";
    }

    @GetMapping("/delete/{id}")
    public String Delete(@PathVariable ("id") Long i)
    {
        ss.deletedata(i);
        return "redirect:/view";
    }

    @GetMapping("/update/{id}")
    public String Update(@PathVariable ("id") Long i)
    {
        ss.updatedata(i);
        return "redirect:/view";
    }


    @GetMapping("/return")
    public String Return()
    {
        return "redirect:/index";
    }
    @GetMapping("/collection")
    public String Collection()
    {
        return "collection";
    }
    
    // @GetMapping("/h")
    // public String Home()
    // {
    //     return "redirect:/index";
    // }

    @GetMapping("/acs")
    public String Asc()
    {
        return "accessories" ;
    }
    @GetMapping("/cart")
    public String Cart()
    {
        return "cart" ;
    }
}
