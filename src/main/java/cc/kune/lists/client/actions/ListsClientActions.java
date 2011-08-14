/*
 *
 * Copyright (C) 2007-2009 The kune development team (see CREDITS for details)
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
 \*/
package cc.kune.lists.client.actions;

import static cc.kune.lists.shared.ListsConstants.TYPE_LIST;
import static cc.kune.lists.shared.ListsConstants.TYPE_POST;
import static cc.kune.lists.shared.ListsConstants.TYPE_ROOT;
import cc.kune.chat.client.actions.ChatAboutContentBtn;
import cc.kune.core.client.actions.ActionRegistryByType;
import cc.kune.core.client.i18n.I18nUITranslationService;
import cc.kune.core.client.registry.NewMenusForTypeIdsRegistry;
import cc.kune.core.client.resources.CoreResources;
import cc.kune.core.client.state.Session;
import cc.kune.core.client.state.StateManager;
import cc.kune.gspace.client.actions.AbstractFoldableToolActions;
import cc.kune.gspace.client.actions.ActionGroups;
import cc.kune.gspace.client.actions.ParticipateInContentBtn;
import cc.kune.gspace.client.actions.SetAsHomePageMenuItem;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class ListsClientActions extends AbstractFoldableToolActions {

  final String[] all = { TYPE_ROOT, TYPE_LIST, TYPE_POST };
  final String[] containers = { TYPE_ROOT, TYPE_LIST };
  final String[] containersNoRoot = { TYPE_LIST };
  final String[] contents = { TYPE_POST };
  final String[] noRoot = { TYPE_LIST, TYPE_POST };

  @Inject
  public ListsClientActions(final I18nUITranslationService i18n, final Session session,
      final StateManager stateManager, final ActionRegistryByType registry, final CoreResources res,
      final Provider<GoParentFolderBtn> folderGoUp, final Provider<NewListPostIconMenuItem> newPostItem,
      final Provider<NewListPostIconBtn> newPostIconBtn,
      final Provider<NewListMenuItem> newListMenuItem, final Provider<NewListBtn> newListBtn,
      final Provider<OpenFolderMenuItem> openContentMenuItem,
      final Provider<RefreshListMenuItem> refresh, final Provider<SubscribeToListBtn> subscribeBtn,
      final Provider<OptionsListMenu> optionsMenuContent,
      final Provider<SetListOpenessMenuItem> listOpenessMenuItem,
      final Provider<ParticipateInContentBtn> participateBtn, final ListsNewMenu listNewMenu,
      final NewMenusForTypeIdsRegistry newMenusRegistry, final Provider<ChatAboutContentBtn> chatAbout,
      final Provider<DelListMenuItem> delFolderMenuItem,
      final Provider<SetAsHomePageMenuItem> setAsHomePage) {
    super(session, stateManager, i18n, registry);
    actionsRegistry.addAction(ActionGroups.TOOLBAR, optionsMenuContent, all);
    actionsRegistry.addAction(ActionGroups.TOOLBAR, listNewMenu, containers);
    actionsRegistry.addAction(ActionGroups.TOOLBAR, refresh, all);
    actionsRegistry.addAction(ActionGroups.TOOLBAR, subscribeBtn, containersNoRoot);
    actionsRegistry.addAction(ActionGroups.TOOLBAR, listOpenessMenuItem, containersNoRoot);
    actionsRegistry.addAction(ActionGroups.TOOLBAR, newPostItem, containersNoRoot);
    actionsRegistry.addAction(ActionGroups.TOOLBAR, newPostIconBtn, noRoot);
    actionsRegistry.addAction(ActionGroups.TOOLBAR, newListMenuItem, TYPE_ROOT);
    actionsRegistry.addAction(ActionGroups.TOOLBAR, newListBtn, TYPE_ROOT);
    actionsRegistry.addAction(ActionGroups.TOOLBAR, folderGoUp, contents);
    actionsRegistry.addAction(ActionGroups.TOOLBAR, folderGoUp, containers);
    actionsRegistry.addAction(ActionGroups.TOOLBAR, participateBtn, contents);
    actionsRegistry.addAction(ActionGroups.TOOLBAR, chatAbout, contents);
    actionsRegistry.addAction(ActionGroups.ITEM_MENU, openContentMenuItem, contents);
    actionsRegistry.addAction(ActionGroups.ITEM_MENU, openContentMenuItem, containersNoRoot);
    actionsRegistry.addAction(ActionGroups.ITEM_MENU, delFolderMenuItem, containersNoRoot);
    newMenusRegistry.register(TYPE_LIST, listNewMenu.get());
    newMenusRegistry.register(TYPE_ROOT, listNewMenu.get());
  }

  @Override
  protected void createPostSessionInitActions() {
  }
}