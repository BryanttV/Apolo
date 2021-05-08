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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "programming_languages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgrammingLanguages.findAll", query = "SELECT p FROM ProgrammingLanguages p")
    , @NamedQuery(name = "ProgrammingLanguages.findByLanguageId", query = "SELECT p FROM ProgrammingLanguages p WHERE p.languageId = :languageId")
    , @NamedQuery(name = "ProgrammingLanguages.findByLanguageName", query = "SELECT p FROM ProgrammingLanguages p WHERE p.languageName = :languageName")})
public class ProgrammingLanguages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private Integer languageId;
    @Basic(optional = false)
    @Column(name = "language_name")
    private String languageName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languageId")
    private List<StudyPrograms> studyProgramsList;
    @OneToMany(mappedBy = "languageId")
    private List<HistoryPrograms> historyProgramsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languageId")
    private List<Progress> progressList;

    public ProgrammingLanguages() {
    }

    public ProgrammingLanguages(Integer languageId) {
        this.languageId = languageId;
    }

    public ProgrammingLanguages(Integer languageId, String languageName) {
        this.languageId = languageId;
        this.languageName = languageName;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    @XmlTransient
    public List<StudyPrograms> getStudyProgramsList() {
        return studyProgramsList;
    }

    public void setStudyProgramsList(List<StudyPrograms> studyProgramsList) {
        this.studyProgramsList = studyProgramsList;
    }

    @XmlTransient
    public List<HistoryPrograms> getHistoryProgramsList() {
        return historyProgramsList;
    }

    public void setHistoryProgramsList(List<HistoryPrograms> historyProgramsList) {
        this.historyProgramsList = historyProgramsList;
    }

    @XmlTransient
    public List<Progress> getProgressList() {
        return progressList;
    }

    public void setProgressList(List<Progress> progressList) {
        this.progressList = progressList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (languageId != null ? languageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgrammingLanguages)) {
            return false;
        }
        ProgrammingLanguages other = (ProgrammingLanguages) object;
        if ((this.languageId == null && other.languageId != null) || (this.languageId != null && !this.languageId.equals(other.languageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ProgrammingLanguages[ languageId=" + languageId + " ]";
    }
    
}
