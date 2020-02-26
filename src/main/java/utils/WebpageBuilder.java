package utils;

import domain.Webpage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class WebpageBuilder {

    public String title;
    public Map<String,String> timesAndNames;
    public String redirected;

    public Map<String,Integer> namesAndEdits;


    public WebpageBuilder(String aTitle, Map aTNNMap, String aRedirected)
    {
        this.title = aTitle;
        this.timesAndNames = aTNNMap;
        this.redirected = aRedirected;
    }

    public Webpage buildAWebpage(){
        namesAndEdits = makeEditSumList(timesAndNames);
        Webpage webpage = new Webpage(title, timesAndNames, redirected, namesAndEdits);
        return webpage;
    }

    private Map<String, Integer> makeEditSumList(Map aTimesAndNamesMap) {
        ArrayList<String> users = new ArrayList<>();
        Map<String, Integer> nameEdit = null;
        for (Object entry : aTimesAndNamesMap.values()) {
            users.add(entry.toString());
        }
        users.sort(null);
        String oldName = "";

        for (String name : users){
            if (!name.contentEquals(oldName)){
                int numberOfEdits = modeOfName(users, name);
                nameEdit.put(name, numberOfEdits);
            }
            oldName = name;
        }
        return nameEdit;
    }

    public static int modeOfName(ArrayList users, String userName) {
        String[] editors = makeArrayFromArrayList(users);
        String editorsName = userName;
        int count = 0;
        for (int j = 0; j < editors.length; ++j)
            {
                if (editorsName.contains(editors[j])) {
                    count++;
                }
            }
        return count;
    }


    public static String[] makeArrayFromArrayList(ArrayList anArrayList){
        int h = 0;
        String[] array = new String[anArrayList.size()];
        for (Object name : anArrayList){
            String actualName = name.toString();
            array[h] = actualName;
            h++;
        }
        return array;
    }
}
