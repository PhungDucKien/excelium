# Mobile API

## Command Table

No | Command | Method | Param 1 | Param 2 | Param 3
--------- | --------- | --------- | --------- | --------- | ---------
1 | Accept Touch ID | acceptTouchID |  |  | 
2 | Activate App | activateApp |  |  | 
3 | Answer Prompt | answerPrompt | answer |  | 
4 | Assert Activity | assertActivity | activity |  | 
5 | Assert Alert | assertAlert | text |  | 
6 | Assert Alert Match | assertAlertMatch | text |  | 
7 | Assert Alert Not Match | assertAlertNotMatch | text |  | 
8 | Assert Alert Not Present | assertAlertNotPresent |  |  | 
9 | Assert Alert Present | assertAlertPresent |  |  | 
10 | Assert Attribute | assertAttribute | locator | name | text
11 | Assert Attribute Match | assertAttributeMatch | locator | name | text
12 | Assert Attribute Not Match | assertAttributeNotMatch | locator | name | text
13 | Assert Checked | assertChecked | locator |  | 
14 | Assert Checked | assertChecked | parentLocator | locator | 
15 | Assert Confirmation | assertConfirmation | text |  | 
16 | Assert Confirmation Match | assertConfirmationMatch | text |  | 
17 | Assert Confirmation Not Match | assertConfirmationNotMatch | text |  | 
18 | Assert Confirmation Not Present | assertConfirmationNotPresent |  |  | 
19 | Assert Confirmation Present | assertConfirmationPresent |  |  | 
20 | Assert Date List Order Asc | assertDateListOrderAsc | locator | format | 
21 | Assert Date List Order Asc | assertDateListOrderAsc | parentLocator | locator | format
22 | Assert Date List Order Desc | assertDateListOrderDesc | locator | format | 
23 | Assert Date List Order Desc | assertDateListOrderDesc | parentLocator | locator | format
24 | Assert Editable | assertEditable | locator |  | 
25 | Assert Editable | assertEditable | parentLocator | locator | 
26 | Assert Element Not Present | assertElementNotPresent | locator |  | 
27 | Assert Element Not Present | assertElementNotPresent | parentLocator | locator | 
28 | Assert Element Present | assertElementPresent | locator |  | 
29 | Assert Element Present | assertElementPresent | parentLocator | locator | 
30 | Assert Enabled | assertEnabled | locator |  | 
31 | Assert Enabled | assertEnabled | parentLocator | locator | 
32 | Assert Eval | assertEval | expression | text | 
33 | Assert Exists In Database | assertExistsInDatabase | sql |  | 
34 | Assert Expression | assertExpression | expression | text | 
35 | Assert Expression Match | assertExpressionMatch | expression | text | 
36 | Assert Expression Not Match | assertExpressionNotMatch | expression | text | 
37 | Assert Integer List Order Asc | assertIntegerListOrderAsc | locator |  | 
38 | Assert Integer List Order Asc | assertIntegerListOrderAsc | parentLocator | locator | 
39 | Assert Integer List Order Desc | assertIntegerListOrderDesc | locator |  | 
40 | Assert Integer List Order Desc | assertIntegerListOrderDesc | parentLocator | locator | 
41 | Assert List Contain | assertListContain | variable | text | 
42 | Assert List Not Contain | assertListNotContain | variable | text | 
43 | Assert List Order Asc | assertListOrderAsc | variable |  | 
44 | Assert List Order Desc | assertListOrderDesc | variable |  | 
45 | Assert Not Activity | assertNotActivity | activity |  | 
46 | Assert Not Alert | assertNotAlert | text |  | 
47 | Assert Not Attribute | assertNotAttribute | locator | name | text
48 | Assert Not Checked | assertNotChecked | locator |  | 
49 | Assert Not Checked | assertNotChecked | parentLocator | locator | 
50 | Assert Not Confirmation | assertNotConfirmation | text |  | 
51 | Assert Not Editable | assertNotEditable | locator |  | 
52 | Assert Not Editable | assertNotEditable | parentLocator | locator | 
53 | Assert Not Enabled | assertNotEnabled | locator |  | 
54 | Assert Not Enabled | assertNotEnabled | parentLocator | locator | 
55 | Assert Not Eval | assertNotEval | expression | text | 
56 | Assert Not Exists In Database | assertNotExistsInDatabase | sql |  | 
57 | Assert Not Expression | assertNotExpression | expression | text | 
58 | Assert Not Page Source | assertNotPageSource | text |  | 
59 | Assert Not Prompt | assertNotPrompt | text |  | 
60 | Assert Not Text | assertNotText | locator | text | 
61 | Assert Not Text | assertNotText | parentLocator | locator | text
62 | Assert Not Text Empty | assertNotTextEmpty | locator |  | 
63 | Assert Not Text Empty | assertNotTextEmpty | parentLocator | locator | 
64 | Assert Not Value | assertNotValue | locator | text | 
65 | Assert Not Value | assertNotValue | parentLocator | locator | text
66 | Assert Not Value Empty | assertNotValueEmpty | locator |  | 
67 | Assert Not Value Empty | assertNotValueEmpty | parentLocator | locator | 
68 | Assert Not Variable | assertNotVariable | variable | text | 
69 | Assert Not Visible | assertNotVisible | locator |  | 
70 | Assert Not Visible | assertNotVisible | parentLocator | locator | 
71 | Assert Page Source | assertPageSource | text |  | 
72 | Assert Page Source Match | assertPageSourceMatch | text |  | 
73 | Assert Page Source Not Match | assertPageSourceNotMatch | text |  | 
74 | Assert Prompt | assertPrompt | text |  | 
75 | Assert Prompt Match | assertPromptMatch | text |  | 
76 | Assert Prompt Not Match | assertPromptNotMatch | text |  | 
77 | Assert Prompt Not Present | assertPromptNotPresent |  |  | 
78 | Assert Prompt Present | assertPromptPresent |  |  | 
79 | Assert Row Count | assertRowCount | sql | count | 
80 | Assert Row Count Greater Than | assertRowCountGreaterThan | sql | count | 
81 | Assert Row Count Less Than | assertRowCountLessThan | sql | count | 
82 | Assert Text | assertText | locator | text | 
83 | Assert Text | assertText | parentLocator | locator | text
84 | Assert Text Empty | assertTextEmpty | locator |  | 
85 | Assert Text Empty | assertTextEmpty | parentLocator | locator | 
86 | Assert Text List Order Asc | assertTextListOrderAsc | locator |  | 
87 | Assert Text List Order Asc | assertTextListOrderAsc | parentLocator | locator | 
88 | Assert Text List Order Desc | assertTextListOrderDesc | locator |  | 
89 | Assert Text List Order Desc | assertTextListOrderDesc | parentLocator | locator | 
90 | Assert Text Match | assertTextMatch | locator | text | 
91 | Assert Text Match | assertTextMatch | parentLocator | locator | text
92 | Assert Text Not Match | assertTextNotMatch | locator | text | 
93 | Assert Text Not Match | assertTextNotMatch | parentLocator | locator | text
94 | Assert Text Not Present | assertTextNotPresent | text |  | 
95 | Assert Text Present | assertTextPresent | text |  | 
96 | Assert Value | assertValue | locator | text | 
97 | Assert Value | assertValue | parentLocator | locator | text
98 | Assert Value Empty | assertValueEmpty | locator |  | 
99 | Assert Value Empty | assertValueEmpty | parentLocator | locator | 
100 | Assert Value Match | assertValueMatch | locator | text | 
101 | Assert Value Match | assertValueMatch | parentLocator | locator | text
102 | Assert Value Not Match | assertValueNotMatch | locator | text | 
103 | Assert Value Not Match | assertValueNotMatch | parentLocator | locator | text
104 | Assert Variable | assertVariable | variable | text | 
105 | Assert Visible | assertVisible | locator |  | 
106 | Assert Visible | assertVisible | parentLocator | locator | 
107 | Broadcast Intent | broadcastIntent | intent |  | 
108 | Capture Screenshot | captureScreenshot |  |  | 
109 | Capture Viewport | captureViewport |  |  | 
110 | Choose Cancel Confirmation | chooseCancelConfirmation |  |  | 
111 | Choose Cancel Prompt | chooseCancelPrompt |  |  | 
112 | Choose Ok Alert | chooseOkAlert |  |  | 
113 | Choose Ok Confirmation | chooseOkConfirmation |  |  | 
114 | Clear | clear | locator |  | 
115 | Clear | clear | parentLocator | locator | 
116 | Click | click | locator |  | 
117 | Click | click | parentLocator | locator | 
118 | Click Button | clickButton | indexOrText |  | 
119 | Click Text | clickText | indexOrText |  | 
120 | Close App | closeApp |  |  | 
121 | Double Tap | doubleTap | locator |  | 
122 | Double Tap | doubleTap | parentLocator | locator | 
123 | Double Tap At | doubleTapAt | coordinate |  | 
124 | Echo | echo | message |  | 
125 | Execute | execute | action |  | 
126 | Execute Each | executeEach | action | locator | variable
127 | Execute If Activity | executeIfActivity | action | activity | 
128 | Execute If Alert | executeIfAlert | action | text | 
129 | Execute If Alert Match | executeIfAlertMatch | action | text | 
130 | Execute If Alert Not Match | executeIfAlertNotMatch | action | text | 
131 | Execute If Alert Not Present | executeIfAlertNotPresent | action |  | 
132 | Execute If Alert Present | executeIfAlertPresent | action |  | 
133 | Execute If Checked | executeIfChecked | action | locator | 
134 | Execute If Checked | executeIfChecked | action | parentLocator | locator
135 | Execute If Confirmation | executeIfConfirmation | action | text | 
136 | Execute If Confirmation Match | executeIfConfirmationMatch | action | text | 
137 | Execute If Confirmation Not Match | executeIfConfirmationNotMatch | action | text | 
138 | Execute If Confirmation Not Present | executeIfConfirmationNotPresent | action |  | 
139 | Execute If Confirmation Present | executeIfConfirmationPresent | action |  | 
140 | Execute If Editable | executeIfEditable | action | locator | 
141 | Execute If Editable | executeIfEditable | action | parentLocator | locator
142 | Execute If Element Not Present | executeIfElementNotPresent | action | locator | 
143 | Execute If Element Not Present | executeIfElementNotPresent | action | parentLocator | locator
144 | Execute If Element Present | executeIfElementPresent | action | locator | 
145 | Execute If Element Present | executeIfElementPresent | action | parentLocator | locator
146 | Execute If Enabled | executeIfEnabled | action | locator | 
147 | Execute If Enabled | executeIfEnabled | action | parentLocator | locator
148 | Execute If Eval | executeIfEval | action | expression | text
149 | Execute If Exists In Database | executeIfExistsInDatabase | action | sql | 
150 | Execute If Expression | executeIfExpression | action | expression | text
151 | Execute If Expression Match | executeIfExpressionMatch | action | expression | text
152 | Execute If Expression Not Match | executeIfExpressionNotMatch | action | expression | text
153 | Execute If List Contain | executeIfListContain | action | variable | text
154 | Execute If List Not Contain | executeIfListNotContain | action | variable | text
155 | Execute If Not Activity | executeIfNotActivity | action | activity | 
156 | Execute If Not Alert | executeIfNotAlert | action | text | 
157 | Execute If Not Checked | executeIfNotChecked | action | locator | 
158 | Execute If Not Checked | executeIfNotChecked | action | parentLocator | locator
159 | Execute If Not Confirmation | executeIfNotConfirmation | action | text | 
160 | Execute If Not Editable | executeIfNotEditable | action | locator | 
161 | Execute If Not Editable | executeIfNotEditable | action | parentLocator | locator
162 | Execute If Not Enabled | executeIfNotEnabled | action | locator | 
163 | Execute If Not Enabled | executeIfNotEnabled | action | parentLocator | locator
164 | Execute If Not Eval | executeIfNotEval | action | expression | text
165 | Execute If Not Exists In Database | executeIfNotExistsInDatabase | action | sql | 
166 | Execute If Not Expression | executeIfNotExpression | action | expression | text
167 | Execute If Not Page Source | executeIfNotPageSource | action | text | 
168 | Execute If Not Prompt | executeIfNotPrompt | action | text | 
169 | Execute If Not Text | executeIfNotText | action | locator | text
170 | Execute If Not Text Empty | executeIfNotTextEmpty | action | locator | 
171 | Execute If Not Text Empty | executeIfNotTextEmpty | action | parentLocator | locator
172 | Execute If Not Value | executeIfNotValue | action | locator | text
173 | Execute If Not Value Empty | executeIfNotValueEmpty | action | locator | 
174 | Execute If Not Value Empty | executeIfNotValueEmpty | action | parentLocator | locator
175 | Execute If Not Variable | executeIfNotVariable | action | variable | text
176 | Execute If Not Visible | executeIfNotVisible | action | locator | 
177 | Execute If Not Visible | executeIfNotVisible | action | parentLocator | locator
178 | Execute If Page Source | executeIfPageSource | action | text | 
179 | Execute If Page Source Match | executeIfPageSourceMatch | action | text | 
180 | Execute If Page Source Not Match | executeIfPageSourceNotMatch | action | text | 
181 | Execute If Prompt | executeIfPrompt | action | text | 
182 | Execute If Prompt Match | executeIfPromptMatch | action | text | 
183 | Execute If Prompt Not Match | executeIfPromptNotMatch | action | text | 
184 | Execute If Prompt Not Present | executeIfPromptNotPresent | action |  | 
185 | Execute If Prompt Present | executeIfPromptPresent | action |  | 
186 | Execute If Text | executeIfText | action | locator | text
187 | Execute If Text Empty | executeIfTextEmpty | action | locator | 
188 | Execute If Text Empty | executeIfTextEmpty | action | parentLocator | locator
189 | Execute If Text Match | executeIfTextMatch | action | locator | text
190 | Execute If Text Not Match | executeIfTextNotMatch | action | locator | text
191 | Execute If Text Not Present | executeIfTextNotPresent | action | text | 
192 | Execute If Text Present | executeIfTextPresent | action | text | 
193 | Execute If Value | executeIfValue | action | locator | text
194 | Execute If Value Empty | executeIfValueEmpty | action | locator | 
195 | Execute If Value Empty | executeIfValueEmpty | action | parentLocator | locator
196 | Execute If Value Match | executeIfValueMatch | action | locator | text
197 | Execute If Value Not Match | executeIfValueNotMatch | action | locator | text
198 | Execute If Variable | executeIfVariable | action | variable | text
199 | Execute If Visible | executeIfVisible | action | locator | 
200 | Execute If Visible | executeIfVisible | action | parentLocator | locator
201 | Execute Loop | executeLoop | action | times | 
202 | Finger Print | fingerPrint |  |  | 
203 | Go Back | goBack |  |  | 
204 | Hide Keyboard | hideKeyboard |  |  | 
205 | Landscape | landscape |  |  | 
206 | Launch App | launchApp |  |  | 
207 | Lock | lock |  |  | 
208 | Long Press | longPress | locator |  | 
209 | Long Press | longPress | parentLocator | locator | 
210 | Long Press At | longPressAt | coordinate |  | 
211 | Open Notifications | openNotifications |  |  | 
212 | Pause | pause | waitTime |  | 
213 | Portrait | portrait |  |  | 
214 | Reject Touch ID | rejectTouchID |  |  | 
215 | Reload App | reloadApp |  |  | 
216 | Reset App | resetApp |  |  | 
217 | Rotate | rotate |  |  | 
218 | Run App In Background | runAppInBackground | millis |  | 
219 | Scroll Down To | scrollDownTo | locator |  | 
220 | Scroll Down To | scrollDownTo | parentLocator | locator | 
221 | Scroll Up To | scrollUpTo | locator |  | 
222 | Scroll Up To | scrollUpTo | parentLocator | locator | 
223 | Set Clipboard | setClipboard |  |  | 
224 | Set Geolocation | setGeolocation |  |  | 
225 | Set Timeout | setTimeout | timeout |  | 
226 | Shake | shake |  |  | 
227 | Start Activity | startActivity | activity |  | 
228 | Store | store | text | variable | 
229 | Store Alert | storeAlert | variable |  | 
230 | Store Attribute | storeAttribute | locator | name | variable
231 | Store Confirmation | storeConfirmation | variable |  | 
232 | Store Current Date | storeCurrentDate | variable |  | 
233 | Store Eval | storeEval | expression | variable | 
234 | Store Expression | storeExpression | expression | variable | 
235 | Store Page Source | storePageSource | variable |  | 
236 | Store Prompt | storePrompt | variable |  | 
237 | Store Push | storePush | text | variable | 
238 | Store Text | storeText | locator | variable | 
239 | Store Text | storeText | parentLocator | locator | variable
240 | Store Value | storeValue | locator | variable | 
241 | Store Value | storeValue | parentLocator | locator | variable
242 | Swipe Left | swipeLeft |  |  | 
243 | Swipe Right | swipeRight |  |  | 
244 | Tap | tap | locator |  | 
245 | Tap | tap | parentLocator | locator | 
246 | Tap At | tapAt | coordinate |  | 
247 | Terminate App | terminateApp |  |  | 
248 | Toggle Airplane Mode | toggleAirplaneMode |  |  | 
249 | Toggle Location Services | toggleLocationServices |  |  | 
250 | Toggle Wifi | toggleWifi |  |  | 
251 | Type | type | locator | value | 
252 | Type | type | parentLocator | locator | value
253 | Unlock | unlock |  |  | 
254 | Verify Activity | verifyActivity | activity |  | 
255 | Verify Alert | verifyAlert | text |  | 
256 | Verify Alert Match | verifyAlertMatch | text |  | 
257 | Verify Alert Not Match | verifyAlertNotMatch | text |  | 
258 | Verify Alert Not Present | verifyAlertNotPresent |  |  | 
259 | Verify Alert Present | verifyAlertPresent |  |  | 
260 | Verify Attribute | verifyAttribute | locator | name | text
261 | Verify Attribute Match | verifyAttributeMatch | locator | name | text
262 | Verify Attribute Not Match | verifyAttributeNotMatch | locator | name | text
263 | Verify Checked | verifyChecked | locator |  | 
264 | Verify Checked | verifyChecked | parentLocator | locator | 
265 | Verify Confirmation | verifyConfirmation | text |  | 
266 | Verify Confirmation Match | verifyConfirmationMatch | text |  | 
267 | Verify Confirmation Not Match | verifyConfirmationNotMatch | text |  | 
268 | Verify Confirmation Not Present | verifyConfirmationNotPresent |  |  | 
269 | Verify Confirmation Present | verifyConfirmationPresent |  |  | 
270 | Verify Date List Order Asc | verifyDateListOrderAsc | locator | format | 
271 | Verify Date List Order Asc | verifyDateListOrderAsc | parentLocator | locator | format
272 | Verify Date List Order Desc | verifyDateListOrderDesc | locator | format | 
273 | Verify Date List Order Desc | verifyDateListOrderDesc | parentLocator | locator | format
274 | Verify Editable | verifyEditable | locator |  | 
275 | Verify Editable | verifyEditable | parentLocator | locator | 
276 | Verify Element Not Present | verifyElementNotPresent | locator |  | 
277 | Verify Element Not Present | verifyElementNotPresent | parentLocator | locator | 
278 | Verify Element Present | verifyElementPresent | locator |  | 
279 | Verify Element Present | verifyElementPresent | parentLocator | locator | 
280 | Verify Enabled | verifyEnabled | locator |  | 
281 | Verify Enabled | verifyEnabled | parentLocator | locator | 
282 | Verify Eval | verifyEval | expression | text | 
283 | Verify Exists In Database | verifyExistsInDatabase | sql |  | 
284 | Verify Expression | verifyExpression | expression | text | 
285 | Verify Expression Match | verifyExpressionMatch | expression | text | 
286 | Verify Expression Not Match | verifyExpressionNotMatch | expression | text | 
287 | Verify Integer List Order Asc | verifyIntegerListOrderAsc | locator |  | 
288 | Verify Integer List Order Asc | verifyIntegerListOrderAsc | parentLocator | locator | 
289 | Verify Integer List Order Desc | verifyIntegerListOrderDesc | locator |  | 
290 | Verify Integer List Order Desc | verifyIntegerListOrderDesc | parentLocator | locator | 
291 | Verify List Contain | verifyListContain | variable | text | 
292 | Verify List Not Contain | verifyListNotContain | variable | text | 
293 | Verify List Order Asc | verifyListOrderAsc | variable |  | 
294 | Verify List Order Desc | verifyListOrderDesc | variable |  | 
295 | Verify Not Activity | verifyNotActivity | activity |  | 
296 | Verify Not Alert | verifyNotAlert | text |  | 
297 | Verify Not Attribute | verifyNotAttribute | locator | name | text
298 | Verify Not Checked | verifyNotChecked | locator |  | 
299 | Verify Not Checked | verifyNotChecked | parentLocator | locator | 
300 | Verify Not Confirmation | verifyNotConfirmation | text |  | 
301 | Verify Not Editable | verifyNotEditable | locator |  | 
302 | Verify Not Editable | verifyNotEditable | parentLocator | locator | 
303 | Verify Not Enabled | verifyNotEnabled | locator |  | 
304 | Verify Not Enabled | verifyNotEnabled | parentLocator | locator | 
305 | Verify Not Eval | verifyNotEval | expression | text | 
306 | Verify Not Exists In Database | verifyNotExistsInDatabase | sql |  | 
307 | Verify Not Expression | verifyNotExpression | expression | text | 
308 | Verify Not Page Source | verifyNotPageSource | text |  | 
309 | Verify Not Prompt | verifyNotPrompt | text |  | 
310 | Verify Not Text | verifyNotText | locator | text | 
311 | Verify Not Text | verifyNotText | parentLocator | locator | text
312 | Verify Not Text Empty | verifyNotTextEmpty | locator |  | 
313 | Verify Not Text Empty | verifyNotTextEmpty | parentLocator | locator | 
314 | Verify Not Value | verifyNotValue | locator | text | 
315 | Verify Not Value | verifyNotValue | parentLocator | locator | text
316 | Verify Not Value Empty | verifyNotValueEmpty | locator |  | 
317 | Verify Not Value Empty | verifyNotValueEmpty | parentLocator | locator | 
318 | Verify Not Variable | verifyNotVariable | variable | text | 
319 | Verify Not Visible | verifyNotVisible | locator |  | 
320 | Verify Not Visible | verifyNotVisible | parentLocator | locator | 
321 | Verify Page Source | verifyPageSource | text |  | 
322 | Verify Page Source Match | verifyPageSourceMatch | text |  | 
323 | Verify Page Source Not Match | verifyPageSourceNotMatch | text |  | 
324 | Verify Prompt | verifyPrompt | text |  | 
325 | Verify Prompt Match | verifyPromptMatch | text |  | 
326 | Verify Prompt Not Match | verifyPromptNotMatch | text |  | 
327 | Verify Prompt Not Present | verifyPromptNotPresent |  |  | 
328 | Verify Prompt Present | verifyPromptPresent |  |  | 
329 | Verify Row Count | verifyRowCount | sql | count | 
330 | Verify Row Count Greater Than | verifyRowCountGreaterThan | sql | count | 
331 | Verify Row Count Less Than | verifyRowCountLessThan | sql | count | 
332 | Verify Text | verifyText | locator | text | 
333 | Verify Text | verifyText | parentLocator | locator | text
334 | Verify Text Empty | verifyTextEmpty | locator |  | 
335 | Verify Text Empty | verifyTextEmpty | parentLocator | locator | 
336 | Verify Text List Order Asc | verifyTextListOrderAsc | locator |  | 
337 | Verify Text List Order Asc | verifyTextListOrderAsc | parentLocator | locator | 
338 | Verify Text List Order Desc | verifyTextListOrderDesc | locator |  | 
339 | Verify Text List Order Desc | verifyTextListOrderDesc | parentLocator | locator | 
340 | Verify Text Match | verifyTextMatch | locator | text | 
341 | Verify Text Match | verifyTextMatch | parentLocator | locator | text
342 | Verify Text Not Match | verifyTextNotMatch | locator | text | 
343 | Verify Text Not Match | verifyTextNotMatch | parentLocator | locator | text
344 | Verify Text Not Present | verifyTextNotPresent | text |  | 
345 | Verify Text Present | verifyTextPresent | text |  | 
346 | Verify Value | verifyValue | locator | text | 
347 | Verify Value | verifyValue | parentLocator | locator | text
348 | Verify Value Empty | verifyValueEmpty | locator |  | 
349 | Verify Value Empty | verifyValueEmpty | parentLocator | locator | 
350 | Verify Value Match | verifyValueMatch | locator | text | 
351 | Verify Value Match | verifyValueMatch | parentLocator | locator | text
352 | Verify Value Not Match | verifyValueNotMatch | locator | text | 
353 | Verify Value Not Match | verifyValueNotMatch | parentLocator | locator | text
354 | Verify Variable | verifyVariable | variable | text | 
355 | Verify Visible | verifyVisible | locator |  | 
356 | Verify Visible | verifyVisible | parentLocator | locator | 
357 | Wait For Activity | waitForActivity | activity |  | 
358 | Wait For Alert | waitForAlert | text |  | 
359 | Wait For Alert Match | waitForAlertMatch | text |  | 
360 | Wait For Alert Not Match | waitForAlertNotMatch | text |  | 
361 | Wait For Alert Not Present | waitForAlertNotPresent |  |  | 
362 | Wait For Alert Present | waitForAlertPresent |  |  | 
363 | Wait For All Element Not Present | waitForAllElementNotPresent | locatorArray |  | 
364 | Wait For All Element Present | waitForAllElementPresent | locatorArray |  | 
365 | Wait For All Text Not Present | waitForAllTextNotPresent | textArray |  | 
366 | Wait For All Text Present | waitForAllTextPresent | textArray |  | 
367 | Wait For Any Element Not Present | waitForAnyElementNotPresent | locatorArray |  | 
368 | Wait For Any Element Present | waitForAnyElementPresent | locatorArray |  | 
369 | Wait For Any Text Not Present | waitForAnyTextNotPresent | textArray |  | 
370 | Wait For Any Text Present | waitForAnyTextPresent | textArray |  | 
371 | Wait For Attribute | waitForAttribute | locator | name | text
372 | Wait For Attribute Match | waitForAttributeMatch | locator | name | text
373 | Wait For Attribute Not Match | waitForAttributeNotMatch | locator | name | text
374 | Wait For Checked | waitForChecked | locator |  | 
375 | Wait For Checked | waitForChecked | parentLocator | locator | 
376 | Wait For Confirmation | waitForConfirmation | text |  | 
377 | Wait For Confirmation Match | waitForConfirmationMatch | text |  | 
378 | Wait For Confirmation Not Match | waitForConfirmationNotMatch | text |  | 
379 | Wait For Confirmation Not Present | waitForConfirmationNotPresent |  |  | 
380 | Wait For Confirmation Present | waitForConfirmationPresent |  |  | 
381 | Wait For Editable | waitForEditable | locator |  | 
382 | Wait For Editable | waitForEditable | parentLocator | locator | 
383 | Wait For Element Not Present | waitForElementNotPresent | locator |  | 
384 | Wait For Element Not Present | waitForElementNotPresent | parentLocator | locator | 
385 | Wait For Element Present | waitForElementPresent | locator |  | 
386 | Wait For Element Present | waitForElementPresent | parentLocator | locator | 
387 | Wait For Enabled | waitForEnabled | locator |  | 
388 | Wait For Enabled | waitForEnabled | parentLocator | locator | 
389 | Wait For Eval | waitForEval | expression | text | 
390 | Wait For Exists In Database | waitForExistsInDatabase | sql |  | 
391 | Wait For Expression | waitForExpression | expression | text | 
392 | Wait For Expression Match | waitForExpressionMatch | expression | text | 
393 | Wait For Expression Not Match | waitForExpressionNotMatch | expression | text | 
394 | Wait For Not Activity | waitForNotActivity | activity |  | 
395 | Wait For Not Alert | waitForNotAlert | text |  | 
396 | Wait For Not Attribute | waitForNotAttribute | locator | name | text
397 | Wait For Not Checked | waitForNotChecked | locator |  | 
398 | Wait For Not Checked | waitForNotChecked | parentLocator | locator | 
399 | Wait For Not Confirmation | waitForNotConfirmation | text |  | 
400 | Wait For Not Editable | waitForNotEditable | locator |  | 
401 | Wait For Not Editable | waitForNotEditable | parentLocator | locator | 
402 | Wait For Not Enabled | waitForNotEnabled | locator |  | 
403 | Wait For Not Enabled | waitForNotEnabled | parentLocator | locator | 
404 | Wait For Not Eval | waitForNotEval | expression | text | 
405 | Wait For Not Exists In Database | waitForNotExistsInDatabase | sql |  | 
406 | Wait For Not Expression | waitForNotExpression | expression | text | 
407 | Wait For Not Page Source | waitForNotPageSource | text |  | 
408 | Wait For Not Prompt | waitForNotPrompt | text |  | 
409 | Wait For Not Text | waitForNotText | locator | text | 
410 | Wait For Not Text | waitForNotText | parentLocator | locator | text
411 | Wait For Not Text Empty | waitForNotTextEmpty | locator |  | 
412 | Wait For Not Text Empty | waitForNotTextEmpty | parentLocator | locator | 
413 | Wait For Not Value | waitForNotValue | locator | text | 
414 | Wait For Not Value | waitForNotValue | parentLocator | locator | text
415 | Wait For Not Value Empty | waitForNotValueEmpty | locator |  | 
416 | Wait For Not Value Empty | waitForNotValueEmpty | parentLocator | locator | 
417 | Wait For Not Visible | waitForNotVisible | locator |  | 
418 | Wait For Not Visible | waitForNotVisible | parentLocator | locator | 
419 | Wait For Page Source | waitForPageSource | text |  | 
420 | Wait For Page Source Match | waitForPageSourceMatch | text |  | 
421 | Wait For Page Source Not Match | waitForPageSourceNotMatch | text |  | 
422 | Wait For Prompt | waitForPrompt | text |  | 
423 | Wait For Prompt Match | waitForPromptMatch | text |  | 
424 | Wait For Prompt Not Match | waitForPromptNotMatch | text |  | 
425 | Wait For Prompt Not Present | waitForPromptNotPresent |  |  | 
426 | Wait For Prompt Present | waitForPromptPresent |  |  | 
427 | Wait For Text | waitForText | locator | text | 
428 | Wait For Text | waitForText | parentLocator | locator | text
429 | Wait For Text Empty | waitForTextEmpty | locator |  | 
430 | Wait For Text Empty | waitForTextEmpty | parentLocator | locator | 
431 | Wait For Text Match | waitForTextMatch | locator | text | 
432 | Wait For Text Match | waitForTextMatch | parentLocator | locator | text
433 | Wait For Text Not Match | waitForTextNotMatch | locator | text | 
434 | Wait For Text Not Match | waitForTextNotMatch | parentLocator | locator | text
435 | Wait For Text Not Present | waitForTextNotPresent | text |  | 
436 | Wait For Text Present | waitForTextPresent | text |  | 
437 | Wait For Value | waitForValue | locator | text | 
438 | Wait For Value | waitForValue | parentLocator | locator | text
439 | Wait For Value Empty | waitForValueEmpty | locator |  | 
440 | Wait For Value Empty | waitForValueEmpty | parentLocator | locator | 
441 | Wait For Value Match | waitForValueMatch | locator | text | 
442 | Wait For Value Match | waitForValueMatch | parentLocator | locator | text
443 | Wait For Value Not Match | waitForValueNotMatch | locator | text | 
444 | Wait For Value Not Match | waitForValueNotMatch | parentLocator | locator | text
445 | Wait For Visible | waitForVisible | locator |  | 
446 | Wait For Visible | waitForVisible | parentLocator | locator | 

## Accept Touch ID

Simulate an accept touch id event (iOS Simulator only)

### Usage

`
acceptTouchID()
`

### Parameters

Parameter | Description
--------- | -----------

## Activate App

Activate the given app onto the device.

### Usage

`
activateApp()
`

### Parameters

Parameter | Description
--------- | -----------
bundleId | the bundle identifier (or app id) of the app to activate.

## Answer Prompt

Instructs Selenium to return the specified answer string in response to the JavaScript prompt [window.prompt()].

### Usage

`
answerPrompt(answer)
`

### Parameters

Parameter | Description
--------- | -----------
answer | the answer to give in response to the prompt pop-up

## Assert Activity

Asserts that the current activity matches the given activity. When the assert fails, the test is aborted. The activity is identified by a string separated by a comma, containing "appPackage" and "appActivity" properties. For example: appPackage=example,appActivity=example

### Usage

`
assertActivity(activity)
`

### Parameters

Parameter | Description
--------- | -----------
activity | the given activity

## Assert Alert

Asserts that the message of a JavaScript alert equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertAlert(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Alert Match

Asserts that the message of a JavaScript alert matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertAlertMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Alert Not Match

Asserts that the message of a JavaScript alert not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertAlertNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Alert Not Present

Asserts that an alert dialog is not present. When the assert fails, the test is aborted.

 <p> This function never throws an exception </p>

### Usage

`
assertAlertNotPresent()
`

### Parameters

Parameter | Description
--------- | -----------

## Assert Alert Present

Asserts that an alert dialog is present. When the assert fails, the test is aborted.

 <p> This function never throws an exception </p>

### Usage

`
assertAlertPresent()
`

### Parameters

Parameter | Description
--------- | -----------

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

## Assert Confirmation

Asserts that the message of a JavaScript confirmation dialog equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertConfirmation(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Confirmation Match

Asserts that the message of a JavaScript confirmation dialog matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertConfirmationMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Confirmation Not Match

Asserts that the message of a JavaScript confirmation dialog not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertConfirmationNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Confirmation Not Present

Asserts that a confirmation dialog is not present. When the assert fails, the test is aborted.

 <p> This function never throws an exception </p>

### Usage

`
assertConfirmationNotPresent()
`

### Parameters

Parameter | Description
--------- | -----------

## Assert Confirmation Present

Asserts that a confirmation dialog is present. When the assert fails, the test is aborted.

 <p> This function never throws an exception </p>

### Usage

`
assertConfirmationPresent()
`

### Parameters

Parameter | Description
--------- | -----------

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

## Assert Element Not Present

Asserts that the specified element is not somewhere on the page. When the assert fails, the test is aborted.

### Usage

`
assertElementNotPresent(locator)
`

`
assertElementNotPresent(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Assert Element Present

Asserts that the specified element is somewhere on the page. When the assert fails, the test is aborted.

### Usage

`
assertElementPresent(locator)
`

`
assertElementPresent(parentLocator, locator)
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

## Assert Not Activity

Asserts that the current activity matches the given activity. When the assert fails, the test is aborted. The activity is identified by a string separated by a comma, containing "appPackage" and "appActivity" properties. For example: appPackage=example,appActivity=example

### Usage

`
assertNotActivity(activity)
`

### Parameters

Parameter | Description
--------- | -----------
activity | the given activity

## Assert Not Alert

Asserts that the message of a JavaScript alert not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotAlert(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

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

## Assert Not Confirmation

Asserts that the message of a JavaScript confirmation dialog not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotConfirmation(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

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

## Assert Not Page Source

Asserts that the current application hierarchy XML (app) or page source (web). <p> In a web context, the source returns the source HTML of the current window. In a native context (iOS, Android, etc...) it will return the application hierarchy XML not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotPageSource(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Not Prompt

Asserts that the message of a JavaScript question prompt dialog not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotPrompt(text)
`

### Parameters

Parameter | Description
--------- | -----------
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

## Assert Page Source

Asserts that the current application hierarchy XML (app) or page source (web). <p> In a web context, the source returns the source HTML of the current window. In a native context (iOS, Android, etc...) it will return the application hierarchy XML equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertPageSource(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Page Source Match

Asserts that the current application hierarchy XML (app) or page source (web). <p> In a web context, the source returns the source HTML of the current window. In a native context (iOS, Android, etc...) it will return the application hierarchy XML matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertPageSourceMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Page Source Not Match

Asserts that the current application hierarchy XML (app) or page source (web). <p> In a web context, the source returns the source HTML of the current window. In a native context (iOS, Android, etc...) it will return the application hierarchy XML not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertPageSourceNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Prompt

Asserts that the message of a JavaScript question prompt dialog equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertPrompt(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Prompt Match

Asserts that the message of a JavaScript question prompt dialog matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertPromptMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Prompt Not Match

Asserts that the message of a JavaScript question prompt dialog not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertPromptNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Prompt Not Present

Asserts that a prompt dialog is not present. When the assert fails, the test is aborted.

 <p> This function never throws an exception </p>

### Usage

`
assertPromptNotPresent()
`

### Parameters

Parameter | Description
--------- | -----------

## Assert Prompt Present

Asserts that a prompt dialog is present. When the assert fails, the test is aborted.

 <p> This function never throws an exception </p>

### Usage

`
assertPromptPresent()
`

### Parameters

Parameter | Description
--------- | -----------

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

## Assert Text Not Present

Asserts that the specified text appears somewhere on the page not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertTextNotPresent(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | a text to match with the text of the page
text | the value to match with the result

## Assert Text Present

Asserts that the specified text appears somewhere on the page equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertTextPresent(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | a text to match with the text of the page
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

## Broadcast Intent

Broadcast an Android Intent.

### Usage

`
broadcastIntent(intent)
`

### Parameters

Parameter | Description
--------- | -----------
intent | Android Intent

## Capture Screenshot

Captures full screenshot.

### Usage

`
captureScreenshot()
`

### Parameters

Parameter | Description
--------- | -----------

## Capture Viewport

Captures viewport screenshot.

### Usage

`
captureViewport()
`

### Parameters

Parameter | Description
--------- | -----------

## Choose Cancel Confirmation

Simulates as if the user had manually clicked Cancel.

### Usage

`
chooseCancelConfirmation()
`

### Parameters

Parameter | Description
--------- | -----------

## Choose Cancel Prompt

Simulates as if the user had manually clicked Cancel.

### Usage

`
chooseCancelPrompt()
`

### Parameters

Parameter | Description
--------- | -----------

## Choose Ok Alert

Simulates as if the user had manually clicked OK.

### Usage

`
chooseOkAlert()
`

### Parameters

Parameter | Description
--------- | -----------

## Choose Ok Confirmation

Simulates as if the user had manually clicked OK.

### Usage

`
chooseOkConfirmation()
`

### Parameters

Parameter | Description
--------- | -----------

## Clear

Clear an element's value

### Usage

`
clear(locator)
`

`
clear(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Click

Click element at its center point. <p> If the element's center point is obscured by another element, an element click intercepted error is returned. If the element is outside the viewport, an element not interactable error is returned. Not all drivers automatically scroll the element into view and may need to be scrolled to in order to interact with it.

### Usage

`
click(locator)
`

`
click(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Click Button

Click a button with the given text at its center point. <p> If the element's center point is obscured by another element, an element click intercepted error is returned. If the element is outside the viewport, an element not interactable error is returned. Not all drivers automatically scroll the element into view and may need to be scrolled to in order to interact with it.

### Usage

`
clickButton(indexOrText)
`

### Parameters

Parameter | Description
--------- | -----------
indexOrText | an index or a text to find

## Click Text

Click a text label with the given text at its center point. <p> If the element's center point is obscured by another element, an element click intercepted error is returned. If the element is outside the viewport, an element not interactable error is returned. Not all drivers automatically scroll the element into view and may need to be scrolled to in order to interact with it.

### Usage

`
clickText(indexOrText)
`

### Parameters

Parameter | Description
--------- | -----------
indexOrText | an index or a text to find

## Close App

Close an app on device.

### Usage

`
closeApp()
`

### Parameters

Parameter | Description
--------- | -----------

## Double Tap

Double tap on the touch screen using finger motion events

### Usage

`
doubleTap(locator)
`

`
doubleTap(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Double Tap At

Double tap at a specified position on the touch enabled device

### Usage

`
doubleTapAt(coordinate)
`

### Parameters

Parameter | Description
--------- | -----------
coordinate | a string represents a position of x and y

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

## Execute If Activity

Executes an action if the current activity matches the given activity. The activity is identified by a string separated by a comma, containing "appPackage" and "appActivity" properties. For example: appPackage=example,appActivity=example

### Usage

`
executeIfActivity(action, activity)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
activity | the given activity

## Execute If Alert

Executes an action if the message of a JavaScript alert equals to the given value.

### Usage

`
executeIfAlert(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Alert Match

Executes an action if the message of a JavaScript alert matches the given value.

### Usage

`
executeIfAlertMatch(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Alert Not Match

Executes an action if the message of a JavaScript alert not match the given value.

### Usage

`
executeIfAlertNotMatch(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Alert Not Present

Executes an action if an alert dialog is not present.

 <p> This function never throws an exception </p>

### Usage

`
executeIfAlertNotPresent(action)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute

## Execute If Alert Present

Executes an action if an alert dialog is present.

 <p> This function never throws an exception </p>

### Usage

`
executeIfAlertPresent(action)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute

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

## Execute If Confirmation

Executes an action if the message of a JavaScript confirmation dialog equals to the given value.

### Usage

`
executeIfConfirmation(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Confirmation Match

Executes an action if the message of a JavaScript confirmation dialog matches the given value.

### Usage

`
executeIfConfirmationMatch(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Confirmation Not Match

Executes an action if the message of a JavaScript confirmation dialog not match the given value.

### Usage

`
executeIfConfirmationNotMatch(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Confirmation Not Present

Executes an action if a confirmation dialog is not present.

 <p> This function never throws an exception </p>

### Usage

`
executeIfConfirmationNotPresent(action)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute

## Execute If Confirmation Present

Executes an action if a confirmation dialog is present.

 <p> This function never throws an exception </p>

### Usage

`
executeIfConfirmationPresent(action)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute

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

## Execute If Element Not Present

Executes an action if the specified element is not somewhere on the page.

### Usage

`
executeIfElementNotPresent(action, locator)
`

`
executeIfElementNotPresent(action, parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator

## Execute If Element Present

Executes an action if the specified element is somewhere on the page.

### Usage

`
executeIfElementPresent(action, locator)
`

`
executeIfElementPresent(action, parentLocator, locator)
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

## Execute If Not Activity

Executes an action if the current activity matches the given activity. The activity is identified by a string separated by a comma, containing "appPackage" and "appActivity" properties. For example: appPackage=example,appActivity=example

### Usage

`
executeIfNotActivity(action, activity)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
activity | the given activity

## Execute If Not Alert

Executes an action if the message of a JavaScript alert not equal to the given value.

### Usage

`
executeIfNotAlert(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
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

## Execute If Not Confirmation

Executes an action if the message of a JavaScript confirmation dialog not equal to the given value.

### Usage

`
executeIfNotConfirmation(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

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

## Execute If Not Page Source

Executes an action if the current application hierarchy XML (app) or page source (web). <p> In a web context, the source returns the source HTML of the current window. In a native context (iOS, Android, etc...) it will return the application hierarchy XML not equal to the given value.

### Usage

`
executeIfNotPageSource(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Not Prompt

Executes an action if the message of a JavaScript question prompt dialog not equal to the given value.

### Usage

`
executeIfNotPrompt(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
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

## Execute If Page Source

Executes an action if the current application hierarchy XML (app) or page source (web). <p> In a web context, the source returns the source HTML of the current window. In a native context (iOS, Android, etc...) it will return the application hierarchy XML equals to the given value.

### Usage

`
executeIfPageSource(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Page Source Match

Executes an action if the current application hierarchy XML (app) or page source (web). <p> In a web context, the source returns the source HTML of the current window. In a native context (iOS, Android, etc...) it will return the application hierarchy XML matches the given value.

### Usage

`
executeIfPageSourceMatch(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Page Source Not Match

Executes an action if the current application hierarchy XML (app) or page source (web). <p> In a web context, the source returns the source HTML of the current window. In a native context (iOS, Android, etc...) it will return the application hierarchy XML not match the given value.

### Usage

`
executeIfPageSourceNotMatch(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Prompt

Executes an action if the message of a JavaScript question prompt dialog equals to the given value.

### Usage

`
executeIfPrompt(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Prompt Match

Executes an action if the message of a JavaScript question prompt dialog matches the given value.

### Usage

`
executeIfPromptMatch(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Prompt Not Match

Executes an action if the message of a JavaScript question prompt dialog not match the given value.

### Usage

`
executeIfPromptNotMatch(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Prompt Not Present

Executes an action if a prompt dialog is not present.

 <p> This function never throws an exception </p>

### Usage

`
executeIfPromptNotPresent(action)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute

## Execute If Prompt Present

Executes an action if a prompt dialog is present.

 <p> This function never throws an exception </p>

### Usage

`
executeIfPromptPresent(action)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute

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

## Execute If Text Not Present

Executes an action if the specified text appears somewhere on the page not equal to the given value.

### Usage

`
executeIfTextNotPresent(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | a text to match with the text of the page
text | the value to match with the result

## Execute If Text Present

Executes an action if the specified text appears somewhere on the page equals to the given value.

### Usage

`
executeIfTextPresent(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | a text to match with the text of the page
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

## Finger Print

Authenticate users by using their finger print scans on supported emulators. (For Android emulator)

### Usage

`
fingerPrint()
`

### Parameters

Parameter | Description
--------- | -----------
fingerPrintId | finger prints stored in Android Keystore system (from 1 to 10)

## Go Back

Simulates the user clicking the "back" button on their browser.

### Usage

`
goBack()
`

### Parameters

Parameter | Description
--------- | -----------

## Hide Keyboard

Hide soft keyboard

### Usage

`
hideKeyboard()
`

### Parameters

Parameter | Description
--------- | -----------

## Landscape

Set the current device/browser orientation to landscape.

### Usage

`
landscape()
`

### Parameters

Parameter | Description
--------- | -----------

## Launch App

Launch the app-under-test on the device. <p> If the app-under-test (AUT) is closed, or backgrounded, it will launch it. If the AUT is already open, it will background it and re-launch it.

### Usage

`
launchApp()
`

### Parameters

Parameter | Description
--------- | -----------

## Lock

Lock the device

### Usage

`
lock()
`

### Parameters

Parameter | Description
--------- | -----------

## Long Press

Long press on the touch screen using finger motion events.

### Usage

`
longPress(locator)
`

`
longPress(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Long Press At

Long press at a specified position on the touch enabled device

### Usage

`
longPressAt(coordinate)
`

### Parameters

Parameter | Description
--------- | -----------
coordinate | a string represents a position of x and y

## Open Notifications

Open Android notifications (Emulator only)

### Usage

`
openNotifications()
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

## Portrait

Set the current device/browser orientation to portrait.

### Usage

`
portrait()
`

### Parameters

Parameter | Description
--------- | -----------

## Reject Touch ID

Simulate a reject touch id event (iOS Simulator only)

### Usage

`
rejectTouchID()
`

### Parameters

Parameter | Description
--------- | -----------

## Reload App

Reload the application without cleaning application data.

### Usage

`
reloadApp()
`

### Parameters

Parameter | Description
--------- | -----------

## Reset App

Reset the currently running app for this session.

### Usage

`
resetApp()
`

### Parameters

Parameter | Description
--------- | -----------

## Rotate

Rotate the device in three dimensions.

### Usage

`
rotate()
`

### Parameters

Parameter | Description
--------- | -----------
rotation | a string represents the three dimensional plane and how a device can be rotated about it.

## Run App In Background

Send the currently running app for this session to the background, and return after a certain amount of time (-1 means to deactivate the app entirely).

### Usage

`
runAppInBackground(millis)
`

### Parameters

Parameter | Description
--------- | -----------
millis | An integer designating how long, in milliseconds, to background the app for.

## Scroll Down To

Scroll down until an element is visible.

### Usage

`
scrollDownTo(locator)
`

`
scrollDownTo(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Scroll Up To

Scroll up until an element is visible.

### Usage

`
scrollUpTo(locator)
`

`
scrollUpTo(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Set Clipboard

Set the content of the system clipboard

### Usage

`
setClipboard()
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to set

## Set Geolocation

Set the current geo location.

### Usage

`
setGeolocation()
`

### Parameters

Parameter | Description
--------- | -----------
location | Geo location string separated by commas

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

## Shake

Perform a shake action on the device

### Usage

`
shake()
`

### Parameters

Parameter | Description
--------- | -----------

## Start Activity

Start an Android activity by providing package name and activity name. <p> The activity is identified by a string separated by a comma, containing "appPackage" and "appActivity" properties. For example: appPackage=example,appActivity=example

### Usage

`
startActivity(activity)
`

### Parameters

Parameter | Description
--------- | -----------
activity | the given activity

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

## Store Alert

Stores the message of a JavaScript alert in a variable for later access.

### Usage

`
storeAlert(variable)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the name of a variable in which the result is to be stored

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

## Store Confirmation

Stores the message of a JavaScript confirmation dialog in a variable for later access.

### Usage

`
storeConfirmation(variable)
`

### Parameters

Parameter | Description
--------- | -----------
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

## Store Page Source

Stores the current application hierarchy XML (app) or page source (web). <p> In a web context, the source returns the source HTML of the current window. In a native context (iOS, Android, etc...) it will return the application hierarchy XML in a variable for later access.

### Usage

`
storePageSource(variable)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the name of a variable in which the result is to be stored

## Store Prompt

Stores the message of a JavaScript question prompt dialog in a variable for later access.

### Usage

`
storePrompt(variable)
`

### Parameters

Parameter | Description
--------- | -----------
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

## Swipe Left

Swipe from right to left

### Usage

`
swipeLeft()
`

### Parameters

Parameter | Description
--------- | -----------

## Swipe Right

Swipe from left to right

### Usage

`
swipeRight()
`

### Parameters

Parameter | Description
--------- | -----------

## Tap

Single tap on the touch enabled device

### Usage

`
tap(locator)
`

`
tap(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Tap At

Single tap at a specified position on the touch enabled device

### Usage

`
tapAt(coordinate)
`

### Parameters

Parameter | Description
--------- | -----------
coordinate | a string represents a position of x and y

## Terminate App

Terminate the given app on the device.

### Usage

`
terminateApp()
`

### Parameters

Parameter | Description
--------- | -----------
bundleId | the bundle identifier (or app id) of the app to be terminated.

## Toggle Airplane Mode

Toggle airplane mode on device

### Usage

`
toggleAirplaneMode()
`

### Parameters

Parameter | Description
--------- | -----------

## Toggle Location Services

Switch the state of the location service

### Usage

`
toggleLocationServices()
`

### Parameters

Parameter | Description
--------- | -----------

## Toggle Wifi

Switch the state of the wifi service

### Usage

`
toggleWifi()
`

### Parameters

Parameter | Description
--------- | -----------

## Type

Send a sequence of key strokes to an element

### Usage

`
type(locator, value)
`

`
type(parentLocator, locator, value)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
value | the value to type

## Unlock

Unlock the device

### Usage

`
unlock()
`

### Parameters

Parameter | Description
--------- | -----------

## Verify Activity

Verifies that the current activity matches the given activity. When the verify fails, the test will continue execution, logging the failure. The activity is identified by a string separated by a comma, containing "appPackage" and "appActivity" properties. For example: appPackage=example,appActivity=example

### Usage

`
verifyActivity(activity)
`

### Parameters

Parameter | Description
--------- | -----------
activity | the given activity

## Verify Alert

Verifies that the message of a JavaScript alert equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyAlert(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Alert Match

Verifies that the message of a JavaScript alert matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyAlertMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Alert Not Match

Verifies that the message of a JavaScript alert not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyAlertNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Alert Not Present

Verifies that an alert dialog is not present. When the verify fails, the test will continue execution, logging the failure.

 <p> This function never throws an exception </p>

### Usage

`
verifyAlertNotPresent()
`

### Parameters

Parameter | Description
--------- | -----------

## Verify Alert Present

Verifies that an alert dialog is present. When the verify fails, the test will continue execution, logging the failure.

 <p> This function never throws an exception </p>

### Usage

`
verifyAlertPresent()
`

### Parameters

Parameter | Description
--------- | -----------

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

## Verify Confirmation

Verifies that the message of a JavaScript confirmation dialog equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyConfirmation(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Confirmation Match

Verifies that the message of a JavaScript confirmation dialog matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyConfirmationMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Confirmation Not Match

Verifies that the message of a JavaScript confirmation dialog not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyConfirmationNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Confirmation Not Present

Verifies that a confirmation dialog is not present. When the verify fails, the test will continue execution, logging the failure.

 <p> This function never throws an exception </p>

### Usage

`
verifyConfirmationNotPresent()
`

### Parameters

Parameter | Description
--------- | -----------

## Verify Confirmation Present

Verifies that a confirmation dialog is present. When the verify fails, the test will continue execution, logging the failure.

 <p> This function never throws an exception </p>

### Usage

`
verifyConfirmationPresent()
`

### Parameters

Parameter | Description
--------- | -----------

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

## Verify Element Not Present

Verifies that the specified element is not somewhere on the page. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyElementNotPresent(locator)
`

`
verifyElementNotPresent(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Verify Element Present

Verifies that the specified element is somewhere on the page. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyElementPresent(locator)
`

`
verifyElementPresent(parentLocator, locator)
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

## Verify Not Activity

Verifies that the current activity matches the given activity. When the verify fails, the test will continue execution, logging the failure. The activity is identified by a string separated by a comma, containing "appPackage" and "appActivity" properties. For example: appPackage=example,appActivity=example

### Usage

`
verifyNotActivity(activity)
`

### Parameters

Parameter | Description
--------- | -----------
activity | the given activity

## Verify Not Alert

Verifies that the message of a JavaScript alert not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotAlert(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

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

## Verify Not Confirmation

Verifies that the message of a JavaScript confirmation dialog not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotConfirmation(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

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

## Verify Not Page Source

Verifies that the current application hierarchy XML (app) or page source (web). <p> In a web context, the source returns the source HTML of the current window. In a native context (iOS, Android, etc...) it will return the application hierarchy XML not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotPageSource(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Not Prompt

Verifies that the message of a JavaScript question prompt dialog not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotPrompt(text)
`

### Parameters

Parameter | Description
--------- | -----------
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

## Verify Page Source

Verifies that the current application hierarchy XML (app) or page source (web). <p> In a web context, the source returns the source HTML of the current window. In a native context (iOS, Android, etc...) it will return the application hierarchy XML equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyPageSource(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Page Source Match

Verifies that the current application hierarchy XML (app) or page source (web). <p> In a web context, the source returns the source HTML of the current window. In a native context (iOS, Android, etc...) it will return the application hierarchy XML matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyPageSourceMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Page Source Not Match

Verifies that the current application hierarchy XML (app) or page source (web). <p> In a web context, the source returns the source HTML of the current window. In a native context (iOS, Android, etc...) it will return the application hierarchy XML not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyPageSourceNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Prompt

Verifies that the message of a JavaScript question prompt dialog equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyPrompt(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Prompt Match

Verifies that the message of a JavaScript question prompt dialog matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyPromptMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Prompt Not Match

Verifies that the message of a JavaScript question prompt dialog not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyPromptNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Prompt Not Present

Verifies that a prompt dialog is not present. When the verify fails, the test will continue execution, logging the failure.

 <p> This function never throws an exception </p>

### Usage

`
verifyPromptNotPresent()
`

### Parameters

Parameter | Description
--------- | -----------

## Verify Prompt Present

Verifies that a prompt dialog is present. When the verify fails, the test will continue execution, logging the failure.

 <p> This function never throws an exception </p>

### Usage

`
verifyPromptPresent()
`

### Parameters

Parameter | Description
--------- | -----------

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

## Verify Text Not Present

Verifies that the specified text appears somewhere on the page not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTextNotPresent(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | a text to match with the text of the page
text | the value to match with the result

## Verify Text Present

Verifies that the specified text appears somewhere on the page equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTextPresent(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | a text to match with the text of the page
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

## Wait For Activity

Waits for the current activity matches the given activity. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. The activity is identified by a string separated by a comma, containing "appPackage" and "appActivity" properties. For example: appPackage=example,appActivity=example

### Usage

`
waitForActivity(activity)
`

### Parameters

Parameter | Description
--------- | -----------
activity | the given activity

## Wait For Alert

Waits for the message of a JavaScript alert equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForAlert(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Alert Match

Waits for the message of a JavaScript alert matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForAlertMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Alert Not Match

Waits for the message of a JavaScript alert not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForAlertNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Alert Not Present

Waits for an alert dialog is not present. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

 <p> This function never throws an exception </p>

### Usage

`
waitForAlertNotPresent()
`

### Parameters

Parameter | Description
--------- | -----------

## Wait For Alert Present

Waits for an alert dialog is present. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

 <p> This function never throws an exception </p>

### Usage

`
waitForAlertPresent()
`

### Parameters

Parameter | Description
--------- | -----------

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

## Wait For Confirmation

Waits for the message of a JavaScript confirmation dialog equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForConfirmation(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Confirmation Match

Waits for the message of a JavaScript confirmation dialog matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForConfirmationMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Confirmation Not Match

Waits for the message of a JavaScript confirmation dialog not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForConfirmationNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Confirmation Not Present

Waits for a confirmation dialog is not present. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

 <p> This function never throws an exception </p>

### Usage

`
waitForConfirmationNotPresent()
`

### Parameters

Parameter | Description
--------- | -----------

## Wait For Confirmation Present

Waits for a confirmation dialog is present. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

 <p> This function never throws an exception </p>

### Usage

`
waitForConfirmationPresent()
`

### Parameters

Parameter | Description
--------- | -----------

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

## Wait For Element Not Present

Waits for the specified element is not somewhere on the page. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForElementNotPresent(locator)
`

`
waitForElementNotPresent(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Wait For Element Present

Waits for the specified element is somewhere on the page. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForElementPresent(locator)
`

`
waitForElementPresent(parentLocator, locator)
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

## Wait For Not Activity

Waits for the current activity matches the given activity. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. The activity is identified by a string separated by a comma, containing "appPackage" and "appActivity" properties. For example: appPackage=example,appActivity=example

### Usage

`
waitForNotActivity(activity)
`

### Parameters

Parameter | Description
--------- | -----------
activity | the given activity

## Wait For Not Alert

Waits for the message of a JavaScript alert not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotAlert(text)
`

### Parameters

Parameter | Description
--------- | -----------
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

## Wait For Not Confirmation

Waits for the message of a JavaScript confirmation dialog not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotConfirmation(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

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

## Wait For Not Page Source

Waits for the current application hierarchy XML (app) or page source (web). <p> In a web context, the source returns the source HTML of the current window. In a native context (iOS, Android, etc...) it will return the application hierarchy XML not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotPageSource(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Not Prompt

Waits for the message of a JavaScript question prompt dialog not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotPrompt(text)
`

### Parameters

Parameter | Description
--------- | -----------
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

## Wait For Page Source

Waits for the current application hierarchy XML (app) or page source (web). <p> In a web context, the source returns the source HTML of the current window. In a native context (iOS, Android, etc...) it will return the application hierarchy XML equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForPageSource(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Page Source Match

Waits for the current application hierarchy XML (app) or page source (web). <p> In a web context, the source returns the source HTML of the current window. In a native context (iOS, Android, etc...) it will return the application hierarchy XML matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForPageSourceMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Page Source Not Match

Waits for the current application hierarchy XML (app) or page source (web). <p> In a web context, the source returns the source HTML of the current window. In a native context (iOS, Android, etc...) it will return the application hierarchy XML not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForPageSourceNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Prompt

Waits for the message of a JavaScript question prompt dialog equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForPrompt(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Prompt Match

Waits for the message of a JavaScript question prompt dialog matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForPromptMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Prompt Not Match

Waits for the message of a JavaScript question prompt dialog not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForPromptNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Prompt Not Present

Waits for a prompt dialog is not present. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

 <p> This function never throws an exception </p>

### Usage

`
waitForPromptNotPresent()
`

### Parameters

Parameter | Description
--------- | -----------

## Wait For Prompt Present

Waits for a prompt dialog is present. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

 <p> This function never throws an exception </p>

### Usage

`
waitForPromptPresent()
`

### Parameters

Parameter | Description
--------- | -----------

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

## Wait For Text Not Present

Waits for the specified text appears somewhere on the page not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForTextNotPresent(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | a text to match with the text of the page
text | the value to match with the result

## Wait For Text Present

Waits for the specified text appears somewhere on the page equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForTextPresent(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | a text to match with the text of the page
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

