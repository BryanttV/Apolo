package Entities;

import Entities.HistorySubtopics;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-29T17:15:20")
@StaticMetamodel(HistoryImages.class)
public class HistoryImages_ { 

    public static volatile SingularAttribute<HistoryImages, Integer> historyImageId;
    public static volatile SingularAttribute<HistoryImages, String> historyImagePath;
    public static volatile SingularAttribute<HistoryImages, HistorySubtopics> historySubId;
    public static volatile SingularAttribute<HistoryImages, String> historyImageName;

}