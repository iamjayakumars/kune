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
package cc.kune.core.client.sn.actions;

import cc.kune.common.client.actions.AbstractExtendedAction;
import cc.kune.common.client.actions.Action;
import cc.kune.common.client.actions.ActionEvent;
import cc.kune.common.shared.i18n.I18nTranslationService;
import cc.kune.core.client.resources.iconic.IconicResources;
import cc.kune.core.client.rpcservices.SocialNetServiceHelper;
import cc.kune.core.shared.dto.GroupDTO;

import com.google.inject.Inject;

// TODO: Auto-generated Javadoc
/**
 * The Class ChangeToAdminAction.
 *
 * @author vjrj@ourproject.org (Vicente J. Ruiz Jurado)
 */
public class ChangeToAdminAction extends AbstractExtendedAction {
  
  /** The sn client utils. */
  private final SocialNetServiceHelper snClientUtils;

  /**
   * Instantiates a new change to admin action.
   *
   * @param i18n the i18n
   * @param res the res
   * @param snClientUtils the sn client utils
   */
  @Inject
  public ChangeToAdminAction(final I18nTranslationService i18n, final IconicResources res,
      final SocialNetServiceHelper snClientUtils) {
    this.snClientUtils = snClientUtils;
    putValue(NAME, i18n.t("Change to administrator"));
    putValue(Action.SMALL_ICON, res.upArrow());
  }

  /* (non-Javadoc)
   * @see cc.kune.common.client.actions.ActionListener#actionPerformed(cc.kune.common.client.actions.ActionEvent)
   */
  @Override
  public void actionPerformed(final ActionEvent event) {
    snClientUtils.changeToAdmin(((GroupDTO) event.getTarget()).getShortName());
  }

}
