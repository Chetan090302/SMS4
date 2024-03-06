package com.studentManagement.controller;

import com.studentManagement.entity.User;
import com.studentManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private UserRepo userRepo;

    @ModelAttribute
    public void commonUser(Principal p, Model m)
    {
        if (p != null) {
            String email = p.getName();
            User user = userRepo.findByUserId(email);
            m.addAttribute("user", user);
        }
    }
    @GetMapping("/profile")
    public String profile()
    {
        return "teacher_profile";
    }
}
