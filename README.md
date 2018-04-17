# Example for Selenide web test
Using Selenide and Spring boot.
- [Selenide](http://selenide.org/) 4.10
- Spring Boot 2.0
- lombok
- JDK 1.8
- [Latest Chrome(Headless mode included)](https://www.google.com/chrome/browser/desktop/index.html)
- Travis CI

## Test case
- Ajax test(example web app included.)
- Google Search test
- Yahoo Search test
- Naver Search test

### Example web app
```
http://localhost:18080/top
```
You need to run `com.example.AutoTestApplication#main` method

# Usage
## Basic
```
$ mvn clean test -Dchromeoptions.args="--disable-gpu"
```

## Headless
### If using maven
```
$ mvn clean test -Dchromeoptions.args="--headless --disable-gpu"
```

### If using java source
edit`application.yml`
```
  isHeadless: true
```

# If test failed
Screenshot and html file saved in `Git repository/test-result/Date and current time` folder.

- ex) `C:/sample-selenide-web-test/test-result/20171213162334`

# Etc
## You can some custom setting at `application.yml` file.
```
server:
  port: 11080

setting:
  browser: Chrome
  screenshot-folder: test-result/
  isHeadless: true
  timeInterval: 1

```

## You can test headless chrome at Travis CI
See below setting file.
```
https://github.com/buzzricksons/example-selenide-web-test/blob/master/.travis.yml
```

## If lobmok compile error occurred
https://www.jetbrains.com/help/idea/configuring-annotation-processing.html