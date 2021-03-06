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
package cc.kune.gspace.client.actions;

import cc.kune.common.shared.i18n.I18nTranslationService;
import cc.kune.core.client.actions.ActionRegistryByType;
import cc.kune.core.client.events.AppStartEvent;
import cc.kune.core.client.events.AppStartEvent.AppStartHandler;
import cc.kune.core.client.state.Session;
import cc.kune.core.client.state.StateManager;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractFoldableToolActions.
 * 
 * @author vjrj@ourproject.org (Vicente J. Ruiz Jurado)
 */
public abstract class AbstractFoldableToolActions {

  /** The actions registry. */
  protected final ActionRegistryByType actionsRegistry;

  /** The i18n. */
  protected final I18nTranslationService i18n;

  /** The session. */
  protected final Session session;

  /** The state manager. */
  protected final StateManager stateManager;

  /**
   * Instantiates a new abstract foldable tool actions.
   * 
   * @param session
   *          the session
   * @param stateManager
   *          the state manager
   * @param i18n
   *          the i18n
   * @param actionsRegistry
   *          the actions registry
   */
  public AbstractFoldableToolActions(final Session session, final StateManager stateManager,
      final I18nTranslationService i18n, final ActionRegistryByType actionsRegistry) {
    this.session = session;
    this.stateManager = stateManager;
    this.i18n = i18n;
    this.actionsRegistry = actionsRegistry;
    session.onAppStart(true, new AppStartHandler() {
      @Override
      public void onAppStart(final AppStartEvent event) {
        createPostSessionInitActions();
      }
    });
  }

  /**
   * Creates the post session init actions.
   */
  protected abstract void createPostSessionInitActions();

}
