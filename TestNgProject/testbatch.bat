set projectLocation=C:\Users\WinPro\gitlocalrepoFrames\TestNgProject
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*;
java org.testng.TestNG testngBat.xml
