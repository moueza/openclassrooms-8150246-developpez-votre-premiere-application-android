package com.moueza.superquiz.data;

import java.util.List;

public class QuestionRepository {
    private final QuestionBank questionBank;

    public QuestionRepository(QuestionBank questionBank) {
        this.questionBank = questionBank;
    }


    public List<Question> getQuestions() {
        return questionBank.getQuestions();
    }

   /* public void setQuestionBank(QuestionBank questionBank) {
        this.questionBank = questionBank;//Cannot assign a value to final variable 'questionBank'
    }*/


}
