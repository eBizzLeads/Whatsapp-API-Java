Wapify API Java Implementation
A simple Java-based client to interact with the Wapify API, providing functionalities to send text messages, media messages, and create groups on WhatsApp.

Features
Send a text message to a given number.
Send a media message with a caption to a given number.
Create a WhatsApp group with a name and members.
Prerequisites
JDK 8 or later
Maven (for dependency management)
Dependencies
This project utilizes the OkHttp library to make HTTP requests. Add the following dependency to your Maven pom.xml:
<dependency>
    <groupId>com.squareup.okhttp3</groupId>
    <artifactId>okhttp</artifactId>
    <version>4.9.1</version>
</dependency>
