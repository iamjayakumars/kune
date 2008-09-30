package org.ourproject.kune.platf.client.actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.ourproject.kune.platf.client.dto.AccessRightsDTO;
import org.ourproject.kune.platf.client.dto.AccessRolDTO;
import org.ourproject.kune.platf.client.dto.StateToken;
import org.ourproject.kune.platf.client.state.Session;

import com.calclab.suco.client.listener.Listener;

public class ActionRegistryTest {

    private static final String DEF_CONTENT_TYPE_ID = "test";
    private ActionRegistry<StateToken> registry;
    private ActionToolbarMenuAndItemDescriptor<StateToken> adminAction;
    private ActionToolbarMenuAndItemDescriptor<StateToken> editorAction;
    private ActionMenuItemDescriptor<StateToken> viewerAction;
    private Session session;

    @Test
    public void actionsEmptyButNeverNull() {
	Mockito.stub(session.isLogged()).toReturn(true);
	checkActionLists(0, new AccessRightsDTO(true, true, true), true);
	checkActionLists(0, new AccessRightsDTO(true, true, true), false);
	checkActionLists(0, new AccessRightsDTO(false, true, true), true);
	checkActionLists(0, new AccessRightsDTO(false, true, true), false);
	checkActionLists(0, new AccessRightsDTO(false, false, true), true);
	checkActionLists(0, new AccessRightsDTO(false, false, true), false);
    }

    @Before
    public void before() {
	session = Mockito.mock(Session.class);
	registry = new ActionRegistry<StateToken>();
	adminAction = new ActionToolbarMenuAndItemDescriptor<StateToken>(AccessRolDTO.Administrator,
		ActionToolbarPosition.topbar, new Listener<StateToken>() {
		    public void onEvent(final StateToken parameter) {
		    }
		});
	editorAction = new ActionToolbarMenuAndItemDescriptor<StateToken>(AccessRolDTO.Editor,
		ActionToolbarPosition.topbar, new Listener<StateToken>() {
		    public void onEvent(final StateToken parameter) {
		    }
		});

	viewerAction = new ActionMenuItemDescriptor<StateToken>(AccessRolDTO.Viewer, new Listener<StateToken>() {
	    public void onEvent(final StateToken parameter) {
	    }
	});
	viewerAction.setMustBeAuthenticated(false);
    }

    @Test
    public void mustBeAuthFalse() {
	Mockito.stub(session.isLogged()).toReturn(false);
	addDefActions();
	checkActionLists(0, new AccessRightsDTO(false, true, true), true);
	checkActionLists(1, new AccessRightsDTO(false, true, true), false);
    }

    @Test
    public void testAddWhenAdmin() {
	Mockito.stub(session.isLogged()).toReturn(true);
	addDefActions();
	checkActionLists(2, new AccessRightsDTO(true, true, true), true);
	checkActionLists(3, new AccessRightsDTO(true, true, true), false);
    }

    @Test
    public void testAddWhenEditor() {
	Mockito.stub(session.isLogged()).toReturn(true);
	addDefActions();
	checkActionLists(1, new AccessRightsDTO(false, true, true), true);
	checkActionLists(2, new AccessRightsDTO(false, true, true), false);
    }

    @Test
    public void testAddWhenViewer() {
	Mockito.stub(session.isLogged()).toReturn(true);
	addDefActions();
	checkActionLists(0, new AccessRightsDTO(false, false, true), true);
	checkActionLists(1, new AccessRightsDTO(false, false, true), false);
    }

    @Test
    public void testEnablingFalse() {
	Mockito.stub(session.isLogged()).toReturn(true);
	adminAction.setEnableCondition(new ActionEnableCondition<StateToken>() {
	    public boolean mustBeEnabled(final StateToken param) {
		return false;
	    }
	});
	registry.addAction(adminAction, DEF_CONTENT_TYPE_ID);
	assertTrue(!registry.checkEnabling(adminAction, new StateToken()));
    }

    @Test
    public void testEnablingTrue() {
	Mockito.stub(session.isLogged()).toReturn(true);
	adminAction.setEnableCondition(new ActionEnableCondition<StateToken>() {
	    public boolean mustBeEnabled(final StateToken param) {
		return true;
	    }
	});
	registry.addAction(adminAction, DEF_CONTENT_TYPE_ID);
	assertTrue(registry.checkEnabling(adminAction, new StateToken()));
    }

    private void addDefActions() {
	registry.addAction(adminAction, DEF_CONTENT_TYPE_ID);
	registry.addAction(editorAction, DEF_CONTENT_TYPE_ID);
	registry.addAction(viewerAction, DEF_CONTENT_TYPE_ID);
    }

    private void checkActionLists(final int expectedActions, final AccessRightsDTO accessRightsDTO,
	    final boolean toolbarActions) {
	assertEquals(expectedActions, registry.getCurrentActions(new StateToken(), DEF_CONTENT_TYPE_ID,
		session.isLogged(), accessRightsDTO, toolbarActions).size());
    }
}
