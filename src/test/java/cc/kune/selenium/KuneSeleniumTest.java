/*
 *
 * Copyright (C) 2007-2011 The kune development team (see CREDITS for details)
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
package cc.kune.selenium;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Shared behaviour in selenium tests
 */
public abstract class KuneSeleniumTest extends KuneSeleniumDefaults {

  protected String getTempString() {
    final DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    final String value = dateFormat.format(new Date());
    return value;
  }

  protected void login() {
    login("admin", "easyeasy");
  }

  protected void login(final String user, final String password) {
    login.signIn(user, password);
    login.assertIsConnectedAs(user);
  }

  protected void logout() {
    login.logout();
  }

}