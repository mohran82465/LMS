package com.mohran.udemy.service;

import com.mohran.udemy.ExceptionHandler.ResourceNotFoundException;
import com.mohran.udemy.dto.AdminDto;
import com.mohran.udemy.model.Admin;
import com.mohran.udemy.repository.AdminRepository;
import com.mohran.udemy.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository ;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ConvertAdminService convertAdminService;

    public List<AdminDto> getAllAdmins(){
        List<Admin>  admins = adminRepository.findAll();
        List<AdminDto> adminDtoList = new ArrayList<>();
        for (Admin admin : admins){
            adminDtoList.add(convertAdminService.convertAdminToAdminDto(admin));
        }
        return adminDtoList;
    }

    public AdminDto getAdminById(Long id){
        AdminDto adminDto = convertAdminService.convertAdminToAdminDto(adminRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Admin not found with id " + id)));
        return adminDto;
    }

    public AdminDto saveAdmin(AdminDto adminDto)
    {
        Admin admin= convertAdminService.convertAdminDtoToAdmin(adminDto);
        adminRepository.save(admin);
        return adminDto;
    }

    public void deleteAdmin(Long id)
    {
        adminRepository.deleteById(id);
    }

}
