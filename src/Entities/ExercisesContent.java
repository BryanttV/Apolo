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
@Table(name = "exercises_content")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExercisesContent.findAll", query = "SELECT e FROM ExercisesContent e")
    , @NamedQuery(name = "ExercisesContent.findByExerciseContentCode", query = "SELECT e FROM ExercisesContent e WHERE e.exerciseContentCode = :exerciseContentCode")
    , @NamedQuery(name = "ExercisesContent.findByExerciseDescription", query = "SELECT e FROM ExercisesContent e WHERE e.exerciseDescription = :exerciseDescription")
    , @NamedQuery(name = "ExercisesContent.findByInput", query = "SELECT e FROM ExercisesContent e WHERE e.input = :input")
    , @NamedQuery(name = "ExercisesContent.findByOutput", query = "SELECT e FROM ExercisesContent e WHERE e.output = :output")
    , @NamedQuery(name = "ExercisesContent.findBySampleInput", query = "SELECT e FROM ExercisesContent e WHERE e.sampleInput = :sampleInput")
    , @NamedQuery(name = "ExercisesContent.findBySampleOutput", query = "SELECT e FROM ExercisesContent e WHERE e.sampleOutput = :sampleOutput")
    , @NamedQuery(name = "ExercisesContent.findByAdditionalNotes", query = "SELECT e FROM ExercisesContent e WHERE e.additionalNotes = :additionalNotes")})
public class ExercisesContent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "exercise_content_code")
    private Integer exerciseContentCode;
    @Basic(optional = false)
    @Column(name = "exercise_description")
    private String exerciseDescription;
    @Basic(optional = false)
    @Column(name = "input")
    private String input;
    @Basic(optional = false)
    @Column(name = "output")
    private String output;
    @Column(name = "sample_input")
    private String sampleInput;
    @Column(name = "sample_output")
    private String sampleOutput;
    @Column(name = "additional_notes")
    private String additionalNotes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exerciseContentCode")
    private List<ExercisesImages> exercisesImagesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exerciseContentCode")
    private List<Exercises> exercisesList;

    public ExercisesContent() {
    }

    public ExercisesContent(Integer exerciseContentCode) {
        this.exerciseContentCode = exerciseContentCode;
    }

    public ExercisesContent(Integer exerciseContentCode, String exerciseDescription, String input, String output) {
        this.exerciseContentCode = exerciseContentCode;
        this.exerciseDescription = exerciseDescription;
        this.input = input;
        this.output = output;
    }

    public Integer getExerciseContentCode() {
        return exerciseContentCode;
    }

    public void setExerciseContentCode(Integer exerciseContentCode) {
        this.exerciseContentCode = exerciseContentCode;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public void setExerciseDescription(String exerciseDescription) {
        this.exerciseDescription = exerciseDescription;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getSampleInput() {
        return sampleInput;
    }

    public void setSampleInput(String sampleInput) {
        this.sampleInput = sampleInput;
    }

    public String getSampleOutput() {
        return sampleOutput;
    }

    public void setSampleOutput(String sampleOutput) {
        this.sampleOutput = sampleOutput;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    @XmlTransient
    public List<ExercisesImages> getExercisesImagesList() {
        return exercisesImagesList;
    }

    public void setExercisesImagesList(List<ExercisesImages> exercisesImagesList) {
        this.exercisesImagesList = exercisesImagesList;
    }

    @XmlTransient
    public List<Exercises> getExercisesList() {
        return exercisesList;
    }

    public void setExercisesList(List<Exercises> exercisesList) {
        this.exercisesList = exercisesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exerciseContentCode != null ? exerciseContentCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExercisesContent)) {
            return false;
        }
        ExercisesContent other = (ExercisesContent) object;
        if ((this.exerciseContentCode == null && other.exerciseContentCode != null) || (this.exerciseContentCode != null && !this.exerciseContentCode.equals(other.exerciseContentCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ExercisesContent[ exerciseContentCode=" + exerciseContentCode + " ]";
    }
    
}
