package com.mohran.udemy.service;

import com.mohran.udemy.ExceptionHandler.ResourceNotFoundException;
import com.mohran.udemy.dto.QuestionDto;
import com.mohran.udemy.model.Question;
import com.mohran.udemy.model.Quiz;
import com.mohran.udemy.repository.QuestionRepository;
import com.mohran.udemy.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private ConvertQuestionService convertQuestionService;

    public QuestionDto createQuestion(QuestionDto questionDto) {
        Quiz quiz = quizRepository.findById(questionDto.getQuizId())
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + questionDto.getQuizId()));
        Question question = convertQuestionService.convertQuestionDtoToQuestion(questionDto);
        question.setQuiz(quiz);
        Question savedQuestion = questionRepository.save(question);
        return convertQuestionService.convertQuestionToQuestionDto(savedQuestion);
    }

    public List<QuestionDto> getAllQuestions() {
        List<Question> questions = questionRepository.findAll();
        List<QuestionDto> questionDtos = new ArrayList<>();
        for (Question question : questions) {
            questionDtos.add(convertQuestionService.convertQuestionToQuestionDto(question));
        }
        return questionDtos;
    }

    public QuestionDto getQuestionById(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + id));
        return convertQuestionService.convertQuestionToQuestionDto(question);
    }

    public QuestionDto updateQuestion(Long id, QuestionDto updateQuestionDto) {
        Question existingQuestion = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + id));
        Question updatedQuestion = convertQuestionService.update(updateQuestionDto, existingQuestion);
        questionRepository.save(updatedQuestion);
        return convertQuestionService.convertQuestionToQuestionDto(updatedQuestion);
    }

    public void deleteQuestion(Long id) {
        Question existingQuestion = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + id));
        questionRepository.delete(existingQuestion);
    }
}
