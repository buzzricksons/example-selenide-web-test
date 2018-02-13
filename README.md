# Example for Selenide web test
Using Selenide and Spring boot.
- [Selenide](http://selenide.org/)
- Spring Boot
- JDK 1.8
- [Latest Chrome(Headless mode included)](https://www.google.com/chrome/browser/desktop/index.html)
- travis CI

## Test case
- Google Search test
- Yahoo Search test
- Naver Search test

# Usage
## Basic
```
$ mvn clean test
```

## Headless
### If using maven
```
$ mvn clean test -Dchromeoptions.args=headless
```

### If using java source(Not yet supported)
edit`application.yml`
```
  headless: true
```

# If test failed
Screenshot and html file saved in `Git repository/test-result/Date and current time` folder.

- ex) `C:/sample-selenide-web-test/test-result/20171213162334`

# Etc
You can some custom setting at `application.yml` file.
```
setting:
  browser: Chrome
  screenshot-folder: test-result/
  #↓Not yet supported
  #headless: true

```
