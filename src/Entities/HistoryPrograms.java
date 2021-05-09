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
@Table(name = "history_programs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoryPrograms.findAll", query = "SELECT h FROM HistoryPrograms h")
    , @NamedQuery(name = "HistoryPrograms.findByHistoryProgramId", query = "SELECT h FROM HistoryPrograms h WHERE h.historyProgramId = :historyProgramId")
    , @NamedQuery(name = "HistoryPrograms.findByHistoryProgramCode", query = "SELECT h FROM HistoryPrograms h WHERE h.historyProgramCode = :historyProgramCode")
    , @NamedQuery(name = "HistoryPrograms.findByHistoryProgramName", query = "SELECT h FROM HistoryPrograms h WHERE h.historyProgramName = :historyProgramName")})
public class HistoryPrograms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "history_program_id")
    private int historyProgramId;
    @Id
    @Basic(optional = false)
    @Column(name = "history_program_code")
    private Integer historyProgramCode;
    @Basic(optional = false)
    @Column(name = "history_program_name")
    private String historyProgramName;
    @JoinColumn(name = "language_id", referencedColumnName = "language_id")
    @ManyToOne
    private ProgrammingLanguages languageId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historyProgramCode")
    private List<HistoryTopics> historyTopicsList;

    public HistoryPrograms() {
    }

    public HistoryPrograms(Integer historyProgramCode) {
        this.historyProgramCode = historyProgramCode;
    }

    public HistoryPrograms(Integer historyProgramCode, int historyProgramId, String historyProgramName) {
        this.historyProgramCode = historyProgramCode;
        this.historyProgramId = historyProgramId;
        this.historyProgramName = historyProgramName;
    }

    public int getHistoryProgramId() {
        return historyProgramId;
    }

    public void setHistoryProgramId(int historyProgramId) {
        this.historyProgramId = historyProgramId;
    }

    public Integer getHistoryProgramCode() {
        return historyProgramCode;
    }

    public void setHistoryProgramCode(Integer historyProgramCode) {
        this.historyProgramCode = historyProgramCode;
    }

    public String getHistoryProgramName() {
        return historyProgramName;
    }

    public void setHistoryProgramName(String historyProgramName) {
        this.historyProgramName = historyProgramName;
    }

    public ProgrammingLanguages getLanguageId() {
        return languageId;
    }

    public void setLanguageId(ProgrammingLanguages languageId) {
        this.languageId = languageId;
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
        hash += (historyProgramCode != null ? historyProgramCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoryPrograms)) {
            return false;
        }
        HistoryPrograms other = (HistoryPrograms) object;
        if ((this.historyProgramCode == null && other.historyProgramCode != null) || (this.historyProgramCode != null && !this.historyProgramCode.equals(other.historyProgramCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.HistoryPrograms[ historyProgramCode=" + historyProgramCode + " ]";
    }
    
}
