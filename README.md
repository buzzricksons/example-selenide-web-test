# Example for Selenide web test
Using Selenide and Spring boot.
- [Selenide](http://selenide.org/) 4.12
- Spring Boot 2
- JUnit 5
- lombok
- JDK 1.9
- [Latest Chrome(Headless mode included)](https://www.google.com/chrome/browser/desktop/index.html)
- Travis CI(optional)

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

#### Usage
Enter time value(seconds) at input box. Text message printed in `0 seconds ~ entered time value`.

(Elapsed time is random between 0 seconds and entered time value.)
- ex)If you enter 3, then text message printed in 0~3 seconds.


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
