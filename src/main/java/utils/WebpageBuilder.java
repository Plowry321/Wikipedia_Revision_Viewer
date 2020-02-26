package utils;

import domain.Webpage;

import java.util.*;

public class WebpageBuilder {

    public String title;
    public Map<String,String> timesAndNames;
    public String redirected;
    private ArrayList<String> users;
    private Set<String> uniqueUserSet;
    private int[] edits;


    public WebpageBuilder(String aTitle, Map aTNNMap, String aRedirected)
    {
        this.title = aTitle;
        this.timesAndNames = aTNNMap;
        this.redirected = aRedirected;
    }

    public Webpage buildAWebpage(){
        Set<String> uSet = makeUniqueSet(timesAndNames);
        edits = getEditValuesFromNames(uSet);
        Webpage webpage = new Webpage(title, timesAndNames, redirected, uniqueUserSet, edits);
        return webpage;
    }

    private Set<String> makeUniqueSet(Map aTimesAndNamesMap) {
        users = new ArrayList<>();
        for (Object entry : aTimesAndNamesMap.values()) {
            users.add(entry.toString());
        }
        users.sort(null);
        uniqueUserSet = new HashSet<>(users);
        return uniqueUserSet;
    }

    private int[] getEditValuesFromNames(Set<String> uniqueUserSet){
        Object[] uniqueUserArray = uniqueUserSet.toArray();
        int[] values = new int[uniqueUserArray.length];
        for (int i = 0; i < uniqueUserArray.length; i++){
            int editsMade = 0;
            for (int k = 0; k < users.size(); k++){
                if (users.get(k).contains(uniqueUserArray[i].toString())){
                    editsMade++;
                }
            }
            values[i] = editsMade;
        }
        return values;
    }
}
