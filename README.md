# redis pup sub project



## gradlew ClassNotFoundException
``` bash
$ bash ./gradlew build -x test
  Error: Could not find or load main class org.gradle.wrapper.GradleWrapperMain
  Caused by: java.lang.ClassNotFoundException: org.gradle.wrapper.GradleWrapperMain
```
add .gitignore
```bash 
$ vi .gitignore
!gradle/wrapper/gradle-wrapper.jar
```

