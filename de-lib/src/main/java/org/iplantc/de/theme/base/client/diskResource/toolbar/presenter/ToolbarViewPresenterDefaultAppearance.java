package org.iplantc.de.theme.base.client.diskResource.toolbar.presenter;

import org.iplantc.de.diskResource.client.ToolbarView;
import org.iplantc.de.resources.client.messages.IplantDisplayStrings;
import org.iplantc.de.theme.base.client.diskResource.DiskResourceMessages;
import org.iplantc.de.theme.base.client.diskResource.toolbar.ToolbarDisplayMessages;

import com.google.gwt.core.client.GWT;

/**
 * @author jstroot
 */
public class ToolbarViewPresenterDefaultAppearance implements ToolbarView.Presenter.Appearance {
    private final IplantDisplayStrings iplantDisplayStrings;
    private final ToolbarDisplayMessages displayMessages;
    private final DiskResourceMessages diskResourceMessages;

    public ToolbarViewPresenterDefaultAppearance() {
        this(GWT.<IplantDisplayStrings> create(IplantDisplayStrings.class),
             GWT.<ToolbarDisplayMessages> create(ToolbarDisplayMessages.class),
             GWT.<DiskResourceMessages> create(DiskResourceMessages.class));
    }

    ToolbarViewPresenterDefaultAppearance(final IplantDisplayStrings iplantDisplayStrings,
                                          final ToolbarDisplayMessages displayMessages,
                                          final DiskResourceMessages diskResourceMessages) {
        this.iplantDisplayStrings = iplantDisplayStrings;
        this.displayMessages = displayMessages;
        this.diskResourceMessages = diskResourceMessages;
    }

    @Override
    public String createDelimitedFileDialogHeight() {
        return "150px";
    }

    @Override
    public String createDelimitedFileDialogWidth() {
        return "300px";
    }

    @Override
    public String done() {
        return iplantDisplayStrings.done();
    }

    @Override
    public String emptyTrash() {
        return diskResourceMessages.emptyTrash();
    }

    @Override
    public String emptyTrashWarning() {
        return diskResourceMessages.emptyTrashWarning();
    }

    @Override
    public String manageDataLinks() {
        return displayMessages.manageDataLinks();
    }

    @Override
    public int manageDataLinksDialogHeight() {
        return 300;
    }

    @Override
    public int manageDataLinksDialogWidth() {
        return 550;
    }

    @Override
    public String manageDataLinksHelp() {
        return displayMessages.manageDataLinksHelp();
    }
}
