package utils;

import domain.TimeStamp;
import domain.Webpage;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;

public class WebpageBuilder {

    public String title;
    public Map<TimeStamp,String> timesAndNames;
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
        Set<String> uSet = makeUniqueSetFromMap(timesAndNames);
        edits = getEditValuesFromNames(uSet);
        Map<TimeStamp, String> orderedTimesAndNames = reOrderTheMap(timesAndNames);

        Webpage webpage = new Webpage(title, timesAndNames, redirected, uniqueUserSet, edits);
        return webpage;
    }

    private Set<String> makeUniqueSetFromMap(Map aTimesAndNamesMap) {
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

    private Map<TimeStamp, String> reOrderTheMap(Map<TimeStamp, String> timesAndNames) {
        Map<TimeStamp, String> orderedMap = null;
        for (Map.Entry<TimeStamp, String> entry : timesAndNames.entrySet()) {
            TimeStamp mostRecentTime = entry.getKey();
            String mostRecentName = entry.getValue();
            for (Map.Entry<TimeStamp, String> otherEntry : timesAndNames.entrySet()) {
                TimeStamp time = otherEntry.getKey();
                String name = otherEntry.getValue();
                if(mostRecentTime.getSum() < time.getSum()){
                    mostRecentTime = time;
                    mostRecentName = name;
                    }
                }
            orderedMap.put(mostRecentTime, mostRecentName);
            }
        return orderedMap;
    }
}
