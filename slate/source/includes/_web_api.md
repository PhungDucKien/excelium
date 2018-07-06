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
15 | Assert Alert Contain | assertAlertContain | text |  | 
16 | Assert Alert Not Contain | assertAlertNotContain | text |  | 
17 | Assert Alert Not Present | assertAlertNotPresent |  |  | 
18 | Assert Alert Present | assertAlertPresent |  |  | 
19 | Assert Attribute | assertAttribute | locator | name | text
20 | Assert Attribute Contain | assertAttributeContain | locator | name | text
21 | Assert Attribute Not Contain | assertAttributeNotContain | locator | name | text
22 | Assert Background Color | assertBackgroundColor | locator | text | 
23 | Assert Background Color | assertBackgroundColor | parentLocator | locator | text
24 | Assert Body Text | assertBodyText | text |  | 
25 | Assert Body Text Contain | assertBodyTextContain | text |  | 
26 | Assert Body Text Not Contain | assertBodyTextNotContain | text |  | 
27 | Assert Border Color | assertBorderColor | locator | text | 
28 | Assert Border Color | assertBorderColor | parentLocator | locator | text
29 | Assert Checked | assertChecked | locator |  | 
30 | Assert Checked | assertChecked | parentLocator | locator | 
31 | Assert Color | assertColor | locator | text | 
32 | Assert Color | assertColor | parentLocator | locator | text
33 | Assert Confirmation | assertConfirmation | text |  | 
34 | Assert Confirmation Contain | assertConfirmationContain | text |  | 
35 | Assert Confirmation Not Contain | assertConfirmationNotContain | text |  | 
36 | Assert Confirmation Not Present | assertConfirmationNotPresent |  |  | 
37 | Assert Confirmation Present | assertConfirmationPresent |  |  | 
38 | Assert Cookie | assertCookie | text |  | 
39 | Assert Cookie By Name | assertCookieByName | name | text | 
40 | Assert Cookie By Name Contain | assertCookieByNameContain | name | text | 
41 | Assert Cookie By Name Not Contain | assertCookieByNameNotContain | name | text | 
42 | Assert Cookie Contain | assertCookieContain | text |  | 
43 | Assert Cookie Not Contain | assertCookieNotContain | text |  | 
44 | Assert Cookie Not Present | assertCookieNotPresent | name |  | 
45 | Assert Cookie Present | assertCookiePresent | name |  | 
46 | Assert Css Count | assertCssCount | css | text | 
47 | Assert Cursor Position | assertCursorPosition | locator | text | 
48 | Assert Cursor Position | assertCursorPosition | parentLocator | locator | text
49 | Assert Date List Order Asc | assertDateListOrderAsc | locator | format | 
50 | Assert Date List Order Asc | assertDateListOrderAsc | parentLocator | locator | format
51 | Assert Date List Order Desc | assertDateListOrderDesc | locator | format | 
52 | Assert Date List Order Desc | assertDateListOrderDesc | parentLocator | locator | format
53 | Assert Editable | assertEditable | locator |  | 
54 | Assert Editable | assertEditable | parentLocator | locator | 
55 | Assert Element Height | assertElementHeight | locator | text | 
56 | Assert Element Height | assertElementHeight | parentLocator | locator | text
57 | Assert Element Index | assertElementIndex | locator | text | 
58 | Assert Element Index | assertElementIndex | parentLocator | locator | text
59 | Assert Element Not Present | assertElementNotPresent | locator |  | 
60 | Assert Element Not Present | assertElementNotPresent | parentLocator | locator | 
61 | Assert Element Position Left | assertElementPositionLeft | locator | text | 
62 | Assert Element Position Left | assertElementPositionLeft | parentLocator | locator | text
63 | Assert Element Position Top | assertElementPositionTop | locator | text | 
64 | Assert Element Position Top | assertElementPositionTop | parentLocator | locator | text
65 | Assert Element Present | assertElementPresent | locator |  | 
66 | Assert Element Present | assertElementPresent | parentLocator | locator | 
67 | Assert Element Width | assertElementWidth | locator | text | 
68 | Assert Element Width | assertElementWidth | parentLocator | locator | text
69 | Assert Eval | assertEval | expression | text | 
70 | Assert Eval Script | assertEvalScript | script | text | 
71 | Assert Eval Script Contain | assertEvalScriptContain | script | text | 
72 | Assert Eval Script Not Contain | assertEvalScriptNotContain | script | text | 
73 | Assert Exists In Database | assertExistsInDatabase | sql |  | 
74 | Assert Expression | assertExpression | expression | text | 
75 | Assert Expression Contain | assertExpressionContain | expression | text | 
76 | Assert Expression Not Contain | assertExpressionNotContain | expression | text | 
77 | Assert Font Family | assertFontFamily | locator | text | 
78 | Assert Font Family | assertFontFamily | parentLocator | locator | text
79 | Assert Font Family Contain | assertFontFamilyContain | locator | text | 
80 | Assert Font Family Contain | assertFontFamilyContain | parentLocator | locator | text
81 | Assert Font Family Not Contain | assertFontFamilyNotContain | locator | text | 
82 | Assert Font Family Not Contain | assertFontFamilyNotContain | parentLocator | locator | text
83 | Assert Font Size | assertFontSize | locator | text | 
84 | Assert Font Size | assertFontSize | parentLocator | locator | text
85 | Assert Font Size Contain | assertFontSizeContain | locator | text | 
86 | Assert Font Size Contain | assertFontSizeContain | parentLocator | locator | text
87 | Assert Font Size Not Contain | assertFontSizeNotContain | locator | text | 
88 | Assert Font Size Not Contain | assertFontSizeNotContain | parentLocator | locator | text
89 | Assert Font Style | assertFontStyle | locator | text | 
90 | Assert Font Style | assertFontStyle | parentLocator | locator | text
91 | Assert Font Style Contain | assertFontStyleContain | locator | text | 
92 | Assert Font Style Contain | assertFontStyleContain | parentLocator | locator | text
93 | Assert Font Style Not Contain | assertFontStyleNotContain | locator | text | 
94 | Assert Font Style Not Contain | assertFontStyleNotContain | parentLocator | locator | text
95 | Assert Font Weight | assertFontWeight | locator | text | 
96 | Assert Font Weight | assertFontWeight | parentLocator | locator | text
97 | Assert Font Weight Contain | assertFontWeightContain | locator | text | 
98 | Assert Font Weight Contain | assertFontWeightContain | parentLocator | locator | text
99 | Assert Font Weight Not Contain | assertFontWeightNotContain | locator | text | 
100 | Assert Font Weight Not Contain | assertFontWeightNotContain | parentLocator | locator | text
101 | Assert Html Source | assertHtmlSource | text |  | 
102 | Assert Html Source Contain | assertHtmlSourceContain | text |  | 
103 | Assert Html Source Not Contain | assertHtmlSourceNotContain | text |  | 
104 | Assert Integer List Order Asc | assertIntegerListOrderAsc | locator |  | 
105 | Assert Integer List Order Asc | assertIntegerListOrderAsc | parentLocator | locator | 
106 | Assert Integer List Order Desc | assertIntegerListOrderDesc | locator |  | 
107 | Assert Integer List Order Desc | assertIntegerListOrderDesc | parentLocator | locator | 
108 | Assert List Contain | assertListContain | variable | text | 
109 | Assert List Not Contain | assertListNotContain | variable | text | 
110 | Assert List Order Asc | assertListOrderAsc | variable |  | 
111 | Assert List Order Desc | assertListOrderDesc | variable |  | 
112 | Assert Location | assertLocation | text |  | 
113 | Assert Location Contain | assertLocationContain | text |  | 
114 | Assert Location Not Contain | assertLocationNotContain | text |  | 
115 | Assert Not Alert | assertNotAlert | text |  | 
116 | Assert Not Attribute | assertNotAttribute | locator | name | text
117 | Assert Not Background Color | assertNotBackgroundColor | locator | text | 
118 | Assert Not Background Color | assertNotBackgroundColor | parentLocator | locator | text
119 | Assert Not Body Text | assertNotBodyText | text |  | 
120 | Assert Not Border Color | assertNotBorderColor | locator | text | 
121 | Assert Not Border Color | assertNotBorderColor | parentLocator | locator | text
122 | Assert Not Checked | assertNotChecked | locator |  | 
123 | Assert Not Checked | assertNotChecked | parentLocator | locator | 
124 | Assert Not Color | assertNotColor | locator | text | 
125 | Assert Not Color | assertNotColor | parentLocator | locator | text
126 | Assert Not Confirmation | assertNotConfirmation | text |  | 
127 | Assert Not Cookie | assertNotCookie | text |  | 
128 | Assert Not Cookie By Name | assertNotCookieByName | name | text | 
129 | Assert Not Css Count | assertNotCssCount | css | text | 
130 | Assert Not Cursor Position | assertNotCursorPosition | locator | text | 
131 | Assert Not Cursor Position | assertNotCursorPosition | parentLocator | locator | text
132 | Assert Not Editable | assertNotEditable | locator |  | 
133 | Assert Not Editable | assertNotEditable | parentLocator | locator | 
134 | Assert Not Element Height | assertNotElementHeight | locator | text | 
135 | Assert Not Element Height | assertNotElementHeight | parentLocator | locator | text
136 | Assert Not Element Index | assertNotElementIndex | locator | text | 
137 | Assert Not Element Index | assertNotElementIndex | parentLocator | locator | text
138 | Assert Not Element Position Left | assertNotElementPositionLeft | locator | text | 
139 | Assert Not Element Position Left | assertNotElementPositionLeft | parentLocator | locator | text
140 | Assert Not Element Position Top | assertNotElementPositionTop | locator | text | 
141 | Assert Not Element Position Top | assertNotElementPositionTop | parentLocator | locator | text
142 | Assert Not Element Width | assertNotElementWidth | locator | text | 
143 | Assert Not Element Width | assertNotElementWidth | parentLocator | locator | text
144 | Assert Not Eval | assertNotEval | expression | text | 
145 | Assert Not Eval Script | assertNotEvalScript | script | text | 
146 | Assert Not Exists In Database | assertNotExistsInDatabase | sql |  | 
147 | Assert Not Expression | assertNotExpression | expression | text | 
148 | Assert Not Font Family | assertNotFontFamily | locator | text | 
149 | Assert Not Font Family | assertNotFontFamily | parentLocator | locator | text
150 | Assert Not Font Size | assertNotFontSize | locator | text | 
151 | Assert Not Font Size | assertNotFontSize | parentLocator | locator | text
152 | Assert Not Font Style | assertNotFontStyle | locator | text | 
153 | Assert Not Font Style | assertNotFontStyle | parentLocator | locator | text
154 | Assert Not Font Weight | assertNotFontWeight | locator | text | 
155 | Assert Not Font Weight | assertNotFontWeight | parentLocator | locator | text
156 | Assert Not Html Source | assertNotHtmlSource | text |  | 
157 | Assert Not Location | assertNotLocation | text |  | 
158 | Assert Not Ordered | assertNotOrdered | firstLocator | secondLocator | 
159 | Assert Not Prompt | assertNotPrompt | text |  | 
160 | Assert Not Selected Id | assertNotSelectedId | locator | text | 
161 | Assert Not Selected Id | assertNotSelectedId | parentLocator | locator | text
162 | Assert Not Selected Index | assertNotSelectedIndex | locator | text | 
163 | Assert Not Selected Index | assertNotSelectedIndex | parentLocator | locator | text
164 | Assert Not Selected Label | assertNotSelectedLabel | locator | text | 
165 | Assert Not Selected Label | assertNotSelectedLabel | parentLocator | locator | text
166 | Assert Not Selected Value | assertNotSelectedValue | locator | text | 
167 | Assert Not Selected Value | assertNotSelectedValue | parentLocator | locator | text
168 | Assert Not Something Selected | assertNotSomethingSelected | locator |  | 
169 | Assert Not Something Selected | assertNotSomethingSelected | parentLocator | locator | 
170 | Assert Not Table | assertNotTable | locator | cellAddress | text
171 | Assert Not Text | assertNotText | locator | text | 
172 | Assert Not Text | assertNotText | parentLocator | locator | text
173 | Assert Not Text Alignment | assertNotTextAlignment | locator | text | 
174 | Assert Not Text Alignment | assertNotTextAlignment | parentLocator | locator | text
175 | Assert Not Text Decoration | assertNotTextDecoration | locator | text | 
176 | Assert Not Text Decoration | assertNotTextDecoration | parentLocator | locator | text
177 | Assert Not Text Empty | assertNotTextEmpty | locator |  | 
178 | Assert Not Text Empty | assertNotTextEmpty | parentLocator | locator | 
179 | Assert Not Title | assertNotTitle | text |  | 
180 | Assert Not Value | assertNotValue | locator | text | 
181 | Assert Not Value | assertNotValue | parentLocator | locator | text
182 | Assert Not Value Empty | assertNotValueEmpty | locator |  | 
183 | Assert Not Value Empty | assertNotValueEmpty | parentLocator | locator | 
184 | Assert Not Variable | assertNotVariable | variable | text | 
185 | Assert Not Visible | assertNotVisible | locator |  | 
186 | Assert Not Visible | assertNotVisible | parentLocator | locator | 
187 | Assert Not Xpath Count | assertNotXpathCount | xpath | text | 
188 | Assert Ordered | assertOrdered | firstLocator | secondLocator | 
189 | Assert Prompt | assertPrompt | text |  | 
190 | Assert Prompt Contain | assertPromptContain | text |  | 
191 | Assert Prompt Not Contain | assertPromptNotContain | text |  | 
192 | Assert Prompt Not Present | assertPromptNotPresent |  |  | 
193 | Assert Prompt Present | assertPromptPresent |  |  | 
194 | Assert Row Count | assertRowCount | sql | count | 
195 | Assert Row Count Greater Than | assertRowCountGreaterThan | sql | count | 
196 | Assert Row Count Less Than | assertRowCountLessThan | sql | count | 
197 | Assert Selected Id | assertSelectedId | locator | text | 
198 | Assert Selected Id | assertSelectedId | parentLocator | locator | text
199 | Assert Selected Id Contain | assertSelectedIdContain | locator | text | 
200 | Assert Selected Id Contain | assertSelectedIdContain | parentLocator | locator | text
201 | Assert Selected Id Not Contain | assertSelectedIdNotContain | locator | text | 
202 | Assert Selected Id Not Contain | assertSelectedIdNotContain | parentLocator | locator | text
203 | Assert Selected Index | assertSelectedIndex | locator | text | 
204 | Assert Selected Index | assertSelectedIndex | parentLocator | locator | text
205 | Assert Selected Index Contain | assertSelectedIndexContain | locator | text | 
206 | Assert Selected Index Contain | assertSelectedIndexContain | parentLocator | locator | text
207 | Assert Selected Index Not Contain | assertSelectedIndexNotContain | locator | text | 
208 | Assert Selected Index Not Contain | assertSelectedIndexNotContain | parentLocator | locator | text
209 | Assert Selected Label | assertSelectedLabel | locator | text | 
210 | Assert Selected Label | assertSelectedLabel | parentLocator | locator | text
211 | Assert Selected Label Contain | assertSelectedLabelContain | locator | text | 
212 | Assert Selected Label Contain | assertSelectedLabelContain | parentLocator | locator | text
213 | Assert Selected Label Not Contain | assertSelectedLabelNotContain | locator | text | 
214 | Assert Selected Label Not Contain | assertSelectedLabelNotContain | parentLocator | locator | text
215 | Assert Selected Value | assertSelectedValue | locator | text | 
216 | Assert Selected Value | assertSelectedValue | parentLocator | locator | text
217 | Assert Selected Value Contain | assertSelectedValueContain | locator | text | 
218 | Assert Selected Value Contain | assertSelectedValueContain | parentLocator | locator | text
219 | Assert Selected Value Not Contain | assertSelectedValueNotContain | locator | text | 
220 | Assert Selected Value Not Contain | assertSelectedValueNotContain | parentLocator | locator | text
221 | Assert Something Selected | assertSomethingSelected | locator |  | 
222 | Assert Something Selected | assertSomethingSelected | parentLocator | locator | 
223 | Assert Table | assertTable | locator | cellAddress | text
224 | Assert Table Contain | assertTableContain | locator | cellAddress | text
225 | Assert Table Not Contain | assertTableNotContain | locator | cellAddress | text
226 | Assert Text | assertText | locator | text | 
227 | Assert Text | assertText | parentLocator | locator | text
228 | Assert Text Alignment | assertTextAlignment | locator | text | 
229 | Assert Text Alignment | assertTextAlignment | parentLocator | locator | text
230 | Assert Text Alignment Contain | assertTextAlignmentContain | locator | text | 
231 | Assert Text Alignment Contain | assertTextAlignmentContain | parentLocator | locator | text
232 | Assert Text Alignment Not Contain | assertTextAlignmentNotContain | locator | text | 
233 | Assert Text Alignment Not Contain | assertTextAlignmentNotContain | parentLocator | locator | text
234 | Assert Text Contain | assertTextContain | locator | text | 
235 | Assert Text Contain | assertTextContain | parentLocator | locator | text
236 | Assert Text Decoration | assertTextDecoration | locator | text | 
237 | Assert Text Decoration | assertTextDecoration | parentLocator | locator | text
238 | Assert Text Decoration Contain | assertTextDecorationContain | locator | text | 
239 | Assert Text Decoration Contain | assertTextDecorationContain | parentLocator | locator | text
240 | Assert Text Decoration Not Contain | assertTextDecorationNotContain | locator | text | 
241 | Assert Text Decoration Not Contain | assertTextDecorationNotContain | parentLocator | locator | text
242 | Assert Text Empty | assertTextEmpty | locator |  | 
243 | Assert Text Empty | assertTextEmpty | parentLocator | locator | 
244 | Assert Text List Order Asc | assertTextListOrderAsc | locator |  | 
245 | Assert Text List Order Asc | assertTextListOrderAsc | parentLocator | locator | 
246 | Assert Text List Order Desc | assertTextListOrderDesc | locator |  | 
247 | Assert Text List Order Desc | assertTextListOrderDesc | parentLocator | locator | 
248 | Assert Text Not Contain | assertTextNotContain | locator | text | 
249 | Assert Text Not Contain | assertTextNotContain | parentLocator | locator | text
250 | Assert Text Not Present | assertTextNotPresent | pattern |  | 
251 | Assert Text Present | assertTextPresent | pattern |  | 
252 | Assert Title | assertTitle | text |  | 
253 | Assert Title Contain | assertTitleContain | text |  | 
254 | Assert Title Not Contain | assertTitleNotContain | text |  | 
255 | Assert Value | assertValue | locator | text | 
256 | Assert Value | assertValue | parentLocator | locator | text
257 | Assert Value Contain | assertValueContain | locator | text | 
258 | Assert Value Contain | assertValueContain | parentLocator | locator | text
259 | Assert Value Empty | assertValueEmpty | locator |  | 
260 | Assert Value Empty | assertValueEmpty | parentLocator | locator | 
261 | Assert Value Not Contain | assertValueNotContain | locator | text | 
262 | Assert Value Not Contain | assertValueNotContain | parentLocator | locator | text
263 | Assert Variable | assertVariable | variable | text | 
264 | Assert Variable Contain | assertVariableContain | variable | text | 
265 | Assert Variable Not Contain | assertVariableNotContain | variable | text | 
266 | Assert Visible | assertVisible | locator |  | 
267 | Assert Visible | assertVisible | parentLocator | locator | 
268 | Assert Xpath Count | assertXpathCount | xpath | text | 
269 | Assign Id | assignId | locator | identifier | 
270 | Assign Id | assignId | parentLocator | locator | identifier
271 | Blur | blur | locator |  | 
272 | Blur | blur | parentLocator | locator | 
273 | Check | check | locator |  | 
274 | Check | check | parentLocator | locator | 
275 | Choose Cancel Confirmation | chooseCancelConfirmation |  |  | 
276 | Choose Cancel Prompt | chooseCancelPrompt |  |  | 
277 | Choose Ok Alert | chooseOkAlert |  |  | 
278 | Choose Ok Confirmation | chooseOkConfirmation |  |  | 
279 | Clear | clear | locator |  | 
280 | Clear | clear | parentLocator | locator | 
281 | Click | click | locator |  | 
282 | Click | click | parentLocator | locator | 
283 | Click At | clickAt | locator | coordString | 
284 | Click At | clickAt | parentLocator | locator | coordString
285 | Close | close |  |  | 
286 | Context Menu | contextMenu | locator |  | 
287 | Context Menu | contextMenu | parentLocator | locator | 
288 | Context Menu At | contextMenuAt | locator | coordString | 
289 | Context Menu At | contextMenuAt | parentLocator | locator | coordString
290 | Control Key Down | controlKeyDown |  |  | 
291 | Control Key Up | controlKeyUp |  |  | 
292 | Create Cookie | createCookie | nameValuePair | optionsString | 
293 | Delete All Visible Cookies | deleteAllVisibleCookies |  |  | 
294 | Delete Cookie | deleteCookie | name |  | 
295 | Deselect Pop Up | deselectPopUp |  |  | 
296 | Double Click | doubleClick | locator |  | 
297 | Double Click | doubleClick | parentLocator | locator | 
298 | Double Click At | doubleClickAt | locator | coordString | 
299 | Double Click At | doubleClickAt | parentLocator | locator | coordString
300 | Drag And Drop | dragAndDrop | locator | movementsString | 
301 | Drag And Drop | dragAndDrop | parentLocator | locator | movementsString
302 | Drag And Drop To Object | dragAndDropToObject | toBeDraggedObjectLocator | dragDestinationObjectLocator | 
303 | Echo | echo | message |  | 
304 | Execute | execute | action |  | 
305 | Execute Each | executeEach | action | locator | variable
306 | Execute If Alert | executeIfAlert | action | text | 
307 | Execute If Alert Contain | executeIfAlertContain | action | text | 
308 | Execute If Alert Not Contain | executeIfAlertNotContain | action | text | 
309 | Execute If Alert Not Present | executeIfAlertNotPresent | action |  | 
310 | Execute If Alert Present | executeIfAlertPresent | action |  | 
311 | Execute If Body Text | executeIfBodyText | action | text | 
312 | Execute If Body Text Contain | executeIfBodyTextContain | action | text | 
313 | Execute If Body Text Not Contain | executeIfBodyTextNotContain | action | text | 
314 | Execute If Checked | executeIfChecked | action | locator | 
315 | Execute If Checked | executeIfChecked | action | parentLocator | locator
316 | Execute If Confirmation | executeIfConfirmation | action | text | 
317 | Execute If Confirmation Contain | executeIfConfirmationContain | action | text | 
318 | Execute If Confirmation Not Contain | executeIfConfirmationNotContain | action | text | 
319 | Execute If Confirmation Not Present | executeIfConfirmationNotPresent | action |  | 
320 | Execute If Confirmation Present | executeIfConfirmationPresent | action |  | 
321 | Execute If Cookie | executeIfCookie | action | text | 
322 | Execute If Cookie By Name | executeIfCookieByName | action | name | text
323 | Execute If Cookie By Name Contain | executeIfCookieByNameContain | action | name | text
324 | Execute If Cookie By Name Not Contain | executeIfCookieByNameNotContain | action | name | text
325 | Execute If Cookie Contain | executeIfCookieContain | action | text | 
326 | Execute If Cookie Not Contain | executeIfCookieNotContain | action | text | 
327 | Execute If Cookie Not Present | executeIfCookieNotPresent | action | name | 
328 | Execute If Cookie Present | executeIfCookiePresent | action | name | 
329 | Execute If Editable | executeIfEditable | action | locator | 
330 | Execute If Editable | executeIfEditable | action | parentLocator | locator
331 | Execute If Element Not Present | executeIfElementNotPresent | action | locator | 
332 | Execute If Element Not Present | executeIfElementNotPresent | action | parentLocator | locator
333 | Execute If Element Present | executeIfElementPresent | action | locator | 
334 | Execute If Element Present | executeIfElementPresent | action | parentLocator | locator
335 | Execute If Eval | executeIfEval | action | expression | text
336 | Execute If Eval Script | executeIfEvalScript | action | script | text
337 | Execute If Eval Script Contain | executeIfEvalScriptContain | action | script | text
338 | Execute If Eval Script Not Contain | executeIfEvalScriptNotContain | action | script | text
339 | Execute If Exists In Database | executeIfExistsInDatabase | action | sql | 
340 | Execute If Expression | executeIfExpression | action | expression | text
341 | Execute If Expression Contain | executeIfExpressionContain | action | expression | text
342 | Execute If Expression Not Contain | executeIfExpressionNotContain | action | expression | text
343 | Execute If Html Source | executeIfHtmlSource | action | text | 
344 | Execute If Html Source Contain | executeIfHtmlSourceContain | action | text | 
345 | Execute If Html Source Not Contain | executeIfHtmlSourceNotContain | action | text | 
346 | Execute If List Contain | executeIfListContain | action | variable | text
347 | Execute If List Not Contain | executeIfListNotContain | action | variable | text
348 | Execute If Location | executeIfLocation | action | text | 
349 | Execute If Location Contain | executeIfLocationContain | action | text | 
350 | Execute If Location Not Contain | executeIfLocationNotContain | action | text | 
351 | Execute If Not Alert | executeIfNotAlert | action | text | 
352 | Execute If Not Body Text | executeIfNotBodyText | action | text | 
353 | Execute If Not Checked | executeIfNotChecked | action | locator | 
354 | Execute If Not Checked | executeIfNotChecked | action | parentLocator | locator
355 | Execute If Not Confirmation | executeIfNotConfirmation | action | text | 
356 | Execute If Not Cookie | executeIfNotCookie | action | text | 
357 | Execute If Not Cookie By Name | executeIfNotCookieByName | action | name | text
358 | Execute If Not Editable | executeIfNotEditable | action | locator | 
359 | Execute If Not Editable | executeIfNotEditable | action | parentLocator | locator
360 | Execute If Not Eval | executeIfNotEval | action | expression | text
361 | Execute If Not Eval Script | executeIfNotEvalScript | action | script | text
362 | Execute If Not Exists In Database | executeIfNotExistsInDatabase | action | sql | 
363 | Execute If Not Expression | executeIfNotExpression | action | expression | text
364 | Execute If Not Html Source | executeIfNotHtmlSource | action | text | 
365 | Execute If Not Location | executeIfNotLocation | action | text | 
366 | Execute If Not Prompt | executeIfNotPrompt | action | text | 
367 | Execute If Not Selected Id | executeIfNotSelectedId | action | locator | text
368 | Execute If Not Selected Index | executeIfNotSelectedIndex | action | locator | text
369 | Execute If Not Selected Label | executeIfNotSelectedLabel | action | locator | text
370 | Execute If Not Selected Value | executeIfNotSelectedValue | action | locator | text
371 | Execute If Not Something Selected | executeIfNotSomethingSelected | action | locator | 
372 | Execute If Not Something Selected | executeIfNotSomethingSelected | action | parentLocator | locator
373 | Execute If Not Text | executeIfNotText | action | locator | text
374 | Execute If Not Text Empty | executeIfNotTextEmpty | action | locator | 
375 | Execute If Not Text Empty | executeIfNotTextEmpty | action | parentLocator | locator
376 | Execute If Not Title | executeIfNotTitle | action | text | 
377 | Execute If Not Value | executeIfNotValue | action | locator | text
378 | Execute If Not Value Empty | executeIfNotValueEmpty | action | locator | 
379 | Execute If Not Value Empty | executeIfNotValueEmpty | action | parentLocator | locator
380 | Execute If Not Variable | executeIfNotVariable | action | variable | text
381 | Execute If Not Visible | executeIfNotVisible | action | locator | 
382 | Execute If Not Visible | executeIfNotVisible | action | parentLocator | locator
383 | Execute If Prompt | executeIfPrompt | action | text | 
384 | Execute If Prompt Contain | executeIfPromptContain | action | text | 
385 | Execute If Prompt Not Contain | executeIfPromptNotContain | action | text | 
386 | Execute If Prompt Not Present | executeIfPromptNotPresent | action |  | 
387 | Execute If Prompt Present | executeIfPromptPresent | action |  | 
388 | Execute If Selected Id | executeIfSelectedId | action | locator | text
389 | Execute If Selected Id Contain | executeIfSelectedIdContain | action | locator | text
390 | Execute If Selected Id Not Contain | executeIfSelectedIdNotContain | action | locator | text
391 | Execute If Selected Index | executeIfSelectedIndex | action | locator | text
392 | Execute If Selected Index Contain | executeIfSelectedIndexContain | action | locator | text
393 | Execute If Selected Index Not Contain | executeIfSelectedIndexNotContain | action | locator | text
394 | Execute If Selected Label | executeIfSelectedLabel | action | locator | text
395 | Execute If Selected Label Contain | executeIfSelectedLabelContain | action | locator | text
396 | Execute If Selected Label Not Contain | executeIfSelectedLabelNotContain | action | locator | text
397 | Execute If Selected Value | executeIfSelectedValue | action | locator | text
398 | Execute If Selected Value Contain | executeIfSelectedValueContain | action | locator | text
399 | Execute If Selected Value Not Contain | executeIfSelectedValueNotContain | action | locator | text
400 | Execute If Something Selected | executeIfSomethingSelected | action | locator | 
401 | Execute If Something Selected | executeIfSomethingSelected | action | parentLocator | locator
402 | Execute If Text | executeIfText | action | locator | text
403 | Execute If Text Contain | executeIfTextContain | action | locator | text
404 | Execute If Text Empty | executeIfTextEmpty | action | locator | 
405 | Execute If Text Empty | executeIfTextEmpty | action | parentLocator | locator
406 | Execute If Text Not Contain | executeIfTextNotContain | action | locator | text
407 | Execute If Text Not Present | executeIfTextNotPresent | action | pattern | 
408 | Execute If Text Present | executeIfTextPresent | action | pattern | 
409 | Execute If Title | executeIfTitle | action | text | 
410 | Execute If Title Contain | executeIfTitleContain | action | text | 
411 | Execute If Title Not Contain | executeIfTitleNotContain | action | text | 
412 | Execute If Value | executeIfValue | action | locator | text
413 | Execute If Value Contain | executeIfValueContain | action | locator | text
414 | Execute If Value Empty | executeIfValueEmpty | action | locator | 
415 | Execute If Value Empty | executeIfValueEmpty | action | parentLocator | locator
416 | Execute If Value Not Contain | executeIfValueNotContain | action | locator | text
417 | Execute If Variable | executeIfVariable | action | variable | text
418 | Execute If Variable Contain | executeIfVariableContain | action | variable | text
419 | Execute If Variable Not Contain | executeIfVariableNotContain | action | variable | text
420 | Execute If Visible | executeIfVisible | action | locator | 
421 | Execute If Visible | executeIfVisible | action | parentLocator | locator
422 | Execute Loop | executeLoop | action | times | 
423 | Fire Event | fireEvent | locator | eventName | 
424 | Fire Event | fireEvent | parentLocator | locator | eventName
425 | Focus | focus | locator |  | 
426 | Focus | focus | parentLocator | locator | 
427 | Go Back | goBack |  |  | 
428 | Go Forward | goForward |  |  | 
429 | Highlight | highlight | locator |  | 
430 | Highlight | highlight | parentLocator | locator | 
431 | Key Down | keyDown | keycode |  | 
432 | Key Down | keyDown | locator | keySequence | 
433 | Key Down | keyDown | parentLocator | locator | keySequence
434 | Key Press | keyPress | locator | keySequence | 
435 | Key Press | keyPress | parentLocator | locator | keySequence
436 | Key Press | keyPress | keycode |  | 
437 | Key Up | keyUp | locator | keySequence | 
438 | Key Up | keyUp | parentLocator | locator | keySequence
439 | Key Up | keyUp | keycode |  | 
440 | Meta Key Down | metaKeyDown |  |  | 
441 | Meta Key Up | metaKeyUp |  |  | 
442 | Mouse Down | mouseDown | locator |  | 
443 | Mouse Down | mouseDown | parentLocator | locator | 
444 | Mouse Down At | mouseDownAt | locator | coordString | 
445 | Mouse Down At | mouseDownAt | parentLocator | locator | coordString
446 | Mouse Move | mouseMove | locator |  | 
447 | Mouse Move | mouseMove | parentLocator | locator | 
448 | Mouse Move At | mouseMoveAt | locator | coordString | 
449 | Mouse Move At | mouseMoveAt | parentLocator | locator | coordString
450 | Mouse Out | mouseOut | locator |  | 
451 | Mouse Out | mouseOut | parentLocator | locator | 
452 | Mouse Over | mouseOver | locator |  | 
453 | Mouse Over | mouseOver | parentLocator | locator | 
454 | Mouse Up | mouseUp | locator |  | 
455 | Mouse Up | mouseUp | parentLocator | locator | 
456 | Mouse Up At | mouseUpAt | locator | coordString | 
457 | Mouse Up At | mouseUpAt | parentLocator | locator | coordString
458 | Open | open | url |  | 
459 | Open Window | openWindow | url | windowID | 
460 | Open Window | openWindow | url |  | 
461 | Pause | pause | waitTime |  | 
462 | Refresh | refresh |  |  | 
463 | Remove All Selections | removeAllSelections | locator |  | 
464 | Remove All Selections | removeAllSelections | parentLocator | locator | 
465 | Remove Selection | removeSelection | locator | optionLocator | 
466 | Remove Selection | removeSelection | parentLocator | locator | optionLocator
467 | Remove Selection Id | removeSelectionId | locator | id | 
468 | Remove Selection Id | removeSelectionId | parentLocator | locator | id
469 | Remove Selection Index | removeSelectionIndex | locator | index | 
470 | Remove Selection Index | removeSelectionIndex | parentLocator | locator | index
471 | Remove Selection Label | removeSelectionLabel | locator | label | 
472 | Remove Selection Label | removeSelectionLabel | parentLocator | locator | label
473 | Remove Selection Value | removeSelectionValue | locator | value | 
474 | Remove Selection Value | removeSelectionValue | parentLocator | locator | value
475 | Run Script | runScript | script |  | 
476 | Select | select | locator | optionLocator | 
477 | Select | select | parentLocator | locator | optionLocator
478 | Select First Window | selectFirstWindow |  |  | 
479 | Select Frame | selectFrame | locator |  | 
480 | Select Id | selectId | locator | id | 
481 | Select Id | selectId | parentLocator | locator | id
482 | Select Index | selectIndex | locator | index | 
483 | Select Index | selectIndex | parentLocator | locator | index
484 | Select Label | selectLabel | locator | label | 
485 | Select Label | selectLabel | parentLocator | locator | label
486 | Select Last Window | selectLastWindow |  |  | 
487 | Select Parent Frame | selectParentFrame |  |  | 
488 | Select Pop Up | selectPopUp | windowID |  | 
489 | Select Value | selectValue | locator | value | 
490 | Select Value | selectValue | parentLocator | locator | value
491 | Select Window | selectWindow | windowID |  | 
492 | Set Cursor Position | setCursorPosition | locator | position | 
493 | Set Cursor Position | setCursorPosition | parentLocator | locator | position
494 | Set Timeout | setTimeout | timeout |  | 
495 | Shift Key Down | shiftKeyDown |  |  | 
496 | Shift Key Up | shiftKeyUp |  |  | 
497 | Store | store | text | variable | 
498 | Store Alert | storeAlert | variable |  | 
499 | Store All Buttons | storeAllButtons | variable |  | 
500 | Store All Fields | storeAllFields | variable |  | 
501 | Store All Links | storeAllLinks | variable |  | 
502 | Store All Window Names | storeAllWindowNames | variable |  | 
503 | Store All Window Titles | storeAllWindowTitles | variable |  | 
504 | Store Attribute | storeAttribute | locator | name | variable
505 | Store Attribute From All Windows | storeAttributeFromAllWindows | attributeName | variable | 
506 | Store Body Text | storeBodyText | variable |  | 
507 | Store Confirmation | storeConfirmation | variable |  | 
508 | Store Cookie | storeCookie | variable |  | 
509 | Store Cookie By Name | storeCookieByName | name | variable | 
510 | Store Current Date | storeCurrentDate | variable |  | 
511 | Store Eval | storeEval | expression | variable | 
512 | Store Eval Script | storeEvalScript | script | variable | 
513 | Store Expression | storeExpression | expression | variable | 
514 | Store Html Source | storeHtmlSource | variable |  | 
515 | Store Location | storeLocation | variable |  | 
516 | Store Prompt | storePrompt | variable |  | 
517 | Store Push | storePush | text | variable | 
518 | Store Select Options | storeSelectOptions | locator | variable | 
519 | Store Select Options | storeSelectOptions | parentLocator | locator | variable
520 | Store Selected Id | storeSelectedId | locator | variable | 
521 | Store Selected Id | storeSelectedId | parentLocator | locator | variable
522 | Store Selected Ids | storeSelectedIds | locator | variable | 
523 | Store Selected Ids | storeSelectedIds | parentLocator | locator | variable
524 | Store Selected Index | storeSelectedIndex | locator | variable | 
525 | Store Selected Index | storeSelectedIndex | parentLocator | locator | variable
526 | Store Selected Indexes | storeSelectedIndexes | locator | variable | 
527 | Store Selected Indexes | storeSelectedIndexes | parentLocator | locator | variable
528 | Store Selected Label | storeSelectedLabel | locator | variable | 
529 | Store Selected Label | storeSelectedLabel | parentLocator | locator | variable
530 | Store Selected Labels | storeSelectedLabels | locator | variable | 
531 | Store Selected Labels | storeSelectedLabels | parentLocator | locator | variable
532 | Store Selected Value | storeSelectedValue | locator | variable | 
533 | Store Selected Value | storeSelectedValue | parentLocator | locator | variable
534 | Store Selected Values | storeSelectedValues | locator | variable | 
535 | Store Selected Values | storeSelectedValues | parentLocator | locator | variable
536 | Store Table | storeTable | locator | cellAddress | variable
537 | Store Text | storeText | locator | variable | 
538 | Store Text | storeText | parentLocator | locator | variable
539 | Store Title | storeTitle | variable |  | 
540 | Store Value | storeValue | locator | variable | 
541 | Store Value | storeValue | parentLocator | locator | variable
542 | Submit | submit | locator |  | 
543 | Submit | submit | parentLocator | locator | 
544 | Type | type | locator | value | 
545 | Type | type | parentLocator | locator | value
546 | Type And Tab | typeAndTab | locator | value | 
547 | Type And Tab | typeAndTab | parentLocator | locator | value
548 | Type Keys | typeKeys | locator | value | 
549 | Type Keys | typeKeys | parentLocator | locator | value
550 | Uncheck | uncheck | locator |  | 
551 | Uncheck | uncheck | parentLocator | locator | 
552 | Verify Alert | verifyAlert | text |  | 
553 | Verify Alert Contain | verifyAlertContain | text |  | 
554 | Verify Alert Not Contain | verifyAlertNotContain | text |  | 
555 | Verify Alert Not Present | verifyAlertNotPresent |  |  | 
556 | Verify Alert Present | verifyAlertPresent |  |  | 
557 | Verify Attribute | verifyAttribute | locator | name | text
558 | Verify Attribute Contain | verifyAttributeContain | locator | name | text
559 | Verify Attribute Not Contain | verifyAttributeNotContain | locator | name | text
560 | Verify Background Color | verifyBackgroundColor | locator | text | 
561 | Verify Background Color | verifyBackgroundColor | parentLocator | locator | text
562 | Verify Body Text | verifyBodyText | text |  | 
563 | Verify Body Text Contain | verifyBodyTextContain | text |  | 
564 | Verify Body Text Not Contain | verifyBodyTextNotContain | text |  | 
565 | Verify Border Color | verifyBorderColor | locator | text | 
566 | Verify Border Color | verifyBorderColor | parentLocator | locator | text
567 | Verify Checked | verifyChecked | locator |  | 
568 | Verify Checked | verifyChecked | parentLocator | locator | 
569 | Verify Color | verifyColor | locator | text | 
570 | Verify Color | verifyColor | parentLocator | locator | text
571 | Verify Confirmation | verifyConfirmation | text |  | 
572 | Verify Confirmation Contain | verifyConfirmationContain | text |  | 
573 | Verify Confirmation Not Contain | verifyConfirmationNotContain | text |  | 
574 | Verify Confirmation Not Present | verifyConfirmationNotPresent |  |  | 
575 | Verify Confirmation Present | verifyConfirmationPresent |  |  | 
576 | Verify Cookie | verifyCookie | text |  | 
577 | Verify Cookie By Name | verifyCookieByName | name | text | 
578 | Verify Cookie By Name Contain | verifyCookieByNameContain | name | text | 
579 | Verify Cookie By Name Not Contain | verifyCookieByNameNotContain | name | text | 
580 | Verify Cookie Contain | verifyCookieContain | text |  | 
581 | Verify Cookie Not Contain | verifyCookieNotContain | text |  | 
582 | Verify Cookie Not Present | verifyCookieNotPresent | name |  | 
583 | Verify Cookie Present | verifyCookiePresent | name |  | 
584 | Verify Css Count | verifyCssCount | css | text | 
585 | Verify Cursor Position | verifyCursorPosition | locator | text | 
586 | Verify Cursor Position | verifyCursorPosition | parentLocator | locator | text
587 | Verify Date List Order Asc | verifyDateListOrderAsc | locator | format | 
588 | Verify Date List Order Asc | verifyDateListOrderAsc | parentLocator | locator | format
589 | Verify Date List Order Desc | verifyDateListOrderDesc | locator | format | 
590 | Verify Date List Order Desc | verifyDateListOrderDesc | parentLocator | locator | format
591 | Verify Editable | verifyEditable | locator |  | 
592 | Verify Editable | verifyEditable | parentLocator | locator | 
593 | Verify Element Height | verifyElementHeight | locator | text | 
594 | Verify Element Height | verifyElementHeight | parentLocator | locator | text
595 | Verify Element Index | verifyElementIndex | locator | text | 
596 | Verify Element Index | verifyElementIndex | parentLocator | locator | text
597 | Verify Element Not Present | verifyElementNotPresent | locator |  | 
598 | Verify Element Not Present | verifyElementNotPresent | parentLocator | locator | 
599 | Verify Element Position Left | verifyElementPositionLeft | locator | text | 
600 | Verify Element Position Left | verifyElementPositionLeft | parentLocator | locator | text
601 | Verify Element Position Top | verifyElementPositionTop | locator | text | 
602 | Verify Element Position Top | verifyElementPositionTop | parentLocator | locator | text
603 | Verify Element Present | verifyElementPresent | locator |  | 
604 | Verify Element Present | verifyElementPresent | parentLocator | locator | 
605 | Verify Element Width | verifyElementWidth | locator | text | 
606 | Verify Element Width | verifyElementWidth | parentLocator | locator | text
607 | Verify Eval | verifyEval | expression | text | 
608 | Verify Eval Script | verifyEvalScript | script | text | 
609 | Verify Eval Script Contain | verifyEvalScriptContain | script | text | 
610 | Verify Eval Script Not Contain | verifyEvalScriptNotContain | script | text | 
611 | Verify Exists In Database | verifyExistsInDatabase | sql |  | 
612 | Verify Expression | verifyExpression | expression | text | 
613 | Verify Expression Contain | verifyExpressionContain | expression | text | 
614 | Verify Expression Not Contain | verifyExpressionNotContain | expression | text | 
615 | Verify Font Family | verifyFontFamily | locator | text | 
616 | Verify Font Family | verifyFontFamily | parentLocator | locator | text
617 | Verify Font Family Contain | verifyFontFamilyContain | locator | text | 
618 | Verify Font Family Contain | verifyFontFamilyContain | parentLocator | locator | text
619 | Verify Font Family Not Contain | verifyFontFamilyNotContain | locator | text | 
620 | Verify Font Family Not Contain | verifyFontFamilyNotContain | parentLocator | locator | text
621 | Verify Font Size | verifyFontSize | locator | text | 
622 | Verify Font Size | verifyFontSize | parentLocator | locator | text
623 | Verify Font Size Contain | verifyFontSizeContain | locator | text | 
624 | Verify Font Size Contain | verifyFontSizeContain | parentLocator | locator | text
625 | Verify Font Size Not Contain | verifyFontSizeNotContain | locator | text | 
626 | Verify Font Size Not Contain | verifyFontSizeNotContain | parentLocator | locator | text
627 | Verify Font Style | verifyFontStyle | locator | text | 
628 | Verify Font Style | verifyFontStyle | parentLocator | locator | text
629 | Verify Font Style Contain | verifyFontStyleContain | locator | text | 
630 | Verify Font Style Contain | verifyFontStyleContain | parentLocator | locator | text
631 | Verify Font Style Not Contain | verifyFontStyleNotContain | locator | text | 
632 | Verify Font Style Not Contain | verifyFontStyleNotContain | parentLocator | locator | text
633 | Verify Font Weight | verifyFontWeight | locator | text | 
634 | Verify Font Weight | verifyFontWeight | parentLocator | locator | text
635 | Verify Font Weight Contain | verifyFontWeightContain | locator | text | 
636 | Verify Font Weight Contain | verifyFontWeightContain | parentLocator | locator | text
637 | Verify Font Weight Not Contain | verifyFontWeightNotContain | locator | text | 
638 | Verify Font Weight Not Contain | verifyFontWeightNotContain | parentLocator | locator | text
639 | Verify Html Source | verifyHtmlSource | text |  | 
640 | Verify Html Source Contain | verifyHtmlSourceContain | text |  | 
641 | Verify Html Source Not Contain | verifyHtmlSourceNotContain | text |  | 
642 | Verify Integer List Order Asc | verifyIntegerListOrderAsc | locator |  | 
643 | Verify Integer List Order Asc | verifyIntegerListOrderAsc | parentLocator | locator | 
644 | Verify Integer List Order Desc | verifyIntegerListOrderDesc | locator |  | 
645 | Verify Integer List Order Desc | verifyIntegerListOrderDesc | parentLocator | locator | 
646 | Verify List Contain | verifyListContain | variable | text | 
647 | Verify List Not Contain | verifyListNotContain | variable | text | 
648 | Verify List Order Asc | verifyListOrderAsc | variable |  | 
649 | Verify List Order Desc | verifyListOrderDesc | variable |  | 
650 | Verify Location | verifyLocation | text |  | 
651 | Verify Location Contain | verifyLocationContain | text |  | 
652 | Verify Location Not Contain | verifyLocationNotContain | text |  | 
653 | Verify Not Alert | verifyNotAlert | text |  | 
654 | Verify Not Attribute | verifyNotAttribute | locator | name | text
655 | Verify Not Background Color | verifyNotBackgroundColor | locator | text | 
656 | Verify Not Background Color | verifyNotBackgroundColor | parentLocator | locator | text
657 | Verify Not Body Text | verifyNotBodyText | text |  | 
658 | Verify Not Border Color | verifyNotBorderColor | locator | text | 
659 | Verify Not Border Color | verifyNotBorderColor | parentLocator | locator | text
660 | Verify Not Checked | verifyNotChecked | locator |  | 
661 | Verify Not Checked | verifyNotChecked | parentLocator | locator | 
662 | Verify Not Color | verifyNotColor | locator | text | 
663 | Verify Not Color | verifyNotColor | parentLocator | locator | text
664 | Verify Not Confirmation | verifyNotConfirmation | text |  | 
665 | Verify Not Cookie | verifyNotCookie | text |  | 
666 | Verify Not Cookie By Name | verifyNotCookieByName | name | text | 
667 | Verify Not Css Count | verifyNotCssCount | css | text | 
668 | Verify Not Cursor Position | verifyNotCursorPosition | locator | text | 
669 | Verify Not Cursor Position | verifyNotCursorPosition | parentLocator | locator | text
670 | Verify Not Editable | verifyNotEditable | locator |  | 
671 | Verify Not Editable | verifyNotEditable | parentLocator | locator | 
672 | Verify Not Element Height | verifyNotElementHeight | locator | text | 
673 | Verify Not Element Height | verifyNotElementHeight | parentLocator | locator | text
674 | Verify Not Element Index | verifyNotElementIndex | locator | text | 
675 | Verify Not Element Index | verifyNotElementIndex | parentLocator | locator | text
676 | Verify Not Element Position Left | verifyNotElementPositionLeft | locator | text | 
677 | Verify Not Element Position Left | verifyNotElementPositionLeft | parentLocator | locator | text
678 | Verify Not Element Position Top | verifyNotElementPositionTop | locator | text | 
679 | Verify Not Element Position Top | verifyNotElementPositionTop | parentLocator | locator | text
680 | Verify Not Element Width | verifyNotElementWidth | locator | text | 
681 | Verify Not Element Width | verifyNotElementWidth | parentLocator | locator | text
682 | Verify Not Eval | verifyNotEval | expression | text | 
683 | Verify Not Eval Script | verifyNotEvalScript | script | text | 
684 | Verify Not Exists In Database | verifyNotExistsInDatabase | sql |  | 
685 | Verify Not Expression | verifyNotExpression | expression | text | 
686 | Verify Not Font Family | verifyNotFontFamily | locator | text | 
687 | Verify Not Font Family | verifyNotFontFamily | parentLocator | locator | text
688 | Verify Not Font Size | verifyNotFontSize | locator | text | 
689 | Verify Not Font Size | verifyNotFontSize | parentLocator | locator | text
690 | Verify Not Font Style | verifyNotFontStyle | locator | text | 
691 | Verify Not Font Style | verifyNotFontStyle | parentLocator | locator | text
692 | Verify Not Font Weight | verifyNotFontWeight | locator | text | 
693 | Verify Not Font Weight | verifyNotFontWeight | parentLocator | locator | text
694 | Verify Not Html Source | verifyNotHtmlSource | text |  | 
695 | Verify Not Location | verifyNotLocation | text |  | 
696 | Verify Not Ordered | verifyNotOrdered | firstLocator | secondLocator | 
697 | Verify Not Prompt | verifyNotPrompt | text |  | 
698 | Verify Not Selected Id | verifyNotSelectedId | locator | text | 
699 | Verify Not Selected Id | verifyNotSelectedId | parentLocator | locator | text
700 | Verify Not Selected Index | verifyNotSelectedIndex | locator | text | 
701 | Verify Not Selected Index | verifyNotSelectedIndex | parentLocator | locator | text
702 | Verify Not Selected Label | verifyNotSelectedLabel | locator | text | 
703 | Verify Not Selected Label | verifyNotSelectedLabel | parentLocator | locator | text
704 | Verify Not Selected Value | verifyNotSelectedValue | locator | text | 
705 | Verify Not Selected Value | verifyNotSelectedValue | parentLocator | locator | text
706 | Verify Not Something Selected | verifyNotSomethingSelected | locator |  | 
707 | Verify Not Something Selected | verifyNotSomethingSelected | parentLocator | locator | 
708 | Verify Not Table | verifyNotTable | locator | cellAddress | text
709 | Verify Not Text | verifyNotText | locator | text | 
710 | Verify Not Text | verifyNotText | parentLocator | locator | text
711 | Verify Not Text Alignment | verifyNotTextAlignment | locator | text | 
712 | Verify Not Text Alignment | verifyNotTextAlignment | parentLocator | locator | text
713 | Verify Not Text Decoration | verifyNotTextDecoration | locator | text | 
714 | Verify Not Text Decoration | verifyNotTextDecoration | parentLocator | locator | text
715 | Verify Not Text Empty | verifyNotTextEmpty | locator |  | 
716 | Verify Not Text Empty | verifyNotTextEmpty | parentLocator | locator | 
717 | Verify Not Title | verifyNotTitle | text |  | 
718 | Verify Not Value | verifyNotValue | locator | text | 
719 | Verify Not Value | verifyNotValue | parentLocator | locator | text
720 | Verify Not Value Empty | verifyNotValueEmpty | locator |  | 
721 | Verify Not Value Empty | verifyNotValueEmpty | parentLocator | locator | 
722 | Verify Not Variable | verifyNotVariable | variable | text | 
723 | Verify Not Visible | verifyNotVisible | locator |  | 
724 | Verify Not Visible | verifyNotVisible | parentLocator | locator | 
725 | Verify Not Xpath Count | verifyNotXpathCount | xpath | text | 
726 | Verify Ordered | verifyOrdered | firstLocator | secondLocator | 
727 | Verify Prompt | verifyPrompt | text |  | 
728 | Verify Prompt Contain | verifyPromptContain | text |  | 
729 | Verify Prompt Not Contain | verifyPromptNotContain | text |  | 
730 | Verify Prompt Not Present | verifyPromptNotPresent |  |  | 
731 | Verify Prompt Present | verifyPromptPresent |  |  | 
732 | Verify Row Count | verifyRowCount | sql | count | 
733 | Verify Row Count Greater Than | verifyRowCountGreaterThan | sql | count | 
734 | Verify Row Count Less Than | verifyRowCountLessThan | sql | count | 
735 | Verify Selected Id | verifySelectedId | locator | text | 
736 | Verify Selected Id | verifySelectedId | parentLocator | locator | text
737 | Verify Selected Id Contain | verifySelectedIdContain | locator | text | 
738 | Verify Selected Id Contain | verifySelectedIdContain | parentLocator | locator | text
739 | Verify Selected Id Not Contain | verifySelectedIdNotContain | locator | text | 
740 | Verify Selected Id Not Contain | verifySelectedIdNotContain | parentLocator | locator | text
741 | Verify Selected Index | verifySelectedIndex | locator | text | 
742 | Verify Selected Index | verifySelectedIndex | parentLocator | locator | text
743 | Verify Selected Index Contain | verifySelectedIndexContain | locator | text | 
744 | Verify Selected Index Contain | verifySelectedIndexContain | parentLocator | locator | text
745 | Verify Selected Index Not Contain | verifySelectedIndexNotContain | locator | text | 
746 | Verify Selected Index Not Contain | verifySelectedIndexNotContain | parentLocator | locator | text
747 | Verify Selected Label | verifySelectedLabel | locator | text | 
748 | Verify Selected Label | verifySelectedLabel | parentLocator | locator | text
749 | Verify Selected Label Contain | verifySelectedLabelContain | locator | text | 
750 | Verify Selected Label Contain | verifySelectedLabelContain | parentLocator | locator | text
751 | Verify Selected Label Not Contain | verifySelectedLabelNotContain | locator | text | 
752 | Verify Selected Label Not Contain | verifySelectedLabelNotContain | parentLocator | locator | text
753 | Verify Selected Value | verifySelectedValue | locator | text | 
754 | Verify Selected Value | verifySelectedValue | parentLocator | locator | text
755 | Verify Selected Value Contain | verifySelectedValueContain | locator | text | 
756 | Verify Selected Value Contain | verifySelectedValueContain | parentLocator | locator | text
757 | Verify Selected Value Not Contain | verifySelectedValueNotContain | locator | text | 
758 | Verify Selected Value Not Contain | verifySelectedValueNotContain | parentLocator | locator | text
759 | Verify Something Selected | verifySomethingSelected | locator |  | 
760 | Verify Something Selected | verifySomethingSelected | parentLocator | locator | 
761 | Verify Table | verifyTable | locator | cellAddress | text
762 | Verify Table Contain | verifyTableContain | locator | cellAddress | text
763 | Verify Table Not Contain | verifyTableNotContain | locator | cellAddress | text
764 | Verify Text | verifyText | locator | text | 
765 | Verify Text | verifyText | parentLocator | locator | text
766 | Verify Text Alignment | verifyTextAlignment | locator | text | 
767 | Verify Text Alignment | verifyTextAlignment | parentLocator | locator | text
768 | Verify Text Alignment Contain | verifyTextAlignmentContain | locator | text | 
769 | Verify Text Alignment Contain | verifyTextAlignmentContain | parentLocator | locator | text
770 | Verify Text Alignment Not Contain | verifyTextAlignmentNotContain | locator | text | 
771 | Verify Text Alignment Not Contain | verifyTextAlignmentNotContain | parentLocator | locator | text
772 | Verify Text Contain | verifyTextContain | locator | text | 
773 | Verify Text Contain | verifyTextContain | parentLocator | locator | text
774 | Verify Text Decoration | verifyTextDecoration | locator | text | 
775 | Verify Text Decoration | verifyTextDecoration | parentLocator | locator | text
776 | Verify Text Decoration Contain | verifyTextDecorationContain | locator | text | 
777 | Verify Text Decoration Contain | verifyTextDecorationContain | parentLocator | locator | text
778 | Verify Text Decoration Not Contain | verifyTextDecorationNotContain | locator | text | 
779 | Verify Text Decoration Not Contain | verifyTextDecorationNotContain | parentLocator | locator | text
780 | Verify Text Empty | verifyTextEmpty | locator |  | 
781 | Verify Text Empty | verifyTextEmpty | parentLocator | locator | 
782 | Verify Text List Order Asc | verifyTextListOrderAsc | locator |  | 
783 | Verify Text List Order Asc | verifyTextListOrderAsc | parentLocator | locator | 
784 | Verify Text List Order Desc | verifyTextListOrderDesc | locator |  | 
785 | Verify Text List Order Desc | verifyTextListOrderDesc | parentLocator | locator | 
786 | Verify Text Not Contain | verifyTextNotContain | locator | text | 
787 | Verify Text Not Contain | verifyTextNotContain | parentLocator | locator | text
788 | Verify Text Not Present | verifyTextNotPresent | pattern |  | 
789 | Verify Text Present | verifyTextPresent | pattern |  | 
790 | Verify Title | verifyTitle | text |  | 
791 | Verify Title Contain | verifyTitleContain | text |  | 
792 | Verify Title Not Contain | verifyTitleNotContain | text |  | 
793 | Verify Value | verifyValue | locator | text | 
794 | Verify Value | verifyValue | parentLocator | locator | text
795 | Verify Value Contain | verifyValueContain | locator | text | 
796 | Verify Value Contain | verifyValueContain | parentLocator | locator | text
797 | Verify Value Empty | verifyValueEmpty | locator |  | 
798 | Verify Value Empty | verifyValueEmpty | parentLocator | locator | 
799 | Verify Value Not Contain | verifyValueNotContain | locator | text | 
800 | Verify Value Not Contain | verifyValueNotContain | parentLocator | locator | text
801 | Verify Variable | verifyVariable | variable | text | 
802 | Verify Variable Contain | verifyVariableContain | variable | text | 
803 | Verify Variable Not Contain | verifyVariableNotContain | variable | text | 
804 | Verify Visible | verifyVisible | locator |  | 
805 | Verify Visible | verifyVisible | parentLocator | locator | 
806 | Verify Xpath Count | verifyXpathCount | xpath | text | 
807 | Wait For Alert | waitForAlert | text |  | 
808 | Wait For Alert Contain | waitForAlertContain | text |  | 
809 | Wait For Alert Not Contain | waitForAlertNotContain | text |  | 
810 | Wait For Alert Not Present | waitForAlertNotPresent |  |  | 
811 | Wait For Alert Present | waitForAlertPresent |  |  | 
812 | Wait For All Element Not Present | waitForAllElementNotPresent | locatorArray |  | 
813 | Wait For All Element Present | waitForAllElementPresent | locatorArray |  | 
814 | Wait For All Text Not Present | waitForAllTextNotPresent | textArray |  | 
815 | Wait For All Text Present | waitForAllTextPresent | textArray |  | 
816 | Wait For Any Element Not Present | waitForAnyElementNotPresent | locatorArray |  | 
817 | Wait For Any Element Present | waitForAnyElementPresent | locatorArray |  | 
818 | Wait For Any Text Not Present | waitForAnyTextNotPresent | textArray |  | 
819 | Wait For Any Text Present | waitForAnyTextPresent | textArray |  | 
820 | Wait For Attribute | waitForAttribute | locator | name | text
821 | Wait For Attribute Contain | waitForAttributeContain | locator | name | text
822 | Wait For Attribute Not Contain | waitForAttributeNotContain | locator | name | text
823 | Wait For Body Text | waitForBodyText | text |  | 
824 | Wait For Body Text Contain | waitForBodyTextContain | text |  | 
825 | Wait For Body Text Not Contain | waitForBodyTextNotContain | text |  | 
826 | Wait For Checked | waitForChecked | locator |  | 
827 | Wait For Checked | waitForChecked | parentLocator | locator | 
828 | Wait For Condition | waitForCondition | script | timeout | 
829 | Wait For Confirmation | waitForConfirmation | text |  | 
830 | Wait For Confirmation Contain | waitForConfirmationContain | text |  | 
831 | Wait For Confirmation Not Contain | waitForConfirmationNotContain | text |  | 
832 | Wait For Confirmation Not Present | waitForConfirmationNotPresent |  |  | 
833 | Wait For Confirmation Present | waitForConfirmationPresent |  |  | 
834 | Wait For Cookie | waitForCookie | text |  | 
835 | Wait For Cookie By Name | waitForCookieByName | name | text | 
836 | Wait For Cookie By Name Contain | waitForCookieByNameContain | name | text | 
837 | Wait For Cookie By Name Not Contain | waitForCookieByNameNotContain | name | text | 
838 | Wait For Cookie Contain | waitForCookieContain | text |  | 
839 | Wait For Cookie Not Contain | waitForCookieNotContain | text |  | 
840 | Wait For Cookie Not Present | waitForCookieNotPresent | name |  | 
841 | Wait For Cookie Present | waitForCookiePresent | name |  | 
842 | Wait For Editable | waitForEditable | locator |  | 
843 | Wait For Editable | waitForEditable | parentLocator | locator | 
844 | Wait For Element Not Present | waitForElementNotPresent | locator |  | 
845 | Wait For Element Not Present | waitForElementNotPresent | parentLocator | locator | 
846 | Wait For Element Present | waitForElementPresent | locator |  | 
847 | Wait For Element Present | waitForElementPresent | parentLocator | locator | 
848 | Wait For Eval | waitForEval | expression | text | 
849 | Wait For Eval Script | waitForEvalScript | script | text | 
850 | Wait For Eval Script Contain | waitForEvalScriptContain | script | text | 
851 | Wait For Eval Script Not Contain | waitForEvalScriptNotContain | script | text | 
852 | Wait For Exists In Database | waitForExistsInDatabase | sql |  | 
853 | Wait For Expression | waitForExpression | expression | text | 
854 | Wait For Expression Contain | waitForExpressionContain | expression | text | 
855 | Wait For Expression Not Contain | waitForExpressionNotContain | expression | text | 
856 | Wait For Html Source | waitForHtmlSource | text |  | 
857 | Wait For Html Source Contain | waitForHtmlSourceContain | text |  | 
858 | Wait For Html Source Not Contain | waitForHtmlSourceNotContain | text |  | 
859 | Wait For Location | waitForLocation | text |  | 
860 | Wait For Location Contain | waitForLocationContain | text |  | 
861 | Wait For Location Not Contain | waitForLocationNotContain | text |  | 
862 | Wait For Not Alert | waitForNotAlert | text |  | 
863 | Wait For Not Attribute | waitForNotAttribute | locator | name | text
864 | Wait For Not Body Text | waitForNotBodyText | text |  | 
865 | Wait For Not Checked | waitForNotChecked | locator |  | 
866 | Wait For Not Checked | waitForNotChecked | parentLocator | locator | 
867 | Wait For Not Confirmation | waitForNotConfirmation | text |  | 
868 | Wait For Not Cookie | waitForNotCookie | text |  | 
869 | Wait For Not Cookie By Name | waitForNotCookieByName | name | text | 
870 | Wait For Not Editable | waitForNotEditable | locator |  | 
871 | Wait For Not Editable | waitForNotEditable | parentLocator | locator | 
872 | Wait For Not Eval | waitForNotEval | expression | text | 
873 | Wait For Not Eval Script | waitForNotEvalScript | script | text | 
874 | Wait For Not Exists In Database | waitForNotExistsInDatabase | sql |  | 
875 | Wait For Not Expression | waitForNotExpression | expression | text | 
876 | Wait For Not Html Source | waitForNotHtmlSource | text |  | 
877 | Wait For Not Location | waitForNotLocation | text |  | 
878 | Wait For Not Prompt | waitForNotPrompt | text |  | 
879 | Wait For Not Selected Id | waitForNotSelectedId | locator | text | 
880 | Wait For Not Selected Id | waitForNotSelectedId | parentLocator | locator | text
881 | Wait For Not Selected Index | waitForNotSelectedIndex | locator | text | 
882 | Wait For Not Selected Index | waitForNotSelectedIndex | parentLocator | locator | text
883 | Wait For Not Selected Label | waitForNotSelectedLabel | locator | text | 
884 | Wait For Not Selected Label | waitForNotSelectedLabel | parentLocator | locator | text
885 | Wait For Not Selected Value | waitForNotSelectedValue | locator | text | 
886 | Wait For Not Selected Value | waitForNotSelectedValue | parentLocator | locator | text
887 | Wait For Not Something Selected | waitForNotSomethingSelected | locator |  | 
888 | Wait For Not Something Selected | waitForNotSomethingSelected | parentLocator | locator | 
889 | Wait For Not Table | waitForNotTable | locator | cellAddress | text
890 | Wait For Not Text | waitForNotText | locator | text | 
891 | Wait For Not Text | waitForNotText | parentLocator | locator | text
892 | Wait For Not Text Empty | waitForNotTextEmpty | locator |  | 
893 | Wait For Not Text Empty | waitForNotTextEmpty | parentLocator | locator | 
894 | Wait For Not Title | waitForNotTitle | text |  | 
895 | Wait For Not Value | waitForNotValue | locator | text | 
896 | Wait For Not Value | waitForNotValue | parentLocator | locator | text
897 | Wait For Not Value Empty | waitForNotValueEmpty | locator |  | 
898 | Wait For Not Value Empty | waitForNotValueEmpty | parentLocator | locator | 
899 | Wait For Not Visible | waitForNotVisible | locator |  | 
900 | Wait For Not Visible | waitForNotVisible | parentLocator | locator | 
901 | Wait For Page To Load | waitForPageToLoad | timeout |  | 
902 | Wait For Pop Up | waitForPopUp | windowID | timeout | 
903 | Wait For Prompt | waitForPrompt | text |  | 
904 | Wait For Prompt Contain | waitForPromptContain | text |  | 
905 | Wait For Prompt Not Contain | waitForPromptNotContain | text |  | 
906 | Wait For Prompt Not Present | waitForPromptNotPresent |  |  | 
907 | Wait For Prompt Present | waitForPromptPresent |  |  | 
908 | Wait For Selected Id | waitForSelectedId | locator | text | 
909 | Wait For Selected Id | waitForSelectedId | parentLocator | locator | text
910 | Wait For Selected Id Contain | waitForSelectedIdContain | locator | text | 
911 | Wait For Selected Id Contain | waitForSelectedIdContain | parentLocator | locator | text
912 | Wait For Selected Id Not Contain | waitForSelectedIdNotContain | locator | text | 
913 | Wait For Selected Id Not Contain | waitForSelectedIdNotContain | parentLocator | locator | text
914 | Wait For Selected Index | waitForSelectedIndex | locator | text | 
915 | Wait For Selected Index | waitForSelectedIndex | parentLocator | locator | text
916 | Wait For Selected Index Contain | waitForSelectedIndexContain | locator | text | 
917 | Wait For Selected Index Contain | waitForSelectedIndexContain | parentLocator | locator | text
918 | Wait For Selected Index Not Contain | waitForSelectedIndexNotContain | locator | text | 
919 | Wait For Selected Index Not Contain | waitForSelectedIndexNotContain | parentLocator | locator | text
920 | Wait For Selected Label | waitForSelectedLabel | locator | text | 
921 | Wait For Selected Label | waitForSelectedLabel | parentLocator | locator | text
922 | Wait For Selected Label Contain | waitForSelectedLabelContain | locator | text | 
923 | Wait For Selected Label Contain | waitForSelectedLabelContain | parentLocator | locator | text
924 | Wait For Selected Label Not Contain | waitForSelectedLabelNotContain | locator | text | 
925 | Wait For Selected Label Not Contain | waitForSelectedLabelNotContain | parentLocator | locator | text
926 | Wait For Selected Value | waitForSelectedValue | locator | text | 
927 | Wait For Selected Value | waitForSelectedValue | parentLocator | locator | text
928 | Wait For Selected Value Contain | waitForSelectedValueContain | locator | text | 
929 | Wait For Selected Value Contain | waitForSelectedValueContain | parentLocator | locator | text
930 | Wait For Selected Value Not Contain | waitForSelectedValueNotContain | locator | text | 
931 | Wait For Selected Value Not Contain | waitForSelectedValueNotContain | parentLocator | locator | text
932 | Wait For Something Selected | waitForSomethingSelected | locator |  | 
933 | Wait For Something Selected | waitForSomethingSelected | parentLocator | locator | 
934 | Wait For Table | waitForTable | locator | cellAddress | text
935 | Wait For Table Contain | waitForTableContain | locator | cellAddress | text
936 | Wait For Table Not Contain | waitForTableNotContain | locator | cellAddress | text
937 | Wait For Text | waitForText | locator | text | 
938 | Wait For Text | waitForText | parentLocator | locator | text
939 | Wait For Text Contain | waitForTextContain | locator | text | 
940 | Wait For Text Contain | waitForTextContain | parentLocator | locator | text
941 | Wait For Text Empty | waitForTextEmpty | locator |  | 
942 | Wait For Text Empty | waitForTextEmpty | parentLocator | locator | 
943 | Wait For Text Not Contain | waitForTextNotContain | locator | text | 
944 | Wait For Text Not Contain | waitForTextNotContain | parentLocator | locator | text
945 | Wait For Text Not Present | waitForTextNotPresent | pattern |  | 
946 | Wait For Text Present | waitForTextPresent | pattern |  | 
947 | Wait For Title | waitForTitle | text |  | 
948 | Wait For Title Contain | waitForTitleContain | text |  | 
949 | Wait For Title Not Contain | waitForTitleNotContain | text |  | 
950 | Wait For Value | waitForValue | locator | text | 
951 | Wait For Value | waitForValue | parentLocator | locator | text
952 | Wait For Value Contain | waitForValueContain | locator | text | 
953 | Wait For Value Contain | waitForValueContain | parentLocator | locator | text
954 | Wait For Value Empty | waitForValueEmpty | locator |  | 
955 | Wait For Value Empty | waitForValueEmpty | parentLocator | locator | 
956 | Wait For Value Not Contain | waitForValueNotContain | locator | text | 
957 | Wait For Value Not Contain | waitForValueNotContain | parentLocator | locator | text
958 | Wait For Visible | waitForVisible | locator |  | 
959 | Wait For Visible | waitForVisible | parentLocator | locator | 
960 | Window Focus | windowFocus |  |  | 
961 | Window Maximize | windowMaximize |  |  | 

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

## Assert Alert Contain

Asserts that the message of a JavaScript alert contains the given value. When the assert fails, the test is aborted.

### Usage

`
assertAlertContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Alert Not Contain

Asserts that the message of a JavaScript alert not contain the given value. When the assert fails, the test is aborted.

### Usage

`
assertAlertNotContain(text)
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

## Assert Attribute Contain

Asserts that the value of the given attribute of the element contains the given value. When the assert fails, the test is aborted. Will return the current value, even if this has been modified after the page has been loaded.

 <p>More exactly, this method will return the value of the property with the given name, if it exists. If it does not, then the value of the attribute with the given name is returned. If neither exists, null is returned.

 <p>The "style" attribute is converted as best can be to a text representation with a trailing semi-colon.

 <p>The following are deemed to be "boolean" attributes, and will return either "true" or null:

 <p>async, autofocus, autoplay, checked, compact, complete, controls, declare, defaultchecked, defaultselected, defer, disabled, draggable, ended, formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope, loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open, paused, pubdate, readonly, required, reversed, scoped, seamless, seeking, selected, truespeed, willvalidate

 <p>Finally, the following commonly mis-capitalized attribute/property names are evaluated as expected:

 <ul> <li>If the given name is "class", the "className" property is returned. <li>If the given name is "readonly", the "readOnly" property is returned. </ul>

 <i>Note:</i> The reason for this behavior is that users frequently confuse attributes and properties. If you need to do something more precise, e.g., refer to an attribute even when a property of the same name exists, then you should evaluate Javascript to obtain the result you desire.

### Usage

`
assertAttributeContain(locator, name, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator
name | The name of the attribute.
text | the value to match with the result

## Assert Attribute Not Contain

Asserts that the value of the given attribute of the element not contain the given value. When the assert fails, the test is aborted. Will return the current value, even if this has been modified after the page has been loaded.

 <p>More exactly, this method will return the value of the property with the given name, if it exists. If it does not, then the value of the attribute with the given name is returned. If neither exists, null is returned.

 <p>The "style" attribute is converted as best can be to a text representation with a trailing semi-colon.

 <p>The following are deemed to be "boolean" attributes, and will return either "true" or null:

 <p>async, autofocus, autoplay, checked, compact, complete, controls, declare, defaultchecked, defaultselected, defer, disabled, draggable, ended, formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope, loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open, paused, pubdate, readonly, required, reversed, scoped, seamless, seeking, selected, truespeed, willvalidate

 <p>Finally, the following commonly mis-capitalized attribute/property names are evaluated as expected:

 <ul> <li>If the given name is "class", the "className" property is returned. <li>If the given name is "readonly", the "readOnly" property is returned. </ul>

 <i>Note:</i> The reason for this behavior is that users frequently confuse attributes and properties. If you need to do something more precise, e.g., refer to an attribute even when a property of the same name exists, then you should evaluate Javascript to obtain the result you desire.

### Usage

`
assertAttributeNotContain(locator, name, text)
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

## Assert Body Text Contain

Asserts that the entire text of the page contains the given value. When the assert fails, the test is aborted.

### Usage

`
assertBodyTextContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Body Text Not Contain

Asserts that the entire text of the page not contain the given value. When the assert fails, the test is aborted.

### Usage

`
assertBodyTextNotContain(text)
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

## Assert Confirmation Contain

Asserts that the message of a JavaScript confirmation dialog contains the given value. When the assert fails, the test is aborted.

### Usage

`
assertConfirmationContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Confirmation Not Contain

Asserts that the message of a JavaScript confirmation dialog not contain the given value. When the assert fails, the test is aborted.

### Usage

`
assertConfirmationNotContain(text)
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

## Assert Cookie By Name Contain

Asserts that the value of the cookie with the specified name contains the given value. When the assert fails, the test is aborted.

### Usage

`
assertCookieByNameContain(name, text)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie
text | the value to match with the result

## Assert Cookie By Name Not Contain

Asserts that the value of the cookie with the specified name not contain the given value. When the assert fails, the test is aborted.

### Usage

`
assertCookieByNameNotContain(name, text)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie
text | the value to match with the result

## Assert Cookie Contain

Asserts that all cookies of the current page under test contains the given value. When the assert fails, the test is aborted.

### Usage

`
assertCookieContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Cookie Not Contain

Asserts that all cookies of the current page under test not contain the given value. When the assert fails, the test is aborted.

### Usage

`
assertCookieNotContain(text)
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

## Assert Eval Script Contain

Asserts that the result of evaluating the specified JavaScript snippet contains the given value. When the assert fails, the test is aborted. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
assertEvalScriptContain(script, text)
`

### Parameters

Parameter | Description
--------- | -----------
script | the JavaScript snippet to run
text | the value to match with the result

## Assert Eval Script Not Contain

Asserts that the result of evaluating the specified JavaScript snippet not contain the given value. When the assert fails, the test is aborted. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
assertEvalScriptNotContain(script, text)
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

## Assert Expression Contain

Asserts that the specified expression contains the given value. When the assert fails, the test is aborted.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
assertExpressionContain(expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the value to return
text | the value to match with the result

## Assert Expression Not Contain

Asserts that the specified expression not contain the given value. When the assert fails, the test is aborted.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
assertExpressionNotContain(expression, text)
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

## Assert Font Family Contain

Asserts that the font family of the specified element contains the given value. When the assert fails, the test is aborted.

### Usage

`
assertFontFamilyContain(locator, text)
`

`
assertFontFamilyContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Font Family Not Contain

Asserts that the font family of the specified element not contain the given value. When the assert fails, the test is aborted.

### Usage

`
assertFontFamilyNotContain(locator, text)
`

`
assertFontFamilyNotContain(parentLocator, locator, text)
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

## Assert Font Size Contain

Asserts that the font size of the specified element contains the given value. When the assert fails, the test is aborted.

### Usage

`
assertFontSizeContain(locator, text)
`

`
assertFontSizeContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Font Size Not Contain

Asserts that the font size of the specified element not contain the given value. When the assert fails, the test is aborted.

### Usage

`
assertFontSizeNotContain(locator, text)
`

`
assertFontSizeNotContain(parentLocator, locator, text)
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

## Assert Font Style Contain

Asserts that the font style of the specified element contains the given value. When the assert fails, the test is aborted.

### Usage

`
assertFontStyleContain(locator, text)
`

`
assertFontStyleContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Font Style Not Contain

Asserts that the font style of the specified element not contain the given value. When the assert fails, the test is aborted.

### Usage

`
assertFontStyleNotContain(locator, text)
`

`
assertFontStyleNotContain(parentLocator, locator, text)
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

## Assert Font Weight Contain

Asserts that the font weight of the specified element contains the given value. When the assert fails, the test is aborted.

### Usage

`
assertFontWeightContain(locator, text)
`

`
assertFontWeightContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Font Weight Not Contain

Asserts that the font weight of the specified element not contain the given value. When the assert fails, the test is aborted.

### Usage

`
assertFontWeightNotContain(locator, text)
`

`
assertFontWeightNotContain(parentLocator, locator, text)
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

## Assert Html Source Contain

Asserts that the entire HTML source between the opening and closing "html" tags contains the given value. When the assert fails, the test is aborted.

### Usage

`
assertHtmlSourceContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Html Source Not Contain

Asserts that the entire HTML source between the opening and closing "html" tags not contain the given value. When the assert fails, the test is aborted.

### Usage

`
assertHtmlSourceNotContain(text)
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

## Assert Location Contain

Asserts that the absolute URL of the current page contains the given value. When the assert fails, the test is aborted.

### Usage

`
assertLocationContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Location Not Contain

Asserts that the absolute URL of the current page not contain the given value. When the assert fails, the test is aborted.

### Usage

`
assertLocationNotContain(text)
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

## Assert Prompt Contain

Asserts that the message of a JavaScript question prompt dialog contains the given value. When the assert fails, the test is aborted.

### Usage

`
assertPromptContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Prompt Not Contain

Asserts that the message of a JavaScript question prompt dialog not contain the given value. When the assert fails, the test is aborted.

### Usage

`
assertPromptNotContain(text)
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

## Assert Selected Id Contain

Asserts that option element ID for selected option in the specified select element contains the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedIdContain(locator, text)
`

`
assertSelectedIdContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Id Not Contain

Asserts that option element ID for selected option in the specified select element not contain the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedIdNotContain(locator, text)
`

`
assertSelectedIdNotContain(parentLocator, locator, text)
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

## Assert Selected Index Contain

Asserts that option index (option number, starting at 0) for selected option in the specified select element contains the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedIndexContain(locator, text)
`

`
assertSelectedIndexContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Index Not Contain

Asserts that option index (option number, starting at 0) for selected option in the specified select element not contain the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedIndexNotContain(locator, text)
`

`
assertSelectedIndexNotContain(parentLocator, locator, text)
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

## Assert Selected Label Contain

Asserts that option label (visible text) for selected option in the specified select element contains the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedLabelContain(locator, text)
`

`
assertSelectedLabelContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Label Not Contain

Asserts that option label (visible text) for selected option in the specified select element not contain the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedLabelNotContain(locator, text)
`

`
assertSelectedLabelNotContain(parentLocator, locator, text)
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

## Assert Selected Value Contain

Asserts that option value (value attribute) for selected option in the specified select element contains the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedValueContain(locator, text)
`

`
assertSelectedValueContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Assert Selected Value Not Contain

Asserts that option value (value attribute) for selected option in the specified select element not contain the given value. When the assert fails, the test is aborted.

### Usage

`
assertSelectedValueNotContain(locator, text)
`

`
assertSelectedValueNotContain(parentLocator, locator, text)
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

## Assert Table Contain

Asserts that the text from a cell of a table contains the given value. When the assert fails, the test is aborted. The cellAddress syntax row.column, where row and column start at 0.

### Usage

`
assertTableContain(locator, cellAddress, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator pointing to a table
cellAddress | a cell address, e.g. "1.4"
text | the value to match with the result

## Assert Table Not Contain

Asserts that the text from a cell of a table not contain the given value. When the assert fails, the test is aborted. The cellAddress syntax row.column, where row and column start at 0.

### Usage

`
assertTableNotContain(locator, cellAddress, text)
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

## Assert Text Alignment Contain

Asserts that the text alignment of the specified element contains the given value. When the assert fails, the test is aborted.

### Usage

`
assertTextAlignmentContain(locator, text)
`

`
assertTextAlignmentContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Text Alignment Not Contain

Asserts that the text alignment of the specified element not contain the given value. When the assert fails, the test is aborted.

### Usage

`
assertTextAlignmentNotContain(locator, text)
`

`
assertTextAlignmentNotContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Text Contain

Asserts that the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user contains the given value. When the assert fails, the test is aborted.

### Usage

`
assertTextContain(locator, text)
`

`
assertTextContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
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

## Assert Text Decoration Contain

Asserts that the text decoration of the specified element contains the given value. When the assert fails, the test is aborted.

### Usage

`
assertTextDecorationContain(locator, text)
`

`
assertTextDecorationContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Assert Text Decoration Not Contain

Asserts that the text decoration of the specified element not contain the given value. When the assert fails, the test is aborted.

### Usage

`
assertTextDecorationNotContain(locator, text)
`

`
assertTextDecorationNotContain(parentLocator, locator, text)
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

## Assert Text Not Contain

Asserts that the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user not contain the given value. When the assert fails, the test is aborted.

### Usage

`
assertTextNotContain(locator, text)
`

`
assertTextNotContain(parentLocator, locator, text)
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

## Assert Title Contain

Asserts that the title of the current page contains the given value. When the assert fails, the test is aborted.

### Usage

`
assertTitleContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Title Not Contain

Asserts that the title of the current page not contain the given value. When the assert fails, the test is aborted.

### Usage

`
assertTitleNotContain(text)
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

## Assert Value Contain

Asserts that the (whitespace-trimmed) value of an input field (or anything else with a value parameter) contains the given value. When the assert fails, the test is aborted. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
assertValueContain(locator, text)
`

`
assertValueContain(parentLocator, locator, text)
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

## Assert Value Not Contain

Asserts that the (whitespace-trimmed) value of an input field (or anything else with a value parameter) not contain the given value. When the assert fails, the test is aborted. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
assertValueNotContain(locator, text)
`

`
assertValueNotContain(parentLocator, locator, text)
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

## Assert Variable Contain

Asserts that the specified variable value contains the given value. When the assert fails, the test is aborted.

### Usage

`
assertVariableContain(variable, text)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the variable
text | the value to match with the result

## Assert Variable Not Contain

Asserts that the specified variable value not contain the given value. When the assert fails, the test is aborted.

### Usage

`
assertVariableNotContain(variable, text)
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

## Execute If Alert Contain

Executes an action if the message of a JavaScript alert contains the given value.

### Usage

`
executeIfAlertContain(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Alert Not Contain

Executes an action if the message of a JavaScript alert not contain the given value.

### Usage

`
executeIfAlertNotContain(action, text)
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

## Execute If Body Text Contain

Executes an action if the entire text of the page contains the given value.

### Usage

`
executeIfBodyTextContain(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Body Text Not Contain

Executes an action if the entire text of the page not contain the given value.

### Usage

`
executeIfBodyTextNotContain(action, text)
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

## Execute If Confirmation Contain

Executes an action if the message of a JavaScript confirmation dialog contains the given value.

### Usage

`
executeIfConfirmationContain(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Confirmation Not Contain

Executes an action if the message of a JavaScript confirmation dialog not contain the given value.

### Usage

`
executeIfConfirmationNotContain(action, text)
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

## Execute If Cookie By Name Contain

Executes an action if the value of the cookie with the specified name contains the given value.

### Usage

`
executeIfCookieByNameContain(action, name, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
name | the name of the cookie
text | the value to match with the result

## Execute If Cookie By Name Not Contain

Executes an action if the value of the cookie with the specified name not contain the given value.

### Usage

`
executeIfCookieByNameNotContain(action, name, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
name | the name of the cookie
text | the value to match with the result

## Execute If Cookie Contain

Executes an action if all cookies of the current page under test contains the given value.

### Usage

`
executeIfCookieContain(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Cookie Not Contain

Executes an action if all cookies of the current page under test not contain the given value.

### Usage

`
executeIfCookieNotContain(action, text)
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

## Execute If Eval Script Contain

Executes an action if the result of evaluating the specified JavaScript snippet contains the given value. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
executeIfEvalScriptContain(action, script, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
script | the JavaScript snippet to run
text | the value to match with the result

## Execute If Eval Script Not Contain

Executes an action if the result of evaluating the specified JavaScript snippet not contain the given value. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
executeIfEvalScriptNotContain(action, script, text)
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

## Execute If Expression Contain

Executes an action if the specified expression contains the given value.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
executeIfExpressionContain(action, expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
expression | the value to return
text | the value to match with the result

## Execute If Expression Not Contain

Executes an action if the specified expression not contain the given value.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
executeIfExpressionNotContain(action, expression, text)
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

## Execute If Html Source Contain

Executes an action if the entire HTML source between the opening and closing "html" tags contains the given value.

### Usage

`
executeIfHtmlSourceContain(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Html Source Not Contain

Executes an action if the entire HTML source between the opening and closing "html" tags not contain the given value.

### Usage

`
executeIfHtmlSourceNotContain(action, text)
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

## Execute If Location Contain

Executes an action if the absolute URL of the current page contains the given value.

### Usage

`
executeIfLocationContain(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Location Not Contain

Executes an action if the absolute URL of the current page not contain the given value.

### Usage

`
executeIfLocationNotContain(action, text)
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

## Execute If Prompt Contain

Executes an action if the message of a JavaScript question prompt dialog contains the given value.

### Usage

`
executeIfPromptContain(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Prompt Not Contain

Executes an action if the message of a JavaScript question prompt dialog not contain the given value.

### Usage

`
executeIfPromptNotContain(action, text)
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

## Execute If Selected Id Contain

Executes an action if option element ID for selected option in the specified select element contains the given value.

### Usage

`
executeIfSelectedIdContain(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Execute If Selected Id Not Contain

Executes an action if option element ID for selected option in the specified select element not contain the given value.

### Usage

`
executeIfSelectedIdNotContain(action, locator, text)
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

## Execute If Selected Index Contain

Executes an action if option index (option number, starting at 0) for selected option in the specified select element contains the given value.

### Usage

`
executeIfSelectedIndexContain(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Execute If Selected Index Not Contain

Executes an action if option index (option number, starting at 0) for selected option in the specified select element not contain the given value.

### Usage

`
executeIfSelectedIndexNotContain(action, locator, text)
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

## Execute If Selected Label Contain

Executes an action if option label (visible text) for selected option in the specified select element contains the given value.

### Usage

`
executeIfSelectedLabelContain(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Execute If Selected Label Not Contain

Executes an action if option label (visible text) for selected option in the specified select element not contain the given value.

### Usage

`
executeIfSelectedLabelNotContain(action, locator, text)
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

## Execute If Selected Value Contain

Executes an action if option value (value attribute) for selected option in the specified select element contains the given value.

### Usage

`
executeIfSelectedValueContain(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Execute If Selected Value Not Contain

Executes an action if option value (value attribute) for selected option in the specified select element not contain the given value.

### Usage

`
executeIfSelectedValueNotContain(action, locator, text)
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

## Execute If Text Contain

Executes an action if the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user contains the given value.

### Usage

`
executeIfTextContain(action, locator, text)
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

## Execute If Text Not Contain

Executes an action if the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user not contain the given value.

### Usage

`
executeIfTextNotContain(action, locator, text)
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

## Execute If Title Contain

Executes an action if the title of the current page contains the given value.

### Usage

`
executeIfTitleContain(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Title Not Contain

Executes an action if the title of the current page not contain the given value.

### Usage

`
executeIfTitleNotContain(action, text)
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

## Execute If Value Contain

Executes an action if the (whitespace-trimmed) value of an input field (or anything else with a value parameter) contains the given value. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
executeIfValueContain(action, locator, text)
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

## Execute If Value Not Contain

Executes an action if the (whitespace-trimmed) value of an input field (or anything else with a value parameter) not contain the given value. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
executeIfValueNotContain(action, locator, text)
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

## Execute If Variable Contain

Executes an action if the specified variable value contains the given value.

### Usage

`
executeIfVariableContain(action, variable, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
variable | the variable
text | the value to match with the result

## Execute If Variable Not Contain

Executes an action if the specified variable value not contain the given value.

### Usage

`
executeIfVariableNotContain(action, variable, text)
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

 <p> You may also use a DOM expression to identify the frame you want directly, like this: <code>dom=frames["main"].frames["subframe"]</code> </p>

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

## Verify Alert Contain

Verifies that the message of a JavaScript alert contains the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyAlertContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Alert Not Contain

Verifies that the message of a JavaScript alert not contain the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyAlertNotContain(text)
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

## Verify Attribute Contain

Verifies that the value of the given attribute of the element contains the given value. When the verify fails, the test will continue execution, logging the failure. Will return the current value, even if this has been modified after the page has been loaded.

 <p>More exactly, this method will return the value of the property with the given name, if it exists. If it does not, then the value of the attribute with the given name is returned. If neither exists, null is returned.

 <p>The "style" attribute is converted as best can be to a text representation with a trailing semi-colon.

 <p>The following are deemed to be "boolean" attributes, and will return either "true" or null:

 <p>async, autofocus, autoplay, checked, compact, complete, controls, declare, defaultchecked, defaultselected, defer, disabled, draggable, ended, formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope, loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open, paused, pubdate, readonly, required, reversed, scoped, seamless, seeking, selected, truespeed, willvalidate

 <p>Finally, the following commonly mis-capitalized attribute/property names are evaluated as expected:

 <ul> <li>If the given name is "class", the "className" property is returned. <li>If the given name is "readonly", the "readOnly" property is returned. </ul>

 <i>Note:</i> The reason for this behavior is that users frequently confuse attributes and properties. If you need to do something more precise, e.g., refer to an attribute even when a property of the same name exists, then you should evaluate Javascript to obtain the result you desire.

### Usage

`
verifyAttributeContain(locator, name, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator
name | The name of the attribute.
text | the value to match with the result

## Verify Attribute Not Contain

Verifies that the value of the given attribute of the element not contain the given value. When the verify fails, the test will continue execution, logging the failure. Will return the current value, even if this has been modified after the page has been loaded.

 <p>More exactly, this method will return the value of the property with the given name, if it exists. If it does not, then the value of the attribute with the given name is returned. If neither exists, null is returned.

 <p>The "style" attribute is converted as best can be to a text representation with a trailing semi-colon.

 <p>The following are deemed to be "boolean" attributes, and will return either "true" or null:

 <p>async, autofocus, autoplay, checked, compact, complete, controls, declare, defaultchecked, defaultselected, defer, disabled, draggable, ended, formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope, loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open, paused, pubdate, readonly, required, reversed, scoped, seamless, seeking, selected, truespeed, willvalidate

 <p>Finally, the following commonly mis-capitalized attribute/property names are evaluated as expected:

 <ul> <li>If the given name is "class", the "className" property is returned. <li>If the given name is "readonly", the "readOnly" property is returned. </ul>

 <i>Note:</i> The reason for this behavior is that users frequently confuse attributes and properties. If you need to do something more precise, e.g., refer to an attribute even when a property of the same name exists, then you should evaluate Javascript to obtain the result you desire.

### Usage

`
verifyAttributeNotContain(locator, name, text)
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

## Verify Body Text Contain

Verifies that the entire text of the page contains the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyBodyTextContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Body Text Not Contain

Verifies that the entire text of the page not contain the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyBodyTextNotContain(text)
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

## Verify Confirmation Contain

Verifies that the message of a JavaScript confirmation dialog contains the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyConfirmationContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Confirmation Not Contain

Verifies that the message of a JavaScript confirmation dialog not contain the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyConfirmationNotContain(text)
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

## Verify Cookie By Name Contain

Verifies that the value of the cookie with the specified name contains the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyCookieByNameContain(name, text)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie
text | the value to match with the result

## Verify Cookie By Name Not Contain

Verifies that the value of the cookie with the specified name not contain the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyCookieByNameNotContain(name, text)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie
text | the value to match with the result

## Verify Cookie Contain

Verifies that all cookies of the current page under test contains the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyCookieContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Cookie Not Contain

Verifies that all cookies of the current page under test not contain the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyCookieNotContain(text)
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

## Verify Eval Script Contain

Verifies that the result of evaluating the specified JavaScript snippet contains the given value. When the verify fails, the test will continue execution, logging the failure. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
verifyEvalScriptContain(script, text)
`

### Parameters

Parameter | Description
--------- | -----------
script | the JavaScript snippet to run
text | the value to match with the result

## Verify Eval Script Not Contain

Verifies that the result of evaluating the specified JavaScript snippet not contain the given value. When the verify fails, the test will continue execution, logging the failure. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
verifyEvalScriptNotContain(script, text)
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

## Verify Expression Contain

Verifies that the specified expression contains the given value. When the verify fails, the test will continue execution, logging the failure.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
verifyExpressionContain(expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the value to return
text | the value to match with the result

## Verify Expression Not Contain

Verifies that the specified expression not contain the given value. When the verify fails, the test will continue execution, logging the failure.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
verifyExpressionNotContain(expression, text)
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

## Verify Font Family Contain

Verifies that the font family of the specified element contains the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyFontFamilyContain(locator, text)
`

`
verifyFontFamilyContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Font Family Not Contain

Verifies that the font family of the specified element not contain the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyFontFamilyNotContain(locator, text)
`

`
verifyFontFamilyNotContain(parentLocator, locator, text)
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

## Verify Font Size Contain

Verifies that the font size of the specified element contains the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyFontSizeContain(locator, text)
`

`
verifyFontSizeContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Font Size Not Contain

Verifies that the font size of the specified element not contain the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyFontSizeNotContain(locator, text)
`

`
verifyFontSizeNotContain(parentLocator, locator, text)
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

## Verify Font Style Contain

Verifies that the font style of the specified element contains the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyFontStyleContain(locator, text)
`

`
verifyFontStyleContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Font Style Not Contain

Verifies that the font style of the specified element not contain the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyFontStyleNotContain(locator, text)
`

`
verifyFontStyleNotContain(parentLocator, locator, text)
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

## Verify Font Weight Contain

Verifies that the font weight of the specified element contains the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyFontWeightContain(locator, text)
`

`
verifyFontWeightContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Font Weight Not Contain

Verifies that the font weight of the specified element not contain the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyFontWeightNotContain(locator, text)
`

`
verifyFontWeightNotContain(parentLocator, locator, text)
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

## Verify Html Source Contain

Verifies that the entire HTML source between the opening and closing "html" tags contains the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyHtmlSourceContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Html Source Not Contain

Verifies that the entire HTML source between the opening and closing "html" tags not contain the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyHtmlSourceNotContain(text)
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

## Verify Location Contain

Verifies that the absolute URL of the current page contains the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyLocationContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Location Not Contain

Verifies that the absolute URL of the current page not contain the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyLocationNotContain(text)
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

## Verify Prompt Contain

Verifies that the message of a JavaScript question prompt dialog contains the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyPromptContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Prompt Not Contain

Verifies that the message of a JavaScript question prompt dialog not contain the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyPromptNotContain(text)
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

## Verify Selected Id Contain

Verifies that option element ID for selected option in the specified select element contains the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedIdContain(locator, text)
`

`
verifySelectedIdContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Id Not Contain

Verifies that option element ID for selected option in the specified select element not contain the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedIdNotContain(locator, text)
`

`
verifySelectedIdNotContain(parentLocator, locator, text)
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

## Verify Selected Index Contain

Verifies that option index (option number, starting at 0) for selected option in the specified select element contains the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedIndexContain(locator, text)
`

`
verifySelectedIndexContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Index Not Contain

Verifies that option index (option number, starting at 0) for selected option in the specified select element not contain the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedIndexNotContain(locator, text)
`

`
verifySelectedIndexNotContain(parentLocator, locator, text)
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

## Verify Selected Label Contain

Verifies that option label (visible text) for selected option in the specified select element contains the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedLabelContain(locator, text)
`

`
verifySelectedLabelContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Label Not Contain

Verifies that option label (visible text) for selected option in the specified select element not contain the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedLabelNotContain(locator, text)
`

`
verifySelectedLabelNotContain(parentLocator, locator, text)
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

## Verify Selected Value Contain

Verifies that option value (value attribute) for selected option in the specified select element contains the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedValueContain(locator, text)
`

`
verifySelectedValueContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Verify Selected Value Not Contain

Verifies that option value (value attribute) for selected option in the specified select element not contain the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifySelectedValueNotContain(locator, text)
`

`
verifySelectedValueNotContain(parentLocator, locator, text)
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

## Verify Table Contain

Verifies that the text from a cell of a table contains the given value. When the verify fails, the test will continue execution, logging the failure. The cellAddress syntax row.column, where row and column start at 0.

### Usage

`
verifyTableContain(locator, cellAddress, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator pointing to a table
cellAddress | a cell address, e.g. "1.4"
text | the value to match with the result

## Verify Table Not Contain

Verifies that the text from a cell of a table not contain the given value. When the verify fails, the test will continue execution, logging the failure. The cellAddress syntax row.column, where row and column start at 0.

### Usage

`
verifyTableNotContain(locator, cellAddress, text)
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

## Verify Text Alignment Contain

Verifies that the text alignment of the specified element contains the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTextAlignmentContain(locator, text)
`

`
verifyTextAlignmentContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Text Alignment Not Contain

Verifies that the text alignment of the specified element not contain the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTextAlignmentNotContain(locator, text)
`

`
verifyTextAlignmentNotContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Text Contain

Verifies that the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user contains the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTextContain(locator, text)
`

`
verifyTextContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
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

## Verify Text Decoration Contain

Verifies that the text decoration of the specified element contains the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTextDecorationContain(locator, text)
`

`
verifyTextDecorationContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator pointing to an element
text | the value to match with the result

## Verify Text Decoration Not Contain

Verifies that the text decoration of the specified element not contain the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTextDecorationNotContain(locator, text)
`

`
verifyTextDecorationNotContain(parentLocator, locator, text)
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

## Verify Text Not Contain

Verifies that the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user not contain the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTextNotContain(locator, text)
`

`
verifyTextNotContain(parentLocator, locator, text)
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

## Verify Title Contain

Verifies that the title of the current page contains the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTitleContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Title Not Contain

Verifies that the title of the current page not contain the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyTitleNotContain(text)
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

## Verify Value Contain

Verifies that the (whitespace-trimmed) value of an input field (or anything else with a value parameter) contains the given value. When the verify fails, the test will continue execution, logging the failure. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
verifyValueContain(locator, text)
`

`
verifyValueContain(parentLocator, locator, text)
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

## Verify Value Not Contain

Verifies that the (whitespace-trimmed) value of an input field (or anything else with a value parameter) not contain the given value. When the verify fails, the test will continue execution, logging the failure. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
verifyValueNotContain(locator, text)
`

`
verifyValueNotContain(parentLocator, locator, text)
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

## Verify Variable Contain

Verifies that the specified variable value contains the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyVariableContain(variable, text)
`

### Parameters

Parameter | Description
--------- | -----------
variable | the variable
text | the value to match with the result

## Verify Variable Not Contain

Verifies that the specified variable value not contain the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyVariableNotContain(variable, text)
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

## Wait For Alert Contain

Waits for the message of a JavaScript alert contains the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForAlertContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Alert Not Contain

Waits for the message of a JavaScript alert not contain the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForAlertNotContain(text)
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

## Wait For Attribute Contain

Waits for the value of the given attribute of the element contains the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. Will return the current value, even if this has been modified after the page has been loaded.

 <p>More exactly, this method will return the value of the property with the given name, if it exists. If it does not, then the value of the attribute with the given name is returned. If neither exists, null is returned.

 <p>The "style" attribute is converted as best can be to a text representation with a trailing semi-colon.

 <p>The following are deemed to be "boolean" attributes, and will return either "true" or null:

 <p>async, autofocus, autoplay, checked, compact, complete, controls, declare, defaultchecked, defaultselected, defer, disabled, draggable, ended, formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope, loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open, paused, pubdate, readonly, required, reversed, scoped, seamless, seeking, selected, truespeed, willvalidate

 <p>Finally, the following commonly mis-capitalized attribute/property names are evaluated as expected:

 <ul> <li>If the given name is "class", the "className" property is returned. <li>If the given name is "readonly", the "readOnly" property is returned. </ul>

 <i>Note:</i> The reason for this behavior is that users frequently confuse attributes and properties. If you need to do something more precise, e.g., refer to an attribute even when a property of the same name exists, then you should evaluate Javascript to obtain the result you desire.

### Usage

`
waitForAttributeContain(locator, name, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator
name | The name of the attribute.
text | the value to match with the result

## Wait For Attribute Not Contain

Waits for the value of the given attribute of the element not contain the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. Will return the current value, even if this has been modified after the page has been loaded.

 <p>More exactly, this method will return the value of the property with the given name, if it exists. If it does not, then the value of the attribute with the given name is returned. If neither exists, null is returned.

 <p>The "style" attribute is converted as best can be to a text representation with a trailing semi-colon.

 <p>The following are deemed to be "boolean" attributes, and will return either "true" or null:

 <p>async, autofocus, autoplay, checked, compact, complete, controls, declare, defaultchecked, defaultselected, defer, disabled, draggable, ended, formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope, loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open, paused, pubdate, readonly, required, reversed, scoped, seamless, seeking, selected, truespeed, willvalidate

 <p>Finally, the following commonly mis-capitalized attribute/property names are evaluated as expected:

 <ul> <li>If the given name is "class", the "className" property is returned. <li>If the given name is "readonly", the "readOnly" property is returned. </ul>

 <i>Note:</i> The reason for this behavior is that users frequently confuse attributes and properties. If you need to do something more precise, e.g., refer to an attribute even when a property of the same name exists, then you should evaluate Javascript to obtain the result you desire.

### Usage

`
waitForAttributeNotContain(locator, name, text)
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

## Wait For Body Text Contain

Waits for the entire text of the page contains the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForBodyTextContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Body Text Not Contain

Waits for the entire text of the page not contain the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForBodyTextNotContain(text)
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

## Wait For Confirmation Contain

Waits for the message of a JavaScript confirmation dialog contains the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForConfirmationContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Confirmation Not Contain

Waits for the message of a JavaScript confirmation dialog not contain the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForConfirmationNotContain(text)
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

## Wait For Cookie By Name Contain

Waits for the value of the cookie with the specified name contains the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForCookieByNameContain(name, text)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie
text | the value to match with the result

## Wait For Cookie By Name Not Contain

Waits for the value of the cookie with the specified name not contain the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForCookieByNameNotContain(name, text)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie
text | the value to match with the result

## Wait For Cookie Contain

Waits for all cookies of the current page under test contains the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForCookieContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Cookie Not Contain

Waits for all cookies of the current page under test not contain the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForCookieNotContain(text)
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

## Wait For Eval Script Contain

Waits for the result of evaluating the specified JavaScript snippet contains the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
waitForEvalScriptContain(script, text)
`

### Parameters

Parameter | Description
--------- | -----------
script | the JavaScript snippet to run
text | the value to match with the result

## Wait For Eval Script Not Contain

Waits for the result of evaluating the specified JavaScript snippet not contain the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. The snippet may have multiple lines, but only the result of the last line will be returned.

 <p> Note that, by default, the snippet will run in the context of the "selenium" object itself, so <code>this</code> will refer to the Selenium object. Use <code>window</code> to refer to the window of your application, e.g. <code>window.document.getElementById('foo')</code> </p> <p> If you need to use a locator to refer to a single element in your application page, you can use <code>this.browserbot.findElement("id=foo")</code> where "id=foo" is your locator. </p>

### Usage

`
waitForEvalScriptNotContain(script, text)
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

## Wait For Expression Contain

Waits for the specified expression contains the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
waitForExpressionContain(expression, text)
`

### Parameters

Parameter | Description
--------- | -----------
expression | the value to return
text | the value to match with the result

## Wait For Expression Not Contain

Waits for the specified expression not contain the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

 <p> This is useful because of JavaScript preprocessing. It is used to generate commands like assertExpression and waitForExpression. </p>

### Usage

`
waitForExpressionNotContain(expression, text)
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

## Wait For Html Source Contain

Waits for the entire HTML source between the opening and closing "html" tags contains the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForHtmlSourceContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Html Source Not Contain

Waits for the entire HTML source between the opening and closing "html" tags not contain the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForHtmlSourceNotContain(text)
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

## Wait For Location Contain

Waits for the absolute URL of the current page contains the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForLocationContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Location Not Contain

Waits for the absolute URL of the current page not contain the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForLocationNotContain(text)
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

## Wait For Prompt Contain

Waits for the message of a JavaScript question prompt dialog contains the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForPromptContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Prompt Not Contain

Waits for the message of a JavaScript question prompt dialog not contain the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForPromptNotContain(text)
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

## Wait For Selected Id Contain

Waits for option element ID for selected option in the specified select element contains the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForSelectedIdContain(locator, text)
`

`
waitForSelectedIdContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Wait For Selected Id Not Contain

Waits for option element ID for selected option in the specified select element not contain the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForSelectedIdNotContain(locator, text)
`

`
waitForSelectedIdNotContain(parentLocator, locator, text)
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

## Wait For Selected Index Contain

Waits for option index (option number, starting at 0) for selected option in the specified select element contains the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForSelectedIndexContain(locator, text)
`

`
waitForSelectedIndexContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Wait For Selected Index Not Contain

Waits for option index (option number, starting at 0) for selected option in the specified select element not contain the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForSelectedIndexNotContain(locator, text)
`

`
waitForSelectedIndexNotContain(parentLocator, locator, text)
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

## Wait For Selected Label Contain

Waits for option label (visible text) for selected option in the specified select element contains the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForSelectedLabelContain(locator, text)
`

`
waitForSelectedLabelContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Wait For Selected Label Not Contain

Waits for option label (visible text) for selected option in the specified select element not contain the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForSelectedLabelNotContain(locator, text)
`

`
waitForSelectedLabelNotContain(parentLocator, locator, text)
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

## Wait For Selected Value Contain

Waits for option value (value attribute) for selected option in the specified select element contains the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForSelectedValueContain(locator, text)
`

`
waitForSelectedValueContain(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator identifying a drop-down menu
text | the value to match with the result

## Wait For Selected Value Not Contain

Waits for option value (value attribute) for selected option in the specified select element not contain the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForSelectedValueNotContain(locator, text)
`

`
waitForSelectedValueNotContain(parentLocator, locator, text)
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

## Wait For Table Contain

Waits for the text from a cell of a table contains the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. The cellAddress syntax row.column, where row and column start at 0.

### Usage

`
waitForTableContain(locator, cellAddress, text)
`

### Parameters

Parameter | Description
--------- | -----------
locator | an element locator pointing to a table
cellAddress | a cell address, e.g. "1.4"
text | the value to match with the result

## Wait For Table Not Contain

Waits for the text from a cell of a table not contain the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. The cellAddress syntax row.column, where row and column start at 0.

### Usage

`
waitForTableNotContain(locator, cellAddress, text)
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

## Wait For Text Contain

Waits for the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user contains the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForTextContain(locator, text)
`

`
waitForTextContain(parentLocator, locator, text)
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

## Wait For Text Not Contain

Waits for the text of an element. This works for any element that contains text. This command uses either the textContent (Mozilla-like browsers) or the innerText (IE-like browsers) of the element, which is the rendered text shown to the user not contain the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForTextNotContain(locator, text)
`

`
waitForTextNotContain(parentLocator, locator, text)
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

## Wait For Title Contain

Waits for the title of the current page contains the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForTitleContain(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Title Not Contain

Waits for the title of the current page not contain the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForTitleNotContain(text)
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

## Wait For Value Contain

Waits for the (whitespace-trimmed) value of an input field (or anything else with a value parameter) contains the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
waitForValueContain(locator, text)
`

`
waitForValueContain(parentLocator, locator, text)
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

## Wait For Value Not Contain

Waits for the (whitespace-trimmed) value of an input field (or anything else with a value parameter) not contain the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting. For checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.

### Usage

`
waitForValueNotContain(locator, text)
`

`
waitForValueNotContain(parentLocator, locator, text)
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

