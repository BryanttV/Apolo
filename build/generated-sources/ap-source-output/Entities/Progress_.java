package Entities;

import Entities.ProgrammingLanguages;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-29T17:15:20")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-28T21:56:37")
>>>>>>> 885604bed293261588943d3f6e05ef8460fabbb1
@StaticMetamodel(Progress.class)
public class Progress_ { 

    public static volatile SingularAttribute<Progress, Integer> recordId;
    public static volatile SingularAttribute<Progress, String> lastTopicLearning;
    public static volatile SingularAttribute<Progress, String> createdAt;
    public static volatile SingularAttribute<Progress, Double> historyPercentage;
    public static volatile SingularAttribute<Progress, Double> learningPercentage;
    public static volatile SingularAttribute<Progress, ProgrammingLanguages> languageId;
    public static volatile SingularAttribute<Progress, String> lastTopicHistory;
    public static volatile SingularAttribute<Progress, String> updatedAt;

}