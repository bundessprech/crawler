create table PERSON (
   dateOfBirth 	DATE default NULL,
   electoralDistrictName 
   				VARCHAR(20) default NULL,
   faction 		VARCHAR(20) default NULL,
   homepageUrl 	VARCHAR(40) default NULL,
   id 			INT NOT NULL,
   party 		VARCHAR(20) default NULL,
   prename  	VARCHAR(20) default NULL,
   profession  	VARCHAR(20) default NULL,
   gender  		VARCHAR(10) default NULL,
   state  		VARCHAR(20) default NULL,
   surname  	VARCHAR(20) default NULL,
   title  		VARCHAR(20) default NULL,
   titleOfNobility  VARCHAR(20) default NULL,
   university  	VARCHAR(20) default NULL,
   PRIMARY KEY (id)
);