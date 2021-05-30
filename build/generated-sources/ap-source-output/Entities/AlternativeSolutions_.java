package Entities;

import Entities.Exercises;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-28T21:56:36")
@StaticMetamodel(AlternativeSolutions.class)
public class AlternativeSolutions_ { 

    public static volatile SingularAttribute<AlternativeSolutions, String> solutionText;
    public static volatile SingularAttribute<AlternativeSolutions, String> solutionType;
    public static volatile SingularAttribute<AlternativeSolutions, Integer> solutionCode;
    public static volatile ListAttribute<AlternativeSolutions, Exercises> exercisesList;

}