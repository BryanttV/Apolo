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
@Table(name = "alternative_solutions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlternativeSolutions.findAll", query = "SELECT a FROM AlternativeSolutions a")
    , @NamedQuery(name = "AlternativeSolutions.findBySolutionCode", query = "SELECT a FROM AlternativeSolutions a WHERE a.solutionCode = :solutionCode")
    , @NamedQuery(name = "AlternativeSolutions.findBySolutionText", query = "SELECT a FROM AlternativeSolutions a WHERE a.solutionText = :solutionText")
    , @NamedQuery(name = "AlternativeSolutions.findBySolutionType", query = "SELECT a FROM AlternativeSolutions a WHERE a.solutionType = :solutionType")})
public class AlternativeSolutions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "solution_code")
    private Integer solutionCode;
    @Basic(optional = false)
    @Column(name = "solution_text")
    private String solutionText;
    @Column(name = "solution_type")
    private String solutionType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solutionCode")
    private List<Exercises> exercisesList;

    public AlternativeSolutions() {
    }

    public AlternativeSolutions(Integer solutionCode) {
        this.solutionCode = solutionCode;
    }

    public AlternativeSolutions(Integer solutionCode, String solutionText) {
        this.solutionCode = solutionCode;
        this.solutionText = solutionText;
    }

    public Integer getSolutionCode() {
        return solutionCode;
    }

    public void setSolutionCode(Integer solutionCode) {
        this.solutionCode = solutionCode;
    }

    public String getSolutionText() {
        return solutionText;
    }

    public void setSolutionText(String solutionText) {
        this.solutionText = solutionText;
    }

    public String getSolutionType() {
        return solutionType;
    }

    public void setSolutionType(String solutionType) {
        this.solutionType = solutionType;
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
        hash += (solutionCode != null ? solutionCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlternativeSolutions)) {
            return false;
        }
        AlternativeSolutions other = (AlternativeSolutions) object;
        if ((this.solutionCode == null && other.solutionCode != null) || (this.solutionCode != null && !this.solutionCode.equals(other.solutionCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.AlternativeSolutions[ solutionCode=" + solutionCode + " ]";
    }
    
}
