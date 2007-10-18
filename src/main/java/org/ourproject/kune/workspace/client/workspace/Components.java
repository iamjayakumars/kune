/*
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

package org.ourproject.kune.workspace.client.workspace;

import org.ourproject.kune.workspace.client.WorkspaceFactory;
import org.ourproject.kune.workspace.client.license.LicenseComponent;

class Components {
    private LicenseComponent license;
    private ContentTitleComponent contentTitle;
    private GroupMembersComponent groupMembers;
    private ParticipationComponent participatesInGroups;
    private BuddiesPresenceComponent buddiesPresence;
    private ContentSubTitleComponent contentSubTitle;
    private ThemeMenuComponent themeMenu;

    public Components(final WorkspacePresenter presenter) {
    }

    public LicenseComponent getLicenseComponent() {
	if (license == null) {
	    license = WorkspaceFactory.createLicenseComponent();
	}
	return license;
    }

    public ContentTitleComponent getContentTitleComponent() {
	if (contentTitle == null) {
	    contentTitle = WorkspaceFactory.createContentTitleComponent();
	}
	return contentTitle;
    }

    public ContentSubTitleComponent getContentSubTitleComponent() {
	if (contentSubTitle == null) {
	    contentSubTitle = WorkspaceFactory.createContentSubTitleComponent();
	}
	return contentSubTitle;
    }

    public GroupMembersComponent getGroupMembersComponent() {
	if (groupMembers == null) {
	    groupMembers = WorkspaceFactory.createGroupMembersComponent();
	}
	return groupMembers;
    }

    public BuddiesPresenceComponent getBuddiesPresenceComponent() {
	if (buddiesPresence == null) {
	    buddiesPresence = WorkspaceFactory.createBuddiesPresenceComponent();
	}
	return buddiesPresence;
    }

    public ParticipationComponent getParticipationComponent() {
	if (participatesInGroups == null) {
	    participatesInGroups = WorkspaceFactory.createParticipationComponent();
	}
	return participatesInGroups;
    }

    public ThemeMenuComponent getThemeMenuComponent() {
	if (themeMenu == null) {
	    themeMenu = WorkspaceFactory.createThemeMenuComponent();
	}
	return themeMenu;
    }
}
