# download-upload SpringBootApplication
 [Java]RestServiceApplication practice using JAVA

1- You need to create a springboot application to do this test.  
2- This webservice has 2 routes  
a. GET “/animal”  
b. POST “/animal”  
3- GET “/animal”:  
a. Use https://dog.ceo/api/breeds/image/random To fetch the image URL of a random dog.  
b. Show the information as a text output. For example:  
{  
"message": "https://images.dog.ceo/breeds/terrier-welsh/lucy.jpg",  
"status": "success"  
}  
c. You only need one controller  
d. You need to provide the same structure as we did in the class (Model, Service, Controller, Adapter)  
4- POST “/animal”:  
a. Use an animal image file to do your tests  
b. This route will upload your file via REST  
c. You need to create a folder in this path to put your uploaded files -> “src/main/resource/upload”  
d. You need some investigations for answering upload question.  
e. you need to test your code via postman to see if it is working.  
Optional (bonus) For the GET “/animal” route, you can create a download folder and save the dog’s images into that folder.  
