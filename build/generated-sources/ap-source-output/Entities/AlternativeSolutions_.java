package Entities;

import Entities.Exercises;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-29T17:15:20")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-28T21:56:36")
>>>>>>> 885604bed293261588943d3f6e05ef8460fabbb1
@StaticMetamodel(AlternativeSolutions.class)
public class AlternativeSolutions_ { 

    public static volatile SingularAttribute<AlternativeSolutions, String> solutionText;
    public static volatile SingularAttribute<AlternativeSolutions, String> solutionType;
    public static volatile SingularAttribute<AlternativeSolutions, Integer> solutionCode;
    public static volatile ListAttribute<AlternativeSolutions, Exercises> exercisesList;

}