package utils;

import domain.TimeStamp;
import domain.Webpage;
import java.util.*;

public class WebpageBuilder {

    public String title;
    public Map<TimeStamp, String> timesAndNames;
    public String redirected;
    private ArrayList<String> users;

    private Object[] userArray;
    private Object[] timeStampArray;
    private int[] editsArray;
    private Object[] timeUserArray;

    private Set<String> uSet;


    public WebpageBuilder(String aTitle, Map aTNNMap, String aRedirected) {
        this.title = aTitle;
        this.timesAndNames = aTNNMap;
        this.redirected = aRedirected;
        this.uSet = makeUniqueSetFromMap(timesAndNames);
        this.userArray = uSet.toArray();
        this.timeUserArray = timesAndNames.values().toArray();
        this.timeStampArray = timesAndNames.keySet().toArray();

    }

    public Webpage buildAWebpage() {
        int[] editValues = getEditValuesFromNames(uSet);
        editsArray = orderByEdits(editValues);
        String[] timeUserArr = orderByTimeStamp(timeStampArray);

        Webpage webpage = new Webpage(title, redirected, userArray, editsArray, timeStampArray, timeUserArr);
        return webpage;
    }

    private Set<String> makeUniqueSetFromMap(Map aTimesAndNamesMap) {
        users = new ArrayList<>();
        for (Object entry : aTimesAndNamesMap.values()) {
            users.add(entry.toString());
        }
        users.sort(null);
        Set<String> uniqueUserSet = new HashSet<>(users);
        return uniqueUserSet;
    }

    private int[] getEditValuesFromNames(Set<String> uniqueUserSet) {
        Object[] uniqueUserArray = uniqueUserSet.toArray();
        int[] values = new int[uniqueUserArray.length];
        for (int i = 0; i < uniqueUserArray.length; i++) {
            int editsMade = 0;
            for (int k = 0; k < users.size(); k++) {
                if (users.get(k).contains(uniqueUserArray[i].toString())) {
                    editsMade++;
                }
            }
            values[i] = editsMade;
        }
        return values;
    }

    private String[] orderByTimeStamp(Object[] aTimeStampArray) {
        String[] stringArray = new String[aTimeStampArray.length];
        for (int i = 0; i < aTimeStampArray.length; i++) {
            TimeStamp maxTime = (TimeStamp) aTimeStampArray[i];
            TimeStamp tempTime;

            for (int k = 0; k < aTimeStampArray.length; k++) {
                TimeStamp secondTime = (TimeStamp) aTimeStampArray[k];

                if (maxTime.getSum() < secondTime.getSum()) {
                    tempTime = (TimeStamp) aTimeStampArray[i];
                    aTimeStampArray[i] = aTimeStampArray[k];
                    aTimeStampArray[k] = tempTime;

                    stringArray[i] = timeUserArray[k].toString();
                }
            }
        }
        return stringArray;
    }

    private int[] orderByEdits(int[] editValueArray) {
        for (int i = 0; i < editValueArray.length; i++) {
            int maxValue = editValueArray[i];
            int tempValue;
            Object tempUser;

            for (int k = 0; k < editValueArray.length; k++) {
                if (maxValue < editValueArray[k]) {
                    tempValue = editValueArray[i];
                    editValueArray[i] = editValueArray[k];
                    editValueArray[k] = tempValue;

                    tempUser = userArray[i];
                    userArray[i] = userArray[k];
                    userArray[k] = tempUser;
                }
            }
        }
        return editValueArray;
    }
}
