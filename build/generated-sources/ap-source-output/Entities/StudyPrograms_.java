package Entities;

import Entities.LearningTopics;
import Entities.ProgrammingLanguages;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-16T10:17:18")
@StaticMetamodel(StudyPrograms.class)
public class StudyPrograms_ { 

    public static volatile SingularAttribute<StudyPrograms, Integer> studyProgramId;
    public static volatile SingularAttribute<StudyPrograms, ProgrammingLanguages> languageId;
    public static volatile SingularAttribute<StudyPrograms, Integer> studyProgramCode;
    public static volatile ListAttribute<StudyPrograms, LearningTopics> learningTopicsList;
    public static volatile SingularAttribute<StudyPrograms, String> studyProgramName;

}