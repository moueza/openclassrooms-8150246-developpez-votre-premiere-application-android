package com.moueza.superquiz.ui.quiz;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.moueza.superquiz.data.Question;
import com.moueza.superquiz.data.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

public class QuizViewModel extends ViewModel {


    private final QuestionRepository questionRepository;
    public List<Question> questions = new ArrayList<Question>();
    MutableLiveData<Question> currentQuestion = new MutableLiveData<Question>();
    /*currentQuestion.postValue(questions.get(1));
    currentQuestion.getValue();
    */
    MutableLiveData<Integer> score = new MutableLiveData<Integer>(0);
    /*
    viewModel.currentQuestion.observe(getViewLifecycleOwner(), new Observer<Question>() {
        @Override
        public void onChanged(Question question) {
            // on récupère ici les mises à jour via la variable question
        }
    });
    */
    MutableLiveData<Boolean> isLastQuestion = new MutableLiveData<Boolean>(false);
    //int choice = -99;
    int questionIndex = 0;

    public QuizViewModel(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;

    }

    public void startQuiz() {
        this.questions = this.questionRepository.getQuestions();
        currentQuestion.postValue(this.questions.get(questionIndex));

    }

    public boolean isAnswerValid(int choice) {
        boolean isGoodAnswer = (choice == currentQuestion.getValue().getAnswerIndex());
        if (isGoodAnswer) {
            //score = score + 1;
            score.postValue(this.score.getValue() + 1);//++++
        }

        return isGoodAnswer;
    }

    public void nextQuestion() {
        questionIndex++;
        currentQuestion.postValue(this.questions.get(questionIndex));

        //isLastQuestion = (this.questionIndex == this.questions.size() - 1);
        isLastQuestion.postValue(this.questionIndex == this.questions.size() - 1);//++++
    }
}

