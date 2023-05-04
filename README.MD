# Spring Boot GraalVM Native Image Example Application
This is a followup of https://github.com/kuromogeko/graal-consent. For an explanation of the application and its purpose please refer to the original repository.

This Readme will list differences to the original App.

## Dependencies
Unlike the original this depends on Spring Boot 3 and GraalVM CE with a minimum Version of 22.3.

## Native Image compile

Is now achieved by running
```
mvn -Pnative native:compile
```

A Docker build could be run using Paketobuilder but is untested. 
```
mvn -Pnative spring-boot:build-image
```

## Reflection Config
Reflect Config gains a new Entry apparently due to a change in how Spring AOT interacts with Jackson.

```json
{
    "name": "de.examples.graal.consent.consent.domain.actors.user.UserCharacteristic",
    "allPublicFields": true,
    "allDeclaredFields": true,
    "allDeclaredConstructors": true,
    "allPublicConstructors": true,
    "allDeclaredMethods": true,
    "allPublicMethods": true
  }
```

## Known Issues
Javascript in this project ist currently disabled (ConsentEventListener not registered as component, language:js removed in call to native image). This is due to Spring Boot now requiring the Graal native Compiler Feature `ParseOnce`. Truffle Languages however require ParseOnce to be disabled to work. The Issue is also known to the GraalVM Development team and will be fixed with a later release.  
[Issue](https://github.com/oracle/graal/issues/4473) 