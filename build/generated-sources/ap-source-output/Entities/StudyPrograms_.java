package Entities;

import Entities.LearningTopics;
import Entities.ProgrammingLanguages;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-29T17:15:20")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-28T21:56:36")
>>>>>>> 885604bed293261588943d3f6e05ef8460fabbb1
@StaticMetamodel(StudyPrograms.class)
public class StudyPrograms_ { 

    public static volatile SingularAttribute<StudyPrograms, Integer> studyProgramId;
    public static volatile SingularAttribute<StudyPrograms, ProgrammingLanguages> languageId;
    public static volatile SingularAttribute<StudyPrograms, Integer> studyProgramCode;
    public static volatile ListAttribute<StudyPrograms, LearningTopics> learningTopicsList;
    public static volatile SingularAttribute<StudyPrograms, String> studyProgramName;

}