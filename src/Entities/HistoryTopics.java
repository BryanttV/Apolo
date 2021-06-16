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
@Table(name = "history_topics")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoryTopics.findAll", query = "SELECT h FROM HistoryTopics h")
    , @NamedQuery(name = "HistoryTopics.findByHistoryTopicCode", query = "SELECT h FROM HistoryTopics h WHERE h.historyTopicCode = :historyTopicCode")
    , @NamedQuery(name = "HistoryTopics.findByHistoryTopicTitle", query = "SELECT h FROM HistoryTopics h WHERE h.historyTopicTitle = :historyTopicTitle")})
public class HistoryTopics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "history_topic_code")
    private Integer historyTopicCode;
    @Basic(optional = false)
    @Column(name = "history_topic_title")
    private String historyTopicTitle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historyTopicCode")
    private List<HistorySubtopics> historySubtopicsList;
    @JoinColumn(name = "curiosity_code", referencedColumnName = "curiosity_code")
    @ManyToOne(optional = false)
    private Curiosities curiosityCode;
    @JoinColumn(name = "history_program_code", referencedColumnName = "history_program_code")
    @ManyToOne(optional = false)
    private HistoryPrograms historyProgramCode;

    public HistoryTopics() {
    }

    public HistoryTopics(Integer historyTopicCode) {
        this.historyTopicCode = historyTopicCode;
    }

    public HistoryTopics(Integer historyTopicCode, String historyTopicTitle) {
        this.historyTopicCode = historyTopicCode;
        this.historyTopicTitle = historyTopicTitle;
    }

    public Integer getHistoryTopicCode() {
        return historyTopicCode;
    }

    public void setHistoryTopicCode(Integer historyTopicCode) {
        this.historyTopicCode = historyTopicCode;
    }

    public String getHistoryTopicTitle() {
        return historyTopicTitle;
    }

    public void setHistoryTopicTitle(String historyTopicTitle) {
        this.historyTopicTitle = historyTopicTitle;
    }

    @XmlTransient
    public List<HistorySubtopics> getHistorySubtopicsList() {
        return historySubtopicsList;
    }

    public void setHistorySubtopicsList(List<HistorySubtopics> historySubtopicsList) {
        this.historySubtopicsList = historySubtopicsList;
    }

    public Curiosities getCuriosityCode() {
        return curiosityCode;
    }

    public void setCuriosityCode(Curiosities curiosityCode) {
        this.curiosityCode = curiosityCode;
    }

    public HistoryPrograms getHistoryProgramCode() {
        return historyProgramCode;
    }

    public void setHistoryProgramCode(HistoryPrograms historyProgramCode) {
        this.historyProgramCode = historyProgramCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (historyTopicCode != null ? historyTopicCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoryTopics)) {
            return false;
        }
        HistoryTopics other = (HistoryTopics) object;
        if ((this.historyTopicCode == null && other.historyTopicCode != null) || (this.historyTopicCode != null && !this.historyTopicCode.equals(other.historyTopicCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.HistoryTopics[ historyTopicCode=" + historyTopicCode + " ]";
    }
    
}
