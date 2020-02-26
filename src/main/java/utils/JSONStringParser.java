package utils;

import com.google.gson.*;
import domain.Webpage;
import exceptions.ParameterIsNotJSONStringException;

import java.nio.channels.ScatteringByteChannel;
import java.util.HashMap;
import java.util.Map;


public class JSONStringParser {

    public static Webpage ParseJSONString(String JSONString) throws ParameterIsNotJSONStringException {
        if (JSONString.charAt(0) != '{') {
            throw new ParameterIsNotJSONStringException();
        }
        HashMap<String, String> timestampNameMap = new HashMap<>();
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
                timestampNameMap.put(time, name);
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
}