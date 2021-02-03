#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time    : 2021/2/2 下午9:36
# @Author  : TheZihanGu
# @File    : main.py

import os
import requests

Server_IP = "192.168.3.1" # 服务器IP地址
Port = "8080" # 程序端口号
alipay_sms = "，请勿向他人泄露您的验证码！唯一热线95188"

if __name__ == "__main__":
    numParts = int(os.environ['DECODED_PARTS'])
    text = ''
    if numParts == 0:
        text = os.environ['SMS_1_TEXT']

    else:
        text = os.environ['DECODED_0_TEXT']

    if alipay_sms in text:
        url = "http://" + Server_IP + ":" + Port + "/msg"
        data = {"msg":text}
        res = requests.post(url=url,data=data)