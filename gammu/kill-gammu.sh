#!/bin/bash

ps aux | grep gammu-smsd | grep -v 'grep' | awk '{print $2}' | xargs kill -9