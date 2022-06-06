## Checking working files on Postman and MySQL 

I created a series of API calls using Postman to check if my methods were working prior to testing.

Started with a create call.
>![](../documentation_images/5_testing_on_postman/postman_1.png)  
As mentioned previously - the getById method had an exception thrown from a class - in that exception I never removed the reason from the @ResponseStatus annotation. Therefore the below message was showing up when I was trying to retrieve an entry by an id which doesn't exist. 
>![](../documentation_images/5_testing_on_postman/postman_2.png)  

I went back into the class and removed the "reason" from the @ResponseStatus annotation body. 
>![](../documentation_images/5_testing_on_postman/postman_3.png) 

Now it is giving my the message I wrote that class for. Specifying which id I've searched for that doesn't exist.
>![](../documentation_images/5_testing_on_postman/postman_4.png)  

I then created an entry with id 2 to check the method works.
>![](../documentation_images/5_testing_on_postman/postman_5.png)  

Tested the getAll() method.
>![](../documentation_images/5_testing_on_postman/postman_6.png)  

Updated entry 1.
>![](../documentation_images/5_testing_on_postman/postman_7.png)  

Deleted an entry and then checked if it exists.
>![](../documentation_images/5_testing_on_postman/postman_8.png)  
>![](../documentation_images/5_testing_on_postman/postman_9.png)

I then checked to see if my entries were on MySQL to ensure my application as communicating with the database. It was! 
>![](../documentation_images/5_testing_on_postman/postman_10.png)  
