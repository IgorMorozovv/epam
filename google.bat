cd %cd%
java -jar  selenium-server-standalone-3.11.0.jar -role node -hub http://10.19.10.150:4444/grid/register/ -browser browserName=chrome -port 5557
pause
