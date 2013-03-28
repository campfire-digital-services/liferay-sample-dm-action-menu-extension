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
package au.com.permeance.liferay.demo.menufix.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MenuHookListener implements ServletContextListener {

    private static final Log _log = LogFactoryUtil.getLog(MenuHookListener.class);
    private static final String MENU_PORTAL_PROP_KEY = "liferay.dl.folder.actions";
    private static final String HOOK_OPTION_JSP = "option2";

    @Override
    public void contextInitialized(ServletContextEvent event) {
        startApplication();
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        stopApplication();
    }

    public static void startApplication() {
        String menuItems = System.getProperty(MENU_PORTAL_PROP_KEY);
        if (menuItems == null) {
            menuItems = "";
        }
        System.setProperty(MENU_PORTAL_PROP_KEY, StringUtil.add(menuItems, HOOK_OPTION_JSP, StringPool.COMMA));
        _log.info(MENU_PORTAL_PROP_KEY + StringPool.COLON + System.getProperty(MENU_PORTAL_PROP_KEY));
    }

    public static void stopApplication() {
        String menuItems = System.getProperty(MENU_PORTAL_PROP_KEY);
        if (menuItems == null) {
            menuItems = "";
        }
        System.setProperty(MENU_PORTAL_PROP_KEY, StringUtil.remove(menuItems, HOOK_OPTION_JSP, StringPool.COMMA));
        _log.info(MENU_PORTAL_PROP_KEY + StringPool.COLON + System.getProperty(MENU_PORTAL_PROP_KEY));
    }

}
