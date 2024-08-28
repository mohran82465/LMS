package com.mohran.udemy.service;

import com.mohran.udemy.ExceptionHandler.ResourceNotFoundException;
import com.mohran.udemy.dto.LectureDto;
import com.mohran.udemy.model.Lecture;
import com.mohran.udemy.model.StudentSectionProgress;
import com.mohran.udemy.repository.CourseRepository;
import com.mohran.udemy.repository.LectureRepository;
import com.mohran.udemy.repository.StudentSectionProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LectureService {

    @Autowired
    private LectureRepository lectureRepository;
    @Autowired
    private ConvertLectureService convertLectureDtoToLecture;

    public LectureDto createLecture(LectureDto lectureDto) {
        Lecture lecture = convertLectureDtoToLecture.convertLectureDtoToLecture(lectureDto);
        Lecture savedLecture = lectureRepository.save(lecture);
        return convertLectureDtoToLecture.convertLectureToLectureDto(savedLecture);
    }

    public List<LectureDto> getAllLectures() {
        List<Lecture> lectures = lectureRepository.findAll();
        return lectures.stream()
                .map(x->convertLectureDtoToLecture.convertLectureToLectureDto(x))
                .collect(Collectors.toList());
    }

    public LectureDto getLectureById(Long id) {
        Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lecture not found with id " + id));
        return convertLectureDtoToLecture.convertLectureToLectureDto(lecture);
    }

    public LectureDto updateLecture(Long id, LectureDto lectureDto) {
        Lecture existingLecture = lectureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lecture not found with id " + id));
        Lecture updatedLecture = convertLectureDtoToLecture.updateLectureFromDto(existingLecture, lectureDto);
        lectureRepository.save(updatedLecture);
        return convertLectureDtoToLecture.convertLectureToLectureDto(updatedLecture);
    }

    public void deleteLecture(Long id) {
        Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lecture not found with id " + id));
        lectureRepository.delete(lecture);
    }


}
