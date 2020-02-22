package domain;

import com.google.gson.annotations.SerializedName;

import java.util.*;

public class Webpage {
    @SerializedName(value = "title")
    String pageTitle;

    @SerializedName(value = "Redirects")
    String redirect;

    @SerializedName(value = "user")
    Map<String, String> editList;


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

    public String getPageTitle() {
        return pageTitle;
    }

    public String getRedirect() {
        return redirect;
    }

    public Map<String, String> getEditList() {
        return editList;
    }
}