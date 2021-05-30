package Entities;

import Entities.Codes;
import Entities.LearningImages;
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
@StaticMetamodel(LearningSubtopics.class)
public class LearningSubtopics_ { 

    public static volatile SingularAttribute<LearningSubtopics, String> learningSubContent;
    public static volatile SingularAttribute<LearningSubtopics, LearningTopics> learningTopicCode;
    public static volatile SingularAttribute<LearningSubtopics, Integer> learningSubId;
    public static volatile SingularAttribute<LearningSubtopics, String> syntax;
    public static volatile SingularAttribute<LearningSubtopics, String> learningSubTitle;
    public static volatile ListAttribute<LearningSubtopics, LearningImages> learningImagesList;
    public static volatile SingularAttribute<LearningSubtopics, String> titleAnalogy;
    public static volatile SingularAttribute<LearningSubtopics, String> tips;
    public static volatile ListAttribute<LearningSubtopics, Codes> codesList;

}