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
package au.com.permeance.liferay.portlet.util;


import com.liferay.portal.kernel.util.StringPool;

import org.junit.Assert;
import org.junit.Test;


/**
 * String Util Helper Test.
 * 
 * @author Tim Telcik <tim.telcik@permeance.com.au>
 * 
 * @see StringUtilHelper
 */
public class StringUtilHelperTest {

	@Test
	public void test() {
		
		String curMenuItems = "";
		System.out.println("curMenuItems: " + curMenuItems);
		
		String newMenuItems = "option1,option2";
		System.out.println("newMenuItems: " + newMenuItems);
		
        String mergedMenuItems = StringUtilHelper.addDelimItems( curMenuItems, newMenuItems, StringPool.COMMA );
        System.out.println("mergedMenuItems: " + mergedMenuItems);
        Assert.assertNotNull(mergedMenuItems);
	}

}
