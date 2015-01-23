package net.bykov.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the test database table.
 */
@Entity
@Table(name = "test", schema = "public")
@NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t")
public class Test extends AbstractMainEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "ID_TEST_GENERATOR", sequenceName = "test_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_TEST_GENERATOR")
    @Column(name = "id_test", unique = true, nullable = false)
    private long idTest;

    @Basic
    @Column(name = "id_tutor", insertable = false, updatable = false)
    private long idTutor;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "time", nullable = false)
    private Integer time;

    @OneToMany(mappedBy = "testByIdTest")
    private List<Question> questionsByIdTest;

    @OneToMany(mappedBy = "testByIdTest")
    private List<Result> resultsByIdTest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tutor", referencedColumnName = "id_user")
    private User userByIdTutor;

    public Test() {
    }

    public long getIdTest() {
        return idTest;
    }

    public void setIdTest(long idTest) {
        this.idTest = idTest;
    }

    public long getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(long idTutor) {
        this.idTutor = idTutor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public Serializable getId() {
        return getIdTest();
    }

    public List<Question> getQuestionsByIdTest() {
        return questionsByIdTest;
    }

    public void setQuestionsByIdTest(List<Question> questionsByIdTest) {
        this.questionsByIdTest = questionsByIdTest;
    }

    public List<Result> getResultsByIdTest() {
        return resultsByIdTest;
    }

    public void setResultsByIdTest(List<Result> resultsByIdTest) {
        this.resultsByIdTest = resultsByIdTest;
    }

    public User getUserByIdTutor() {
        return userByIdTutor;
    }

    public void setUserByIdTutor(User userByIdTutor) {
        this.userByIdTutor = userByIdTutor;
    }
}
