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
package cc.kune.core.client.notify.msgs;

import cc.kune.common.client.notify.NotifyLevel;
import cc.kune.core.client.notify.msgs.UserNotifierPresenter.UserNotifierProxy;
import cc.kune.core.client.notify.msgs.UserNotifierPresenter.UserNotifierView;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.ProxyEvent;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealRootPopupContentEvent;

public class UserNotifierPresenter extends Presenter<UserNotifierView, UserNotifierProxy> {
    @ProxyCodeSplit
    public interface UserNotifierProxy extends Proxy<UserNotifierPresenter> {
    }

    public interface UserNotifierView extends PopupView {
        public void notify(UserNotifyEvent event);
    }

    @Inject
    public UserNotifierPresenter(final EventBus eventBus, final UserNotifierView view, final UserNotifierProxy proxy) {
        super(eventBus, view, proxy);
    }

    @ProxyEvent
    public void onUserNotify(final UserNotifyEvent event) {
        if (event.getLevel() != NotifyLevel.log) {
            getView().notify(event);
        }
    }

    @Override
    protected void revealInParent() {
        RevealRootPopupContentEvent.fire(this, this);
    }

}