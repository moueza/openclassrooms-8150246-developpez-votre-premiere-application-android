package com.moueza.superquiz.data;

import java.util.List;

public class QuestionRepository {
    private List<String> questions;


    public QuestionRepository(QuestionBank qb) {

    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }


}
