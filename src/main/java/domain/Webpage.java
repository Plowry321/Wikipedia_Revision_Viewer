package domain;


import java.util.ArrayList;
import java.util.Map;

public class Webpage {

    public String title;
    public Map<String,String> timesAndNames;
    public Map<String,Integer> namesAndEdits;
    public Boolean redirected;
    public String redirectedFrom;

    public Webpage(String aTitle, Map aTimesAndNamesMap, String aRedirectedFrom, Map aNamesAndEditsMap)
    {
        this.title = aTitle;
        this.timesAndNames = aTimesAndNamesMap;
        this.redirected = !aRedirectedFrom.isEmpty();
        this.redirectedFrom = aRedirectedFrom;
        this.namesAndEdits = aNamesAndEditsMap;
    }

    public String getTitle() {
        return title;
    }

    public Boolean wasRedirected() {
        return redirected;
    }

}