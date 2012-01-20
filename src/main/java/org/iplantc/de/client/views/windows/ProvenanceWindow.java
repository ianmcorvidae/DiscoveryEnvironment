package org.iplantc.de.client.views.windows;

import org.iplantc.core.uidiskresource.client.models.FileIdentifier;

import com.extjs.gxt.ui.client.widget.layout.FitLayout;

/**
 * Provides a user interface for provenance widgets.
 * 
 * @author amuir
 * 
 */
public abstract class ProvenanceWindow extends FileWindow {
    /**
     * The provenance text associated with the file data.
     */
    protected String provenance;

    /**
     * Constructs an instance of the window.
     * 
     * @param tag a unique identifier for the window.
     * @param file the unique identifier for the file shown in the window.
     * @param manifest of file contents.
     */
    protected ProvenanceWindow(String tag, FileIdentifier file, String manifest) {
        super(tag, file, manifest);
    }

    /**
     * Performs configuration of the window.
     */
    protected void config() {
        super.config();

        setCollapsible(false);
        setSize(640, 438);
        setLayout(new FitLayout());
    }

    /**
     * {@inheritDoc}
     */
    protected void init() {
        super.init();

        clearPanel();

        // get our provenance
        // updateProvenance();

        // add necessary tabs
        constructPanel();
    }

    /**
     * Performs an update operation on the provenance data.
     * 
     * @param provenanceNew the new data to use when updating.
     */
    protected void updateProvenance(String provenanceNew) {
        provenance = provenanceNew;

        updatePanelProvenance(provenance);
    }

    /**
     * Register handlers with event bus.
     */
    protected abstract void registerEventHandlers();

    /**
     * Clear panel's contents.
     */
    protected abstract void clearPanel();

    /**
     * Build panel's contents.
     */
    protected abstract void constructPanel();

    /**
     * Handle provenance changes.
     * 
     * @param provenanceNew update provenance text with this argument.
     */
    protected abstract void updatePanelProvenance(String provenanceNew);
}
