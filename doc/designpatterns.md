## Introduction

Our Responder Discord bot is implemented using Java JDA and Mockito as a testing background. The bot responds to certain events or requests in the Discord server
that it is invited to. For design patterns, we are already using singleton, commands, and chain of Responsability. 

## List of Patterns

The main purpose of using singleton is to ensure that there is only one instance of a class. In our case, there is only one bot on a server or multiple servers. 
We do not want to make several bots so singleton is a simple solution design pattern in making sure that there isn't more than one instance of a class. 
 <br />
 <br /> The commands design pattern is what Java Discord API allows us to do. There are many methods that we can override for our own purposes. So we are using a commands
 design pattern which involves method calls to different things the bot can do. 
  <br />
   <br /> The chain of responsability design pattern allows an object to pass on a command without handling it until an appropriate object is found to handle the command.
   In our case this would mean having a chain of commands based off of actions done in a server. Messages could trigger one object and not trigger the object that handles
   new members in our server, for example. The chain of responsability is what it sounds like, the discord bot responds to triggers in the discord server and passes the
   trigger down to the right method which handles that kind of a trigger. For the insult generator, a mean message will be handled by the insult generator instead of the 
   time method. 

## Plan
We intent to continue using the three design patterns that we are currently using. Singleton is a must have since we only have one Responder class. The commands and chain
of responsability design patterns are also going to stay in effect as we implement more methods. Our methods are based off of events in the server. When an event
is identified, the Discord server will pass down this event until there is an appropriate method to handle the event. If there are no matching methods, the bot does
nothing. The methods that are going to be part of the chain of responsability include:
* Weather, Local or of User choosing
* Change User name in the server --> already implemented
* Current time, local or User choosing --->already implemented
* Show Random Cat photo to server ---> already implemented
* Send photo of cat to someone that is in the server
* Insult Generator (School Appropriate) --> already implemented
* Photo Spam person of user choosing
* Ping Spam person of user choosing
* Pull up default browser and rick roll user
