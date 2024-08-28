package com.mohran.udemy.conroller;

import com.mohran.udemy.dto.CourseDto;
import com.mohran.udemy.service.CourseService;
import com.mohran.udemy.service.CourseStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseStatusController {
    @Autowired
    private CourseStatusService courseStatusService;


    @PostMapping("/{id}/approve")
    public ResponseEntity<CourseDto> approveCourse(@PathVariable Long id) {
        CourseDto approvedCourse = courseStatusService.approveCourse(id);
        return ResponseEntity.ok(approvedCourse);
    }

    @PostMapping("/{id}/reject")
    public ResponseEntity<CourseDto> rejectCourse(@PathVariable Long id) {
        CourseDto rejectedCourse = courseStatusService.rejectCourse(id);
        return ResponseEntity.ok(rejectedCourse);
    }
}
