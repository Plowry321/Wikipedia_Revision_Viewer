package utils;

import com.google.gson.Gson;
import domain.Webpage;
import exceptions.ParameterIsNotJSONStringException;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JSONStringParserTest {
    String sampleString = "{\"continue\":{\"rvcontinue\":\"20191012231046|920951968\",\"continue\":\"||\"},\"query\":{\"pages\":{\"19651298\":{\"pageid\":19651298,\"ns\":0,\"title\":\"Soup\",\"revisions\":[{\"user\":\"AnomieBOT\",\"timestamp\":\"2019-11-28T06:58:48Z\"},{\"user\":\"Esoteric bearcat\",\"timestamp\":\"2019-11-28T04:58:37Z\"},{\"user\":\"Esoteric bearcat\",\"timestamp\":\"2019-11-28T04:50:07Z\"},{\"user\":\"Rmhermen\",\"timestamp\":\"2019-11-04T17:21:04Z\"}]}}}}";
    String sampleStringTwo = "{\"continue\":{\"rvcontinue\":\"20200208083845|939722289\",\"continue\":\"||\"},\"query\":{\"redirects\":[{\"from\":\"Donut\",\"to\":\"Doughnut\"}],\"pages\":{\"74803\":{\"pageid\":74803,\"ns\":0,\"title\":\"Doughnut\",\"revisions\":[{\"user\":\"FlightTime Phone\",\"timestamp\":\"2020-02-15T04:41:44Z\"},{\"user\":\"\\u041a\\u0438\\u0430\\u043d\",\"timestamp\":\"2020-02-15T04:39:21Z\"},{\"user\":\"APal Wikiwriter\",\"timestamp\":\"2020-02-12T14:10:25Z\"},{\"user\":\"Teemeah\",\"timestamp\":\"2020-02-09T18:39:24Z\"}]}}}}";

    @org.junit.jupiter.api.Test
    void parsesTitle() throws ParameterIsNotJSONStringException {
        Webpage resultingWebpage = JSONStringParser.ParseJSONString(sampleString);
        assertEquals("Soup", resultingWebpage.getTitle());
    }

    @org.junit.jupiter.api.Test
    void parsesRedirection() throws ParameterIsNotJSONStringException {
        Webpage resultingWebpageTwo = JSONStringParser.ParseJSONString(sampleStringTwo);
        Webpage resultingWebpage = JSONStringParser.ParseJSONString(sampleString);

        assertEquals(true, resultingWebpageTwo.wasRedirected());
        assertEquals(false, resultingWebpage.wasRedirected());
    }

}