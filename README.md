# SpringDataJpaMysqlCrud
A sample Mysql Jpa crud rest application

1.http://localhost:8080/Book/get    GET
Returns all the books


2.http://localhost:8080/Book/create POST
{
	"name":"How to do nothing"
}


3.http://localhost:8080/Book/update PUT
{
	"id":7,
	"name":"How to do nothing But still nothing"
}


4.http://localhost:8080/Book/1  DELETE


5.http://localhost:8080/Book/1  GET Single ITEM	


6.Mysql Database -->temp
  Table Script
  ==============
  
  CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
  )


7.To be Deployed in Apache Tomcat Server Version should be above 9 War file Link Given
======================================================================================
https://drive.google.com/open?id=1fGEjRnrEOhi4TDLuD8N23cK0Vvu1B-F_
