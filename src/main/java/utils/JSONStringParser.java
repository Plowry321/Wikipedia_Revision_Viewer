package utils;

import domain.Webpage;
import exceptions.ParameterIsNotJSONStringException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Map;

public class JSONStringParser {

    public static Webpage ParseMostRecent(String JSONString) throws ParameterIsNotJSONStringException {
        if (JSONString.charAt(0) != '{') {
            throw new ParameterIsNotJSONStringException();
        }
        Gson gson = new Gson();
        return gson.fromJson(JSONString, Webpage.class);
    }

    public static Webpage ParseMostRevisions(String JSONString) throws ParameterIsNotJSONStringException {

        JsonParser jsonParser = new JsonParser();
        JsonElement rootElement = jsonParser.parse(JSONString);
        JsonObject rootObject = rootElement.getAsJsonObject();
        var pageTitle = rootObject.getAsJsonPrimitive("name").getAsString();
        var pageRedirect = rootObject.getAsJsonPrimitive("last").getAsString();
        Map<String, String> listOfEditors = null; //rootObject.getAsJsonPrimitive("dob").getAsInt();
        return new Webpage(pageTitle, pageRedirect, listOfEditors);

    }

}
