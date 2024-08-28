package com.mohran.udemy.service;

import com.mohran.udemy.ExceptionHandler.ResourceNotFoundException;
import com.mohran.udemy.dto.QuestionDto;
import com.mohran.udemy.dto.QuizDto;
import com.mohran.udemy.model.Question;
import com.mohran.udemy.model.Quiz;
import com.mohran.udemy.model.StudentSectionProgress;
import com.mohran.udemy.repository.CourseRepository;
import com.mohran.udemy.repository.StudentSectionProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
@Service
public class ConvertQuizService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentSectionProgressRepository progressRepository;

    @Autowired
    private ConvertQuestionService convertQuestionService;

    public Quiz convertQuizDtoToQuiz(QuizDto quizDto) {
        Quiz quiz = new Quiz();
        quiz.setSectiontitle(quizDto.getSectiontitle());

        quiz.setCourse(courseRepository.findById(quizDto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + quizDto.getCourseId())));

        quiz.setProgress(progressRepository.findAllById(quizDto.getProgressIds()));

        quiz.setName(quizDto.getName());
        quiz.setDescription(quizDto.getDescription());


        Set<Question> questions = quizDto.getQuestions().stream()
                .map(convertQuestionService::convertQuestionDtoToQuestion)
                .collect(Collectors.toSet());
        quiz.setQuestions(questions);
        return quiz;
    }

    public QuizDto convertQuizToQuizDto(Quiz quiz) {
        QuizDto quizDto = new QuizDto();
        quizDto.setId(quiz.getId());
        quizDto.setSectiontitle(quiz.getSectiontitle());
        quizDto.setCourseId(quiz.getCourse().getId());
        quizDto.setProgressIds(quiz.getProgress().stream()
                .map(StudentSectionProgress::getId)
                .collect(Collectors.toList()));
        quizDto.setName(quiz.getName());
        quizDto.setDescription(quiz.getDescription());
        Set<QuestionDto> questionDtos = quiz.getQuestions().stream()
                .map(convertQuestionService::convertQuestionToQuestionDto)
                .collect(Collectors.toSet());
        quizDto.setQuestions(questionDtos);
        return quizDto;
    }

    public Quiz updateQuizFromDto(Quiz quiz, QuizDto quizDto) {
        quiz.setSectiontitle(quizDto.getSectiontitle());

        quiz.setCourse(courseRepository.findById(quizDto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + quizDto.getCourseId())));

        quiz.setProgress(progressRepository.findAllById(quizDto.getProgressIds()));

        quiz.setName(quizDto.getName());
        quiz.setDescription(quizDto.getDescription());

        Set<Question> questions = quizDto.getQuestions().stream()
                .map(convertQuestionService::convertQuestionDtoToQuestion)
                .collect(Collectors.toSet());
        quiz.setQuestions(questions);
        return quiz;
    }

}
