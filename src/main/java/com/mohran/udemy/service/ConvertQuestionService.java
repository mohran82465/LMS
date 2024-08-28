package com.mohran.udemy.service;

import com.mohran.udemy.dto.QuestionDto;
import com.mohran.udemy.model.Question;
import com.mohran.udemy.model.Quiz;
import com.mohran.udemy.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertQuestionService {

    private final QuizRepository quizRepository;

    @Autowired
    public ConvertQuestionService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public QuestionDto convertQuestionToQuestionDto(Question question) {
        QuestionDto questionDto = new QuestionDto();

        if (question.getId() != null) {
            questionDto.setId(question.getId());
        }

        if (question.getQuestionContent() != null) {
            questionDto.setQuestionContent(question.getQuestionContent());
        }

        if (question.getOptions() != null) {
            questionDto.setOptions(question.getOptions());
        }

        if (question.getCorrectAnswer() != null) {
            questionDto.setCorrectAnswer(question.getCorrectAnswer());
        }

        if (question.getQuiz() != null && question.getQuiz().getId() != null) {
            questionDto.setQuizId(question.getQuiz().getId());
        }

        return questionDto;
    }

    public Question convertQuestionDtoToQuestion(QuestionDto questionDto) {
        Question question = new Question();

        if (questionDto.getId() != null) {
            question.setId(questionDto.getId());
        }

        if (questionDto.getQuestionContent() != null) {
            question.setQuestionContent(questionDto.getQuestionContent());
        }

        if (questionDto.getOptions() != null) {
            question.setOptions(questionDto.getOptions());
        }

        if (questionDto.getCorrectAnswer() != null) {
            question.setCorrectAnswer(questionDto.getCorrectAnswer());
        }

        if (questionDto.getQuizId() != null) {
            Quiz quiz = quizRepository.findById(questionDto.getQuizId())
                    .orElseThrow(() -> new IllegalArgumentException("Quiz not found"));
            question.setQuiz(quiz);
        }

        return question;
    }

    public Question update(QuestionDto questionDto, Question question) {

        if (questionDto.getQuestionContent() != null) {
            question.setQuestionContent(questionDto.getQuestionContent());
        }

        if (questionDto.getOptions() != null) {
            question.setOptions(questionDto.getOptions());
        }

        if (questionDto.getCorrectAnswer() != null) {
            question.setCorrectAnswer(questionDto.getCorrectAnswer());
        }

        if (questionDto.getQuizId() != null) {
            Quiz quiz = quizRepository.findById(questionDto.getQuizId())
                    .orElseThrow(() -> new IllegalArgumentException("Quiz not found"));
            question.setQuiz(quiz);
        }

        return question;
    }
}
