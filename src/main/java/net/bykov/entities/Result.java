package net.bykov.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * The persistent class for the result database table.
 */
@Entity
@Table(name = "result", schema = "public")
@NamedQuery(name = "Result.findAll", query = "SELECT r FROM Result r")
public class Result extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "ID_RESULT_GENERATOR", sequenceName = "result_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_RESULT_GENERATOR")
    @Column(name = "id_result", unique = true, nullable = false)
    private long idResult;

//    @Basic
//    @Column(name = "id_student")
//    private long idStudent;
//
//    @Basic
//    @Column(name = "id_test")
//    private Long idTest;

    @Basic
    @Column(name = "result", length = 30)
    private String result;

    @Basic
    @Column(name = "created", nullable = false)
    private Timestamp created;

    @Basic
    @Column(name = "comment", length = 30)
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_test", referencedColumnName = "id_test")
    private Test testByIdTest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_student", referencedColumnName = "id_user", nullable = false)
    private User userByIdStudent;

    public Result() {
    }

    public long getIdResult() {
        return idResult;
    }

    public void setIdResult(long idResult) {
        this.idResult = idResult;
    }

//    public long getIdStudent() {
//        return idStudent;
//    }
//
//    public void setIdStudent(long idStudent) {
//        this.idStudent = idStudent;
//    }
//
//    public Long getIdTest() {
//        return idTest;
//    }
//
//    public void setIdTest(Long idTest) {
//        this.idTest = idTest;
//    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public Serializable getId() {
        return getIdResult();
    }

    public Test getTestByIdTest() {
        return testByIdTest;
    }

    public void setTestByIdTest(Test testByIdTest) {
        this.testByIdTest = testByIdTest;
    }

    public User getUserByIdStudent() {
        return userByIdStudent;
    }

    public void setUserByIdStudent(User userByIdStudent) {
        this.userByIdStudent = userByIdStudent;
    }
}
