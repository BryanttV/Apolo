package Entities;

import Entities.Curiosities;
import Entities.LearningSubtopics;
import Entities.Questionnaires;
import Entities.StudyPrograms;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-28T21:56:37")
@StaticMetamodel(LearningTopics.class)
public class LearningTopics_ { 

    public static volatile SingularAttribute<LearningTopics, String> learningTopicTitle;
    public static volatile ListAttribute<LearningTopics, LearningSubtopics> learningSubtopicsList;
    public static volatile SingularAttribute<LearningTopics, Integer> learningTopicCode;
    public static volatile SingularAttribute<LearningTopics, Questionnaires> questionnaireId;
    public static volatile SingularAttribute<LearningTopics, StudyPrograms> studyProgramCode;
    public static volatile SingularAttribute<LearningTopics, Curiosities> curiosityCode;

}