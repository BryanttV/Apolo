/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author david
 */
@Entity
@Table(name = "test_cases")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestCases.findAll", query = "SELECT t FROM TestCases t")
    , @NamedQuery(name = "TestCases.findByTestCasesCode", query = "SELECT t FROM TestCases t WHERE t.testCasesCode = :testCasesCode")
    , @NamedQuery(name = "TestCases.findByInputCasesPath", query = "SELECT t FROM TestCases t WHERE t.inputCasesPath = :inputCasesPath")
    , @NamedQuery(name = "TestCases.findByOutputCasesPath", query = "SELECT t FROM TestCases t WHERE t.outputCasesPath = :outputCasesPath")})
public class TestCases implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "test_cases_code")
    private Integer testCasesCode;
    @Basic(optional = false)
    @Column(name = "input_cases_path")
    private String inputCasesPath;
    @Basic(optional = false)
    @Column(name = "output_cases_path")
    private String outputCasesPath;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testCasesCode")
    private List<Exercises> exercisesList;

    public TestCases() {
    }

    public TestCases(Integer testCasesCode) {
        this.testCasesCode = testCasesCode;
    }

    public TestCases(Integer testCasesCode, String inputCasesPath, String outputCasesPath) {
        this.testCasesCode = testCasesCode;
        this.inputCasesPath = inputCasesPath;
        this.outputCasesPath = outputCasesPath;
    }

    public Integer getTestCasesCode() {
        return testCasesCode;
    }

    public void setTestCasesCode(Integer testCasesCode) {
        this.testCasesCode = testCasesCode;
    }

    public String getInputCasesPath() {
        return inputCasesPath;
    }

    public void setInputCasesPath(String inputCasesPath) {
        this.inputCasesPath = inputCasesPath;
    }

    public String getOutputCasesPath() {
        return outputCasesPath;
    }

    public void setOutputCasesPath(String outputCasesPath) {
        this.outputCasesPath = outputCasesPath;
    }

    @XmlTransient
    public List<Exercises> getExercisesList() {
        return exercisesList;
    }

    public void setExercisesList(List<Exercises> exercisesList) {
        this.exercisesList = exercisesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testCasesCode != null ? testCasesCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestCases)) {
            return false;
        }
        TestCases other = (TestCases) object;
        if ((this.testCasesCode == null && other.testCasesCode != null) || (this.testCasesCode != null && !this.testCasesCode.equals(other.testCasesCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TestCases[ testCasesCode=" + testCasesCode + " ]";
    }
    
}
