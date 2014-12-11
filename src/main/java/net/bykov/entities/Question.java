package net.bykov.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the question database table.
 */

@Entity
@Table(name = "question", schema = "public")
@NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q")
public class Question extends AbstractMainEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "ID_QUESTION_GENERATOR", sequenceName = "question_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_QUESTION_GENERATOR")
    @Column(name = "id_question", unique = true, nullable = false)
    private long idQuestion;

    @Basic
    @Column(name = "id_test", insertable = false, updatable = false)
    private long idTest;

    @Basic
    @Column(name = "question")
    private String question;

    @OneToMany(mappedBy = "questionByIdQuestion")
    private List<Answer> answersByIdQuestion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_test", referencedColumnName = "id_test", nullable = false)
    private Test testByIdTest;

    public Question() {
    }

    public long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public long getIdTest() {
        return idTest;
    }

    public void setIdTest(long idTest) {
        this.idTest = idTest;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public Serializable getId() {

        return getIdQuestion();
    }

    public List<Answer> getAnswersByIdQuestion() {
        return answersByIdQuestion;
    }

    public void setAnswersByIdQuestion(List<Answer> answersByIdQuestion) {
        this.answersByIdQuestion = answersByIdQuestion;
    }

    public Test getTestByIdTest() {
        return testByIdTest;
    }

    public void setTestByIdTest(Test testByIdTest) {
        this.testByIdTest = testByIdTest;
    }
}
