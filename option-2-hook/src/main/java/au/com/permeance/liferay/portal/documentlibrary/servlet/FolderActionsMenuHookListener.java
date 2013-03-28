/**
 * Copyright (C) 2013 Permeance Technologies
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If
 * not, see <http://www.gnu.org/licenses/>.
 */
package au.com.permeance.liferay.portal.documentlibrary.servlet;

import au.com.permeance.liferay.portlet.kernel.util.HookSysPropsKeys;
import au.com.permeance.liferay.portlet.util.HookPropsValues;
import au.com.permeance.liferay.portlet.util.StringUtilHelper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * Folder Action Menu Hook Listener.
 * 
 * @author Chun Ho <chun.ho@permeance.com.au>
 * @author Tim Telcik <tim.telcik@permeance.com.au>
 */
public class FolderActionsMenuHookListener implements ServletContextListener {

    private static final Log LOG = LogFactoryUtil.getLog(FolderActionsMenuHookListener.class);
	

    @Override
    public void contextInitialized(ServletContextEvent event) {
        startApplication();
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        stopApplication();
    }

    public static void startApplication() {
    	
    	System.out.println("startApplication");
    	
    	String newMenuItems = HookPropsValues.DL_FOLDER_ACTIONS_MENU_EXT;
    	LOG.debug("newMenuItems: " + newMenuItems);
    	
        String curMenuItems = GetterUtil.getString( System.getProperty(HookSysPropsKeys.DL_FOLDER_ACTIONS_MENU_EXT), StringPool.BLANK );
        LOG.debug("curMenuItems: " + curMenuItems);
        
        String mergedMenuItems = StringUtilHelper.addDelimItems( curMenuItems, newMenuItems, StringPool.COMMA );
        LOG.debug("mergedMenuItems: " + mergedMenuItems);
        
        System.setProperty( HookSysPropsKeys.DL_FOLDER_ACTIONS_MENU_EXT, mergedMenuItems );
        LOG.info(HookSysPropsKeys.DL_FOLDER_ACTIONS_MENU_EXT + ": " + System.getProperty(HookSysPropsKeys.DL_FOLDER_ACTIONS_MENU_EXT));
    }

    public static void stopApplication() {
    	
    	System.out.println("stopApplication");
    	
    	String newMenuItems = HookPropsValues.DL_FOLDER_ACTIONS_MENU_EXT;
    	LOG.debug("newMenuItems: " + newMenuItems);
    	
        String curMenuItems = GetterUtil.getString( System.getProperty(HookSysPropsKeys.DL_FOLDER_ACTIONS_MENU_EXT), StringPool.BLANK );
        LOG.debug("curMenuItems: " + curMenuItems);

        String mergedMenuItems = StringUtilHelper.removeDelimItems( curMenuItems, newMenuItems, StringPool.COMMA );
        LOG.debug("mergedMenuItems: " + mergedMenuItems);
        
        System.setProperty( HookSysPropsKeys.DL_FOLDER_ACTIONS_MENU_EXT, mergedMenuItems );
        LOG.info(HookSysPropsKeys.DL_FOLDER_ACTIONS_MENU_EXT + ": " + System.getProperty(HookSysPropsKeys.DL_FOLDER_ACTIONS_MENU_EXT));
    }

}
