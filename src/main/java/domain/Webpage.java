package domain;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Webpage {

    public String title;
    public String redirectedFrom;
    public Boolean redirected;

    public int[] editValueArray;
    public Object[] userArray;
    public Object[] timeStampArray;
    public String[] timeUserArray;


    public Webpage(String aTitle, String aRedirectedFrom, Object[] aUserArray, int[] anEditsArray, Object[] aTimeStampArray, String[] aTimeUserArray) {
        this.title = aTitle;
        this.redirectedFrom = aRedirectedFrom;
        this.redirected = !aRedirectedFrom.isEmpty();

        this.userArray = aUserArray;
        this.editValueArray = anEditsArray;

        this.timeStampArray = aTimeStampArray;
        this.timeUserArray = aTimeUserArray;
    }

    public String getTitle() {
        return title;
    }

    public Boolean wasRedirected() {
        return redirected;
    }

    public String getFirstTimestamp() {
        return timeStampArray[0].toString();
    }
}