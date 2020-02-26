package utils;

import com.google.gson.Gson;
import domain.Webpage;
import exceptions.ParameterIsNotJSONStringException;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JSONStringParserTest {
    String sampleString = "{\"continue\":{\"rvcontinue\":\"20191012231046|920951968\",\"continue\":\"||\"},\"query\":{\"pages\":{\"19651298\":{\"pageid\":19651298,\"ns\":0,\"title\":\"Soup\",\"revisions\":[{\"user\":\"AnomieBOT\",\"timestamp\":\"2019-11-28T06:58:48Z\"},{\"user\":\"Esoteric bearcat\",\"timestamp\":\"2019-11-28T04:58:37Z\"},{\"user\":\"Esoteric bearcat\",\"timestamp\":\"2019-11-28T04:50:07Z\"},{\"user\":\"Rmhermen\",\"timestamp\":\"2019-11-04T17:21:04Z\"}]}}}}";
    String sampleStringTwo = "{\"continue\":{\"rvcontinue\":\"20200208083845|939722289\",\"continue\":\"||\"},\"query\":{\"redirects\":[{\"from\":\"Donut\",\"to\":\"Doughnut\"}],\"pages\":{\"74803\":{\"pageid\":74803,\"ns\":0,\"title\":\"Doughnut\",\"revisions\":[{\"user\":\"FlightTime Phone\",\"timestamp\":\"2020-02-15T04:41:44Z\"},{\"user\":\"\\u041a\\u0438\\u0430\\u043d\",\"timestamp\":\"2020-02-15T04:39:21Z\"},{\"user\":\"APal Wikiwriter\",\"timestamp\":\"2020-02-12T14:10:25Z\"},{\"user\":\"Teemeah\",\"timestamp\":\"2020-02-09T18:39:24Z\"}]}}}}";
    String sampleStringThree = "{\"continue\":{\"rvcontinue\":\"20200207213513|939660366\",\"continue\":\"||\"},\"query\":{\"redirects\":[{\"from\":\"Obama\",\"to\":\"Barack Obama\"}],\"pages\":{\"534366\":{\"pageid\":534366,\"ns\":0,\"title\":\"Barack Obama\",\"revisions\":[{\"user\":\"Smurrayinchester\",\"timestamp\":\"2020-02-26T15:00:49Z\"},{\"user\":\"Kiwi128\",\"timestamp\":\"2020-02-24T09:27:13Z\"},{\"user\":\"Brett12212\",\"timestamp\":\"2020-02-24T09:26:29Z\"},{\"user\":\"SunCrow\",\"timestamp\":\"2020-02-23T23:44:03Z\"},{\"user\":\"SunCrow\",\"timestamp\":\"2020-02-23T23:42:56Z\"},{\"user\":\"SunCrow\",\"timestamp\":\"2020-02-23T23:37:56Z\"},{\"user\":\"SunCrow\",\"timestamp\":\"2020-02-23T23:36:12Z\"},{\"user\":\"SunCrow\",\"timestamp\":\"2020-02-23T22:43:08Z\"},{\"user\":\"SunCrow\",\"timestamp\":\"2020-02-23T22:41:35Z\"},{\"user\":\"Ich\",\"timestamp\":\"2020-02-23T15:20:59Z\"},{\"user\":\"Tymon.r\",\"timestamp\":\"2020-02-21T19:09:29Z\"},{\"user\":\"TheMightyDuckmen\",\"timestamp\":\"2020-02-21T19:07:59Z\"},{\"user\":\"Eyer\",\"timestamp\":\"2020-02-19T17:31:49Z\"},{\"user\":\"Md320\",\"timestamp\":\"2020-02-19T17:21:33Z\"},{\"user\":\"DemonDays64 Bot\",\"timestamp\":\"2020-02-19T05:40:38Z\"},{\"user\":\"DemonDays64 Bot\",\"timestamp\":\"2020-02-18T02:57:00Z\"},{\"user\":\"Theoptimalhawk\",\"timestamp\":\"2020-02-17T20:33:09Z\"},{\"user\":\"Alanscottwalker\",\"timestamp\":\"2020-02-13T15:19:06Z\"},{\"user\":\"Alanscottwalker\",\"timestamp\":\"2020-02-13T15:16:23Z\"},{\"user\":\"Alanscottwalker\",\"timestamp\":\"2020-02-13T15:14:43Z\"},{\"user\":\"Alanscottwalker\",\"timestamp\":\"2020-02-13T15:12:54Z\"},{\"user\":\"Alanscottwalker\",\"timestamp\":\"2020-02-13T15:09:05Z\"},{\"user\":\"Alanscottwalker\",\"timestamp\":\"2020-02-13T15:06:11Z\"},{\"user\":\"DocWatson42\",\"timestamp\":\"2020-02-13T10:57:56Z\"},{\"user\":\"Coffeeandcrumbs\",\"timestamp\":\"2020-02-13T05:47:59Z\"},{\"user\":\"Joppa Chong\",\"timestamp\":\"2020-02-12T00:25:03Z\"},{\"user\":\"Love of Corey\",\"timestamp\":\"2020-02-10T08:57:24Z\"},{\"user\":\"Sundayclose\",\"timestamp\":\"2020-02-10T03:00:52Z\"},{\"user\":\"Historyman2665\",\"timestamp\":\"2020-02-10T02:52:48Z\"},{\"user\":\"Pulkitism4215\",\"timestamp\":\"2020-02-10T02:20:52Z\"}]}}}}";
    @org.junit.jupiter.api.Test
    void parsesTitle() throws ParameterIsNotJSONStringException {
        Webpage resultingWebpage = JSONStringParser.ParseJSONString(sampleString);
        assertEquals("Soup", resultingWebpage.getTitle());
    }

    @org.junit.jupiter.api.Test
    void parsesRedirection() throws ParameterIsNotJSONStringException {
        Webpage resultingWebpageTwo = JSONStringParser.ParseJSONString(sampleStringThree);
        Webpage resultingWebpage = JSONStringParser.ParseJSONString(sampleString);

        assertEquals(true, resultingWebpageTwo.wasRedirected());
        assertEquals(false, resultingWebpage.wasRedirected());
    }

}