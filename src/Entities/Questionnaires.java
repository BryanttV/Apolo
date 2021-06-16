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
@Table(name = "questionnaires")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questionnaires.findAll", query = "SELECT q FROM Questionnaires q")
    , @NamedQuery(name = "Questionnaires.findByQuestionnaireId", query = "SELECT q FROM Questionnaires q WHERE q.questionnaireId = :questionnaireId")
    , @NamedQuery(name = "Questionnaires.findByQuestionnaireName", query = "SELECT q FROM Questionnaires q WHERE q.questionnaireName = :questionnaireName")
    , @NamedQuery(name = "Questionnaires.findByQuestionnaireStatus", query = "SELECT q FROM Questionnaires q WHERE q.questionnaireStatus = :questionnaireStatus")})
public class Questionnaires implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "questionnaire_id")
    private Integer questionnaireId;
    @Basic(optional = false)
    @Column(name = "questionnaire_name")
    private String questionnaireName;
    @Basic(optional = false)
    @Column(name = "questionnaire_status")
    private String questionnaireStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionnaireId")
    private List<Questions> questionsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionnaireId")
    private List<LearningTopics> learningTopicsList;

    public Questionnaires() {
    }

    public Questionnaires(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Questionnaires(Integer questionnaireId, String questionnaireName, String questionnaireStatus) {
        this.questionnaireId = questionnaireId;
        this.questionnaireName = questionnaireName;
        this.questionnaireStatus = questionnaireStatus;
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public void setQuestionnaireName(String questionnaireName) {
        this.questionnaireName = questionnaireName;
    }

    public String getQuestionnaireStatus() {
        return questionnaireStatus;
    }

    public void setQuestionnaireStatus(String questionnaireStatus) {
        this.questionnaireStatus = questionnaireStatus;
    }

    @XmlTransient
    public List<Questions> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Questions> questionsList) {
        this.questionsList = questionsList;
    }

    @XmlTransient
    public List<LearningTopics> getLearningTopicsList() {
        return learningTopicsList;
    }

    public void setLearningTopicsList(List<LearningTopics> learningTopicsList) {
        this.learningTopicsList = learningTopicsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionnaireId != null ? questionnaireId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questionnaires)) {
            return false;
        }
        Questionnaires other = (Questionnaires) object;
        if ((this.questionnaireId == null && other.questionnaireId != null) || (this.questionnaireId != null && !this.questionnaireId.equals(other.questionnaireId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Questionnaires[ questionnaireId=" + questionnaireId + " ]";
    }
    
}
