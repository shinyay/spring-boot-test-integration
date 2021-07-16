# Spring Boot Integration Tests

The `@SpringBootTest` annotation automagically spins up your application with all dependencies for use in tests.
Therefore, this testing is suitable for the Integration tests.

## Description
### Pros and Cons for `@SpringBootTest`
`@SpringBootTest` bootstraps the whole application

#### Good Fit
End-to-end tests would be the best, assuming the whole application is a black box.

#### When to Avoid `@SpringBootTest`
1. Integration tests with @SpringBootTest can take a very long time to start,
which is mostly **related to database initialization**, **the configuration of remote sources**, and **other IO (input/output)**.

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
