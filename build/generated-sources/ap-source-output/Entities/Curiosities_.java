package Entities;

import Entities.HistoryTopics;
import Entities.LearningTopics;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-28T21:56:37")
@StaticMetamodel(Curiosities.class)
public class Curiosities_ { 

    public static volatile SingularAttribute<Curiosities, Integer> curiosityId;
    public static volatile SingularAttribute<Curiosities, String> curiosityContent;
    public static volatile ListAttribute<Curiosities, LearningTopics> learningTopicsList;
    public static volatile SingularAttribute<Curiosities, Integer> curiosityCode;
    public static volatile ListAttribute<Curiosities, HistoryTopics> historyTopicsList;

}