package org.iplantc.admin.belphegor.client.views;

import org.iplantc.admin.belphegor.client.BelphegorResources;
import org.iplantc.admin.belphegor.client.Constants;
import org.iplantc.admin.belphegor.client.I18N;
import org.iplantc.admin.belphegor.client.apps.presenter.BelphegorAppsViewPresenter;
import org.iplantc.admin.belphegor.client.gin.BelphegorAppInjector;
import org.iplantc.admin.belphegor.client.systemMessage.SystemMessageView;
import org.iplantc.admin.belphegor.client.toolRequest.ToolRequestView;
import org.iplantc.core.resources.client.messages.IplantDisplayStrings;
import org.iplantc.core.uicommons.client.models.UserInfo;
import org.iplantc.core.uicommons.client.widgets.IPlantAnchor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.AbstractHtmlLayoutContainer.HtmlData;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.menu.Menu;

public class BelSample extends Composite {

    private static BelSampleUiBinder uiBinder = GWT.create(BelSampleUiBinder.class);

    interface BelSampleUiBinder extends UiBinder<Widget, BelSample> {}

    @UiField(provided = true)
    BelphegorResources res = BelphegorAppInjector.INSTANCE.getResources();

    @UiField(provided = true)
    IplantDisplayStrings strings = I18N.DISPLAY;

    @UiField
    HtmlLayoutContainer northCon;

    @UiField
    SimpleContainer appsPanel, refGenomePanel, toolRequestPanel, systemMessagesPanel;

    public BelSample(String firstName) {
        res.css().ensureInjected();
        initWidget(uiBinder.createAndBindUi(this));
        init();
    }

    private void init() {
        buildUserMenu();

        BelphegorAppsViewPresenter presenter = BelphegorAppInjector.INSTANCE.getAppsViewPresenter();
        presenter.go(appsPanel);
        
        ToolRequestView.Presenter toolReqPresenter = BelphegorAppInjector.INSTANCE.getToolRequestPresenter();
        toolReqPresenter.go(toolRequestPanel);
        
        SystemMessageView.Presenter sysMsgPresenter = BelphegorAppInjector.INSTANCE.getSystemMessagePresenter();
        sysMsgPresenter.go(systemMessagesPanel);
    }

    private void buildUserMenu() {

        Menu userMenu = new Menu();

        userMenu.setSize("110", "90");
        userMenu.setBorders(true);
        userMenu.setStyleName(res.css().iplantcHeaderMenuBody());
        userMenu.add(new IPlantAnchor(I18N.DISPLAY.logout(), -1, new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.Location.assign(GWT.getHostPageBaseURL() + Constants.CLIENT.logoutUrl());
            }
        }));

        String username = UserInfo.getInstance().getUsername();
        String firstName = UserInfo.getInstance().getFirstName();
        String lastName = UserInfo.getInstance().getLastName();
        String menuLabel = (firstName != null && lastName != null) ? firstName + " " + lastName : username;
        TextButton menuButton = new TextButton(menuLabel);
        menuButton.setMenu(userMenu);

        northCon.add(menuButton, new HtmlData(res.css().iplantcHeaderMenu()));
    }

}