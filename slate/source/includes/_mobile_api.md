# Mobile API

## Command Table

No | Command | Method | Param 1 | Param 2 | Param 3
--------- | --------- | --------- | --------- | --------- | ---------
1 | Accept Touch ID | acceptTouchID |  |  | 
2 | Activate App | activateApp | bundleId |  | 
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
20 | Assert Context | assertContext | text |  | 
21 | Assert Context Match | assertContextMatch | text |  | 
22 | Assert Context Not Match | assertContextNotMatch | text |  | 
23 | Assert Date List Order Asc | assertDateListOrderAsc | locator | format | 
24 | Assert Date List Order Asc | assertDateListOrderAsc | parentLocator | locator | format
25 | Assert Date List Order Desc | assertDateListOrderDesc | locator | format | 
26 | Assert Date List Order Desc | assertDateListOrderDesc | parentLocator | locator | format
27 | Assert Editable | assertEditable | locator |  | 
28 | Assert Editable | assertEditable | parentLocator | locator | 
29 | Assert Element Not Present | assertElementNotPresent | locator |  | 
30 | Assert Element Not Present | assertElementNotPresent | parentLocator | locator | 
31 | Assert Element Present | assertElementPresent | locator |  | 
32 | Assert Element Present | assertElementPresent | parentLocator | locator | 
33 | Assert Enabled | assertEnabled | locator |  | 
34 | Assert Enabled | assertEnabled | parentLocator | locator | 
35 | Assert Eval | assertEval | expression | text | 
36 | Assert Exists In Database | assertExistsInDatabase | sql |  | 
37 | Assert Expression | assertExpression | expression | text | 
38 | Assert Expression Match | assertExpressionMatch | expression | text | 
39 | Assert Expression Not Match | assertExpressionNotMatch | expression | text | 
40 | Assert Integer List Order Asc | assertIntegerListOrderAsc | locator |  | 
41 | Assert Integer List Order Asc | assertIntegerListOrderAsc | parentLocator | locator | 
42 | Assert Integer List Order Desc | assertIntegerListOrderDesc | locator |  | 
43 | Assert Integer List Order Desc | assertIntegerListOrderDesc | parentLocator | locator | 
44 | Assert List Contain | assertListContain | variable | text | 
45 | Assert List Not Contain | assertListNotContain | variable | text | 
46 | Assert List Order Asc | assertListOrderAsc | variable |  | 
47 | Assert List Order Desc | assertListOrderDesc | variable |  | 
48 | Assert Not Activity | assertNotActivity | activity |  | 
49 | Assert Not Alert | assertNotAlert | text |  | 
50 | Assert Not Attribute | assertNotAttribute | locator | name | text
51 | Assert Not Checked | assertNotChecked | locator |  | 
52 | Assert Not Checked | assertNotChecked | parentLocator | locator | 
53 | Assert Not Confirmation | assertNotConfirmation | text |  | 
54 | Assert Not Context | assertNotContext | text |  | 
55 | Assert Not Editable | assertNotEditable | locator |  | 
56 | Assert Not Editable | assertNotEditable | parentLocator | locator | 
57 | Assert Not Enabled | assertNotEnabled | locator |  | 
58 | Assert Not Enabled | assertNotEnabled | parentLocator | locator | 
59 | Assert Not Eval | assertNotEval | expression | text | 
60 | Assert Not Exists In Database | assertNotExistsInDatabase | sql |  | 
61 | Assert Not Expression | assertNotExpression | expression | text | 
62 | Assert Not Page Source | assertNotPageSource | text |  | 
63 | Assert Not Prompt | assertNotPrompt | text |  | 
64 | Assert Not Tag Name | assertNotTagName | locator | text | 
65 | Assert Not Tag Name | assertNotTagName | parentLocator | locator | text
66 | Assert Not Text | assertNotText | locator | text | 
67 | Assert Not Text | assertNotText | parentLocator | locator | text
68 | Assert Not Text Empty | assertNotTextEmpty | locator |  | 
69 | Assert Not Text Empty | assertNotTextEmpty | parentLocator | locator | 
70 | Assert Not Value | assertNotValue | locator | text | 
71 | Assert Not Value | assertNotValue | parentLocator | locator | text
72 | Assert Not Value Empty | assertNotValueEmpty | locator |  | 
73 | Assert Not Value Empty | assertNotValueEmpty | parentLocator | locator | 
74 | Assert Not Variable | assertNotVariable | variable | text | 
75 | Assert Not Visible | assertNotVisible | locator |  | 
76 | Assert Not Visible | assertNotVisible | parentLocator | locator | 
77 | Assert Page Source | assertPageSource | text |  | 
78 | Assert Page Source Match | assertPageSourceMatch | text |  | 
79 | Assert Page Source Not Match | assertPageSourceNotMatch | text |  | 
80 | Assert Prompt | assertPrompt | text |  | 
81 | Assert Prompt Match | assertPromptMatch | text |  | 
82 | Assert Prompt Not Match | assertPromptNotMatch | text |  | 
83 | Assert Prompt Not Present | assertPromptNotPresent |  |  | 
84 | Assert Prompt Present | assertPromptPresent |  |  | 
85 | Assert Row Count | assertRowCount | sql | count | 
86 | Assert Row Count Greater Than | assertRowCountGreaterThan | sql | count | 
87 | Assert Row Count Less Than | assertRowCountLessThan | sql | count | 
88 | Assert Tag Name | assertTagName | locator | text | 
89 | Assert Tag Name | assertTagName | parentLocator | locator | text
90 | Assert Tag Name Match | assertTagNameMatch | locator | text | 
91 | Assert Tag Name Match | assertTagNameMatch | parentLocator | locator | text
92 | Assert Tag Name Not Match | assertTagNameNotMatch | locator | text | 
93 | Assert Tag Name Not Match | assertTagNameNotMatch | parentLocator | locator | text
94 | Assert Text | assertText | locator | text | 
95 | Assert Text | assertText | parentLocator | locator | text
96 | Assert Text Empty | assertTextEmpty | locator |  | 
97 | Assert Text Empty | assertTextEmpty | parentLocator | locator | 
98 | Assert Text List Order Asc | assertTextListOrderAsc | locator |  | 
99 | Assert Text List Order Asc | assertTextListOrderAsc | parentLocator | locator | 
100 | Assert Text List Order Desc | assertTextListOrderDesc | locator |  | 
101 | Assert Text List Order Desc | assertTextListOrderDesc | parentLocator | locator | 
102 | Assert Text Match | assertTextMatch | locator | text | 
103 | Assert Text Match | assertTextMatch | parentLocator | locator | text
104 | Assert Text Not Match | assertTextNotMatch | locator | text | 
105 | Assert Text Not Match | assertTextNotMatch | parentLocator | locator | text
106 | Assert Text Not Present | assertTextNotPresent | text |  | 
107 | Assert Text Present | assertTextPresent | text |  | 
108 | Assert Value | assertValue | locator | text | 
109 | Assert Value | assertValue | parentLocator | locator | text
110 | Assert Value Empty | assertValueEmpty | locator |  | 
111 | Assert Value Empty | assertValueEmpty | parentLocator | locator | 
112 | Assert Value Match | assertValueMatch | locator | text | 
113 | Assert Value Match | assertValueMatch | parentLocator | locator | text
114 | Assert Value Not Match | assertValueNotMatch | locator | text | 
115 | Assert Value Not Match | assertValueNotMatch | parentLocator | locator | text
116 | Assert Variable | assertVariable | variable | text | 
117 | Assert Visible | assertVisible | locator |  | 
118 | Assert Visible | assertVisible | parentLocator | locator | 
119 | Broadcast Intent | broadcastIntent | intent |  | 
120 | Capture Screenshot | captureScreenshot |  |  | 
121 | Capture Viewport | captureViewport |  |  | 
122 | Choose Cancel Confirmation | chooseCancelConfirmation |  |  | 
123 | Choose Cancel Prompt | chooseCancelPrompt |  |  | 
124 | Choose Ok Alert | chooseOkAlert |  |  | 
125 | Choose Ok Confirmation | chooseOkConfirmation |  |  | 
126 | Clear | clear | locator |  | 
127 | Clear | clear | parentLocator | locator | 
128 | Click | click | locator |  | 
129 | Click | click | parentLocator | locator | 
130 | Click Button | clickButton | indexOrText |  | 
131 | Click Text | clickText | indexOrText |  | 
132 | Close App | closeApp |  |  | 
133 | Double Tap | doubleTap | locator |  | 
134 | Double Tap | doubleTap | parentLocator | locator | 
135 | Double Tap At | doubleTapAt | coordinate |  | 
136 | Echo | echo | message |  | 
137 | Execute | execute | action |  | 
138 | Execute Each | executeEach | action | locator | variable
139 | Execute If Activity | executeIfActivity | action | activity | 
140 | Execute If Alert | executeIfAlert | action | text | 
141 | Execute If Alert Match | executeIfAlertMatch | action | text | 
142 | Execute If Alert Not Match | executeIfAlertNotMatch | action | text | 
143 | Execute If Alert Not Present | executeIfAlertNotPresent | action |  | 
144 | Execute If Alert Present | executeIfAlertPresent | action |  | 
145 | Execute If Checked | executeIfChecked | action | locator | 
146 | Execute If Checked | executeIfChecked | action | parentLocator | locator
147 | Execute If Confirmation | executeIfConfirmation | action | text | 
148 | Execute If Confirmation Match | executeIfConfirmationMatch | action | text | 
149 | Execute If Confirmation Not Match | executeIfConfirmationNotMatch | action | text | 
150 | Execute If Confirmation Not Present | executeIfConfirmationNotPresent | action |  | 
151 | Execute If Confirmation Present | executeIfConfirmationPresent | action |  | 
152 | Execute If Context | executeIfContext | action | text | 
153 | Execute If Context Match | executeIfContextMatch | action | text | 
154 | Execute If Context Not Match | executeIfContextNotMatch | action | text | 
155 | Execute If Editable | executeIfEditable | action | locator | 
156 | Execute If Editable | executeIfEditable | action | parentLocator | locator
157 | Execute If Element Not Present | executeIfElementNotPresent | action | locator | 
158 | Execute If Element Not Present | executeIfElementNotPresent | action | parentLocator | locator
159 | Execute If Element Present | executeIfElementPresent | action | locator | 
160 | Execute If Element Present | executeIfElementPresent | action | parentLocator | locator
161 | Execute If Enabled | executeIfEnabled | action | locator | 
162 | Execute If Enabled | executeIfEnabled | action | parentLocator | locator
163 | Execute If Eval | executeIfEval | action | expression | text
164 | Execute If Exists In Database | executeIfExistsInDatabase | action | sql | 
165 | Execute If Expression | executeIfExpression | action | expression | text
166 | Execute If Expression Match | executeIfExpressionMatch | action | expression | text
167 | Execute If Expression Not Match | executeIfExpressionNotMatch | action | expression | text
168 | Execute If List Contain | executeIfListContain | action | variable | text
169 | Execute If List Not Contain | executeIfListNotContain | action | variable | text
170 | Execute If Not Activity | executeIfNotActivity | action | activity | 
171 | Execute If Not Alert | executeIfNotAlert | action | text | 
172 | Execute If Not Checked | executeIfNotChecked | action | locator | 
173 | Execute If Not Checked | executeIfNotChecked | action | parentLocator | locator
174 | Execute If Not Confirmation | executeIfNotConfirmation | action | text | 
175 | Execute If Not Context | executeIfNotContext | action | text | 
176 | Execute If Not Editable | executeIfNotEditable | action | locator | 
177 | Execute If Not Editable | executeIfNotEditable | action | parentLocator | locator
178 | Execute If Not Enabled | executeIfNotEnabled | action | locator | 
179 | Execute If Not Enabled | executeIfNotEnabled | action | parentLocator | locator
180 | Execute If Not Eval | executeIfNotEval | action | expression | text
181 | Execute If Not Exists In Database | executeIfNotExistsInDatabase | action | sql | 
182 | Execute If Not Expression | executeIfNotExpression | action | expression | text
183 | Execute If Not Page Source | executeIfNotPageSource | action | text | 
184 | Execute If Not Prompt | executeIfNotPrompt | action | text | 
185 | Execute If Not Tag Name | executeIfNotTagName | action | locator | text
186 | Execute If Not Text | executeIfNotText | action | locator | text
187 | Execute If Not Text Empty | executeIfNotTextEmpty | action | locator | 
188 | Execute If Not Text Empty | executeIfNotTextEmpty | action | parentLocator | locator
189 | Execute If Not Value | executeIfNotValue | action | locator | text
190 | Execute If Not Value Empty | executeIfNotValueEmpty | action | locator | 
191 | Execute If Not Value Empty | executeIfNotValueEmpty | action | parentLocator | locator
192 | Execute If Not Variable | executeIfNotVariable | action | variable | text
193 | Execute If Not Visible | executeIfNotVisible | action | locator | 
194 | Execute If Not Visible | executeIfNotVisible | action | parentLocator | locator
195 | Execute If Page Source | executeIfPageSource | action | text | 
196 | Execute If Page Source Match | executeIfPageSourceMatch | action | text | 
197 | Execute If Page Source Not Match | executeIfPageSourceNotMatch | action | text | 
198 | Execute If Prompt | executeIfPrompt | action | text | 
199 | Execute If Prompt Match | executeIfPromptMatch | action | text | 
200 | Execute If Prompt Not Match | executeIfPromptNotMatch | action | text | 
201 | Execute If Prompt Not Present | executeIfPromptNotPresent | action |  | 
202 | Execute If Prompt Present | executeIfPromptPresent | action |  | 
203 | Execute If Tag Name | executeIfTagName | action | locator | text
204 | Execute If Tag Name Match | executeIfTagNameMatch | action | locator | text
205 | Execute If Tag Name Not Match | executeIfTagNameNotMatch | action | locator | text
206 | Execute If Text | executeIfText | action | locator | text
207 | Execute If Text Empty | executeIfTextEmpty | action | locator | 
208 | Execute If Text Empty | executeIfTextEmpty | action | parentLocator | locator
209 | Execute If Text Match | executeIfTextMatch | action | locator | text
210 | Execute If Text Not Match | executeIfTextNotMatch | action | locator | text
211 | Execute If Text Not Present | executeIfTextNotPresent | action | text | 
212 | Execute If Text Present | executeIfTextPresent | action | text | 
213 | Execute If Value | executeIfValue | action | locator | text
214 | Execute If Value Empty | executeIfValueEmpty | action | locator | 
215 | Execute If Value Empty | executeIfValueEmpty | action | parentLocator | locator
216 | Execute If Value Match | executeIfValueMatch | action | locator | text
217 | Execute If Value Not Match | executeIfValueNotMatch | action | locator | text
218 | Execute If Variable | executeIfVariable | action | variable | text
219 | Execute If Visible | executeIfVisible | action | locator | 
220 | Execute If Visible | executeIfVisible | action | parentLocator | locator
221 | Execute Loop | executeLoop | action | times | 
222 | Finger Print | fingerPrint | fingerPrintId |  | 
223 | Go Back | goBack |  |  | 
224 | Hide Keyboard | hideKeyboard |  |  | 
225 | Hide Keyboard | hideKeyboard | name |  | 
226 | Landscape | landscape |  |  | 
227 | Launch App | launchApp |  |  | 
228 | Lock | lock |  |  | 
229 | Long Press | longPress | locator |  | 
230 | Long Press | longPress | parentLocator | locator | 
231 | Long Press At | longPressAt | coordinate |  | 
232 | Open Notifications | openNotifications |  |  | 
233 | Pause | pause | waitTime |  | 
234 | Portrait | portrait |  |  | 
235 | Reject Touch ID | rejectTouchID |  |  | 
236 | Reload App | reloadApp |  |  | 
237 | Reset App | resetApp |  |  | 
238 | Rotate | rotate | rotation |  | 
239 | Run App In Background | runAppInBackground | millis |  | 
240 | Scroll Down | scrollDown |  |  | 
241 | Scroll Down | scrollDown | locator |  | 
242 | Scroll Down | scrollDown | parentLocator | locator | 
243 | Scroll Down To | scrollDownTo | locator |  | 
244 | Scroll Down To | scrollDownTo | parentLocator | locator | 
245 | Scroll Left | scrollLeft |  |  | 
246 | Scroll Left | scrollLeft | locator |  | 
247 | Scroll Left | scrollLeft | parentLocator | locator | 
248 | Scroll Left To | scrollLeftTo | locator |  | 
249 | Scroll Left To | scrollLeftTo | parentLocator | locator | 
250 | Scroll Right | scrollRight |  |  | 
251 | Scroll Right | scrollRight | locator |  | 
252 | Scroll Right | scrollRight | parentLocator | locator | 
253 | Scroll Right To | scrollRightTo | locator |  | 
254 | Scroll Right To | scrollRightTo | parentLocator | locator | 
255 | Scroll Up | scrollUp |  |  | 
256 | Scroll Up | scrollUp | locator |  | 
257 | Scroll Up | scrollUp | parentLocator | locator | 
258 | Scroll Up To | scrollUpTo | locator |  | 
259 | Scroll Up To | scrollUpTo | parentLocator | locator | 
260 | Set Clipboard | setClipboard | text |  | 
261 | Set Context | setContext | context |  | 
262 | Set Geolocation | setGeolocation | location |  | 
263 | Set Timeout | setTimeout | timeout |  | 
264 | Shake | shake |  |  | 
265 | Start Activity | startActivity | activity |  | 
266 | Store | store | text | variable | 
267 | Store Alert | storeAlert | variable |  | 
268 | Store Attribute | storeAttribute | locator | name | variable
269 | Store Confirmation | storeConfirmation | variable |  | 
270 | Store Context | storeContext | variable |  | 
271 | Store Current Date | storeCurrentDate | variable |  | 
272 | Store Eval | storeEval | expression | variable | 
273 | Store Expression | storeExpression | expression | variable | 
274 | Store Page Source | storePageSource | variable |  | 
275 | Store Prompt | storePrompt | variable |  | 
276 | Store Push | storePush | text | variable | 
277 | Store Tag Name | storeTagName | locator | variable | 
278 | Store Tag Name | storeTagName | parentLocator | locator | variable
279 | Store Text | storeText | locator | variable | 
280 | Store Text | storeText | parentLocator | locator | variable
281 | Store Value | storeValue | locator | variable | 
282 | Store Value | storeValue | parentLocator | locator | variable
283 | Swipe Down | swipeDown |  |  | 
284 | Swipe Down | swipeDown | locator |  | 
285 | Swipe Down | swipeDown | parentLocator | locator | 
286 | Swipe Left | swipeLeft |  |  | 
287 | Swipe Left | swipeLeft | locator |  | 
288 | Swipe Left | swipeLeft | parentLocator | locator | 
289 | Swipe Right | swipeRight |  |  | 
290 | Swipe Right | swipeRight | locator |  | 
291 | Swipe Right | swipeRight | parentLocator | locator | 
292 | Swipe Up | swipeUp |  |  | 
293 | Swipe Up | swipeUp | locator |  | 
294 | Swipe Up | swipeUp | parentLocator | locator | 
295 | Tap | tap | locator |  | 
296 | Tap | tap | parentLocator | locator | 
297 | Tap At | tapAt | coordinate |  | 
298 | Terminate App | terminateApp | bundleId |  | 
299 | Toggle Airplane Mode | toggleAirplaneMode |  |  | 
300 | Toggle Location Services | toggleLocationServices |  |  | 
301 | Toggle Wifi | toggleWifi |  |  | 
302 | Type | type | locator | value | 
303 | Type | type | parentLocator | locator | value
304 | Unlock | unlock |  |  | 
305 | Verify Activity | verifyActivity | activity |  | 
306 | Verify Alert | verifyAlert | text |  | 
307 | Verify Alert Match | verifyAlertMatch | text |  | 
308 | Verify Alert Not Match | verifyAlertNotMatch | text |  | 
309 | Verify Alert Not Present | verifyAlertNotPresent |  |  | 
310 | Verify Alert Present | verifyAlertPresent |  |  | 
311 | Verify Attribute | verifyAttribute | locator | name | text
312 | Verify Attribute Match | verifyAttributeMatch | locator | name | text
313 | Verify Attribute Not Match | verifyAttributeNotMatch | locator | name | text
314 | Verify Checked | verifyChecked | locator |  | 
315 | Verify Checked | verifyChecked | parentLocator | locator | 
316 | Verify Confirmation | verifyConfirmation | text |  | 
317 | Verify Confirmation Match | verifyConfirmationMatch | text |  | 
318 | Verify Confirmation Not Match | verifyConfirmationNotMatch | text |  | 
319 | Verify Confirmation Not Present | verifyConfirmationNotPresent |  |  | 
320 | Verify Confirmation Present | verifyConfirmationPresent |  |  | 
321 | Verify Context | verifyContext | text |  | 
322 | Verify Context Match | verifyContextMatch | text |  | 
323 | Verify Context Not Match | verifyContextNotMatch | text |  | 
324 | Verify Date List Order Asc | verifyDateListOrderAsc | locator | format | 
325 | Verify Date List Order Asc | verifyDateListOrderAsc | parentLocator | locator | format
326 | Verify Date List Order Desc | verifyDateListOrderDesc | locator | format | 
327 | Verify Date List Order Desc | verifyDateListOrderDesc | parentLocator | locator | format
328 | Verify Editable | verifyEditable | locator |  | 
329 | Verify Editable | verifyEditable | parentLocator | locator | 
330 | Verify Element Not Present | verifyElementNotPresent | locator |  | 
331 | Verify Element Not Present | verifyElementNotPresent | parentLocator | locator | 
332 | Verify Element Present | verifyElementPresent | locator |  | 
333 | Verify Element Present | verifyElementPresent | parentLocator | locator | 
334 | Verify Enabled | verifyEnabled | locator |  | 
335 | Verify Enabled | verifyEnabled | parentLocator | locator | 
336 | Verify Eval | verifyEval | expression | text | 
337 | Verify Exists In Database | verifyExistsInDatabase | sql |  | 
338 | Verify Expression | verifyExpression | expression | text | 
339 | Verify Expression Match | verifyExpressionMatch | expression | text | 
340 | Verify Expression Not Match | verifyExpressionNotMatch | expression | text | 
341 | Verify Integer List Order Asc | verifyIntegerListOrderAsc | locator |  | 
342 | Verify Integer List Order Asc | verifyIntegerListOrderAsc | parentLocator | locator | 
343 | Verify Integer List Order Desc | verifyIntegerListOrderDesc | locator |  | 
344 | Verify Integer List Order Desc | verifyIntegerListOrderDesc | parentLocator | locator | 
345 | Verify List Contain | verifyListContain | variable | text | 
346 | Verify List Not Contain | verifyListNotContain | variable | text | 
347 | Verify List Order Asc | verifyListOrderAsc | variable |  | 
348 | Verify List Order Desc | verifyListOrderDesc | variable |  | 
349 | Verify Not Activity | verifyNotActivity | activity |  | 
350 | Verify Not Alert | verifyNotAlert | text |  | 
351 | Verify Not Attribute | verifyNotAttribute | locator | name | text
352 | Verify Not Checked | verifyNotChecked | locator |  | 
353 | Verify Not Checked | verifyNotChecked | parentLocator | locator | 
354 | Verify Not Confirmation | verifyNotConfirmation | text |  | 
355 | Verify Not Context | verifyNotContext | text |  | 
356 | Verify Not Editable | verifyNotEditable | locator |  | 
357 | Verify Not Editable | verifyNotEditable | parentLocator | locator | 
358 | Verify Not Enabled | verifyNotEnabled | locator |  | 
359 | Verify Not Enabled | verifyNotEnabled | parentLocator | locator | 
360 | Verify Not Eval | verifyNotEval | expression | text | 
361 | Verify Not Exists In Database | verifyNotExistsInDatabase | sql |  | 
362 | Verify Not Expression | verifyNotExpression | expression | text | 
363 | Verify Not Page Source | verifyNotPageSource | text |  | 
364 | Verify Not Prompt | verifyNotPrompt | text |  | 
365 | Verify Not Tag Name | verifyNotTagName | locator | text | 
366 | Verify Not Tag Name | verifyNotTagName | parentLocator | locator | text
367 | Verify Not Text | verifyNotText | locator | text | 
368 | Verify Not Text | verifyNotText | parentLocator | locator | text
369 | Verify Not Text Empty | verifyNotTextEmpty | locator |  | 
370 | Verify Not Text Empty | verifyNotTextEmpty | parentLocator | locator | 
371 | Verify Not Value | verifyNotValue | locator | text | 
372 | Verify Not Value | verifyNotValue | parentLocator | locator | text
373 | Verify Not Value Empty | verifyNotValueEmpty | locator |  | 
374 | Verify Not Value Empty | verifyNotValueEmpty | parentLocator | locator | 
375 | Verify Not Variable | verifyNotVariable | variable | text | 
376 | Verify Not Visible | verifyNotVisible | locator |  | 
377 | Verify Not Visible | verifyNotVisible | parentLocator | locator | 
378 | Verify Page Source | verifyPageSource | text |  | 
379 | Verify Page Source Match | verifyPageSourceMatch | text |  | 
380 | Verify Page Source Not Match | verifyPageSourceNotMatch | text |  | 
381 | Verify Prompt | verifyPrompt | text |  | 
382 | Verify Prompt Match | verifyPromptMatch | text |  | 
383 | Verify Prompt Not Match | verifyPromptNotMatch | text |  | 
384 | Verify Prompt Not Present | verifyPromptNotPresent |  |  | 
385 | Verify Prompt Present | verifyPromptPresent |  |  | 
386 | Verify Row Count | verifyRowCount | sql | count | 
387 | Verify Row Count Greater Than | verifyRowCountGreaterThan | sql | count | 
388 | Verify Row Count Less Than | verifyRowCountLessThan | sql | count | 
389 | Verify Tag Name | verifyTagName | locator | text | 
390 | Verify Tag Name | verifyTagName | parentLocator | locator | text
391 | Verify Tag Name Match | verifyTagNameMatch | locator | text | 
392 | Verify Tag Name Match | verifyTagNameMatch | parentLocator | locator | text
393 | Verify Tag Name Not Match | verifyTagNameNotMatch | locator | text | 
394 | Verify Tag Name Not Match | verifyTagNameNotMatch | parentLocator | locator | text
395 | Verify Text | verifyText | locator | text | 
396 | Verify Text | verifyText | parentLocator | locator | text
397 | Verify Text Empty | verifyTextEmpty | locator |  | 
398 | Verify Text Empty | verifyTextEmpty | parentLocator | locator | 
399 | Verify Text List Order Asc | verifyTextListOrderAsc | locator |  | 
400 | Verify Text List Order Asc | verifyTextListOrderAsc | parentLocator | locator | 
401 | Verify Text List Order Desc | verifyTextListOrderDesc | locator |  | 
402 | Verify Text List Order Desc | verifyTextListOrderDesc | parentLocator | locator | 
403 | Verify Text Match | verifyTextMatch | locator | text | 
404 | Verify Text Match | verifyTextMatch | parentLocator | locator | text
405 | Verify Text Not Match | verifyTextNotMatch | locator | text | 
406 | Verify Text Not Match | verifyTextNotMatch | parentLocator | locator | text
407 | Verify Text Not Present | verifyTextNotPresent | text |  | 
408 | Verify Text Present | verifyTextPresent | text |  | 
409 | Verify Value | verifyValue | locator | text | 
410 | Verify Value | verifyValue | parentLocator | locator | text
411 | Verify Value Empty | verifyValueEmpty | locator |  | 
412 | Verify Value Empty | verifyValueEmpty | parentLocator | locator | 
413 | Verify Value Match | verifyValueMatch | locator | text | 
414 | Verify Value Match | verifyValueMatch | parentLocator | locator | text
415 | Verify Value Not Match | verifyValueNotMatch | locator | text | 
416 | Verify Value Not Match | verifyValueNotMatch | parentLocator | locator | text
417 | Verify Variable | verifyVariable | variable | text | 
418 | Verify Visible | verifyVisible | locator |  | 
419 | Verify Visible | verifyVisible | parentLocator | locator | 
420 | Wait For Activity | waitForActivity | activity |  | 
421 | Wait For Alert | waitForAlert | text |  | 
422 | Wait For Alert Match | waitForAlertMatch | text |  | 
423 | Wait For Alert Not Match | waitForAlertNotMatch | text |  | 
424 | Wait For Alert Not Present | waitForAlertNotPresent |  |  | 
425 | Wait For Alert Present | waitForAlertPresent |  |  | 
426 | Wait For All Element Not Present | waitForAllElementNotPresent | locatorArray |  | 
427 | Wait For All Element Present | waitForAllElementPresent | locatorArray |  | 
428 | Wait For All Text Not Present | waitForAllTextNotPresent | textArray |  | 
429 | Wait For All Text Present | waitForAllTextPresent | textArray |  | 
430 | Wait For Any Element Not Present | waitForAnyElementNotPresent | locatorArray |  | 
431 | Wait For Any Element Present | waitForAnyElementPresent | locatorArray |  | 
432 | Wait For Any Text Not Present | waitForAnyTextNotPresent | textArray |  | 
433 | Wait For Any Text Present | waitForAnyTextPresent | textArray |  | 
434 | Wait For Attribute | waitForAttribute | locator | name | text
435 | Wait For Attribute Match | waitForAttributeMatch | locator | name | text
436 | Wait For Attribute Not Match | waitForAttributeNotMatch | locator | name | text
437 | Wait For Checked | waitForChecked | locator |  | 
438 | Wait For Checked | waitForChecked | parentLocator | locator | 
439 | Wait For Confirmation | waitForConfirmation | text |  | 
440 | Wait For Confirmation Match | waitForConfirmationMatch | text |  | 
441 | Wait For Confirmation Not Match | waitForConfirmationNotMatch | text |  | 
442 | Wait For Confirmation Not Present | waitForConfirmationNotPresent |  |  | 
443 | Wait For Confirmation Present | waitForConfirmationPresent |  |  | 
444 | Wait For Context | waitForContext | text |  | 
445 | Wait For Context Match | waitForContextMatch | text |  | 
446 | Wait For Context Not Match | waitForContextNotMatch | text |  | 
447 | Wait For Editable | waitForEditable | locator |  | 
448 | Wait For Editable | waitForEditable | parentLocator | locator | 
449 | Wait For Element Not Present | waitForElementNotPresent | locator |  | 
450 | Wait For Element Not Present | waitForElementNotPresent | parentLocator | locator | 
451 | Wait For Element Present | waitForElementPresent | locator |  | 
452 | Wait For Element Present | waitForElementPresent | parentLocator | locator | 
453 | Wait For Enabled | waitForEnabled | locator |  | 
454 | Wait For Enabled | waitForEnabled | parentLocator | locator | 
455 | Wait For Eval | waitForEval | expression | text | 
456 | Wait For Exists In Database | waitForExistsInDatabase | sql |  | 
457 | Wait For Expression | waitForExpression | expression | text | 
458 | Wait For Expression Match | waitForExpressionMatch | expression | text | 
459 | Wait For Expression Not Match | waitForExpressionNotMatch | expression | text | 
460 | Wait For Not Activity | waitForNotActivity | activity |  | 
461 | Wait For Not Alert | waitForNotAlert | text |  | 
462 | Wait For Not Attribute | waitForNotAttribute | locator | name | text
463 | Wait For Not Checked | waitForNotChecked | locator |  | 
464 | Wait For Not Checked | waitForNotChecked | parentLocator | locator | 
465 | Wait For Not Confirmation | waitForNotConfirmation | text |  | 
466 | Wait For Not Context | waitForNotContext | text |  | 
467 | Wait For Not Editable | waitForNotEditable | locator |  | 
468 | Wait For Not Editable | waitForNotEditable | parentLocator | locator | 
469 | Wait For Not Enabled | waitForNotEnabled | locator |  | 
470 | Wait For Not Enabled | waitForNotEnabled | parentLocator | locator | 
471 | Wait For Not Eval | waitForNotEval | expression | text | 
472 | Wait For Not Exists In Database | waitForNotExistsInDatabase | sql |  | 
473 | Wait For Not Expression | waitForNotExpression | expression | text | 
474 | Wait For Not Page Source | waitForNotPageSource | text |  | 
475 | Wait For Not Prompt | waitForNotPrompt | text |  | 
476 | Wait For Not Tag Name | waitForNotTagName | locator | text | 
477 | Wait For Not Tag Name | waitForNotTagName | parentLocator | locator | text
478 | Wait For Not Text | waitForNotText | locator | text | 
479 | Wait For Not Text | waitForNotText | parentLocator | locator | text
480 | Wait For Not Text Empty | waitForNotTextEmpty | locator |  | 
481 | Wait For Not Text Empty | waitForNotTextEmpty | parentLocator | locator | 
482 | Wait For Not Value | waitForNotValue | locator | text | 
483 | Wait For Not Value | waitForNotValue | parentLocator | locator | text
484 | Wait For Not Value Empty | waitForNotValueEmpty | locator |  | 
485 | Wait For Not Value Empty | waitForNotValueEmpty | parentLocator | locator | 
486 | Wait For Not Visible | waitForNotVisible | locator |  | 
487 | Wait For Not Visible | waitForNotVisible | parentLocator | locator | 
488 | Wait For Page Source | waitForPageSource | text |  | 
489 | Wait For Page Source Match | waitForPageSourceMatch | text |  | 
490 | Wait For Page Source Not Match | waitForPageSourceNotMatch | text |  | 
491 | Wait For Prompt | waitForPrompt | text |  | 
492 | Wait For Prompt Match | waitForPromptMatch | text |  | 
493 | Wait For Prompt Not Match | waitForPromptNotMatch | text |  | 
494 | Wait For Prompt Not Present | waitForPromptNotPresent |  |  | 
495 | Wait For Prompt Present | waitForPromptPresent |  |  | 
496 | Wait For Tag Name | waitForTagName | locator | text | 
497 | Wait For Tag Name | waitForTagName | parentLocator | locator | text
498 | Wait For Tag Name Match | waitForTagNameMatch | locator | text | 
499 | Wait For Tag Name Match | waitForTagNameMatch | parentLocator | locator | text
500 | Wait For Tag Name Not Match | waitForTagNameNotMatch | locator | text | 
501 | Wait For Tag Name Not Match | waitForTagNameNotMatch | parentLocator | locator | text
502 | Wait For Text | waitForText | locator | text | 
503 | Wait For Text | waitForText | parentLocator | locator | text
504 | Wait For Text Empty | waitForTextEmpty | locator |  | 
505 | Wait For Text Empty | waitForTextEmpty | parentLocator | locator | 
506 | Wait For Text Match | waitForTextMatch | locator | text | 
507 | Wait For Text Match | waitForTextMatch | parentLocator | locator | text
508 | Wait For Text Not Match | waitForTextNotMatch | locator | text | 
509 | Wait For Text Not Match | waitForTextNotMatch | parentLocator | locator | text
510 | Wait For Text Not Present | waitForTextNotPresent | text |  | 
511 | Wait For Text Present | waitForTextPresent | text |  | 
512 | Wait For Value | waitForValue | locator | text | 
513 | Wait For Value | waitForValue | parentLocator | locator | text
514 | Wait For Value Empty | waitForValueEmpty | locator |  | 
515 | Wait For Value Empty | waitForValueEmpty | parentLocator | locator | 
516 | Wait For Value Match | waitForValueMatch | locator | text | 
517 | Wait For Value Match | waitForValueMatch | parentLocator | locator | text
518 | Wait For Value Not Match | waitForValueNotMatch | locator | text | 
519 | Wait For Value Not Match | waitForValueNotMatch | parentLocator | locator | text
520 | Wait For Visible | waitForVisible | locator |  | 
521 | Wait For Visible | waitForVisible | parentLocator | locator | 

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
activateApp(bundleId)
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

## Assert Context

Asserts that the current context in which Appium is running equals to the given value. When the assert fails, the test is aborted. <p> Retrieve the current context. This can be either NATIVE_APP for the native context, or a web view context, which will be: <p> - iOS - WEBVIEW_<id> - Android - WEBVIEW_<package name>

### Usage

`
assertContext(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Context Match

Asserts that the current context in which Appium is running matches the given value. When the assert fails, the test is aborted. <p> Retrieve the current context. This can be either NATIVE_APP for the native context, or a web view context, which will be: <p> - iOS - WEBVIEW_<id> - Android - WEBVIEW_<package name>

### Usage

`
assertContextMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Context Not Match

Asserts that the current context in which Appium is running not match the given value. When the assert fails, the test is aborted. <p> Retrieve the current context. This can be either NATIVE_APP for the native context, or a web view context, which will be: <p> - iOS - WEBVIEW_<id> - Android - WEBVIEW_<package name>

### Usage

`
assertContextNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

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

## Assert Not Context

Asserts that the current context in which Appium is running not equal to the given value. When the assert fails, the test is aborted. <p> Retrieve the current context. This can be either NATIVE_APP for the native context, or a web view context, which will be: <p> - iOS - WEBVIEW_<id> - Android - WEBVIEW_<package name>

### Usage

`
assertNotContext(text)
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

## Assert Not Tag Name

Asserts that the tag name of an element not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotTagName(locator, text)
`

`
assertNotTagName(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
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

## Assert Tag Name

Asserts that the tag name of an element equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertTagName(locator, text)
`

`
assertTagName(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Assert Tag Name Match

Asserts that the tag name of an element matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertTagNameMatch(locator, text)
`

`
assertTagNameMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Assert Tag Name Not Match

Asserts that the tag name of an element not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertTagNameNotMatch(locator, text)
`

`
assertTagNameNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

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

## Execute If Context

Executes an action if the current context in which Appium is running equals to the given value. <p> Retrieve the current context. This can be either NATIVE_APP for the native context, or a web view context, which will be: <p> - iOS - WEBVIEW_<id> - Android - WEBVIEW_<package name>

### Usage

`
executeIfContext(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Context Match

Executes an action if the current context in which Appium is running matches the given value. <p> Retrieve the current context. This can be either NATIVE_APP for the native context, or a web view context, which will be: <p> - iOS - WEBVIEW_<id> - Android - WEBVIEW_<package name>

### Usage

`
executeIfContextMatch(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Context Not Match

Executes an action if the current context in which Appium is running not match the given value. <p> Retrieve the current context. This can be either NATIVE_APP for the native context, or a web view context, which will be: <p> - iOS - WEBVIEW_<id> - Android - WEBVIEW_<package name>

### Usage

`
executeIfContextNotMatch(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

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

## Execute If Not Context

Executes an action if the current context in which Appium is running not equal to the given value. <p> Retrieve the current context. This can be either NATIVE_APP for the native context, or a web view context, which will be: <p> - iOS - WEBVIEW_<id> - Android - WEBVIEW_<package name>

### Usage

`
executeIfNotContext(action, text)
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

## Execute If Not Tag Name

Executes an action if the tag name of an element not equal to the given value.

### Usage

`
executeIfNotTagName(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator
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

## Execute If Tag Name

Executes an action if the tag name of an element equals to the given value.

### Usage

`
executeIfTagName(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Execute If Tag Name Match

Executes an action if the tag name of an element matches the given value.

### Usage

`
executeIfTagNameMatch(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Execute If Tag Name Not Match

Executes an action if the tag name of an element not match the given value.

### Usage

`
executeIfTagNameNotMatch(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

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
fingerPrint(fingerPrintId)
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

## Hide Keyboard

Hide soft keyboard by pressing the button specified key name

### Usage

`
hideKeyboard(name)
`

### Parameters

Parameter | Description
--------- | -----------
name | the key name to press

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
rotate(rotation)
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

## Scroll Down

Scrolls down the whole screen. The main difference from swipe call is that scroll will try to move the current viewport exactly to the next/previous page (the term "page" means the content, which fits into a single device screen)

### Usage

`
scrollDown()
`

### Parameters

Parameter | Description
--------- | -----------

## Scroll Down

Scrolls down on the particular screen element.

### Usage

`
scrollDown(locator)
`

`
scrollDown(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Scroll Down To

Scrolls down on the whole screen to the first visible element in the parent container.

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

## Scroll Left

Scrolls left the whole screen. The main difference from swipe call is that scroll will try to move the current viewport exactly to the next/previous page (the term "page" means the content, which fits into a single device screen)

### Usage

`
scrollLeft()
`

### Parameters

Parameter | Description
--------- | -----------

## Scroll Left

Scrolls left on the particular screen element.

### Usage

`
scrollLeft(locator)
`

`
scrollLeft(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Scroll Left To

Scrolls left on the whole screen to the first visible element in the parent container.

### Usage

`
scrollLeftTo(locator)
`

`
scrollLeftTo(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Scroll Right

Scrolls right the whole screen. The main difference from swipe call is that scroll will try to move the current viewport exactly to the next/previous page (the term "page" means the content, which fits into a single device screen)

### Usage

`
scrollRight()
`

### Parameters

Parameter | Description
--------- | -----------

## Scroll Right

Scrolls right on the particular screen element.

### Usage

`
scrollRight(locator)
`

`
scrollRight(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Scroll Right To

Scrolls right on the whole screen to the first visible element in the parent container.

### Usage

`
scrollRightTo(locator)
`

`
scrollRightTo(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Scroll Up

Scrolls up the whole screen. The main difference from swipe call is that scroll will try to move the current viewport exactly to the next/previous page (the term "page" means the content, which fits into a single device screen)

### Usage

`
scrollUp()
`

### Parameters

Parameter | Description
--------- | -----------

## Scroll Up

Scrolls up on the particular screen element.

### Usage

`
scrollUp(locator)
`

`
scrollUp(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Scroll Up To

Scrolls up on the whole screen to the first visible element in the parent container.

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
setClipboard(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to set

## Set Context

Set the context being automated. <p> Set the current context to that passed in. If this is moving into a web view context it will involve attempting to connect to that web view: <p> - iOS - attempt to connect to the application through the remote debugger - Android - start a Chromedriver process and begin a session to connect to the web view

### Usage

`
setContext(context)
`

### Parameters

Parameter | Description
--------- | -----------
context | The name of the context to which to change

## Set Geolocation

Set the current geo location.

### Usage

`
setGeolocation(location)
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

## Store Context

Stores the current context in which Appium is running in a variable for later access. <p> Retrieve the current context. This can be either NATIVE_APP for the native context, or a web view context, which will be: <p> - iOS - WEBVIEW_<id> - Android - WEBVIEW_<package name>

### Usage

`
storeContext(variable)
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

## Store Tag Name

Stores the tag name of an element in a variable for later access.

### Usage

`
storeTagName(locator, variable)
`

`
storeTagName(parentLocator, locator, variable)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
variable | the name of a variable in which the result is to be stored

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

## Swipe Down

Performs a simple "swipe" down gesture on the whole screen.

### Usage

`
swipeDown()
`

### Parameters

Parameter | Description
--------- | -----------

## Swipe Down

Performs a simple "swipe" down gesture on the particular screen element.

### Usage

`
swipeDown(locator)
`

`
swipeDown(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Swipe Left

Performs a simple "swipe" left gesture on the whole screen.

### Usage

`
swipeLeft()
`

### Parameters

Parameter | Description
--------- | -----------

## Swipe Left

Performs a simple "swipe" left gesture on the particular screen element.

### Usage

`
swipeLeft(locator)
`

`
swipeLeft(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Swipe Right

Performs a simple "swipe" right gesture on the whole screen.

### Usage

`
swipeRight()
`

### Parameters

Parameter | Description
--------- | -----------

## Swipe Right

Performs a simple "swipe" right gesture on the particular screen element.

### Usage

`
swipeRight(locator)
`

`
swipeRight(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Swipe Up

Performs a simple "swipe" up gesture on the whole screen.

### Usage

`
swipeUp()
`

### Parameters

Parameter | Description
--------- | -----------

## Swipe Up

Performs a simple "swipe" up gesture on the particular screen element.

### Usage

`
swipeUp(locator)
`

`
swipeUp(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

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
terminateApp(bundleId)
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

## Verify Context

Verifies that the current context in which Appium is running equals to the given value. When the verify fails, the test will continue execution, logging the failure. <p> Retrieve the current context. This can be either NATIVE_APP for the native context, or a web view context, which will be: <p> - iOS - WEBVIEW_<id> - Android - WEBVIEW_<package name>

### Usage

`
verifyContext(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Context Match

Verifies that the current context in which Appium is running matches the given value. When the verify fails, the test will continue execution, logging the failure. <p> Retrieve the current context. This can be either NATIVE_APP for the native context, or a web view context, which will be: <p> - iOS - WEBVIEW_<id> - Android - WEBVIEW_<package name>

### Usage

`
verifyContextMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Context Not Match

Verifies that the current context in which Appium is running not match the given value. When the verify fails, the test will continue execution, logging the failure. <p> Retrieve the current context. This can be either NATIVE_APP for the native context, or a web view context, which will be: <p> - iOS - WEBVIEW_<id> - Android - WEBVIEW_<package name>

### Usage

`
verifyContextNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

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

## Verify Not Context

Verifies that the current context in which Appium is running not equal to the given value. When the verify fails, the test will continue execution, logging the failure. <p> Retrieve the current context. This can be either NATIVE_APP for the native context, or a web view context, which will be: <p> - iOS - WEBVIEW_<id> - Android - WEBVIEW_<package name>

### Usage

`
verifyNotContext(text)
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

## Verify Not Tag Name

Verifies that the tag name of an element not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotTagName(locator, text)
`

`
verifyNotTagName(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
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

## Verify Tag Name

Verifies that the tag name of an element equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTagName(locator, text)
`

`
verifyTagName(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Verify Tag Name Match

Verifies that the tag name of an element matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTagNameMatch(locator, text)
`

`
verifyTagNameMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Verify Tag Name Not Match

Verifies that the tag name of an element not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTagNameNotMatch(locator, text)
`

`
verifyTagNameNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

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

## Wait For Context

Waits for the current context in which Appium is running equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. <p> Retrieve the current context. This can be either NATIVE_APP for the native context, or a web view context, which will be: <p> - iOS - WEBVIEW_<id> - Android - WEBVIEW_<package name>

### Usage

`
waitForContext(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Context Match

Waits for the current context in which Appium is running matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. <p> Retrieve the current context. This can be either NATIVE_APP for the native context, or a web view context, which will be: <p> - iOS - WEBVIEW_<id> - Android - WEBVIEW_<package name>

### Usage

`
waitForContextMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Context Not Match

Waits for the current context in which Appium is running not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. <p> Retrieve the current context. This can be either NATIVE_APP for the native context, or a web view context, which will be: <p> - iOS - WEBVIEW_<id> - Android - WEBVIEW_<package name>

### Usage

`
waitForContextNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

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

## Wait For Not Context

Waits for the current context in which Appium is running not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. <p> Retrieve the current context. This can be either NATIVE_APP for the native context, or a web view context, which will be: <p> - iOS - WEBVIEW_<id> - Android - WEBVIEW_<package name>

### Usage

`
waitForNotContext(text)
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

## Wait For Not Tag Name

Waits for the tag name of an element not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotTagName(locator, text)
`

`
waitForNotTagName(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
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

## Wait For Tag Name

Waits for the tag name of an element equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForTagName(locator, text)
`

`
waitForTagName(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Wait For Tag Name Match

Waits for the tag name of an element matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForTagNameMatch(locator, text)
`

`
waitForTagNameMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Wait For Tag Name Not Match

Waits for the tag name of an element not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForTagNameNotMatch(locator, text)
`

`
waitForTagNameNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

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

