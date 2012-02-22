package org.iplantc.de.client.views.panels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.iplantc.core.client.widgets.Hyperlink;
import org.iplantc.core.jsonutil.JsonUtil;
import org.iplantc.de.client.I18N;
import org.iplantc.de.client.models.AnalysisParameter;
import org.iplantc.de.client.models.JsAnalysisParameter;
import org.iplantc.de.client.services.AnalysisServiceFacade;
import org.iplantc.de.client.utils.DataViewContextExecutor;
import org.iplantc.de.client.utils.builders.context.DataContextBuilder;
import org.iplantc.de.client.views.dialogs.SaveAsDialog;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * 
 * A panel to view analysis parameters
 * 
 * TODO : Integrate into viewer architecture
 * 
 * @author sriram
 * 
 */

public class AnalysisParameterViewerPanel extends ContentPanel {

    private Grid<AnalysisParameter> grid;
    private ToolBar toolbar;

    public AnalysisParameterViewerPanel() {
        init();
    }

    private void init() {
        setSize(515, 300);
        setLayout(new FitLayout());
        retrieveData();
        initToolbar();
        initGrid();
        add(grid);
    }

    private void initToolbar() {
        toolbar = new ToolBar();
        toolbar.add(buildSaveAsButton());
        setTopComponent(toolbar);
    }

    private Button buildSaveAsButton() {
        Button b = new Button(I18N.DISPLAY.saveAs());
        b.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                SaveAsDialog d = new SaveAsDialog("Save", "Save As", null, null);
                d.show();

            }
        });
        return b;
    }

    private void retrieveData() {
        AnalysisServiceFacade facade = new AnalysisServiceFacade();
        facade.getAnalysisParams(new AsyncCallback<String>() {

            @Override
            public void onSuccess(String result) {
                JSONObject obj = JSONParser.parseStrict(result).isObject();
                JSONArray arr = JsonUtil.getArray(obj, "parameters");
                JsArray<JsAnalysisParameter> js_params = JsonUtil.asArrayOf(arr.toString());
                List<AnalysisParameter> parameters = new ArrayList<AnalysisParameter>();
                for (int i = 0; i < js_params.length(); i++) {
                    JsAnalysisParameter jsp = js_params.get(i);
                    AnalysisParameter param = new AnalysisParameter(jsp.getId(), jsp.getName(), jsp
                            .getType(), jsp.getValue());
                    parameters.add(param);
                }

                grid.getStore().removeAll();
                grid.getStore().add(parameters);

            }

            @Override
            public void onFailure(Throwable caught) {
                System.out.println(caught.getMessage());

            }
        });

    }

    private void initGrid() {
        final ColumnModel colModel = buildColumnModel();
        grid = new Grid<AnalysisParameter>(new ListStore<AnalysisParameter>(), colModel);
    }

    private ColumnModel buildColumnModel() {
        ColumnConfig param_name = new ColumnConfig("param_name", I18N.DISPLAY.paramName(), 150); //$NON-NLS-1$
        ColumnConfig param_type = new ColumnConfig("param_type", I18N.DISPLAY.paramType(), 100); //$NON-NLS-1$
        ColumnConfig param_value = new ColumnConfig("param_value", I18N.DISPLAY.paramValue(), 250); //$NON-NLS-1$
        param_value.setRenderer(new ParamValueCellRenderer());

        List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
        columns.addAll(Arrays.asList(param_name, param_type, param_value));

        return new ColumnModel(columns);
    }

    private class ParamValueCellRenderer implements GridCellRenderer<AnalysisParameter> {

        @Override
        public Object render(AnalysisParameter model, String property, ColumnData config, int rowIndex,
                int colIndex, ListStore<AnalysisParameter> store, Grid<AnalysisParameter> grid) {
            final String val = model.get(AnalysisParameter.PARAMETER_VALUE);
            if (model.get(AnalysisParameter.PARAMETER_TYPE).equals("Input")) {
                Hyperlink link = new Hyperlink(val, "analysis-param-value");
                link.addClickListener(new Listener<ComponentEvent>() {

                    @Override
                    public void handleEvent(ComponentEvent be) {
                        List<String> contexts = new ArrayList<String>();
                        DataContextBuilder builder = new DataContextBuilder();
                        contexts.add(builder.build(val));
                        DataViewContextExecutor executor = new DataViewContextExecutor();
                        executor.execute(contexts);

                    }
                });
                return link;
            } else {
                return val;
            }
        }
    }

}
