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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "progress")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Progress.findAll", query = "SELECT p FROM Progress p")
    , @NamedQuery(name = "Progress.findByRecordId", query = "SELECT p FROM Progress p WHERE p.recordId = :recordId")
    , @NamedQuery(name = "Progress.findByLastTopicLearning", query = "SELECT p FROM Progress p WHERE p.lastTopicLearning = :lastTopicLearning")
    , @NamedQuery(name = "Progress.findByLastTopicHistory", query = "SELECT p FROM Progress p WHERE p.lastTopicHistory = :lastTopicHistory")
    , @NamedQuery(name = "Progress.findByLearningPercentage", query = "SELECT p FROM Progress p WHERE p.learningPercentage = :learningPercentage")
    , @NamedQuery(name = "Progress.findByHistoryPercentage", query = "SELECT p FROM Progress p WHERE p.historyPercentage = :historyPercentage")
    , @NamedQuery(name = "Progress.findByCreatedAt", query = "SELECT p FROM Progress p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "Progress.findByUpdatedAt", query = "SELECT p FROM Progress p WHERE p.updatedAt = :updatedAt")})
public class Progress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Integer recordId;
    @Column(name = "last_topic_learning")
    private String lastTopicLearning;
    @Column(name = "last_topic_history")
    private String lastTopicHistory;
    @Basic(optional = false)
    @Column(name = "learning_percentage")
    private double learningPercentage;
    @Basic(optional = false)
    @Column(name = "history_percentage")
    private double historyPercentage;
    @Basic(optional = false)
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "updated_at")
    private String updatedAt;
    @JoinColumn(name = "language_id", referencedColumnName = "language_id")
    @ManyToOne(optional = false)
    private ProgrammingLanguages languageId;

    public Progress() {
    }

    public Progress(Integer recordId) {
        this.recordId = recordId;
    }

    public Progress(Integer recordId, double learningPercentage, double historyPercentage, String createdAt) {
        this.recordId = recordId;
        this.learningPercentage = learningPercentage;
        this.historyPercentage = historyPercentage;
        this.createdAt = createdAt;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getLastTopicLearning() {
        return lastTopicLearning;
    }

    public void setLastTopicLearning(String lastTopicLearning) {
        this.lastTopicLearning = lastTopicLearning;
    }

    public String getLastTopicHistory() {
        return lastTopicHistory;
    }

    public void setLastTopicHistory(String lastTopicHistory) {
        this.lastTopicHistory = lastTopicHistory;
    }

    public double getLearningPercentage() {
        return learningPercentage;
    }

    public void setLearningPercentage(double learningPercentage) {
        this.learningPercentage = learningPercentage;
    }

    public double getHistoryPercentage() {
        return historyPercentage;
    }

    public void setHistoryPercentage(double historyPercentage) {
        this.historyPercentage = historyPercentage;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
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
        hash += (recordId != null ? recordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Progress)) {
            return false;
        }
        Progress other = (Progress) object;
        if ((this.recordId == null && other.recordId != null) || (this.recordId != null && !this.recordId.equals(other.recordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Progress[ recordId=" + recordId + " ]";
    }
    
}
