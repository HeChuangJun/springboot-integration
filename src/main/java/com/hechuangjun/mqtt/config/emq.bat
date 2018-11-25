@echo off¡¡
start C:\emqttd\bin\emqttd start
start C:\emqttd\bin\emqttd start
PING -n 60 127.0.0.1
taskkill /f /im cmd.exe
