# auto-get-fu-card
# 自动领取支付宝福卡

## 介绍

可完成基本自动化领取支付宝福卡

每天52张 亲测可用

因为支付宝的限制所以领完所有的福卡大约需要 1 小时

## 操作步骤

### Step1:PC端配置

1. 将`src/main/resources/static/dirver/chromedriver.exe`复制到D盘根目录`C:/`.<br>注意浏览器的版本，详见 http://npm.taobao.org/mirrors/chromedriver/

2. 将 `src/main/java/com/dream/autogetfucard/chromeHelper/ChromeHelper.java` 的 `phone` 属性填上自己的手机号
    ```java
    private static final String phone = "00000000000";
    ```

### Step2:手机端(能收短信的都行)配置

#### 目前实现平台

- [x] iOS
- [ ] Android

#### iOS 10 以上版本

1. 在`App Store`里安装`快捷指令`

2. 看图操作

![1](https://github.com/DrDREAM233/auto-get-fu-card/raw/main/FAQ/img/iOS1.PNG)
![2](https://github.com/DrDREAM233/auto-get-fu-card/raw/main/FAQ/img/iOS2.PNG)
![3](https://github.com/DrDREAM233/auto-get-fu-card/raw/main/FAQ/img/iOS3.PNG)

3. 因为苹果的限制所以必须收到短信的时候点击运行按钮,拉下菜单就看见了


