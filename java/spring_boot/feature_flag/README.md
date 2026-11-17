Usage of a feature flag to permit to activate or not a feature or to use a specific logic for different application property value

In this example we have a property called `feature.my-feature.enabled` in our `application.yml` file

In the configuration we define which class extend `MyService` to use depending of the property's value

This example is using SPring Boot 4 and Java 21