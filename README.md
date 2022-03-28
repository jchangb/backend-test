# Spring-boot Backend Development Test

### Purpose
This API will return a detailed list of similar products for a given ID.

### Usage
API is set to launch in port 5000 by default. This can be configured in the project's _application.properties_ file.

It exposes a single endpoint, as requested:

```
localhost:5000/product/{id}/similar
```

### Configuration
The project's _application.properties_ hosts the following configuration:
```yaml
#application configuration
Application:
  server.port: the port the application will launch in

# api used to consume similarid and product detail data
Product API: 

product-api:
  url: api uri
  endpoint_product: endpoint used to retrieve product detail
  endpoint_productSimilarIds: endpoint used to retrieve similar product ids
  request_timeout_in_seconds: product api timeout value
```

### Dev notes
- The repository was setup late in development, so its history does not reflect development very well
- At the start, I had a slightly more complex exception handling setup. However, seeing how the API functionally benefits the most by displaying whatever products it found instead of an error, I decided against the previous setup
- ApiResponse model used to contain more information about the Api Call. This designed seemed incompatible  with spring-boot's webClient approach, which is why the ApiResponse seems off by having a single property: its body

### In retrospective
While the application does provide a working solution for the requested use-case, I wish it provided a better result overall. I realize there is plenty of room for improvement.
Nevertheless it worked very well as a learning and discovery exercise.
