package free.com.se;

import java.util.ListResourceBundle;

public class MyResources  extends ListResourceBundle{

	@Override
	protected Object[][] getContents() {
		Object[][] resObj = {
				{"goodMorning","おはよう"},
				{"goodAfternoon","こんばんわ"}
		};
		return resObj;
	}

}
