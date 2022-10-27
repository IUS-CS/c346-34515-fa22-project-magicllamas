#Testing

##Unit Testing

Unit tests are done using JUnit. Methods being tested are structured in a test file that can be executed separately from the bot program.

###Mocking

Mocking is done using Mockito. In order to verify our methods without outside interference, we are using mock objects. This way we aren't reliant on the Discord server to send or receive events.