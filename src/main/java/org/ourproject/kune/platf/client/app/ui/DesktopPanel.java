/*
 *
 * Copyright (C) 2007-2008 The kune development team (see CREDITS for details)
 * This file is part of kune.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.ourproject.kune.platf.client.app.ui;

import org.ourproject.kune.platf.client.app.DesktopView;
import org.ourproject.kune.platf.client.services.I18nTranslationService;
import org.ourproject.kune.platf.client.state.Session;
import org.ourproject.kune.workspace.client.sitebar.bar.SiteBarListener;
import org.ourproject.kune.workspace.client.sitebar.msg.SiteMessage;
import org.ourproject.kune.workspace.client.workspace.Workspace;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.WindowResizeListener;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

@Deprecated
public class DesktopPanel extends AbsolutePanel implements DesktopView {

    public DesktopPanel(final Workspace workspace, final SiteBarListener listener, final Session session,
	    final I18nTranslationService i18n) {
	// QuickTips.init(); // extgwt tips
	// final QuickTip quickTipInstance = QuickTips.getQuickTip();
	// quickTipInstance.setDismissDelay(8000);
	// quickTipInstance.setHideDelay(500);
	// quickTipInstance.setInterceptTitles(true);
	// SiteBar siteBar = SiteBarFactory.createSiteBar(listener, session,
	// i18n);
	// final SiteMessage siteMessage = SiteBarFactory.getSiteMessage();
	// this.add((Widget) siteMessage.getView(),
	// calculateMessageWidth(Window.getClientWidth()),
	// calculateMessageHeight());
	// this.add((Widget) siteBar.getView(), 0, 0);
	this.add((Widget) workspace.getView(), 0, 20);
	this.addStyleName("kunebody");
	// initResizeListener(this, workspace, siteMessage);
	// resizeDesktop(this, workspace, siteMessage, Window.getClientWidth(),
	// Window.getClientHeight());
    }

    public void attach() {
	RootPanel.get().add(this);
    }

    private int calculateMessageHeight() {
	return 2;
    }

    private int calculateMessageWidth(final int width) {
	return width * 20 / 100 - 10;
    }

    private void initResizeListener(final AbsolutePanel desktop, final Workspace workspace,
	    final SiteMessage siteMessage) {
	Window.addWindowResizeListener(new WindowResizeListener() {
	    public void onWindowResized(final int width, final int height) {
		resizeDesktop(desktop, workspace, siteMessage, width, height);
	    }
	});
    }

    private void resizeDesktop(final AbsolutePanel desktop, final Workspace workspace, final SiteMessage siteMessage,
	    final int clientWidth, final int clientHeight) {
	final int width = workspace.calculateWidth(clientWidth);
	final int height = workspace.calculateHeight(clientHeight);
	final boolean scroll = width <= Workspace.MIN_WIDTH || height <= Workspace.MIN_HEIGHT ? true : false;
	Window.enableScrolling(scroll);
	if (scroll) {
	    desktop.setSize("" + width, "" + height);
	} else {
	    desktop.setSize("100%", "100%");
	}
	workspace.adjustSize(width, height);
	// siteMessage.adjustWidth(width);
	// desktop.setWidgetPosition((Widget) siteMessage.getView(),
	// calculateMessageWidth(width),
	// calculateMessageHeight());
    }

}
