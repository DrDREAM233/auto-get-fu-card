package com.dream.autogetfucard.controller;

import com.dream.autogetfucard.chromeHelper.ChromeHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * 收短信的Controller
 *
 * @author Dr.DREAM
 * @date 2021-02-02 14:46
 */
@Controller
public class MessageController {

    @ResponseBody
    @PostMapping("/msg")
    public String msg(String msg, HttpServletRequest request){
//        System.out.println(Pattern.compile("[^0-9]").matcher(msg).replaceAll("").trim().substring(0, 6));
        ChromeHelper.code = msg.substring(12, 18);
        ChromeHelper.lock.lock();
        try{
            ChromeHelper.condition.signalAll();
        }finally{
            ChromeHelper.lock.unlock();
        }
        return ChromeHelper.code;
    }
}
