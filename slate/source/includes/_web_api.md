# Web API

## Command Table

No | Command | Method | Param 1 | Param 2 | Param 3
--------- | --------- | --------- | --------- | --------- | ---------
1 | Add Selection | addSelection | locator | optionLocator | 
2 | Add Selection | addSelection | parentLocator | locator | optionLocator
3 | Add Selection Id | addSelectionId | locator | id | 
4 | Add Selection Id | addSelectionId | parentLocator | locator | id
5 | Add Selection Index | addSelectionIndex | locator | index | 
6 | Add Selection Index | addSelectionIndex | parentLocator | locator | index
7 | Add Selection Label | addSelectionLabel | locator | label | 
8 | Add Selection Label | addSelectionLabel | parentLocator | locator | label
9 | Add Selection Value | addSelectionValue | locator | value | 
10 | Add Selection Value | addSelectionValue | parentLocator | locator | value
11 | Alt Key Down | altKeyDown |  |  | 
12 | Alt Key Up | altKeyUp |  |  | 
13 | Answer Prompt | answerPrompt | answer |  | 
14 | Assert Alert | assertAlert | text |  | 
15 | Assert Alert Match | assertAlertMatch | text |  | 
16 | Assert Alert Not Match | assertAlertNotMatch | text |  | 
17 | Assert Alert Not Present | assertAlertNotPresent |  |  | 
18 | Assert Alert Present | assertAlertPresent |  |  | 
19 | Assert All Buttons | assertAllButtons | text |  | 
20 | Assert All Buttons Match | assertAllButtonsMatch | text |  | 
21 | Assert All Buttons Not Match | assertAllButtonsNotMatch | text |  | 
22 | Assert All Fields | assertAllFields | text |  | 
23 | Assert All Fields Match | assertAllFieldsMatch | text |  | 
24 | Assert All Fields Not Match | assertAllFieldsNotMatch | text |  | 
25 | Assert All Links | assertAllLinks | text |  | 
26 | Assert All Links Match | assertAllLinksMatch | text |  | 
27 | Assert All Links Not Match | assertAllLinksNotMatch | text |  | 
28 | Assert All Window Names | assertAllWindowNames | text |  | 
29 | Assert All Window Names Match | assertAllWindowNamesMatch | text |  | 
30 | Assert All Window Names Not Match | assertAllWindowNamesNotMatch | text |  | 
31 | Assert All Window Titles | assertAllWindowTitles | text |  | 
32 | Assert All Window Titles Match | assertAllWindowTitlesMatch | text |  | 
33 | Assert All Window Titles Not Match | assertAllWindowTitlesNotMatch | text |  | 
34 | Assert Attribute | assertAttribute | locator | name | text
35 | Assert Attribute From All Windows | assertAttributeFromAllWindows | attributeName | text | 
36 | Assert Attribute From All Windows Match | assertAttributeFromAllWindowsMatch | attributeName | text | 
37 | Assert Attribute From All Windows Not Match | assertAttributeFromAllWindowsNotMatch | attributeName | text | 
38 | Assert Attribute Match | assertAttributeMatch | locator | name | text
39 | Assert Attribute Not Match | assertAttributeNotMatch | locator | name | text
40 | Assert Background Color | assertBackgroundColor | locator | text | 
41 | Assert Background Color | assertBackgroundColor | parentLocator | locator | text
42 | Assert Body Text | assertBodyText | text |  | 
43 | Assert Body Text Match | assertBodyTextMatch | text |  | 
44 | Assert Body Text Not Match | assertBodyTextNotMatch | text |  | 
45 | Assert Border Color | assertBorderColor | locator | text | 
46 | Assert Border Color | assertBorderColor | parentLocator | locator | text
47 | Assert Checked | assertChecked | locator |  | 
48 | Assert Checked | assertChecked | parentLocator | locator | 
49 | Assert Color | assertColor | locator | text | 
50 | Assert Color | assertColor | parentLocator | locator | text
51 | Assert Confirmation | assertConfirmation | text |  | 
52 | Assert Confirmation Match | assertConfirmationMatch | text |  | 
53 | Assert Confirmation Not Match | assertConfirmationNotMatch | text |  | 
54 | Assert Confirmation Not Present | assertConfirmationNotPresent |  |  | 
55 | Assert Confirmation Present | assertConfirmationPresent |  |  | 
56 | Assert Cookie | assertCookie | text |  | 
57 | Assert Cookie By Name | assertCookieByName | name | text | 
58 | Assert Cookie By Name Match | assertCookieByNameMatch | name | text | 
59 | Assert Cookie By Name Not Match | assertCookieByNameNotMatch | name | text | 
60 | Assert Cookie Match | assertCookieMatch | text |  | 
61 | Assert Cookie Not Match | assertCookieNotMatch | text |  | 
62 | Assert Cookie Not Present | assertCookieNotPresent | name |  | 
63 | Assert Cookie Present | assertCookiePresent | name |  | 
64 | Assert Css Count | assertCssCount | css | text | 
65 | Assert Cursor Position | assertCursorPosition | locator | text | 
66 | Assert Cursor Position | assertCursorPosition | parentLocator | locator | text
67 | Assert Date List Order Asc | assertDateListOrderAsc | locator | format | 
68 | Assert Date List Order Asc | assertDateListOrderAsc | parentLocator | locator | format
69 | Assert Date List Order Desc | assertDateListOrderDesc | locator | format | 
70 | Assert Date List Order Desc | assertDateListOrderDesc | parentLocator | locator | format
71 | Assert Editable | assertEditable | locator |  | 
72 | Assert Editable | assertEditable | parentLocator | locator | 
73 | Assert Element Height | assertElementHeight | locator | text | 
74 | Assert Element Height | assertElementHeight | parentLocator | locator | text
75 | Assert Element Index | assertElementIndex | locator | text | 
76 | Assert Element Index | assertElementIndex | parentLocator | locator | text
77 | Assert Element Not Present | assertElementNotPresent | locator |  | 
78 | Assert Element Not Present | assertElementNotPresent | parentLocator | locator | 
79 | Assert Element Position Left | assertElementPositionLeft | locator | text | 
80 | Assert Element Position Left | assertElementPositionLeft | parentLocator | locator | text
81 | Assert Element Position Top | assertElementPositionTop | locator | text | 
82 | Assert Element Position Top | assertElementPositionTop | parentLocator | locator | text
83 | Assert Element Present | assertElementPresent | locator |  | 
84 | Assert Element Present | assertElementPresent | parentLocator | locator | 
85 | Assert Element Width | assertElementWidth | locator | text | 
86 | Assert Element Width | assertElementWidth | parentLocator | locator | text
87 | Assert Eval | assertEval | expression | text | 
88 | Assert Eval Script | assertEvalScript | script | text | 
89 | Assert Eval Script Match | assertEvalScriptMatch | script | text | 
90 | Assert Eval Script Not Match | assertEvalScriptNotMatch | script | text | 
91 | Assert Exists In Database | assertExistsInDatabase | sql |  | 
92 | Assert Expression | assertExpression | expression | text | 
93 | Assert Expression Match | assertExpressionMatch | expression | text | 
94 | Assert Expression Not Match | assertExpressionNotMatch | expression | text | 
95 | Assert Font Family | assertFontFamily | locator | text | 
96 | Assert Font Family | assertFontFamily | parentLocator | locator | text
97 | Assert Font Family Match | assertFontFamilyMatch | locator | text | 
98 | Assert Font Family Match | assertFontFamilyMatch | parentLocator | locator | text
99 | Assert Font Family Not Match | assertFontFamilyNotMatch | locator | text | 
100 | Assert Font Family Not Match | assertFontFamilyNotMatch | parentLocator | locator | text
101 | Assert Font Size | assertFontSize | locator | text | 
102 | Assert Font Size | assertFontSize | parentLocator | locator | text
103 | Assert Font Size Match | assertFontSizeMatch | locator | text | 
104 | Assert Font Size Match | assertFontSizeMatch | parentLocator | locator | text
105 | Assert Font Size Not Match | assertFontSizeNotMatch | locator | text | 
106 | Assert Font Size Not Match | assertFontSizeNotMatch | parentLocator | locator | text
107 | Assert Font Style | assertFontStyle | locator | text | 
108 | Assert Font Style | assertFontStyle | parentLocator | locator | text
109 | Assert Font Style Match | assertFontStyleMatch | locator | text | 
110 | Assert Font Style Match | assertFontStyleMatch | parentLocator | locator | text
111 | Assert Font Style Not Match | assertFontStyleNotMatch | locator | text | 
112 | Assert Font Style Not Match | assertFontStyleNotMatch | parentLocator | locator | text
113 | Assert Font Weight | assertFontWeight | locator | text | 
114 | Assert Font Weight | assertFontWeight | parentLocator | locator | text
115 | Assert Font Weight Match | assertFontWeightMatch | locator | text | 
116 | Assert Font Weight Match | assertFontWeightMatch | parentLocator | locator | text
117 | Assert Font Weight Not Match | assertFontWeightNotMatch | locator | text | 
118 | Assert Font Weight Not Match | assertFontWeightNotMatch | parentLocator | locator | text
119 | Assert Html Source | assertHtmlSource | text |  | 
120 | Assert Html Source Match | assertHtmlSourceMatch | text |  | 
121 | Assert Html Source Not Match | assertHtmlSourceNotMatch | text |  | 
122 | Assert Integer List Order Asc | assertIntegerListOrderAsc | locator |  | 
123 | Assert Integer List Order Asc | assertIntegerListOrderAsc | parentLocator | locator | 
124 | Assert Integer List Order Desc | assertIntegerListOrderDesc | locator |  | 
125 | Assert Integer List Order Desc | assertIntegerListOrderDesc | parentLocator | locator | 
126 | Assert List Contain | assertListContain | variable | text | 
127 | Assert List Not Contain | assertListNotContain | variable | text | 
128 | Assert List Order Asc | assertListOrderAsc | variable |  | 
129 | Assert List Order Desc | assertListOrderDesc | variable |  | 
130 | Assert Location | assertLocation | text |  | 
131 | Assert Location Match | assertLocationMatch | text |  | 
132 | Assert Location Not Match | assertLocationNotMatch | text |  | 
133 | Assert Not Alert | assertNotAlert | text |  | 
134 | Assert Not All Buttons | assertNotAllButtons | text |  | 
135 | Assert Not All Fields | assertNotAllFields | text |  | 
136 | Assert Not All Links | assertNotAllLinks | text |  | 
137 | Assert Not All Window Names | assertNotAllWindowNames | text |  | 
138 | Assert Not All Window Titles | assertNotAllWindowTitles | text |  | 
139 | Assert Not Attribute | assertNotAttribute | locator | name | text
140 | Assert Not Attribute From All Windows | assertNotAttributeFromAllWindows | attributeName | text | 
141 | Assert Not Background Color | assertNotBackgroundColor | locator | text | 
142 | Assert Not Background Color | assertNotBackgroundColor | parentLocator | locator | text
143 | Assert Not Body Text | assertNotBodyText | text |  | 
144 | Assert Not Border Color | assertNotBorderColor | locator | text | 
145 | Assert Not Border Color | assertNotBorderColor | parentLocator | locator | text
146 | Assert Not Checked | assertNotChecked | locator |  | 
147 | Assert Not Checked | assertNotChecked | parentLocator | locator | 
148 | Assert Not Color | assertNotColor | locator | text | 
149 | Assert Not Color | assertNotColor | parentLocator | locator | text
150 | Assert Not Confirmation | assertNotConfirmation | text |  | 
151 | Assert Not Cookie | assertNotCookie | text |  | 
152 | Assert Not Cookie By Name | assertNotCookieByName | name | text | 
153 | Assert Not Css Count | assertNotCssCount | css | text | 
154 | Assert Not Cursor Position | assertNotCursorPosition | locator | text | 
155 | Assert Not Cursor Position | assertNotCursorPosition | parentLocator | locator | text
156 | Assert Not Editable | assertNotEditable | locator |  | 
157 | Assert Not Editable | assertNotEditable | parentLocator | locator | 
158 | Assert Not Element Height | assertNotElementHeight | locator | text | 
159 | Assert Not Element Height | assertNotElementHeight | parentLocator | locator | text
160 | Assert Not Element Index | assertNotElementIndex | locator | text | 
161 | Assert Not Element Index | assertNotElementIndex | parentLocator | locator | text
162 | Assert Not Element Position Left | assertNotElementPositionLeft | locator | text | 
163 | Assert Not Element Position Left | assertNotElementPositionLeft | parentLocator | locator | text
164 | Assert Not Element Position Top | assertNotElementPositionTop | locator | text | 
165 | Assert Not Element Position Top | assertNotElementPositionTop | parentLocator | locator | text
166 | Assert Not Element Width | assertNotElementWidth | locator | text | 
167 | Assert Not Element Width | assertNotElementWidth | parentLocator | locator | text
168 | Assert Not Eval | assertNotEval | expression | text | 
169 | Assert Not Eval Script | assertNotEvalScript | script | text | 
170 | Assert Not Exists In Database | assertNotExistsInDatabase | sql |  | 
171 | Assert Not Expression | assertNotExpression | expression | text | 
172 | Assert Not Font Family | assertNotFontFamily | locator | text | 
173 | Assert Not Font Family | assertNotFontFamily | parentLocator | locator | text
174 | Assert Not Font Size | assertNotFontSize | locator | text | 
175 | Assert Not Font Size | assertNotFontSize | parentLocator | locator | text
176 | Assert Not Font Style | assertNotFontStyle | locator | text | 
177 | Assert Not Font Style | assertNotFontStyle | parentLocator | locator | text
178 | Assert Not Font Weight | assertNotFontWeight | locator | text | 
179 | Assert Not Font Weight | assertNotFontWeight | parentLocator | locator | text
180 | Assert Not Html Source | assertNotHtmlSource | text |  | 
181 | Assert Not Location | assertNotLocation | text |  | 
182 | Assert Not Ordered | assertNotOrdered | firstLocator | secondLocator | 
183 | Assert Not Prompt | assertNotPrompt | text |  | 
184 | Assert Not Select Options | assertNotSelectOptions | locator | text | 
185 | Assert Not Select Options | assertNotSelectOptions | parentLocator | locator | text
186 | Assert Not Selected Id | assertNotSelectedId | locator | text | 
187 | Assert Not Selected Id | assertNotSelectedId | parentLocator | locator | text
188 | Assert Not Selected Ids | assertNotSelectedIds | locator | text | 
189 | Assert Not Selected Ids | assertNotSelectedIds | parentLocator | locator | text
190 | Assert Not Selected Index | assertNotSelectedIndex | locator | text | 
191 | Assert Not Selected Index | assertNotSelectedIndex | parentLocator | locator | text
192 | Assert Not Selected Indexes | assertNotSelectedIndexes | locator | text | 
193 | Assert Not Selected Indexes | assertNotSelectedIndexes | parentLocator | locator | text
194 | Assert Not Selected Label | assertNotSelectedLabel | locator | text | 
195 | Assert Not Selected Label | assertNotSelectedLabel | parentLocator | locator | text
196 | Assert Not Selected Labels | assertNotSelectedLabels | locator | text | 
197 | Assert Not Selected Labels | assertNotSelectedLabels | parentLocator | locator | text
198 | Assert Not Selected Value | assertNotSelectedValue | locator | text | 
199 | Assert Not Selected Value | assertNotSelectedValue | parentLocator | locator | text
200 | Assert Not Selected Values | assertNotSelectedValues | locator | text | 
201 | Assert Not Selected Values | assertNotSelectedValues | parentLocator | locator | text
202 | Assert Not Something Selected | assertNotSomethingSelected | locator |  | 
203 | Assert Not Something Selected | assertNotSomethingSelected | parentLocator | locator | 
204 | Assert Not Table | assertNotTable | locator | cellAddress | text
205 | Assert Not Text | assertNotText | locator | text | 
206 | Assert Not Text | assertNotText | parentLocator | locator | text
207 | Assert Not Text Alignment | assertNotTextAlignment | locator | text | 
208 | Assert Not Text Alignment | assertNotTextAlignment | parentLocator | locator | text
209 | Assert Not Text Decoration | assertNotTextDecoration | locator | text | 
210 | Assert Not Text Decoration | assertNotTextDecoration | parentLocator | locator | text
211 | Assert Not Text Empty | assertNotTextEmpty | locator |  | 
212 | Assert Not Text Empty | assertNotTextEmpty | parentLocator | locator | 
213 | Assert Not Title | assertNotTitle | text |  | 
214 | Assert Not Value | assertNotValue | locator | text | 
215 | Assert Not Value | assertNotValue | parentLocator | locator | text
216 | Assert Not Value Empty | assertNotValueEmpty | locator |  | 
217 | Assert Not Value Empty | assertNotValueEmpty | parentLocator | locator | 
218 | Assert Not Variable | assertNotVariable | variable | text | 
219 | Assert Not Visible | assertNotVisible | locator |  | 
220 | Assert Not Visible | assertNotVisible | parentLocator | locator | 
221 | Assert Not Xpath Count | assertNotXpathCount | xpath | text | 
222 | Assert Ordered | assertOrdered | firstLocator | secondLocator | 
223 | Assert Prompt | assertPrompt | text |  | 
224 | Assert Prompt Match | assertPromptMatch | text |  | 
225 | Assert Prompt Not Match | assertPromptNotMatch | text |  | 
226 | Assert Prompt Not Present | assertPromptNotPresent |  |  | 
227 | Assert Prompt Present | assertPromptPresent |  |  | 
228 | Assert Row Count | assertRowCount | sql | count | 
229 | Assert Row Count Greater Than | assertRowCountGreaterThan | sql | count | 
230 | Assert Row Count Less Than | assertRowCountLessThan | sql | count | 
231 | Assert Select Options | assertSelectOptions | locator | text | 
232 | Assert Select Options | assertSelectOptions | parentLocator | locator | text
233 | Assert Select Options Match | assertSelectOptionsMatch | locator | text | 
234 | Assert Select Options Match | assertSelectOptionsMatch | parentLocator | locator | text
235 | Assert Select Options Not Match | assertSelectOptionsNotMatch | locator | text | 
236 | Assert Select Options Not Match | assertSelectOptionsNotMatch | parentLocator | locator | text
237 | Assert Selected Id | assertSelectedId | locator | text | 
238 | Assert Selected Id | assertSelectedId | parentLocator | locator | text
239 | Assert Selected Id Match | assertSelectedIdMatch | locator | text | 
240 | Assert Selected Id Match | assertSelectedIdMatch | parentLocator | locator | text
241 | Assert Selected Id Not Match | assertSelectedIdNotMatch | locator | text | 
242 | Assert Selected Id Not Match | assertSelectedIdNotMatch | parentLocator | locator | text
243 | Assert Selected Ids | assertSelectedIds | locator | text | 
244 | Assert Selected Ids | assertSelectedIds | parentLocator | locator | text
245 | Assert Selected Ids Match | assertSelectedIdsMatch | locator | text | 
246 | Assert Selected Ids Match | assertSelectedIdsMatch | parentLocator | locator | text
247 | Assert Selected Ids Not Match | assertSelectedIdsNotMatch | locator | text | 
248 | Assert Selected Ids Not Match | assertSelectedIdsNotMatch | parentLocator | locator | text
249 | Assert Selected Index | assertSelectedIndex | locator | text | 
250 | Assert Selected Index | assertSelectedIndex | parentLocator | locator | text
251 | Assert Selected Index Match | assertSelectedIndexMatch | locator | text | 
252 | Assert Selected Index Match | assertSelectedIndexMatch | parentLocator | locator | text
253 | Assert Selected Index Not Match | assertSelectedIndexNotMatch | locator | text | 
254 | Assert Selected Index Not Match | assertSelectedIndexNotMatch | parentLocator | locator | text
255 | Assert Selected Indexes | assertSelectedIndexes | locator | text | 
256 | Assert Selected Indexes | assertSelectedIndexes | parentLocator | locator | text
257 | Assert Selected Indexes Match | assertSelectedIndexesMatch | locator | text | 
258 | Assert Selected Indexes Match | assertSelectedIndexesMatch | parentLocator | locator | text
259 | Assert Selected Indexes Not Match | assertSelectedIndexesNotMatch | locator | text | 
260 | Assert Selected Indexes Not Match | assertSelectedIndexesNotMatch | parentLocator | locator | text
261 | Assert Selected Label | assertSelectedLabel | locator | text | 
262 | Assert Selected Label | assertSelectedLabel | parentLocator | locator | text
263 | Assert Selected Label Match | assertSelectedLabelMatch | locator | text | 
264 | Assert Selected Label Match | assertSelectedLabelMatch | parentLocator | locator | text
265 | Assert Selected Label Not Match | assertSelectedLabelNotMatch | locator | text | 
266 | Assert Selected Label Not Match | assertSelectedLabelNotMatch | parentLocator | locator | text
267 | Assert Selected Labels | assertSelectedLabels | locator | text | 
268 | Assert Selected Labels | assertSelectedLabels | parentLocator | locator | text
269 | Assert Selected Labels Match | assertSelectedLabelsMatch | locator | text | 
270 | Assert Selected Labels Match | assertSelectedLabelsMatch | parentLocator | locator | text
271 | Assert Selected Labels Not Match | assertSelectedLabelsNotMatch | locator | text | 
272 | Assert Selected Labels Not Match | assertSelectedLabelsNotMatch | parentLocator | locator | text
273 | Assert Selected Value | assertSelectedValue | locator | text | 
274 | Assert Selected Value | assertSelectedValue | parentLocator | locator | text
275 | Assert Selected Value Match | assertSelectedValueMatch | locator | text | 
276 | Assert Selected Value Match | assertSelectedValueMatch | parentLocator | locator | text
277 | Assert Selected Value Not Match | assertSelectedValueNotMatch | locator | text | 
278 | Assert Selected Value Not Match | assertSelectedValueNotMatch | parentLocator | locator | text
279 | Assert Selected Values | assertSelectedValues | locator | text | 
280 | Assert Selected Values | assertSelectedValues | parentLocator | locator | text
281 | Assert Selected Values Match | assertSelectedValuesMatch | locator | text | 
282 | Assert Selected Values Match | assertSelectedValuesMatch | parentLocator | locator | text
283 | Assert Selected Values Not Match | assertSelectedValuesNotMatch | locator | text | 
284 | Assert Selected Values Not Match | assertSelectedValuesNotMatch | parentLocator | locator | text
285 | Assert Something Selected | assertSomethingSelected | locator |  | 
286 | Assert Something Selected | assertSomethingSelected | parentLocator | locator | 
287 | Assert Table | assertTable | locator | cellAddress | text
288 | Assert Table Match | assertTableMatch | locator | cellAddress | text
289 | Assert Table Not Match | assertTableNotMatch | locator | cellAddress | text
290 | Assert Text | assertText | locator | text | 
291 | Assert Text | assertText | parentLocator | locator | text
292 | Assert Text Alignment | assertTextAlignment | locator | text | 
293 | Assert Text Alignment | assertTextAlignment | parentLocator | locator | text
294 | Assert Text Alignment Match | assertTextAlignmentMatch | locator | text | 
295 | Assert Text Alignment Match | assertTextAlignmentMatch | parentLocator | locator | text
296 | Assert Text Alignment Not Match | assertTextAlignmentNotMatch | locator | text | 
297 | Assert Text Alignment Not Match | assertTextAlignmentNotMatch | parentLocator | locator | text
298 | Assert Text Decoration | assertTextDecoration | locator | text | 
299 | Assert Text Decoration | assertTextDecoration | parentLocator | locator | text
300 | Assert Text Decoration Match | assertTextDecorationMatch | locator | text | 
301 | Assert Text Decoration Match | assertTextDecorationMatch | parentLocator | locator | text
302 | Assert Text Decoration Not Match | assertTextDecorationNotMatch | locator | text | 
303 | Assert Text Decoration Not Match | assertTextDecorationNotMatch | parentLocator | locator | text
304 | Assert Text Empty | assertTextEmpty | locator |  | 
305 | Assert Text Empty | assertTextEmpty | parentLocator | locator | 
306 | Assert Text List Order Asc | assertTextListOrderAsc | locator |  | 
307 | Assert Text List Order Asc | assertTextListOrderAsc | parentLocator | locator | 
308 | Assert Text List Order Desc | assertTextListOrderDesc | locator |  | 
309 | Assert Text List Order Desc | assertTextListOrderDesc | parentLocator | locator | 
310 | Assert Text Match | assertTextMatch | locator | text | 
311 | Assert Text Match | assertTextMatch | parentLocator | locator | text
312 | Assert Text Not Match | assertTextNotMatch | locator | text | 
313 | Assert Text Not Match | assertTextNotMatch | parentLocator | locator | text
314 | Assert Text Not Present | assertTextNotPresent | pattern |  | 
315 | Assert Text Present | assertTextPresent | pattern |  | 
316 | Assert Title | assertTitle | text |  | 
317 | Assert Title Match | assertTitleMatch | text |  | 
318 | Assert Title Not Match | assertTitleNotMatch | text |  | 
319 | Assert Value | assertValue | locator | text | 
320 | Assert Value | assertValue | parentLocator | locator | text
321 | Assert Value Empty | assertValueEmpty | locator |  | 
322 | Assert Value Empty | assertValueEmpty | parentLocator | locator | 
323 | Assert Value Match | assertValueMatch | locator | text | 
324 | Assert Value Match | assertValueMatch | parentLocator | locator | text
325 | Assert Value Not Match | assertValueNotMatch | locator | text | 
326 | Assert Value Not Match | assertValueNotMatch | parentLocator | locator | text
327 | Assert Variable | assertVariable | variable | text | 
328 | Assert Visible | assertVisible | locator |  | 
329 | Assert Visible | assertVisible | parentLocator | locator | 
330 | Assert Xpath Count | assertXpathCount | xpath | text | 
331 | Assign Id | assignId | locator | identifier | 
332 | Assign Id | assignId | parentLocator | locator | identifier
333 | Attach File | attachFile | locator | filePath | 
334 | Attach File | attachFile | parentLocator | locator | filePath
335 | Blur | blur | locator |  | 
336 | Blur | blur | parentLocator | locator | 
337 | Check | check | locator |  | 
338 | Check | check | parentLocator | locator | 
339 | Choose Cancel Confirmation | chooseCancelConfirmation |  |  | 
340 | Choose Cancel Prompt | chooseCancelPrompt |  |  | 
341 | Choose Ok Alert | chooseOkAlert |  |  | 
342 | Choose Ok Confirmation | chooseOkConfirmation |  |  | 
343 | Clear | clear | locator |  | 
344 | Clear | clear | parentLocator | locator | 
345 | Click | click | locator |  | 
346 | Click | click | parentLocator | locator | 
347 | Click At | clickAt | locator | coordString | 
348 | Click At | clickAt | parentLocator | locator | coordString
349 | Close | close |  |  | 
350 | Context Menu | contextMenu | locator |  | 
351 | Context Menu | contextMenu | parentLocator | locator | 
352 | Context Menu At | contextMenuAt | locator | coordString | 
353 | Context Menu At | contextMenuAt | parentLocator | locator | coordString
354 | Control Key Down | controlKeyDown |  |  | 
355 | Control Key Up | controlKeyUp |  |  | 
356 | Create Cookie | createCookie | nameValuePair | optionsString | 
357 | Delete All Visible Cookies | deleteAllVisibleCookies |  |  | 
358 | Delete Cookie | deleteCookie | name |  | 
359 | Deselect Pop Up | deselectPopUp |  |  | 
360 | Double Click | doubleClick | locator |  | 
361 | Double Click | doubleClick | parentLocator | locator | 
362 | Double Click At | doubleClickAt | locator | coordString | 
363 | Double Click At | doubleClickAt | parentLocator | locator | coordString
364 | Drag And Drop | dragAndDrop | locator | movementsString | 
365 | Drag And Drop | dragAndDrop | parentLocator | locator | movementsString
366 | Drag And Drop To Object | dragAndDropToObject | toBeDraggedObjectLocator | dragDestinationObjectLocator | 
367 | Echo | echo | message |  | 
368 | Execute | execute | action |  | 
369 | Execute Each | executeEach | action | locator | variable
370 | Execute If Alert | executeIfAlert | action | text | 
371 | Execute If Alert Match | executeIfAlertMatch | action | text | 
372 | Execute If Alert Not Match | executeIfAlertNotMatch | action | text | 
373 | Execute If Alert Not Present | executeIfAlertNotPresent | action |  | 
374 | Execute If Alert Present | executeIfAlertPresent | action |  | 
375 | Execute If Body Text | executeIfBodyText | action | text | 
376 | Execute If Body Text Match | executeIfBodyTextMatch | action | text | 
377 | Execute If Body Text Not Match | executeIfBodyTextNotMatch | action | text | 
378 | Execute If Checked | executeIfChecked | action | locator | 
379 | Execute If Checked | executeIfChecked | action | parentLocator | locator
380 | Execute If Confirmation | executeIfConfirmation | action | text | 
381 | Execute If Confirmation Match | executeIfConfirmationMatch | action | text | 
382 | Execute If Confirmation Not Match | executeIfConfirmationNotMatch | action | text | 
383 | Execute If Confirmation Not Present | executeIfConfirmationNotPresent | action |  | 
384 | Execute If Confirmation Present | executeIfConfirmationPresent | action |  | 
385 | Execute If Cookie | executeIfCookie | action | text | 
386 | Execute If Cookie By Name | executeIfCookieByName | action | name | text
387 | Execute If Cookie By Name Match | executeIfCookieByNameMatch | action | name | text
388 | Execute If Cookie By Name Not Match | executeIfCookieByNameNotMatch | action | name | text
389 | Execute If Cookie Match | executeIfCookieMatch | action | text | 
390 | Execute If Cookie Not Match | executeIfCookieNotMatch | action | text | 
391 | Execute If Cookie Not Present | executeIfCookieNotPresent | action | name | 
392 | Execute If Cookie Present | executeIfCookiePresent | action | name | 
393 | Execute If Editable | executeIfEditable | action | locator | 
394 | Execute If Editable | executeIfEditable | action | parentLocator | locator
395 | Execute If Element Not Present | executeIfElementNotPresent | action | locator | 
396 | Execute If Element Not Present | executeIfElementNotPresent | action | parentLocator | locator
397 | Execute If Element Present | executeIfElementPresent | action | locator | 
398 | Execute If Element Present | executeIfElementPresent | action | parentLocator | locator
399 | Execute If Eval | executeIfEval | action | expression | text
400 | Execute If Eval Script | executeIfEvalScript | action | script | text
401 | Execute If Eval Script Match | executeIfEvalScriptMatch | action | script | text
402 | Execute If Eval Script Not Match | executeIfEvalScriptNotMatch | action | script | text
403 | Execute If Exists In Database | executeIfExistsInDatabase | action | sql | 
404 | Execute If Expression | executeIfExpression | action | expression | text
405 | Execute If Expression Match | executeIfExpressionMatch | action | expression | text
406 | Execute If Expression Not Match | executeIfExpressionNotMatch | action | expression | text
407 | Execute If Html Source | executeIfHtmlSource | action | text | 
408 | Execute If Html Source Match | executeIfHtmlSourceMatch | action | text | 
409 | Execute If Html Source Not Match | executeIfHtmlSourceNotMatch | action | text | 
410 | Execute If List Contain | executeIfListContain | action | variable | text
411 | Execute If List Not Contain | executeIfListNotContain | action | variable | text
412 | Execute If Location | executeIfLocation | action | text | 
413 | Execute If Location Match | executeIfLocationMatch | action | text | 
414 | Execute If Location Not Match | executeIfLocationNotMatch | action | text | 
415 | Execute If Not Alert | executeIfNotAlert | action | text | 
416 | Execute If Not Body Text | executeIfNotBodyText | action | text | 
417 | Execute If Not Checked | executeIfNotChecked | action | locator | 
418 | Execute If Not Checked | executeIfNotChecked | action | parentLocator | locator
419 | Execute If Not Confirmation | executeIfNotConfirmation | action | text | 
420 | Execute If Not Cookie | executeIfNotCookie | action | text | 
421 | Execute If Not Cookie By Name | executeIfNotCookieByName | action | name | text
422 | Execute If Not Editable | executeIfNotEditable | action | locator | 
423 | Execute If Not Editable | executeIfNotEditable | action | parentLocator | locator
424 | Execute If Not Eval | executeIfNotEval | action | expression | text
425 | Execute If Not Eval Script | executeIfNotEvalScript | action | script | text
426 | Execute If Not Exists In Database | executeIfNotExistsInDatabase | action | sql | 
427 | Execute If Not Expression | executeIfNotExpression | action | expression | text
428 | Execute If Not Html Source | executeIfNotHtmlSource | action | text | 
429 | Execute If Not Location | executeIfNotLocation | action | text | 
430 | Execute If Not Prompt | executeIfNotPrompt | action | text | 
431 | Execute If Not Selected Id | executeIfNotSelectedId | action | locator | text
432 | Execute If Not Selected Index | executeIfNotSelectedIndex | action | locator | text
433 | Execute If Not Selected Label | executeIfNotSelectedLabel | action | locator | text
434 | Execute If Not Selected Value | executeIfNotSelectedValue | action | locator | text
435 | Execute If Not Something Selected | executeIfNotSomethingSelected | action | locator | 
436 | Execute If Not Something Selected | executeIfNotSomethingSelected | action | parentLocator | locator
437 | Execute If Not Text | executeIfNotText | action | locator | text
438 | Execute If Not Text Empty | executeIfNotTextEmpty | action | locator | 
439 | Execute If Not Text Empty | executeIfNotTextEmpty | action | parentLocator | locator
440 | Execute If Not Title | executeIfNotTitle | action | text | 
441 | Execute If Not Value | executeIfNotValue | action | locator | text
442 | Execute If Not Value Empty | executeIfNotValueEmpty | action | locator | 
443 | Execute If Not Value Empty | executeIfNotValueEmpty | action | parentLocator | locator
444 | Execute If Not Variable | executeIfNotVariable | action | variable | text
445 | Execute If Not Visible | executeIfNotVisible | action | locator | 
446 | Execute If Not Visible | executeIfNotVisible | action | parentLocator | locator
447 | Execute If Prompt | executeIfPrompt | action | text | 
448 | Execute If Prompt Match | executeIfPromptMatch | action | text | 
449 | Execute If Prompt Not Match | executeIfPromptNotMatch | action | text | 
450 | Execute If Prompt Not Present | executeIfPromptNotPresent | action |  | 
451 | Execute If Prompt Present | executeIfPromptPresent | action |  | 
452 | Execute If Selected Id | executeIfSelectedId | action | locator | text
453 | Execute If Selected Id Match | executeIfSelectedIdMatch | action | locator | text
454 | Execute If Selected Id Not Match | executeIfSelectedIdNotMatch | action | locator | text
455 | Execute If Selected Index | executeIfSelectedIndex | action | locator | text
456 | Execute If Selected Index Match | executeIfSelectedIndexMatch | action | locator | text
457 | Execute If Selected Index Not Match | executeIfSelectedIndexNotMatch | action | locator | text
458 | Execute If Selected Label | executeIfSelectedLabel | action | locator | text
459 | Execute If Selected Label Match | executeIfSelectedLabelMatch | action | locator | text
460 | Execute If Selected Label Not Match | executeIfSelectedLabelNotMatch | action | locator | text
461 | Execute If Selected Value | executeIfSelectedValue | action | locator | text
462 | Execute If Selected Value Match | executeIfSelectedValueMatch | action | locator | text
463 | Execute If Selected Value Not Match | executeIfSelectedValueNotMatch | action | locator | text
464 | Execute If Something Selected | executeIfSomethingSelected | action | locator | 
465 | Execute If Something Selected | executeIfSomethingSelected | action | parentLocator | locator
466 | Execute If Text | executeIfText | action | locator | text
467 | Execute If Text Empty | executeIfTextEmpty | action | locator | 
468 | Execute If Text Empty | executeIfTextEmpty | action | parentLocator | locator
469 | Execute If Text Match | executeIfTextMatch | action | locator | text
470 | Execute If Text Not Match | executeIfTextNotMatch | action | locator | text
471 | Execute If Text Not Present | executeIfTextNotPresent | action | pattern | 
472 | Execute If Text Present | executeIfTextPresent | action | pattern | 
473 | Execute If Title | executeIfTitle | action | text | 
474 | Execute If Title Match | executeIfTitleMatch | action | text | 
475 | Execute If Title Not Match | executeIfTitleNotMatch | action | text | 
476 | Execute If Value | executeIfValue | action | locator | text
477 | Execute If Value Empty | executeIfValueEmpty | action | locator | 
478 | Execute If Value Empty | executeIfValueEmpty | action | parentLocator | locator
479 | Execute If Value Match | executeIfValueMatch | action | locator | text
480 | Execute If Value Not Match | executeIfValueNotMatch | action | locator | text
481 | Execute If Variable | executeIfVariable | action | variable | text
482 | Execute If Visible | executeIfVisible | action | locator | 
483 | Execute If Visible | executeIfVisible | action | parentLocator | locator
484 | Execute Loop | executeLoop | action | times | 
485 | Fire Event | fireEvent | locator | eventName | 
486 | Fire Event | fireEvent | parentLocator | locator | eventName
487 | Focus | focus | locator |  | 
488 | Focus | focus | parentLocator | locator | 
489 | Go Back | goBack |  |  | 
490 | Go Forward | goForward |  |  | 
491 | Highlight | highlight | locator |  | 
492 | Highlight | highlight | parentLocator | locator | 
493 | Key Down | keyDown | keycode |  | 
494 | Key Down | keyDown | locator | keySequence | 
495 | Key Down | keyDown | parentLocator | locator | keySequence
496 | Key Press | keyPress | keycode |  | 
497 | Key Press | keyPress | locator | keySequence | 
498 | Key Press | keyPress | parentLocator | locator | keySequence
499 | Key Up | keyUp | keycode |  | 
500 | Key Up | keyUp | locator | keySequence | 
501 | Key Up | keyUp | parentLocator | locator | keySequence
502 | Meta Key Down | metaKeyDown |  |  | 
503 | Meta Key Up | metaKeyUp |  |  | 
504 | Mouse Down | mouseDown | locator |  | 
505 | Mouse Down | mouseDown | parentLocator | locator | 
506 | Mouse Down At | mouseDownAt | locator | coordString | 
507 | Mouse Down At | mouseDownAt | parentLocator | locator | coordString
508 | Mouse Move | mouseMove | locator |  | 
509 | Mouse Move | mouseMove | parentLocator | locator | 
510 | Mouse Move At | mouseMoveAt | locator | coordString | 
511 | Mouse Move At | mouseMoveAt | parentLocator | locator | coordString
512 | Mouse Out | mouseOut | locator |  | 
513 | Mouse Out | mouseOut | parentLocator | locator | 
514 | Mouse Over | mouseOver | locator |  | 
515 | Mouse Over | mouseOver | parentLocator | locator | 
516 | Mouse Up | mouseUp | locator |  | 
517 | Mouse Up | mouseUp | parentLocator | locator | 
518 | Mouse Up At | mouseUpAt | locator | coordString | 
519 | Mouse Up At | mouseUpAt | parentLocator | locator | coordString
520 | Open | open | url |  | 
521 | Open Window | openWindow | url |  | 
522 | Open Window | openWindow | url | windowID | 
523 | Pause | pause | waitTime |  | 
524 | Refresh | refresh |  |  | 
525 | Remove All Selections | removeAllSelections | locator |  | 
526 | Remove All Selections | removeAllSelections | parentLocator | locator | 
527 | Remove Selection | removeSelection | locator | optionLocator | 
528 | Remove Selection | removeSelection | parentLocator | locator | optionLocator
529 | Remove Selection Id | removeSelectionId | locator | id | 
530 | Remove Selection Id | removeSelectionId | parentLocator | locator | id
531 | Remove Selection Index | removeSelectionIndex | locator | index | 
532 | Remove Selection Index | removeSelectionIndex | parentLocator | locator | index
533 | Remove Selection Label | removeSelectionLabel | locator | label | 
534 | Remove Selection Label | removeSelectionLabel | parentLocator | locator | label
535 | Remove Selection Value | removeSelectionValue | locator | value | 
536 | Remove Selection Value | removeSelectionValue | parentLocator | locator | value
537 | Run Script | runScript | script |  | 
538 | Select | select | locator | optionLocator | 
539 | Select | select | parentLocator | locator | optionLocator
540 | Select First Window | selectFirstWindow |  |  | 
541 | Select Frame | selectFrame | locator |  | 
542 | Select Id | selectId | locator | id | 
543 | Select Id | selectId | parentLocator | locator | id
544 | Select Index | selectIndex | locator | index | 
545 | Select Index | selectIndex | parentLocator | locator | index
546 | Select Label | selectLabel | locator | label | 
547 | Select Label | selectLabel | parentLocator | locator | label
548 | Select Last Window | selectLastWindow |  |  | 
549 | Select Parent Frame | selectParentFrame |  |  | 
550 | Select Pop Up | selectPopUp | windowID |  | 
551 | Select Value | selectValue | locator | value | 
552 | Select Value | selectValue | parentLocator | locator | value
553 | Select Window | selectWindow | windowID |  | 
554 | Set Cursor Position | setCursorPosition | locator | position | 
555 | Set Cursor Position | setCursorPosition | parentLocator | locator | position
556 | Set Timeout | setTimeout | timeout |  | 
557 | Shift Key Down | shiftKeyDown |  |  | 
558 | Shift Key Up | shiftKeyUp |  |  | 
559 | Store | store | text | variable | 
560 | Store Alert | storeAlert | variable |  | 
561 | Store All Buttons | storeAllButtons | variable |  | 
562 | Store All Fields | storeAllFields | variable |  | 
563 | Store All Links | storeAllLinks | variable |  | 
564 | Store All Window Names | storeAllWindowNames | variable |  | 
565 | Store All Window Titles | storeAllWindowTitles | variable |  | 
566 | Store Attribute | storeAttribute | locator | name | variable
567 | Store Attribute From All Windows | storeAttributeFromAllWindows | attributeName | variable | 
568 | Store Body Text | storeBodyText | variable |  | 
569 | Store Confirmation | storeConfirmation | variable |  | 
570 | Store Cookie | storeCookie | variable |  | 
571 | Store Cookie By Name | storeCookieByName | name | variable | 
572 | Store Current Date | storeCurrentDate | variable |  | 
573 | Store Cursor Position | storeCursorPosition | locator | variable | 
574 | Store Cursor Position | storeCursorPosition | parentLocator | locator | variable
575 | Store Eval | storeEval | expression | variable | 
576 | Store Eval Script | storeEvalScript | script | variable | 
577 | Store Expression | storeExpression | expression | variable | 
578 | Store Html Source | storeHtmlSource | variable |  | 
579 | Store Location | storeLocation | variable |  | 
580 | Store Prompt | storePrompt | variable |  | 
581 | Store Push | storePush | text | variable | 
582 | Store Select Options | storeSelectOptions | locator | variable | 
583 | Store Select Options | storeSelectOptions | parentLocator | locator | variable
584 | Store Selected Id | storeSelectedId | locator | variable | 
585 | Store Selected Id | storeSelectedId | parentLocator | locator | variable
586 | Store Selected Ids | storeSelectedIds | locator | variable | 
587 | Store Selected Ids | storeSelectedIds | parentLocator | locator | variable
588 | Store Selected Index | storeSelectedIndex | locator | variable | 
589 | Store Selected Index | storeSelectedIndex | parentLocator | locator | variable
590 | Store Selected Indexes | storeSelectedIndexes | locator | variable | 
591 | Store Selected Indexes | storeSelectedIndexes | parentLocator | locator | variable
592 | Store Selected Label | storeSelectedLabel | locator | variable | 
593 | Store Selected Label | storeSelectedLabel | parentLocator | locator | variable
594 | Store Selected Labels | storeSelectedLabels | locator | variable | 
595 | Store Selected Labels | storeSelectedLabels | parentLocator | locator | variable
596 | Store Selected Value | storeSelectedValue | locator | variable | 
597 | Store Selected Value | storeSelectedValue | parentLocator | locator | variable
598 | Store Selected Values | storeSelectedValues | locator | variable | 
599 | Store Selected Values | storeSelectedValues | parentLocator | locator | variable
600 | Store Table | storeTable | locator | cellAddress | variable
601 | Store Text | storeText | locator | variable | 
602 | Store Text | storeText | parentLocator | locator | variable
603 | Store Title | storeTitle | variable |  | 
604 | Store Value | storeValue | locator | variable | 
605 | Store Value | storeValue | parentLocator | locator | variable
606 | Submit | submit | locator |  | 
607 | Submit | submit | parentLocator | locator | 
608 | Type | type | locator | value | 
609 | Type | type | parentLocator | locator | value
610 | Type And Tab | typeAndTab | locator | value | 
611 | Type And Tab | typeAndTab | parentLocator | locator | value
612 | Type Keys | typeKeys | locator | value | 
613 | Type Keys | typeKeys | parentLocator | locator | value
614 | Uncheck | uncheck | locator |  | 
615 | Uncheck | uncheck | parentLocator | locator | 
616 | Verify Alert | verifyAlert | text |  | 
617 | Verify Alert Match | verifyAlertMatch | text |  | 
618 | Verify Alert Not Match | verifyAlertNotMatch | text |  | 
619 | Verify Alert Not Present | verifyAlertNotPresent |  |  | 
620 | Verify Alert Present | verifyAlertPresent |  |  | 
621 | Verify All Buttons | verifyAllButtons | text |  | 
622 | Verify All Buttons Match | verifyAllButtonsMatch | text |  | 
623 | Verify All Buttons Not Match | verifyAllButtonsNotMatch | text |  | 
624 | Verify All Fields | verifyAllFields | text |  | 
625 | Verify All Fields Match | verifyAllFieldsMatch | text |  | 
626 | Verify All Fields Not Match | verifyAllFieldsNotMatch | text |  | 
627 | Verify All Links | verifyAllLinks | text |  | 
628 | Verify All Links Match | verifyAllLinksMatch | text |  | 
629 | Verify All Links Not Match | verifyAllLinksNotMatch | text |  | 
630 | Verify All Window Names | verifyAllWindowNames | text |  | 
631 | Verify All Window Names Match | verifyAllWindowNamesMatch | text |  | 
632 | Verify All Window Names Not Match | verifyAllWindowNamesNotMatch | text |  | 
633 | Verify All Window Titles | verifyAllWindowTitles | text |  | 
634 | Verify All Window Titles Match | verifyAllWindowTitlesMatch | text |  | 
635 | Verify All Window Titles Not Match | verifyAllWindowTitlesNotMatch | text |  | 
636 | Verify Attribute | verifyAttribute | locator | name | text
637 | Verify Attribute From All Windows | verifyAttributeFromAllWindows | attributeName | text | 
638 | Verify Attribute From All Windows Match | verifyAttributeFromAllWindowsMatch | attributeName | text | 
639 | Verify Attribute From All Windows Not Match | verifyAttributeFromAllWindowsNotMatch | attributeName | text | 
640 | Verify Attribute Match | verifyAttributeMatch | locator | name | text
641 | Verify Attribute Not Match | verifyAttributeNotMatch | locator | name | text
642 | Verify Background Color | verifyBackgroundColor | locator | text | 
643 | Verify Background Color | verifyBackgroundColor | parentLocator | locator | text
644 | Verify Body Text | verifyBodyText | text |  | 
645 | Verify Body Text Match | verifyBodyTextMatch | text |  | 
646 | Verify Body Text Not Match | verifyBodyTextNotMatch | text |  | 
647 | Verify Border Color | verifyBorderColor | locator | text | 
648 | Verify Border Color | verifyBorderColor | parentLocator | locator | text
649 | Verify Checked | verifyChecked | locator |  | 
650 | Verify Checked | verifyChecked | parentLocator | locator | 
651 | Verify Color | verifyColor | locator | text | 
652 | Verify Color | verifyColor | parentLocator | locator | text
653 | Verify Confirmation | verifyConfirmation | text |  | 
654 | Verify Confirmation Match | verifyConfirmationMatch | text |  | 
655 | Verify Confirmation Not Match | verifyConfirmationNotMatch | text |  | 
656 | Verify Confirmation Not Present | verifyConfirmationNotPresent |  |  | 
657 | Verify Confirmation Present | verifyConfirmationPresent |  |  | 
658 | Verify Cookie | verifyCookie | text |  | 
659 | Verify Cookie By Name | verifyCookieByName | name | text | 
660 | Verify Cookie By Name Match | verifyCookieByNameMatch | name | text | 
661 | Verify Cookie By Name Not Match | verifyCookieByNameNotMatch | name | text | 
662 | Verify Cookie Match | verifyCookieMatch | text |  | 
663 | Verify Cookie Not Match | verifyCookieNotMatch | text |  | 
664 | Verify Cookie Not Present | verifyCookieNotPresent | name |  | 
665 | Verify Cookie Present | verifyCookiePresent | name |  | 
666 | Verify Css Count | verifyCssCount | css | text | 
667 | Verify Cursor Position | verifyCursorPosition | locator | text | 
668 | Verify Cursor Position | verifyCursorPosition | parentLocator | locator | text
669 | Verify Date List Order Asc | verifyDateListOrderAsc | locator | format | 
670 | Verify Date List Order Asc | verifyDateListOrderAsc | parentLocator | locator | format
671 | Verify Date List Order Desc | verifyDateListOrderDesc | locator | format | 
672 | Verify Date List Order Desc | verifyDateListOrderDesc | parentLocator | locator | format
673 | Verify Editable | verifyEditable | locator |  | 
674 | Verify Editable | verifyEditable | parentLocator | locator | 
675 | Verify Element Height | verifyElementHeight | locator | text | 
676 | Verify Element Height | verifyElementHeight | parentLocator | locator | text
677 | Verify Element Index | verifyElementIndex | locator | text | 
678 | Verify Element Index | verifyElementIndex | parentLocator | locator | text
679 | Verify Element Not Present | verifyElementNotPresent | locator |  | 
680 | Verify Element Not Present | verifyElementNotPresent | parentLocator | locator | 
681 | Verify Element Position Left | verifyElementPositionLeft | locator | text | 
682 | Verify Element Position Left | verifyElementPositionLeft | parentLocator | locator | text
683 | Verify Element Position Top | verifyElementPositionTop | locator | text | 
684 | Verify Element Position Top | verifyElementPositionTop | parentLocator | locator | text
685 | Verify Element Present | verifyElementPresent | locator |  | 
686 | Verify Element Present | verifyElementPresent | parentLocator | locator | 
687 | Verify Element Width | verifyElementWidth | locator | text | 
688 | Verify Element Width | verifyElementWidth | parentLocator | locator | text
689 | Verify Eval | verifyEval | expression | text | 
690 | Verify Eval Script | verifyEvalScript | script | text | 
691 | Verify Eval Script Match | verifyEvalScriptMatch | script | text | 
692 | Verify Eval Script Not Match | verifyEvalScriptNotMatch | script | text | 
693 | Verify Exists In Database | verifyExistsInDatabase | sql |  | 
694 | Verify Expression | verifyExpression | expression | text | 
695 | Verify Expression Match | verifyExpressionMatch | expression | text | 
696 | Verify Expression Not Match | verifyExpressionNotMatch | expression | text | 
697 | Verify Font Family | verifyFontFamily | locator | text | 
698 | Verify Font Family | verifyFontFamily | parentLocator | locator | text
699 | Verify Font Family Match | verifyFontFamilyMatch | locator | text | 
700 | Verify Font Family Match | verifyFontFamilyMatch | parentLocator | locator | text
701 | Verify Font Family Not Match | verifyFontFamilyNotMatch | locator | text | 
702 | Verify Font Family Not Match | verifyFontFamilyNotMatch | parentLocator | locator | text
703 | Verify Font Size | verifyFontSize | locator | text | 
704 | Verify Font Size | verifyFontSize | parentLocator | locator | text
705 | Verify Font Size Match | verifyFontSizeMatch | locator | text | 
706 | Verify Font Size Match | verifyFontSizeMatch | parentLocator | locator | text
707 | Verify Font Size Not Match | verifyFontSizeNotMatch | locator | text | 
708 | Verify Font Size Not Match | verifyFontSizeNotMatch | parentLocator | locator | text
709 | Verify Font Style | verifyFontStyle | locator | text | 
710 | Verify Font Style | verifyFontStyle | parentLocator | locator | text
711 | Verify Font Style Match | verifyFontStyleMatch | locator | text | 
712 | Verify Font Style Match | verifyFontStyleMatch | parentLocator | locator | text
713 | Verify Font Style Not Match | verifyFontStyleNotMatch | locator | text | 
714 | Verify Font Style Not Match | verifyFontStyleNotMatch | parentLocator | locator | text
715 | Verify Font Weight | verifyFontWeight | locator | text | 
716 | Verify Font Weight | verifyFontWeight | parentLocator | locator | text
717 | Verify Font Weight Match | verifyFontWeightMatch | locator | text | 
718 | Verify Font Weight Match | verifyFontWeightMatch | parentLocator | locator | text
719 | Verify Font Weight Not Match | verifyFontWeightNotMatch | locator | text | 
720 | Verify Font Weight Not Match | verifyFontWeightNotMatch | parentLocator | locator | text
721 | Verify Html Source | verifyHtmlSource | text |  | 
722 | Verify Html Source Match | verifyHtmlSourceMatch | text |  | 
723 | Verify Html Source Not Match | verifyHtmlSourceNotMatch | text |  | 
724 | Verify Integer List Order Asc | verifyIntegerListOrderAsc | locator |  | 
725 | Verify Integer List Order Asc | verifyIntegerListOrderAsc | parentLocator | locator | 
726 | Verify Integer List Order Desc | verifyIntegerListOrderDesc | locator |  | 
727 | Verify Integer List Order Desc | verifyIntegerListOrderDesc | parentLocator | locator | 
728 | Verify List Contain | verifyListContain | variable | text | 
729 | Verify List Not Contain | verifyListNotContain | variable | text | 
730 | Verify List Order Asc | verifyListOrderAsc | variable |  | 
731 | Verify List Order Desc | verifyListOrderDesc | variable |  | 
732 | Verify Location | verifyLocation | text |  | 
733 | Verify Location Match | verifyLocationMatch | text |  | 
734 | Verify Location Not Match | verifyLocationNotMatch | text |  | 
735 | Verify Not Alert | verifyNotAlert | text |  | 
736 | Verify Not All Buttons | verifyNotAllButtons | text |  | 
737 | Verify Not All Fields | verifyNotAllFields | text |  | 
738 | Verify Not All Links | verifyNotAllLinks | text |  | 
739 | Verify Not All Window Names | verifyNotAllWindowNames | text |  | 
740 | Verify Not All Window Titles | verifyNotAllWindowTitles | text |  | 
741 | Verify Not Attribute | verifyNotAttribute | locator | name | text
742 | Verify Not Attribute From All Windows | verifyNotAttributeFromAllWindows | attributeName | text | 
743 | Verify Not Background Color | verifyNotBackgroundColor | locator | text | 
744 | Verify Not Background Color | verifyNotBackgroundColor | parentLocator | locator | text
745 | Verify Not Body Text | verifyNotBodyText | text |  | 
746 | Verify Not Border Color | verifyNotBorderColor | locator | text | 
747 | Verify Not Border Color | verifyNotBorderColor | parentLocator | locator | text
748 | Verify Not Checked | verifyNotChecked | locator |  | 
749 | Verify Not Checked | verifyNotChecked | parentLocator | locator | 
750 | Verify Not Color | verifyNotColor | locator | text | 
751 | Verify Not Color | verifyNotColor | parentLocator | locator | text
752 | Verify Not Confirmation | verifyNotConfirmation | text |  | 
753 | Verify Not Cookie | verifyNotCookie | text |  | 
754 | Verify Not Cookie By Name | verifyNotCookieByName | name | text | 
755 | Verify Not Css Count | verifyNotCssCount | css | text | 
756 | Verify Not Cursor Position | verifyNotCursorPosition | locator | text | 
757 | Verify Not Cursor Position | verifyNotCursorPosition | parentLocator | locator | text
758 | Verify Not Editable | verifyNotEditable | locator |  | 
759 | Verify Not Editable | verifyNotEditable | parentLocator | locator | 
760 | Verify Not Element Height | verifyNotElementHeight | locator | text | 
761 | Verify Not Element Height | verifyNotElementHeight | parentLocator | locator | text
762 | Verify Not Element Index | verifyNotElementIndex | locator | text | 
763 | Verify Not Element Index | verifyNotElementIndex | parentLocator | locator | text
764 | Verify Not Element Position Left | verifyNotElementPositionLeft | locator | text | 
765 | Verify Not Element Position Left | verifyNotElementPositionLeft | parentLocator | locator | text
766 | Verify Not Element Position Top | verifyNotElementPositionTop | locator | text | 
767 | Verify Not Element Position Top | verifyNotElementPositionTop | parentLocator | locator | text
768 | Verify Not Element Width | verifyNotElementWidth | locator | text | 
769 | Verify Not Element Width | verifyNotElementWidth | parentLocator | locator | text
770 | Verify Not Eval | verifyNotEval | expression | text | 
771 | Verify Not Eval Script | verifyNotEvalScript | script | text | 
772 | Verify Not Exists In Database | verifyNotExistsInDatabase | sql |  | 
773 | Verify Not Expression | verifyNotExpression | expression | text | 
774 | Verify Not Font Family | verifyNotFontFamily | locator | text | 
775 | Verify Not Font Family | verifyNotFontFamily | parentLocator | locator | text
776 | Verify Not Font Size | verifyNotFontSize | locator | text | 
777 | Verify Not Font Size | verifyNotFontSize | parentLocator | locator | text
778 | Verify Not Font Style | verifyNotFontStyle | locator | text | 
779 | Verify Not Font Style | verifyNotFontStyle | parentLocator | locator | text
780 | Verify Not Font Weight | verifyNotFontWeight | locator | text | 
781 | Verify Not Font Weight | verifyNotFontWeight | parentLocator | locator | text
782 | Verify Not Html Source | verifyNotHtmlSource | text |  | 
783 | Verify Not Location | verifyNotLocation | text |  | 
784 | Verify Not Ordered | verifyNotOrdered | firstLocator | secondLocator | 
785 | Verify Not Prompt | verifyNotPrompt | text |  | 
786 | Verify Not Select Options | verifyNotSelectOptions | locator | text | 
787 | Verify Not Select Options | verifyNotSelectOptions | parentLocator | locator | text
788 | Verify Not Selected Id | verifyNotSelectedId | locator | text | 
789 | Verify Not Selected Id | verifyNotSelectedId | parentLocator | locator | text
790 | Verify Not Selected Ids | verifyNotSelectedIds | locator | text | 
791 | Verify Not Selected Ids | verifyNotSelectedIds | parentLocator | locator | text
792 | Verify Not Selected Index | verifyNotSelectedIndex | locator | text | 
793 | Verify Not Selected Index | verifyNotSelectedIndex | parentLocator | locator | text
794 | Verify Not Selected Indexes | verifyNotSelectedIndexes | locator | text | 
795 | Verify Not Selected Indexes | verifyNotSelectedIndexes | parentLocator | locator | text
796 | Verify Not Selected Label | verifyNotSelectedLabel | locator | text | 
797 | Verify Not Selected Label | verifyNotSelectedLabel | parentLocator | locator | text
798 | Verify Not Selected Labels | verifyNotSelectedLabels | locator | text | 
799 | Verify Not Selected Labels | verifyNotSelectedLabels | parentLocator | locator | text
800 | Verify Not Selected Value | verifyNotSelectedValue | locator | text | 
801 | Verify Not Selected Value | verifyNotSelectedValue | parentLocator | locator | text
802 | Verify Not Selected Values | verifyNotSelectedValues | locator | text | 
803 | Verify Not Selected Values | verifyNotSelectedValues | parentLocator | locator | text
804 | Verify Not Something Selected | verifyNotSomethingSelected | locator |  | 
805 | Verify Not Something Selected | verifyNotSomethingSelected | parentLocator | locator | 
806 | Verify Not Table | verifyNotTable | locator | cellAddress | text
807 | Verify Not Text | verifyNotText | locator | text | 
808 | Verify Not Text | verifyNotText | parentLocator | locator | text
809 | Verify Not Text Alignment | verifyNotTextAlignment | locator | text | 
810 | Verify Not Text Alignment | verifyNotTextAlignment | parentLocator | locator | text
811 | Verify Not Text Decoration | verifyNotTextDecoration | locator | text | 
812 | Verify Not Text Decoration | verifyNotTextDecoration | parentLocator | locator | text
813 | Verify Not Text Empty | verifyNotTextEmpty | locator |  | 
814 | Verify Not Text Empty | verifyNotTextEmpty | parentLocator | locator | 
815 | Verify Not Title | verifyNotTitle | text |  | 
816 | Verify Not Value | verifyNotValue | locator | text | 
817 | Verify Not Value | verifyNotValue | parentLocator | locator | text
818 | Verify Not Value Empty | verifyNotValueEmpty | locator |  | 
819 | Verify Not Value Empty | verifyNotValueEmpty | parentLocator | locator | 
820 | Verify Not Variable | verifyNotVariable | variable | text | 
821 | Verify Not Visible | verifyNotVisible | locator |  | 
822 | Verify Not Visible | verifyNotVisible | parentLocator | locator | 
823 | Verify Not Xpath Count | verifyNotXpathCount | xpath | text | 
824 | Verify Ordered | verifyOrdered | firstLocator | secondLocator | 
825 | Verify Prompt | verifyPrompt | text |  | 
826 | Verify Prompt Match | verifyPromptMatch | text |  | 
827 | Verify Prompt Not Match | verifyPromptNotMatch | text |  | 
828 | Verify Prompt Not Present | verifyPromptNotPresent |  |  | 
829 | Verify Prompt Present | verifyPromptPresent |  |  | 
830 | Verify Row Count | verifyRowCount | sql | count | 
831 | Verify Row Count Greater Than | verifyRowCountGreaterThan | sql | count | 
832 | Verify Row Count Less Than | verifyRowCountLessThan | sql | count | 
833 | Verify Select Options | verifySelectOptions | locator | text | 
834 | Verify Select Options | verifySelectOptions | parentLocator | locator | text
835 | Verify Select Options Match | verifySelectOptionsMatch | locator | text | 
836 | Verify Select Options Match | verifySelectOptionsMatch | parentLocator | locator | text
837 | Verify Select Options Not Match | verifySelectOptionsNotMatch | locator | text | 
838 | Verify Select Options Not Match | verifySelectOptionsNotMatch | parentLocator | locator | text
839 | Verify Selected Id | verifySelectedId | locator | text | 
840 | Verify Selected Id | verifySelectedId | parentLocator | locator | text
841 | Verify Selected Id Match | verifySelectedIdMatch | locator | text | 
842 | Verify Selected Id Match | verifySelectedIdMatch | parentLocator | locator | text
843 | Verify Selected Id Not Match | verifySelectedIdNotMatch | locator | text | 
844 | Verify Selected Id Not Match | verifySelectedIdNotMatch | parentLocator | locator | text
845 | Verify Selected Ids | verifySelectedIds | locator | text | 
846 | Verify Selected Ids | verifySelectedIds | parentLocator | locator | text
847 | Verify Selected Ids Match | verifySelectedIdsMatch | locator | text | 
848 | Verify Selected Ids Match | verifySelectedIdsMatch | parentLocator | locator | text
849 | Verify Selected Ids Not Match | verifySelectedIdsNotMatch | locator | text | 
850 | Verify Selected Ids Not Match | verifySelectedIdsNotMatch | parentLocator | locator | text
851 | Verify Selected Index | verifySelectedIndex | locator | text | 
852 | Verify Selected Index | verifySelectedIndex | parentLocator | locator | text
853 | Verify Selected Index Match | verifySelectedIndexMatch | locator | text | 
854 | Verify Selected Index Match | verifySelectedIndexMatch | parentLocator | locator | text
855 | Verify Selected Index Not Match | verifySelectedIndexNotMatch | locator | text | 
856 | Verify Selected Index Not Match | verifySelectedIndexNotMatch | parentLocator | locator | text
857 | Verify Selected Indexes | verifySelectedIndexes | locator | text | 
858 | Verify Selected Indexes | verifySelectedIndexes | parentLocator | locator | text
859 | Verify Selected Indexes Match | verifySelectedIndexesMatch | locator | text | 
860 | Verify Selected Indexes Match | verifySelectedIndexesMatch | parentLocator | locator | text
861 | Verify Selected Indexes Not Match | verifySelectedIndexesNotMatch | locator | text | 
862 | Verify Selected Indexes Not Match | verifySelectedIndexesNotMatch | parentLocator | locator | text
863 | Verify Selected Label | verifySelectedLabel | locator | text | 
864 | Verify Selected Label | verifySelectedLabel | parentLocator | locator | text
865 | Verify Selected Label Match | verifySelectedLabelMatch | locator | text | 
866 | Verify Selected Label Match | verifySelectedLabelMatch | parentLocator | locator | text
867 | Verify Selected Label Not Match | verifySelectedLabelNotMatch | locator | text | 
868 | Verify Selected Label Not Match | verifySelectedLabelNotMatch | parentLocator | locator | text
869 | Verify Selected Labels | verifySelectedLabels | locator | text | 
870 | Verify Selected Labels | verifySelectedLabels | parentLocator | locator | text
871 | Verify Selected Labels Match | verifySelectedLabelsMatch | locator | text | 
872 | Verify Selected Labels Match | verifySelectedLabelsMatch | parentLocator | locator | text
873 | Verify Selected Labels Not Match | verifySelectedLabelsNotMatch | locator | text | 
874 | Verify Selected Labels Not Match | verifySelectedLabelsNotMatch | parentLocator | locator | text
875 | Verify Selected Value | verifySelectedValue | locator | text | 
876 | Verify Selected Value | verifySelectedValue | parentLocator | locator | text
877 | Verify Selected Value Match | verifySelectedValueMatch | locator | text | 
878 | Verify Selected Value Match | verifySelectedValueMatch | parentLocator | locator | text
879 | Verify Selected Value Not Match | verifySelectedValueNotMatch | locator | text | 
880 | Verify Selected Value Not Match | verifySelectedValueNotMatch | parentLocator | locator | text
881 | Verify Selected Values | verifySelectedValues | locator | text | 
882 | Verify Selected Values | verifySelectedValues | parentLocator | locator | text
883 | Verify Selected Values Match | verifySelectedValuesMatch | locator | text | 
884 | Verify Selected Values Match | verifySelectedValuesMatch | parentLocator | locator | text
885 | Verify Selected Values Not Match | verifySelectedValuesNotMatch | locator | text | 
886 | Verify Selected Values Not Match | verifySelectedValuesNotMatch | parentLocator | locator | text
887 | Verify Something Selected | verifySomethingSelected | locator |  | 
888 | Verify Something Selected | verifySomethingSelected | parentLocator | locator | 
889 | Verify Table | verifyTable | locator | cellAddress | text
890 | Verify Table Match | verifyTableMatch | locator | cellAddress | text
891 | Verify Table Not Match | verifyTableNotMatch | locator | cellAddress | text
892 | Verify Text | verifyText | locator | text | 
893 | Verify Text | verifyText | parentLocator | locator | text
894 | Verify Text Alignment | verifyTextAlignment | locator | text | 
895 | Verify Text Alignment | verifyTextAlignment | parentLocator | locator | text
896 | Verify Text Alignment Match | verifyTextAlignmentMatch | locator | text | 
897 | Verify Text Alignment Match | verifyTextAlignmentMatch | parentLocator | locator | text
898 | Verify Text Alignment Not Match | verifyTextAlignmentNotMatch | locator | text | 
899 | Verify Text Alignment Not Match | verifyTextAlignmentNotMatch | parentLocator | locator | text
900 | Verify Text Decoration | verifyTextDecoration | locator | text | 
901 | Verify Text Decoration | verifyTextDecoration | parentLocator | locator | text
902 | Verify Text Decoration Match | verifyTextDecorationMatch | locator | text | 
903 | Verify Text Decoration Match | verifyTextDecorationMatch | parentLocator | locator | text
904 | Verify Text Decoration Not Match | verifyTextDecorationNotMatch | locator | text | 
905 | Verify Text Decoration Not Match | verifyTextDecorationNotMatch | parentLocator | locator | text
906 | Verify Text Empty | verifyTextEmpty | locator |  | 
907 | Verify Text Empty | verifyTextEmpty | parentLocator | locator | 
908 | Verify Text List Order Asc | verifyTextListOrderAsc | locator |  | 
909 | Verify Text List Order Asc | verifyTextListOrderAsc | parentLocator | locator | 
910 | Verify Text List Order Desc | verifyTextListOrderDesc | locator |  | 
911 | Verify Text List Order Desc | verifyTextListOrderDesc | parentLocator | locator | 
912 | Verify Text Match | verifyTextMatch | locator | text | 
913 | Verify Text Match | verifyTextMatch | parentLocator | locator | text
914 | Verify Text Not Match | verifyTextNotMatch | locator | text | 
915 | Verify Text Not Match | verifyTextNotMatch | parentLocator | locator | text
916 | Verify Text Not Present | verifyTextNotPresent | pattern |  | 
917 | Verify Text Present | verifyTextPresent | pattern |  | 
918 | Verify Title | verifyTitle | text |  | 
919 | Verify Title Match | verifyTitleMatch | text |  | 
920 | Verify Title Not Match | verifyTitleNotMatch | text |  | 
921 | Verify Value | verifyValue | locator | text | 
922 | Verify Value | verifyValue | parentLocator | locator | text
923 | Verify Value Empty | verifyValueEmpty | locator |  | 
924 | Verify Value Empty | verifyValueEmpty | parentLocator | locator | 
925 | Verify Value Match | verifyValueMatch | locator | text | 
926 | Verify Value Match | verifyValueMatch | parentLocator | locator | text
927 | Verify Value Not Match | verifyValueNotMatch | locator | text | 
928 | Verify Value Not Match | verifyValueNotMatch | parentLocator | locator | text
929 | Verify Variable | verifyVariable | variable | text | 
930 | Verify Visible | verifyVisible | locator |  | 
931 | Verify Visible | verifyVisible | parentLocator | locator | 
932 | Verify Xpath Count | verifyXpathCount | xpath | text | 
933 | Wait For Alert | waitForAlert | text |  | 
934 | Wait For Alert Match | waitForAlertMatch | text |  | 
935 | Wait For Alert Not Match | waitForAlertNotMatch | text |  | 
936 | Wait For Alert Not Present | waitForAlertNotPresent |  |  | 
937 | Wait For Alert Present | waitForAlertPresent |  |  | 
938 | Wait For All Element Not Present | waitForAllElementNotPresent | locatorArray |  | 
939 | Wait For All Element Present | waitForAllElementPresent | locatorArray |  | 
940 | Wait For All Text Not Present | waitForAllTextNotPresent | textArray |  | 
941 | Wait For All Text Present | waitForAllTextPresent | textArray |  | 
942 | Wait For Any Element Not Present | waitForAnyElementNotPresent | locatorArray |  | 
943 | Wait For Any Element Present | waitForAnyElementPresent | locatorArray |  | 
944 | Wait For Any Text Not Present | waitForAnyTextNotPresent | textArray |  | 
945 | Wait For Any Text Present | waitForAnyTextPresent | textArray |  | 
946 | Wait For Attribute | waitForAttribute | locator | name | text
947 | Wait For Attribute Match | waitForAttributeMatch | locator | name | text
948 | Wait For Attribute Not Match | waitForAttributeNotMatch | locator | name | text
949 | Wait For Body Text | waitForBodyText | text |  | 
950 | Wait For Body Text Match | waitForBodyTextMatch | text |  | 
951 | Wait For Body Text Not Match | waitForBodyTextNotMatch | text |  | 
952 | Wait For Checked | waitForChecked | locator |  | 
953 | Wait For Checked | waitForChecked | parentLocator | locator | 
954 | Wait For Condition | waitForCondition | script | timeout | 
955 | Wait For Confirmation | waitForConfirmation | text |  | 
956 | Wait For Confirmation Match | waitForConfirmationMatch | text |  | 
957 | Wait For Confirmation Not Match | waitForConfirmationNotMatch | text |  | 
958 | Wait For Confirmation Not Present | waitForConfirmationNotPresent |  |  | 
959 | Wait For Confirmation Present | waitForConfirmationPresent |  |  | 
960 | Wait For Cookie | waitForCookie | text |  | 
961 | Wait For Cookie By Name | waitForCookieByName | name | text | 
962 | Wait For Cookie By Name Match | waitForCookieByNameMatch | name | text | 
963 | Wait For Cookie By Name Not Match | waitForCookieByNameNotMatch | name | text | 
964 | Wait For Cookie Match | waitForCookieMatch | text |  | 
965 | Wait For Cookie Not Match | waitForCookieNotMatch | text |  | 
966 | Wait For Cookie Not Present | waitForCookieNotPresent | name |  | 
967 | Wait For Cookie Present | waitForCookiePresent | name |  | 
968 | Wait For Editable | waitForEditable | locator |  | 
969 | Wait For Editable | waitForEditable | parentLocator | locator | 
970 | Wait For Element Not Present | waitForElementNotPresent | locator |  | 
971 | Wait For Element Not Present | waitForElementNotPresent | parentLocator | locator | 
972 | Wait For Element Present | waitForElementPresent | locator |  | 
973 | Wait For Element Present | waitForElementPresent | parentLocator | locator | 
974 | Wait For Eval | waitForEval | expression | text | 
975 | Wait For Eval Script | waitForEvalScript | script | text | 
976 | Wait For Eval Script Match | waitForEvalScriptMatch | script | text | 
977 | Wait For Eval Script Not Match | waitForEvalScriptNotMatch | script | text | 
978 | Wait For Exists In Database | waitForExistsInDatabase | sql |  | 
979 | Wait For Expression | waitForExpression | expression | text | 
980 | Wait For Expression Match | waitForExpressionMatch | expression | text | 
981 | Wait For Expression Not Match | waitForExpressionNotMatch | expression | text | 
982 | Wait For Html Source | waitForHtmlSource | text |  | 
983 | Wait For Html Source Match | waitForHtmlSourceMatch | text |  | 
984 | Wait For Html Source Not Match | waitForHtmlSourceNotMatch | text |  | 
985 | Wait For Location | waitForLocation | text |  | 
986 | Wait For Location Match | waitForLocationMatch | text |  | 
987 | Wait For Location Not Match | waitForLocationNotMatch | text |  | 
988 | Wait For Not Alert | waitForNotAlert | text |  | 
989 | Wait For Not Attribute | waitForNotAttribute | locator | name | text
990 | Wait For Not Body Text | waitForNotBodyText | text |  | 
991 | Wait For Not Checked | waitForNotChecked | locator |  | 
992 | Wait For Not Checked | waitForNotChecked | parentLocator | locator | 
993 | Wait For Not Confirmation | waitForNotConfirmation | text |  | 
994 | Wait For Not Cookie | waitForNotCookie | text |  | 
995 | Wait For Not Cookie By Name | waitForNotCookieByName | name | text | 
996 | Wait For Not Editable | waitForNotEditable | locator |  | 
997 | Wait For Not Editable | waitForNotEditable | parentLocator | locator | 
998 | Wait For Not Eval | waitForNotEval | expression | text | 
999 | Wait For Not Eval Script | waitForNotEvalScript | script | text | 
1,000 | Wait For Not Exists In Database | waitForNotExistsInDatabase | sql |  | 
1,001 | Wait For Not Expression | waitForNotExpression | expression | text | 
1,002 | Wait For Not Html Source | waitForNotHtmlSource | text |  | 
1,003 | Wait For Not Location | waitForNotLocation | text |  | 
1,004 | Wait For Not Prompt | waitForNotPrompt | text |  | 
1,005 | Wait For Not Selected Id | waitForNotSelectedId | locator | text | 
1,006 | Wait For Not Selected Id | waitForNotSelectedId | parentLocator | locator | text
1,007 | Wait For Not Selected Index | waitForNotSelectedIndex | locator | text | 
1,008 | Wait For Not Selected Index | waitForNotSelectedIndex | parentLocator | locator | text
1,009 | Wait For Not Selected Label | waitForNotSelectedLabel | locator | text | 
1,010 | Wait For Not Selected Label | waitForNotSelectedLabel | parentLocator | locator | text
1,011 | Wait For Not Selected Value | waitForNotSelectedValue | locator | text | 
1,012 | Wait For Not Selected Value | waitForNotSelectedValue | parentLocator | locator | text
1,013 | Wait For Not Something Selected | waitForNotSomethingSelected | locator |  | 
1,014 | Wait For Not Something Selected | waitForNotSomethingSelected | parentLocator | locator | 
1,015 | Wait For Not Table | waitForNotTable | locator | cellAddress | text
1,016 | Wait For Not Text | waitForNotText | locator | text | 
1,017 | Wait For Not Text | waitForNotText | parentLocator | locator | text
1,018 | Wait For Not Text Empty | waitForNotTextEmpty | locator |  | 
1,019 | Wait For Not Text Empty | waitForNotTextEmpty | parentLocator | locator | 
1,020 | Wait For Not Title | waitForNotTitle | text |  | 
1,021 | Wait For Not Value | waitForNotValue | locator | text | 
1,022 | Wait For Not Value | waitForNotValue | parentLocator | locator | text
1,023 | Wait For Not Value Empty | waitForNotValueEmpty | locator |  | 
1,024 | Wait For Not Value Empty | waitForNotValueEmpty | parentLocator | locator | 
1,025 | Wait For Not Visible | waitForNotVisible | locator |  | 
1,026 | Wait For Not Visible | waitForNotVisible | parentLocator | locator | 
1,027 | Wait For Page To Load | waitForPageToLoad | timeout |  | 
1,028 | Wait For Pop Up | waitForPopUp | windowID | timeout | 
1,029 | Wait For Prompt | waitForPrompt | text |  | 
1,030 | Wait For Prompt Match | waitForPromptMatch | text |  | 
1,031 | Wait For Prompt Not Match | waitForPromptNotMatch | text |  | 
1,032 | Wait For Prompt Not Present | waitForPromptNotPresent |  |  | 
1,033 | Wait For Prompt Present | waitForPromptPresent |  |  | 
1,034 | Wait For Selected Id | waitForSelectedId | locator | text | 
1,035 | Wait For Selected Id | waitForSelectedId | parentLocator | locator | text
1,036 | Wait For Selected Id Match | waitForSelectedIdMatch | locator | text | 
1,037 | Wait For Selected Id Match | waitForSelectedIdMatch | parentLocator | locator | text
1,038 | Wait For Selected Id Not Match | waitForSelectedIdNotMatch | locator | text | 
1,039 | Wait For Selected Id Not Match | waitForSelectedIdNotMatch | parentLocator | locator | text
1,040 | Wait For Selected Index | waitForSelectedIndex | locator | text | 
1,041 | Wait For Selected Index | waitForSelectedIndex | parentLocator | locator | text
1,042 | Wait For Selected Index Match | waitForSelectedIndexMatch | locator | text | 
1,043 | Wait For Selected Index Match | waitForSelectedIndexMatch | parentLocator | locator | text
1,044 | Wait For Selected Index Not Match | waitForSelectedIndexNotMatch | locator | text | 
1,045 | Wait For Selected Index Not Match | waitForSelectedIndexNotMatch | parentLocator | locator | text
1,046 | Wait For Selected Label | waitForSelectedLabel | locator | text | 
1,047 | Wait For Selected Label | waitForSelectedLabel | parentLocator | locator | text
1,048 | Wait For Selected Label Match | waitForSelectedLabelMatch | locator | text | 
1,049 | Wait For Selected Label Match | waitForSelectedLabelMatch | parentLocator | locator | text
1,050 | Wait For Selected Label Not Match | waitForSelectedLabelNotMatch | locator | text | 
1,051 | Wait For Selected Label Not Match | waitForSelectedLabelNotMatch | parentLocator | locator | text
1,052 | Wait For Selected Value | waitForSelectedValue | locator | text | 
1,053 | Wait For Selected Value | waitForSelectedValue | parentLocator | locator | text
1,054 | Wait For Selected Value Match | waitForSelectedValueMatch | locator | text | 
1,055 | Wait For Selected Value Match | waitForSelectedValueMatch | parentLocator | locator | text
1,056 | Wait For Selected Value Not Match | waitForSelectedValueNotMatch | locator | text | 
1,057 | Wait For Selected Value Not Match | waitForSelectedValueNotMatch | parentLocator | locator | text
1,058 | Wait For Something Selected | waitForSomethingSelected | locator |  | 
1,059 | Wait For Something Selected | waitForSomethingSelected | parentLocator | locator | 
1,060 | Wait For Table | waitForTable | locator | cellAddress | text
1,061 | Wait For Table Match | waitForTableMatch | locator | cellAddress | text
1,062 | Wait For Table Not Match | waitForTableNotMatch | locator | cellAddress | text
1,063 | Wait For Text | waitForText | locator | text | 
1,064 | Wait For Text | waitForText | parentLocator | locator | text
1,065 | Wait For Text Empty | waitForTextEmpty | locator |  | 
1,066 | Wait For Text Empty | waitForTextEmpty | parentLocator | locator | 
1,067 | Wait For Text Match | waitForTextMatch | locator | text | 
1,068 | Wait For Text Match | waitForTextMatch | parentLocator | locator | text
1,069 | Wait For Text Not Match | waitForTextNotMatch | locator | text | 
1,070 | Wait For Text Not Match | waitForTextNotMatch | parentLocator | locator | text
1,071 | Wait For Text Not Present | waitForTextNotPresent | pattern |  | 
1,072 | Wait For Text Present | waitForTextPresent | pattern |  | 
1,073 | Wait For Title | waitForTitle | text |  | 
1,074 | Wait For Title Match | waitForTitleMatch | text |  | 
1,075 | Wait For Title Not Match | waitForTitleNotMatch | text |  | 
1,076 | Wait For Value | waitForValue | locator | text | 
1,077 | Wait For Value | waitForValue | parentLocator | locator | text
1,078 | Wait For Value Empty | waitForValueEmpty | locator |  | 
1,079 | Wait For Value Empty | waitForValueEmpty | parentLocator | locator | 
1,080 | Wait For Value Match | waitForValueMatch | locator | text | 
1,081 | Wait For Value Match | waitForValueMatch | parentLocator | locator | text
1,082 | Wait For Value Not Match | waitForValueNotMatch | locator | text | 
1,083 | Wait For Value Not Match | waitForValueNotMatch | parentLocator | locator | text
1,084 | Wait For Visible | waitForVisible | locator |  | 
1,085 | Wait For Visible | waitForVisible | parentLocator | locator | 
1,086 | Window Focus | windowFocus |  |  | 
1,087 | Window Maximize | windowMaximize |  |  | 

## Add Selection

Add a selection to the set of selected options in a multi-select element using an option locator.

### Usage

`
addSelection(locator, optionLocator)
`

`
addSelection(parentLocator, locator, optionLocator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a multi-select box
optionLocator | an option locator (a label by default)

## Add Selection Id

Add a selection to the set of selected options in a multi-select element using an element ID.

### Usage

`
addSelectionId(locator, id)
`

`
addSelectionId(parentLocator, locator, id)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a multi-select box
id | an element ID

## Add Selection Index

Add a selection to the set of selected options in a multi-select element using an index.

### Usage

`
addSelectionIndex(locator, index)
`

`
addSelectionIndex(parentLocator, locator, index)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a multi-select box
index | an index

## Add Selection Label

Add a selection to the set of selected options in a multi-select element using a label.

### Usage

`
addSelectionLabel(locator, label)
`

`
addSelectionLabel(parentLocator, locator, label)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a multi-select box
label | a label

## Add Selection Value

Add a selection to the set of selected options in a multi-select element using a value.

### Usage

`
addSelectionValue(locator, value)
`

`
addSelectionValue(parentLocator, locator, value)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a multi-select box
value | a value

## Alt Key Down

Press the alt key and hold it down until doAltUp() is called or a new page is loaded.

### Usage

`
altKeyDown()
`

### Parameters

Parameter | Description
--------- | -----------

## Alt Key Up

Release the alt key.

### Usage

`
altKeyUp()
`

### Parameters

Parameter | Description
--------- | -----------

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

## Assert All Buttons

Asserts that the IDs of all buttons on the page equals to the given value. When the assert fails, the test is aborted.

 <p> If a given button has no ID, it will appear as "" in this array. </p>

### Usage

`
assertAllButtons(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert All Buttons Match

Asserts that the IDs of all buttons on the page matches the given value. When the assert fails, the test is aborted.

 <p> If a given button has no ID, it will appear as "" in this array. </p>

### Usage

`
assertAllButtonsMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert All Buttons Not Match

Asserts that the IDs of all buttons on the page not match the given value. When the assert fails, the test is aborted.

 <p> If a given button has no ID, it will appear as "" in this array. </p>

### Usage

`
assertAllButtonsNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert All Fields

Asserts that the IDs of all input fields on the page equals to the given value. When the assert fails, the test is aborted.

 <p> If a given field has no ID, it will appear as "" in this array. </p>

### Usage

`
assertAllFields(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert All Fields Match

Asserts that the IDs of all input fields on the page matches the given value. When the assert fails, the test is aborted.

 <p> If a given field has no ID, it will appear as "" in this array. </p>

### Usage

`
assertAllFieldsMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert All Fields Not Match

Asserts that the IDs of all input fields on the page not match the given value. When the assert fails, the test is aborted.

 <p> If a given field has no ID, it will appear as "" in this array. </p>

### Usage

`
assertAllFieldsNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert All Links

Asserts that the IDs of all links on the page equals to the given value. When the assert fails, the test is aborted.

 <p> If a given link has no ID, it will appear as "" in this array. </p>

### Usage

`
assertAllLinks(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert All Links Match

Asserts that the IDs of all links on the page matches the given value. When the assert fails, the test is aborted.

 <p> If a given link has no ID, it will appear as "" in this array. </p>

### Usage

`
assertAllLinksMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert All Links Not Match

Asserts that the IDs of all links on the page not match the given value. When the assert fails, the test is aborted.

 <p> If a given link has no ID, it will appear as "" in this array. </p>

### Usage

`
assertAllLinksNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert All Window Names

Asserts that the names of all windows that the browser knows about equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertAllWindowNames(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert All Window Names Match

Asserts that the names of all windows that the browser knows about matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertAllWindowNamesMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert All Window Names Not Match

Asserts that the names of all windows that the browser knows about not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertAllWindowNamesNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert All Window Titles

Asserts that the titles of all windows that the browser knows about equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertAllWindowTitles(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert All Window Titles Match

Asserts that the titles of all windows that the browser knows about matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertAllWindowTitlesMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert All Window Titles Not Match

Asserts that the titles of all windows that the browser knows about not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertAllWindowTitlesNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

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

## Assert Attribute From All Windows

Asserts that every instance of some attribute from all known windows equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertAttributeFromAllWindows(attributeName, text)
`

### Parameters

Parameter | Description
--------- | -----------
attributeName | name of an attribute on the windows
text | the value to match with the result

## Assert Attribute From All Windows Match

Asserts that every instance of some attribute from all known windows matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertAttributeFromAllWindowsMatch(attributeName, text)
`

### Parameters

Parameter | Description
--------- | -----------
attributeName | name of an attribute on the windows
text | the value to match with the result

## Assert Attribute From All Windows Not Match

Asserts that every instance of some attribute from all known windows not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertAttributeFromAllWindowsNotMatch(attributeName, text)
`

### Parameters

Parameter | Description
--------- | -----------
attributeName | name of an attribute on the windows
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

## Assert Background Color

Asserts that the background color of the specified element equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertBackgroundColor(locator, text)
`

`
assertBackgroundColor(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Body Text

Asserts that the entire text of the page equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertBodyText(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Body Text Match

Asserts that the entire text of the page matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertBodyTextMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Body Text Not Match

Asserts that the entire text of the page not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertBodyTextNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Border Color

Asserts that the border color of the specified element equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertBorderColor(locator, text)
`

`
assertBorderColor(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
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

## Assert Color

Asserts that the text color of the specified element equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertColor(locator, text)
`

`
assertColor(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

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

## Assert Cookie

Asserts that all cookies of the current page under test equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertCookie(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Cookie By Name

Asserts that the value of the cookie with the specified name equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertCookieByName(name, text)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie
text | the value to match with the result

## Assert Cookie By Name Match

Asserts that the value of the cookie with the specified name matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertCookieByNameMatch(name, text)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie
text | the value to match with the result

## Assert Cookie By Name Not Match

Asserts that the value of the cookie with the specified name not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertCookieByNameNotMatch(name, text)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie
text | the value to match with the result

## Assert Cookie Match

Asserts that all cookies of the current page under test matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertCookieMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Cookie Not Match

Asserts that all cookies of the current page under test not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertCookieNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Cookie Not Present

Asserts that a cookie with the specified name is not present. When the assert fails, the test is aborted.

### Usage

`
assertCookieNotPresent(name)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie

## Assert Cookie Present

Asserts that a cookie with the specified name is present. When the assert fails, the test is aborted.

### Usage

`
assertCookiePresent(name)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie

## Assert Css Count

Asserts that the number of nodes that match the specified css selector, eg equals to the given value. When the assert fails, the test is aborted. "css=table" would give the number of tables.

### Usage

`
assertCssCount(css, text)
`

### Parameters

Parameter | Description
--------- | -----------
css | the css selector to evaluate. do NOT wrap this expression in a 'count()' function; we will do that for you.
text | the value to match with the result

## Assert Cursor Position

Asserts that the text cursor position in the given input element or textarea equals to the given value. When the assert fails, the test is aborted. Beware, this may not work perfectly on all browsers.

 <p> Specifically, if the cursor/selection has been cleared by JavaScript, this command will tend to return the position of the last location of the cursor, even though the cursor is now gone from the page. This is filed as <a href="http://jira.openqa.org/browse/SEL-243">SEL-243</a>. </p> This method will fail if the specified element isn't an input element or textarea, or there is no cursor in the element.

### Usage

`
assertCursorPosition(locator, text)
`

`
assertCursorPosition(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an input element or textarea
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

## Assert Element Height

Asserts that the height of an element equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertElementHeight(locator, text)
`

`
assertElementHeight(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Element Index

Asserts that the relative index of an element to its parent (starting from 0) equals to the given value. When the assert fails, the test is aborted. The comment node and empty text node will be ignored.

### Usage

`
assertElementIndex(locator, text)
`

`
assertElementIndex(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

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

## Assert Element Position Left

Asserts that the horizontal position of an element equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertElementPositionLeft(locator, text)
`

`
assertElementPositionLeft(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Element Position Top

Asserts that the vertical position of an element equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertElementPositionTop(locator, text)
`

`
assertElementPositionTop(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

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

## Assert Element Width

Asserts that the width of an element equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertElementWidth(locator, text)
`

`
assertElementWidth(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

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

## Assert Eval Script

Asserts that the result of evaluating the specified JavaScript snippet equals to the given value. When the assert fails, the test is aborted. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
assertEvalScript(script, text)
`

### Parameters

Parameter | Description
--------- | -----------
script | the JavaScript snippet to run
text | the value to match with the result

## Assert Eval Script Match

Asserts that the result of evaluating the specified JavaScript snippet matches the given value. When the assert fails, the test is aborted. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
assertEvalScriptMatch(script, text)
`

### Parameters

Parameter | Description
--------- | -----------
script | the JavaScript snippet to run
text | the value to match with the result

## Assert Eval Script Not Match

Asserts that the result of evaluating the specified JavaScript snippet not match the given value. When the assert fails, the test is aborted. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
assertEvalScriptNotMatch(script, text)
`

### Parameters

Parameter | Description
--------- | -----------
script | the JavaScript snippet to run
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

## Assert Font Family

Asserts that the font family of the specified element equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertFontFamily(locator, text)
`

`
assertFontFamily(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Font Family Match

Asserts that the font family of the specified element matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertFontFamilyMatch(locator, text)
`

`
assertFontFamilyMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Font Family Not Match

Asserts that the font family of the specified element not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertFontFamilyNotMatch(locator, text)
`

`
assertFontFamilyNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Font Size

Asserts that the font size of the specified element equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertFontSize(locator, text)
`

`
assertFontSize(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Font Size Match

Asserts that the font size of the specified element matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertFontSizeMatch(locator, text)
`

`
assertFontSizeMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Font Size Not Match

Asserts that the font size of the specified element not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertFontSizeNotMatch(locator, text)
`

`
assertFontSizeNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Font Style

Asserts that the font style of the specified element equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertFontStyle(locator, text)
`

`
assertFontStyle(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Font Style Match

Asserts that the font style of the specified element matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertFontStyleMatch(locator, text)
`

`
assertFontStyleMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Font Style Not Match

Asserts that the font style of the specified element not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertFontStyleNotMatch(locator, text)
`

`
assertFontStyleNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Font Weight

Asserts that the font weight of the specified element equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertFontWeight(locator, text)
`

`
assertFontWeight(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Font Weight Match

Asserts that the font weight of the specified element matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertFontWeightMatch(locator, text)
`

`
assertFontWeightMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Font Weight Not Match

Asserts that the font weight of the specified element not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertFontWeightNotMatch(locator, text)
`

`
assertFontWeightNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Html Source

Asserts that the entire HTML source between the opening and closing "html" tags equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertHtmlSource(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Html Source Match

Asserts that the entire HTML source between the opening and closing "html" tags matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertHtmlSourceMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Html Source Not Match

Asserts that the entire HTML source between the opening and closing "html" tags not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertHtmlSourceNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
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

## Assert Location

Asserts that the absolute URL of the current page equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertLocation(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Location Match

Asserts that the absolute URL of the current page matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertLocationMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Location Not Match

Asserts that the absolute URL of the current page not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertLocationNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

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

## Assert Not All Buttons

Asserts that the IDs of all buttons on the page not equal to the given value. When the assert fails, the test is aborted.

 <p> If a given button has no ID, it will appear as "" in this array. </p>

### Usage

`
assertNotAllButtons(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Not All Fields

Asserts that the IDs of all input fields on the page not equal to the given value. When the assert fails, the test is aborted.

 <p> If a given field has no ID, it will appear as "" in this array. </p>

### Usage

`
assertNotAllFields(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Not All Links

Asserts that the IDs of all links on the page not equal to the given value. When the assert fails, the test is aborted.

 <p> If a given link has no ID, it will appear as "" in this array. </p>

### Usage

`
assertNotAllLinks(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Not All Window Names

Asserts that the names of all windows that the browser knows about not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotAllWindowNames(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Not All Window Titles

Asserts that the titles of all windows that the browser knows about not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotAllWindowTitles(text)
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

## Assert Not Attribute From All Windows

Asserts that every instance of some attribute from all known windows not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotAttributeFromAllWindows(attributeName, text)
`

### Parameters

Parameter | Description
--------- | -----------
attributeName | name of an attribute on the windows
text | the value to match with the result

## Assert Not Background Color

Asserts that the background color of the specified element not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotBackgroundColor(locator, text)
`

`
assertNotBackgroundColor(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Not Body Text

Asserts that the entire text of the page not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotBodyText(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Not Border Color

Asserts that the border color of the specified element not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotBorderColor(locator, text)
`

`
assertNotBorderColor(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
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

## Assert Not Color

Asserts that the text color of the specified element not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotColor(locator, text)
`

`
assertNotColor(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

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

## Assert Not Cookie

Asserts that all cookies of the current page under test not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotCookie(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Not Cookie By Name

Asserts that the value of the cookie with the specified name not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotCookieByName(name, text)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie
text | the value to match with the result

## Assert Not Css Count

Asserts that the number of nodes that match the specified css selector, eg not equal to the given value. When the assert fails, the test is aborted. "css=table" would give the number of tables.

### Usage

`
assertNotCssCount(css, text)
`

### Parameters

Parameter | Description
--------- | -----------
css | the css selector to evaluate. do NOT wrap this expression in a 'count()' function; we will do that for you.
text | the value to match with the result

## Assert Not Cursor Position

Asserts that the text cursor position in the given input element or textarea not equal to the given value. When the assert fails, the test is aborted. Beware, this may not work perfectly on all browsers.

 <p> Specifically, if the cursor/selection has been cleared by JavaScript, this command will tend to return the position of the last location of the cursor, even though the cursor is now gone from the page. This is filed as <a href="http://jira.openqa.org/browse/SEL-243">SEL-243</a>. </p> This method will fail if the specified element isn't an input element or textarea, or there is no cursor in the element.

### Usage

`
assertNotCursorPosition(locator, text)
`

`
assertNotCursorPosition(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an input element or textarea
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

## Assert Not Element Height

Asserts that the height of an element not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotElementHeight(locator, text)
`

`
assertNotElementHeight(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Not Element Index

Asserts that the relative index of an element to its parent (starting from 0) not equal to the given value. When the assert fails, the test is aborted. The comment node and empty text node will be ignored.

### Usage

`
assertNotElementIndex(locator, text)
`

`
assertNotElementIndex(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Not Element Position Left

Asserts that the horizontal position of an element not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotElementPositionLeft(locator, text)
`

`
assertNotElementPositionLeft(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Not Element Position Top

Asserts that the vertical position of an element not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotElementPositionTop(locator, text)
`

`
assertNotElementPositionTop(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Not Element Width

Asserts that the width of an element not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotElementWidth(locator, text)
`

`
assertNotElementWidth(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

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

## Assert Not Eval Script

Asserts that the result of evaluating the specified JavaScript snippet not equal to the given value. When the assert fails, the test is aborted. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
assertNotEvalScript(script, text)
`

### Parameters

Parameter | Description
--------- | -----------
script | the JavaScript snippet to run
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

## Assert Not Font Family

Asserts that the font family of the specified element not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotFontFamily(locator, text)
`

`
assertNotFontFamily(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Not Font Size

Asserts that the font size of the specified element not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotFontSize(locator, text)
`

`
assertNotFontSize(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Not Font Style

Asserts that the font style of the specified element not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotFontStyle(locator, text)
`

`
assertNotFontStyle(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Not Font Weight

Asserts that the font weight of the specified element not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotFontWeight(locator, text)
`

`
assertNotFontWeight(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Not Html Source

Asserts that the entire HTML source between the opening and closing "html" tags not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotHtmlSource(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Not Location

Asserts that the absolute URL of the current page not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotLocation(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Not Ordered

Asserts that these two elements have same parent and are ordered siblings in the DOM. When the assert fails, the test is aborted. Two same elements will not be considered ordered.

### Usage

`
assertNotOrdered(firstLocator, secondLocator)
`

### Parameters

Parameter | Description
--------- | -----------
firstLocator | an element locator pointing to the first element
secondLocator | an element locator pointing to the second element

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

## Assert Not Select Options

Asserts that all option labels in the specified select drop-down not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotSelectOptions(locator, text)
`

`
assertNotSelectOptions(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Not Selected Id

Asserts that option element ID for selected option in the specified select element not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotSelectedId(locator, text)
`

`
assertNotSelectedId(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Not Selected Ids

Asserts that all option element IDs for selected options in the specified select or multi-select element not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotSelectedIds(locator, text)
`

`
assertNotSelectedIds(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Not Selected Index

Asserts that option index (option number, starting at 0) for selected option in the specified select element not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotSelectedIndex(locator, text)
`

`
assertNotSelectedIndex(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Not Selected Indexes

Asserts that all option indexes (option number, starting at 0) for selected options in the specified select or multi-select element not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotSelectedIndexes(locator, text)
`

`
assertNotSelectedIndexes(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Not Selected Label

Asserts that option label (visible text) for selected option in the specified select element not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotSelectedLabel(locator, text)
`

`
assertNotSelectedLabel(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Not Selected Labels

Asserts that all option labels (visible text) for selected options in the specified select or multi-select element not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotSelectedLabels(locator, text)
`

`
assertNotSelectedLabels(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Not Selected Value

Asserts that option value (value attribute) for selected option in the specified select element not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotSelectedValue(locator, text)
`

`
assertNotSelectedValue(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Not Selected Values

Asserts that all option values (value attributes) for selected options in the specified select or multi-select element not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotSelectedValues(locator, text)
`

`
assertNotSelectedValues(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Not Something Selected

Asserts that some option in a drop-down menu is not selected. When the assert fails, the test is aborted.

### Usage

`
assertNotSomethingSelected(locator)
`

`
assertNotSomethingSelected(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu

## Assert Not Table

Asserts that the text from a cell of a table not equal to the given value. When the assert fails, the test is aborted. The cellAddress syntax row.column, where row and column start at 0.

### Usage

`
assertNotTable(locator, cellAddress, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator pointing to a table
cellAddress | a cell address, e.g. "1.4"
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

## Assert Not Text Alignment

Asserts that the text alignment of the specified element not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotTextAlignment(locator, text)
`

`
assertNotTextAlignment(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Not Text Decoration

Asserts that the text decoration of the specified element not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotTextDecoration(locator, text)
`

`
assertNotTextDecoration(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
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

## Assert Not Title

Asserts that the title of the current page not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotTitle(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

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

## Assert Not Xpath Count

Asserts that the number of nodes that match the specified xpath, eg not equal to the given value. When the assert fails, the test is aborted. "//table" would give the number of tables.

### Usage

`
assertNotXpathCount(xpath, text)
`

### Parameters

Parameter | Description
--------- | -----------
xpath | the xpath expression to evaluate. do NOT wrap this expression in a 'count()' function; we will do that for you.
text | the value to match with the result

## Assert Ordered

Asserts that these two elements have same parent and are ordered siblings in the DOM. When the assert fails, the test is aborted. Two same elements will not be considered ordered.

### Usage

`
assertOrdered(firstLocator, secondLocator)
`

### Parameters

Parameter | Description
--------- | -----------
firstLocator | an element locator pointing to the first element
secondLocator | an element locator pointing to the second element

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

## Assert Select Options

Asserts that all option labels in the specified select drop-down equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectOptions(locator, text)
`

`
assertSelectOptions(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Select Options Match

Asserts that all option labels in the specified select drop-down matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectOptionsMatch(locator, text)
`

`
assertSelectOptionsMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Select Options Not Match

Asserts that all option labels in the specified select drop-down not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectOptionsNotMatch(locator, text)
`

`
assertSelectOptionsNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Id

Asserts that option element ID for selected option in the specified select element equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedId(locator, text)
`

`
assertSelectedId(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Id Match

Asserts that option element ID for selected option in the specified select element matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedIdMatch(locator, text)
`

`
assertSelectedIdMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Id Not Match

Asserts that option element ID for selected option in the specified select element not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedIdNotMatch(locator, text)
`

`
assertSelectedIdNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Ids

Asserts that all option element IDs for selected options in the specified select or multi-select element equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedIds(locator, text)
`

`
assertSelectedIds(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Ids Match

Asserts that all option element IDs for selected options in the specified select or multi-select element matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedIdsMatch(locator, text)
`

`
assertSelectedIdsMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Ids Not Match

Asserts that all option element IDs for selected options in the specified select or multi-select element not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedIdsNotMatch(locator, text)
`

`
assertSelectedIdsNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Index

Asserts that option index (option number, starting at 0) for selected option in the specified select element equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedIndex(locator, text)
`

`
assertSelectedIndex(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Index Match

Asserts that option index (option number, starting at 0) for selected option in the specified select element matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedIndexMatch(locator, text)
`

`
assertSelectedIndexMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Index Not Match

Asserts that option index (option number, starting at 0) for selected option in the specified select element not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedIndexNotMatch(locator, text)
`

`
assertSelectedIndexNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Indexes

Asserts that all option indexes (option number, starting at 0) for selected options in the specified select or multi-select element equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedIndexes(locator, text)
`

`
assertSelectedIndexes(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Indexes Match

Asserts that all option indexes (option number, starting at 0) for selected options in the specified select or multi-select element matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedIndexesMatch(locator, text)
`

`
assertSelectedIndexesMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Indexes Not Match

Asserts that all option indexes (option number, starting at 0) for selected options in the specified select or multi-select element not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedIndexesNotMatch(locator, text)
`

`
assertSelectedIndexesNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Label

Asserts that option label (visible text) for selected option in the specified select element equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedLabel(locator, text)
`

`
assertSelectedLabel(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Label Match

Asserts that option label (visible text) for selected option in the specified select element matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedLabelMatch(locator, text)
`

`
assertSelectedLabelMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Label Not Match

Asserts that option label (visible text) for selected option in the specified select element not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedLabelNotMatch(locator, text)
`

`
assertSelectedLabelNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Labels

Asserts that all option labels (visible text) for selected options in the specified select or multi-select element equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedLabels(locator, text)
`

`
assertSelectedLabels(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Labels Match

Asserts that all option labels (visible text) for selected options in the specified select or multi-select element matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedLabelsMatch(locator, text)
`

`
assertSelectedLabelsMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Labels Not Match

Asserts that all option labels (visible text) for selected options in the specified select or multi-select element not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedLabelsNotMatch(locator, text)
`

`
assertSelectedLabelsNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Value

Asserts that option value (value attribute) for selected option in the specified select element equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedValue(locator, text)
`

`
assertSelectedValue(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Value Match

Asserts that option value (value attribute) for selected option in the specified select element matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedValueMatch(locator, text)
`

`
assertSelectedValueMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Value Not Match

Asserts that option value (value attribute) for selected option in the specified select element not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedValueNotMatch(locator, text)
`

`
assertSelectedValueNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Values

Asserts that all option values (value attributes) for selected options in the specified select or multi-select element equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedValues(locator, text)
`

`
assertSelectedValues(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Values Match

Asserts that all option values (value attributes) for selected options in the specified select or multi-select element matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedValuesMatch(locator, text)
`

`
assertSelectedValuesMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Values Not Match

Asserts that all option values (value attributes) for selected options in the specified select or multi-select element not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedValuesNotMatch(locator, text)
`

`
assertSelectedValuesNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Something Selected

Asserts that some option in a drop-down menu is selected. When the assert fails, the test is aborted.

### Usage

`
assertSomethingSelected(locator)
`

`
assertSomethingSelected(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu

## Assert Table

Asserts that the text from a cell of a table equals to the given value. When the assert fails, the test is aborted. The cellAddress syntax row.column, where row and column start at 0.

### Usage

`
assertTable(locator, cellAddress, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator pointing to a table
cellAddress | a cell address, e.g. "1.4"
text | the value to match with the result

## Assert Table Match

Asserts that the text from a cell of a table matches the given value. When the assert fails, the test is aborted. The cellAddress syntax row.column, where row and column start at 0.

### Usage

`
assertTableMatch(locator, cellAddress, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator pointing to a table
cellAddress | a cell address, e.g. "1.4"
text | the value to match with the result

## Assert Table Not Match

Asserts that the text from a cell of a table not match the given value. When the assert fails, the test is aborted. The cellAddress syntax row.column, where row and column start at 0.

### Usage

`
assertTableNotMatch(locator, cellAddress, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator pointing to a table
cellAddress | a cell address, e.g. "1.4"
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

## Assert Text Alignment

Asserts that the text alignment of the specified element equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertTextAlignment(locator, text)
`

`
assertTextAlignment(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Text Alignment Match

Asserts that the text alignment of the specified element matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertTextAlignmentMatch(locator, text)
`

`
assertTextAlignmentMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Text Alignment Not Match

Asserts that the text alignment of the specified element not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertTextAlignmentNotMatch(locator, text)
`

`
assertTextAlignmentNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Text Decoration

Asserts that the text decoration of the specified element equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertTextDecoration(locator, text)
`

`
assertTextDecoration(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Text Decoration Match

Asserts that the text decoration of the specified element matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertTextDecorationMatch(locator, text)
`

`
assertTextDecorationMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Text Decoration Not Match

Asserts that the text decoration of the specified element not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertTextDecorationNotMatch(locator, text)
`

`
assertTextDecorationNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
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

Asserts that the specified text pattern appears somewhere on the rendered page shown to the user. When the assert fails, the test is aborted.

### Usage

`
assertTextNotPresent(pattern)
`

### Parameters

Parameter | Description
--------- | -----------
pattern | a pattern to match with the text of the page

## Assert Text Present

Asserts that the specified text pattern appears somewhere on the rendered page shown to the user. When the assert fails, the test is aborted.

### Usage

`
assertTextPresent(pattern)
`

### Parameters

Parameter | Description
--------- | -----------
pattern | a pattern to match with the text of the page

## Assert Title

Asserts that the title of the current page equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertTitle(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Title Match

Asserts that the title of the current page matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertTitleMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Title Not Match

Asserts that the title of the current page not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertTitleNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
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

## Assert Xpath Count

Asserts that the number of nodes that match the specified xpath, eg equals to the given value. When the assert fails, the test is aborted. "//table" would give the number of tables.

### Usage

`
assertXpathCount(xpath, text)
`

### Parameters

Parameter | Description
--------- | -----------
xpath | the xpath expression to evaluate. do NOT wrap this expression in a 'count()' function; we will do that for you.
text | the value to match with the result

## Assign Id

Temporarily sets the "id" attribute of the specified element, so you can locate it in the future using its ID rather than a slow/complicated XPath. This ID will disappear once the page is reloaded.

### Usage

`
assignId(locator, identifier)
`

`
assignId(parentLocator, locator, identifier)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
identifier | a string to be used as the ID of the specified element

## Attach File

Sets a file input (upload) field to the file listed in fileLocator

### Usage

`
attachFile(locator, filePath)
`

`
attachFile(parentLocator, locator, filePath)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
filePath | a path or a URL pointing to the specified file.

## Blur

Remove the focus from the specified element; for example, if the element is an input field, remove the cursor from that field.

### Usage

`
blur(locator)
`

`
blur(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Check

Check a toggle-button (checkbox/radio)

### Usage

`
check(locator)
`

`
check(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

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

Clears the value of an input field.

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

Clicks on a link, button, checkbox or radio button. If the click action causes a new page to load (like a link usually does), call waitForPageToLoad.

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

## Click At

Clicks on a link, button, checkbox or radio button. If the click action causes a new page to load (like a link usually does), call waitForPageToLoad.

### Usage

`
clickAt(locator, coordString)
`

`
clickAt(parentLocator, locator, coordString)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
coordString | specifies the x,y position (i.e. - 10,20) of the mouse event relative to the element returned by the locator.

## Close

Simulates the user clicking the "close" button in the titlebar of a popup window or tab.

### Usage

`
close()
`

### Parameters

Parameter | Description
--------- | -----------

## Context Menu

Simulates opening the context menu for the specified element (as might happen if the user "right-clicked" on the element).

### Usage

`
contextMenu(locator)
`

`
contextMenu(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Context Menu At

Simulates opening the context menu for the specified element (as might happen if the user "right-clicked" on the element).

### Usage

`
contextMenuAt(locator, coordString)
`

`
contextMenuAt(parentLocator, locator, coordString)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
coordString | specifies the x,y position (i.e. - 10,20) of the mouse event relative to the element returned by the locator.

## Control Key Down

Press the control key and hold it down until doControlUp() is called or a new page is loaded.

### Usage

`
controlKeyDown()
`

### Parameters

Parameter | Description
--------- | -----------

## Control Key Up

Release the control key.

### Usage

`
controlKeyUp()
`

### Parameters

Parameter | Description
--------- | -----------

## Create Cookie

Create a new cookie whose path and domain are same with those of current page under test, unless you specified a path for this cookie explicitly.

### Usage

`
createCookie(nameValuePair, optionsString)
`

### Parameters

Parameter | Description
--------- | -----------
nameValuePair | name and value of the cookie in a format "name=value"
optionsString | options for the cookie. Currently supported options include 'path', 'max_age' and 'domain'. the optionsString's format is "path=/path/, max_age=60, domain=.foo.com". The order of options are irrelevant, the unit of the value of 'max_age' is second. Note that specifying a domain that isn't a subset of the current domain will usually fail.

## Delete All Visible Cookies

Calls deleteCookie with recurse=true on all cookies visible to the current page. As noted on the documentation for deleteCookie, recurse=true can be much slower than simply deleting the cookies using a known domain/path.

### Usage

`
deleteAllVisibleCookies()
`

### Parameters

Parameter | Description
--------- | -----------

## Delete Cookie

Delete a named cookie with specified path and domain. Be careful; to delete a cookie, you need to delete it using the exact same path and domain that were used to create the cookie. If the path is wrong, or the domain is wrong, the cookie simply won't be deleted. Also note that specifying a domain that isn't a subset of the current domain will usually fail.

 Since there's no way to discover at runtime the original path and domain of a given cookie, we've added an option called 'recurse' to try all sub-domains of the current domain with all paths that are a subset of the current path. Beware; this option can be slow. In big-O notation, it operates in O(n*m) time, where n is the number of dots in the domain name and m is the number of slashes in the path.

### Usage

`
deleteCookie(name)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie to be deleted

## Deselect Pop Up

Selects the main window. Functionally equivalent to using <code>selectWindow()</code> and specifying no value for <code>windowID</code>.

### Usage

`
deselectPopUp()
`

### Parameters

Parameter | Description
--------- | -----------

## Double Click

Double clicks on a link, button, checkbox or radio button. If the double click action causes a new page to load (like a link usually does), call waitForPageToLoad.

### Usage

`
doubleClick(locator)
`

`
doubleClick(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Double Click At

Double clicks on a link, button, checkbox or radio button. If the double click action causes a new page to load (like a link usually does), call waitForPageToLoad.

### Usage

`
doubleClickAt(locator, coordString)
`

`
doubleClickAt(parentLocator, locator, coordString)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
coordString | specifies the x,y position (i.e. - 10,20) of the mouse event relative to the element returned by the locator.

## Drag And Drop

Drags an element a certain distance and then drops it

### Usage

`
dragAndDrop(locator, movementsString)
`

`
dragAndDrop(parentLocator, locator, movementsString)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
movementsString | offset in pixels from the current location to which the element should be moved, e.g., "+70,-300"

## Drag And Drop To Object

Drags an element and drops it on another element

### Usage

`
dragAndDropToObject(toBeDraggedObjectLocator, dragDestinationObjectLocator)
`

### Parameters

Parameter | Description
--------- | -----------
toBeDraggedObjectLocator | an element to be dragged
dragDestinationObjectLocator | an element whose location (i.e., whose center-most pixel) will be the point where locatorOfObjectToBeDragged is dropped

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

## Execute If Body Text

Executes an action if the entire text of the page equals to the given value.

### Usage

`
executeIfBodyText(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Body Text Match

Executes an action if the entire text of the page matches the given value.

### Usage

`
executeIfBodyTextMatch(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Body Text Not Match

Executes an action if the entire text of the page not match the given value.

### Usage

`
executeIfBodyTextNotMatch(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

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

## Execute If Cookie

Executes an action if all cookies of the current page under test equals to the given value.

### Usage

`
executeIfCookie(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Cookie By Name

Executes an action if the value of the cookie with the specified name equals to the given value.

### Usage

`
executeIfCookieByName(action, name, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
name | the name of the cookie
text | the value to match with the result

## Execute If Cookie By Name Match

Executes an action if the value of the cookie with the specified name matches the given value.

### Usage

`
executeIfCookieByNameMatch(action, name, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
name | the name of the cookie
text | the value to match with the result

## Execute If Cookie By Name Not Match

Executes an action if the value of the cookie with the specified name not match the given value.

### Usage

`
executeIfCookieByNameNotMatch(action, name, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
name | the name of the cookie
text | the value to match with the result

## Execute If Cookie Match

Executes an action if all cookies of the current page under test matches the given value.

### Usage

`
executeIfCookieMatch(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Cookie Not Match

Executes an action if all cookies of the current page under test not match the given value.

### Usage

`
executeIfCookieNotMatch(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Cookie Not Present

Executes an action if a cookie with the specified name is not present.

### Usage

`
executeIfCookieNotPresent(action, name)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
name | the name of the cookie

## Execute If Cookie Present

Executes an action if a cookie with the specified name is present.

### Usage

`
executeIfCookiePresent(action, name)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
name | the name of the cookie

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

## Execute If Eval Script

Executes an action if the result of evaluating the specified JavaScript snippet equals to the given value. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
executeIfEvalScript(action, script, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
script | the JavaScript snippet to run
text | the value to match with the result

## Execute If Eval Script Match

Executes an action if the result of evaluating the specified JavaScript snippet matches the given value. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
executeIfEvalScriptMatch(action, script, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
script | the JavaScript snippet to run
text | the value to match with the result

## Execute If Eval Script Not Match

Executes an action if the result of evaluating the specified JavaScript snippet not match the given value. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
executeIfEvalScriptNotMatch(action, script, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
script | the JavaScript snippet to run
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

## Execute If Html Source

Executes an action if the entire HTML source between the opening and closing "html" tags equals to the given value.

### Usage

`
executeIfHtmlSource(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Html Source Match

Executes an action if the entire HTML source between the opening and closing "html" tags matches the given value.

### Usage

`
executeIfHtmlSourceMatch(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Html Source Not Match

Executes an action if the entire HTML source between the opening and closing "html" tags not match the given value.

### Usage

`
executeIfHtmlSourceNotMatch(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
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

## Execute If Location

Executes an action if the absolute URL of the current page equals to the given value.

### Usage

`
executeIfLocation(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Location Match

Executes an action if the absolute URL of the current page matches the given value.

### Usage

`
executeIfLocationMatch(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Location Not Match

Executes an action if the absolute URL of the current page not match the given value.

### Usage

`
executeIfLocationNotMatch(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

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

## Execute If Not Body Text

Executes an action if the entire text of the page not equal to the given value.

### Usage

`
executeIfNotBodyText(action, text)
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

## Execute If Not Cookie

Executes an action if all cookies of the current page under test not equal to the given value.

### Usage

`
executeIfNotCookie(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Not Cookie By Name

Executes an action if the value of the cookie with the specified name not equal to the given value.

### Usage

`
executeIfNotCookieByName(action, name, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
name | the name of the cookie
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

## Execute If Not Eval Script

Executes an action if the result of evaluating the specified JavaScript snippet not equal to the given value. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
executeIfNotEvalScript(action, script, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
script | the JavaScript snippet to run
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

## Execute If Not Html Source

Executes an action if the entire HTML source between the opening and closing "html" tags not equal to the given value.

### Usage

`
executeIfNotHtmlSource(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Not Location

Executes an action if the absolute URL of the current page not equal to the given value.

### Usage

`
executeIfNotLocation(action, text)
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

## Execute If Not Selected Id

Executes an action if option element ID for selected option in the specified select element not equal to the given value.

### Usage

`
executeIfNotSelectedId(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Execute If Not Selected Index

Executes an action if option index (option number, starting at 0) for selected option in the specified select element not equal to the given value.

### Usage

`
executeIfNotSelectedIndex(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Execute If Not Selected Label

Executes an action if option label (visible text) for selected option in the specified select element not equal to the given value.

### Usage

`
executeIfNotSelectedLabel(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Execute If Not Selected Value

Executes an action if option value (value attribute) for selected option in the specified select element not equal to the given value.

### Usage

`
executeIfNotSelectedValue(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Execute If Not Something Selected

Executes an action if some option in a drop-down menu is not selected.

### Usage

`
executeIfNotSomethingSelected(action, locator)
`

`
executeIfNotSomethingSelected(action, parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu

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

## Execute If Not Title

Executes an action if the title of the current page not equal to the given value.

### Usage

`
executeIfNotTitle(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

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

## Execute If Selected Id

Executes an action if option element ID for selected option in the specified select element equals to the given value.

### Usage

`
executeIfSelectedId(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Execute If Selected Id Match

Executes an action if option element ID for selected option in the specified select element matches the given value.

### Usage

`
executeIfSelectedIdMatch(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Execute If Selected Id Not Match

Executes an action if option element ID for selected option in the specified select element not match the given value.

### Usage

`
executeIfSelectedIdNotMatch(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Execute If Selected Index

Executes an action if option index (option number, starting at 0) for selected option in the specified select element equals to the given value.

### Usage

`
executeIfSelectedIndex(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Execute If Selected Index Match

Executes an action if option index (option number, starting at 0) for selected option in the specified select element matches the given value.

### Usage

`
executeIfSelectedIndexMatch(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Execute If Selected Index Not Match

Executes an action if option index (option number, starting at 0) for selected option in the specified select element not match the given value.

### Usage

`
executeIfSelectedIndexNotMatch(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Execute If Selected Label

Executes an action if option label (visible text) for selected option in the specified select element equals to the given value.

### Usage

`
executeIfSelectedLabel(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Execute If Selected Label Match

Executes an action if option label (visible text) for selected option in the specified select element matches the given value.

### Usage

`
executeIfSelectedLabelMatch(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Execute If Selected Label Not Match

Executes an action if option label (visible text) for selected option in the specified select element not match the given value.

### Usage

`
executeIfSelectedLabelNotMatch(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Execute If Selected Value

Executes an action if option value (value attribute) for selected option in the specified select element equals to the given value.

### Usage

`
executeIfSelectedValue(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Execute If Selected Value Match

Executes an action if option value (value attribute) for selected option in the specified select element matches the given value.

### Usage

`
executeIfSelectedValueMatch(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Execute If Selected Value Not Match

Executes an action if option value (value attribute) for selected option in the specified select element not match the given value.

### Usage

`
executeIfSelectedValueNotMatch(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Execute If Something Selected

Executes an action if some option in a drop-down menu is selected.

### Usage

`
executeIfSomethingSelected(action, locator)
`

`
executeIfSomethingSelected(action, parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu

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

Executes an action if the specified text pattern appears somewhere on the rendered page shown to the user.

### Usage

`
executeIfTextNotPresent(action, pattern)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
pattern | a pattern to match with the text of the page

## Execute If Text Present

Executes an action if the specified text pattern appears somewhere on the rendered page shown to the user.

### Usage

`
executeIfTextPresent(action, pattern)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
pattern | a pattern to match with the text of the page

## Execute If Title

Executes an action if the title of the current page equals to the given value.

### Usage

`
executeIfTitle(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Title Match

Executes an action if the title of the current page matches the given value.

### Usage

`
executeIfTitleMatch(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Title Not Match

Executes an action if the title of the current page not match the given value.

### Usage

`
executeIfTitleNotMatch(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
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

## Fire Event

Explicitly simulate an event, to trigger the corresponding "on<em>event</em>" handler.

### Usage

`
fireEvent(locator, eventName)
`

`
fireEvent(parentLocator, locator, eventName)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
eventName | the event name, e.g. "focus" or "blur"

## Focus

Move the focus to the specified element; for example, if the element is an input field, move the cursor to that field.

### Usage

`
focus(locator)
`

`
focus(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Go Back

Simulates the user clicking the "back" button on their browser.

### Usage

`
goBack()
`

### Parameters

Parameter | Description
--------- | -----------

## Go Forward

Simulates the user clicking the "forward" button on their browser.

### Usage

`
goForward()
`

### Parameters

Parameter | Description
--------- | -----------

## Highlight

Briefly changes the backgroundColor of the specified element yellow. Useful for debugging.

### Usage

`
highlight(locator)
`

`
highlight(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Key Down

Simulates a user pressing a key (without releasing it yet) by sending a native operating system keystroke. This function uses the java.awt.Robot class to send a keystroke; this more accurately simulates typing a key on the keyboard. It does not honor settings from the shiftKeyDown, controlKeyDown, altKeyDown and metaKeyDown commands, and does not target any particular HTML element. To send a keystroke to a particular element, focus on the element first before running this command.

### Usage

`
keyDown(keycode)
`

### Parameters

Parameter | Description
--------- | -----------
keycode | an integer keycode number corresponding to a java.awt.event.KeyEvent; note that Java keycodes are NOT the same thing as JavaScript keycodes!

## Key Down

Simulates a user pressing a key (without releasing it yet).

### Usage

`
keyDown(locator, keySequence)
`

`
keyDown(parentLocator, locator, keySequence)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
keySequence | Either be a string( "\" followed by the numeric keycode  of the key to be pressed, normally the ASCII value of that key), or a single  character. For example: " w", "\119".

## Key Press

Simulates a user pressing and releasing a key by sending a native operating system keystroke. This function uses the java.awt.Robot class to send a keystroke; this more accurately simulates typing a key on the keyboard. It does not honor settings from the shiftKeyDown, controlKeyDown, altKeyDown and metaKeyDown commands, and does not target any particular HTML element. To send a keystroke to a particular element, focus on the element first before running this command.

### Usage

`
keyPress(keycode)
`

### Parameters

Parameter | Description
--------- | -----------
keycode | an integer keycode number corresponding to a java.awt.event.KeyEvent; note that Java keycodes are NOT the same thing as JavaScript keycodes!

## Key Press

Simulates a user pressing and releasing a key.

### Usage

`
keyPress(locator, keySequence)
`

`
keyPress(parentLocator, locator, keySequence)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
keySequence | Either be a string( "\" followed by the numeric keycode  of the key to be pressed, normally the ASCII value of that key), or a single  character. For example: " w", "\119".

## Key Up

Simulates a user releasing a key by sending a native operating system keystroke. This function uses the java.awt.Robot class to send a keystroke; this more accurately simulates typing a key on the keyboard. It does not honor settings from the shiftKeyDown, controlKeyDown, altKeyDown and metaKeyDown commands, and does not target any particular HTML element. To send a keystroke to a particular element, focus on the element first before running this command.

### Usage

`
keyUp(keycode)
`

### Parameters

Parameter | Description
--------- | -----------
keycode | an integer keycode number corresponding to a java.awt.event.KeyEvent; note that Java keycodes are NOT the same thing as JavaScript keycodes!

## Key Up

Simulates a user releasing a key.

### Usage

`
keyUp(locator, keySequence)
`

`
keyUp(parentLocator, locator, keySequence)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
keySequence | Either be a string( "\" followed by the numeric keycode  of the key to be pressed, normally the ASCII value of that key), or a single  character. For example: " w", "\119".

## Meta Key Down

Press the meta key and hold it down until doMetaUp() is called or a new page is loaded.

### Usage

`
metaKeyDown()
`

### Parameters

Parameter | Description
--------- | -----------

## Meta Key Up

Release the meta key.

### Usage

`
metaKeyUp()
`

### Parameters

Parameter | Description
--------- | -----------

## Mouse Down

Simulates a user pressing the left mouse button (without releasing it yet) on the specified element.

### Usage

`
mouseDown(locator)
`

`
mouseDown(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Mouse Down At

Simulates a user pressing the left mouse button (without releasing it yet) at the specified location.

### Usage

`
mouseDownAt(locator, coordString)
`

`
mouseDownAt(parentLocator, locator, coordString)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
coordString | specifies the x,y position (i.e. - 10,20) of the mouse event relative to the element returned by the locator.

## Mouse Move

Simulates a user pressing the mouse button (without releasing it yet) on the specified element.

### Usage

`
mouseMove(locator)
`

`
mouseMove(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Mouse Move At

Simulates a user pressing the mouse button (without releasing it yet) on the specified element.

### Usage

`
mouseMoveAt(locator, coordString)
`

`
mouseMoveAt(parentLocator, locator, coordString)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
coordString | specifies the x,y position (i.e. - 10,20) of the mouse event relative to the element returned by the locator.

## Mouse Out

Simulates a user moving the mouse pointer away from the specified element.

### Usage

`
mouseOut(locator)
`

`
mouseOut(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Mouse Over

Simulates a user hovering a mouse over the specified element.

### Usage

`
mouseOver(locator)
`

`
mouseOver(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Mouse Up

Simulates the event that occurs when the user releases the mouse button (i.e., stops holding the button down) on the specified element.

### Usage

`
mouseUp(locator)
`

`
mouseUp(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Mouse Up At

Simulates the event that occurs when the user releases the mouse button (i.e., stops holding the button down) at the specified location.

### Usage

`
mouseUpAt(locator, coordString)
`

`
mouseUpAt(parentLocator, locator, coordString)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
coordString | specifies the x,y position (i.e. - 10,20) of the mouse event relative to the element returned by the locator.

## Open

Opens an URL in the test frame. This accepts both relative and absolute URLs. <p> The "open" command waits for the page to load before proceeding.

 <aside class="notice">The URL must be on the same domain as the runner HTML due to security restrictions in the browser (Same Origin Policy). If you need to open an URL on another domain, use the Selenium Server to start a new browser session on that domain.</aside>

### Usage

`
open(url)
`

### Parameters

Parameter | Description
--------- | -----------
url | the URL to open; may be relative or absolute

## Open Window

Opens a popup window. This accepts both relative and absolute URLs. <p> The "openWindow" command selects the window after the window is opened. (the "selectWindow" command is implicitly invoked)

### Usage

`
openWindow(url)
`

### Parameters

Parameter | Description
--------- | -----------
url | the URL to open; may be relative or absolute

## Open Window

Opens a popup window (if a window with that ID isn't already open). <p> The "openWindow" command selects the window after the window is opened. (the "selectWindow" command is implicitly invoked)

 <aside class="notice"> In some cases, Selenium will be unable to intercept a call to window.open (if the call occurs during or before the "onLoad" event, for example). In those cases, you can force Selenium to notice the open window's name by using the Selenium openWindow command, using an empty (blank) url, like this: openWindow("", "myFunnyWindow").</aside>

### Usage

`
openWindow(url, windowID)
`

### Parameters

Parameter | Description
--------- | -----------
url | the URL to open, which can be blank
windowID | the JavaScript window ID of the window to select

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

## Refresh

Simulates the user clicking the "Refresh" button on their browser.

### Usage

`
refresh()
`

### Parameters

Parameter | Description
--------- | -----------

## Remove All Selections

Unselects all of the selected options in a multi-select element.

### Usage

`
removeAllSelections(locator)
`

`
removeAllSelections(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a multi-select box

## Remove Selection

Remove a selection from the set of selected options in a multi-select element using an option locator.

### Usage

`
removeSelection(locator, optionLocator)
`

`
removeSelection(parentLocator, locator, optionLocator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a multi-select box
optionLocator | an option locator (a label by default)

## Remove Selection Id

Remove a selection from the set of selected options in a multi-select element using an element ID.

### Usage

`
removeSelectionId(locator, id)
`

`
removeSelectionId(parentLocator, locator, id)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a multi-select box
id | an element ID

## Remove Selection Index

Remove a selection from the set of selected options in a multi-select element using an index.

### Usage

`
removeSelectionIndex(locator, index)
`

`
removeSelectionIndex(parentLocator, locator, index)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a multi-select box
index | an index

## Remove Selection Label

Remove a selection from the set of selected options in a multi-select element using a label.

### Usage

`
removeSelectionLabel(locator, label)
`

`
removeSelectionLabel(parentLocator, locator, label)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a multi-select box
label | a label

## Remove Selection Value

Remove a selection from the set of selected options in a multi-select element using a value.

### Usage

`
removeSelectionValue(locator, value)
`

`
removeSelectionValue(parentLocator, locator, value)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a multi-select box
value | a value

## Run Script

Creates a new "script" tag in the body of the current test window, and adds the specified text into the body of the command. Scripts run in this way can often be debugged more easily than scripts executed using Selenium's "getEval" command. Beware that JS exceptions thrown in these script tags aren't managed by Selenium, so you should probably wrap your script in try/catch blocks if there is any chance that the script will throw an exception.

### Usage

`
runScript(script)
`

### Parameters

Parameter | Description
--------- | -----------
script | the JavaScript snippet to run

## Select

Select an option from a drop-down using an option locator.

 <p> Option locators provide different ways of specifying options of an HTML Select element (e.g. for selecting a specific option, or for asserting that the selected option satisfies a specification). There are several forms of Select Option Locator. </p> <ul> <li><strong>label</strong>=<em>labelPattern</em>: matches options based on their labels, i.e. the visible text. (This is the default.) <ul class="first last simple"> <li>label=regexp:^[Oo]ther</li> </ul> </li> <li><strong>value</strong>=<em>valuePattern</em>: matches options based on their values. <ul class="first last simple"> <li>value=other</li> </ul> </li> <li><strong>id</strong>=<em>id</em>:

 matches options based on their ids. <ul class="first last simple"> <li>id=option1</li> </ul> </li> <li><strong>index</strong>=<em>index</em>: matches an option based on its index (offset from zero). <ul class="first last simple"> <li>index=2</li> </ul> </li> </ul> <p> If no option locator prefix is provided, the default behaviour is to match on <strong>label</strong>. </p>

### Usage

`
select(locator, optionLocator)
`

`
select(parentLocator, locator, optionLocator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
optionLocator | an option locator (a label by default)

## Select First Window

Selects the first window (mostly the original window instantiated by the browser).

### Usage

`
selectFirstWindow()
`

### Parameters

Parameter | Description
--------- | -----------

## Select Frame

Selects a frame within the current window. (You may invoke this command multiple times to select nested frames.) To select the parent frame, use "relative=parent" as a locator; to select the top frame, use "relative=top". You can also select a frame by its 0-based index number; select the first frame with "index=0", or the third frame with "index=2".

### Usage

`
selectFrame(locator)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator identifying a frame or iframe

## Select Id

Select an option from a drop-down using an element ID.

### Usage

`
selectId(locator, id)
`

`
selectId(parentLocator, locator, id)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
id | an element ID

## Select Index

Select an option from a drop-down using an index.

### Usage

`
selectIndex(locator, index)
`

`
selectIndex(parentLocator, locator, index)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
index | an index

## Select Label

Select an option from a drop-down using a label.

### Usage

`
selectLabel(locator, label)
`

`
selectLabel(parentLocator, locator, label)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
label | a label

## Select Last Window

Selects the last opened window.

### Usage

`
selectLastWindow()
`

### Parameters

Parameter | Description
--------- | -----------

## Select Parent Frame

Selects the parent frame within the current window. Equivalents to selectFrame("relative=up").

### Usage

`
selectParentFrame()
`

### Parameters

Parameter | Description
--------- | -----------

## Select Pop Up

Simplifies the process of selecting a popup window (and does not offer functionality beyond what <code>selectWindow()</code> already provides). <ul> <li>If <code>windowID</code> is either not specified, or specified as "null", the first non-top window is selected. The top window is the one that would be selected by <code>selectWindow()</code> without providing a <code>windowID</code> . This should not be used when more than one popup window is in play.</li> <li>Otherwise, the window will be looked up considering <code>windowID</code> as the following in order: 1) the "name" of the window, as specified to <code>window.open()</code>; 2) a javascript variable which is a reference to a window; and 3) the title of the window. This is the same ordered lookup performed by <code>selectWindow</code> .</li> </ul>

### Usage

`
selectPopUp(windowID)
`

### Parameters

Parameter | Description
--------- | -----------
windowID | an identifier for the popup window, which can take on a number of different meanings

## Select Value

Select an option from a drop-down using a value.

### Usage

`
selectValue(locator, value)
`

`
selectValue(parentLocator, locator, value)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
value | a value

## Select Window

Selects a popup window using a window locator; once a popup window has been selected, all commands go to that window. To select the main window again, use null as the target.

 <p>

 Window locators provide different ways of specifying the window object: by title, by internal JavaScript "name," or by JavaScript variable. </p> <ul> <li><strong>title</strong>=<em>My Special Window</em>: Finds the window using the text that appears in the title bar. Be careful; two windows can share the same title. If that happens, this locator will just pick one.</li> <li><strong>name</strong>=<em>myWindow</em>: Finds the window using its internal JavaScript "name" property. This is the second parameter "windowName" passed to the JavaScript method window.open(url, windowName, windowFeatures, replaceFlag) (which Selenium intercepts).</li> <li><strong>var</strong>=<em>variableName</em>: Some pop-up windows are unnamed (anonymous), but are associated with a JavaScript variable name in the current application window, e.g. "window.foo = window.open(url);". In those cases, you can open the window using "var=foo".</li> </ul> <p> If no window locator prefix is provided, we'll try to guess what you mean like this: </p> <p> 1.) if windowID is null, (or the string "null") then it is assumed the user is referring to the original window instantiated by the browser). </p> <p> 2.) if the value of the "windowID" parameter is a JavaScript variable name in the current application window, then it is assumed that this variable contains the return value from a call to the JavaScript window.open() method. </p> <p> 3.) Otherwise, selenium looks in a hash it maintains that maps string names to window "names". </p> <p> 4.) If <em>that</em> fails, we'll try looping over all of the known windows to try to find the appropriate "title". Since "title" is not necessarily unique, this may have unexpected behavior. </p> <p> If you're having trouble figuring out the name of a window that you want to manipulate, look at the Selenium log messages which identify the names of windows created via window.open (and therefore intercepted by Selenium). You will see messages like the following for each window as it is opened: </p> <p> <code>debug: window.open call intercepted; window ID (which you can use with selectWindow()) is "myNewWindow"</code> </p> <p> In some cases, Selenium will be unable to intercept a call to window.open (if the call occurs during or before the "onLoad" event, for example). (This is bug SEL-339.) In those cases, you can force Selenium to notice the open window's name by using the Selenium openWindow command, using an empty (blank) url, like this: openWindow("", "myFunnyWindow"). </p>

### Usage

`
selectWindow(windowID)
`

### Parameters

Parameter | Description
--------- | -----------
windowID | the JavaScript window ID of the window to select

## Set Cursor Position

Moves the text cursor to the specified position in the given input element or textarea. This method will fail if the specified element isn't an input element or textarea.

### Usage

`
setCursorPosition(locator, position)
`

`
setCursorPosition(parentLocator, locator, position)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an input element or textarea
position | the numerical position of the cursor in the field; position should be 0 to move the position to the beginning of the field. You can also set the cursor to -1 to move it to the end of the field.

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

## Shift Key Down

Press the shift key and hold it down until doShiftUp() is called or a new page is loaded.

### Usage

`
shiftKeyDown()
`

### Parameters

Parameter | Description
--------- | -----------

## Shift Key Up

Release the shift key.

### Usage

`
shiftKeyUp()
`

### Parameters

Parameter | Description
--------- | -----------

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

## Store All Buttons

Stores the IDs of all buttons on the page in a variable for later access.

 <p> If a given button has no ID, it will appear as "" in this array. </p>

### Usage

`
storeAllButtons(variable)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the name of a variable in which the result is to be stored

## Store All Fields

Stores the IDs of all input fields on the page in a variable for later access.

 <p> If a given field has no ID, it will appear as "" in this array. </p>

### Usage

`
storeAllFields(variable)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the name of a variable in which the result is to be stored

## Store All Links

Stores the IDs of all links on the page in a variable for later access.

 <p> If a given link has no ID, it will appear as "" in this array. </p>

### Usage

`
storeAllLinks(variable)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the name of a variable in which the result is to be stored

## Store All Window Names

Stores the names of all windows that the browser knows about in a variable for later access.

### Usage

`
storeAllWindowNames(variable)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the name of a variable in which the result is to be stored

## Store All Window Titles

Stores the titles of all windows that the browser knows about in a variable for later access.

### Usage

`
storeAllWindowTitles(variable)
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

## Store Attribute From All Windows

Stores every instance of some attribute from all known windows in a variable for later access.

### Usage

`
storeAttributeFromAllWindows(attributeName, variable)
`

### Parameters

Parameter | Description
--------- | -----------
attributeName | name of an attribute on the windows
variable | the name of a variable in which the result is to be stored

## Store Body Text

Stores the entire text of the page in a variable for later access.

### Usage

`
storeBodyText(variable)
`

### Parameters

Parameter | Description
--------- | -----------
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

## Store Cookie

Stores all cookies of the current page under test in a variable for later access.

### Usage

`
storeCookie(variable)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the name of a variable in which the result is to be stored

## Store Cookie By Name

Stores the value of the cookie with the specified name in a variable for later access.

### Usage

`
storeCookieByName(name, variable)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie
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

## Store Cursor Position

Stores the text cursor position in the given input element or textarea in a variable for later access. Beware, this may not work perfectly on all browsers.

 <p> Specifically, if the cursor/selection has been cleared by JavaScript, this command will tend to return the position of the last location of the cursor, even though the cursor is now gone from the page. This is filed as <a href="http://jira.openqa.org/browse/SEL-243">SEL-243</a>. </p> This method will fail if the specified element isn't an input element or textarea, or there is no cursor in the element.

### Usage

`
storeCursorPosition(locator, variable)
`

`
storeCursorPosition(parentLocator, locator, variable)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an input element or textarea
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

## Store Eval Script

Stores the result of evaluating the specified JavaScript snippet in a variable for later access. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
storeEvalScript(script, variable)
`

### Parameters

Parameter | Description
--------- | -----------
script | the JavaScript snippet to run
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

## Store Html Source

Stores the entire HTML source between the opening and closing "html" tags in a variable for later access.

### Usage

`
storeHtmlSource(variable)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the name of a variable in which the result is to be stored

## Store Location

Stores the absolute URL of the current page in a variable for later access.

### Usage

`
storeLocation(variable)
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

## Store Select Options

Stores all option labels in the specified select drop-down in a variable for later access.

### Usage

`
storeSelectOptions(locator, variable)
`

`
storeSelectOptions(parentLocator, locator, variable)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
variable | the name of a variable in which the result is to be stored

## Store Selected Id

Stores option element ID for selected option in the specified select element in a variable for later access.

### Usage

`
storeSelectedId(locator, variable)
`

`
storeSelectedId(parentLocator, locator, variable)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
variable | the name of a variable in which the result is to be stored

## Store Selected Ids

Stores all option element IDs for selected options in the specified select or multi-select element in a variable for later access.

### Usage

`
storeSelectedIds(locator, variable)
`

`
storeSelectedIds(parentLocator, locator, variable)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
variable | the name of a variable in which the result is to be stored

## Store Selected Index

Stores option index (option number, starting at 0) for selected option in the specified select element in a variable for later access.

### Usage

`
storeSelectedIndex(locator, variable)
`

`
storeSelectedIndex(parentLocator, locator, variable)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
variable | the name of a variable in which the result is to be stored

## Store Selected Indexes

Stores all option indexes (option number, starting at 0) for selected options in the specified select or multi-select element in a variable for later access.

### Usage

`
storeSelectedIndexes(locator, variable)
`

`
storeSelectedIndexes(parentLocator, locator, variable)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
variable | the name of a variable in which the result is to be stored

## Store Selected Label

Stores option label (visible text) for selected option in the specified select element in a variable for later access.

### Usage

`
storeSelectedLabel(locator, variable)
`

`
storeSelectedLabel(parentLocator, locator, variable)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
variable | the name of a variable in which the result is to be stored

## Store Selected Labels

Stores all option labels (visible text) for selected options in the specified select or multi-select element in a variable for later access.

### Usage

`
storeSelectedLabels(locator, variable)
`

`
storeSelectedLabels(parentLocator, locator, variable)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
variable | the name of a variable in which the result is to be stored

## Store Selected Value

Stores option value (value attribute) for selected option in the specified select element in a variable for later access.

### Usage

`
storeSelectedValue(locator, variable)
`

`
storeSelectedValue(parentLocator, locator, variable)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
variable | the name of a variable in which the result is to be stored

## Store Selected Values

Stores all option values (value attributes) for selected options in the specified select or multi-select element in a variable for later access.

### Usage

`
storeSelectedValues(locator, variable)
`

`
storeSelectedValues(parentLocator, locator, variable)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
variable | the name of a variable in which the result is to be stored

## Store Table

Stores the text from a cell of a table in a variable for later access. The cellAddress syntax row.column, where row and column start at 0.

### Usage

`
storeTable(locator, cellAddress, variable)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator pointing to a table
cellAddress | a cell address, e.g. "1.4"
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

## Store Title

Stores the title of the current page in a variable for later access.

### Usage

`
storeTitle(variable)
`

### Parameters

Parameter | Description
--------- | -----------
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

## Submit

Submit the specified form. This is particularly useful for forms without submit buttons, e.g. single-input "Search" forms.

### Usage

`
submit(locator)
`

`
submit(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator for the form you want to submit

## Type

Sets the value of an input field, as though you typed it in.

 <p> Can also be used to set the value of combo boxes, check boxes, etc. In these cases, value should be the value of the option selected, not the visible text. </p>

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

## Type And Tab

Sets the value of an input field, as though you typed it in and press Tab key.

 <p> Can also be used to set the value of combo boxes, check boxes, etc. In these cases, value should be the value of the option selected, not the visible text. </p>

### Usage

`
typeAndTab(locator, value)
`

`
typeAndTab(parentLocator, locator, value)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
value | the value to type

## Type Keys

Simulates keystroke events on the specified element, as though you typed the value key-by-key.

 <p> This is a convenience method for calling keyDown, keyUp, keyPress for every character in the specified string; this is useful for dynamic UI widgets (like auto-completing combo boxes) that require explicit key events. </p> <p> Unlike the simple "type" command, which forces the specified value into the page directly, this command may or may not have any visible effect, even in cases where typing keys would normally have a visible effect. For example, if you use "typeKeys" on a form element, you may or may not see the results of what you typed in the field. </p> <p> In some cases, you may need to use the simple "type" command to set the value of the field and then the "typeKeys" command to send the keystroke events corresponding to what you just typed. </p>

### Usage

`
typeKeys(locator, value)
`

`
typeKeys(parentLocator, locator, value)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
value | the value to type

## Uncheck

Uncheck a toggle-button (checkbox/radio)

### Usage

`
uncheck(locator)
`

`
uncheck(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

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

## Verify All Buttons

Verifies that the IDs of all buttons on the page equals to the given value. When the verify fails, the test will continue execution, logging the failure.

 <p> If a given button has no ID, it will appear as "" in this array. </p>

### Usage

`
verifyAllButtons(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify All Buttons Match

Verifies that the IDs of all buttons on the page matches the given value. When the verify fails, the test will continue execution, logging the failure.

 <p> If a given button has no ID, it will appear as "" in this array. </p>

### Usage

`
verifyAllButtonsMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify All Buttons Not Match

Verifies that the IDs of all buttons on the page not match the given value. When the verify fails, the test will continue execution, logging the failure.

 <p> If a given button has no ID, it will appear as "" in this array. </p>

### Usage

`
verifyAllButtonsNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify All Fields

Verifies that the IDs of all input fields on the page equals to the given value. When the verify fails, the test will continue execution, logging the failure.

 <p> If a given field has no ID, it will appear as "" in this array. </p>

### Usage

`
verifyAllFields(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify All Fields Match

Verifies that the IDs of all input fields on the page matches the given value. When the verify fails, the test will continue execution, logging the failure.

 <p> If a given field has no ID, it will appear as "" in this array. </p>

### Usage

`
verifyAllFieldsMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify All Fields Not Match

Verifies that the IDs of all input fields on the page not match the given value. When the verify fails, the test will continue execution, logging the failure.

 <p> If a given field has no ID, it will appear as "" in this array. </p>

### Usage

`
verifyAllFieldsNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify All Links

Verifies that the IDs of all links on the page equals to the given value. When the verify fails, the test will continue execution, logging the failure.

 <p> If a given link has no ID, it will appear as "" in this array. </p>

### Usage

`
verifyAllLinks(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify All Links Match

Verifies that the IDs of all links on the page matches the given value. When the verify fails, the test will continue execution, logging the failure.

 <p> If a given link has no ID, it will appear as "" in this array. </p>

### Usage

`
verifyAllLinksMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify All Links Not Match

Verifies that the IDs of all links on the page not match the given value. When the verify fails, the test will continue execution, logging the failure.

 <p> If a given link has no ID, it will appear as "" in this array. </p>

### Usage

`
verifyAllLinksNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify All Window Names

Verifies that the names of all windows that the browser knows about equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyAllWindowNames(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify All Window Names Match

Verifies that the names of all windows that the browser knows about matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyAllWindowNamesMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify All Window Names Not Match

Verifies that the names of all windows that the browser knows about not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyAllWindowNamesNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify All Window Titles

Verifies that the titles of all windows that the browser knows about equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyAllWindowTitles(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify All Window Titles Match

Verifies that the titles of all windows that the browser knows about matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyAllWindowTitlesMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify All Window Titles Not Match

Verifies that the titles of all windows that the browser knows about not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyAllWindowTitlesNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

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

## Verify Attribute From All Windows

Verifies that every instance of some attribute from all known windows equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyAttributeFromAllWindows(attributeName, text)
`

### Parameters

Parameter | Description
--------- | -----------
attributeName | name of an attribute on the windows
text | the value to match with the result

## Verify Attribute From All Windows Match

Verifies that every instance of some attribute from all known windows matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyAttributeFromAllWindowsMatch(attributeName, text)
`

### Parameters

Parameter | Description
--------- | -----------
attributeName | name of an attribute on the windows
text | the value to match with the result

## Verify Attribute From All Windows Not Match

Verifies that every instance of some attribute from all known windows not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyAttributeFromAllWindowsNotMatch(attributeName, text)
`

### Parameters

Parameter | Description
--------- | -----------
attributeName | name of an attribute on the windows
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

## Verify Background Color

Verifies that the background color of the specified element equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyBackgroundColor(locator, text)
`

`
verifyBackgroundColor(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Body Text

Verifies that the entire text of the page equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyBodyText(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Body Text Match

Verifies that the entire text of the page matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyBodyTextMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Body Text Not Match

Verifies that the entire text of the page not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyBodyTextNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Border Color

Verifies that the border color of the specified element equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyBorderColor(locator, text)
`

`
verifyBorderColor(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
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

## Verify Color

Verifies that the text color of the specified element equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyColor(locator, text)
`

`
verifyColor(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

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

## Verify Cookie

Verifies that all cookies of the current page under test equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyCookie(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Cookie By Name

Verifies that the value of the cookie with the specified name equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyCookieByName(name, text)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie
text | the value to match with the result

## Verify Cookie By Name Match

Verifies that the value of the cookie with the specified name matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyCookieByNameMatch(name, text)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie
text | the value to match with the result

## Verify Cookie By Name Not Match

Verifies that the value of the cookie with the specified name not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyCookieByNameNotMatch(name, text)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie
text | the value to match with the result

## Verify Cookie Match

Verifies that all cookies of the current page under test matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyCookieMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Cookie Not Match

Verifies that all cookies of the current page under test not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyCookieNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Cookie Not Present

Verifies that a cookie with the specified name is not present. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyCookieNotPresent(name)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie

## Verify Cookie Present

Verifies that a cookie with the specified name is present. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyCookiePresent(name)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie

## Verify Css Count

Verifies that the number of nodes that match the specified css selector, eg equals to the given value. When the verify fails, the test will continue execution, logging the failure. "css=table" would give the number of tables.

### Usage

`
verifyCssCount(css, text)
`

### Parameters

Parameter | Description
--------- | -----------
css | the css selector to evaluate. do NOT wrap this expression in a 'count()' function; we will do that for you.
text | the value to match with the result

## Verify Cursor Position

Verifies that the text cursor position in the given input element or textarea equals to the given value. When the verify fails, the test will continue execution, logging the failure. Beware, this may not work perfectly on all browsers.

 <p> Specifically, if the cursor/selection has been cleared by JavaScript, this command will tend to return the position of the last location of the cursor, even though the cursor is now gone from the page. This is filed as <a href="http://jira.openqa.org/browse/SEL-243">SEL-243</a>. </p> This method will fail if the specified element isn't an input element or textarea, or there is no cursor in the element.

### Usage

`
verifyCursorPosition(locator, text)
`

`
verifyCursorPosition(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an input element or textarea
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

## Verify Element Height

Verifies that the height of an element equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyElementHeight(locator, text)
`

`
verifyElementHeight(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Element Index

Verifies that the relative index of an element to its parent (starting from 0) equals to the given value. When the verify fails, the test will continue execution, logging the failure. The comment node and empty text node will be ignored.

### Usage

`
verifyElementIndex(locator, text)
`

`
verifyElementIndex(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

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

## Verify Element Position Left

Verifies that the horizontal position of an element equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyElementPositionLeft(locator, text)
`

`
verifyElementPositionLeft(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Element Position Top

Verifies that the vertical position of an element equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyElementPositionTop(locator, text)
`

`
verifyElementPositionTop(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

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

## Verify Element Width

Verifies that the width of an element equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyElementWidth(locator, text)
`

`
verifyElementWidth(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

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

## Verify Eval Script

Verifies that the result of evaluating the specified JavaScript snippet equals to the given value. When the verify fails, the test will continue execution, logging the failure. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
verifyEvalScript(script, text)
`

### Parameters

Parameter | Description
--------- | -----------
script | the JavaScript snippet to run
text | the value to match with the result

## Verify Eval Script Match

Verifies that the result of evaluating the specified JavaScript snippet matches the given value. When the verify fails, the test will continue execution, logging the failure. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
verifyEvalScriptMatch(script, text)
`

### Parameters

Parameter | Description
--------- | -----------
script | the JavaScript snippet to run
text | the value to match with the result

## Verify Eval Script Not Match

Verifies that the result of evaluating the specified JavaScript snippet not match the given value. When the verify fails, the test will continue execution, logging the failure. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
verifyEvalScriptNotMatch(script, text)
`

### Parameters

Parameter | Description
--------- | -----------
script | the JavaScript snippet to run
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

## Verify Font Family

Verifies that the font family of the specified element equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyFontFamily(locator, text)
`

`
verifyFontFamily(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Font Family Match

Verifies that the font family of the specified element matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyFontFamilyMatch(locator, text)
`

`
verifyFontFamilyMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Font Family Not Match

Verifies that the font family of the specified element not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyFontFamilyNotMatch(locator, text)
`

`
verifyFontFamilyNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Font Size

Verifies that the font size of the specified element equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyFontSize(locator, text)
`

`
verifyFontSize(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Font Size Match

Verifies that the font size of the specified element matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyFontSizeMatch(locator, text)
`

`
verifyFontSizeMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Font Size Not Match

Verifies that the font size of the specified element not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyFontSizeNotMatch(locator, text)
`

`
verifyFontSizeNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Font Style

Verifies that the font style of the specified element equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyFontStyle(locator, text)
`

`
verifyFontStyle(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Font Style Match

Verifies that the font style of the specified element matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyFontStyleMatch(locator, text)
`

`
verifyFontStyleMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Font Style Not Match

Verifies that the font style of the specified element not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyFontStyleNotMatch(locator, text)
`

`
verifyFontStyleNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Font Weight

Verifies that the font weight of the specified element equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyFontWeight(locator, text)
`

`
verifyFontWeight(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Font Weight Match

Verifies that the font weight of the specified element matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyFontWeightMatch(locator, text)
`

`
verifyFontWeightMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Font Weight Not Match

Verifies that the font weight of the specified element not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyFontWeightNotMatch(locator, text)
`

`
verifyFontWeightNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Html Source

Verifies that the entire HTML source between the opening and closing "html" tags equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyHtmlSource(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Html Source Match

Verifies that the entire HTML source between the opening and closing "html" tags matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyHtmlSourceMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Html Source Not Match

Verifies that the entire HTML source between the opening and closing "html" tags not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyHtmlSourceNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
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

## Verify Location

Verifies that the absolute URL of the current page equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyLocation(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Location Match

Verifies that the absolute URL of the current page matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyLocationMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Location Not Match

Verifies that the absolute URL of the current page not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyLocationNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

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

## Verify Not All Buttons

Verifies that the IDs of all buttons on the page not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

 <p> If a given button has no ID, it will appear as "" in this array. </p>

### Usage

`
verifyNotAllButtons(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Not All Fields

Verifies that the IDs of all input fields on the page not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

 <p> If a given field has no ID, it will appear as "" in this array. </p>

### Usage

`
verifyNotAllFields(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Not All Links

Verifies that the IDs of all links on the page not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

 <p> If a given link has no ID, it will appear as "" in this array. </p>

### Usage

`
verifyNotAllLinks(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Not All Window Names

Verifies that the names of all windows that the browser knows about not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotAllWindowNames(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Not All Window Titles

Verifies that the titles of all windows that the browser knows about not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotAllWindowTitles(text)
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

## Verify Not Attribute From All Windows

Verifies that every instance of some attribute from all known windows not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotAttributeFromAllWindows(attributeName, text)
`

### Parameters

Parameter | Description
--------- | -----------
attributeName | name of an attribute on the windows
text | the value to match with the result

## Verify Not Background Color

Verifies that the background color of the specified element not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotBackgroundColor(locator, text)
`

`
verifyNotBackgroundColor(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Not Body Text

Verifies that the entire text of the page not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotBodyText(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Not Border Color

Verifies that the border color of the specified element not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotBorderColor(locator, text)
`

`
verifyNotBorderColor(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
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

## Verify Not Color

Verifies that the text color of the specified element not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotColor(locator, text)
`

`
verifyNotColor(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

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

## Verify Not Cookie

Verifies that all cookies of the current page under test not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotCookie(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Not Cookie By Name

Verifies that the value of the cookie with the specified name not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotCookieByName(name, text)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie
text | the value to match with the result

## Verify Not Css Count

Verifies that the number of nodes that match the specified css selector, eg not equal to the given value. When the verify fails, the test will continue execution, logging the failure. "css=table" would give the number of tables.

### Usage

`
verifyNotCssCount(css, text)
`

### Parameters

Parameter | Description
--------- | -----------
css | the css selector to evaluate. do NOT wrap this expression in a 'count()' function; we will do that for you.
text | the value to match with the result

## Verify Not Cursor Position

Verifies that the text cursor position in the given input element or textarea not equal to the given value. When the verify fails, the test will continue execution, logging the failure. Beware, this may not work perfectly on all browsers.

 <p> Specifically, if the cursor/selection has been cleared by JavaScript, this command will tend to return the position of the last location of the cursor, even though the cursor is now gone from the page. This is filed as <a href="http://jira.openqa.org/browse/SEL-243">SEL-243</a>. </p> This method will fail if the specified element isn't an input element or textarea, or there is no cursor in the element.

### Usage

`
verifyNotCursorPosition(locator, text)
`

`
verifyNotCursorPosition(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an input element or textarea
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

## Verify Not Element Height

Verifies that the height of an element not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotElementHeight(locator, text)
`

`
verifyNotElementHeight(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Not Element Index

Verifies that the relative index of an element to its parent (starting from 0) not equal to the given value. When the verify fails, the test will continue execution, logging the failure. The comment node and empty text node will be ignored.

### Usage

`
verifyNotElementIndex(locator, text)
`

`
verifyNotElementIndex(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Not Element Position Left

Verifies that the horizontal position of an element not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotElementPositionLeft(locator, text)
`

`
verifyNotElementPositionLeft(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Not Element Position Top

Verifies that the vertical position of an element not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotElementPositionTop(locator, text)
`

`
verifyNotElementPositionTop(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Not Element Width

Verifies that the width of an element not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotElementWidth(locator, text)
`

`
verifyNotElementWidth(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

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

## Verify Not Eval Script

Verifies that the result of evaluating the specified JavaScript snippet not equal to the given value. When the verify fails, the test will continue execution, logging the failure. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
verifyNotEvalScript(script, text)
`

### Parameters

Parameter | Description
--------- | -----------
script | the JavaScript snippet to run
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

## Verify Not Font Family

Verifies that the font family of the specified element not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotFontFamily(locator, text)
`

`
verifyNotFontFamily(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Not Font Size

Verifies that the font size of the specified element not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotFontSize(locator, text)
`

`
verifyNotFontSize(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Not Font Style

Verifies that the font style of the specified element not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotFontStyle(locator, text)
`

`
verifyNotFontStyle(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Not Font Weight

Verifies that the font weight of the specified element not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotFontWeight(locator, text)
`

`
verifyNotFontWeight(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Not Html Source

Verifies that the entire HTML source between the opening and closing "html" tags not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotHtmlSource(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Not Location

Verifies that the absolute URL of the current page not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotLocation(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Not Ordered

Verifies that these two elements have same parent and are ordered siblings in the DOM. When the verify fails, the test will continue execution, logging the failure. Two same elements will not be considered ordered.

### Usage

`
verifyNotOrdered(firstLocator, secondLocator)
`

### Parameters

Parameter | Description
--------- | -----------
firstLocator | an element locator pointing to the first element
secondLocator | an element locator pointing to the second element

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

## Verify Not Select Options

Verifies that all option labels in the specified select drop-down not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotSelectOptions(locator, text)
`

`
verifyNotSelectOptions(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Not Selected Id

Verifies that option element ID for selected option in the specified select element not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotSelectedId(locator, text)
`

`
verifyNotSelectedId(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Not Selected Ids

Verifies that all option element IDs for selected options in the specified select or multi-select element not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotSelectedIds(locator, text)
`

`
verifyNotSelectedIds(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Not Selected Index

Verifies that option index (option number, starting at 0) for selected option in the specified select element not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotSelectedIndex(locator, text)
`

`
verifyNotSelectedIndex(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Not Selected Indexes

Verifies that all option indexes (option number, starting at 0) for selected options in the specified select or multi-select element not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotSelectedIndexes(locator, text)
`

`
verifyNotSelectedIndexes(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Not Selected Label

Verifies that option label (visible text) for selected option in the specified select element not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotSelectedLabel(locator, text)
`

`
verifyNotSelectedLabel(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Not Selected Labels

Verifies that all option labels (visible text) for selected options in the specified select or multi-select element not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotSelectedLabels(locator, text)
`

`
verifyNotSelectedLabels(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Not Selected Value

Verifies that option value (value attribute) for selected option in the specified select element not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotSelectedValue(locator, text)
`

`
verifyNotSelectedValue(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Not Selected Values

Verifies that all option values (value attributes) for selected options in the specified select or multi-select element not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotSelectedValues(locator, text)
`

`
verifyNotSelectedValues(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Not Something Selected

Verifies that some option in a drop-down menu is not selected. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotSomethingSelected(locator)
`

`
verifyNotSomethingSelected(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu

## Verify Not Table

Verifies that the text from a cell of a table not equal to the given value. When the verify fails, the test will continue execution, logging the failure. The cellAddress syntax row.column, where row and column start at 0.

### Usage

`
verifyNotTable(locator, cellAddress, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator pointing to a table
cellAddress | a cell address, e.g. "1.4"
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

## Verify Not Text Alignment

Verifies that the text alignment of the specified element not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotTextAlignment(locator, text)
`

`
verifyNotTextAlignment(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Not Text Decoration

Verifies that the text decoration of the specified element not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotTextDecoration(locator, text)
`

`
verifyNotTextDecoration(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
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

## Verify Not Title

Verifies that the title of the current page not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotTitle(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

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

## Verify Not Xpath Count

Verifies that the number of nodes that match the specified xpath, eg not equal to the given value. When the verify fails, the test will continue execution, logging the failure. "//table" would give the number of tables.

### Usage

`
verifyNotXpathCount(xpath, text)
`

### Parameters

Parameter | Description
--------- | -----------
xpath | the xpath expression to evaluate. do NOT wrap this expression in a 'count()' function; we will do that for you.
text | the value to match with the result

## Verify Ordered

Verifies that these two elements have same parent and are ordered siblings in the DOM. When the verify fails, the test will continue execution, logging the failure. Two same elements will not be considered ordered.

### Usage

`
verifyOrdered(firstLocator, secondLocator)
`

### Parameters

Parameter | Description
--------- | -----------
firstLocator | an element locator pointing to the first element
secondLocator | an element locator pointing to the second element

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

## Verify Select Options

Verifies that all option labels in the specified select drop-down equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectOptions(locator, text)
`

`
verifySelectOptions(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Select Options Match

Verifies that all option labels in the specified select drop-down matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectOptionsMatch(locator, text)
`

`
verifySelectOptionsMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Select Options Not Match

Verifies that all option labels in the specified select drop-down not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectOptionsNotMatch(locator, text)
`

`
verifySelectOptionsNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Id

Verifies that option element ID for selected option in the specified select element equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedId(locator, text)
`

`
verifySelectedId(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Id Match

Verifies that option element ID for selected option in the specified select element matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedIdMatch(locator, text)
`

`
verifySelectedIdMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Id Not Match

Verifies that option element ID for selected option in the specified select element not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedIdNotMatch(locator, text)
`

`
verifySelectedIdNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Ids

Verifies that all option element IDs for selected options in the specified select or multi-select element equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedIds(locator, text)
`

`
verifySelectedIds(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Ids Match

Verifies that all option element IDs for selected options in the specified select or multi-select element matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedIdsMatch(locator, text)
`

`
verifySelectedIdsMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Ids Not Match

Verifies that all option element IDs for selected options in the specified select or multi-select element not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedIdsNotMatch(locator, text)
`

`
verifySelectedIdsNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Index

Verifies that option index (option number, starting at 0) for selected option in the specified select element equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedIndex(locator, text)
`

`
verifySelectedIndex(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Index Match

Verifies that option index (option number, starting at 0) for selected option in the specified select element matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedIndexMatch(locator, text)
`

`
verifySelectedIndexMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Index Not Match

Verifies that option index (option number, starting at 0) for selected option in the specified select element not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedIndexNotMatch(locator, text)
`

`
verifySelectedIndexNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Indexes

Verifies that all option indexes (option number, starting at 0) for selected options in the specified select or multi-select element equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedIndexes(locator, text)
`

`
verifySelectedIndexes(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Indexes Match

Verifies that all option indexes (option number, starting at 0) for selected options in the specified select or multi-select element matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedIndexesMatch(locator, text)
`

`
verifySelectedIndexesMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Indexes Not Match

Verifies that all option indexes (option number, starting at 0) for selected options in the specified select or multi-select element not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedIndexesNotMatch(locator, text)
`

`
verifySelectedIndexesNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Label

Verifies that option label (visible text) for selected option in the specified select element equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedLabel(locator, text)
`

`
verifySelectedLabel(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Label Match

Verifies that option label (visible text) for selected option in the specified select element matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedLabelMatch(locator, text)
`

`
verifySelectedLabelMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Label Not Match

Verifies that option label (visible text) for selected option in the specified select element not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedLabelNotMatch(locator, text)
`

`
verifySelectedLabelNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Labels

Verifies that all option labels (visible text) for selected options in the specified select or multi-select element equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedLabels(locator, text)
`

`
verifySelectedLabels(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Labels Match

Verifies that all option labels (visible text) for selected options in the specified select or multi-select element matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedLabelsMatch(locator, text)
`

`
verifySelectedLabelsMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Labels Not Match

Verifies that all option labels (visible text) for selected options in the specified select or multi-select element not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedLabelsNotMatch(locator, text)
`

`
verifySelectedLabelsNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Value

Verifies that option value (value attribute) for selected option in the specified select element equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedValue(locator, text)
`

`
verifySelectedValue(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Value Match

Verifies that option value (value attribute) for selected option in the specified select element matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedValueMatch(locator, text)
`

`
verifySelectedValueMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Value Not Match

Verifies that option value (value attribute) for selected option in the specified select element not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedValueNotMatch(locator, text)
`

`
verifySelectedValueNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Values

Verifies that all option values (value attributes) for selected options in the specified select or multi-select element equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedValues(locator, text)
`

`
verifySelectedValues(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Values Match

Verifies that all option values (value attributes) for selected options in the specified select or multi-select element matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedValuesMatch(locator, text)
`

`
verifySelectedValuesMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Values Not Match

Verifies that all option values (value attributes) for selected options in the specified select or multi-select element not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedValuesNotMatch(locator, text)
`

`
verifySelectedValuesNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Something Selected

Verifies that some option in a drop-down menu is selected. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySomethingSelected(locator)
`

`
verifySomethingSelected(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu

## Verify Table

Verifies that the text from a cell of a table equals to the given value. When the verify fails, the test will continue execution, logging the failure. The cellAddress syntax row.column, where row and column start at 0.

### Usage

`
verifyTable(locator, cellAddress, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator pointing to a table
cellAddress | a cell address, e.g. "1.4"
text | the value to match with the result

## Verify Table Match

Verifies that the text from a cell of a table matches the given value. When the verify fails, the test will continue execution, logging the failure. The cellAddress syntax row.column, where row and column start at 0.

### Usage

`
verifyTableMatch(locator, cellAddress, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator pointing to a table
cellAddress | a cell address, e.g. "1.4"
text | the value to match with the result

## Verify Table Not Match

Verifies that the text from a cell of a table not match the given value. When the verify fails, the test will continue execution, logging the failure. The cellAddress syntax row.column, where row and column start at 0.

### Usage

`
verifyTableNotMatch(locator, cellAddress, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator pointing to a table
cellAddress | a cell address, e.g. "1.4"
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

## Verify Text Alignment

Verifies that the text alignment of the specified element equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTextAlignment(locator, text)
`

`
verifyTextAlignment(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Text Alignment Match

Verifies that the text alignment of the specified element matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTextAlignmentMatch(locator, text)
`

`
verifyTextAlignmentMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Text Alignment Not Match

Verifies that the text alignment of the specified element not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTextAlignmentNotMatch(locator, text)
`

`
verifyTextAlignmentNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Text Decoration

Verifies that the text decoration of the specified element equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTextDecoration(locator, text)
`

`
verifyTextDecoration(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Text Decoration Match

Verifies that the text decoration of the specified element matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTextDecorationMatch(locator, text)
`

`
verifyTextDecorationMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Text Decoration Not Match

Verifies that the text decoration of the specified element not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTextDecorationNotMatch(locator, text)
`

`
verifyTextDecorationNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
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

Verifies that the specified text pattern appears somewhere on the rendered page shown to the user. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTextNotPresent(pattern)
`

### Parameters

Parameter | Description
--------- | -----------
pattern | a pattern to match with the text of the page

## Verify Text Present

Verifies that the specified text pattern appears somewhere on the rendered page shown to the user. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTextPresent(pattern)
`

### Parameters

Parameter | Description
--------- | -----------
pattern | a pattern to match with the text of the page

## Verify Title

Verifies that the title of the current page equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTitle(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Title Match

Verifies that the title of the current page matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTitleMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Title Not Match

Verifies that the title of the current page not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTitleNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
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

## Verify Xpath Count

Verifies that the number of nodes that match the specified xpath, eg equals to the given value. When the verify fails, the test will continue execution, logging the failure. "//table" would give the number of tables.

### Usage

`
verifyXpathCount(xpath, text)
`

### Parameters

Parameter | Description
--------- | -----------
xpath | the xpath expression to evaluate. do NOT wrap this expression in a 'count()' function; we will do that for you.
text | the value to match with the result

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

## Wait For Body Text

Waits for the entire text of the page equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForBodyText(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Body Text Match

Waits for the entire text of the page matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForBodyTextMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Body Text Not Match

Waits for the entire text of the page not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForBodyTextNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
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

## Wait For Condition

Runs the specified JavaScript snippet repeatedly until it evaluates to "true". The snippet may have multiple lines, but only the result of the last line will be considered.

 <p> Note that, by default, the snippet will be run in the runner's test window, not in the window of your application. To get the window of your application, you can use the JavaScript snippet <code>selenium.browserbot.getCurrentWindow()</code>, and then run your JavaScript in there </p>

### Usage

`
waitForCondition(script, timeout)
`

### Parameters

Parameter | Description
--------- | -----------
script | the JavaScript snippet to run
timeout | a timeout in milliseconds, after which this command will return with an error

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

## Wait For Cookie

Waits for all cookies of the current page under test equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForCookie(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Cookie By Name

Waits for the value of the cookie with the specified name equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForCookieByName(name, text)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie
text | the value to match with the result

## Wait For Cookie By Name Match

Waits for the value of the cookie with the specified name matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForCookieByNameMatch(name, text)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie
text | the value to match with the result

## Wait For Cookie By Name Not Match

Waits for the value of the cookie with the specified name not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForCookieByNameNotMatch(name, text)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie
text | the value to match with the result

## Wait For Cookie Match

Waits for all cookies of the current page under test matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForCookieMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Cookie Not Match

Waits for all cookies of the current page under test not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForCookieNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Cookie Not Present

Waits for a cookie with the specified name is not present. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForCookieNotPresent(name)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie

## Wait For Cookie Present

Waits for a cookie with the specified name is present. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForCookiePresent(name)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie

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

## Wait For Eval Script

Waits for the result of evaluating the specified JavaScript snippet equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
waitForEvalScript(script, text)
`

### Parameters

Parameter | Description
--------- | -----------
script | the JavaScript snippet to run
text | the value to match with the result

## Wait For Eval Script Match

Waits for the result of evaluating the specified JavaScript snippet matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
waitForEvalScriptMatch(script, text)
`

### Parameters

Parameter | Description
--------- | -----------
script | the JavaScript snippet to run
text | the value to match with the result

## Wait For Eval Script Not Match

Waits for the result of evaluating the specified JavaScript snippet not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
waitForEvalScriptNotMatch(script, text)
`

### Parameters

Parameter | Description
--------- | -----------
script | the JavaScript snippet to run
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

## Wait For Html Source

Waits for the entire HTML source between the opening and closing "html" tags equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForHtmlSource(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Html Source Match

Waits for the entire HTML source between the opening and closing "html" tags matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForHtmlSourceMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Html Source Not Match

Waits for the entire HTML source between the opening and closing "html" tags not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForHtmlSourceNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Location

Waits for the absolute URL of the current page equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForLocation(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Location Match

Waits for the absolute URL of the current page matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForLocationMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Location Not Match

Waits for the absolute URL of the current page not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForLocationNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

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

## Wait For Not Body Text

Waits for the entire text of the page not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotBodyText(text)
`

### Parameters

Parameter | Description
--------- | -----------
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

## Wait For Not Cookie

Waits for all cookies of the current page under test not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotCookie(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Not Cookie By Name

Waits for the value of the cookie with the specified name not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotCookieByName(name, text)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie
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

## Wait For Not Eval Script

Waits for the result of evaluating the specified JavaScript snippet not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
waitForNotEvalScript(script, text)
`

### Parameters

Parameter | Description
--------- | -----------
script | the JavaScript snippet to run
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

## Wait For Not Html Source

Waits for the entire HTML source between the opening and closing "html" tags not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotHtmlSource(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Not Location

Waits for the absolute URL of the current page not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotLocation(text)
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

## Wait For Not Selected Id

Waits for option element ID for selected option in the specified select element not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotSelectedId(locator, text)
`

`
waitForNotSelectedId(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Wait For Not Selected Index

Waits for option index (option number, starting at 0) for selected option in the specified select element not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotSelectedIndex(locator, text)
`

`
waitForNotSelectedIndex(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Wait For Not Selected Label

Waits for option label (visible text) for selected option in the specified select element not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotSelectedLabel(locator, text)
`

`
waitForNotSelectedLabel(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Wait For Not Selected Value

Waits for option value (value attribute) for selected option in the specified select element not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotSelectedValue(locator, text)
`

`
waitForNotSelectedValue(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Wait For Not Something Selected

Waits for some option in a drop-down menu is not selected. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotSomethingSelected(locator)
`

`
waitForNotSomethingSelected(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu

## Wait For Not Table

Waits for the text from a cell of a table not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. The cellAddress syntax row.column, where row and column start at 0.

### Usage

`
waitForNotTable(locator, cellAddress, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator pointing to a table
cellAddress | a cell address, e.g. "1.4"
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

## Wait For Not Title

Waits for the title of the current page not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotTitle(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

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

## Wait For Page To Load

Waits for a new page to load.

 <p> You can use this command instead of the "AndWait" suffixes, "clickAndWait", "selectAndWait", "typeAndWait" etc. (which are only available in the JS API). </p> <p> Selenium constantly keeps track of new pages loading, and sets a "newPageLoaded" flag when it first notices a page load. Running any other Selenium command after turns the flag to false. Hence, if you want to wait for a page to load, you must wait immediately after a Selenium command that caused a page-load. </p>

### Usage

`
waitForPageToLoad(timeout)
`

### Parameters

Parameter | Description
--------- | -----------
timeout | a timeout in milliseconds, after which this command will return with an error

## Wait For Pop Up

Waits for a popup window to appear and load up.

### Usage

`
waitForPopUp(windowID, timeout)
`

### Parameters

Parameter | Description
--------- | -----------
windowID | the JavaScript window "name" of the window that will appear (not the text of the title bar) If unspecified, or specified as "null", this command will wait for the first non-top window to appear (don't rely on this if you are working with multiple popups simultaneously).
timeout | a timeout in milliseconds, after which the action will return with an error. If this value is not specified, the default Selenium timeout will be used. See the setTimeout() command.

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

## Wait For Selected Id

Waits for option element ID for selected option in the specified select element equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForSelectedId(locator, text)
`

`
waitForSelectedId(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Wait For Selected Id Match

Waits for option element ID for selected option in the specified select element matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForSelectedIdMatch(locator, text)
`

`
waitForSelectedIdMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Wait For Selected Id Not Match

Waits for option element ID for selected option in the specified select element not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForSelectedIdNotMatch(locator, text)
`

`
waitForSelectedIdNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Wait For Selected Index

Waits for option index (option number, starting at 0) for selected option in the specified select element equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForSelectedIndex(locator, text)
`

`
waitForSelectedIndex(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Wait For Selected Index Match

Waits for option index (option number, starting at 0) for selected option in the specified select element matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForSelectedIndexMatch(locator, text)
`

`
waitForSelectedIndexMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Wait For Selected Index Not Match

Waits for option index (option number, starting at 0) for selected option in the specified select element not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForSelectedIndexNotMatch(locator, text)
`

`
waitForSelectedIndexNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Wait For Selected Label

Waits for option label (visible text) for selected option in the specified select element equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForSelectedLabel(locator, text)
`

`
waitForSelectedLabel(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Wait For Selected Label Match

Waits for option label (visible text) for selected option in the specified select element matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForSelectedLabelMatch(locator, text)
`

`
waitForSelectedLabelMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Wait For Selected Label Not Match

Waits for option label (visible text) for selected option in the specified select element not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForSelectedLabelNotMatch(locator, text)
`

`
waitForSelectedLabelNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Wait For Selected Value

Waits for option value (value attribute) for selected option in the specified select element equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForSelectedValue(locator, text)
`

`
waitForSelectedValue(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Wait For Selected Value Match

Waits for option value (value attribute) for selected option in the specified select element matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForSelectedValueMatch(locator, text)
`

`
waitForSelectedValueMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Wait For Selected Value Not Match

Waits for option value (value attribute) for selected option in the specified select element not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForSelectedValueNotMatch(locator, text)
`

`
waitForSelectedValueNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Wait For Something Selected

Waits for some option in a drop-down menu is selected. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForSomethingSelected(locator)
`

`
waitForSomethingSelected(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu

## Wait For Table

Waits for the text from a cell of a table equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. The cellAddress syntax row.column, where row and column start at 0.

### Usage

`
waitForTable(locator, cellAddress, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator pointing to a table
cellAddress | a cell address, e.g. "1.4"
text | the value to match with the result

## Wait For Table Match

Waits for the text from a cell of a table matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. The cellAddress syntax row.column, where row and column start at 0.

### Usage

`
waitForTableMatch(locator, cellAddress, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator pointing to a table
cellAddress | a cell address, e.g. "1.4"
text | the value to match with the result

## Wait For Table Not Match

Waits for the text from a cell of a table not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. The cellAddress syntax row.column, where row and column start at 0.

### Usage

`
waitForTableNotMatch(locator, cellAddress, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator pointing to a table
cellAddress | a cell address, e.g. "1.4"
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

Waits for the specified text pattern appears somewhere on the rendered page shown to the user. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForTextNotPresent(pattern)
`

### Parameters

Parameter | Description
--------- | -----------
pattern | a pattern to match with the text of the page

## Wait For Text Present

Waits for the specified text pattern appears somewhere on the rendered page shown to the user. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForTextPresent(pattern)
`

### Parameters

Parameter | Description
--------- | -----------
pattern | a pattern to match with the text of the page

## Wait For Title

Waits for the title of the current page equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForTitle(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Title Match

Waits for the title of the current page matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForTitleMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Title Not Match

Waits for the title of the current page not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForTitleNotMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
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

## Window Focus

Gives focus to the currently selected window

### Usage

`
windowFocus()
`

### Parameters

Parameter | Description
--------- | -----------

## Window Maximize

Resize currently selected window to take up the entire screen

### Usage

`
windowMaximize()
`

### Parameters

Parameter | Description
--------- | -----------

