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

package org.ourproject.kune.platf.client.utils;

import java.util.List;

import org.ourproject.kune.platf.client.rpc.KuneService;
import org.ourproject.kune.platf.client.state.Session;
import org.ourproject.kune.sitebar.client.Site;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;

public class PrefetchUtilites {

    public static void preFetchImpImages() {
	Image.prefetch("images/spin-kune-thund-green.gif");

	Image.prefetch("css/img/button15cdark.png");
	Image.prefetch("css/img/button15clight.png");
	Image.prefetch("css/img/button15cxlight.png");
	Image.prefetch("css/img/button17cdark.png");
	Image.prefetch("css/img/button17clight.png");
	Image.prefetch("css/img/button17cxlight.png");
	Image.prefetch("css/img/button20cdark.png");
	Image.prefetch("css/img/button20clight.png");
	Image.prefetch("css/img/button20cxlight.png");
	Image.prefetch("css/img/button-bg-soft.gif");
	Image.prefetch("css/img/button-bg-hard.gif");

	Image.prefetch("gwm/themes/alphacubecustom/b.gif");
	Image.prefetch("gwm/themes/alphacubecustom/bl.gif");
	Image.prefetch("gwm/themes/alphacubecustom/br.gif");
	Image.prefetch("gwm/themes/alphacubecustom/close-btn.gif");
	Image.prefetch("gwm/themes/alphacubecustom/close-btn-on.gif");
	Image.prefetch("gwm/themes/alphacubecustom/l.gif");
	Image.prefetch("gwm/themes/alphacubecustom/max-btn.gif");
	Image.prefetch("gwm/themes/alphacubecustom/max-btn-on.gif");
	Image.prefetch("gwm/themes/alphacubecustom/min-btn.gif");
	Image.prefetch("gwm/themes/alphacubecustom/min-btn-on.gif");
	Image.prefetch("gwm/themes/alphacubecustom/resize-btn.gif");
	Image.prefetch("gwm/themes/alphacubecustom/restore-btn.gif");
	Image.prefetch("gwm/themes/alphacubecustom/r.gif");
	Image.prefetch("gwm/themes/alphacubecustom/t.gif");
	Image.prefetch("gwm/themes/alphacubecustom/tr.gif");
	Image.prefetch("gwm/themes/alphacubecustom/tl.gif");
	Image.prefetch("gwm/themes/alphacubecustom/t-off.gif");
	Image.prefetch("gwm/themes/alphacubecustom/tr-off.gif");
	Image.prefetch("gwm/themes/alphacubecustom/tl-off.gif");
    }

    public static void preFetchLicenses(final Session session) {
	org.ourproject.kune.platf.client.rpc.KuneServiceAsync kuneService = KuneService.App.getInstance();
	kuneService.getAllLicenses(new AsyncCallback() {
	    public void onFailure(final Throwable arg0) {
		// TODO
		Site.error("Error fetching initial data");
	    }

	    public void onSuccess(final Object result) {
		session.setLicenses((List) result);
	    }
	});

	kuneService.getNotCCLicenses(new AsyncCallback() {
	    public void onFailure(final Throwable arg0) {
		// TODO
		Site.error("Error fetching initial data");
	    }

	    public void onSuccess(final Object result) {
		session.setLicensesNotCC((List) result);
	    }
	});

    }
}
