package org.ourproject.kune.workspace.client.ui.ctx.items;

import org.ourproject.kune.platf.client.ui.BorderDecorator;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.VerticalPanel;

class TopBar extends VerticalPanel {

    public final Label currentFolder;
    public final PushButton btnGoParent;
    public final HorizontalPanel firstRow;

    public TopBar() {
	ContextItemsImages Img = ContextItemsImages.App.getInstance();

	firstRow = new HorizontalPanel();
	HorizontalPanel secondRow = new HorizontalPanel();
	HorizontalPanel iconBarHP = new HorizontalPanel();
	HorizontalPanel currentFolderHP = new HorizontalPanel();
	btnGoParent = new PushButton(Img.goUp().createImage(), Img.goUpLight().createImage());
	MenuBar pathMenu = new MenuBar();
	MenuBar pathSubmenu = new MenuBar(true);

	// Layout
	add(firstRow);
	add(secondRow);
	firstRow.add(iconBarHP);
	secondRow.add(currentFolderHP);
	// iconBarHP.add(btnGoParent);
	BorderDecorator buttonRounded = new BorderDecorator(pathMenu, BorderDecorator.ALL, BorderDecorator.SIMPLE);
	iconBarHP.add(buttonRounded);
	pathMenu.addItem(Img.folderpathmenu().getHTML(), true, pathSubmenu);
	pathSubmenu.addItem(Img.folder().getHTML() + "&nbsp;Container", true, new Command() {
	    public void execute() {
		// FIXME
		Window.alert("jump!");
	    }
	});
	pathSubmenu.addItem(Img.folder().getHTML() + "&nbsp;Container 2", true, new Command() {
	    public void execute() {
		// FIXME
		Window.alert("jump too!");
	    }
	});
	currentFolderHP.add(btnGoParent);
	currentFolder = new Label("Current Container");
	currentFolderHP.add(currentFolder);

	// Set properties
	addStyleName("kune-NavigationBar");
	firstRow.addStyleName("topBar");
	secondRow.addStyleName("topBar");
	firstRow.setWidth("100%");
	secondRow.setWidth("100%");
	setCellWidth(firstRow, "100%");
	setCellWidth(secondRow, "100%");
	firstRow.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);
	iconBarHP.setCellVerticalAlignment(btnGoParent, VerticalPanel.ALIGN_MIDDLE);
	iconBarHP.setCellVerticalAlignment(buttonRounded, VerticalPanel.ALIGN_MIDDLE);
	pathMenu.setStyleName("pathMenu");
	buttonRounded.setColor("AAA");
    }

}