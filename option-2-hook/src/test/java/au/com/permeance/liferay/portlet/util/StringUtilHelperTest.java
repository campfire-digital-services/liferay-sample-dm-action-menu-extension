package au.com.permeance.liferay.portlet.util;


import com.liferay.portal.kernel.util.StringPool;

import org.junit.Assert;
import org.junit.Test;


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
