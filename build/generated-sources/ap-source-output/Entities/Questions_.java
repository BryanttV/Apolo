package Entities;

import Entities.Questionnaires;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-28T21:56:37")
@StaticMetamodel(Questions.class)
public class Questions_ { 

    public static volatile SingularAttribute<Questions, String> questionContent;
    public static volatile SingularAttribute<Questions, Integer> questionId;
    public static volatile SingularAttribute<Questions, String> questionSolution;
    public static volatile SingularAttribute<Questions, String> questionOptions;
    public static volatile SingularAttribute<Questions, Questionnaires> questionnaireId;

}