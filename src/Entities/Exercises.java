/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "exercises")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exercises.findAll", query = "SELECT e FROM Exercises e")
    , @NamedQuery(name = "Exercises.findByExerciseCode", query = "SELECT e FROM Exercises e WHERE e.exerciseCode = :exerciseCode")
    , @NamedQuery(name = "Exercises.findByExerciseName", query = "SELECT e FROM Exercises e WHERE e.exerciseName = :exerciseName")
    , @NamedQuery(name = "Exercises.findByStatus", query = "SELECT e FROM Exercises e WHERE e.status = :status")
    , @NamedQuery(name = "Exercises.findByUpdatedAt", query = "SELECT e FROM Exercises e WHERE e.updatedAt = :updatedAt")})
public class Exercises implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "exercise_code")
    private Integer exerciseCode;
    @Basic(optional = false)
    @Column(name = "exercise_name")
    private String exerciseName;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Column(name = "updated_at")
    private String updatedAt;
    @JoinColumn(name = "solution_code", referencedColumnName = "solution_code")
    @ManyToOne(optional = false)
    private AlternativeSolutions solutionCode;
    @JoinColumn(name = "exercise_content_code", referencedColumnName = "exercise_content_code")
    @ManyToOne(optional = false)
    private ExercisesContent exerciseContentCode;
    @JoinColumn(name = "test_cases_code", referencedColumnName = "test_cases_code")
    @ManyToOne(optional = false)
    private TestCases testCasesCode;

    public Exercises() {
    }

    public Exercises(Integer exerciseCode) {
        this.exerciseCode = exerciseCode;
    }

    public Exercises(Integer exerciseCode, String exerciseName, String status) {
        this.exerciseCode = exerciseCode;
        this.exerciseName = exerciseName;
        this.status = status;
    }

    public Integer getExerciseCode() {
        return exerciseCode;
    }

    public void setExerciseCode(Integer exerciseCode) {
        this.exerciseCode = exerciseCode;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public AlternativeSolutions getSolutionCode() {
        return solutionCode;
    }

    public void setSolutionCode(AlternativeSolutions solutionCode) {
        this.solutionCode = solutionCode;
    }

    public ExercisesContent getExerciseContentCode() {
        return exerciseContentCode;
    }

    public void setExerciseContentCode(ExercisesContent exerciseContentCode) {
        this.exerciseContentCode = exerciseContentCode;
    }

    public TestCases getTestCasesCode() {
        return testCasesCode;
    }

    public void setTestCasesCode(TestCases testCasesCode) {
        this.testCasesCode = testCasesCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exerciseCode != null ? exerciseCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exercises)) {
            return false;
        }
        Exercises other = (Exercises) object;
        if ((this.exerciseCode == null && other.exerciseCode != null) || (this.exerciseCode != null && !this.exerciseCode.equals(other.exerciseCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Exercises[ exerciseCode=" + exerciseCode + " ]";
    }
    
}
