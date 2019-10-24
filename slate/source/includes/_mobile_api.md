# Mobile API

## Command Table

No | Command | Method | Param 1 | Param 2 | Param 3
--------- | --------- | --------- | --------- | --------- | ---------
1 | Assert Attribute | assertAttribute | locator | name | text
2 | Assert Attribute Match | assertAttributeMatch | locator | name | text
3 | Assert Attribute Not Match | assertAttributeNotMatch | locator | name | text
4 | Assert Checked | assertChecked | locator |  | 
5 | Assert Checked | assertChecked | parentLocator | locator | 
6 | Assert Date List Order Asc | assertDateListOrderAsc | locator | format | 
7 | Assert Date List Order Asc | assertDateListOrderAsc | parentLocator | locator | format
8 | Assert Date List Order Desc | assertDateListOrderDesc | locator | format | 
9 | Assert Date List Order Desc | assertDateListOrderDesc | parentLocator | locator | format
10 | Assert Editable | assertEditable | locator |  | 
11 | Assert Editable | assertEditable | parentLocator | locator | 
12 | Assert Enabled | assertEnabled | locator |  | 
13 | Assert Enabled | assertEnabled | parentLocator | locator | 
14 | Assert Eval | assertEval | expression | text | 
15 | Assert Exists In Database | assertExistsInDatabase | sql |  | 
16 | Assert Expression | assertExpression | expression | text | 
17 | Assert Expression Match | assertExpressionMatch | expression | text | 
18 | Assert Expression Not Match | assertExpressionNotMatch | expression | text | 
19 | Assert Integer List Order Asc | assertIntegerListOrderAsc | locator |  | 
20 | Assert Integer List Order Asc | assertIntegerListOrderAsc | parentLocator | locator | 
21 | Assert Integer List Order Desc | assertIntegerListOrderDesc | locator |  | 
22 | Assert Integer List Order Desc | assertIntegerListOrderDesc | parentLocator | locator | 
23 | Assert List Contain | assertListContain | variable | text | 
24 | Assert List Not Contain | assertListNotContain | variable | text | 
25 | Assert List Order Asc | assertListOrderAsc | variable |  | 
26 | Assert List Order Desc | assertListOrderDesc | variable |  | 
27 | Assert Not Attribute | assertNotAttribute | locator | name | text
28 | Assert Not Checked | assertNotChecked | locator |  | 
29 | Assert Not Checked | assertNotChecked | parentLocator | locator | 
30 | Assert Not Editable | assertNotEditable | locator |  | 
31 | Assert Not Editable | assertNotEditable | parentLocator | locator | 
32 | Assert Not Enabled | assertNotEnabled | locator |  | 
33 | Assert Not Enabled | assertNotEnabled | parentLocator | locator | 
34 | Assert Not Eval | assertNotEval | expression | text | 
35 | Assert Not Exists In Database | assertNotExistsInDatabase | sql |  | 
36 | Assert Not Expression | assertNotExpression | expression | text | 
37 | Assert Not Text | assertNotText | locator | text | 
38 | Assert Not Text | assertNotText | parentLocator | locator | text
39 | Assert Not Text Empty | assertNotTextEmpty | locator |  | 
40 | Assert Not Text Empty | assertNotTextEmpty | parentLocator | locator | 
41 | Assert Not Value | assertNotValue | locator | text | 
42 | Assert Not Value | assertNotValue | parentLocator | locator | text
43 | Assert Not Value Empty | assertNotValueEmpty | locator |  | 
44 | Assert Not Value Empty | assertNotValueEmpty | parentLocator | locator | 
45 | Assert Not Variable | assertNotVariable | variable | text | 
46 | Assert Not Visible | assertNotVisible | locator |  | 
47 | Assert Not Visible | assertNotVisible | parentLocator | locator | 
48 | Assert Row Count | assertRowCount | sql | count | 
49 | Assert Row Count Greater Than | assertRowCountGreaterThan | sql | count | 
50 | Assert Row Count Less Than | assertRowCountLessThan | sql | count | 
51 | Assert Text | assertText | locator | text | 
52 | Assert Text | assertText | parentLocator | locator | text
53 | Assert Text Empty | assertTextEmpty | locator |  | 
54 | Assert Text Empty | assertTextEmpty | parentLocator | locator | 
55 | Assert Text List Order Asc | assertTextListOrderAsc | locator |  | 
56 | Assert Text List Order Asc | assertTextListOrderAsc | parentLocator | locator | 
57 | Assert Text List Order Desc | assertTextListOrderDesc | locator |  | 
58 | Assert Text List Order Desc | assertTextListOrderDesc | parentLocator | locator | 
59 | Assert Text Match | assertTextMatch | locator | text | 
60 | Assert Text Match | assertTextMatch | parentLocator | locator | text
61 | Assert Text Not Match | assertTextNotMatch | locator | text | 
62 | Assert Text Not Match | assertTextNotMatch | parentLocator | locator | text
63 | Assert Value | assertValue | locator | text | 
64 | Assert Value | assertValue | parentLocator | locator | text
65 | Assert Value Empty | assertValueEmpty | locator |  | 
66 | Assert Value Empty | assertValueEmpty | parentLocator | locator | 
67 | Assert Value Match | assertValueMatch | locator | text | 
68 | Assert Value Match | assertValueMatch | parentLocator | locator | text
69 | Assert Value Not Match | assertValueNotMatch | locator | text | 
70 | Assert Value Not Match | assertValueNotMatch | parentLocator | locator | text
71 | Assert Variable | assertVariable | variable | text | 
72 | Assert Visible | assertVisible | locator |  | 
73 | Assert Visible | assertVisible | parentLocator | locator | 
74 | Echo | echo | message |  | 
75 | Execute | execute | action |  | 
76 | Execute Each | executeEach | action | locator | variable
77 | Execute If Checked | executeIfChecked | action | locator | 
78 | Execute If Checked | executeIfChecked | action | parentLocator | locator
79 | Execute If Editable | executeIfEditable | action | locator | 
80 | Execute If Editable | executeIfEditable | action | parentLocator | locator
81 | Execute If Enabled | executeIfEnabled | action | locator | 
82 | Execute If Enabled | executeIfEnabled | action | parentLocator | locator
83 | Execute If Eval | executeIfEval | action | expression | text
84 | Execute If Exists In Database | executeIfExistsInDatabase | action | sql | 
85 | Execute If Expression | executeIfExpression | action | expression | text
86 | Execute If Expression Match | executeIfExpressionMatch | action | expression | text
87 | Execute If Expression Not Match | executeIfExpressionNotMatch | action | expression | text
88 | Execute If List Contain | executeIfListContain | action | variable | text
89 | Execute If List Not Contain | executeIfListNotContain | action | variable | text
90 | Execute If Not Checked | executeIfNotChecked | action | locator | 
91 | Execute If Not Checked | executeIfNotChecked | action | parentLocator | locator
92 | Execute If Not Editable | executeIfNotEditable | action | locator | 
93 | Execute If Not Editable | executeIfNotEditable | action | parentLocator | locator
94 | Execute If Not Enabled | executeIfNotEnabled | action | locator | 
95 | Execute If Not Enabled | executeIfNotEnabled | action | parentLocator | locator
96 | Execute If Not Eval | executeIfNotEval | action | expression | text
97 | Execute If Not Exists In Database | executeIfNotExistsInDatabase | action | sql | 
98 | Execute If Not Expression | executeIfNotExpression | action | expression | text
99 | Execute If Not Text | executeIfNotText | action | locator | text
100 | Execute If Not Text Empty | executeIfNotTextEmpty | action | locator | 
101 | Execute If Not Text Empty | executeIfNotTextEmpty | action | parentLocator | locator
102 | Execute If Not Value | executeIfNotValue | action | locator | text
103 | Execute If Not Value Empty | executeIfNotValueEmpty | action | locator | 
104 | Execute If Not Value Empty | executeIfNotValueEmpty | action | parentLocator | locator
105 | Execute If Not Variable | executeIfNotVariable | action | variable | text
106 | Execute If Not Visible | executeIfNotVisible | action | locator | 
107 | Execute If Not Visible | executeIfNotVisible | action | parentLocator | locator
108 | Execute If Text | executeIfText | action | locator | text
109 | Execute If Text Empty | executeIfTextEmpty | action | locator | 
110 | Execute If Text Empty | executeIfTextEmpty | action | parentLocator | locator
111 | Execute If Text Match | executeIfTextMatch | action | locator | text
112 | Execute If Text Not Match | executeIfTextNotMatch | action | locator | text
113 | Execute If Value | executeIfValue | action | locator | text
114 | Execute If Value Empty | executeIfValueEmpty | action | locator | 
115 | Execute If Value Empty | executeIfValueEmpty | action | parentLocator | locator
116 | Execute If Value Match | executeIfValueMatch | action | locator | text
117 | Execute If Value Not Match | executeIfValueNotMatch | action | locator | text
118 | Execute If Variable | executeIfVariable | action | variable | text
119 | Execute If Visible | executeIfVisible | action | locator | 
120 | Execute If Visible | executeIfVisible | action | parentLocator | locator
121 | Execute Loop | executeLoop | action | times | 
122 | Go Back | goBack |  |  | 
123 | Pause | pause | waitTime |  | 
124 | Set Timeout | setTimeout | timeout |  | 
125 | Store | store | text | variable | 
126 | Store Attribute | storeAttribute | locator | name | variable
127 | Store Current Date | storeCurrentDate | variable |  | 
128 | Store Eval | storeEval | expression | variable | 
129 | Store Expression | storeExpression | expression | variable | 
130 | Store Push | storePush | text | variable | 
131 | Store Text | storeText | locator | variable | 
132 | Store Text | storeText | parentLocator | locator | variable
133 | Store Value | storeValue | locator | variable | 
134 | Store Value | storeValue | parentLocator | locator | variable
135 | Verify Attribute | verifyAttribute | locator | name | text
136 | Verify Attribute Match | verifyAttributeMatch | locator | name | text
137 | Verify Attribute Not Match | verifyAttributeNotMatch | locator | name | text
138 | Verify Checked | verifyChecked | locator |  | 
139 | Verify Checked | verifyChecked | parentLocator | locator | 
140 | Verify Date List Order Asc | verifyDateListOrderAsc | locator | format | 
141 | Verify Date List Order Asc | verifyDateListOrderAsc | parentLocator | locator | format
142 | Verify Date List Order Desc | verifyDateListOrderDesc | locator | format | 
143 | Verify Date List Order Desc | verifyDateListOrderDesc | parentLocator | locator | format
144 | Verify Editable | verifyEditable | locator |  | 
145 | Verify Editable | verifyEditable | parentLocator | locator | 
146 | Verify Enabled | verifyEnabled | locator |  | 
147 | Verify Enabled | verifyEnabled | parentLocator | locator | 
148 | Verify Eval | verifyEval | expression | text | 
149 | Verify Exists In Database | verifyExistsInDatabase | sql |  | 
150 | Verify Expression | verifyExpression | expression | text | 
151 | Verify Expression Match | verifyExpressionMatch | expression | text | 
152 | Verify Expression Not Match | verifyExpressionNotMatch | expression | text | 
153 | Verify Integer List Order Asc | verifyIntegerListOrderAsc | locator |  | 
154 | Verify Integer List Order Asc | verifyIntegerListOrderAsc | parentLocator | locator | 
155 | Verify Integer List Order Desc | verifyIntegerListOrderDesc | locator |  | 
156 | Verify Integer List Order Desc | verifyIntegerListOrderDesc | parentLocator | locator | 
157 | Verify List Contain | verifyListContain | variable | text | 
158 | Verify List Not Contain | verifyListNotContain | variable | text | 
159 | Verify List Order Asc | verifyListOrderAsc | variable |  | 
160 | Verify List Order Desc | verifyListOrderDesc | variable |  | 
161 | Verify Not Attribute | verifyNotAttribute | locator | name | text
162 | Verify Not Checked | verifyNotChecked | locator |  | 
163 | Verify Not Checked | verifyNotChecked | parentLocator | locator | 
164 | Verify Not Editable | verifyNotEditable | locator |  | 
165 | Verify Not Editable | verifyNotEditable | parentLocator | locator | 
166 | Verify Not Enabled | verifyNotEnabled | locator |  | 
167 | Verify Not Enabled | verifyNotEnabled | parentLocator | locator | 
168 | Verify Not Eval | verifyNotEval | expression | text | 
169 | Verify Not Exists In Database | verifyNotExistsInDatabase | sql |  | 
170 | Verify Not Expression | verifyNotExpression | expression | text | 
171 | Verify Not Text | verifyNotText | locator | text | 
172 | Verify Not Text | verifyNotText | parentLocator | locator | text
173 | Verify Not Text Empty | verifyNotTextEmpty | locator |  | 
174 | Verify Not Text Empty | verifyNotTextEmpty | parentLocator | locator | 
175 | Verify Not Value | verifyNotValue | locator | text | 
176 | Verify Not Value | verifyNotValue | parentLocator | locator | text
177 | Verify Not Value Empty | verifyNotValueEmpty | locator |  | 
178 | Verify Not Value Empty | verifyNotValueEmpty | parentLocator | locator | 
179 | Verify Not Variable | verifyNotVariable | variable | text | 
180 | Verify Not Visible | verifyNotVisible | locator |  | 
181 | Verify Not Visible | verifyNotVisible | parentLocator | locator | 
182 | Verify Row Count | verifyRowCount | sql | count | 
183 | Verify Row Count Greater Than | verifyRowCountGreaterThan | sql | count | 
184 | Verify Row Count Less Than | verifyRowCountLessThan | sql | count | 
185 | Verify Text | verifyText | locator | text | 
186 | Verify Text | verifyText | parentLocator | locator | text
187 | Verify Text Empty | verifyTextEmpty | locator |  | 
188 | Verify Text Empty | verifyTextEmpty | parentLocator | locator | 
189 | Verify Text List Order Asc | verifyTextListOrderAsc | locator |  | 
190 | Verify Text List Order Asc | verifyTextListOrderAsc | parentLocator | locator | 
191 | Verify Text List Order Desc | verifyTextListOrderDesc | locator |  | 
192 | Verify Text List Order Desc | verifyTextListOrderDesc | parentLocator | locator | 
193 | Verify Text Match | verifyTextMatch | locator | text | 
194 | Verify Text Match | verifyTextMatch | parentLocator | locator | text
195 | Verify Text Not Match | verifyTextNotMatch | locator | text | 
196 | Verify Text Not Match | verifyTextNotMatch | parentLocator | locator | text
197 | Verify Value | verifyValue | locator | text | 
198 | Verify Value | verifyValue | parentLocator | locator | text
199 | Verify Value Empty | verifyValueEmpty | locator |  | 
200 | Verify Value Empty | verifyValueEmpty | parentLocator | locator | 
201 | Verify Value Match | verifyValueMatch | locator | text | 
202 | Verify Value Match | verifyValueMatch | parentLocator | locator | text
203 | Verify Value Not Match | verifyValueNotMatch | locator | text | 
204 | Verify Value Not Match | verifyValueNotMatch | parentLocator | locator | text
205 | Verify Variable | verifyVariable | variable | text | 
206 | Verify Visible | verifyVisible | locator |  | 
207 | Verify Visible | verifyVisible | parentLocator | locator | 
208 | Wait For All Element Not Present | waitForAllElementNotPresent | locatorArray |  | 
209 | Wait For All Element Present | waitForAllElementPresent | locatorArray |  | 
210 | Wait For All Text Not Present | waitForAllTextNotPresent | textArray |  | 
211 | Wait For All Text Present | waitForAllTextPresent | textArray |  | 
212 | Wait For Any Element Not Present | waitForAnyElementNotPresent | locatorArray |  | 
213 | Wait For Any Element Present | waitForAnyElementPresent | locatorArray |  | 
214 | Wait For Any Text Not Present | waitForAnyTextNotPresent | textArray |  | 
215 | Wait For Any Text Present | waitForAnyTextPresent | textArray |  | 
216 | Wait For Attribute | waitForAttribute | locator | name | text
217 | Wait For Attribute Match | waitForAttributeMatch | locator | name | text
218 | Wait For Attribute Not Match | waitForAttributeNotMatch | locator | name | text
219 | Wait For Checked | waitForChecked | locator |  | 
220 | Wait For Checked | waitForChecked | parentLocator | locator | 
221 | Wait For Editable | waitForEditable | locator |  | 
222 | Wait For Editable | waitForEditable | parentLocator | locator | 
223 | Wait For Enabled | waitForEnabled | locator |  | 
224 | Wait For Enabled | waitForEnabled | parentLocator | locator | 
225 | Wait For Eval | waitForEval | expression | text | 
226 | Wait For Exists In Database | waitForExistsInDatabase | sql |  | 
227 | Wait For Expression | waitForExpression | expression | text | 
228 | Wait For Expression Match | waitForExpressionMatch | expression | text | 
229 | Wait For Expression Not Match | waitForExpressionNotMatch | expression | text | 
230 | Wait For Not Attribute | waitForNotAttribute | locator | name | text
231 | Wait For Not Checked | waitForNotChecked | locator |  | 
232 | Wait For Not Checked | waitForNotChecked | parentLocator | locator | 
233 | Wait For Not Editable | waitForNotEditable | locator |  | 
234 | Wait For Not Editable | waitForNotEditable | parentLocator | locator | 
235 | Wait For Not Enabled | waitForNotEnabled | locator |  | 
236 | Wait For Not Enabled | waitForNotEnabled | parentLocator | locator | 
237 | Wait For Not Eval | waitForNotEval | expression | text | 
238 | Wait For Not Exists In Database | waitForNotExistsInDatabase | sql |  | 
239 | Wait For Not Expression | waitForNotExpression | expression | text | 
240 | Wait For Not Text | waitForNotText | locator | text | 
241 | Wait For Not Text | waitForNotText | parentLocator | locator | text
242 | Wait For Not Text Empty | waitForNotTextEmpty | locator |  | 
243 | Wait For Not Text Empty | waitForNotTextEmpty | parentLocator | locator | 
244 | Wait For Not Value | waitForNotValue | locator | text | 
245 | Wait For Not Value | waitForNotValue | parentLocator | locator | text
246 | Wait For Not Value Empty | waitForNotValueEmpty | locator |  | 
247 | Wait For Not Value Empty | waitForNotValueEmpty | parentLocator | locator | 
248 | Wait For Not Visible | waitForNotVisible | locator |  | 
249 | Wait For Not Visible | waitForNotVisible | parentLocator | locator | 
250 | Wait For Text | waitForText | locator | text | 
251 | Wait For Text | waitForText | parentLocator | locator | text
252 | Wait For Text Empty | waitForTextEmpty | locator |  | 
253 | Wait For Text Empty | waitForTextEmpty | parentLocator | locator | 
254 | Wait For Text Match | waitForTextMatch | locator | text | 
255 | Wait For Text Match | waitForTextMatch | parentLocator | locator | text
256 | Wait For Text Not Match | waitForTextNotMatch | locator | text | 
257 | Wait For Text Not Match | waitForTextNotMatch | parentLocator | locator | text
258 | Wait For Value | waitForValue | locator | text | 
259 | Wait For Value | waitForValue | parentLocator | locator | text
260 | Wait For Value Empty | waitForValueEmpty | locator |  | 
261 | Wait For Value Empty | waitForValueEmpty | parentLocator | locator | 
262 | Wait For Value Match | waitForValueMatch | locator | text | 
263 | Wait For Value Match | waitForValueMatch | parentLocator | locator | text
264 | Wait For Value Not Match | waitForValueNotMatch | locator | text | 
265 | Wait For Value Not Match | waitForValueNotMatch | parentLocator | locator | text
266 | Wait For Visible | waitForVisible | locator |  | 
267 | Wait For Visible | waitForVisible | parentLocator | locator | 

## Assert Attribute

Asserts that the value of the given attribute of the element equals to the given value. When the assert fails, the test is aborted. Will return the current value, even if this has been modified after the page has been loaded.

 <p>More exactly, this method will return the value of the property with the given name, if it exists. If it does not, then the value of the attribute with the given name is returned. If neither exists, null is returned.

 <p>The "style" attribute is converted as best can be to a text representation with a trailing semi-colon.

 <p>The following are deemed to be "boolean" attributes, and will return either "true" or null:

 <p>async, autofocus, autoplay, checked, compact, complete, controls, declare, defaultchecked, defaultselected, defer, disabled, draggable, ended, formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope, loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open, paused, pubdate, readonly, required, reversed, scoped, seamless, seeking, selected, truespeed, willvalidate

 <p>Finally, the following commonly mis-capitalized attribute/property names are evaluated as expected:

 <ul> <li>If the given name is "class", the "className" property is returned. <li>If the given name is "readonly", the "readOnly" property is returned. </ul>

 <i>Note:</i> The reason for this behavior is that users frequently confuse attributes and properties. If you need to do something more precise, e.g., refer to an attribute even when a property of the same name exists, then you should evaluate Javascript to obtain the result you desire.

### Usage

`
assertAttribute(locator, name, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator
name | The name of the attribute.
text | the value to match with the result

## Assert Attribute Match

Asserts that the value of the given attribute of the element matches the given value. When the assert fails, the test is aborted. Will return the current value, even if this has been modified after the page has been loaded.

 <p>More exactly, this method will return the value of the property with the given name, if it exists. If it does not, then the value of the attribute with the given name is returned. If neither exists, null is returned.

 <p>The "style" attribute is converted as best can be to a text representation with a trailing semi-colon.

 <p>The following are deemed to be "boolean" attributes, and will return either "true" or null:

 <p>async, autofocus, autoplay, checked, compact, complete, controls, declare, defaultchecked, defaultselected, defer, disabled, draggable, ended, formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope, loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open, paused, pubdate, readonly, required, reversed, scoped, seamless, seeking, selected, truespeed, willvalidate

 <p>Finally, the following commonly mis-capitalized attribute/property names are evaluated as expected:

 <ul> <li>If the given name is "class", the "className" property is returned. <li>If the given name is "readonly", the "readOnly" property is returned. </ul>

 <i>Note:</i> The reason for this behavior is that users frequently confuse attributes and properties. If you need to do something more precise, e.g., refer to an attribute even when a property of the same name exists, then you should evaluate Javascript to obtain the result you desire.

### Usage

`
assertAttributeMatch(locator, name, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator
name | The name of the attribute.
text | the value to match with the result

## Assert Attribute Not Match

Asserts that the value of the given attribute of the element not match the given value. When the assert fails, the test is aborted. Will return the current value, even if this has been modified after the page has been loaded.

 <p>More exactly, this method will return the value of the property with the given name, if it exists. If it does not, then the value of the attribute with the given name is returned. If neither exists, null is returned.

 <p>The "style" attribute is converted as best can be to a text representation with a trailing semi-colon.

 <p>The following are deemed to be "boolean" attributes, and will return either "true" or null:

 <p>async, autofocus, autoplay, checked, compact, complete, controls, declare, defaultchecked, defaultselected, defer, disabled, draggable, ended, formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope, loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open, paused, pubdate, readonly, required, reversed, scoped, seamless, seeking, selected, truespeed, willvalidate

 <p>Finally, the following commonly mis-capitalized attribute/property names are evaluated as expected:

 <ul> <li>If the given name is "class", the "className" property is returned. <li>If the given name is "readonly", the "readOnly" property is returned. </ul>

 <i>Note:</i> The reason for this behavior is that users frequently confuse attributes and properties. If you need to do something more precise, e.g., refer to an attribute even when a property of the same name exists, then you should evaluate Javascript to obtain the result you desire.

### Usage

`
assertAttributeNotMatch(locator, name, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator
name | The name of the attribute.
text | the value to match with the result

## Assert Checked

Asserts that a toggle-button (checkbox/radio) is checked. When the assert fails, the test is aborted. Fails if the specified element doesn't exist or isn't a toggle-button.

### Usage

`
assertChecked(locator)
`

`
assertChecked(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to a checkbox or radio button

## Assert Date List Order Asc

Returns the text values of the specified elements are sorted in ascending order. The values are assuming to be dates.

### Usage

`
assertDateListOrderAsc(locator, format)
`

`
assertDateListOrderAsc(parentLocator, locator, format)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
format | date format to parse

## Assert Date List Order Desc

Returns the text values of the specified elements are sorted in descending order. The values are assuming to be dates.

### Usage

`
assertDateListOrderDesc(locator, format)
`

`
assertDateListOrderDesc(parentLocator, locator, format)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
format | date format to parse

## Assert Editable

Asserts that the specified input element is editable, ie hasn't been disabled. When the assert fails, the test is aborted. This method will fail if the specified element isn't an input element.

### Usage

`
assertEditable(locator)
`

`
assertEditable(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Assert Enabled

Asserts that an element is enabled. When the assert fails, the test is aborted. Fails if the specified element doesn't exist.

### Usage

`
assertEnabled(locator)
`

`
assertEnabled(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Assert Eval

Asserts that the result of evaluating the specified snippet equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertEval(expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the snippet to run
text | the value to match with the result

## Assert Exists In Database

Asserts that any row would be returned by given the input SQL statement. When the assert fails, the test is aborted.

### Usage

`
assertExistsInDatabase(sql)
`

### Parameters

Parameter | Description
--------- | -----------
sql | the sql

## Assert Expression

Asserts that the specified expression equals to the given value. When the assert fails, the test is aborted.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
assertExpression(expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the value to return
text | the value to match with the result

## Assert Expression Match

Asserts that the specified expression matches the given value. When the assert fails, the test is aborted.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
assertExpressionMatch(expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the value to return
text | the value to match with the result

## Assert Expression Not Match

Asserts that the specified expression not match the given value. When the assert fails, the test is aborted.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
assertExpressionNotMatch(expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the value to return
text | the value to match with the result

## Assert Integer List Order Asc

Returns the text values of the specified elements are sorted in ascending order. The values are assuming to be numbers.

### Usage

`
assertIntegerListOrderAsc(locator)
`

`
assertIntegerListOrderAsc(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element

## Assert Integer List Order Desc

Returns the text values of the specified elements are sorted in descending order. The values are assuming to be numbers.

### Usage

`
assertIntegerListOrderDesc(locator)
`

`
assertIntegerListOrderDesc(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element

## Assert List Contain

Asserts that the specified text pattern appears in the specified variable list value contains the given value. When the assert fails, the test is aborted.

### Usage

`
assertListContain(variable, text)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the variable
text | the text to compare
text | the value to match with the result

## Assert List Not Contain

Asserts that the specified text pattern appears in the specified variable list value not contain the given value. When the assert fails, the test is aborted.

### Usage

`
assertListNotContain(variable, text)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the variable
text | the text to compare
text | the value to match with the result

## Assert List Order Asc

Verifies that the specified variable list value is in ascending order.

### Usage

`
assertListOrderAsc(variable)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the variable

## Assert List Order Desc

Verifies that the specified variable list value is in descending order.

### Usage

`
assertListOrderDesc(variable)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the variable

## Assert Not Attribute

Asserts that the value of the given attribute of the element not equal to the given value. When the assert fails, the test is aborted. Will return the current value, even if this has been modified after the page has been loaded.

 <p>More exactly, this method will return the value of the property with the given name, if it exists. If it does not, then the value of the attribute with the given name is returned. If neither exists, null is returned.

 <p>The "style" attribute is converted as best can be to a text representation with a trailing semi-colon.

 <p>The following are deemed to be "boolean" attributes, and will return either "true" or null:

 <p>async, autofocus, autoplay, checked, compact, complete, controls, declare, defaultchecked, defaultselected, defer, disabled, draggable, ended, formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope, loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open, paused, pubdate, readonly, required, reversed, scoped, seamless, seeking, selected, truespeed, willvalidate

 <p>Finally, the following commonly mis-capitalized attribute/property names are evaluated as expected:

 <ul> <li>If the given name is "class", the "className" property is returned. <li>If the given name is "readonly", the "readOnly" property is returned. </ul>

 <i>Note:</i> The reason for this behavior is that users frequently confuse attributes and properties. If you need to do something more precise, e.g., refer to an attribute even when a property of the same name exists, then you should evaluate Javascript to obtain the result you desire.

### Usage

`
assertNotAttribute(locator, name, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator
name | The name of the attribute.
text | the value to match with the result

## Assert Not Checked

Asserts that a toggle-button (checkbox/radio) is not checked. When the assert fails, the test is aborted. Fails if the specified element doesn't exist or isn't a toggle-button.

### Usage

`
assertNotChecked(locator)
`

`
assertNotChecked(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to a checkbox or radio button

## Assert Not Editable

Asserts that the specified input element is not editable, ie hasn't been disabled. When the assert fails, the test is aborted. This method will fail if the specified element isn't an input element.

### Usage

`
assertNotEditable(locator)
`

`
assertNotEditable(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Assert Not Enabled

Asserts that an element is not enabled. When the assert fails, the test is aborted. Fails if the specified element doesn't exist.

### Usage

`
assertNotEnabled(locator)
`

`
assertNotEnabled(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Assert Not Eval

Asserts that the result of evaluating the specified snippet not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotEval(expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the snippet to run
text | the value to match with the result

## Assert Not Exists In Database

Asserts that any row would be returned by given the input SQL statement. When the assert fails, the test is aborted.

### Usage

`
assertNotExistsInDatabase(sql)
`

### Parameters

Parameter | Description
--------- | -----------
sql | the sql

## Assert Not Expression

Asserts that the specified expression not equal to the given value. When the assert fails, the test is aborted.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
assertNotExpression(expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the value to return
text | the value to match with the result

## Assert Not Text

Asserts that the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotText(locator, text)
`

`
assertNotText(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Assert Not Text Empty

Asserts that the text of an element is not empty. When the assert fails, the test is aborted.

### Usage

`
assertNotTextEmpty(locator)
`

`
assertNotTextEmpty(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Assert Not Value

Asserts that the (whitespace-trimmed) value of an input field (or anything else with a value parameter) not equal to the given value. When the assert fails, the test is aborted. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
assertNotValue(locator, text)
`

`
assertNotValue(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Assert Not Value Empty

Asserts that the (whitespace-trimmed) value of an input field is not empty. When the assert fails, the test is aborted.

### Usage

`
assertNotValueEmpty(locator)
`

`
assertNotValueEmpty(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Assert Not Variable

Asserts that the specified variable value not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotVariable(variable, text)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the variable
text | the value to match with the result

## Assert Not Visible

Asserts that the specified element is not visible. When the assert fails, the test is aborted. An element can be rendered invisible by setting the CSS "visibility" property to "hidden", or the "display" property to "none", either for the element itself or one if its ancestors. This method will fail if the element is not present.

### Usage

`
assertNotVisible(locator)
`

`
assertNotVisible(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Assert Row Count

Check if the number of rows returned from selectStatement is equal to the value submitted.

### Usage

`
assertRowCount(sql, count)
`

### Parameters

Parameter | Description
--------- | -----------
sql | the sql
count | the count

## Assert Row Count Greater Than

Check if the number of rows returned from selectStatement is greater than the value submitted.

### Usage

`
assertRowCountGreaterThan(sql, count)
`

### Parameters

Parameter | Description
--------- | -----------
sql | the sql
count | the count

## Assert Row Count Less Than

Check if the number of rows returned from selectStatement is less than the value submitted.

### Usage

`
assertRowCountLessThan(sql, count)
`

### Parameters

Parameter | Description
--------- | -----------
sql | the sql
count | the count

## Assert Text

Asserts that the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertText(locator, text)
`

`
assertText(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Assert Text Empty

Asserts that the text of an element is empty. When the assert fails, the test is aborted.

### Usage

`
assertTextEmpty(locator)
`

`
assertTextEmpty(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Assert Text List Order Asc

Returns the text values of the specified elements are sorted in ascending order.

### Usage

`
assertTextListOrderAsc(locator)
`

`
assertTextListOrderAsc(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element

## Assert Text List Order Desc

Returns the text values of the specified elements are sorted in descending order.

### Usage

`
assertTextListOrderDesc(locator)
`

`
assertTextListOrderDesc(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element

## Assert Text Match

Asserts that the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertTextMatch(locator, text)
`

`
assertTextMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Assert Text Not Match

Asserts that the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertTextNotMatch(locator, text)
`

`
assertTextNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Assert Value

Asserts that the (whitespace-trimmed) value of an input field (or anything else with a value parameter) equals to the given value. When the assert fails, the test is aborted. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
assertValue(locator, text)
`

`
assertValue(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Assert Value Empty

Asserts that the (whitespace-trimmed) value of an input field is empty. When the assert fails, the test is aborted.

### Usage

`
assertValueEmpty(locator)
`

`
assertValueEmpty(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Assert Value Match

Asserts that the (whitespace-trimmed) value of an input field (or anything else with a value parameter) matches the given value. When the assert fails, the test is aborted. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
assertValueMatch(locator, text)
`

`
assertValueMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Assert Value Not Match

Asserts that the (whitespace-trimmed) value of an input field (or anything else with a value parameter) not match the given value. When the assert fails, the test is aborted. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
assertValueNotMatch(locator, text)
`

`
assertValueNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Assert Variable

Asserts that the specified variable value equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertVariable(variable, text)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the variable
text | the value to match with the result

## Assert Visible

Asserts that the specified element is visible. When the assert fails, the test is aborted. An element can be rendered invisible by setting the CSS "visibility" property to "hidden", or the "display" property to "none", either for the element itself or one if its ancestors. This method will fail if the element is not present.

### Usage

`
assertVisible(locator)
`

`
assertVisible(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Echo

Prints the specified message into the third table cell in your Selenese tables. Useful for debugging.

### Usage

`
echo(message)
`

### Parameters

Parameter | Description
--------- | -----------
message | the message to print

## Execute

Executes an action.

### Usage

`
execute(action)
`

### Parameters

Parameter | Description
--------- | -----------
action | the action

## Execute Each

Iterates over the list of the specified elements and executes an action.

### Usage

`
executeEach(action, locator, variable)
`

### Parameters

Parameter | Description
--------- | -----------
action | the action
locator | the locator
variable | the variable

## Execute If Checked

Executes an action if a toggle-button (checkbox/radio) is checked. Fails if the specified element doesn't exist or isn't a toggle-button.

### Usage

`
executeIfChecked(action, locator)
`

`
executeIfChecked(action, parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator pointing to a checkbox or radio button

## Execute If Editable

Executes an action if the specified input element is editable, ie hasn't been disabled. This method will fail if the specified element isn't an input element.

### Usage

`
executeIfEditable(action, locator)
`

`
executeIfEditable(action, parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator

## Execute If Enabled

Executes an action if an element is enabled. Fails if the specified element doesn't exist.

### Usage

`
executeIfEnabled(action, locator)
`

`
executeIfEnabled(action, parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator

## Execute If Eval

Executes an action if the result of evaluating the specified snippet equals to the given value.

### Usage

`
executeIfEval(action, expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
expression | the snippet to run
text | the value to match with the result

## Execute If Exists In Database

Executes an action if any row would be returned by given the input SQL statement.

### Usage

`
executeIfExistsInDatabase(action, sql)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
sql | the sql

## Execute If Expression

Executes an action if the specified expression equals to the given value.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
executeIfExpression(action, expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
expression | the value to return
text | the value to match with the result

## Execute If Expression Match

Executes an action if the specified expression matches the given value.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
executeIfExpressionMatch(action, expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
expression | the value to return
text | the value to match with the result

## Execute If Expression Not Match

Executes an action if the specified expression not match the given value.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
executeIfExpressionNotMatch(action, expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
expression | the value to return
text | the value to match with the result

## Execute If List Contain

Executes an action if the specified text pattern appears in the specified variable list value contains the given value.

### Usage

`
executeIfListContain(action, variable, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
variable | the variable
text | the text to compare
text | the value to match with the result

## Execute If List Not Contain

Executes an action if the specified text pattern appears in the specified variable list value not contain the given value.

### Usage

`
executeIfListNotContain(action, variable, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
variable | the variable
text | the text to compare
text | the value to match with the result

## Execute If Not Checked

Executes an action if a toggle-button (checkbox/radio) is not checked. Fails if the specified element doesn't exist or isn't a toggle-button.

### Usage

`
executeIfNotChecked(action, locator)
`

`
executeIfNotChecked(action, parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator pointing to a checkbox or radio button

## Execute If Not Editable

Executes an action if the specified input element is not editable, ie hasn't been disabled. This method will fail if the specified element isn't an input element.

### Usage

`
executeIfNotEditable(action, locator)
`

`
executeIfNotEditable(action, parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator

## Execute If Not Enabled

Executes an action if an element is not enabled. Fails if the specified element doesn't exist.

### Usage

`
executeIfNotEnabled(action, locator)
`

`
executeIfNotEnabled(action, parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator

## Execute If Not Eval

Executes an action if the result of evaluating the specified snippet not equal to the given value.

### Usage

`
executeIfNotEval(action, expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
expression | the snippet to run
text | the value to match with the result

## Execute If Not Exists In Database

Executes an action if any row would be returned by given the input SQL statement.

### Usage

`
executeIfNotExistsInDatabase(action, sql)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
sql | the sql

## Execute If Not Expression

Executes an action if the specified expression not equal to the given value.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
executeIfNotExpression(action, expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
expression | the value to return
text | the value to match with the result

## Execute If Not Text

Executes an action if the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user not equal to the given value.

### Usage

`
executeIfNotText(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Execute If Not Text Empty

Executes an action if the text of an element is not empty.

### Usage

`
executeIfNotTextEmpty(action, locator)
`

`
executeIfNotTextEmpty(action, parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator

## Execute If Not Value

Executes an action if the (whitespace-trimmed) value of an input field (or anything else with a value parameter) not equal to the given value. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
executeIfNotValue(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Execute If Not Value Empty

Executes an action if the (whitespace-trimmed) value of an input field is not empty.

### Usage

`
executeIfNotValueEmpty(action, locator)
`

`
executeIfNotValueEmpty(action, parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator

## Execute If Not Variable

Executes an action if the specified variable value not equal to the given value.

### Usage

`
executeIfNotVariable(action, variable, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
variable | the variable
text | the value to match with the result

## Execute If Not Visible

Executes an action if the specified element is not visible. An element can be rendered invisible by setting the CSS "visibility" property to "hidden", or the "display" property to "none", either for the element itself or one if its ancestors. This method will fail if the element is not present.

### Usage

`
executeIfNotVisible(action, locator)
`

`
executeIfNotVisible(action, parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator

## Execute If Text

Executes an action if the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user equals to the given value.

### Usage

`
executeIfText(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Execute If Text Empty

Executes an action if the text of an element is empty.

### Usage

`
executeIfTextEmpty(action, locator)
`

`
executeIfTextEmpty(action, parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator

## Execute If Text Match

Executes an action if the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user matches the given value.

### Usage

`
executeIfTextMatch(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Execute If Text Not Match

Executes an action if the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user not match the given value.

### Usage

`
executeIfTextNotMatch(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Execute If Value

Executes an action if the (whitespace-trimmed) value of an input field (or anything else with a value parameter) equals to the given value. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
executeIfValue(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Execute If Value Empty

Executes an action if the (whitespace-trimmed) value of an input field is empty.

### Usage

`
executeIfValueEmpty(action, locator)
`

`
executeIfValueEmpty(action, parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator

## Execute If Value Match

Executes an action if the (whitespace-trimmed) value of an input field (or anything else with a value parameter) matches the given value. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
executeIfValueMatch(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Execute If Value Not Match

Executes an action if the (whitespace-trimmed) value of an input field (or anything else with a value parameter) not match the given value. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
executeIfValueNotMatch(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Execute If Variable

Executes an action if the specified variable value equals to the given value.

### Usage

`
executeIfVariable(action, variable, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
variable | the variable
text | the value to match with the result

## Execute If Visible

Executes an action if the specified element is visible. An element can be rendered invisible by setting the CSS "visibility" property to "hidden", or the "display" property to "none", either for the element itself or one if its ancestors. This method will fail if the element is not present.

### Usage

`
executeIfVisible(action, locator)
`

`
executeIfVisible(action, parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator

## Execute Loop

Executes an action n times.

### Usage

`
executeLoop(action, times)
`

### Parameters

Parameter | Description
--------- | -----------
action | the action
times | the times

## Go Back

Simulates the user clicking the "back" button on their browser.

### Usage

`
goBack()
`

### Parameters

Parameter | Description
--------- | -----------

## Pause

Wait for the specified amount of time (in milliseconds)

### Usage

`
pause(waitTime)
`

### Parameters

Parameter | Description
--------- | -----------
waitTime | the amount of time to sleep (in milliseconds)

## Set Timeout

Specifies the amount of time that Selenium will wait for actions to complete.

 <p> Actions that require waiting include "open" and the "waitFor*" actions. </p> The default timeout is 30 seconds.

### Usage

`
setTimeout(timeout)
`

### Parameters

Parameter | Description
--------- | -----------
timeout | a timeout in milliseconds, after which the action will return with an error

## Store

Stores a value in a variable for later access.

### Usage

`
store(text, variable)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to store
variable | the name of a variable in which the result is to be stored.

## Store Attribute

Stores the value of the given attribute of the element in a variable for later access. Will return the current value, even if this has been modified after the page has been loaded.

 <p>More exactly, this method will return the value of the property with the given name, if it exists. If it does not, then the value of the attribute with the given name is returned. If neither exists, null is returned.

 <p>The "style" attribute is converted as best can be to a text representation with a trailing semi-colon.

 <p>The following are deemed to be "boolean" attributes, and will return either "true" or null:

 <p>async, autofocus, autoplay, checked, compact, complete, controls, declare, defaultchecked, defaultselected, defer, disabled, draggable, ended, formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope, loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open, paused, pubdate, readonly, required, reversed, scoped, seamless, seeking, selected, truespeed, willvalidate

 <p>Finally, the following commonly mis-capitalized attribute/property names are evaluated as expected:

 <ul> <li>If the given name is "class", the "className" property is returned. <li>If the given name is "readonly", the "readOnly" property is returned. </ul>

 <i>Note:</i> The reason for this behavior is that users frequently confuse attributes and properties. If you need to do something more precise, e.g., refer to an attribute even when a property of the same name exists, then you should evaluate Javascript to obtain the result you desire.

### Usage

`
storeAttribute(locator, name, variable)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator
name | The name of the attribute.
variable | the name of a variable in which the result is to be stored

## Store Current Date

Stores the current date in a variable for later access.

### Usage

`
storeCurrentDate(variable)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the name of a variable in which the result is to be stored

## Store Eval

Stores the result of evaluating the specified snippet in a variable for later access.

### Usage

`
storeEval(expression, variable)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the snippet to run
variable | the name of a variable in which the result is to be stored

## Store Expression

Stores the specified expression in a variable for later access.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
storeExpression(expression, variable)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the value to return
variable | the name of a variable in which the result is to be stored

## Store Push

Stores a value in an array variable for later access.

### Usage

`
storePush(text, variable)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to store
variable | the name of a variable in which the result is to be stored.

## Store Text

Stores the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user in a variable for later access.

### Usage

`
storeText(locator, variable)
`

`
storeText(parentLocator, locator, variable)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
variable | the name of a variable in which the result is to be stored

## Store Value

Stores the (whitespace-trimmed) value of an input field (or anything else with a value parameter) in a variable for later access. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
storeValue(locator, variable)
`

`
storeValue(parentLocator, locator, variable)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
variable | the name of a variable in which the result is to be stored

## Verify Attribute

Verifies that the value of the given attribute of the element equals to the given value. When the verify fails, the test will continue execution, logging the failure. Will return the current value, even if this has been modified after the page has been loaded.

 <p>More exactly, this method will return the value of the property with the given name, if it exists. If it does not, then the value of the attribute with the given name is returned. If neither exists, null is returned.

 <p>The "style" attribute is converted as best can be to a text representation with a trailing semi-colon.

 <p>The following are deemed to be "boolean" attributes, and will return either "true" or null:

 <p>async, autofocus, autoplay, checked, compact, complete, controls, declare, defaultchecked, defaultselected, defer, disabled, draggable, ended, formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope, loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open, paused, pubdate, readonly, required, reversed, scoped, seamless, seeking, selected, truespeed, willvalidate

 <p>Finally, the following commonly mis-capitalized attribute/property names are evaluated as expected:

 <ul> <li>If the given name is "class", the "className" property is returned. <li>If the given name is "readonly", the "readOnly" property is returned. </ul>

 <i>Note:</i> The reason for this behavior is that users frequently confuse attributes and properties. If you need to do something more precise, e.g., refer to an attribute even when a property of the same name exists, then you should evaluate Javascript to obtain the result you desire.

### Usage

`
verifyAttribute(locator, name, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator
name | The name of the attribute.
text | the value to match with the result

## Verify Attribute Match

Verifies that the value of the given attribute of the element matches the given value. When the verify fails, the test will continue execution, logging the failure. Will return the current value, even if this has been modified after the page has been loaded.

 <p>More exactly, this method will return the value of the property with the given name, if it exists. If it does not, then the value of the attribute with the given name is returned. If neither exists, null is returned.

 <p>The "style" attribute is converted as best can be to a text representation with a trailing semi-colon.

 <p>The following are deemed to be "boolean" attributes, and will return either "true" or null:

 <p>async, autofocus, autoplay, checked, compact, complete, controls, declare, defaultchecked, defaultselected, defer, disabled, draggable, ended, formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope, loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open, paused, pubdate, readonly, required, reversed, scoped, seamless, seeking, selected, truespeed, willvalidate

 <p>Finally, the following commonly mis-capitalized attribute/property names are evaluated as expected:

 <ul> <li>If the given name is "class", the "className" property is returned. <li>If the given name is "readonly", the "readOnly" property is returned. </ul>

 <i>Note:</i> The reason for this behavior is that users frequently confuse attributes and properties. If you need to do something more precise, e.g., refer to an attribute even when a property of the same name exists, then you should evaluate Javascript to obtain the result you desire.

### Usage

`
verifyAttributeMatch(locator, name, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator
name | The name of the attribute.
text | the value to match with the result

## Verify Attribute Not Match

Verifies that the value of the given attribute of the element not match the given value. When the verify fails, the test will continue execution, logging the failure. Will return the current value, even if this has been modified after the page has been loaded.

 <p>More exactly, this method will return the value of the property with the given name, if it exists. If it does not, then the value of the attribute with the given name is returned. If neither exists, null is returned.

 <p>The "style" attribute is converted as best can be to a text representation with a trailing semi-colon.

 <p>The following are deemed to be "boolean" attributes, and will return either "true" or null:

 <p>async, autofocus, autoplay, checked, compact, complete, controls, declare, defaultchecked, defaultselected, defer, disabled, draggable, ended, formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope, loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open, paused, pubdate, readonly, required, reversed, scoped, seamless, seeking, selected, truespeed, willvalidate

 <p>Finally, the following commonly mis-capitalized attribute/property names are evaluated as expected:

 <ul> <li>If the given name is "class", the "className" property is returned. <li>If the given name is "readonly", the "readOnly" property is returned. </ul>

 <i>Note:</i> The reason for this behavior is that users frequently confuse attributes and properties. If you need to do something more precise, e.g., refer to an attribute even when a property of the same name exists, then you should evaluate Javascript to obtain the result you desire.

### Usage

`
verifyAttributeNotMatch(locator, name, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator
name | The name of the attribute.
text | the value to match with the result

## Verify Checked

Verifies that a toggle-button (checkbox/radio) is checked. When the verify fails, the test will continue execution, logging the failure. Fails if the specified element doesn't exist or isn't a toggle-button.

### Usage

`
verifyChecked(locator)
`

`
verifyChecked(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to a checkbox or radio button

## Verify Date List Order Asc

Returns the text values of the specified elements are sorted in ascending order. The values are assuming to be dates.

### Usage

`
verifyDateListOrderAsc(locator, format)
`

`
verifyDateListOrderAsc(parentLocator, locator, format)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
format | date format to parse

## Verify Date List Order Desc

Returns the text values of the specified elements are sorted in descending order. The values are assuming to be dates.

### Usage

`
verifyDateListOrderDesc(locator, format)
`

`
verifyDateListOrderDesc(parentLocator, locator, format)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
format | date format to parse

## Verify Editable

Verifies that the specified input element is editable, ie hasn't been disabled. When the verify fails, the test will continue execution, logging the failure. This method will fail if the specified element isn't an input element.

### Usage

`
verifyEditable(locator)
`

`
verifyEditable(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Verify Enabled

Verifies that an element is enabled. When the verify fails, the test will continue execution, logging the failure. Fails if the specified element doesn't exist.

### Usage

`
verifyEnabled(locator)
`

`
verifyEnabled(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Verify Eval

Verifies that the result of evaluating the specified snippet equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyEval(expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the snippet to run
text | the value to match with the result

## Verify Exists In Database

Verifies that any row would be returned by given the input SQL statement. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyExistsInDatabase(sql)
`

### Parameters

Parameter | Description
--------- | -----------
sql | the sql

## Verify Expression

Verifies that the specified expression equals to the given value. When the verify fails, the test will continue execution, logging the failure.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
verifyExpression(expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the value to return
text | the value to match with the result

## Verify Expression Match

Verifies that the specified expression matches the given value. When the verify fails, the test will continue execution, logging the failure.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
verifyExpressionMatch(expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the value to return
text | the value to match with the result

## Verify Expression Not Match

Verifies that the specified expression not match the given value. When the verify fails, the test will continue execution, logging the failure.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
verifyExpressionNotMatch(expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the value to return
text | the value to match with the result

## Verify Integer List Order Asc

Returns the text values of the specified elements are sorted in ascending order. The values are assuming to be numbers.

### Usage

`
verifyIntegerListOrderAsc(locator)
`

`
verifyIntegerListOrderAsc(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element

## Verify Integer List Order Desc

Returns the text values of the specified elements are sorted in descending order. The values are assuming to be numbers.

### Usage

`
verifyIntegerListOrderDesc(locator)
`

`
verifyIntegerListOrderDesc(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element

## Verify List Contain

Verifies that the specified text pattern appears in the specified variable list value contains the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyListContain(variable, text)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the variable
text | the text to compare
text | the value to match with the result

## Verify List Not Contain

Verifies that the specified text pattern appears in the specified variable list value not contain the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyListNotContain(variable, text)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the variable
text | the text to compare
text | the value to match with the result

## Verify List Order Asc

Verifies that the specified variable list value is in ascending order.

### Usage

`
verifyListOrderAsc(variable)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the variable

## Verify List Order Desc

Verifies that the specified variable list value is in descending order.

### Usage

`
verifyListOrderDesc(variable)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the variable

## Verify Not Attribute

Verifies that the value of the given attribute of the element not equal to the given value. When the verify fails, the test will continue execution, logging the failure. Will return the current value, even if this has been modified after the page has been loaded.

 <p>More exactly, this method will return the value of the property with the given name, if it exists. If it does not, then the value of the attribute with the given name is returned. If neither exists, null is returned.

 <p>The "style" attribute is converted as best can be to a text representation with a trailing semi-colon.

 <p>The following are deemed to be "boolean" attributes, and will return either "true" or null:

 <p>async, autofocus, autoplay, checked, compact, complete, controls, declare, defaultchecked, defaultselected, defer, disabled, draggable, ended, formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope, loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open, paused, pubdate, readonly, required, reversed, scoped, seamless, seeking, selected, truespeed, willvalidate

 <p>Finally, the following commonly mis-capitalized attribute/property names are evaluated as expected:

 <ul> <li>If the given name is "class", the "className" property is returned. <li>If the given name is "readonly", the "readOnly" property is returned. </ul>

 <i>Note:</i> The reason for this behavior is that users frequently confuse attributes and properties. If you need to do something more precise, e.g., refer to an attribute even when a property of the same name exists, then you should evaluate Javascript to obtain the result you desire.

### Usage

`
verifyNotAttribute(locator, name, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator
name | The name of the attribute.
text | the value to match with the result

## Verify Not Checked

Verifies that a toggle-button (checkbox/radio) is not checked. When the verify fails, the test will continue execution, logging the failure. Fails if the specified element doesn't exist or isn't a toggle-button.

### Usage

`
verifyNotChecked(locator)
`

`
verifyNotChecked(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to a checkbox or radio button

## Verify Not Editable

Verifies that the specified input element is not editable, ie hasn't been disabled. When the verify fails, the test will continue execution, logging the failure. This method will fail if the specified element isn't an input element.

### Usage

`
verifyNotEditable(locator)
`

`
verifyNotEditable(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Verify Not Enabled

Verifies that an element is not enabled. When the verify fails, the test will continue execution, logging the failure. Fails if the specified element doesn't exist.

### Usage

`
verifyNotEnabled(locator)
`

`
verifyNotEnabled(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Verify Not Eval

Verifies that the result of evaluating the specified snippet not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotEval(expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the snippet to run
text | the value to match with the result

## Verify Not Exists In Database

Verifies that any row would be returned by given the input SQL statement. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotExistsInDatabase(sql)
`

### Parameters

Parameter | Description
--------- | -----------
sql | the sql

## Verify Not Expression

Verifies that the specified expression not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
verifyNotExpression(expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the value to return
text | the value to match with the result

## Verify Not Text

Verifies that the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotText(locator, text)
`

`
verifyNotText(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Verify Not Text Empty

Verifies that the text of an element is not empty. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotTextEmpty(locator)
`

`
verifyNotTextEmpty(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Verify Not Value

Verifies that the (whitespace-trimmed) value of an input field (or anything else with a value parameter) not equal to the given value. When the verify fails, the test will continue execution, logging the failure. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
verifyNotValue(locator, text)
`

`
verifyNotValue(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Verify Not Value Empty

Verifies that the (whitespace-trimmed) value of an input field is not empty. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotValueEmpty(locator)
`

`
verifyNotValueEmpty(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Verify Not Variable

Verifies that the specified variable value not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotVariable(variable, text)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the variable
text | the value to match with the result

## Verify Not Visible

Verifies that the specified element is not visible. When the verify fails, the test will continue execution, logging the failure. An element can be rendered invisible by setting the CSS "visibility" property to "hidden", or the "display" property to "none", either for the element itself or one if its ancestors. This method will fail if the element is not present.

### Usage

`
verifyNotVisible(locator)
`

`
verifyNotVisible(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Verify Row Count

Check if the number of rows returned from selectStatement is equal to the value submitted.

### Usage

`
verifyRowCount(sql, count)
`

### Parameters

Parameter | Description
--------- | -----------
sql | the sql
count | the count

## Verify Row Count Greater Than

Check if the number of rows returned from selectStatement is greater than the value submitted.

### Usage

`
verifyRowCountGreaterThan(sql, count)
`

### Parameters

Parameter | Description
--------- | -----------
sql | the sql
count | the count

## Verify Row Count Less Than

Check if the number of rows returned from selectStatement is less than the value submitted.

### Usage

`
verifyRowCountLessThan(sql, count)
`

### Parameters

Parameter | Description
--------- | -----------
sql | the sql
count | the count

## Verify Text

Verifies that the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyText(locator, text)
`

`
verifyText(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Verify Text Empty

Verifies that the text of an element is empty. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTextEmpty(locator)
`

`
verifyTextEmpty(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Verify Text List Order Asc

Returns the text values of the specified elements are sorted in ascending order.

### Usage

`
verifyTextListOrderAsc(locator)
`

`
verifyTextListOrderAsc(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element

## Verify Text List Order Desc

Returns the text values of the specified elements are sorted in descending order.

### Usage

`
verifyTextListOrderDesc(locator)
`

`
verifyTextListOrderDesc(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element

## Verify Text Match

Verifies that the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTextMatch(locator, text)
`

`
verifyTextMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Verify Text Not Match

Verifies that the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTextNotMatch(locator, text)
`

`
verifyTextNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Verify Value

Verifies that the (whitespace-trimmed) value of an input field (or anything else with a value parameter) equals to the given value. When the verify fails, the test will continue execution, logging the failure. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
verifyValue(locator, text)
`

`
verifyValue(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Verify Value Empty

Verifies that the (whitespace-trimmed) value of an input field is empty. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyValueEmpty(locator)
`

`
verifyValueEmpty(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Verify Value Match

Verifies that the (whitespace-trimmed) value of an input field (or anything else with a value parameter) matches the given value. When the verify fails, the test will continue execution, logging the failure. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
verifyValueMatch(locator, text)
`

`
verifyValueMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Verify Value Not Match

Verifies that the (whitespace-trimmed) value of an input field (or anything else with a value parameter) not match the given value. When the verify fails, the test will continue execution, logging the failure. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
verifyValueNotMatch(locator, text)
`

`
verifyValueNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Verify Variable

Verifies that the specified variable value equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyVariable(variable, text)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the variable
text | the value to match with the result

## Verify Visible

Verifies that the specified element is visible. When the verify fails, the test will continue execution, logging the failure. An element can be rendered invisible by setting the CSS "visibility" property to "hidden", or the "display" property to "none", either for the element itself or one if its ancestors. This method will fail if the element is not present.

### Usage

`
verifyVisible(locator)
`

`
verifyVisible(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Wait For All Element Not Present

Waits for all of the specified elements are not present on the page.

### Usage

`
waitForAllElementNotPresent(locatorArray)
`

### Parameters

Parameter | Description
--------- | -----------
locatorArray | array of element locators

## Wait For All Element Present

Waits for all of the specified elements are somewhere on the page.

### Usage

`
waitForAllElementPresent(locatorArray)
`

### Parameters

Parameter | Description
--------- | -----------
locatorArray | array of element locators

## Wait For All Text Not Present

Waits for all of the specified texts are not present on the page.

### Usage

`
waitForAllTextNotPresent(textArray)
`

### Parameters

Parameter | Description
--------- | -----------
textArray | array of texts

## Wait For All Text Present

Waits for all of the specified texts are somewhere on the page.

### Usage

`
waitForAllTextPresent(textArray)
`

### Parameters

Parameter | Description
--------- | -----------
textArray | array of texts

## Wait For Any Element Not Present

Waits for any of the specified elements is not present on the page.

### Usage

`
waitForAnyElementNotPresent(locatorArray)
`

### Parameters

Parameter | Description
--------- | -----------
locatorArray | array of element locators

## Wait For Any Element Present

Waits for any of the specified elements is somewhere on the page.

### Usage

`
waitForAnyElementPresent(locatorArray)
`

### Parameters

Parameter | Description
--------- | -----------
locatorArray | array of element locators

## Wait For Any Text Not Present

Waits for any of the specified texts is not present on the page.

### Usage

`
waitForAnyTextNotPresent(textArray)
`

### Parameters

Parameter | Description
--------- | -----------
textArray | array of texts

## Wait For Any Text Present

Waits for any of the specified texts is somewhere on the page.

### Usage

`
waitForAnyTextPresent(textArray)
`

### Parameters

Parameter | Description
--------- | -----------
textArray | array of texts

## Wait For Attribute

Waits for the value of the given attribute of the element equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. Will return the current value, even if this has been modified after the page has been loaded.

 <p>More exactly, this method will return the value of the property with the given name, if it exists. If it does not, then the value of the attribute with the given name is returned. If neither exists, null is returned.

 <p>The "style" attribute is converted as best can be to a text representation with a trailing semi-colon.

 <p>The following are deemed to be "boolean" attributes, and will return either "true" or null:

 <p>async, autofocus, autoplay, checked, compact, complete, controls, declare, defaultchecked, defaultselected, defer, disabled, draggable, ended, formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope, loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open, paused, pubdate, readonly, required, reversed, scoped, seamless, seeking, selected, truespeed, willvalidate

 <p>Finally, the following commonly mis-capitalized attribute/property names are evaluated as expected:

 <ul> <li>If the given name is "class", the "className" property is returned. <li>If the given name is "readonly", the "readOnly" property is returned. </ul>

 <i>Note:</i> The reason for this behavior is that users frequently confuse attributes and properties. If you need to do something more precise, e.g., refer to an attribute even when a property of the same name exists, then you should evaluate Javascript to obtain the result you desire.

### Usage

`
waitForAttribute(locator, name, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator
name | The name of the attribute.
text | the value to match with the result

## Wait For Attribute Match

Waits for the value of the given attribute of the element matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. Will return the current value, even if this has been modified after the page has been loaded.

 <p>More exactly, this method will return the value of the property with the given name, if it exists. If it does not, then the value of the attribute with the given name is returned. If neither exists, null is returned.

 <p>The "style" attribute is converted as best can be to a text representation with a trailing semi-colon.

 <p>The following are deemed to be "boolean" attributes, and will return either "true" or null:

 <p>async, autofocus, autoplay, checked, compact, complete, controls, declare, defaultchecked, defaultselected, defer, disabled, draggable, ended, formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope, loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open, paused, pubdate, readonly, required, reversed, scoped, seamless, seeking, selected, truespeed, willvalidate

 <p>Finally, the following commonly mis-capitalized attribute/property names are evaluated as expected:

 <ul> <li>If the given name is "class", the "className" property is returned. <li>If the given name is "readonly", the "readOnly" property is returned. </ul>

 <i>Note:</i> The reason for this behavior is that users frequently confuse attributes and properties. If you need to do something more precise, e.g., refer to an attribute even when a property of the same name exists, then you should evaluate Javascript to obtain the result you desire.

### Usage

`
waitForAttributeMatch(locator, name, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator
name | The name of the attribute.
text | the value to match with the result

## Wait For Attribute Not Match

Waits for the value of the given attribute of the element not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. Will return the current value, even if this has been modified after the page has been loaded.

 <p>More exactly, this method will return the value of the property with the given name, if it exists. If it does not, then the value of the attribute with the given name is returned. If neither exists, null is returned.

 <p>The "style" attribute is converted as best can be to a text representation with a trailing semi-colon.

 <p>The following are deemed to be "boolean" attributes, and will return either "true" or null:

 <p>async, autofocus, autoplay, checked, compact, complete, controls, declare, defaultchecked, defaultselected, defer, disabled, draggable, ended, formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope, loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open, paused, pubdate, readonly, required, reversed, scoped, seamless, seeking, selected, truespeed, willvalidate

 <p>Finally, the following commonly mis-capitalized attribute/property names are evaluated as expected:

 <ul> <li>If the given name is "class", the "className" property is returned. <li>If the given name is "readonly", the "readOnly" property is returned. </ul>

 <i>Note:</i> The reason for this behavior is that users frequently confuse attributes and properties. If you need to do something more precise, e.g., refer to an attribute even when a property of the same name exists, then you should evaluate Javascript to obtain the result you desire.

### Usage

`
waitForAttributeNotMatch(locator, name, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator
name | The name of the attribute.
text | the value to match with the result

## Wait For Checked

Waits for a toggle-button (checkbox/radio) is checked. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. Fails if the specified element doesn't exist or isn't a toggle-button.

### Usage

`
waitForChecked(locator)
`

`
waitForChecked(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to a checkbox or radio button

## Wait For Editable

Waits for the specified input element is editable, ie hasn't been disabled. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. This method will fail if the specified element isn't an input element.

### Usage

`
waitForEditable(locator)
`

`
waitForEditable(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Wait For Enabled

Waits for an element is enabled. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. Fails if the specified element doesn't exist.

### Usage

`
waitForEnabled(locator)
`

`
waitForEnabled(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Wait For Eval

Waits for the result of evaluating the specified snippet equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForEval(expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the snippet to run
text | the value to match with the result

## Wait For Exists In Database

Waits for any row would be returned by given the input SQL statement. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForExistsInDatabase(sql)
`

### Parameters

Parameter | Description
--------- | -----------
sql | the sql

## Wait For Expression

Waits for the specified expression equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
waitForExpression(expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the value to return
text | the value to match with the result

## Wait For Expression Match

Waits for the specified expression matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
waitForExpressionMatch(expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the value to return
text | the value to match with the result

## Wait For Expression Not Match

Waits for the specified expression not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
waitForExpressionNotMatch(expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the value to return
text | the value to match with the result

## Wait For Not Attribute

Waits for the value of the given attribute of the element not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. Will return the current value, even if this has been modified after the page has been loaded.

 <p>More exactly, this method will return the value of the property with the given name, if it exists. If it does not, then the value of the attribute with the given name is returned. If neither exists, null is returned.

 <p>The "style" attribute is converted as best can be to a text representation with a trailing semi-colon.

 <p>The following are deemed to be "boolean" attributes, and will return either "true" or null:

 <p>async, autofocus, autoplay, checked, compact, complete, controls, declare, defaultchecked, defaultselected, defer, disabled, draggable, ended, formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope, loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open, paused, pubdate, readonly, required, reversed, scoped, seamless, seeking, selected, truespeed, willvalidate

 <p>Finally, the following commonly mis-capitalized attribute/property names are evaluated as expected:

 <ul> <li>If the given name is "class", the "className" property is returned. <li>If the given name is "readonly", the "readOnly" property is returned. </ul>

 <i>Note:</i> The reason for this behavior is that users frequently confuse attributes and properties. If you need to do something more precise, e.g., refer to an attribute even when a property of the same name exists, then you should evaluate Javascript to obtain the result you desire.

### Usage

`
waitForNotAttribute(locator, name, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator
name | The name of the attribute.
text | the value to match with the result

## Wait For Not Checked

Waits for a toggle-button (checkbox/radio) is not checked. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. Fails if the specified element doesn't exist or isn't a toggle-button.

### Usage

`
waitForNotChecked(locator)
`

`
waitForNotChecked(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to a checkbox or radio button

## Wait For Not Editable

Waits for the specified input element is not editable, ie hasn't been disabled. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. This method will fail if the specified element isn't an input element.

### Usage

`
waitForNotEditable(locator)
`

`
waitForNotEditable(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Wait For Not Enabled

Waits for an element is not enabled. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. Fails if the specified element doesn't exist.

### Usage

`
waitForNotEnabled(locator)
`

`
waitForNotEnabled(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Wait For Not Eval

Waits for the result of evaluating the specified snippet not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotEval(expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the snippet to run
text | the value to match with the result

## Wait For Not Exists In Database

Waits for any row would be returned by given the input SQL statement. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotExistsInDatabase(sql)
`

### Parameters

Parameter | Description
--------- | -----------
sql | the sql

## Wait For Not Expression

Waits for the specified expression not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
waitForNotExpression(expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the value to return
text | the value to match with the result

## Wait For Not Text

Waits for the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotText(locator, text)
`

`
waitForNotText(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Wait For Not Text Empty

Waits for the text of an element is not empty. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotTextEmpty(locator)
`

`
waitForNotTextEmpty(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Wait For Not Value

Waits for the (whitespace-trimmed) value of an input field (or anything else with a value parameter) not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
waitForNotValue(locator, text)
`

`
waitForNotValue(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Wait For Not Value Empty

Waits for the (whitespace-trimmed) value of an input field is not empty. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotValueEmpty(locator)
`

`
waitForNotValueEmpty(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Wait For Not Visible

Waits for the specified element is not visible. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. An element can be rendered invisible by setting the CSS "visibility" property to "hidden", or the "display" property to "none", either for the element itself or one if its ancestors. This method will fail if the element is not present.

### Usage

`
waitForNotVisible(locator)
`

`
waitForNotVisible(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Wait For Text

Waits for the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForText(locator, text)
`

`
waitForText(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Wait For Text Empty

Waits for the text of an element is empty. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForTextEmpty(locator)
`

`
waitForTextEmpty(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Wait For Text Match

Waits for the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForTextMatch(locator, text)
`

`
waitForTextMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Wait For Text Not Match

Waits for the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForTextNotMatch(locator, text)
`

`
waitForTextNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Wait For Value

Waits for the (whitespace-trimmed) value of an input field (or anything else with a value parameter) equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
waitForValue(locator, text)
`

`
waitForValue(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Wait For Value Empty

Waits for the (whitespace-trimmed) value of an input field is empty. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForValueEmpty(locator)
`

`
waitForValueEmpty(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Wait For Value Match

Waits for the (whitespace-trimmed) value of an input field (or anything else with a value parameter) matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
waitForValueMatch(locator, text)
`

`
waitForValueMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Wait For Value Not Match

Waits for the (whitespace-trimmed) value of an input field (or anything else with a value parameter) not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
waitForValueNotMatch(locator, text)
`

`
waitForValueNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Wait For Visible

Waits for the specified element is visible. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. An element can be rendered invisible by setting the CSS "visibility" property to "hidden", or the "display" property to "none", either for the element itself or one if its ancestors. This method will fail if the element is not present.

### Usage

`
waitForVisible(locator)
`

`
waitForVisible(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

