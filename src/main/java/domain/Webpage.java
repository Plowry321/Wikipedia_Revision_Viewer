package domain;

import java.util.*;

public class Webpage {

    private String pageTitle;
    private String redirect;
    private Map<String, String> editList;


    public Webpage(String aTitle, String aRedirect, Map aMap){
        this.pageTitle = aTitle;
        this.redirect = aRedirect;
        this.editList = aMap;
    }

    public void printThePage(){
        System.out.println("*********");
        System.out.println("Title: " + pageTitle);
        System.out.println("Redirects: " + redirect);
        System.out.println("Edit HashMap: " + editList);
    }


}
