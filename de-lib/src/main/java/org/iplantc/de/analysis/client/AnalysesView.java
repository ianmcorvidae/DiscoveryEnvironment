package org.iplantc.de.analysis.client;

import org.iplantc.de.analysis.client.events.HTAnalysisExpandEvent;
import org.iplantc.de.analysis.client.events.selection.AnalysisAppSelectedEvent;
import org.iplantc.de.analysis.client.events.selection.AnalysisNameSelectedEvent;
import org.iplantc.de.client.models.analysis.Analysis;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.IsWidget;

import java.util.List;

/**
 * @author sriram, jstroot
 */
public interface AnalysesView extends IsWidget,
                                      AnalysisAppSelectedEvent.HasAnalysisAppSelectedEventHandlers,
                                      AnalysisNameSelectedEvent.HasAnalysisNameSelectedEventHandlers,
                                      HTAnalysisExpandEvent.HasHTAnalysisExpandEventHandlers {

    interface Appearance {

        String analysesExecDeleteWarning();

        String appName();

        String endDate();

        String gridEmptyText();

        String name();

        String noParameters();

        String pagingToolbarStyle();

        String paramName();

        String paramType();

        String paramValue();

        String rename();

        String renameAnalysis();

        String retrieveParametersLoadingMask();

        String searchFieldEmptyText();

        String selectionCount(int count);

        String startDate();

        String status();

        String goToOutputFolder();

        ImageResource folderIcon();

        String viewParamLbl();

        ImageResource fileViewIcon();

        String relaunchAnalysis();

        ImageResource runIcon();

        String cancelAnalysis();

        ImageResource deleteIcon();

        String delete();

        ImageResource cancelIcon();

        String analysesMenuLbl();

        String editMenuLbl();

        String renameMenuItem();

        ImageResource fileRenameIcon();

        String updateComments();

        ImageResource userCommentIcon();

        String refresh();

        ImageResource refreshIcon();

        String showAll();

        ImageResource arrow_undoIcon();

        ImageResource saveIcon();

        String saveAs();

        String warning();
    }

    interface Presenter {

        interface Appearance {

            String analysesRetrievalFailure();

            SafeHtml analysisCommentUpdateFailed();

            SafeHtml analysisCommentUpdateSuccess();

            SafeHtml analysisRenameFailed();

            SafeHtml analysisRenameSuccess();

            String analysisStopSuccess(String name);

            String comments();

            String deleteAnalysisError();

            String stopAnalysisError(String name);
        }

        void cancelSelectedAnalyses(List<Analysis> analysesToDelete);

        void deleteSelectedAnalyses(List<Analysis> currentSelection);

        List<Analysis> getSelectedAnalyses();

        void go(final HasOneWidget container, List<Analysis> selectedAnalyses);

        void goToSelectedAnalysisFolder(Analysis selectedAnalysis);

        void onRefreshSelected();

        void onShowAllSelected();

        void relaunchSelectedAnalysis(Analysis selectedAnalysis);

        void renameSelectedAnalysis(Analysis selectedAnalysis, String newName);

        void setSelectedAnalyses(List<Analysis> selectedAnalyses);

        void setViewDebugId(String baseId);

        void updateAnalysisComment(Analysis value, String comment);
    }

    void filterByAnalysisId(String id, String name);

    void filterByParentAnalysisId(String id);

    List<Analysis> getSelectedAnalyses();

    void setSelectedAnalyses(List<Analysis> selectedAnalyses);

}
