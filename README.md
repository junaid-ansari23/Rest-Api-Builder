# Rest-Api-Builder
This application is the initial POC that I did for automating the REST API creation with zero deployment or code change. Once the API is registered, it’s immediately available to use .This framework assumes that API should be READ in nature and your data has to be sourced from a single table or view. I have tested this framework for HANA, Snowflake and Oracle.

Typically, to create a REST API we might need to do following tasks (for a Java based application):
1.	Creating a REST Handler
2.	Write Service logic
3.	Write database logic to connect to database, fire some query and read the result set
4.	Data formatting to send as the final response to API consumer

Consider if you already have some table/view ready that your API need to fetch the data from during the invocation. With this framework, I automated the steps #1,#2,#3 and #4. This is the configuration driven API generation tool. API should be registered first with the POST call of /api/register call. As an API registration process, you provide the details like, end point, database credentials ,JDBC url etc .Please check the sample JSON input for API registration under resources/api-registration.json .This configuration is stored as Mongo collection. You should have your Mongo UP and running .I have used local mongo instance. Once registration is successful, API endpoint is immediately available to consume. No deployment and code changes required

Working of framework:
There are mainly three components of this framework:
1.	Rest controller with request mapper as wildcard /*** to handle all API invocation. That accepts a generic input payload .Please check sample input under resource/service-input.json
2.	Query builder: This components create the final select query using the input request and stored mongo configuration. You can have different query builder for different Database
3.	DAO class: This basically fires select query built by query builder and convert the result set into a generic table-row-columns kind of structure .

Steps for creating the API endpoint
1.API registration :
Rest Controller: ApiRegistrationController.java
http://localhost:8080/builder/api/regsiter

Use the sample registration JSON in resources/api-registration.json

2. Calling the API endpoint created on step #1 above
Rest controller: ApiController.java
Calling API:
http://localhost:8080/builder/{your-new -endpoint}
Use the sample input payload resource/service-input.json. (If you notice this is a structure like a select query with where clause, order by and pagination). Scalability and performance should be analyzed since all the API created using this framework share the common infra. We have built a full fledge framework using this concept and overcome the scalability concern by running it on Cloud (Openshift) with microservice based design. Please reach out to me at junaid.ans@gmail.com for any query.

