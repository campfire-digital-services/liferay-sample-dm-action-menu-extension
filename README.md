# Liferay Sample Documents and Media Action Menu Extension

*liferay-sample-dm-action-menu-extension*


**Issue**

Liferay Portal 6.1 CE GA2 (6.1.1) and 6.1 EE GA2 (6.1.20) only allow one hook to overwrite a JSP.

This project provides a sample solution to LPS ticket [LPS-33757 - Provide an extension mechanism for folder actions in the Documents and Media portlet](http://issues.liferay.com/browse/LPS-33757).  

A hook that needs to add an action entry into a menu in Liferay Portal's portlets usually has to overwrite a Liferay Portal JSP (via the hook mechanism) to add the entry.

An issue arises if there is more than one hook on the instance trying to add an entry to the same menu. 

Refer to LPS ticket [LPS-33757 - Provide an extension mechanism for folder actions in the Documents and Media portlet](http://issues.liferay.com/browse/LPS-33757).


**Solution**

We are providing an example using the folder action menu in Documents and Media Library.

We use a system property "liferay.dl.folder.actions.menu.ext" to store a comma delimited list of jsps to include into that menu.

Each new hook that wants to use this mechanism is expected to:
 * Add custom JSPs into folder "/html/portlet/documentlibrary/folder_actions_menu_ext/". 
 * Using a startup listener, add the entries into that system property. The demo hooks allow the developer to configure the jsp(s) entries to add via a "dl.folder.actions.menu.ext" portal properties entry.
 * Overwrite JSP file "/html/portlet/documentlibrary/folder_actions.jsp" with a version that uses this mechanism

We are currently using a system property for this list of comma delimited JSP entries as portal properties cannot be edited programmatically in hooks (portal.properties file adds or replaces entries, it cannot edit them as we need in this case). 

Reference implementations of the Documents and Media Menu Extension can be see in the following Liferay Portal plugins:

* [Documents and Media Downloader - liferay-dm-folder-downloader](https://github.com/permeance/liferay-dm-folder-downloader)
* [Documents and Media Info Viewer - liferay-dm-info-viewer](https://github.com/permeance/liferay-dm-info-viewer)


**License**

This solution is shared with the community for everyone's benefit. However this code is currently under the GPLv3 license, so any improvements made to this workaround must be shared back. 


**Team**

* Chun Ho - chun.ho@permeance.com.au
* Tim Telcik - tim.telcik@permeance.com.au

