# Sample for Selenide web test
Using Selenide and Spring boot.
- [Selenide](http://selenide.org/)
- Spring Boot
- JDK 1.8
- [Chrome](https://www.google.com/chrome/browser/desktop/index.html)

# Usage
## Basic
```
$ mvn clean test
```

## Headless
```
$ mvn clean test -Dchromeoptions.args=headless
```

# If test failed
Screenshot and html file saved in `Git repository/test-result/Date and current time` folder.

- ex) `C:/sample-selenide-web-test/test-result/20171213162334`

# Etc
You can some custom setting at `application.yml` file.
