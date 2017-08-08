package tasktm.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import tasktm.bean.TasktmBase;

public class Processer {

	public static Properties properties = new Properties();
	public static final String PROPERTY_PATH = ".\\src\\main\\java\\tasktm\\tasktm.properties";
	/* key name for each properties */
	public static final String SEQUENCE="sequence";
	public static final String HEADER_LINES="header_lines";
	public static final String TRANSACTION_TYPE="sequence";

	public static final String INPUT_FILE_FOLDER_PATH="input_file_folder_path";

	public static String COMMA = ",";

	/** . key is each compo you defined in the config file */
	Map<String,List<TasktmBase>> beanMap = new HashMap<>();

	/**
	 * reading configuration
	 * read configuration object is visible to the class which extends this class
	 * @author S.Tokumaru
	 * @param nothing
	 * @return nothing
	 *
	 * */
	static void readProperties(){
		try (InputStream is = new FileInputStream(new File(PROPERTY_PATH))){

			properties = new Properties();
			properties.setProperty(SEQUENCE,"EE,ER,EK,AP");
			properties.setProperty(HEADER_LINES,"5");
			properties.setProperty(INPUT_FILE_FOLDER_PATH,".\\src\\main\\java\\tasktm\\in");
			properties.setProperty(TRANSACTION_TYPE,"MN,TT");
//			int i = 0;
//			while ((i = is.read()) != -1){
//				System.out.println(i);
//			}
//			properties.load(is);
		} catch (IOException ioe){
			ioe.printStackTrace();
		}
	}
}
