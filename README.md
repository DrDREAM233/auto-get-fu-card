# auto-get-fu-card
自动领取支付宝福卡

将/static/driver文件夹下的chromeDriver.exe复制到D盘根目录
注意浏览器的版本，详见 http://npm.taobao.org/mirrors/chromedriver/
在 ChromeHelper 的 phone 属性填上自己的手机号

配合ios的快捷指令（详见/static/img）
    ”当收到包含‘，请勿向他人泄露您的验证码！唯一热线95188’的短信时向服务器发送post请求“
即可完成基本自动化领取支付宝福卡

每天52张 亲测可用
因为苹果的限制所以必须收到短信的时候点击运行按钮
因为支付宝的限制所以领完所有的福卡大约需要 1 小时
