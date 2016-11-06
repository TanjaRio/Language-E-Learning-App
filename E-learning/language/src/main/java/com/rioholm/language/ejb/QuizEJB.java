package com.rioholm.language.ejb;

import no.westerdals.quiz.entity.QuizEntity;
import no.westerdals.quiz.entity.SubSubCategory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
@Stateless
public class QuizEJB {
    @Inject
    private SubSubCategoryEJB subSubCategoryEJB;

    @PersistenceContext
    private EntityManager em;

    public Long createQuiz(String question, List<String> answers, String correctAnswer, String subSubCategoryName) {
        QuizEntity quiz = new QuizEntity();
        quiz.setQuestion(question);
        quiz.setAnswers(answers);
        quiz.setCorrectAnswer(correctAnswer);

        SubSubCategory category = subSubCategoryEJB.findSubSubCategory(subSubCategoryName);
        quiz.setSubSubCategory(category);
        em.persist(quiz);
        category.getQuizEntities().add(quiz);

        return quiz.getQuizId();
    }

    public boolean isCorrectAnswer(String answer, Long quizId) {
        QuizEntity quizEntity = em.find(QuizEntity.class, quizId);
        if (answer == quizEntity.getCorrectAnswer()) {
            return true;
        }

        return false;
    }

    public QuizEntity findQuiz(Long quizId) {
        QuizEntity quizEntity = em.find(QuizEntity.class, quizId);
        return quizEntity;
    }

    public List<QuizEntity> getAll(){
        Query query = em.createQuery("select q from QuizEntity q");
        return query.getResultList();
    }

    public boolean deleteQuizEntity(Long quizId){
        QuizEntity quizEntity = em.find(QuizEntity.class, quizId);
        if(quizEntity != null){
            em.remove(quizEntity);
            return true;
        }
        return false;
    }
}
