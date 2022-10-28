# Testing

The Discord API is tested by Discord. Discord tests its code base regularly and reliably enough that we do not feel the need to test the API itself. What we are working on is testing the code that Responder uses uniquely. In Intelijj, tests are executable and done on an IDE platform as units based on the bot function tested. One bot function ideally has several tests. Integration testing is done in the experimental Discord server where AUTHORS give the bot different kinds of input to see how it reacts. Additionally, we will use unit tests with mock objects to verify our use of JDA API methods.

## Unit Testing

Unit tests are done using JUnit. Methods being tested are structured in a test file that can be executed separately from the bot program. You can find these unit tests in src and in the Test directory. In there test types are separated by bot functions.

### Mocking

Mocking is done using Mockito. In order to verify our methods work, we are using mock objects. By using mock objects we aren't reliant on the Discord server to send or receive events. Since our application is based on a third party API Java Discord API, it is imperative that we use mocking. We need mocking for objects that we have not created but our given by the API. A familiar object that one might perceive in our test cases is the "event" object. Responder does not own this object but is mocked in our test cases in order to contain the same attributes that "event" really has such as event.getAuthor() for example. This gives us the author who made an event in an ideal discord server.

## What has been done so far:

Most testing efforts have been geared towards the insultGenerator bot function. Some unit tests that have been conducted for this functionality include:

a test for the bot to ingnore other bot messages
a test for the bot to acknowledge user messages
several tests for the bot to respond appropriately based on user input: these tests start with "on..." such as "onExclamation".
