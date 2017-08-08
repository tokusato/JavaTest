package tasktmtest.main;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import tasktm.bean.TasktmAp;
import tasktm.bean.TasktmBase;
import tasktm.main.Analyzer;

public class AnalyzerTest {

	@Test
	public void testFilter() {
		HashMap<String, List<TasktmBase>> argMap = new HashMap<>();
		//EE
		List<TasktmBase> eeList = new ArrayList<>();
		eeList.add(new TasktmBase(new HashMap<String, String[]>()) );
		argMap.put("EE", eeList);
		//AP
		List<TasktmBase> apList = new ArrayList<>();
		apList.add(new TasktmAp(new HashMap<String, String[]>()) );
		argMap.put("AP", apList);
		
		
	}


	@Test
	public void testAdd() {
		int expected = 5;
		int actual = new Analyzer().add(2,3);
		assertEquals(expected, actual);
	}

}
