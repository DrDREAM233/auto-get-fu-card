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

```
填写路径时一定要这样写
C:\\Program Files\\Chrome\\Application\\chrome.exe
而不是
C:\Program Files\Chrome\Application\chrome.exe
```

#### A.使用配置文件

0. 前提

安装JRE8并保证全局变量没问题.https://www.java.com/en/download/manual.jsp

达到在cmd里输java可以返回正常信息的标准.

1. 配置`config.properties`

| Key  | 备注  |
| :------------: | :------------: |
| PhoneNumber | 电话号码  |
| DriverLocal | chromedriver.exe 路径 [镜像站](http://npm.taobao.org/mirrors/chromedriver/)(根据Chrome版本下载) |
| ChromeLocal | chrome.exe 路径(可选参数)  |

2. 启动程序

```java
java -jar auto-get-fu-card.jar
```

注意`config.properties`和`auto-get-fu-card.jar`必须在一个文件夹下.

#### B.不用配置文件,用参数

| 参数  | 备注  |
| :------------: | :------------: |
| -p or -phone  | 电话号码  |
| -d or -driver | chromedriver.exe 路径 [镜像站](http://npm.taobao.org/mirrors/chromedriver/)(根据Chrome版本下载) |
| -c or -chrome | chrome.exe 路径(可选参数)  |

示例:

```java
java -jar auto-get-fu-card.jar -p 12345678900 -d D:\\chromedriver.exe -c C:\\Program Files\\Chrome\\Application\\chrome.exe
```

#### 对于 macOS 和 Linux

请注意下载适合设备系统的 chromedriver.
<br>macOS 不能与 Linux 通用。   
<br>请在运行前先赋予 chromedriver 权限，并尝试在 Terminal 运行一次。   
```
sudo chmod u+x ./chromedriver
sudo ./chromedriver
```
#### 对于 macOS 用户

在首次运行前，可能会弹出安全性警告阻止 chromedriver 运行。   
<br>因此，请在首次运行时在 Finder 点选 chromedriver, 按住 Control 然后双击, 在弹出的安全性警告窗口点选「打开」即可。   
<br>在之后的使用中，就可以直接通过 Terminal 或 Java 直接调用。


### Step2:手机端(能收短信的都行)配置

#### 目前实现平台

- [x] iOS
- [ ] Android
- [x] 树莓派等 Linux 设备
- [x] 手

#### iOS 10 以上版本

1.在`App Store`里安装 `快捷指令`(就是苹果官方开发的那个)

2.看图操作

<img src="https://i.loli.net/2021/02/03/Kktg6F1lDxzULuE.png" alt="drawing" width="300"/>
<img src="https://i.loli.net/2021/02/03/vDAaS6d12sBZLkm.png" alt="drawing" width="300"/>
<img src="https://i.loli.net/2021/02/03/7an5sMoEYhkK61H.png" alt="drawing" width="300"/>

3.因为苹果的限制所以必须收到短信的时候点击运行按钮,拉下菜单就看见了


#### 树莓派等 Linux 设备: Gammu
如果你身边有 3G/4G 模块，也可以尝试在树莓派等设备上搭建 Gammu 来实现手机上的效果。   
本程序已经在 Raspberry Pi 3B + Ubuntu + EC20 模块下测试通过。

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

#### 手

运行之后收到验证码自己往里输行了
