package com.moueza.superquiz.data;

public class QuestionRepository {
    private final QuestionBank questionBank;

    public QuestionRepository(QuestionBank questionBank) {
        this.questionBank = questionBank;
    }


    public QuestionBank getQuestionBank() {
        return questionBank;
    }

   /* public void setQuestionBank(QuestionBank questionBank) {
        this.questionBank = questionBank;//Cannot assign a value to final variable 'questionBank'
    }*/


}
