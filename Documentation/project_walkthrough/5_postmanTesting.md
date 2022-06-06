## Checking working files on Postman and MySQL 

I created a series of API calls usiong Postman to check if my methods were working prior to testing.

Started with a create call.
>![](../documentation_images/5_testing_on_postman/postman_1.png)  
As mentioned previously - the getById method had an exception thrown from a class - in that exception I never removed the reason from the @REponseStatus annotation. Therefore the below message was showing up.
>![](../documentation_images/5_testing_on_postman/postman_2.png)  

Finally, you select the dependancies - usually when you have a new project and havent had any previous then the selected dependancies aren't there - you simply search for them and include the ones you want.
>![](../documentation_images/5_testing_on_postman/postman_3.png) 
>![](../documentation_images/5_testing_on_postman/postman_4.png)  
>![](../documentation_images/5_testing_on_postman/postman_5.png)  
>![](../documentation_images/5_testing_on_postman/postman_6.png)  
>![](../documentation_images/5_testing_on_postman/postman_7.png)  
>![](../documentation_images/5_testing_on_postman/postman_8.png)  
>![](../documentation_images/5_testing_on_postman/postman_9.png)  
>![](../documentation_images/5_testing_on_postman/postman_10.png)  

