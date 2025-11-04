# AutomationScreenplay
Example of Automation with Serenity BDD Web
:octocat:

## Installation 

This project was created in:

- Windows 11
- IntelliJ IDEA 2023 community edition
- JAVA 17
- Gradle Release 8.10
- Serenity 3.9.8
- Cucumber 3.9.8

Plugins to Intellij IDE:
* Cucumber for java
* Gherkin

## Usage

Make sure you have openjdk-17 (munimun) installed.

This project has 1 package.

In "src/test/resources/features/mytest.feature" do you find one user 
history and four test cases in Gherkin language.

I recommend you read them.

To run the test cases for this user story, open the terminal bash.

Run the following command:

```
./gradlew clean test aggregate -Dtags=@UserStory1
```

or at terminal powershell:

```
gradlew clean test aggregate -Dtags=@UserStory1
```

Watch the execution and in the end find the report in next project path:

" target/site/serenity/index.html "

and open in web browser.

You can watch all tests passed.  ✅✅✅✅ 

## License
[GNU-gpl-3.0](https://choosealicense.com/licenses/gpl-3.0/)
