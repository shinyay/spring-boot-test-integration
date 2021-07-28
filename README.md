# Spring Boot Integration Tests

The `@SpringBootTest` annotation automagically spins up your application with all dependencies for use in tests.
Therefore, this testing is suitable for the Integration tests.

## Description
### Integration Tests vs. Unit Tests
- **Unit Tests** : Unit tests cover a single "unit", where a unit commonly is a single class
- **Integration Tests** :
  - Integration tests cover multiple "units" which test the interaction between two or more clusters of cohesive classes
  - Integration tests cover multiple "layers" which test between the multiple units on multiple layers.
  - Integration tests cover the whole path through the application. `request -> database state -> response`

### Pros and Cons for `@SpringBootTest`
`@SpringBootTest` bootstraps the whole application.
`@SpringBootTest` creates an application context containing all the objects we need for all the test types.

#### Good Fit
End-to-end tests would be the best, assuming the whole application is a black box.

#### When to Avoid `@SpringBootTest`
1. Integration tests with @SpringBootTest can take a very long time to start,
which is mostly **related to database initialization**, **the configuration of remote sources**, and **other IO (input/output)**.
2. If you intend to test the HTTP layer, all other components are created, even not in use.
3. External test data becomes a hard dependency, and it must be either provisioned before the application starts or shared.

As an Integration Test with `@SpringBootTest`
![springboottest](https://user-images.githubusercontent.com/3072734/126014256-612a0f2a-fd4f-48a5-9c2f-cbf6c14b49fc.png)

As a Slice Test with `@WebMvcTest`
![webmvctest](https://user-images.githubusercontent.com/3072734/126014356-6ed1b6b5-21f1-40ce-b465-48ece1789d29.png)

### Creating an ApplicationContext with @SpringBootTest
`@SpringBootTest` by default searches in the current package of the test class
And it searches upwards through the package structure, looking for a class annotated with `@SpringBootConfiguration`, which `@SpringBootApplication` includes, from which it then reads the configuration to create an application context.

### AssertJ / Hamcrest

|Assertions|AssertJ|Hamcrest|
|----------|-------|--------|
|Specify the target|assertThat(target.xxx())|assertThat(target).xxx()|
|True|is|isTrue|
|False|is|isFalse|
|Same Value|is|isEqualTo|
|Not Same Value|is(not())|isNotEqualTo|
|Start Character|startsWith|startsWith|
|End Character|endsWith|endsWith|
|String Existence|is(containsString())|contains<br>containsOnly<br>containsExactly<br>containsExactlyInAnyOrder<br>containsSequence<br>containsSubsequence<br>containsOnlyOnce<br>containsAnyOf|

## Demo

## Features

- feature:1
- feature:2

## Requirement

## Usage

## Installation

## References

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
