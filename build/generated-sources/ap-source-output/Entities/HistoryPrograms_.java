package Entities;

import Entities.HistoryTopics;
import Entities.ProgrammingLanguages;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-29T17:15:20")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-28T21:56:37")
>>>>>>> 885604bed293261588943d3f6e05ef8460fabbb1
@StaticMetamodel(HistoryPrograms.class)
public class HistoryPrograms_ { 

    public static volatile SingularAttribute<HistoryPrograms, Integer> historyProgramId;
    public static volatile SingularAttribute<HistoryPrograms, Integer> historyProgramCode;
    public static volatile SingularAttribute<HistoryPrograms, ProgrammingLanguages> languageId;
    public static volatile SingularAttribute<HistoryPrograms, String> historyProgramName;
    public static volatile ListAttribute<HistoryPrograms, HistoryTopics> historyTopicsList;

}