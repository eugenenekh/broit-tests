# Tests implementation

## Tech stack
- Gradle
- Java 17 (gradle allure plugin does not want to work with java 21)
- Selenide
- JUnit 5
- Allure

## Test cases
NB: Assumption is that to check that 'Order can be placed' it is enough to check that checkout page can be opened from cart.
Actual filling of checkout form is/should be covered by other existing tests.

NB2: For both testcases below we check addition to cart and checkout in one test, which is not ideal. Ideally, we would like to separate tests:
1. One just adds items to the cart,
2. Another Proceeds to checkout.
And for test that proceeds to checkout we would like to prepare cart not via UI (e.g. via API).
Unfortunately, we do not have this opportunity now, hence tests are combined (because for test that proceeds to checkout we need to add items to the cart vial UI anyway).

NB3: Checks of items include **title** and **quantity** only for now. But they can be easily enhanced to validate more parameters.

### Add multiple same items to the cart and proceed to checkout
- add an item with quantity 2 to cart
- check that the cart has what we added
- proceed to checkout
- check that checkout form shows what we added

### Add different items to the cart and proceed to checkout
- add an item with quantity 1 to cart
- add different item with quantity 1 to cart
- check that the cart has what we added
- proceed to checkout
- check that checkout form shows what we added

## Architecture overview
- `com.broit.components` - contains UI components which encapsulate interactions with them
- `com.broit.constaints` - contains constants to avoid direct usage of their string values
- `com.broit.forms` - contains UI forms (most likely pages; static for simplicity, may components, and elements directly)
- `com.broit.models` - contains models that are used to share/check data
- `com.broit.tests` - contains tests
- `com.broit.utils` - contains useful utilities

## How to run tests
```shell
./gradlew clean test
```

## How to generate allure report
```shell
./graldew allureReport
```

## How to run allure server locally
```shell
./gradlew allureServe
```

## Future enhancements
- clarify `FIXME` comments left in code
- prettify steps in tests and in allure report
- whatever you like
