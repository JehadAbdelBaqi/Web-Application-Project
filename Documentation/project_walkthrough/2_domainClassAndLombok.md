## Creating Runner/Main file and Domain Class using Lombok

Upon the creation of the Springboot project - a runner class with the project name is automatically created with the @SpringBootApplication annotation present. This annotation is used to mark a configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning. The project alsop created a pom.xml file with relevant dependancies mentioned in the start-up section and other test folders for rescources and testing. The main method within the class also has a SpringApplication.run method. 

SpringApplication.run(Classname.class, args) bootstraps a spring application as a stand-alone application from the main method. It creates an appropriate ApplicationContext instance and load beans. 
>![](../documentation_images/2_domain_class_and_lombok/domain_class_1.png) 

CHAAANGE PICTURE
>![](../documentation_images/2_domain_class_and_lombok/domain_class_2.png) 

I then create a config class and just run a couple of tests in there. The @Bean annotation means the method can be found in main by finding the object byName, by type or by both. The hello() method is created in config with this bean and then found by it's name in the main class by using the context.getBean() method and entering the string name of the method to call. In the console the propgram is run and you can see the method functioning within.
>![](../documentation_images/2_domain_class_and_lombok/domain_class_3.png) 

I also connect to the local h2 test environment online while the program is running. 
>![](../documentation_images/2_domain_class_and_lombok/domain_class_4.png) 

I then create a domain package and a domain class. Inside of the domain class I annotate the top of the class with @Entity - this annotation tells the application that this is a table creation. Below when creating the first column we specify that it is an id column with the @Id and we use @GenerateValue(strategy = GenerationType.Identity) to tell it this is an auto incrementing id column.
>![](../documentation_images/2_domain_class_and_lombok/domain_class_5.png) 

We the use the @Column annotation to specify the other columns. We can also specify some SQL within the column such as below where we've used (nullable = false) which is the equivalent to NOT_NULL in MySQL.
>![](../documentation_images/2_domain_class_and_lombok/domain_class_6.png) 

Generate some constructors.
>![](../documentation_images/2_domain_class_and_lombok/domain_class_7.png) 

Getters and setters.
>![](../documentation_images/2_domain_class_and_lombok/domain_class_8.png) 

And Hashcode and equals. (These can all be done by right clicking and clicking source)
>![](../documentation_images/2_domain_class_and_lombok/domain_class_9.png) 

Lombok is a Java library which aims to reduce boilerplate code by automatically generating common class components such as: constructors, getters and setters, toString(), equals() and hashCode() methods. Lombok need to be downloaded (see main readme file) and then the dependancies below must be added to the pom file (lines 54 to 57):
>![](../documentation_images/2_domain_class_and_lombok/domain_class_10.png) 

@NoArgsConstructor generatos a constructor with no arguments.  
@AllArgsConstructor does the opposite and generates one with all arguments.  
@Getter and @Setter generates getters and setters.  
And @EqualsAndHashCode generates the equals and hashcode.  
NOTE - if you want to generate specific constructors then you would have to do them manually. As seen in lines 36-41.
>![](../documentation_images/2_domain_class_and_lombok/domain_class_11.png) 
