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

package org.ourproject.kune.platf.server.state;

import java.util.Date;
import java.util.List;

import org.ourproject.kune.platf.server.access.AccessRights;
import org.ourproject.kune.platf.server.domain.AccessLists;
import org.ourproject.kune.platf.server.domain.Container;
import org.ourproject.kune.platf.server.domain.Group;
import org.ourproject.kune.platf.server.domain.I18nLanguage;
import org.ourproject.kune.platf.server.domain.License;

public class State {
    private String documentId;
    private String content;
    private String title;
    private String toolName;
    private Group group;
    private Container container;
    private AccessLists accessLists;
    private AccessRights contentRights;
    private AccessRights folderRights;
    private AccessRights groupRights;
    private boolean isRateable;
    private Double rate;
    private Integer rateByUsers;
    private Double currentUserRate;
    private String typeId;
    private License license;
    private I18nLanguage language;
    private List authors;
    private Date publishedOn;
    private String tags;

    public State() {
    }

    public AccessLists getAccessLists() {
        return accessLists;
    }

    public void setAccessLists(final AccessLists accessLists) {
        this.accessLists = accessLists;
    }

    public AccessRights getContentRights() {
        return contentRights;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(final String docRef) {
        this.documentId = docRef;
    }

    public AccessRights getFolderRights() {
        return folderRights;
    }

    public void setFolderRights(final AccessRights folderRights) {
        this.folderRights = folderRights;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(final String toolName) {
        this.toolName = toolName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(final Group group) {
        this.group = group;
    }

    public void setContentRights(final AccessRights accessRights) {
        this.contentRights = accessRights;
    }

    public Container getFolder() {
        return container;
    }

    public void setFolder(final Container container) {
        this.container = container;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(final Double rate) {
        if (rate != null) {
            this.rate = rate;
        } else {
            this.rate = 0d;
        }
    }

    public Integer getRateByUsers() {
        return rateByUsers;
    }

    public void setRateByUsers(final Long rateByUsers) {
        if (rateByUsers != null) {
            this.rateByUsers = rateByUsers.intValue();
        } else {
            this.rateByUsers = 0;
        }
    }

    public void setTypeId(final String typeId) {
        this.typeId = typeId;
    }

    public String getTypeId() {
        return typeId;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(final License license) {
        this.license = license;
    }

    public AccessRights getGroupRights() {
        return groupRights;
    }

    public void setGroupRights(final AccessRights groupRights) {
        this.groupRights = groupRights;
    }

    public Double getCurrentUserRate() {
        return currentUserRate;
    }

    public void setCurrentUserRate(final Double currentUserRate) {
        this.currentUserRate = currentUserRate;
    }

    public boolean isRateable() {
        return isRateable;
    }

    public void setIsRateable(final boolean isRateable) {
        this.isRateable = isRateable;
    }

    public I18nLanguage getLanguage() {
        return language;
    }

    public void setLanguage(final I18nLanguage language) {
        this.language = language;
    }

    public Date getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(final Date publishedOn) {
        this.publishedOn = publishedOn;
    }

    public List getAuthors() {
        return authors;
    }

    public void setAuthors(final List authors) {
        this.authors = authors;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(final String tags) {
        this.tags = tags;
    }

}
