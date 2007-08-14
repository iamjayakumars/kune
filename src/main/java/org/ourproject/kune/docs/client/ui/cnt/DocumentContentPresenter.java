package org.ourproject.kune.docs.client.ui.cnt;

import org.ourproject.kune.docs.client.ui.cnt.folder.editor.FolderEditor;
import org.ourproject.kune.docs.client.ui.cnt.folder.viewer.FolderViewer;
import org.ourproject.kune.docs.client.ui.cnt.reader.DocumentReader;
import org.ourproject.kune.docs.client.ui.cnt.reader.DocumentReaderListener;
import org.ourproject.kune.platf.client.View;
import org.ourproject.kune.workspace.client.component.WorkspaceDeckView;
import org.ourproject.kune.workspace.client.dto.ContentDTO;
import org.ourproject.kune.workspace.client.editor.TextEditor;
import org.ourproject.kune.workspace.client.editor.TextEditorListener;

public class DocumentContentPresenter implements DocumentContent, DocumentReaderListener, TextEditorListener {
    private final WorkspaceDeckView view;
    private final DocumentComponents components;
    private ContentDTO content;

    public DocumentContentPresenter(final WorkspaceDeckView view) {
	this.view = view;
	this.components = new DocumentComponents(this);
    }

    public void setContent(final ContentDTO content) {
	this.content = content;
	showContent();
    }

    private void showContent() {
	if (content.hasDocument()) {
	    DocumentReader reader = components.getDocumentReader();
	    reader.showDocument(content.getContent(), content.getAccessRights());
	    view.show(reader.getView());
	} else {
	    FolderViewer viewer = components.getFolderViewer();
	    viewer.setFolder(content.getFolder());
	    view.show(viewer.getView());
	}
    }

    public void onEdit() {
	if (content.hasDocument()) {
	    TextEditor editor = components.getDocumentEditor();
	    editor.setContent(content.getContent());
	    view.show(editor.getView());
	} else {
	    FolderEditor editor = components.getFolderEditor();
	    editor.setFolder(content.getFolder());
	    view.show(editor.getView());
	}
    }

    public void onSave() {

    }

    public void onCancel() {
	showContent();
    }

    public void attach() {
    }

    public void detach() {

    }

    public View getView() {
	return view;
    }

}