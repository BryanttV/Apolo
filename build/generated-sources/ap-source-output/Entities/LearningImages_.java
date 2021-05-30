package Entities;

import Entities.LearningSubtopics;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-28T21:56:37")
@StaticMetamodel(LearningImages.class)
public class LearningImages_ { 

    public static volatile SingularAttribute<LearningImages, String> learningImagePath;
    public static volatile SingularAttribute<LearningImages, String> learningImageName;
    public static volatile SingularAttribute<LearningImages, LearningSubtopics> learningSubId;
    public static volatile SingularAttribute<LearningImages, Integer> learningImageId;

}