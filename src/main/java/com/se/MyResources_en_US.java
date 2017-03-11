package com.se;

import java.util.ListResourceBundle;

public class MyResources_en_US  extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		Object[][] resObj = {
				{"goodMorning","goodMorning"},
				{"goodAfternoon","goodAfternoon"}
		};
		return resObj;
	}

}
