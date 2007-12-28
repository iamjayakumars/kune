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

package org.ourproject.kune.docs.client.ctx.admin;

import org.ourproject.kune.platf.client.View;
import org.ourproject.kune.workspace.client.dto.StateDTO;

public class AdminContextPresenter implements AdminContext {

    private final AdminContextView view;

    public AdminContextPresenter(final AdminContextView view) {
        this.view = view;
    }

    public void setState(final StateDTO content) {
        view.setAccessLists(content.getAccessLists());
        view.setLanguage(content.getLanguage());
        view.setAuthors(content.getAuthors());
        view.setPublishedOn(content.getPublishedOn());
        view.setTags(content.getTags());
    }

    public View getView() {
        return view;
    }

}
