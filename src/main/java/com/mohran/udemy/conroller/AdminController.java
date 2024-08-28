package com.mohran.udemy.conroller;

import com.mohran.udemy.ExceptionHandler.ResourceNotFoundException;
import com.mohran.udemy.dto.AdminDto;
import com.mohran.udemy.dto.StudentDto;
import com.mohran.udemy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @GetMapping
    public ResponseEntity<List<AdminDto>> getAllAdmins(){
        List<AdminDto> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminDto> getAdminById(@PathVariable Long id)
    {
        AdminDto adminDto = adminService.getAdminById(id);
        return ResponseEntity.ok(adminDto);
    }

    @PostMapping
    public ResponseEntity<AdminDto> creaetNewAdmin(@RequestBody AdminDto adminDto)
    {
        AdminDto admindto = adminService.saveAdmin(adminDto);
        return ResponseEntity.ok(admindto);
    }
    @PutMapping
    public ResponseEntity<AdminDto> updateAdmin(@PathVariable Long id,@RequestBody AdminDto updateAdminDto)
    {
        AdminDto adminDto = adminService.updateAdmin(id,updateAdminDto);
        return ResponseEntity.ok(adminDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id)
    {
        adminService.deleteAdmin(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
