package utils;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
//import jdk.internal.org.objectweb.asm.TypeReference;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.*;
import java.net.ServerSocket;

public class AppiumServer
{

    private static AppiumDriverLocalService service=null;
    private static AppiumServiceBuilder builder;
    private static DesiredCapabilities cap;
    private static GlobalVars globalVars;
    /*public static void startServer() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
            Thread.sleep(10000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    public static void startServer() {
        globalVars=GlobalVars.getInstance();
        int appiumServerPort=Integer.parseInt(globalVars.getAppiumServerPort());
        //Set Capabilities
        if(!checkIfServerIsRunnning(appiumServerPort)){
            cap = new DesiredCapabilities();
            cap.setCapability("noReset", "false");

            //Build the Appium service
            builder = new AppiumServiceBuilder();
            builder.withIPAddress(globalVars.getAppiumServerIp());
            builder.usingPort(appiumServerPort);
            builder.withCapabilities(cap);
            builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
            builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

            //Start the server with the builder
            try{
                AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
                service.start();
            }
            catch (Exception e){
               e.printStackTrace();
            }

        }

    }

    /*public static void stopServer() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("taskkill /F /IM node.exe");
            runtime.exec("taskkill /F /IM cmd.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public static void stopServer() {
        service.stop();
    }

    public static boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

   /* public static void main(String[] args)
    {
        try {
            AppiumServer appiumServer = new AppiumServer();
            appiumServer.startServer();
            System.out.println("Appium Server Started");
            Thread.sleep(500);

            appiumServer.stopServer();
            System.out.println("Appium Server Stopped");
            Thread.sleep(200);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }

        //appiumServer.stopServer();
    }
*/
}
