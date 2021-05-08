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
@Table(name = "learning_topics")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LearningTopics.findAll", query = "SELECT l FROM LearningTopics l")
    , @NamedQuery(name = "LearningTopics.findByLearningTopicCode", query = "SELECT l FROM LearningTopics l WHERE l.learningTopicCode = :learningTopicCode")
    , @NamedQuery(name = "LearningTopics.findByLearningTopicTitle", query = "SELECT l FROM LearningTopics l WHERE l.learningTopicTitle = :learningTopicTitle")})
public class LearningTopics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "learning_topic_code")
    private Integer learningTopicCode;
    @Basic(optional = false)
    @Column(name = "learning_topic_title")
    private String learningTopicTitle;
    @JoinColumn(name = "curiosity_code", referencedColumnName = "curiosity_code")
    @ManyToOne(optional = false)
    private Curiosities curiosityCode;
    @JoinColumn(name = "questionnaire_id", referencedColumnName = "questionnaire_id")
    @ManyToOne(optional = false)
    private Questionnaires questionnaireId;
    @JoinColumn(name = "study_program_code", referencedColumnName = "study_program_code")
    @ManyToOne(optional = false)
    private StudyPrograms studyProgramCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "learningTopicCode")
    private List<LearningSubtopics> learningSubtopicsList;

    public LearningTopics() {
    }

    public LearningTopics(Integer learningTopicCode) {
        this.learningTopicCode = learningTopicCode;
    }

    public LearningTopics(Integer learningTopicCode, String learningTopicTitle) {
        this.learningTopicCode = learningTopicCode;
        this.learningTopicTitle = learningTopicTitle;
    }

    public Integer getLearningTopicCode() {
        return learningTopicCode;
    }

    public void setLearningTopicCode(Integer learningTopicCode) {
        this.learningTopicCode = learningTopicCode;
    }

    public String getLearningTopicTitle() {
        return learningTopicTitle;
    }

    public void setLearningTopicTitle(String learningTopicTitle) {
        this.learningTopicTitle = learningTopicTitle;
    }

    public Curiosities getCuriosityCode() {
        return curiosityCode;
    }

    public void setCuriosityCode(Curiosities curiosityCode) {
        this.curiosityCode = curiosityCode;
    }

    public Questionnaires getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Questionnaires questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public StudyPrograms getStudyProgramCode() {
        return studyProgramCode;
    }

    public void setStudyProgramCode(StudyPrograms studyProgramCode) {
        this.studyProgramCode = studyProgramCode;
    }

    @XmlTransient
    public List<LearningSubtopics> getLearningSubtopicsList() {
        return learningSubtopicsList;
    }

    public void setLearningSubtopicsList(List<LearningSubtopics> learningSubtopicsList) {
        this.learningSubtopicsList = learningSubtopicsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (learningTopicCode != null ? learningTopicCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LearningTopics)) {
            return false;
        }
        LearningTopics other = (LearningTopics) object;
        if ((this.learningTopicCode == null && other.learningTopicCode != null) || (this.learningTopicCode != null && !this.learningTopicCode.equals(other.learningTopicCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.LearningTopics[ learningTopicCode=" + learningTopicCode + " ]";
    }
    
}
