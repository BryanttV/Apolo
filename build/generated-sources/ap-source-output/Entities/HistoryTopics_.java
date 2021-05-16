package Entities;

import Entities.Curiosities;
import Entities.HistoryPrograms;
import Entities.HistorySubtopics;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-16T10:17:18")
@StaticMetamodel(HistoryTopics.class)
public class HistoryTopics_ { 

    public static volatile SingularAttribute<HistoryTopics, HistoryPrograms> historyProgramCode;
    public static volatile SingularAttribute<HistoryTopics, Integer> historyTopicCode;
    public static volatile SingularAttribute<HistoryTopics, Curiosities> curiosityCode;
    public static volatile SingularAttribute<HistoryTopics, String> historyTopicTitle;
    public static volatile ListAttribute<HistoryTopics, HistorySubtopics> historySubtopicsList;

}