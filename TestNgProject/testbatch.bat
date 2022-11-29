set projectLocation=TestNgProject
cd %projectLocation%
set classpath=\bin;\lib*;
java org.testng.TestNG testngBat.xml
