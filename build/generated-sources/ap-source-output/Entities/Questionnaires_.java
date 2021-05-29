package Entities;

import Entities.LearningTopics;
import Entities.Questions;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-29T17:15:20")
@StaticMetamodel(Questionnaires.class)
public class Questionnaires_ { 

    public static volatile ListAttribute<Questionnaires, Questions> questionsList;
    public static volatile SingularAttribute<Questionnaires, String> questionnaireStatus;
    public static volatile SingularAttribute<Questionnaires, Integer> questionnaireId;
    public static volatile ListAttribute<Questionnaires, LearningTopics> learningTopicsList;
    public static volatile SingularAttribute<Questionnaires, String> questionnaireName;

}