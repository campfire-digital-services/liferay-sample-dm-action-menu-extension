# Sample Liferay Documents and Media Action Menu Extension

*sample-liferay-dm-action-menu-extension*


**Issue**

Liferay Portal 6.1 CE GA2 (6.1.1) and 6.1 EE GA2 (6.1.20) only allows one hook to overwrite a JSP.

This project provides a sample solution to LPS ticket [LPS-33757 - Provide an extension mechanism for folder actions in the Documents and Media portlet](http://issues.liferay.com/browse/LPS-33757).  

A hook that needs to add an action entry into a menu in Liferay's portlets usually has to overwrite a Liferay JSP (via the hook mechanism) to add the entry.

An issue arises if there is more than one hook on the instance trying to add an entry to the same menu. 

Refer to LPS ticket [LPS-33757 - Provide an extension mechanism for folder actions in the Documents and Media portlet](http://issues.liferay.com/browse/LPS-33757).


**Solution**

We are providing an example using the folder action menu in Documents and Media Library

We use a system property "liferay.dl.folder.actions.menu.ext" to store a comma delimited list of jsps to include into that menu.

Each new hook that wants to use this mechanism is expected to:
 * drop its JSPs into /html/portlet/documentlibrary/folder_actions_menu_ext/. 
 * on a startup listener, add the entries into that system property. The demo hooks allow the developer to configure the jsp(s) entries to add via a "dl.folder.actions.menu.ext" portal properties entry.
 * overwrite /html/portlet/documentlibrary/folder_actions.jsp with a version that uses this mechanism

We are currently using a system property for this list of comma delimited jsp entries as portal properties cannot be edited 
programmatically in hooks (portal.properties file adds or replaces entries, it cannot edit them as we need in this case). 
This may change.



**License**

This solution is shared with the community for everyone's benefit. However this code is currently under the GPLv3 license, so any improvements made to this workaround must be shared back. 


**Team**

* Chun Ho - chun.ho@permeance.com.au
* Tim Telcik - tim.telcik@permeance.com.au

