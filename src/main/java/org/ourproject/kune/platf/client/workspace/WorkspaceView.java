package org.ourproject.kune.platf.client.workspace;

import com.google.gwt.user.client.ui.Image;

public interface WorkspaceView {
    void addTab(String name);
    void setLogo(String groupName);
    void setLogo(Image image);
    void setContextTitle(String title);
    void setSelectedTab(int tabIndex);
}
