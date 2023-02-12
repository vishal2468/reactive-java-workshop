## Agenda
* The "default" blocking programming model and its limitations
* Understanding Reactive programming
* Build scalable reactive code using Project Reactor
* Learn operators and transform reactive streams
* Learn patterns, common best practices and pitfalls with reactive programming
* Reactive programming + Spring Boot application development architecture

## What is reactive programming?
* Reactive programming is a declarative programming paradigm concerned with data streams and the propagation of change.
* With this paradigm, it's possible to express static (e.g., arrays) or dynamic (e.g., event emitters) data streams with ease, and also communicate that an inferred dependency within the associated execution model exists, which facilitates the automatic propagation of the changed data flow.

# A case for Reactive programming in Java

## Modern application development
* High data scale
* High usage scale
* Cloud based costs

## How do you scale up?
* Vertical scaling
* Horizontal scaling

## What's the problem here?
```java
User user = userService.getUser (userId);
UserPreferences prefs = userPreferencesService.getPreferences(userId);
```
* Unnecessarily sequential

## Cost
* Performance

## problem 
* Idling threads

## The problem

## We code like...
* It's a single request
* Multiple simultaneous users abstracted out
* Delays abstracted out
* We pay with sequential blocking operations
* We pay with idling threads

## But wait!
* There are concurrency APIs

## Future and CompletableFuture
```java
CompletableFuture<User> userAsync = CompletableFuture.supplyAsync(() -> userService.getUser (userId));
CompletableFuture<UserPreferences> userPreferencesAsync = CompletableFuture.supplyAsync(() -> userPreferencesService);
CompletableFuture<Void> bothFutures = CompletableFuture.allOf(userAsync,userPreferencesAsyn);
bothFutures.join();
User user = userAsync.join();
UserPreferences prefs = userPreferencesAsync.join();
```

## The problem with future and CompletableFuture
* Too much for the dev to do
* Error handling is messy
* It's still sync after all
* We need a new paradigm
* The framework needs to support it

# Reactive Programming

## teaser 
```java
@GetMapping(" /users/{userId}")
public Mono<User> getUserDetails(@PathVariable String userId) {
    return userService.getUser(userId).zipWith(userPreferencesService.getPreferences(userId))
    .map (tuple -> {
        User user = tuple.getT1();
        user.setUserPreferences(tuple.getT2());
        return user;
    });
}
```

## What's different
* Much simpler than the manual concurrent way
* Few reusable flexible functions
* Combine and reuse in powerful ways

## Reactive programming
* Different way of thinking about flow
* Different way of thinking about data
* Integrated with Java! 'Flow' interface
* coding style is similar to streams.

## Java streams
* Represent a sequence of data
* Focus on computations
* vs collections which focus on storage
* Internal iteration

## Two patterns
* Iterator pattern
* Observer pattern

## tbc from vid 13
## i think i should do a course on Java Concurrency before continuing this course.
