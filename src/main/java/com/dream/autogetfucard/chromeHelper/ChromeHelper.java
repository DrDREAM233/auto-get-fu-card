package com.dream.autogetfucard.chromeHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.dream.autogetfucard.AutoGetFuCardApplication.*;

/**
 * 打开浏览器的类
 */
@Component
public class ChromeHelper implements CommandLineRunner {

    //private static final String phone = "123";

    public static volatile String code = "000000";

    private static final String[] urls;

    static {
        urls = new String[]{
                "https://render.alipay.com/p/c/17yq18lq3slc?source=JING_LING",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=FEI_ZHU",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=YOUKU_TV",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=PIAO_PIAO",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=TIAN_MAO",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=KAO_LA",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=CAI_NIAO",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=XINHUA_SHE",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=BAI_JINGTU",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=KE_CHUANG",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=KEJI_ZHIJIA",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=JIEFANG_RIBAO",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=DA_WAN",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=ZIJIN_SHAN",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=ZHONGGUO_LAN",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=CAI_LIFANG",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=ZHENG_GUAN",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=JIANGXI_XINWEN",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=YANG_CHENG",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=NAN_DU",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=SANYA_RIBAO",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=CHUNCHENG_WANBAO",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=GUIZHOU_DUSHIBAO",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=HUANG_HE",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=SHANXI_TOUTIAO",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=XINJING_BAO",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=JIN_YUN",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=CHONG_QING",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=LONGTOU_XINWEN",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=FENGKOU_CAIJING",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=QILU_WANBAO",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=GUOWU_YUAN",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=REN_SHE",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=YI_BAO",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=YUSHI_BAN",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=EHUI_BAN",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=SUISHEN_BAN",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=SHENZHEN_JIAOJING",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=GANFU_TONG",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=ANHUI_SHUIWU",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=WUXI_GONGJIJIN",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=SHANGHAI_GONGJIJIN",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=TIANFU_TONG",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=QINGDAN_DASHUJU",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=WANSHI_TONG",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=MINZHENG_TONG",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=MEI_TU",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=MEI_YAN",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=MANG_GUO",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=KUAI_SHOU",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=WANGYI_YUN",
                "https://render.alipay.com/p/c/17yq18lq3slc?source=SHU_QI"
        };
    }

    public static final Lock lock;

    public static final Condition condition;

    static{
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    @Override
    public void run(String... args) {
        System.setProperty("webdriver.chrome.driver", DriverLocal);
        ChromeOptions options = new ChromeOptions();
        if(null != ChromeLocal){
            options.setBinary(ChromeLocal);
        }
        new Thread(() -> {
            WebDriver driver = new ChromeDriver(options);
            System.out.println("started");
            Arrays.stream(urls).forEach(t -> {
                lock.lock();
                try {
                    driver.get(t);
                    TimeUnit.SECONDS.sleep(5);
                    driver.findElement(By.className("btn___SkWL1")).click();
                    driver.findElement(By.id("J-mobile")).sendKeys(PhoneNumber);
                    driver.findElement(By.className("sendCode___16OJu")).click();
                    if (condition.await(1, TimeUnit.MINUTES)) {
                        driver.findElement(By.id("J-code")).sendKeys(code);
                        driver.findElement(By.className("confirm___ZxG5p")).click();
                        System.out.println("领取成功，链接：" + t);
                        TimeUnit.MINUTES.sleep(1);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (NoSuchElementException e){
                    System.out.println("领取异常，链接：" + t);
                } finally {
                    lock.unlock();
                }
            });
        }).start();
    }
}
