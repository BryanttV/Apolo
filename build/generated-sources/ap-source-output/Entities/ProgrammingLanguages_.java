package Entities;

import Entities.HistoryPrograms;
import Entities.Progress;
import Entities.StudyPrograms;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-29T17:15:20")
@StaticMetamodel(ProgrammingLanguages.class)
public class ProgrammingLanguages_ { 

    public static volatile ListAttribute<ProgrammingLanguages, HistoryPrograms> historyProgramsList;
    public static volatile ListAttribute<ProgrammingLanguages, StudyPrograms> studyProgramsList;
    public static volatile SingularAttribute<ProgrammingLanguages, Integer> languageId;
    public static volatile ListAttribute<ProgrammingLanguages, Progress> progressList;
    public static volatile SingularAttribute<ProgrammingLanguages, String> languageName;

}