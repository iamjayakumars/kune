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

package org.ourproject.kune.docs.server;

import org.ourproject.kune.platf.client.services.I18nTranslationService;
import org.ourproject.kune.platf.server.content.ContainerManager;
import org.ourproject.kune.platf.server.content.ContentManager;
import org.ourproject.kune.platf.server.domain.Container;
import org.ourproject.kune.platf.server.domain.Content;
import org.ourproject.kune.platf.server.domain.Group;
import org.ourproject.kune.platf.server.domain.ToolConfiguration;
import org.ourproject.kune.platf.server.domain.User;
import org.ourproject.kune.platf.server.manager.ToolConfigurationManager;
import org.ourproject.kune.platf.server.tool.ServerTool;
import org.ourproject.kune.platf.server.tool.ToolRegistry;

import com.google.inject.Inject;

public class DocumentServerTool implements ServerTool {
    public static final String TYPE_ROOT = "docs.root";
    public static final String TYPE_FOLDER = "docs.folder";
    public static final String TYPE_GALLERY = "docs.gallery";
    public static final String TYPE_BLOG = "docs.blog";
    public static final String TYPE_DOCUMENT = "docs.doc";
    public static final String TYPE_POST = "docs.post";
    public static final String TYPE_UPLOADEDFILE = "docs.uploaded";

    public static final String NAME = "docs";
    public static final String ROOT_NAME = "documents";

    private final ContentManager contentManager;
    private final ToolConfigurationManager configurationManager;
    private final ContainerManager containerManager;
    private final I18nTranslationService i18n;

    @Inject
    public DocumentServerTool(final ContentManager contentManager, final ContainerManager containerManager,
	    final ToolConfigurationManager configurationManager, final I18nTranslationService translationService) {
	this.contentManager = contentManager;
	this.containerManager = containerManager;
	this.configurationManager = configurationManager;
	this.i18n = translationService;
    }

    public String getName() {
	return NAME;
    }

    public Group initGroup(final User user, final Group group) {
	final ToolConfiguration config = new ToolConfiguration();
	final Container container = containerManager.createRootFolder(group, NAME, ROOT_NAME, TYPE_ROOT);
	config.setRoot(container);
	group.setToolConfig(NAME, config);
	configurationManager.persist(config);
	final String longName = group.getLongName();
	final String publicDesc = group.getPublicDesc();
	final Content descriptor = contentManager.createContent(i18n.t("About [%s]", longName), publicDesc == null ? ""
		: publicDesc, user, container);
	descriptor.addAuthor(user);
	descriptor.setLanguage(user.getLanguage());
	descriptor.setTypeId(TYPE_DOCUMENT);
	group.setDefaultContent(descriptor);
	return group;
    }

    public void onCreateContainer(final Container container, final Container parent) {
	container.setTypeId(TYPE_FOLDER);
    }

    public void onCreateContent(final Content content, final Container parent) {
	content.setTypeId(TYPE_DOCUMENT);
    }

    @Inject
    public void register(final ToolRegistry registry) {
	registry.register(this);
    }

}
