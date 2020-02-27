package utils;

import com.google.gson.*;
import domain.TimeStamp;
import domain.Webpage;
import exceptions.ParameterIsNotJSONStringException;

import java.util.HashMap;
import java.util.Map;


public class JSONStringParser {

    public static Webpage ParseJSONString(String JSONString) throws ParameterIsNotJSONStringException {
        if (JSONString.charAt(0) != '{') {
            throw new ParameterIsNotJSONStringException();
        }
        HashMap<TimeStamp, String> timestampNameMap = new HashMap<>();
        JsonArray array;
        Webpage webpage = null;
        String name;
        String time;
        String title;
        String redirectedFrom = "";
        JsonParser jsonParser = new JsonParser();
        JsonElement rootElement = jsonParser.parse(JSONString);
        JsonObject rootObject = rootElement.getAsJsonObject();

        if (youWereRedirected(rootObject)){
            redirectedFrom = rootObject.getAsJsonObject("query").getAsJsonArray("redirects").get(0).getAsJsonObject().getAsJsonPrimitive("from").getAsString();
        }

        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        for (Map.Entry<String, JsonElement> entry : pages.entrySet()) {
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            title = entryObject.getAsJsonPrimitive("title").getAsString();
            array = entryObject.getAsJsonArray("revisions");

            for (int i = 0; i < array.size(); i++) {
                JsonObject individualRevisionObject = array.get(i).getAsJsonObject();
                name = individualRevisionObject.getAsJsonPrimitive("user").getAsString();
                time = individualRevisionObject.getAsJsonPrimitive("timestamp").getAsString();
                TimeStamp newTimeStamp = breakDownTimeStamp(makePrettyTimestamp(time));
                timestampNameMap.put(newTimeStamp, name);
            }
            WebpageBuilder builder = new WebpageBuilder(title,timestampNameMap,redirectedFrom);
            webpage = builder.buildAWebpage();
        }
        return webpage;
    }

    private static boolean youWereRedirected(JsonObject rootObject){
        try {
            rootObject.getAsJsonObject("query").getAsJsonArray("redirects").get(0);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static String makePrettyTimestamp(String aTimeStampString) {
        String date = aTimeStampString.substring(0,aTimeStampString.indexOf('T'));
        String time = aTimeStampString.substring(aTimeStampString.indexOf('T')+1,aTimeStampString.indexOf('Z'));
        return date + time;
    }

    private static TimeStamp breakDownTimeStamp(String aTimeString) {
        String year = aTimeString.substring(0,4);
        String month = aTimeString.substring(5,7);
        String day = aTimeString.substring(8,10);
        String hour = aTimeString.substring(10,12);
        String minute = aTimeString.substring(13,15);
        String second = aTimeString.substring(16,18);
        TimeStamp newTimeStamp = new TimeStamp(year, month, day, hour, minute, second);
        return newTimeStamp;
    }
}