/*
 *
 * Copyright (C) 2007-2013 Licensed to the Comunes Association (CA) under
 * one or more contributor license agreements (see COPYRIGHT for details).
 * The CA licenses this file to you under the GNU Affero General Public
 * License version 3, (the "License"); you may not use this file except in
 * compliance with the License. This file is part of kune.
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
package cc.kune.lists.client.actions;

import cc.kune.common.client.actions.ui.descrip.MenuItemDescriptor;
import cc.kune.common.shared.i18n.I18nTranslationService;
import cc.kune.core.client.resources.CoreResources;
import cc.kune.core.client.state.Session;
import cc.kune.core.shared.dto.GroupListDTO;

import com.google.inject.Inject;

// TODO: Auto-generated Javadoc
/**
 * The Class SetListOpenessMenuItem.
 *
 * @author vjrj@ourproject.org (Vicente J. Ruiz Jurado)
 */
public class SetListOpenessMenuItem extends MenuItemDescriptor {

  /**
   * Instantiates a new sets the list openess menu item.
   *
   * @param i18n the i18n
   * @param action the action
   * @param session the session
   * @param res the res
   * @param menu the menu
   */
  @Inject
  public SetListOpenessMenuItem(final I18nTranslationService i18n, final SetListOpenessAction action,
      final Session session, final CoreResources res, final OptionsListMenu menu) {
    super(action);
    setParent(menu, false);
    final Boolean isPublic = session.getContainerState().getAccessLists().getViewers().getMode().equals(
        GroupListDTO.EVERYONE);
    action.putValue(SetListOpenessAction.ISPUBLIC, isPublic);
    if (!isPublic) {
      withText(i18n.t("Make this list public"));
      withIcon(res.everybody());
    } else {
      withText(i18n.t("Make this list not public"));
      withIcon(res.nobody());
    }
  }
}
