## Controller Unit Testing

@WebMvcTest is the only annotation we need since this is a unit test - we’re still going to send the same request but this time the service will be mocked as we create a mock bean of the user service to stop the controller from talking to the service - that’s why we add the mock bean on service.
>![](../documentation_images/8_controller_unit_testing/service_unit_testing_1.png) 

The create test is the same as the integration test in some ways - but this time we remove the expected out and we mock the service method - we then perform our HTTP request as normal
>![](../documentation_images/8_controller_unit_testing/service_unit_testing_2.png)  

Same with get by ID and get all.
>![](../documentation_images/8_controller_unit_testing/service_unit_testing_3.png)  

update and delete - same just mocked 
>![](../documentation_images/8_controller_unit_testing/service_unit_testing_4.png) 
