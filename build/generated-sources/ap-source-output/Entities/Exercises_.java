package Entities;

import Entities.AlternativeSolutions;
import Entities.ExercisesContent;
import Entities.TestCases;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-29T17:15:20")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-28T21:56:37")
>>>>>>> 885604bed293261588943d3f6e05ef8460fabbb1
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