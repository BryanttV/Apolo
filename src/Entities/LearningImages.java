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
@Table(name = "learning_images")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LearningImages.findAll", query = "SELECT l FROM LearningImages l")
    , @NamedQuery(name = "LearningImages.findByLearningImageId", query = "SELECT l FROM LearningImages l WHERE l.learningImageId = :learningImageId")
    , @NamedQuery(name = "LearningImages.findByLearningImageName", query = "SELECT l FROM LearningImages l WHERE l.learningImageName = :learningImageName")
    , @NamedQuery(name = "LearningImages.findByLearningImagePath", query = "SELECT l FROM LearningImages l WHERE l.learningImagePath = :learningImagePath")})
public class LearningImages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "learning_image_id")
    private Integer learningImageId;
    @Basic(optional = false)
    @Column(name = "learning_image_name")
    private String learningImageName;
    @Basic(optional = false)
    @Column(name = "learning_image_path")
    private String learningImagePath;
    @JoinColumn(name = "learning_sub_id", referencedColumnName = "learning_sub_id")
    @ManyToOne(optional = false)
    private LearningSubtopics learningSubId;

    public LearningImages() {
    }

    public LearningImages(Integer learningImageId) {
        this.learningImageId = learningImageId;
    }

    public LearningImages(Integer learningImageId, String learningImageName, String learningImagePath) {
        this.learningImageId = learningImageId;
        this.learningImageName = learningImageName;
        this.learningImagePath = learningImagePath;
    }

    public Integer getLearningImageId() {
        return learningImageId;
    }

    public void setLearningImageId(Integer learningImageId) {
        this.learningImageId = learningImageId;
    }

    public String getLearningImageName() {
        return learningImageName;
    }

    public void setLearningImageName(String learningImageName) {
        this.learningImageName = learningImageName;
    }

    public String getLearningImagePath() {
        return learningImagePath;
    }

    public void setLearningImagePath(String learningImagePath) {
        this.learningImagePath = learningImagePath;
    }

    public LearningSubtopics getLearningSubId() {
        return learningSubId;
    }

    public void setLearningSubId(LearningSubtopics learningSubId) {
        this.learningSubId = learningSubId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (learningImageId != null ? learningImageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LearningImages)) {
            return false;
        }
        LearningImages other = (LearningImages) object;
        if ((this.learningImageId == null && other.learningImageId != null) || (this.learningImageId != null && !this.learningImageId.equals(other.learningImageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.LearningImages[ learningImageId=" + learningImageId + " ]";
    }
    
}
