package tasktm.main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import tasktm.bean.TasktmAp;
import tasktm.bean.TasktmBase;
import tasktm.bean.TasktmHub;

public class Collecter extends Processer{

	/**
	 * info : collecting TASKTM information according to sequence
	 * @param nothing
	 * @return nothing
	 * */
	public void collect() {
		/* each component */
		List<String> compoList = new ArrayList<>();
		compoList = Arrays.asList(properties.getProperty(SEQUENCE).split(COMMA));

		@SuppressWarnings("unused")
		List<TasktmBase> ttList;
		Path p;
		for (String compo : compoList){
			//initialize ttList for each compo
			ttList = new ArrayList<>();
			//searching file whose name includes compo name
			try(DirectoryStream<Path> ds =	Files.newDirectoryStream(
					Paths.get(properties.getProperty(INPUT_FILE_FOLDER_PATH)));) {

				// iterating for the target input file directory
				Iterator<Path> ite = ds.iterator();
				while (ite.hasNext()){
					p = ite.next();
					// file name contains upper compo string? then execute reading
					if (p.getFileName().toString().toUpperCase().contains(compo))
						beanMap.put(compo, readFile(compo,p));
				}

			} catch (IOException e) {
				e.printStackTrace();
			}


		}

	}

	/**
	 * reading each compo's tasktm csv file
	 * @param compo
	 * @param p
	 * @return List<TasktmBase>
	 * @throws IOException
	 * */
	private List<TasktmBase> readFile(String compo, Path p) throws IOException {

		//read file and put each line into String List
		List<String> lines = new ArrayList<>();

		//this method return this List
		List<TasktmBase> taskTmList = new ArrayList<>();

		try {
			//TODO can designate charset!!
			lines = Files.readAllLines(p,Charset.defaultCharset());
			//removing header -1
			int i;
			int headerlines = Integer.valueOf((String)properties.getProperty(HEADER_LINES));
			//TODO this is stupid way to removing header. if possible do it in a simple way using smart api.
			//TODO have to consider just only header exists.( but usually(by default) there are several lines before headers)
			for (i = 0 ; i < headerlines - 1  ; i++) lines.remove(0);

			//this mapKey may not be necessary
			String[] mapKey = lines.get(0).split(COMMA);
			System.out.println("for debug. designated header is : " + lines.get(0));
			lines.remove(0);

			String elements[] = null;
			//delegate parse procedure to bean class.
			Map<String, String> tasktmMap =null;
			//object creating now
			TasktmBase ttBase = null;
			//from now on read data.
			for (String eachLine : lines){
				//split lines at front of loop in order not to write redundunt code
				elements = eachLine.split(COMMA);
				int j = 0;
				for (j = 0; j < elements.length ;j++) tasktmMap.put(mapKey[j],elements[j]);

				//creating compo object
				switch (compo){
				//TODO have to think about loadbalance (e.g. AP1,AP2 EE1,EE2 and so on)
				case "EE":
				case "ER":
				case "EK":
					//procedure EE, ER, EK
					ttBase = new TasktmHub(tasktmMap);
					break;
				case "AP":
					//procedure AP
					ttBase = new TasktmAp(tasktmMap);
					break;
				default:
					throw new RuntimeException("Wrong Configuration : sequence");
				}

				taskTmList.add(ttBase);
			}

		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
		return taskTmList;
	}




}
