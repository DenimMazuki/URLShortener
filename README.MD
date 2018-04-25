<h1>URL Shortener</h1>

<h2>A Java Service built with Spring Boot, and Redis.</h1>

<h3>common</h3>
<b>IDConverter.java</b> <br />
A Singleton class responsible for: <br />
1. Generating ID <br />
2. Using ID to create unique URL ID <br />
3. Using unique URL ID to retrieve original ID <br />
<br /> <br />
<b> URLValidator.java</b> <br />
A Singleton class responsible for validating URL's validity

<h3>controller</h3>
<b>URLController.java</b> <br />
A Spring Boot Controller responsible for: <br/>
1. Serving an endpoint to shorten URL <br />
2. Redirect shortened URL to the original URL <br />

<h2>repository</h3>
<b>URLRepository</b> <br />
A Java class responsible for abstracting Redis(database) read/write logic

<h2>service</h3>
<b>URLConverterService.java</b> <br />
A Java class used to abstract URL Shortening and URL Retrieval process
<br />
<b>URLShortenerApplication.java</b> <br />
The entry point for the Spring application
<br /> <br />
<h2>To run:</h2>
1. Start up redis-server by executing `redis-server` in the terminal <br/>
2. Run `gradle build` and `gradle run` in the terminal
