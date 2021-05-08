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
@Table(name = "curiosities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curiosities.findAll", query = "SELECT c FROM Curiosities c")
    , @NamedQuery(name = "Curiosities.findByCuriosityId", query = "SELECT c FROM Curiosities c WHERE c.curiosityId = :curiosityId")
    , @NamedQuery(name = "Curiosities.findByCuriosityCode", query = "SELECT c FROM Curiosities c WHERE c.curiosityCode = :curiosityCode")
    , @NamedQuery(name = "Curiosities.findByCuriosityContent", query = "SELECT c FROM Curiosities c WHERE c.curiosityContent = :curiosityContent")})
public class Curiosities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "curiosity_id")
    private int curiosityId;
    @Id
    @Basic(optional = false)
    @Column(name = "curiosity_code")
    private Integer curiosityCode;
    @Basic(optional = false)
    @Column(name = "curiosity_content")
    private String curiosityContent;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curiosityCode")
    private List<LearningTopics> learningTopicsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curiosityCode")
    private List<HistoryTopics> historyTopicsList;

    public Curiosities() {
    }

    public Curiosities(Integer curiosityCode) {
        this.curiosityCode = curiosityCode;
    }

    public Curiosities(Integer curiosityCode, int curiosityId, String curiosityContent) {
        this.curiosityCode = curiosityCode;
        this.curiosityId = curiosityId;
        this.curiosityContent = curiosityContent;
    }

    public int getCuriosityId() {
        return curiosityId;
    }

    public void setCuriosityId(int curiosityId) {
        this.curiosityId = curiosityId;
    }

    public Integer getCuriosityCode() {
        return curiosityCode;
    }

    public void setCuriosityCode(Integer curiosityCode) {
        this.curiosityCode = curiosityCode;
    }

    public String getCuriosityContent() {
        return curiosityContent;
    }

    public void setCuriosityContent(String curiosityContent) {
        this.curiosityContent = curiosityContent;
    }

    @XmlTransient
    public List<LearningTopics> getLearningTopicsList() {
        return learningTopicsList;
    }

    public void setLearningTopicsList(List<LearningTopics> learningTopicsList) {
        this.learningTopicsList = learningTopicsList;
    }

    @XmlTransient
    public List<HistoryTopics> getHistoryTopicsList() {
        return historyTopicsList;
    }

    public void setHistoryTopicsList(List<HistoryTopics> historyTopicsList) {
        this.historyTopicsList = historyTopicsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (curiosityCode != null ? curiosityCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curiosities)) {
            return false;
        }
        Curiosities other = (Curiosities) object;
        if ((this.curiosityCode == null && other.curiosityCode != null) || (this.curiosityCode != null && !this.curiosityCode.equals(other.curiosityCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Curiosities[ curiosityCode=" + curiosityCode + " ]";
    }
    
}
