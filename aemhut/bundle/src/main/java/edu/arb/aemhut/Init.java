package edu.arb.aemhut;

import com.adobe.cq.sightly.WCMUse;
import com.day.cq.wcm.api.AuthoringUIMode;
import com.day.cq.wcm.api.components.EditContext;
import com.day.cq.wcm.commons.WCMUtils;
import com.day.cq.wcm.undo.UndoConfigService;

import java.io.StringWriter;

/**
 * Created by abani_000 on 17-02-2015.
 */
public class Init extends WCMUse{
    private String undoConfig;
    private String dlgPath;
    private long currentTimeMillis;
    private boolean isTouchUI;

    @Override

    public void activate() throws Exception {
        UndoConfigService undoConfigService = getSlingScriptHelper().getService(UndoConfigService.class);
        StringWriter sw = new StringWriter();
        try {
            undoConfigService.writeClientConfig(sw);
            undoConfig = sw.toString();
        } catch (Exception e) {
            undoConfig = "";
        }

        EditContext editContext = WCMUtils.getComponentContext(getRequest()).getEditContext();
        if (editContext != null && editContext.getComponent() != null) {
            dlgPath = editContext.getComponent().getDialogPath();
        }

        currentTimeMillis = System.currentTimeMillis();

        AuthoringUIMode uiMode = AuthoringUIMode.fromRequest(getRequest());
        isTouchUI = uiMode != null && uiMode != AuthoringUIMode.CLASSIC;
    }

    public String getUndoConfig() {
        return undoConfig;
    }

    public String getDlgPath() {
        return dlgPath;
    }

    public long getCurrentTimeMillis() {
        return currentTimeMillis;
    }

    public boolean isTouchUI() {
        return isTouchUI;
    }
}
