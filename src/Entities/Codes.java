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
@Table(name = "codes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Codes.findAll", query = "SELECT c FROM Codes c")
    , @NamedQuery(name = "Codes.findByCodeId", query = "SELECT c FROM Codes c WHERE c.codeId = :codeId")
    , @NamedQuery(name = "Codes.findByCodeDescription", query = "SELECT c FROM Codes c WHERE c.codeDescription = :codeDescription")
    , @NamedQuery(name = "Codes.findBySampleCode", query = "SELECT c FROM Codes c WHERE c.sampleCode = :sampleCode")
    , @NamedQuery(name = "Codes.findByOutputScreen", query = "SELECT c FROM Codes c WHERE c.outputScreen = :outputScreen")})
public class Codes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code_id")
    private Integer codeId;
    @Column(name = "code_description")
    private String codeDescription;
    @Basic(optional = false)
    @Column(name = "sample_code")
    private String sampleCode;
    @Column(name = "output_screen")
    private String outputScreen;
    @JoinColumn(name = "learning_sub_id", referencedColumnName = "learning_sub_id")
    @ManyToOne(optional = false)
    private LearningSubtopics learningSubId;

    public Codes() {
    }

    public Codes(Integer codeId) {
        this.codeId = codeId;
    }

    public Codes(Integer codeId, String sampleCode) {
        this.codeId = codeId;
        this.sampleCode = sampleCode;
    }

    public Integer getCodeId() {
        return codeId;
    }

    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }

    public String getCodeDescription() {
        return codeDescription;
    }

    public void setCodeDescription(String codeDescription) {
        this.codeDescription = codeDescription;
    }

    public String getSampleCode() {
        return sampleCode;
    }

    public void setSampleCode(String sampleCode) {
        this.sampleCode = sampleCode;
    }

    public String getOutputScreen() {
        return outputScreen;
    }

    public void setOutputScreen(String outputScreen) {
        this.outputScreen = outputScreen;
    }

    public LearningSubtopics getLearningSubId() {
        return learningSubId;
    }

    public void setLearningSubId(LearningSubtopics learningSubId) {
        this.learningSubId = learningSubId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeId != null ? codeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Codes)) {
            return false;
        }
        Codes other = (Codes) object;
        if ((this.codeId == null && other.codeId != null) || (this.codeId != null && !this.codeId.equals(other.codeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Codes[ codeId=" + codeId + " ]";
    }
    
}
