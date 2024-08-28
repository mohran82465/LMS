package com.mohran.udemy.conroller;

import com.mohran.udemy.dto.LectureDto;
import com.mohran.udemy.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lectures")
public class LectureController {
    @Autowired
    private  LectureService lectureService;


    @PostMapping
    public ResponseEntity<LectureDto> createLecture(@RequestBody LectureDto lectureDto) {
        LectureDto createdLecture = lectureService.createLecture(lectureDto);
        return ResponseEntity.ok(createdLecture);
    }

    @GetMapping
    public ResponseEntity<List<LectureDto>> getAllLectures() {
        List<LectureDto> lectures = lectureService.getAllLectures();
        return ResponseEntity.ok(lectures);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LectureDto> getLectureById(@PathVariable Long id) {
        LectureDto lecture = lectureService.getLectureById(id);
        return ResponseEntity.ok(lecture);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LectureDto> updateLecture(@PathVariable Long id, @RequestBody LectureDto lectureDto) {
        LectureDto updatedLecture = lectureService.updateLecture(id, lectureDto);
        return ResponseEntity.ok(updatedLecture);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLecture(@PathVariable Long id) {
        lectureService.deleteLecture(id);
        return ResponseEntity.noContent().build();
    }
}
