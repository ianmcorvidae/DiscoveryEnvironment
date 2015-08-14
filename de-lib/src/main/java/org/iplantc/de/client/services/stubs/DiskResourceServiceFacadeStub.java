package org.iplantc.de.client.services.stubs;

import org.iplantc.de.client.models.HasPaths;
import org.iplantc.de.client.models.dataLink.DataLink;
import org.iplantc.de.client.models.diskResources.*;
import org.iplantc.de.client.models.services.DiskResourceMove;
import org.iplantc.de.client.models.viewer.InfoType;
import org.iplantc.de.client.services.DiskResourceServiceFacade;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.web.bindery.autobean.shared.Splittable;

import com.sencha.gxt.core.shared.FastMap;
import com.sencha.gxt.data.shared.loader.FilterPagingLoadConfigBean;

import java.util.List;
import java.util.Set;

/**
 * @author jstroot
 */
public class DiskResourceServiceFacadeStub implements DiskResourceServiceFacade {

    @Override
    public void refreshFolder(Folder folder, final AsyncCallback<List<Folder>> callback) {

    }

    @Override
    public DiskResource combineDiskResources(DiskResource from, DiskResource into) {
        return null;
    }

    @Override
    public Folder convertToFolder(DiskResource diskResource) {
        return null;
    }

    @Override
    public void getRootFolders(AsyncCallback<RootFolders> callback) {

    }

    @Override
    public void getFolderContents(Folder folder, List<InfoType> infoTypeFilterList,
                                  TYPE entityType, FilterPagingLoadConfigBean loadConfig,
                                  AsyncCallback<Folder> callback) {

    }

    @Override
    public void getSubFolders(Folder parent, AsyncCallback<List<Folder>> callback) {

    }

    @Override
    public void createFolder(Folder parentFolder, String newFolderName, AsyncCallback<Folder> callback) {

    }

    @Override
    public void diskResourcesExist(HasPaths diskResourcePaths, AsyncCallback<DiskResourceExistMap> callback) {

    }

    @Override
    public void moveDiskResources(List<DiskResource> diskResources, Folder destFolder, AsyncCallback<DiskResourceMove> callback) {

    }

    @Override
    public void moveContents(String sourceFolderId, Folder destFolder, AsyncCallback<DiskResourceMove> callback) {

    }

    @Override
    public void renameDiskResource(DiskResource src, String destName, AsyncCallback<DiskResource> callback) {

    }

    @Override
    public void importFromUrl(String url, DiskResource dest, AsyncCallback<String> callback) {

    }

    @Override
    public String getEncodedSimpleDownloadURL(String path) {
        return null;
    }

    @Override
    public <T extends DiskResource> void deleteDiskResources(List<T> diskResources, AsyncCallback<HasPaths> callback) {

    }

    @Override
    public void deleteContents(String selectedFolderId, AsyncCallback<HasPaths> callback) {

    }

    @Override
    public void deleteDiskResources(HasPaths diskResources, AsyncCallback<HasPaths> callback) {

    }

    @Override
    public void getDiskResourceMetaData(DiskResource resource, AsyncCallback<List<DiskResourceMetadata>> callback) {

    }

    @Override
    public void setDiskResourceMetaData(DiskResource resource, Set<DiskResourceMetadata> mdToUpdate, Set<DiskResourceMetadata> mdToDelete, AsyncCallback<String> callback) {

    }

    @Override
    public void shareDiskResource(JSONObject body, AsyncCallback<String> callback) {

    }

    @Override
    public void unshareDiskResource(JSONObject body, AsyncCallback<String> callback) {

    }

    @Override
    public void getPermissions(JSONObject body, AsyncCallback<String> callback) {

    }

    @Override
    public void search(String term, int size, String type, AsyncCallback<String> callback) {

    }

    @Override
    public void getStat(FastMap<TYPE> paths, AsyncCallback<FastMap<DiskResource>> callback) {

    }

    @Override
    public void emptyTrash(String user, AsyncCallback<String> callback) {

    }

    @Override
    public void restoreDiskResource(HasPaths request, AsyncCallback<String> callback) {

    }

    @Override
    public void createDataLinks(List<String> ticketIdList, AsyncCallback<List<DataLink>> callback) {

    }

    @Override
    public void listDataLinks(List<String> diskResourceIds, AsyncCallback<String> callback) {

    }

    @Override
    public void deleteDataLinks(List<String> dataLinkIds, AsyncCallback<String> callback) {

    }

    @Override
    public void getInfoTypes(AsyncCallback<List<InfoType>> callback) {

    }

    @Override
    public void setFileType(String filePath, String type, AsyncCallback<String> callback) {

    }

    @Override
    public DiskResourceAutoBeanFactory getDiskResourceFactory() {
        return null;
    }

    @Override
    public void restoreAll(AsyncCallback<String> callback) {

    }

    @Override
    public void getMetadataTemplateListing(AsyncCallback<List<MetadataTemplateInfo>> callback) {

    }

    @Override
    public void getMetadataTemplate(String templateId, AsyncCallback<MetadataTemplate> callback) {

    }

    @Override
    public void shareWithAnonymous(HasPaths diskResourcePaths, AsyncCallback<String> callback) {
        // TODO Auto-generated method stub

    }

    @Override
    public void getMetadataTemplateAvus(DiskResource resource,
                                        AsyncCallback<DiskResourceMetadataTemplate> callback) {
        // TODO Auto-generated method stub
    }

    @Override
    public void setMetadataTemplateAvus(DiskResource resource,
                                        DiskResourceMetadataTemplate templateAvus,
                                        AsyncCallback<String> callback) {
        // TODO Auto-generated method stub
    }

    @Override
    public void deleteMetadataTemplateAvus(DiskResource resource,
                                           DiskResourceMetadataTemplate templateAvus,
                                           AsyncCallback<String> callback) {
        // TODO Auto-generated method stub
    }

    @Override
    public void copyMetadata(String srcUUID,
                              Splittable paths,
                              boolean override,
                              AsyncCallback<String> callback) {
        // TODO Auto-generated method stub

    }

    @Override
    public void saveMetadata(String srcUUID,
                             String path,
                             boolean recursive,
                             AsyncCallback<String> callback) {
        // TODO Auto-generated method stub

    }

    @Override
    public void createNcbiSraFolderStructure(Folder parentFolder,
                                             String[] foldersToCreate,
                                             AsyncCallback<String> callback) {
        // TODO Auto-generated method stub

    }

}
