package utils;

import exceptions.ParameterIsNotJSONStringException;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JSONStringParserTest {

    @org.junit.jupiter.api.Test
    void parseMostRecent() throws ParameterIsNotJSONStringException {
        Map<String, String> sampleMap = null;
        String sampleString = "{\"continue\":{\"rvcontinue\":\"20191012231046|920951968\",\"continue\":\"||\"},\"query\":{\"pages\":{\"19651298\":{\"pageid\":19651298,\"ns\":0,\"title\":\"Soup\",\"revisions\":[{\"user\":\"AnomieBOT\",\"timestamp\":\"2019-11-28T06:58:48Z\"},{\"user\":\"Esoteric bearcat\",\"timestamp\":\"2019-11-28T04:58:37Z\"},{\"user\":\"Esoteric bearcat\",\"timestamp\":\"2019-11-28T04:50:07Z\"},{\"user\":\"Rmhermen\",\"timestamp\":\"2019-11-04T17:21:04Z\"}]}}}}";
        var resultingWebpage = JSONStringParser.ParseMostRecent(sampleString);
        assertEquals("Huseyin", resultingWebpage.getPageTitle());
        assertEquals("Ergin", resultingWebpage.getRedirect());
        assertEquals(sampleMap, resultingWebpage.getEditList());
    }

    @org.junit.jupiter.api.Test
    void parseMostRevisions() throws ParameterIsNotJSONStringException {
        Map<String, String> sampleMap = null;
        String sampleString = "{\"continue\":{\"rvcontinue\":\"20191012231046|920951968\",\"continue\":\"||\"},\"query\":{\"pages\":{\"19651298\":{\"pageid\":19651298,\"ns\":0,\"title\":\"Soup\",\"revisions\":[{\"user\":\"AnomieBOT\",\"timestamp\":\"2019-11-28T06:58:48Z\"},{\"user\":\"Esoteric bearcat\",\"timestamp\":\"2019-11-28T04:58:37Z\"},{\"user\":\"Esoteric bearcat\",\"timestamp\":\"2019-11-28T04:50:07Z\"},{\"user\":\"Rmhermen\",\"timestamp\":\"2019-11-04T17:21:04Z\"}]}}}}";
        var resultingWebpage = JSONStringParser.ParseMostRevisions(sampleString);
        assertEquals("Huseyin", resultingWebpage.getPageTitle());
        assertEquals("Ergin", resultingWebpage.getRedirect());
        assertEquals(sampleMap, resultingWebpage.getEditList());
    }
}