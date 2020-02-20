package utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JSONStringRetrieverTest {

    @Test
    void getJSONstring() throws IOException {
        System.out.println(new JSONStringRetriever("obama").getJSONstring());
    }
}