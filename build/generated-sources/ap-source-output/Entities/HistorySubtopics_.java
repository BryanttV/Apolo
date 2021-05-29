package Entities;

import Entities.HistoryImages;
import Entities.HistoryTopics;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-29T17:15:20")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-28T21:56:37")
>>>>>>> 885604bed293261588943d3f6e05ef8460fabbb1
@StaticMetamodel(HistorySubtopics.class)
public class HistorySubtopics_ { 

    public static volatile SingularAttribute<HistorySubtopics, Integer> historySubId;
    public static volatile SingularAttribute<HistorySubtopics, String> historySubTitle;
    public static volatile SingularAttribute<HistorySubtopics, String> historySubContent;
    public static volatile SingularAttribute<HistorySubtopics, HistoryTopics> historyTopicCode;
    public static volatile ListAttribute<HistorySubtopics, HistoryImages> historyImagesList;

}