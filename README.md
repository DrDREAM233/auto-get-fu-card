# auto-get-fu-card
# 自动领取支付宝福卡

## 介绍

可完成基本自动化领取支付宝福卡

每天52张 亲测可用

因为支付宝的限制所以领完所有的福卡大约需要 1 小时

## 免责声明

本项目所涉及的任何代码和技术都合法合规,没有利用任何后门或漏洞,其过程完全只是代替人类输入,造成某软件对任何人的封禁一概不负责任.
本项目所实现的功能,人类也可以完全手动实现.

## 操作步骤

### Step1:PC端配置

1. 将`src/main/resources/static/dirver/chromedriver.exe`复制到D盘根目录.<br>注意浏览器的版本，从 [镜像站](http://npm.taobao.org/mirrors/chromedriver/) 下载。

2. 将 `src/main/java/com/dream/autogetfucard/chromeHelper/ChromeHelper.java` 的 `phone` 属性填上自己的手机号
    ```java
    private static final String phone = "00000000000";
    ```

### Step2:手机端(能收短信的都行)配置

#### 目前实现平台

- [x] iOS
- [ ] Android
- [x] 树莓派等 Linux 设备
- [x] 手

#### iOS 10 以上版本

1. 在`App Store`里安装 `快捷指令`(就是苹果官方开发的那个)

2. 看图操作

![1](https://github.com/DrDREAM233/auto-get-fu-card/blob/main/FAQ/iOS1.PNG?raw=true)
![2](https://github.com/DrDREAM233/auto-get-fu-card/blob/main/FAQ/iOS2.PNG?raw=true)
![3](https://github.com/DrDREAM233/auto-get-fu-card/blob/main/FAQ/iOS3.PNG?raw=true)

3. 因为苹果的限制所以必须收到短信的时候点击运行按钮,拉下菜单就看见了


### 树莓派等 Linux 设备: Gammu
如果你身边有 3G/4G 模块，也可以尝试在树莓派等设备上搭建 Gammu 来实现手机上的效果。   

#### 安装&配置 
1.安装和配置 Gammu.   
```
sudo apt-get update && sudo apt-get install gammu
sudo gammu-config
```
配置 Port 为模块的 USB 接口，然后保存设置。   

2.安装和配置 Gammu-SMSD.   
```
sudo apt-get install gammu-smsd
sudo nano /etc/gammu-smsdrc
```   
然后将 ```gammu/gammu-smsdrc``` 中的内容复制保存。   
3.启动并测试   
在启动前，请将 ```gammu/smsPush/main.py``` 中的相关设置修改为真实数据，例如 IP 和端口号。   
```
sudo gammu-smsd --config /etc/gammu-smsdrc --pid /var/run/gammu-smsd.pid --daemon
```   
理论上就可以尝试接收来自支付宝的验证码，领取福卡了。

### 手

运行之后收到验证码自己往里输行了
