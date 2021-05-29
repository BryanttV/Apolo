package Entities;

import Entities.Exercises;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-28T21:56:37")
@StaticMetamodel(TestCases.class)
public class TestCases_ { 

    public static volatile SingularAttribute<TestCases, Integer> testCasesCode;
    public static volatile SingularAttribute<TestCases, String> outputCasesPath;
    public static volatile SingularAttribute<TestCases, String> inputCasesPath;
    public static volatile ListAttribute<TestCases, Exercises> exercisesList;

}