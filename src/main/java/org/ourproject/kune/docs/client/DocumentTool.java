package org.ourproject.kune.docs.client;

import org.ourproject.kune.docs.client.rpc.DocumentService;
import org.ourproject.kune.platf.client.AbstractTool;
import org.ourproject.kune.platf.client.dispatch.HistoryToken;
import org.ourproject.kune.platf.client.workspace.WorkspaceComponent;
import org.ourproject.kune.platf.client.workspace.navigation.NavigationListener;
import org.ourproject.kune.platf.client.workspace.navigation.NavigationPanel;
import org.ourproject.kune.platf.client.workspace.navigation.NavigatorPresenter;

public class DocumentTool extends AbstractTool implements NavigationListener {
    private DocumentPresenter content;
    private NavigatorPresenter context;

    public DocumentTool() {
	super("docs");
    }

    // TODO: translate
    public String getCaption() {
	return "documentos";
    }

    public String getEncodedState() {
	return HistoryToken.encode(getName(), getContext().getEncodedState(), getContent().getEncodedState());
    }

    public void setEncodedState(Object value) {
	String[] split = HistoryToken.split(value);
	getContext().setEncodedState(split[0]);
	getContent().setEncodedState(split[1]);
    }

    public WorkspaceComponent getContent() {
	if (content == null) {
	    DocumentPanel panel = new DocumentPanel();
	    this.content = new DocumentPresenter(panel);
	}
	return content;
    }

    public WorkspaceComponent getContext() {
	if (context == null) {
	    DocumentContextProvider provider = new DocumentContextProvider(DocumentService.App.getInstance());
	    NavigationPanel panel = new NavigationPanel(this);
	    this.context = new NavigatorPresenter(panel);
	}
	return context;
    }

}
