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
@Table(name = "history_subtopics")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorySubtopics.findAll", query = "SELECT h FROM HistorySubtopics h")
    , @NamedQuery(name = "HistorySubtopics.findByHistorySubId", query = "SELECT h FROM HistorySubtopics h WHERE h.historySubId = :historySubId")
    , @NamedQuery(name = "HistorySubtopics.findByHistorySubTitle", query = "SELECT h FROM HistorySubtopics h WHERE h.historySubTitle = :historySubTitle")
    , @NamedQuery(name = "HistorySubtopics.findByHistorySubContent", query = "SELECT h FROM HistorySubtopics h WHERE h.historySubContent = :historySubContent")})
public class HistorySubtopics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "history_sub_id")
    private Integer historySubId;
    @Column(name = "history_sub_title")
    private String historySubTitle;
    @Basic(optional = false)
    @Column(name = "history_sub_content")
    private String historySubContent;
    @JoinColumn(name = "history_topic_code", referencedColumnName = "history_topic_code")
    @ManyToOne(optional = false)
    private HistoryTopics historyTopicCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historySubId")
    private List<HistoryImages> historyImagesList;

    public HistorySubtopics() {
    }

    public HistorySubtopics(Integer historySubId) {
        this.historySubId = historySubId;
    }

    public HistorySubtopics(Integer historySubId, String historySubContent) {
        this.historySubId = historySubId;
        this.historySubContent = historySubContent;
    }

    public Integer getHistorySubId() {
        return historySubId;
    }

    public void setHistorySubId(Integer historySubId) {
        this.historySubId = historySubId;
    }

    public String getHistorySubTitle() {
        return historySubTitle;
    }

    public void setHistorySubTitle(String historySubTitle) {
        this.historySubTitle = historySubTitle;
    }

    public String getHistorySubContent() {
        return historySubContent;
    }

    public void setHistorySubContent(String historySubContent) {
        this.historySubContent = historySubContent;
    }

    public HistoryTopics getHistoryTopicCode() {
        return historyTopicCode;
    }

    public void setHistoryTopicCode(HistoryTopics historyTopicCode) {
        this.historyTopicCode = historyTopicCode;
    }

    @XmlTransient
    public List<HistoryImages> getHistoryImagesList() {
        return historyImagesList;
    }

    public void setHistoryImagesList(List<HistoryImages> historyImagesList) {
        this.historyImagesList = historyImagesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (historySubId != null ? historySubId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorySubtopics)) {
            return false;
        }
        HistorySubtopics other = (HistorySubtopics) object;
        if ((this.historySubId == null && other.historySubId != null) || (this.historySubId != null && !this.historySubId.equals(other.historySubId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.HistorySubtopics[ historySubId=" + historySubId + " ]";
    }
    
}
