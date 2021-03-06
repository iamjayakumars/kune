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
package cc.kune.events.client.actions;

import cc.kune.common.client.actions.ToolbarStyles;
import cc.kune.common.client.actions.ui.descrip.ButtonDescriptor;

import com.bradrydzewski.gwt.calendar.client.CalendarViews;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractCalendarViewSelectBtn.
 *
 * @author vjrj@ourproject.org (Vicente J. Ruiz Jurado)
 */
public class AbstractCalendarViewSelectBtn extends ButtonDescriptor {

  /**
   * Instantiates a new abstract calendar view select btn.
   *
   * @param action the action
   * @param text the text
   * @param days the days
   * @param view the view
   */
  public AbstractCalendarViewSelectBtn(final CalendarViewSelectAction action, final String text,
      final int days, final CalendarViews view) {
    super(text, action);
    action.setDays(days);
    action.setView(view);
    this.withStyles(ToolbarStyles.CSS_BTN_CENTER);
  }

}
