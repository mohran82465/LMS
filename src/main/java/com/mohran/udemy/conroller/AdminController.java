package com.mohran.udemy.conroller;

import com.mohran.udemy.dto.AdminDto;
import com.mohran.udemy.dto.StudentDto;
import com.mohran.udemy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @GetMapping
    public ResponseEntity<List<AdminDto>> getAllStudent(){
        List<AdminDto> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }


}
