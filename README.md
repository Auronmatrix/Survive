`P`ost `A`pocalyptic 2165 - `S`ystems `U`tility for `R`ecording and `V`irtual `I`ndexing of `V`iolent `E`nemies

Code name: `PA165-SURVIVE`

![Image used for personal inspiration. Image remains property of 4A Games Metro: Last Light](http://www.doublejump.co/wp-content/uploads/2013/04/metrolastlight-header03-600x300.jpg)


Project Description, Diagrams and information view: 
https://github.com/Auronspan/Survive/wiki/home

Team members: 
Aubrey Oosthuizen,
Irina Serdyukova,
Maria Dolgikh


# To run:

NOTE: Please ensure that all prerequisites from the TODO.md file has been met before attempting to run the application

1. Open terminal/cmd 

2. Go to project root Survive\Survive-POM  

3. mvn clean install 


To run the web application on context /pa165 and the rest-server 

1. cd Survive\Survive-POM\Surive-Web  

2. mvn tomcat7:run 



To run the rest-client application

NOTE: Please ensure that the rest-server is running through completing above steps

1. cd Survive\Survive-POM\Survive-REST-Client
2. mvn exec:java
