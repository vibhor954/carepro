package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.*;


public class DataReader{

    private static List<Data> dataObjectRepo = new ArrayList<Data>();
    private static Map<String, DataElements> testCaseMapping=new HashMap<>();
    Workbook workBook=null;
    org.apache.poi.ss.usermodel.Sheet generalConfigSheet=null;
    Map<String, String> globalVarsMap=new LinkedHashMap<>();
    private static DataReader dataReader;
    private static GlobalVars globalVars;

    public static DataReader getInstance(){
        if(dataReader==null)
            dataReader=new DataReader();
        return dataReader;
    }

    public void setupDataSheet() throws IOException {
        globalVars=GlobalVars.getInstance();
        InputStream input = getClass().getClassLoader().getResourceAsStream("testdata.xlsx");
        setDataObject(input);
    }

    /**
     * Returns list of test cases and their params
     * @author Vibhor Agarwal
     */
    public static List<Data> getDataObjectRepo(){
        return dataObjectRepo;
    }

    /**
     * Returns map of test cases and their params
     * @author Vibhor Agarwal
     */
    public static Map<String, DataElements> getTestCaseMapping(){
        return testCaseMapping;
    }


    /**
     * Presets all test case data from the excel sheet.
     * <br> This should be only be referenced in before scenario methods.
     *
     * @author Vibhor Agarwal
     */
    private void setDataObject(InputStream inputStream) throws IOException {
        workBook = new XSSFWorkbook(inputStream);
        int totalSheetCount = workBook.getNumberOfSheets();
        try{
            generalConfigSheet =workBook.getSheet("GeneralConfig");
            //************* initializing all general config variables based on the column names **********
            initializeGeneralConfigData();
            //************* initializing all test cases and their parameters **********
            for (int sheetNumber = 1; sheetNumber < totalSheetCount; sheetNumber++) {
                XSSFSheet sheet= (XSSFSheet) workBook.getSheetAt(sheetNumber);
                Map<String, DataElements> tempMap=new HashMap<>();
                tempMap=getDataElements(sheet);

                for(Map.Entry<String, DataElements> entry: tempMap.entrySet()){
                    testCaseMapping.put(entry.getKey(), entry.getValue());
                }
                //testCaseMapping=getDataElements(sheet);
                dataObjectRepo.add(new Data(sheet.getSheetName(), getDataElements(sheet)));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void setMappingKeyValue(Map<String, DataElements> tempMap){
        tempMap.keySet();
        //testCaseMapping.put()

    }

    /**
     * @param cell
     * @return
     * @description: This function takes a cell as an argument and returns the cell value based on the type of cell value type
     */
    @SuppressWarnings("deprecation")
    public String getCellData(Cell cell){
        String cellData="";
        try {
            if (cell != null) {
                switch (cell.getCellType()) {

                    case Cell.CELL_TYPE_STRING:
                        cellData = cell.getStringCellValue();
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        cellData = (int) cell.getNumericCellValue() + "";
                        break;
                    case Cell.CELL_TYPE_BLANK:
                        cellData = "";
                        break;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return cellData.trim();
    }

    /**
     * @param
     * @return
     * @description: This function takes a field name as an argument and initialize the respective config variable
     */
    @SuppressWarnings("deprecation")
    public void initializeGeneralConfigData(){
        String cellDataKey="";
        String cellDataValue="";
        try{
            Iterator rowIterator=generalConfigSheet.iterator();
            while (rowIterator.hasNext()){
                Row row= (Row) rowIterator.next();
                cellDataKey=getCellData(row.getCell(0));
                cellDataValue=getCellData(row.getCell(1));
                if(!globalVarsMap.containsKey(cellDataKey)){
                    globalVarsMap.put(cellDataKey, cellDataValue);
                }
            }
            initializeGeneralConfigVariables();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @param
     * @return
     * @description: This function initializes the general config variables
     */
    public void initializeGeneralConfigVariables(){
        try{
            globalVars.setPlatform(globalVarsMap.get(Constants.PLATFORM));
            globalVars.setApkFileName(globalVarsMap.get(Constants.APK_FILE_NAME));
            globalVars.setDeviceNameAndroid(globalVarsMap.get(Constants.DEVICE_NAME_ANDROID));
            globalVars.setPlatformVersionAndroid(globalVarsMap.get(Constants.PLATFORM_VERSION_ANDROID));
            globalVars.setAppiumServerIp(globalVarsMap.get(Constants.APPIUM_SERVER_IP));
            globalVars.setAppiumServerPort(globalVarsMap.get(Constants.APPIUM_SERVER_PORT));
            globalVars.setDeviceNameIOS(globalVarsMap.get(Constants.DEVICE_NAME_IOS));
            globalVars.setPlatformVersionIOS(globalVarsMap.get(Constants.PLATFORM_VERSION_IOS));
            globalVars.setIpaFileName(globalVarsMap.get(Constants.IPA_FILE_NAME));
            globalVars.setUdid(globalVarsMap.get(Constants.UDID));
            globalVars.setXcodeOrgId(globalVarsMap.get(Constants.XCODE_ORG_ID));
            globalVars.setXcodeSigningId(globalVarsMap.get(Constants.XCODE_SIGNING_ID));
            globalVars.setUpdateWDABundleId(globalVarsMap.get(Constants.UPDATE_WDA_BUNDLE_ID));
            globalVars.setConnectHardwareKeyboard(Boolean.parseBoolean(globalVarsMap.get(Constants.CONNECT_HARDWARE_KEYBOARD)));
            globalVars.setAutomationname(globalVarsMap.get(Constants.AUTOMATION_NAME));
            globalVars.setMailRecipientList(Arrays.asList(globalVarsMap.get(Constants.MAIL_RECIPIENT).split(",")));
            globalVars.setJiraFlag(Boolean.parseBoolean(globalVarsMap.get(Constants.JIRA_FLAG)));
            globalVars.setTestLinkFlag(Boolean.parseBoolean(globalVarsMap.get(Constants.TESTLINK_FLAG)));
            globalVars.setIsMailFlag(Boolean.parseBoolean(globalVarsMap.get(Constants.MAIL_FLAG)));

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * support method for getPageObjects
     * <br>Fetches all page elements in a page
     *
     * @param sheet takes the Sheet object returned from the workbook
     * @return return the map of page elements with element name and object of pageElement for the same.
     *
     */
    private Map<String, DataElements> getDataElements(org.apache.poi.ss.usermodel.Sheet sheet) {
        Map<String, DataElements> dataElementsMap = new HashMap<String, DataElements>();
        String testCaseName="";
        String runStatus="";
        String params="";
        for (int row = 1; row <= sheet.getLastRowNum(); row++) {
            Row dataRow = sheet.getRow(row);
            try{
                testCaseName=getCellData(dataRow.getCell(0));
                runStatus=getCellData(dataRow.getCell(1));
                params=getCellData(dataRow.getCell(2));
            }catch(Exception e){
                e.printStackTrace();
            }
            dataElementsMap.put(testCaseName, new DataElements(testCaseName, runStatus,	params));
        }
        return dataElementsMap;
    }

    /**
     * Fetches page locators from in-memory pageObjectRepo
     * Improved for performance considerations.
     *
     * @param testSuiteName name of the page where the element will be queried
     * @return org.openqa.selenium.By pageElement
     *
     */
    public Map<String, DataElements> getClassData(String testSuiteName) {
        Map<String, DataElements> classElementMap = new HashMap<>();
        for (Data data : dataObjectRepo) {
            if (data.getSuiteName().equalsIgnoreCase(testSuiteName)) {
                classElementMap = data.getElementList();
            }
        }
        return classElementMap;
    }
}
