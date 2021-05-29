package Entities;

import Entities.LearningSubtopics;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-29T17:15:20")
@StaticMetamodel(Codes.class)
public class Codes_ { 

    public static volatile SingularAttribute<Codes, Integer> codeId;
    public static volatile SingularAttribute<Codes, String> outputScreen;
    public static volatile SingularAttribute<Codes, String> codeDescription;
    public static volatile SingularAttribute<Codes, String> sampleCode;
    public static volatile SingularAttribute<Codes, LearningSubtopics> learningSubId;

}