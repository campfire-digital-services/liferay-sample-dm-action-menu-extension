liferay-menu-fix-sample
=======================

**Issue**

A hook that needs to add an action entry into a menu in Liferay's portlets usually has to overwrite a Liferay JSP (via the hook mechanism) to add the entry.
An issue arises if there is more than one hook on the instance trying to add an entry to the same menu. 
Liferay currently only allows one hook to overwrite the JSP effectively.

**Solution**

We are providing an example using the folder action menu in Documents and Media Library

We use a system property "liferay.dl.folder.actions" to store a comma delimited list of jsps to include into that menu.

Each new hook that wants to use this mechanism is expected to:
 * drop its JSPs into /html/portlet/documentlibrary/folder_actions_menu_ext/
 * on a startup listener, add the entries into that system property.
 * overwrite /html/portlet/documentlibrary/folder_actions.jsp with a version that uses this mechanism

The demo hooks allow the developer to configure the jsp(s) entries to add via a "dl.folder.actions.menu.ext" portal properties entry.
We are currently using a system property as portal properties cannot be edited programmatically in hooks (portal.properties file adds or replaces entries, it cannot edit them as we need in this case). This may change.



**License**

This solution is shared with the community for everyone's benefit. However this code is currently under the GPLv3 license, so any improvements made to this workaround must be shared back. 


**Team**

* Chun Ho <chun.ho@permeance.com.au>
* Tim Telcik <tim.telcik@permeance.com.au>
