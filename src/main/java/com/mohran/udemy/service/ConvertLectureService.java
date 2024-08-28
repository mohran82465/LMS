package com.mohran.udemy.service;

import com.mohran.udemy.ExceptionHandler.ResourceNotFoundException;
import com.mohran.udemy.dto.LectureDto;
import com.mohran.udemy.model.Lecture;
import com.mohran.udemy.model.StudentSectionProgress;
import com.mohran.udemy.repository.CourseRepository;
import com.mohran.udemy.repository.StudentSectionProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ConvertLectureService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentSectionProgressRepository progressRepository;

    public Lecture convertLectureDtoToLecture(LectureDto lectureDto) {
        Lecture lecture = new Lecture();
        lecture.setId(lectureDto.getId());
        lecture.setName(lectureDto.getName());
        lecture.setContent(lectureDto.getContent());
        lecture.setDuration(lectureDto.getDuration());
        lecture.setResources(lectureDto.getResources());
        lecture.setSectiontitle(lectureDto.getSectiontitle());
        lecture.setCourse(courseRepository.findById(lectureDto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + lectureDto.getCourseId())));
        lecture.setProgress(progressRepository.findAllById(lectureDto.getProgressIds()));
        return lecture;
    }

    public LectureDto convertLectureToLectureDto(Lecture lecture) {
        LectureDto lectureDto = new LectureDto();
        lectureDto.setId(lecture.getId());
        lectureDto.setName(lecture.getName());
        lectureDto.setContent(lecture.getContent());
        lectureDto.setDuration(lecture.getDuration());
        lectureDto.setResources(lecture.getResources());
        lectureDto.setSectiontitle(lecture.getSectiontitle());
        lectureDto.setCourseId(lecture.getCourse().getId());
        lectureDto.setProgressIds(lecture.getProgress().stream()
                .map(StudentSectionProgress::getId)
                .collect(Collectors.toList()));
        return lectureDto;
    }

    public Lecture updateLectureFromDto(Lecture lecture, LectureDto lectureDto) {
        lecture.setName(lectureDto.getName());
        lecture.setContent(lectureDto.getContent());
        lecture.setDuration(lectureDto.getDuration());
        lecture.setResources(lectureDto.getResources());
        lecture.setSectiontitle(lectureDto.getSectiontitle());
        lecture.setCourse(courseRepository.findById(lectureDto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + lectureDto.getCourseId())));
        lecture.setProgress(progressRepository.findAllById(lectureDto.getProgressIds()));
        return lecture;
    }
}
