package com.dream.autogetfucard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;

@SpringBootApplication

public class AutoGetFuCardApplication {
    public static String ChromeLocal;
    public static String DriverLocal;
    public static String PhoneNumber;
    public static boolean IsConfig;


    public static void main(String[] args) {
        IsConfig=false;
        Properties prop = new Properties();
        try{
            //读取属性文件config.properties
            InputStream in = new BufferedInputStream (new FileInputStream("config.properties"));
            prop.load(in);     ///加载属性列表
            Iterator<String> it=prop.stringPropertyNames().iterator();
            while(it.hasNext()){
                String key=it.next();
                System.out.println(key+":"+prop.getProperty(key));
                if("PhoneNumber".equals(key)){
                    PhoneNumber=prop.getProperty(key);

                }
                else if(("DriverLocal".equals(key))){
                    DriverLocal=prop.getProperty(key);
                }else{
                    ChromeLocal=prop.getProperty(key);
                    IsConfig=true;//所有参数都包含才能使用配置文件,否则不能用.
                }
            in.close();
            }
        } catch(Exception e){
            IsConfig=false;
            System.out.println("配置文件加载失败");
        }


        if(args != null && args.length > 0) {
            for(int index = 0; index < args.length; index = index + 2) {
                if(index + 1 < args.length) {
                    if(args[index].equalsIgnoreCase("-c") || args[index].equalsIgnoreCase("-chrome")) {
                        ChromeLocal = args[index + 1];
                    }else if(IsConfig){
                        ChromeLocal="";
                    }else{
                        //ChromeLocal="C:\\Program Files\\Chrome\\Application\\chrome.exe";
                        System.out.println("错误:没Chrome你让我怎么运行.");
                        System.exit(0);
                    }

                    if(args[index].equalsIgnoreCase("-d") || args[index].equalsIgnoreCase("-driver")) {
                        DriverLocal = args[index + 1];
                    }else if(IsConfig){
                        ChromeLocal="";
                    } else{
                        //ChromeLocal="D:\\chromedriver.exe";
                        System.out.println("错误:没ChromeDriver你让我怎么运行.");
                        System.exit(0);
                    }

                    if(args[index].equalsIgnoreCase("-p") || args[index].equalsIgnoreCase("-phone")) {
                        PhoneNumber = args[index + 1];
                    }else if(IsConfig){
                        PhoneNumber="";
                    } else{
                        //PhoneNumber="12345678900";
                        System.out.println("错误:没电话号码你让我怎么运行.");
                        System.exit(0);
                    }
                }
            }
        }

        SpringApplication.run(AutoGetFuCardApplication.class, args);
    }

}
