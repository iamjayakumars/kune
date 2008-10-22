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
package org.ourproject.kune.workspace.client.licensefoot;

import org.ourproject.kune.platf.client.View;
import org.ourproject.kune.platf.client.dto.LicenseDTO;
import org.ourproject.kune.platf.client.dto.StateDTO;
import org.ourproject.kune.platf.client.services.KuneErrorHandler;
import org.ourproject.kune.platf.client.state.StateManager;

import com.calclab.suco.client.listener.Listener;
import com.calclab.suco.client.listener.Listener0;

public class EntityLicensePresenter {

    private EntityLicenseView view;
    private LicenseDTO license;

    public EntityLicensePresenter(final StateManager stateManager, KuneErrorHandler errorHandler) {
        stateManager.onStateChanged(new Listener<StateDTO>() {
            public void onEvent(final StateDTO state) {
                setLicense(state);
            }
        });
        errorHandler.onNotDefaultContent(new Listener0() {
            public void onEvent() {
                view.detach();
            }
        });
    }

    public View getView() {
        return view;
    }

    public void init(final EntityLicenseView view) {
        this.view = view;
    }

    public void onLicenseClick() {
        view.openWindow(license.getUrl());
    }

    private void setLicense(final StateDTO state) {
        view.attach();
        this.license = state.getLicense();
        view.showLicense(state.getGroup().getLongName(), license);
    }
}
