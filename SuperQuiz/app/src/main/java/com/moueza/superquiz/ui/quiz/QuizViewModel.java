package com.moueza.superquiz.ui.quiz;

import androidx.lifecycle.ViewModel;

import com.moueza.superquiz.data.QuestionRepository;

public class QuizViewModel extends ViewModel {


    private final QuestionRepository questionRepository;

    public QuizViewModel(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
}

