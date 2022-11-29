set projectLocation=TestNgProject
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*;
java org.testng.TestNG testngBat.xml
pause