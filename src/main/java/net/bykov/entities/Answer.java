package net.bykov.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The persistent class for the answer database table.
 */

@Entity
@Table(name = "answer", schema = "public")
@NamedQuery(name = "Answer.findAll", query = "SELECT a FROM Answer a")
public class Answer extends AbstractMainEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "ID_ANSWER_GENERATOR", sequenceName = "answer_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_ANSWER_GENERATOR")
    @Column(name = "id_answer", unique = true, nullable = false)
    private long idAnswer;

    @Basic
    @Column(name = "id_question", unique = true, nullable = false, insertable = false, updatable = false)
    private long idQuestion;

    @Basic
    @Column(name = "text", nullable = false)
    private String text;

    @Basic
    @Column(name = "correct", nullable = false)
    private boolean correct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_question", referencedColumnName = "id_question", nullable = false)
    private Question questionByIdQuestion;

    public Answer() {
    }

    public long getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(long idAnswer) {
        this.idAnswer = idAnswer;
    }

    public long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Override
    public Serializable getId() {
        return getIdAnswer();
    }

    public Question getQuestionByIdQuestion() {
        return questionByIdQuestion;
    }

    public void setQuestionByIdQuestion(Question questionByIdQuestion) {
        this.questionByIdQuestion = questionByIdQuestion;
    }
}
