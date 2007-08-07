package org.ourproject.kune.docs.client.reader;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class DocumentReaderPanel extends VerticalPanel implements DocumentReaderView {
    private Button btnEdit;
    private final HTML content;

    public DocumentReaderPanel(final DocumentReaderListener listener) {
	add(createToolBar(listener));
	btnEdit.setVisible(false);
	content = new HTML();
	add(content);
    }

    private Widget createToolBar(final DocumentReaderListener listener) {
	FlowPanel panel = new FlowPanel();
	btnEdit = new Button("editar", new ClickListener() {
	    public void onClick(final Widget sender) {
		listener.onEdit();
	    }
	});
	panel.add(btnEdit);
	return panel;
    }

    public void setContent(final String text) {
	content.setHTML(text);
    }

    public void setEditEnabled(final boolean isEnabled) {
	btnEdit.setVisible(isEnabled);
    }

    public String getContent() {
	return content.getHTML();
    }

}