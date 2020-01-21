package TestPackage;

public class Config {
    public static final String xlsFilePath = "src/test/java/Data/dataSample.xlsx";
    public static final String DB_HOST = "localhost";
    public static final String DB_PORT = "3306";
    public static final String DB_NAME = "test";
    public static final String DB_UNAME = "root";
    public static final String DB_PASSWORD = "";

    public static final String DB_URL = "jdbc:mysql://"+DB_HOST+":"+DB_PORT+"/"+DB_NAME;
}
