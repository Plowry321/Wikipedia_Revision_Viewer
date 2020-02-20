package utils;

import domain.Webpage;
import exceptions.ParameterIsNotJSONStringException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONStringParser {

    public static Webpage ParseMostRecent(String JSONString) throws ParameterIsNotJSONStringException {

        JsonParser jsonParser = new JsonParser();
        JsonElement rootElement = jsonParser.parse(JSONString);
        JsonObject rootObject = rootElement.getAsJsonObject();
        var firstName = rootObject.getAsJsonPrimitive("title").getAsString();
        var lastName = rootObject.getAsJsonPrimitive("redirects").getAsString();
        var year = rootObject.getAsJsonPrimitive("dob").getAsInt();
        return new Webpage(pageTitle, pageRedirect, listOfEditors);
    }

    public static Webpage ParseMostRevisions(String JSONString) throws ParameterIsNotJSONStringException {

        JsonParser jsonParser = new JsonParser();
        JsonElement rootElement = jsonParser.parse(JSONString);
        JsonObject rootObject = rootElement.getAsJsonObject();
        var firstName = rootObject.getAsJsonPrimitive("name").getAsString();
        var lastName = rootObject.getAsJsonPrimitive("last").getAsString();
        var year = rootObject.getAsJsonPrimitive("dob").getAsInt();
        return new Person(pageTitle, pageRedirect, year);

    }

}
