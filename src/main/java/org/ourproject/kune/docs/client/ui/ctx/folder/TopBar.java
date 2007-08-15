package org.ourproject.kune.docs.client.ui.ctx.folder;

import org.ourproject.kune.platf.client.ui.BorderDecorator;
import org.ourproject.kune.sitebar.client.Site;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

class TopBar extends VerticalPanel {

    public TopBar() {
	FolderContextImages Img = FolderContextImages.App.getInstance();

	HorizontalPanel firstRow = new HorizontalPanel();
	HorizontalPanel secondRow = new HorizontalPanel();
	HorizontalPanel iconBarHP = new HorizontalPanel();
	HorizontalPanel currentFolderHP = new HorizontalPanel();
	final PushButton upIcon = new PushButton(Img.goUp().createImage(), Img.goUpLight().createImage());
	MenuBar pathMenu = new MenuBar();
	MenuBar pathSubmenu = new MenuBar(true);

	// Layout
	add(firstRow);
	add(secondRow);
	firstRow.add(iconBarHP);
	secondRow.add(currentFolderHP);
	iconBarHP.add(upIcon);
	BorderDecorator buttonRounded = new BorderDecorator(pathMenu, BorderDecorator.ALL, BorderDecorator.SIMPLE);
	iconBarHP.add(buttonRounded);
	pathMenu.addItem(Img.folderpathmenu().getHTML(), true, pathSubmenu);
	pathSubmenu.addItem(Img.folder().getHTML() + "&nbsp;Folder", true, new Command() {
	    public void execute() {
		// FIXME
		Window.alert("jump!");
	    }
	});
	pathSubmenu.addItem(Img.folder().getHTML() + "&nbsp;Folder 2", true, new Command() {
	    public void execute() {
		// FIXME
		Window.alert("jump too!");
	    }
	});
	currentFolderHP.add(Img.bulletArrowRight().createImage());
	Label currentFolder = new Label("Current Folder");
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
	iconBarHP.setCellVerticalAlignment(upIcon, VerticalPanel.ALIGN_MIDDLE);
	iconBarHP.setCellVerticalAlignment(buttonRounded, VerticalPanel.ALIGN_MIDDLE);
	pathMenu.setStyleName("pathMenu");
	buttonRounded.setColor("AAA");
	upIcon.addClickListener(new ClickListener() {
	    public void onClick(final Widget sender) {
		// TODO
		Site.info("Test");
	    }
	});
	currentFolder.addClickListener(new ClickListener() {

	    public void onClick(final Widget sender) {
		// TODO
		Site.error("Test 2");
	    }
	});
    }
}
