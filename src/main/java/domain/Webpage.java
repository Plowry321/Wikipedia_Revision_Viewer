package domain;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Webpage {

    public String title;
    public Map<String,String> timesAndNames;
    public int[] edits;
    public Boolean redirected;
    public Object[] userArray;
    public String redirectedFrom;

    public Webpage(String aTitle, Map aTimesAndNamesMap, String aRedirectedFrom, Set aUserSet, int[] anEditsArray)
    {
        this.title = aTitle;
        this.timesAndNames = aTimesAndNamesMap;
        this.redirected = !aRedirectedFrom.isEmpty();
        this.redirectedFrom = aRedirectedFrom;
        this.userArray = aUserSet.toArray();
        this.edits = anEditsArray;
    }

    public String getTitle() {
        return title;
    }

    public Boolean wasRedirected() {
        return redirected;
    }

    public String getFirstTimestamp(){
        return timesAndNames.keySet().toArray()[0].toString();
    }
}