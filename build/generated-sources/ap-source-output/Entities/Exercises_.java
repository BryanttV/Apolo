package Entities;

import Entities.AlternativeSolutions;
import Entities.ExercisesContent;
import Entities.TestCases;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-28T21:56:37")
@StaticMetamodel(Exercises.class)
public class Exercises_ { 

    public static volatile SingularAttribute<Exercises, TestCases> testCasesCode;
    public static volatile SingularAttribute<Exercises, String> exerciseName;
    public static volatile SingularAttribute<Exercises, ExercisesContent> exerciseContentCode;
    public static volatile SingularAttribute<Exercises, Integer> exerciseCode;
    public static volatile SingularAttribute<Exercises, AlternativeSolutions> solutionCode;
    public static volatile SingularAttribute<Exercises, String> status;
    public static volatile SingularAttribute<Exercises, String> updatedAt;

}