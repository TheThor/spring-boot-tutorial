### Spring Boot intro

## Notes
Don't commit application.properties file with passwords/usernames and other related data that could be a security concern. I've got an example on how to use env variables with docker (only for the postgresql databas container env and you don't push .env to the repository) that will be attached to the commit that caries this same message.

## What is this?
This is a project that recruiters and tech recruiters can take a look. :)

I resorted to some external references to do this. These are the links:
- https://www.youtube.com/watch?v=9SGDpanrc8U
- https://spring.io/guides/gs/spring-boot/
- docker documentation
- postgresql documentation (for docker image and options)

## What this is not
An example of how to separate layers and concerns. Although I did it initially, I only did some separation to show concepts like Separation of Concerns,  DI and some patterns like Services and Repositories.

## What will happen with this?
I'll probably create some other fork for a more concrete example of the typical DDD layering, with more tests and so on.