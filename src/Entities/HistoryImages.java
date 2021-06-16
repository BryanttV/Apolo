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
@Table(name = "history_images")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoryImages.findAll", query = "SELECT h FROM HistoryImages h")
    , @NamedQuery(name = "HistoryImages.findByHistoryImageId", query = "SELECT h FROM HistoryImages h WHERE h.historyImageId = :historyImageId")
    , @NamedQuery(name = "HistoryImages.findByHistoryImageName", query = "SELECT h FROM HistoryImages h WHERE h.historyImageName = :historyImageName")
    , @NamedQuery(name = "HistoryImages.findByHistoryImagePath", query = "SELECT h FROM HistoryImages h WHERE h.historyImagePath = :historyImagePath")})
public class HistoryImages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "history_image_id")
    private Integer historyImageId;
    @Basic(optional = false)
    @Column(name = "history_image_name")
    private String historyImageName;
    @Basic(optional = false)
    @Column(name = "history_image_path")
    private String historyImagePath;
    @JoinColumn(name = "history_sub_id", referencedColumnName = "history_sub_id")
    @ManyToOne(optional = false)
    private HistorySubtopics historySubId;

    public HistoryImages() {
    }

    public HistoryImages(Integer historyImageId) {
        this.historyImageId = historyImageId;
    }

    public HistoryImages(Integer historyImageId, String historyImageName, String historyImagePath) {
        this.historyImageId = historyImageId;
        this.historyImageName = historyImageName;
        this.historyImagePath = historyImagePath;
    }

    public Integer getHistoryImageId() {
        return historyImageId;
    }

    public void setHistoryImageId(Integer historyImageId) {
        this.historyImageId = historyImageId;
    }

    public String getHistoryImageName() {
        return historyImageName;
    }

    public void setHistoryImageName(String historyImageName) {
        this.historyImageName = historyImageName;
    }

    public String getHistoryImagePath() {
        return historyImagePath;
    }

    public void setHistoryImagePath(String historyImagePath) {
        this.historyImagePath = historyImagePath;
    }

    public HistorySubtopics getHistorySubId() {
        return historySubId;
    }

    public void setHistorySubId(HistorySubtopics historySubId) {
        this.historySubId = historySubId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (historyImageId != null ? historyImageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoryImages)) {
            return false;
        }
        HistoryImages other = (HistoryImages) object;
        if ((this.historyImageId == null && other.historyImageId != null) || (this.historyImageId != null && !this.historyImageId.equals(other.historyImageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.HistoryImages[ historyImageId=" + historyImageId + " ]";
    }
    
}
