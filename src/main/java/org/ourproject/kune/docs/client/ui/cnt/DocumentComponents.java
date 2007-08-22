/*
 *
 * Copyright (C) 2007 The kune development team (see CREDITS for details)
 * This file is part of kune.
 *
 * Kune is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * Kune is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.ourproject.kune.docs.client.ui.cnt;

import org.ourproject.kune.docs.client.ui.DocumentFactory;
import org.ourproject.kune.docs.client.ui.cnt.folder.editor.FolderEditor;
import org.ourproject.kune.docs.client.ui.cnt.folder.viewer.FolderViewer;
import org.ourproject.kune.docs.client.ui.cnt.reader.DocumentReader;
import org.ourproject.kune.workspace.client.WorkspaceFactory;
import org.ourproject.kune.workspace.client.editor.TextEditor;

class DocumentComponents {
    private DocumentReader reader;
    private TextEditor editor;
    private final DocumentContentPresenter documentContentPresenter;
    private FolderViewer folderViewer;
    private FolderEditor folderEditor;

    public DocumentComponents(final DocumentContentPresenter documentContentPresenter) {
	this.documentContentPresenter = documentContentPresenter;
    }

    public DocumentReader getDocumentReader() {
	if (reader == null) {
	    reader = DocumentFactory.createDocumentReader(documentContentPresenter);
	}
	return reader;
    }

    public TextEditor getDocumentEditor() {
	if (editor == null) {
	    editor = WorkspaceFactory.createDocumentEditor(documentContentPresenter);
	}
	return editor;
    }

    public FolderViewer getFolderViewer() {
	if (folderViewer == null) {
	    folderViewer = DocumentFactory.createFolderViewer();
	}
	return folderViewer;
    }

    public FolderEditor getFolderEditor() {
	if (folderEditor == null) {
	    folderEditor = DocumentFactory.createFolderEditor();
	}
	return folderEditor;
    }

}
