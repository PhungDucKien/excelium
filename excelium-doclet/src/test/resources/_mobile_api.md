# Mobile API

## Command Table

No | Command | Method | Param 1 | Param 2 | Param 3
--------- | --------- | --------- | --------- | --------- | ---------
1 | Assert Value | assertValue | locator | text | 
2 | Execute Action | executeAction | action |  | 
3 | Execute If Value | executeIfValue |  | locator | text
4 | Store Value | storeValue | locator | variable | 
5 | Verify Value | verifyValue | locator | text | 
6 | Wait For Value | waitForValue | locator | text | 

## Assert Value

Asserts that the value of text box equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertValue(locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | the locator
text | the value to match with the result

## Execute Action

Execute action.

### Usage

`
executeAction(action)
`

### Parameters

Parameter | Description
--------- | -----------
action | the action

## Execute If Value

Executes an action if the value of text box equals to the given value.

### Usage

`
executeIfValue(locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
locator | the locator
text | the value to match with the result

## Store Value

Stores the value of text box in a variable for later access.

### Usage

`
storeValue(locator, variable)
`

### Parameters

Parameter | Description
--------- | -----------
locator | the locator
variable | the name of a variable in which the result is to be stored

## Verify Value

Verifies that the value of text box equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyValue(locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | the locator
text | the value to match with the result

## Wait For Value

Waits for the value of text box equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForValue(locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | the locator
text | the value to match with the result

