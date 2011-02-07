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
package org.ourproject.kune.platf.client.ui.rte.insertlink.ext;

import org.ourproject.kune.platf.client.ui.rte.insertlink.InsertLinkDialog;
import org.ourproject.kune.platf.client.ui.rte.insertlink.abstractlink.InsertLinkAbstractPresenter;

import cc.kune.common.client.utils.TextUtils;

public class InsertLinkExtPresenter extends InsertLinkAbstractPresenter implements InsertLinkExt {

    private InsertLinkExtView view;

    public InsertLinkExtPresenter(InsertLinkDialog editorInsertElement) {
        super(editorInsertElement);
    }

    public void init(InsertLinkExtView view) {
        super.init(view);
        this.view = view;
    }

    @Override
    public boolean isValid() {
        String url = view.getUrl();
        if (url.matches(TextUtils.URL_REGEXP)) {
            return true;
        } else {
            if (!url.startsWith("http://")) {
                url = "http://" + url;
                if (url.matches(TextUtils.URL_REGEXP)) {
                    view.setUrl(url);
                    return true;
                } else {
                    return view.isValid();
                }
            } else {
                // Seems is not valid
                return view.isValid();
            }
        }
    }

    public void onPreview() {
        if (isValid()) {
            view.setPreviewUrl(view.getUrl());
        }
    }
}
