package domain;

import java.util.*;

public class Webpage {

    private String pageTitle;
    private String redirect;

    public Webpage(String aTitle, String aRedirect, Map aMap){
        this.pageTitle = aTitle;
        this.redirect = aRedirect;
        Map<String, String> editList = aMap;
    }


}
