package edu.arb.aemhut.beans;

import com.adobe.cq.sightly.WCMUse;

/**
 * Created by abani_000 on 23-02-2015.
 */
public class TitleUse extends WCMUse {

    private String title;
    @Override
    public void activate() throws Exception {
        title = getProperties().get("title", "No Title").toUpperCase();
    }

    public String getTitle() {
        return title;
    }
}
