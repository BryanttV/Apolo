package Entities;

import Entities.Exercises;
import Entities.ExercisesImages;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-16T10:17:18")
@StaticMetamodel(ExercisesContent.class)
public class ExercisesContent_ { 

    public static volatile SingularAttribute<ExercisesContent, String> output;
    public static volatile SingularAttribute<ExercisesContent, String> input;
    public static volatile SingularAttribute<ExercisesContent, String> exerciseDescription;
    public static volatile SingularAttribute<ExercisesContent, Integer> exerciseContentCode;
    public static volatile SingularAttribute<ExercisesContent, String> sampleInput;
    public static volatile SingularAttribute<ExercisesContent, String> additionalNotes;
    public static volatile SingularAttribute<ExercisesContent, String> sampleOutput;
    public static volatile ListAttribute<ExercisesContent, Exercises> exercisesList;
    public static volatile ListAttribute<ExercisesContent, ExercisesImages> exercisesImagesList;

}