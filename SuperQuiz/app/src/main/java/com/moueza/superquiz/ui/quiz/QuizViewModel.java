package com.moueza.superquiz.ui.quiz;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.moueza.superquiz.data.Question;
import com.moueza.superquiz.data.QuestionRepository;

public class QuizViewModel extends ViewModel {


    private final QuestionRepository questionRepository;

    public QuizViewModel(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;


        MutableLiveData<Question> currentQuestion = new MutableLiveData<Question>();
        /*currentQuestion.postValue(questions.get(1));
        currentQuestion.getValue();
        */

        /*
        viewModel.currentQuestion.observe(getViewLifecycleOwner(), new Observer<Question>() {
            @Override
            public void onChanged(Question question) {
                // on récupère ici les mises à jour via la variable question
            }
        });
        */

        MutableLiveData<Integer> score = new MutableLiveData<Integer>(0);
        MutableLiveData<Boolean> isLastQuestion = new MutableLiveData<Boolean>(false);
    }
}

