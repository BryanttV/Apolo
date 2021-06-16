package Entities;

import Entities.Questionnaires;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-29T17:15:20")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-28T21:56:37")
>>>>>>> 885604bed293261588943d3f6e05ef8460fabbb1
@StaticMetamodel(Questions.class)
public class Questions_ { 

    public static volatile SingularAttribute<Questions, String> questionContent;
    public static volatile SingularAttribute<Questions, Integer> questionId;
    public static volatile SingularAttribute<Questions, String> questionSolution;
    public static volatile SingularAttribute<Questions, String> questionOptions;
    public static volatile SingularAttribute<Questions, Questionnaires> questionnaireId;

}