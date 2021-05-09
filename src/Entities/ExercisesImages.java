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
@Table(name = "exercises_images")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExercisesImages.findAll", query = "SELECT e FROM ExercisesImages e")
    , @NamedQuery(name = "ExercisesImages.findByExerciseImageId", query = "SELECT e FROM ExercisesImages e WHERE e.exerciseImageId = :exerciseImageId")
    , @NamedQuery(name = "ExercisesImages.findByExerciseImageName", query = "SELECT e FROM ExercisesImages e WHERE e.exerciseImageName = :exerciseImageName")
    , @NamedQuery(name = "ExercisesImages.findByExerciseImagePath", query = "SELECT e FROM ExercisesImages e WHERE e.exerciseImagePath = :exerciseImagePath")})
public class ExercisesImages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "exercise_image_id")
    private Integer exerciseImageId;
    @Basic(optional = false)
    @Column(name = "exercise_image_name")
    private String exerciseImageName;
    @Basic(optional = false)
    @Column(name = "exercise_image_path")
    private String exerciseImagePath;
    @JoinColumn(name = "exercise_content_code", referencedColumnName = "exercise_content_code")
    @ManyToOne(optional = false)
    private ExercisesContent exerciseContentCode;

    public ExercisesImages() {
    }

    public ExercisesImages(Integer exerciseImageId) {
        this.exerciseImageId = exerciseImageId;
    }

    public ExercisesImages(Integer exerciseImageId, String exerciseImageName, String exerciseImagePath) {
        this.exerciseImageId = exerciseImageId;
        this.exerciseImageName = exerciseImageName;
        this.exerciseImagePath = exerciseImagePath;
    }

    public Integer getExerciseImageId() {
        return exerciseImageId;
    }

    public void setExerciseImageId(Integer exerciseImageId) {
        this.exerciseImageId = exerciseImageId;
    }

    public String getExerciseImageName() {
        return exerciseImageName;
    }

    public void setExerciseImageName(String exerciseImageName) {
        this.exerciseImageName = exerciseImageName;
    }

    public String getExerciseImagePath() {
        return exerciseImagePath;
    }

    public void setExerciseImagePath(String exerciseImagePath) {
        this.exerciseImagePath = exerciseImagePath;
    }

    public ExercisesContent getExerciseContentCode() {
        return exerciseContentCode;
    }

    public void setExerciseContentCode(ExercisesContent exerciseContentCode) {
        this.exerciseContentCode = exerciseContentCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exerciseImageId != null ? exerciseImageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExercisesImages)) {
            return false;
        }
        ExercisesImages other = (ExercisesImages) object;
        if ((this.exerciseImageId == null && other.exerciseImageId != null) || (this.exerciseImageId != null && !this.exerciseImageId.equals(other.exerciseImageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ExercisesImages[ exerciseImageId=" + exerciseImageId + " ]";
    }
    
}
