package com.exa.shoe_project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exa.shoe_project.Model.User;
import com.exa.shoe_project.Repository.ShoeRepository;

@Service
public class ShoeServ {
    @Autowired
    ShoeRepository sr;

    public User savedata(User s)
    {
        return sr.save(s);
    }

    public List<User> viewdata()
    {
           return sr.findAll();
    }

    public void deletedata(Long i)
    {
         sr.deleteById(i);
    }

    public String updatedata(Long i)
    {
        Optional<User> u = sr.findById(i);
        User a = null;
        if(u.isPresent()) 
        {
            a = u.get();
        }
        else {
            throw new RuntimeException("Id id not found..." + i);   
        }
        return "a";
    }
}
