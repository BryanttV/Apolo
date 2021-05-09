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
@Table(name = "learning_subtopics")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LearningSubtopics.findAll", query = "SELECT l FROM LearningSubtopics l")
    , @NamedQuery(name = "LearningSubtopics.findByLearningSubId", query = "SELECT l FROM LearningSubtopics l WHERE l.learningSubId = :learningSubId")
    , @NamedQuery(name = "LearningSubtopics.findByLearningSubTitle", query = "SELECT l FROM LearningSubtopics l WHERE l.learningSubTitle = :learningSubTitle")
    , @NamedQuery(name = "LearningSubtopics.findByTitleAnalogy", query = "SELECT l FROM LearningSubtopics l WHERE l.titleAnalogy = :titleAnalogy")
    , @NamedQuery(name = "LearningSubtopics.findByLearningSubContent", query = "SELECT l FROM LearningSubtopics l WHERE l.learningSubContent = :learningSubContent")
    , @NamedQuery(name = "LearningSubtopics.findBySyntax", query = "SELECT l FROM LearningSubtopics l WHERE l.syntax = :syntax")
    , @NamedQuery(name = "LearningSubtopics.findByTips", query = "SELECT l FROM LearningSubtopics l WHERE l.tips = :tips")})
public class LearningSubtopics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "learning_sub_id")
    private Integer learningSubId;
    @Column(name = "learning_sub_title")
    private String learningSubTitle;
    @Column(name = "title_analogy")
    private String titleAnalogy;
    @Column(name = "learning_sub_content")
    private String learningSubContent;
    @Column(name = "syntax")
    private String syntax;
    @Column(name = "tips")
    private String tips;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "learningSubId")
    private List<Codes> codesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "learningSubId")
    private List<LearningImages> learningImagesList;
    @JoinColumn(name = "learning_topic_code", referencedColumnName = "learning_topic_code")
    @ManyToOne(optional = false)
    private LearningTopics learningTopicCode;

    public LearningSubtopics() {
    }

    public LearningSubtopics(Integer learningSubId) {
        this.learningSubId = learningSubId;
    }

    public Integer getLearningSubId() {
        return learningSubId;
    }

    public void setLearningSubId(Integer learningSubId) {
        this.learningSubId = learningSubId;
    }

    public String getLearningSubTitle() {
        return learningSubTitle;
    }

    public void setLearningSubTitle(String learningSubTitle) {
        this.learningSubTitle = learningSubTitle;
    }

    public String getTitleAnalogy() {
        return titleAnalogy;
    }

    public void setTitleAnalogy(String titleAnalogy) {
        this.titleAnalogy = titleAnalogy;
    }

    public String getLearningSubContent() {
        return learningSubContent;
    }

    public void setLearningSubContent(String learningSubContent) {
        this.learningSubContent = learningSubContent;
    }

    public String getSyntax() {
        return syntax;
    }

    public void setSyntax(String syntax) {
        this.syntax = syntax;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    @XmlTransient
    public List<Codes> getCodesList() {
        return codesList;
    }

    public void setCodesList(List<Codes> codesList) {
        this.codesList = codesList;
    }

    @XmlTransient
    public List<LearningImages> getLearningImagesList() {
        return learningImagesList;
    }

    public void setLearningImagesList(List<LearningImages> learningImagesList) {
        this.learningImagesList = learningImagesList;
    }

    public LearningTopics getLearningTopicCode() {
        return learningTopicCode;
    }

    public void setLearningTopicCode(LearningTopics learningTopicCode) {
        this.learningTopicCode = learningTopicCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (learningSubId != null ? learningSubId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LearningSubtopics)) {
            return false;
        }
        LearningSubtopics other = (LearningSubtopics) object;
        if ((this.learningSubId == null && other.learningSubId != null) || (this.learningSubId != null && !this.learningSubId.equals(other.learningSubId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.LearningSubtopics[ learningSubId=" + learningSubId + " ]";
    }
    
}
