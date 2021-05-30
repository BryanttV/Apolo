package Entities;

import Entities.HistoryTopics;
import Entities.LearningTopics;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-29T17:15:20")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-28T21:56:37")
>>>>>>> 885604bed293261588943d3f6e05ef8460fabbb1
@StaticMetamodel(Curiosities.class)
public class Curiosities_ { 

    public static volatile SingularAttribute<Curiosities, Integer> curiosityId;
    public static volatile SingularAttribute<Curiosities, String> curiosityContent;
    public static volatile ListAttribute<Curiosities, LearningTopics> learningTopicsList;
    public static volatile SingularAttribute<Curiosities, Integer> curiosityCode;
    public static volatile ListAttribute<Curiosities, HistoryTopics> historyTopicsList;

}