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
@Table(name = "questions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questions.findAll", query = "SELECT q FROM Questions q")
    , @NamedQuery(name = "Questions.findByQuestionId", query = "SELECT q FROM Questions q WHERE q.questionId = :questionId")
    , @NamedQuery(name = "Questions.findByQuestionContent", query = "SELECT q FROM Questions q WHERE q.questionContent = :questionContent")
    , @NamedQuery(name = "Questions.findByQuestionOptions", query = "SELECT q FROM Questions q WHERE q.questionOptions = :questionOptions")
    , @NamedQuery(name = "Questions.findByQuestionSolution", query = "SELECT q FROM Questions q WHERE q.questionSolution = :questionSolution")})
public class Questions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "question_id")
    private Integer questionId;
    @Basic(optional = false)
    @Column(name = "question_content")
    private String questionContent;
    @Column(name = "question_options")
    private String questionOptions;
    @Basic(optional = false)
    @Column(name = "question_solution")
    private String questionSolution;
    @JoinColumn(name = "questionnaire_id", referencedColumnName = "questionnaire_id")
    @ManyToOne(optional = false)
    private Questionnaires questionnaireId;

    public Questions() {
    }

    public Questions(Integer questionId) {
        this.questionId = questionId;
    }

    public Questions(Integer questionId, String questionContent, String questionSolution) {
        this.questionId = questionId;
        this.questionContent = questionContent;
        this.questionSolution = questionSolution;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(String questionOptions) {
        this.questionOptions = questionOptions;
    }

    public String getQuestionSolution() {
        return questionSolution;
    }

    public void setQuestionSolution(String questionSolution) {
        this.questionSolution = questionSolution;
    }

    public Questionnaires getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Questionnaires questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionId != null ? questionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questions)) {
            return false;
        }
        Questions other = (Questions) object;
        if ((this.questionId == null && other.questionId != null) || (this.questionId != null && !this.questionId.equals(other.questionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Questions[ questionId=" + questionId + " ]";
    }
    
}
