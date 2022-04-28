package commons;

import java.io.File;

public class GlobalConstants {
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String DOWNLOAD_FOLDER_PATH = PROJECT_PATH + File.separator +"uploadFiles"+File.separator;
}
