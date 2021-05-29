package Entities;

import Entities.Curiosities;
import Entities.HistoryPrograms;
import Entities.HistorySubtopics;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-29T17:15:20")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-28T21:56:36")
>>>>>>> 885604bed293261588943d3f6e05ef8460fabbb1
@StaticMetamodel(HistoryTopics.class)
public class HistoryTopics_ { 

    public static volatile SingularAttribute<HistoryTopics, HistoryPrograms> historyProgramCode;
    public static volatile SingularAttribute<HistoryTopics, Integer> historyTopicCode;
    public static volatile SingularAttribute<HistoryTopics, Curiosities> curiosityCode;
    public static volatile SingularAttribute<HistoryTopics, String> historyTopicTitle;
    public static volatile ListAttribute<HistoryTopics, HistorySubtopics> historySubtopicsList;

}