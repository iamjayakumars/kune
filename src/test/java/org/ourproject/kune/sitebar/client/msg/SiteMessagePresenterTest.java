package org.ourproject.kune.sitebar.client.msg;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.ourproject.kune.workspace.client.sitebar.msg.SiteMessagePresenter;
import org.ourproject.kune.workspace.client.sitebar.msg.SiteMessageView;

public class SiteMessagePresenterTest {

    private SiteMessagePresenter presenter;
    private SiteMessageView view;

    @Before
    public void createObjects() {
	view = EasyMock.createStrictMock(SiteMessageView.class);
	presenter = new SiteMessagePresenter();
    }

    @Test
    public void testViewInitialization() {
	view.hide();
	EasyMock.replay(view);
	presenter.init(view);
	EasyMock.verify(view);
    }

    @Test
    public void testMessage() {
	view.hide();
	view.setMessage("test 1", 3, 0);
	view.show();
	EasyMock.replay(view);
	presenter.init(view);
	presenter.setMessage("test 1", 0);
	EasyMock.verify(view);
    }

    @Test
    public void testTwoMessagesSameType() {
	view.hide();
	view.setMessage("test 1", 3, 0);
	view.show();
	view.setMessage("test 1<br>test 2");
	view.show();
	EasyMock.replay(view);
	presenter.init(view);
	presenter.setMessage("test 1", 0);
	presenter.setMessage("test 2", 0);
	EasyMock.verify(view);
    }

    @Test
    public void testTwoMessagesDifTypes() {
	view.hide();
	view.setMessage("test 1", 3, 1);
	view.show();
	view.setMessage("test 1<br>test 2", 1, 0);
	view.show();
	EasyMock.replay(view);
	presenter.init(view);
	presenter.setMessage("test 1", 1);
	presenter.setMessage("test 2", 0);
	EasyMock.verify(view);
    }

}
