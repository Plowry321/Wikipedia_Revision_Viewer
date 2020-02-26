package domain;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Webpage {

    public String title;
    public Map<String,String> timesAndNames;
    public Boolean redirected;
    public String redirectedFrom;

    public Webpage(String aTitle, Map aTimesAndNamesMap, Boolean aRedirect, String aRedirectedFrom)
    {
        this.title = aTitle;
        this.timesAndNames = aTimesAndNamesMap;
        this.redirected = aRedirect;
        this.redirectedFrom = aRedirectedFrom;
    }

    public String getTitle() {
        return title;
    }

    public Boolean wasRedirected() {
        return redirected;
    }
}