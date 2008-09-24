package org.ourproject.kune.platf.client.services;

import org.ourproject.kune.platf.client.actions.ActionManager;
import org.ourproject.kune.platf.client.actions.ContentActionRegistry;
import org.ourproject.kune.platf.client.actions.ContentIconsRegistry;
import org.ourproject.kune.platf.client.actions.ContextActionRegistry;
import org.ourproject.kune.platf.client.actions.DragDropContentRegistry;
import org.ourproject.kune.platf.client.actions.toolbar.ActionToolbar;
import org.ourproject.kune.platf.client.actions.toolbar.ActionToolbarPanel;
import org.ourproject.kune.platf.client.actions.toolbar.ActionToolbarPresenter;
import org.ourproject.kune.platf.client.app.Application;
import org.ourproject.kune.platf.client.app.ApplicationComponentGroup;
import org.ourproject.kune.platf.client.app.ApplicationDefault;
import org.ourproject.kune.platf.client.app.HistoryWrapper;
import org.ourproject.kune.platf.client.app.HistoryWrapperDefault;
import org.ourproject.kune.platf.client.app.ToolGroup;
import org.ourproject.kune.platf.client.dto.StateToken;
import org.ourproject.kune.platf.client.rpc.AsyncCallbackSimple;
import org.ourproject.kune.platf.client.rpc.ContentService;
import org.ourproject.kune.platf.client.rpc.ContentServiceAsync;
import org.ourproject.kune.platf.client.rpc.GroupService;
import org.ourproject.kune.platf.client.rpc.GroupServiceAsync;
import org.ourproject.kune.platf.client.rpc.I18nService;
import org.ourproject.kune.platf.client.rpc.I18nServiceAsync;
import org.ourproject.kune.platf.client.rpc.SocialNetworkService;
import org.ourproject.kune.platf.client.rpc.SocialNetworkServiceAsync;
import org.ourproject.kune.platf.client.state.ContentProvider;
import org.ourproject.kune.platf.client.state.ContentProviderDefault;
import org.ourproject.kune.platf.client.state.Session;
import org.ourproject.kune.platf.client.state.SessionDefault;
import org.ourproject.kune.platf.client.state.StateManager;
import org.ourproject.kune.platf.client.state.StateManagerDefault;
import org.ourproject.kune.platf.client.tool.ToolSelector;
import org.ourproject.kune.platf.client.tool.ToolSelectorPresenter;
import org.ourproject.kune.platf.client.ui.QuickTipsHelper;
import org.ourproject.kune.platf.client.ui.dialogs.FileUploader;
import org.ourproject.kune.platf.client.ui.dialogs.FileUploaderDialog;
import org.ourproject.kune.platf.client.ui.rate.RateIt;
import org.ourproject.kune.platf.client.ui.rate.RateItPanel;
import org.ourproject.kune.platf.client.ui.rate.RateItPresenter;
import org.ourproject.kune.platf.client.ui.rate.RatePanel;
import org.ourproject.kune.platf.client.ui.rate.RatePresenter;
import org.ourproject.kune.workspace.client.ctxnav.ContextNavigator;
import org.ourproject.kune.workspace.client.ctxnav.ContextNavigatorPanel;
import org.ourproject.kune.workspace.client.ctxnav.ContextNavigatorPresenter;
import org.ourproject.kune.workspace.client.editor.TextEditor;
import org.ourproject.kune.workspace.client.editor.TextEditorPanel;
import org.ourproject.kune.workspace.client.editor.TextEditorPresenter;
import org.ourproject.kune.workspace.client.entitylogo.EntityLogo;
import org.ourproject.kune.workspace.client.entitylogo.EntityLogoPanel;
import org.ourproject.kune.workspace.client.entitylogo.EntityLogoPresenter;
import org.ourproject.kune.workspace.client.i18n.I18nTranslator;
import org.ourproject.kune.workspace.client.i18n.I18nTranslatorPresenter;
import org.ourproject.kune.workspace.client.i18n.I18nTranslatorView;
import org.ourproject.kune.workspace.client.i18n.I18nUITranslationService;
import org.ourproject.kune.workspace.client.i18n.LanguageSelector;
import org.ourproject.kune.workspace.client.i18n.LanguageSelectorPresenter;
import org.ourproject.kune.workspace.client.i18n.LanguageSelectorView;
import org.ourproject.kune.workspace.client.i18n.ui.I18nTranslatorPanel;
import org.ourproject.kune.workspace.client.i18n.ui.LanguageSelectorPanel;
import org.ourproject.kune.workspace.client.licensechoose.LicenseChoose;
import org.ourproject.kune.workspace.client.licensechoose.LicenseChoosePanel;
import org.ourproject.kune.workspace.client.licensechoose.LicenseChoosePresenter;
import org.ourproject.kune.workspace.client.licensefoot.EntityLicensePanel;
import org.ourproject.kune.workspace.client.licensefoot.EntityLicensePresenter;
import org.ourproject.kune.workspace.client.newgroup.NewGroup;
import org.ourproject.kune.workspace.client.newgroup.NewGroupPanel;
import org.ourproject.kune.workspace.client.newgroup.NewGroupPresenter;
import org.ourproject.kune.workspace.client.search.EntityLiveSearcherView;
import org.ourproject.kune.workspace.client.search.GroupLiveSearchPanel;
import org.ourproject.kune.workspace.client.search.GroupLiveSearcher;
import org.ourproject.kune.workspace.client.search.GroupLiveSearcherPresenter;
import org.ourproject.kune.workspace.client.search.SiteSearcher;
import org.ourproject.kune.workspace.client.search.SiteSearcherPanel;
import org.ourproject.kune.workspace.client.search.SiteSearcherPresenter;
import org.ourproject.kune.workspace.client.search.SiteSearcherView;
import org.ourproject.kune.workspace.client.search.UserLiveSearcher;
import org.ourproject.kune.workspace.client.search.UserLiveSearcherPanel;
import org.ourproject.kune.workspace.client.search.UserLiveSearcherPresenter;
import org.ourproject.kune.workspace.client.signin.SignIn;
import org.ourproject.kune.workspace.client.signin.SignInPanel;
import org.ourproject.kune.workspace.client.signin.SignInPresenter;
import org.ourproject.kune.workspace.client.site.Site;
import org.ourproject.kune.workspace.client.site.SiteToken;
import org.ourproject.kune.workspace.client.site.msg.SiteMessage;
import org.ourproject.kune.workspace.client.site.msg.SiteMessagePanel;
import org.ourproject.kune.workspace.client.site.msg.SiteMessagePresenter;
import org.ourproject.kune.workspace.client.site.msg.SiteMessageView;
import org.ourproject.kune.workspace.client.site.rpc.UserService;
import org.ourproject.kune.workspace.client.site.rpc.UserServiceAsync;
import org.ourproject.kune.workspace.client.sitebar.sitelogo.SiteLogo;
import org.ourproject.kune.workspace.client.sitebar.sitelogo.SiteLogoPanel;
import org.ourproject.kune.workspace.client.sitebar.sitelogo.SiteLogoPresenter;
import org.ourproject.kune.workspace.client.sitebar.sitenewgroup.SiteNewGroupLink;
import org.ourproject.kune.workspace.client.sitebar.sitenewgroup.SiteNewGroupLinkPanel;
import org.ourproject.kune.workspace.client.sitebar.sitenewgroup.SiteNewGroupLinkPresenter;
import org.ourproject.kune.workspace.client.sitebar.siteoptions.SiteOptions;
import org.ourproject.kune.workspace.client.sitebar.siteoptions.SiteOptionsPanel;
import org.ourproject.kune.workspace.client.sitebar.siteoptions.SiteOptionsPresenter;
import org.ourproject.kune.workspace.client.sitebar.siteprogress.SiteProgress;
import org.ourproject.kune.workspace.client.sitebar.siteprogress.SiteProgressPanel;
import org.ourproject.kune.workspace.client.sitebar.siteprogress.SiteProgressPresenter;
import org.ourproject.kune.workspace.client.sitebar.sitepublic.SitePublicSpaceLink;
import org.ourproject.kune.workspace.client.sitebar.sitepublic.SitePublicSpaceLinkPanel;
import org.ourproject.kune.workspace.client.sitebar.sitepublic.SitePublicSpaceLinkPresenter;
import org.ourproject.kune.workspace.client.sitebar.sitesearch.SiteSearch;
import org.ourproject.kune.workspace.client.sitebar.sitesearch.SiteSearchPanel;
import org.ourproject.kune.workspace.client.sitebar.sitesearch.SiteSearchPresenter;
import org.ourproject.kune.workspace.client.sitebar.sitesign.SiteSignInLink;
import org.ourproject.kune.workspace.client.sitebar.sitesign.SiteSignInLinkPanel;
import org.ourproject.kune.workspace.client.sitebar.sitesign.SiteSignInLinkPresenter;
import org.ourproject.kune.workspace.client.sitebar.sitesign.SiteSignOutLink;
import org.ourproject.kune.workspace.client.sitebar.sitesign.SiteSignOutLinkPanel;
import org.ourproject.kune.workspace.client.sitebar.sitesign.SiteSignOutLinkPresenter;
import org.ourproject.kune.workspace.client.sitebar.siteusermenu.SiteUserMenu;
import org.ourproject.kune.workspace.client.sitebar.siteusermenu.SiteUserMenuPanel;
import org.ourproject.kune.workspace.client.sitebar.siteusermenu.SiteUserMenuPresenter;
import org.ourproject.kune.workspace.client.skel.WorkspaceSkeleton;
import org.ourproject.kune.workspace.client.socialnet.GroupMembersSummary;
import org.ourproject.kune.workspace.client.socialnet.GroupMembersSummaryPanel;
import org.ourproject.kune.workspace.client.socialnet.GroupMembersSummaryPresenter;
import org.ourproject.kune.workspace.client.socialnet.GroupMembersSummaryView;
import org.ourproject.kune.workspace.client.socialnet.ParticipationSummary;
import org.ourproject.kune.workspace.client.socialnet.ParticipationSummaryPanel;
import org.ourproject.kune.workspace.client.socialnet.ParticipationSummaryPresenter;
import org.ourproject.kune.workspace.client.socialnet.ParticipationSummaryView;
import org.ourproject.kune.workspace.client.summary.GroupSummary;
import org.ourproject.kune.workspace.client.summary.GroupSummaryPanel;
import org.ourproject.kune.workspace.client.summary.GroupSummaryPresenter;
import org.ourproject.kune.workspace.client.summary.GroupSummaryView;
import org.ourproject.kune.workspace.client.tags.TagsSummary;
import org.ourproject.kune.workspace.client.tags.TagsSummaryPanel;
import org.ourproject.kune.workspace.client.tags.TagsSummaryPresenter;
import org.ourproject.kune.workspace.client.themes.WsThemePanel;
import org.ourproject.kune.workspace.client.themes.WsThemePresenter;
import org.ourproject.kune.workspace.client.title.EntitySubTitle;
import org.ourproject.kune.workspace.client.title.EntitySubTitlePanel;
import org.ourproject.kune.workspace.client.title.EntitySubTitlePresenter;
import org.ourproject.kune.workspace.client.title.EntityTitle;
import org.ourproject.kune.workspace.client.title.EntityTitlePanel;
import org.ourproject.kune.workspace.client.title.EntityTitlePresenter;

import com.calclab.suco.client.ioc.decorator.Singleton;
import com.calclab.suco.client.ioc.module.AbstractModule;
import com.calclab.suco.client.ioc.module.Factory;
import com.calclab.suco.client.listener.Listener;
import com.calclab.suco.client.listener.Listener0;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class KuneModule extends AbstractModule {

    @Override
    public void onLoad() {

	register(Singleton.class, new Factory<Session>(Session.class) {
	    public Session create() {
		return new SessionDefault(Cookies.getCookie(Site.USERHASH), $$(UserServiceAsync.class));
	    }
	}, new Factory<I18nServiceAsync>(I18nServiceAsync.class) {
	    public I18nServiceAsync create() {
		final I18nServiceAsync service = (I18nServiceAsync) GWT.create(I18nService.class);
		((ServiceDefTarget) service).setServiceEntryPoint(GWT.getModuleBaseURL() + "I18nService");
		return service;
	    }
	}, new Factory<UserServiceAsync>(UserServiceAsync.class) {
	    public UserServiceAsync create() {
		final UserServiceAsync service = (UserServiceAsync) GWT.create(UserService.class);
		((ServiceDefTarget) service).setServiceEntryPoint(GWT.getModuleBaseURL() + "UserService");
		return service;
	    }
	}, new Factory<SocialNetworkServiceAsync>(SocialNetworkServiceAsync.class) {
	    public SocialNetworkServiceAsync create() {
		final SocialNetworkServiceAsync snServiceAsync = (SocialNetworkServiceAsync) GWT
			.create(SocialNetworkService.class);
		((ServiceDefTarget) snServiceAsync).setServiceEntryPoint(GWT.getModuleBaseURL()
			+ "SocialNetworkService");
		return snServiceAsync;
	    }
	}, new Factory<GroupServiceAsync>(GroupServiceAsync.class) {
	    public GroupServiceAsync create() {
		final GroupServiceAsync groupServiceAsync = (GroupServiceAsync) GWT.create(GroupService.class);
		((ServiceDefTarget) groupServiceAsync).setServiceEntryPoint(GWT.getModuleBaseURL() + "GroupService");
		return groupServiceAsync;
	    }
	}, new Factory<ContentServiceAsync>(ContentServiceAsync.class) {
	    public ContentServiceAsync create() {
		final ContentServiceAsync contentServiceAsync = (ContentServiceAsync) GWT.create(ContentService.class);
		((ServiceDefTarget) contentServiceAsync)
			.setServiceEntryPoint(GWT.getModuleBaseURL() + "ContentService");
		return contentServiceAsync;
	    }
	});

	register(Singleton.class, new Factory<I18nUITranslationService>(I18nUITranslationService.class) {
	    public I18nUITranslationService create() {
		final I18nUITranslationService i18n = new I18nUITranslationService();
		i18n.init($(I18nServiceAsync.class), $(Session.class), new Listener0() {
		    public void onEvent() {
			onI18nReady();
		    }
		});
		return i18n;
	    }
	});

	$(I18nUITranslationService.class);
    }

    private void onI18nReady() {
	final I18nUITranslationService i18n = $(I18nUITranslationService.class);

	if (container.hasProvider(I18nTranslationService.class)) {
	    container.removeProvider(I18nTranslationService.class);
	}

	register(Singleton.class, new Factory<I18nTranslationService>(I18nTranslationService.class) {
	    public I18nTranslationService create() {
		return i18n;
	    }
	});

	register(Singleton.class, new Factory<HistoryWrapper>(HistoryWrapper.class) {
	    public HistoryWrapper create() {
		return new HistoryWrapperDefault();
	    }
	}, new Factory<ContentProvider>(ContentProvider.class) {
	    public ContentProvider create() {
		return new ContentProviderDefault($(ContentServiceAsync.class));
	    }
	}, new Factory<StateManager>(StateManager.class) {
	    public StateManager create() {
		final StateManagerDefault stateManager = new StateManagerDefault($(ContentProvider.class),
			$(Session.class), $(HistoryWrapper.class));
		History.addHistoryListener(stateManager);
		return stateManager;
	    }
	});

	register(Singleton.class, new Factory<KuneErrorHandler>(KuneErrorHandler.class) {
	    public KuneErrorHandler create() {
		return new KuneErrorHandler($(Session.class), i18n, $$(WorkspaceSkeleton.class), $$(StateManager.class));
	    }
	});

	register(Singleton.class, new Factory<Images>(Images.class) {
	    public Images create() {
		return Images.App.getInstance();
	    }
	}, new Factory<ImageUtils>(ImageUtils.class) {
	    public ImageUtils create() {
		return new ImageUtils();
	    }
	});

	register(Singleton.class, new Factory<WorkspaceSkeleton>(WorkspaceSkeleton.class) {
	    public WorkspaceSkeleton create() {
		return new WorkspaceSkeleton();
	    }
	});

	AsyncCallbackSimple.init($(KuneErrorHandler.class));

	final WorkspaceSkeleton ws = $(WorkspaceSkeleton.class);
	register(Singleton.class, new Factory<Application>(Application.class) {
	    public Application create() {
		return new ApplicationDefault($(Session.class));
	    }

	    @Override
	    public void onAfterCreated(final Application instance) {
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<QuickTipsHelper>(QuickTipsHelper.class) {
	    public QuickTipsHelper create() {
		return new QuickTipsHelper();
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<SiteProgress>(SiteProgress.class) {
	    public SiteProgress create() {
		final SiteProgressPresenter presenter = new SiteProgressPresenter();
		final SiteProgressPanel panel = new SiteProgressPanel(presenter, $$(SitePublicSpaceLink.class));
		presenter.init(panel);
		return presenter;
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<Site>(Site.class) {
	    public Site create() {
		return new Site(i18n, $(SiteProgress.class), $$(SiteMessage.class));
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<SitePublicSpaceLink>(SitePublicSpaceLink.class) {
	    public SitePublicSpaceLink create() {
		final SitePublicSpaceLinkPresenter presenter = new SitePublicSpaceLinkPresenter($(StateManager.class));
		final SitePublicSpaceLinkPanel panel = new SitePublicSpaceLinkPanel(presenter, ws, i18n,
			$(Images.class));
		presenter.init(panel);
		return presenter;
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<SiteMessage>(SiteMessage.class) {
	    public SiteMessage create() {
		final SiteMessagePresenter siteMessagePresenter = new SiteMessagePresenter();
		final SiteMessageView siteMessageView = new SiteMessagePanel(siteMessagePresenter, true, i18n);
		siteMessagePresenter.init(siteMessageView);
		return siteMessagePresenter;
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<SiteUserMenu>(SiteUserMenu.class) {
	    public SiteUserMenu create() {
		final SiteUserMenuPresenter presenter = new SiteUserMenuPresenter($(Session.class),
			$(StateManager.class));
		final SiteUserMenuPanel panel = new SiteUserMenuPanel(presenter, ws, i18n);
		presenter.init(panel);
		return presenter;
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<SiteSignInLink>(SiteSignInLink.class) {
	    public SiteSignInLink create() {
		final SiteSignInLinkPresenter presenter = new SiteSignInLinkPresenter($(Session.class));
		final SiteSignInLinkPanel panel = new SiteSignInLinkPanel(presenter, i18n, ws);
		presenter.init(panel);
		return presenter;
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<SiteSignOutLink>(SiteSignOutLink.class) {
	    public SiteSignOutLink create() {
		final SiteSignOutLinkPresenter presenter = new SiteSignOutLinkPresenter($(Session.class),
			$$(UserServiceAsync.class), $$(KuneErrorHandler.class));
		final SiteSignOutLinkPanel panel = new SiteSignOutLinkPanel(presenter, i18n, ws);
		presenter.init(panel);
		return presenter;
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<SiteNewGroupLink>(SiteNewGroupLink.class) {
	    public SiteNewGroupLink create() {
		final SiteNewGroupLinkPresenter presenter = new SiteNewGroupLinkPresenter();
		final SiteNewGroupLinkPanel panel = new SiteNewGroupLinkPanel(presenter, ws, i18n);
		presenter.init(panel);
		return presenter;
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<SiteOptions>(SiteOptions.class) {
	    public SiteOptions create() {
		final SiteOptionsPresenter presenter = new SiteOptionsPresenter();
		final SiteOptionsPanel panel = new SiteOptionsPanel(presenter, ws, i18n, $$(I18nTranslator.class));
		presenter.init(panel);
		return presenter;
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<SiteSearch>(SiteSearch.class) {
	    public SiteSearch create() {
		final SiteSearchPresenter presenter = new SiteSearchPresenter($$(SiteSearcher.class));
		final SiteSearchPanel panel = new SiteSearchPanel(presenter, ws, i18n);
		presenter.init(panel);
		return presenter;
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<SiteLogo>(SiteLogo.class) {
	    public SiteLogo create() {
		final SiteLogoPresenter presenter = new SiteLogoPresenter($(Session.class));
		final SiteLogoPanel panel = new SiteLogoPanel(presenter, ws);
		presenter.init(panel);
		return presenter;
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<EntityLogo>(EntityLogo.class) {
	    public EntityLogo create() {
		final EntityLogoPresenter presenter = new EntityLogoPresenter($(StateManager.class),
			$(WsThemePresenter.class));
		final EntityLogoPanel panel = new EntityLogoPanel(i18n, ws);
		presenter.init(panel);
		return presenter;
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<WsThemePresenter>(WsThemePresenter.class) {
	    public WsThemePresenter create() {
		final WsThemePresenter presenter = new WsThemePresenter($(Session.class), $$(GroupServiceAsync.class),
			$(StateManager.class));
		final WsThemePanel panel = new WsThemePanel(ws, presenter, i18n);
		presenter.init(panel);
		return presenter;
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<EntityTitle>(EntityTitle.class) {
	    public EntityTitle create() {
		final EntityTitlePresenter presenter = new EntityTitlePresenter(i18n, $(KuneErrorHandler.class),
			$(StateManager.class), $(Session.class), $$(ContentServiceAsync.class),
			$$(ContextNavigator.class));
		final EntityTitlePanel panel = new EntityTitlePanel(ws, presenter);
		presenter.init(panel);
		return presenter;
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<EntitySubTitle>(EntitySubTitle.class) {
	    public EntitySubTitle create() {
		final EntitySubTitlePresenter presenter = new EntitySubTitlePresenter(i18n, $(StateManager.class));
		final EntitySubTitlePanel panel = new EntitySubTitlePanel(presenter, i18n, ws);
		presenter.init(panel);
		return presenter;
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<EntityLicensePresenter>(EntityLicensePresenter.class) {
	    public EntityLicensePresenter create() {
		final EntityLicensePresenter presenter = new EntityLicensePresenter($(StateManager.class));
		final EntityLicensePanel panel = new EntityLicensePanel(presenter, i18n, ws);
		presenter.init(panel);
		return presenter;
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<RatePresenter>(RatePresenter.class) {
	    public RatePresenter create() {
		final RatePresenter presenter = new RatePresenter($(StateManager.class));
		final RatePanel panel = new RatePanel(null, null, i18n, ws);
		presenter.init(panel);
		return presenter;
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<RateIt>(RateIt.class) {
	    public RateIt create() {
		final RateItPresenter presenter = new RateItPresenter(i18n, $(Session.class),
			$$(ContentServiceAsync.class), $(StateManager.class));
		final RateItPanel panel = new RateItPanel(presenter, i18n, ws);
		presenter.init(panel);
		return presenter;
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<GroupMembersSummary>(GroupMembersSummary.class) {
	    public GroupMembersSummary create() {
		final GroupMembersSummaryPresenter presenter = new GroupMembersSummaryPresenter(i18n,
			$(StateManager.class), $(ImageUtils.class), $(Session.class),
			$$(SocialNetworkServiceAsync.class), $$(GroupLiveSearcher.class), $(WsThemePresenter.class));
		final GroupMembersSummaryView view = new GroupMembersSummaryPanel(presenter, i18n, ws);
		presenter.init(view);
		return presenter;
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<GroupSummary>(GroupSummary.class) {
	    public GroupSummary create() {
		final GroupSummaryPresenter presenter = new GroupSummaryPresenter($(StateManager.class),
			$(WsThemePresenter.class));
		final GroupSummaryView view = new GroupSummaryPanel(presenter, i18n, ws);
		presenter.init(view);
		return presenter;
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<ParticipationSummary>(ParticipationSummary.class) {
	    public ParticipationSummary create() {
		final ParticipationSummaryPresenter presenter = new ParticipationSummaryPresenter(i18n,
			$(StateManager.class), $(ImageUtils.class), $(Session.class),
			$$(SocialNetworkServiceAsync.class), $(WsThemePresenter.class));
		final ParticipationSummaryView view = new ParticipationSummaryPanel(presenter, i18n, ws);
		presenter.init(view);
		return presenter;
	    }
	});

	register(ApplicationComponentGroup.class, new Factory<TagsSummary>(TagsSummary.class) {
	    public TagsSummary create() {
		final TagsSummaryPresenter presenter = new TagsSummaryPresenter($(Session.class),
			$$(SiteSearcher.class), $(StateManager.class), $(WsThemePresenter.class));
		final TagsSummaryPanel panel = new TagsSummaryPanel(presenter, i18n, ws);
		presenter.init(panel);
		return presenter;
	    }
	});

	register(Singleton.class, new Factory<SiteSearcher>(SiteSearcher.class) {
	    public SiteSearcher create() {
		final SiteSearcherPresenter presenter = new SiteSearcherPresenter($$(StateManager.class));
		final SiteSearcherView view = new SiteSearcherPanel(presenter, i18n, ws);
		presenter.init(view);
		return presenter;
	    }
	});

	register(Singleton.class, new Factory<I18nTranslator>(I18nTranslator.class) {
	    public I18nTranslator create() {
		final I18nTranslatorPresenter presenter = new I18nTranslatorPresenter($(Session.class),
			$(I18nServiceAsync.class), i18n);
		final I18nTranslatorView view = new I18nTranslatorPanel(presenter, i18n, $(LanguageSelector.class), ws);
		presenter.init(view);
		return presenter;
	    }
	});

	register(Singleton.class, new Factory<SignIn>(SignIn.class) {
	    public SignIn create() {
		final SignInPresenter presenter = new SignInPresenter($(Session.class), $(StateManager.class), i18n,
			$(UserServiceAsync.class));
		final SignInPanel view = new SignInPanel(presenter, i18n, ws);
		presenter.init(view);
		return presenter;
	    }
	});

	register(Singleton.class, new Factory<LicenseChoose>(LicenseChoose.class) {
	    public LicenseChoose create() {
		final LicenseChoosePresenter presenter = new LicenseChoosePresenter($(Session.class));
		final LicenseChoosePanel view = new LicenseChoosePanel(presenter, i18n);
		presenter.init(view);
		return presenter;
	    }
	});

	register(Singleton.class, new Factory<NewGroup>(NewGroup.class) {
	    public NewGroup create() {
		final NewGroupPresenter presenter = new NewGroupPresenter(i18n, $(Session.class),
			$(StateManager.class), $$(GroupServiceAsync.class));
		final NewGroupPanel view = new NewGroupPanel(presenter, i18n, $$(LicenseChoose.class));
		presenter.init(view);
		return presenter;
	    }
	});

	register(Singleton.class, new Factory<UserLiveSearcher>(UserLiveSearcher.class) {
	    public UserLiveSearcher create() {
		final UserLiveSearcherPresenter presenter = new UserLiveSearcherPresenter();
		final EntityLiveSearcherView view = new UserLiveSearcherPanel(presenter, i18n);
		presenter.init(view);
		return presenter;
	    }
	});

	register(Singleton.class, new Factory<GroupLiveSearcher>(GroupLiveSearcher.class) {
	    public GroupLiveSearcher create() {
		final GroupLiveSearcherPresenter presenter = new GroupLiveSearcherPresenter();
		final EntityLiveSearcherView view = new GroupLiveSearchPanel(presenter, i18n);
		presenter.init(view);
		return presenter;
	    }
	});

	register(Singleton.class, new Factory<ToolSelector>(ToolSelector.class) {
	    public ToolSelector create() {
		final ToolSelectorPresenter presenter = new ToolSelectorPresenter($(StateManager.class),
			$(WsThemePresenter.class));
		return presenter;
	    }
	});

	register(Singleton.class, new Factory<TextEditor>(TextEditor.class) {
	    public TextEditor create() {
		final TextEditorPresenter presenter = new TextEditorPresenter(null, true);
		final TextEditorPanel panel = new TextEditorPanel(presenter, i18n, ws);
		presenter.init(panel);
		return presenter;
	    }
	});

	register(Singleton.class, new Factory<LanguageSelector>(LanguageSelector.class) {
	    public LanguageSelector create() {
		final LanguageSelectorPresenter presenter = new LanguageSelectorPresenter($(Session.class));
		final LanguageSelectorView view = new LanguageSelectorPanel(presenter, i18n);
		presenter.init(view);
		return presenter;
	    }
	});

	register(Singleton.class, new Factory<ActionManager>(ActionManager.class) {
	    public ActionManager create() {
		return new ActionManager(ws);
	    }
	});

	register(Singleton.class, new Factory<ContextActionRegistry>(ContextActionRegistry.class) {
	    public ContextActionRegistry create() {
		return new ContextActionRegistry();
	    }
	});

	register(Singleton.class, new Factory<ContentActionRegistry>(ContentActionRegistry.class) {
	    public ContentActionRegistry create() {
		return new ContentActionRegistry();
	    }
	});

	register(Singleton.class, new Factory<DragDropContentRegistry>(DragDropContentRegistry.class) {
	    public DragDropContentRegistry create() {
		return new DragDropContentRegistry();
	    }
	});

	register(Singleton.class, new Factory<ContentIconsRegistry>(ContentIconsRegistry.class) {
	    public ContentIconsRegistry create() {
		return new ContentIconsRegistry();
	    }
	});

	register(Singleton.class, new Factory<ContextNavigator>(ContextNavigator.class) {
	    public ContextNavigator create() {
		final ActionToolbarPanel contextNavigatorToolbar = new ActionToolbarPanel(
			ActionToolbarPanel.Position.context, $(Session.class), $$(ActionManager.class), ws);
		final ActionToolbar toolbar = new ActionToolbarPresenter($(Session.class), contextNavigatorToolbar,
			$(ContextActionRegistry.class));

		final ContextNavigatorPresenter presenter = new ContextNavigatorPresenter($(StateManager.class),
			$(Session.class), $$(ContentServiceAsync.class), i18n, $(EntityTitle.class),
			$(ContentIconsRegistry.class), $(DragDropContentRegistry.class),
			$(ContextActionRegistry.class), toolbar);
		final ContextNavigatorPanel panel = new ContextNavigatorPanel(presenter, i18n, ws,
			$(ActionManager.class));
		presenter.init(panel);
		return presenter;
	    }
	});

	register(Singleton.class, new Factory<FileUploader>(FileUploader.class) {
	    public FileUploader create() {
		final FileUploaderDialog panel = new FileUploaderDialog(i18n, ws, $(Session.class));
		return panel;
	    }
	});

	// Register of tokens like "signin", "newgroup", "translate" etcetera
	$(StateManager.class).addSiteToken(SiteToken.signin.toString(), new Listener<StateToken>() {
	    public void onEvent(final StateToken previousStateToken) {
		$(SignIn.class).doSignIn(previousStateToken);
	    }
	});

	$(StateManager.class).addSiteToken(SiteToken.newgroup.toString(), new Listener<StateToken>() {
	    public void onEvent(final StateToken previousStateToken) {
		$(NewGroup.class).doNewGroup(previousStateToken);
	    }
	});

	$(StateManager.class).addSiteToken(SiteToken.translate.toString(), new Listener<StateToken>() {
	    public void onEvent(final StateToken previousStateToken) {
		$(I18nTranslator.class).doShowTranslator();
	    }
	});

	// $(SiteProgress.class);
	// $(Site.class);
	// $(SitePublicSpaceLink.class);
	// $(SiteMessage.class);
	// $(SiteUserMenu.class);
	// $(SiteSignInLink.class);
	// $(SiteSignOutLink.class);
	// $(SiteNewGroupLink.class);
	// $(SiteOptions.class);
	// $(SiteSearch.class);
	// $(SiteLogo.class);
	//
	// $(GroupMembersSummary.class);
	// $(ParticipationSummary.class);
	// $(TagsSummary.class);
	// $(GroupSummary.class);
	//
	// $(EntityLogo.class);
	// $(EntityTitle.class);
	// $(EntitySubTitle.class);
	// $(WsThemePresenter.class);
	// $(EntityLicensePresenter.class);
	// $(RateIt.class);
	// $(RatePresenter.class);

	$(ApplicationComponentGroup.class).createAll();
	$(ToolGroup.class).createAll();
	$(Application.class).start();

    }
}
