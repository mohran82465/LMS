package com.mohran.udemy.service;

import com.mohran.udemy.ExceptionHandler.ResourceNotFoundException;
import com.mohran.udemy.dto.QuestionDto;
import com.mohran.udemy.dto.QuizDto;
import com.mohran.udemy.model.Question;
import com.mohran.udemy.model.Quiz;
import com.mohran.udemy.model.StudentSectionProgress;
import com.mohran.udemy.repository.CourseRepository;
import com.mohran.udemy.repository.StudentSectionProgressRepository;
import com.mohran.udemy.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private ConvertQuizService convertQuizService;

    public QuizDto createQuiz(QuizDto quizDto) {
        Quiz quiz = convertQuizService.convertQuizDtoToQuiz(quizDto);
        Quiz savedQuiz = quizRepository.save(quiz);
        return convertQuizService.convertQuizToQuizDto(savedQuiz);
    }

    public List<QuizDto> getAllQuizzes() {
        List<Quiz> quizzes = quizRepository.findAll();
        return quizzes.stream()
                .map(x ->convertQuizService.convertQuizToQuizDto(x))
                .collect(Collectors.toList());
    }

    public QuizDto getQuizById(Long id) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + id));
        return convertQuizService.convertQuizToQuizDto(quiz);
    }

    public QuizDto updateQuiz(Long id, QuizDto quizDto) {
        Quiz existingQuiz = quizRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + id));
        Quiz updatedQuiz = convertQuizService.updateQuizFromDto(existingQuiz, quizDto);
        quizRepository.save(updatedQuiz);
        return convertQuizService.convertQuizToQuizDto(updatedQuiz);
    }

    public void deleteQuiz(Long id) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + id));
        quizRepository.delete(quiz);
    }
}
