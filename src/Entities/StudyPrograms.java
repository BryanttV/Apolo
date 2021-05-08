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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "study_programs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudyPrograms.findAll", query = "SELECT s FROM StudyPrograms s")
    , @NamedQuery(name = "StudyPrograms.findByStudyProgramId", query = "SELECT s FROM StudyPrograms s WHERE s.studyProgramId = :studyProgramId")
    , @NamedQuery(name = "StudyPrograms.findByStudyProgramCode", query = "SELECT s FROM StudyPrograms s WHERE s.studyProgramCode = :studyProgramCode")
    , @NamedQuery(name = "StudyPrograms.findByStudyProgramName", query = "SELECT s FROM StudyPrograms s WHERE s.studyProgramName = :studyProgramName")})
public class StudyPrograms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "study_program_id")
    private int studyProgramId;
    @Id
    @Basic(optional = false)
    @Column(name = "study_program_code")
    private Integer studyProgramCode;
    @Basic(optional = false)
    @Column(name = "study_program_name")
    private String studyProgramName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studyProgramCode")
    private List<LearningTopics> learningTopicsList;
    @JoinColumn(name = "language_id", referencedColumnName = "language_id")
    @ManyToOne(optional = false)
    private ProgrammingLanguages languageId;

    public StudyPrograms() {
    }

    public StudyPrograms(Integer studyProgramCode) {
        this.studyProgramCode = studyProgramCode;
    }

    public StudyPrograms(Integer studyProgramCode, int studyProgramId, String studyProgramName) {
        this.studyProgramCode = studyProgramCode;
        this.studyProgramId = studyProgramId;
        this.studyProgramName = studyProgramName;
    }

    public int getStudyProgramId() {
        return studyProgramId;
    }

    public void setStudyProgramId(int studyProgramId) {
        this.studyProgramId = studyProgramId;
    }

    public Integer getStudyProgramCode() {
        return studyProgramCode;
    }

    public void setStudyProgramCode(Integer studyProgramCode) {
        this.studyProgramCode = studyProgramCode;
    }

    public String getStudyProgramName() {
        return studyProgramName;
    }

    public void setStudyProgramName(String studyProgramName) {
        this.studyProgramName = studyProgramName;
    }

    @XmlTransient
    public List<LearningTopics> getLearningTopicsList() {
        return learningTopicsList;
    }

    public void setLearningTopicsList(List<LearningTopics> learningTopicsList) {
        this.learningTopicsList = learningTopicsList;
    }

    public ProgrammingLanguages getLanguageId() {
        return languageId;
    }

    public void setLanguageId(ProgrammingLanguages languageId) {
        this.languageId = languageId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studyProgramCode != null ? studyProgramCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudyPrograms)) {
            return false;
        }
        StudyPrograms other = (StudyPrograms) object;
        if ((this.studyProgramCode == null && other.studyProgramCode != null) || (this.studyProgramCode != null && !this.studyProgramCode.equals(other.studyProgramCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.StudyPrograms[ studyProgramCode=" + studyProgramCode + " ]";
    }
    
}
