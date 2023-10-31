package com.moueza.superquiz.ui.quiz;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.moueza.superquiz.data.Question;
import com.moueza.superquiz.data.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

public class QuizViewModel extends ViewModel {


    private final QuestionRepository questionRepository;
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
    private List<Question> questions = new ArrayList<Question>();
    //int choice = -99;
    private int currentQuestionIndex = 0;

    public QuizViewModel(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;

    }

    public void startQuiz() {
        this.questions = this.questionRepository.getQuestions();
        this.currentQuestion.postValue(this.questions.get(currentQuestionIndex));

    }


    public void nextQuestion() {
        currentQuestionIndex++;
        currentQuestion.postValue(this.questions.get(currentQuestionIndex));

        //isLastQuestion = (this.questionIndex == this.questions.size() - 1);
        isLastQuestion.postValue(this.currentQuestionIndex == this.questions.size() - 1);//++++
    }


    public boolean isAnswerValid(int answerIndex) {
        Question question = currentQuestion.getValue();
        boolean isGoodAnswer = (question != null) && (answerIndex == question.getAnswerIndex());

        Integer currentScore = score.getValue();
        if ((currentScore != null) && isGoodAnswer) {
            //score = score + 1;
            score.postValue(currentScore + 1);//++++ vs setValue
        }

        return isGoodAnswer;
    }

   
}

