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
87 | Assert Enabled | assertEnabled | locator |  | 
88 | Assert Enabled | assertEnabled | parentLocator | locator | 
89 | Assert Eval | assertEval | expression | text | 
90 | Assert Eval Script | assertEvalScript | script | text | 
91 | Assert Eval Script Match | assertEvalScriptMatch | script | text | 
92 | Assert Eval Script Not Match | assertEvalScriptNotMatch | script | text | 
93 | Assert Exists In Database | assertExistsInDatabase | sql |  | 
94 | Assert Expression | assertExpression | expression | text | 
95 | Assert Expression Match | assertExpressionMatch | expression | text | 
96 | Assert Expression Not Match | assertExpressionNotMatch | expression | text | 
97 | Assert File Contain Line | assertFileContainLine | filePattern | charset | text
98 | Assert File Downloaded | assertFileDownloaded | filePattern |  | 
99 | Assert File First Line | assertFileFirstLine | filePattern | charset | text
100 | Assert Font Family | assertFontFamily | locator | text | 
101 | Assert Font Family | assertFontFamily | parentLocator | locator | text
102 | Assert Font Family Match | assertFontFamilyMatch | locator | text | 
103 | Assert Font Family Match | assertFontFamilyMatch | parentLocator | locator | text
104 | Assert Font Family Not Match | assertFontFamilyNotMatch | locator | text | 
105 | Assert Font Family Not Match | assertFontFamilyNotMatch | parentLocator | locator | text
106 | Assert Font Size | assertFontSize | locator | text | 
107 | Assert Font Size | assertFontSize | parentLocator | locator | text
108 | Assert Font Size Match | assertFontSizeMatch | locator | text | 
109 | Assert Font Size Match | assertFontSizeMatch | parentLocator | locator | text
110 | Assert Font Size Not Match | assertFontSizeNotMatch | locator | text | 
111 | Assert Font Size Not Match | assertFontSizeNotMatch | parentLocator | locator | text
112 | Assert Font Style | assertFontStyle | locator | text | 
113 | Assert Font Style | assertFontStyle | parentLocator | locator | text
114 | Assert Font Style Match | assertFontStyleMatch | locator | text | 
115 | Assert Font Style Match | assertFontStyleMatch | parentLocator | locator | text
116 | Assert Font Style Not Match | assertFontStyleNotMatch | locator | text | 
117 | Assert Font Style Not Match | assertFontStyleNotMatch | parentLocator | locator | text
118 | Assert Font Weight | assertFontWeight | locator | text | 
119 | Assert Font Weight | assertFontWeight | parentLocator | locator | text
120 | Assert Font Weight Match | assertFontWeightMatch | locator | text | 
121 | Assert Font Weight Match | assertFontWeightMatch | parentLocator | locator | text
122 | Assert Font Weight Not Match | assertFontWeightNotMatch | locator | text | 
123 | Assert Font Weight Not Match | assertFontWeightNotMatch | parentLocator | locator | text
124 | Assert Integer List Order Asc | assertIntegerListOrderAsc | locator |  | 
125 | Assert Integer List Order Asc | assertIntegerListOrderAsc | parentLocator | locator | 
126 | Assert Integer List Order Desc | assertIntegerListOrderDesc | locator |  | 
127 | Assert Integer List Order Desc | assertIntegerListOrderDesc | parentLocator | locator | 
128 | Assert List Contain | assertListContain | variable | text | 
129 | Assert List Not Contain | assertListNotContain | variable | text | 
130 | Assert List Order Asc | assertListOrderAsc | variable |  | 
131 | Assert List Order Desc | assertListOrderDesc | variable |  | 
132 | Assert Location | assertLocation | text |  | 
133 | Assert Location Match | assertLocationMatch | text |  | 
134 | Assert Location Not Match | assertLocationNotMatch | text |  | 
135 | Assert Log Contain Line | assertLogContainLine | text |  | 
136 | Assert Log Not Contain Line | assertLogNotContainLine | text |  | 
137 | Assert Not Alert | assertNotAlert | text |  | 
138 | Assert Not All Buttons | assertNotAllButtons | text |  | 
139 | Assert Not All Fields | assertNotAllFields | text |  | 
140 | Assert Not All Links | assertNotAllLinks | text |  | 
141 | Assert Not All Window Names | assertNotAllWindowNames | text |  | 
142 | Assert Not All Window Titles | assertNotAllWindowTitles | text |  | 
143 | Assert Not Attribute | assertNotAttribute | locator | name | text
144 | Assert Not Attribute From All Windows | assertNotAttributeFromAllWindows | attributeName | text | 
145 | Assert Not Background Color | assertNotBackgroundColor | locator | text | 
146 | Assert Not Background Color | assertNotBackgroundColor | parentLocator | locator | text
147 | Assert Not Body Text | assertNotBodyText | text |  | 
148 | Assert Not Border Color | assertNotBorderColor | locator | text | 
149 | Assert Not Border Color | assertNotBorderColor | parentLocator | locator | text
150 | Assert Not Checked | assertNotChecked | locator |  | 
151 | Assert Not Checked | assertNotChecked | parentLocator | locator | 
152 | Assert Not Color | assertNotColor | locator | text | 
153 | Assert Not Color | assertNotColor | parentLocator | locator | text
154 | Assert Not Confirmation | assertNotConfirmation | text |  | 
155 | Assert Not Cookie | assertNotCookie | text |  | 
156 | Assert Not Cookie By Name | assertNotCookieByName | name | text | 
157 | Assert Not Css Count | assertNotCssCount | css | text | 
158 | Assert Not Cursor Position | assertNotCursorPosition | locator | text | 
159 | Assert Not Cursor Position | assertNotCursorPosition | parentLocator | locator | text
160 | Assert Not Editable | assertNotEditable | locator |  | 
161 | Assert Not Editable | assertNotEditable | parentLocator | locator | 
162 | Assert Not Element Height | assertNotElementHeight | locator | text | 
163 | Assert Not Element Height | assertNotElementHeight | parentLocator | locator | text
164 | Assert Not Element Index | assertNotElementIndex | locator | text | 
165 | Assert Not Element Index | assertNotElementIndex | parentLocator | locator | text
166 | Assert Not Element Position Left | assertNotElementPositionLeft | locator | text | 
167 | Assert Not Element Position Left | assertNotElementPositionLeft | parentLocator | locator | text
168 | Assert Not Element Position Top | assertNotElementPositionTop | locator | text | 
169 | Assert Not Element Position Top | assertNotElementPositionTop | parentLocator | locator | text
170 | Assert Not Element Width | assertNotElementWidth | locator | text | 
171 | Assert Not Element Width | assertNotElementWidth | parentLocator | locator | text
172 | Assert Not Enabled | assertNotEnabled | locator |  | 
173 | Assert Not Enabled | assertNotEnabled | parentLocator | locator | 
174 | Assert Not Eval | assertNotEval | expression | text | 
175 | Assert Not Eval Script | assertNotEvalScript | script | text | 
176 | Assert Not Exists In Database | assertNotExistsInDatabase | sql |  | 
177 | Assert Not Expression | assertNotExpression | expression | text | 
178 | Assert Not File Downloaded | assertNotFileDownloaded | filePattern |  | 
179 | Assert Not Font Family | assertNotFontFamily | locator | text | 
180 | Assert Not Font Family | assertNotFontFamily | parentLocator | locator | text
181 | Assert Not Font Size | assertNotFontSize | locator | text | 
182 | Assert Not Font Size | assertNotFontSize | parentLocator | locator | text
183 | Assert Not Font Style | assertNotFontStyle | locator | text | 
184 | Assert Not Font Style | assertNotFontStyle | parentLocator | locator | text
185 | Assert Not Font Weight | assertNotFontWeight | locator | text | 
186 | Assert Not Font Weight | assertNotFontWeight | parentLocator | locator | text
187 | Assert Not Location | assertNotLocation | text |  | 
188 | Assert Not Ordered | assertNotOrdered | firstLocator | secondLocator | 
189 | Assert Not Page Source | assertNotPageSource | text |  | 
190 | Assert Not Prompt | assertNotPrompt | text |  | 
191 | Assert Not QR | assertNotQR | locator | text | 
192 | Assert Not QR | assertNotQR | parentLocator | locator | text
193 | Assert Not Select Options | assertNotSelectOptions | locator | text | 
194 | Assert Not Select Options | assertNotSelectOptions | parentLocator | locator | text
195 | Assert Not Selected Id | assertNotSelectedId | locator | text | 
196 | Assert Not Selected Id | assertNotSelectedId | parentLocator | locator | text
197 | Assert Not Selected Ids | assertNotSelectedIds | locator | text | 
198 | Assert Not Selected Ids | assertNotSelectedIds | parentLocator | locator | text
199 | Assert Not Selected Index | assertNotSelectedIndex | locator | text | 
200 | Assert Not Selected Index | assertNotSelectedIndex | parentLocator | locator | text
201 | Assert Not Selected Indexes | assertNotSelectedIndexes | locator | text | 
202 | Assert Not Selected Indexes | assertNotSelectedIndexes | parentLocator | locator | text
203 | Assert Not Selected Label | assertNotSelectedLabel | locator | text | 
204 | Assert Not Selected Label | assertNotSelectedLabel | parentLocator | locator | text
205 | Assert Not Selected Labels | assertNotSelectedLabels | locator | text | 
206 | Assert Not Selected Labels | assertNotSelectedLabels | parentLocator | locator | text
207 | Assert Not Selected Value | assertNotSelectedValue | locator | text | 
208 | Assert Not Selected Value | assertNotSelectedValue | parentLocator | locator | text
209 | Assert Not Selected Values | assertNotSelectedValues | locator | text | 
210 | Assert Not Selected Values | assertNotSelectedValues | parentLocator | locator | text
211 | Assert Not Something Selected | assertNotSomethingSelected | locator |  | 
212 | Assert Not Something Selected | assertNotSomethingSelected | parentLocator | locator | 
213 | Assert Not Table | assertNotTable | locator | cellAddress | text
214 | Assert Not Tag Name | assertNotTagName | locator | text | 
215 | Assert Not Tag Name | assertNotTagName | parentLocator | locator | text
216 | Assert Not Text | assertNotText | locator | text | 
217 | Assert Not Text | assertNotText | parentLocator | locator | text
218 | Assert Not Text Alignment | assertNotTextAlignment | locator | text | 
219 | Assert Not Text Alignment | assertNotTextAlignment | parentLocator | locator | text
220 | Assert Not Text Decoration | assertNotTextDecoration | locator | text | 
221 | Assert Not Text Decoration | assertNotTextDecoration | parentLocator | locator | text
222 | Assert Not Text Empty | assertNotTextEmpty | locator |  | 
223 | Assert Not Text Empty | assertNotTextEmpty | parentLocator | locator | 
224 | Assert Not Title | assertNotTitle | text |  | 
225 | Assert Not Value | assertNotValue | locator | text | 
226 | Assert Not Value | assertNotValue | parentLocator | locator | text
227 | Assert Not Value Empty | assertNotValueEmpty | locator |  | 
228 | Assert Not Value Empty | assertNotValueEmpty | parentLocator | locator | 
229 | Assert Not Variable | assertNotVariable | variable | text | 
230 | Assert Not Visible | assertNotVisible | locator |  | 
231 | Assert Not Visible | assertNotVisible | parentLocator | locator | 
232 | Assert Not Xpath Count | assertNotXpathCount | xpath | text | 
233 | Assert Ordered | assertOrdered | firstLocator | secondLocator | 
234 | Assert Page Source | assertPageSource | text |  | 
235 | Assert Page Source Match | assertPageSourceMatch | text |  | 
236 | Assert Page Source Not Match | assertPageSourceNotMatch | text |  | 
237 | Assert Prompt | assertPrompt | text |  | 
238 | Assert Prompt Match | assertPromptMatch | text |  | 
239 | Assert Prompt Not Match | assertPromptNotMatch | text |  | 
240 | Assert Prompt Not Present | assertPromptNotPresent |  |  | 
241 | Assert Prompt Present | assertPromptPresent |  |  | 
242 | Assert QR | assertQR | locator | text | 
243 | Assert QR | assertQR | parentLocator | locator | text
244 | Assert QR Match | assertQRMatch | locator | text | 
245 | Assert QR Match | assertQRMatch | parentLocator | locator | text
246 | Assert QR Not Match | assertQRNotMatch | locator | text | 
247 | Assert QR Not Match | assertQRNotMatch | parentLocator | locator | text
248 | Assert Row Count | assertRowCount | sql | count | 
249 | Assert Row Count Greater Than | assertRowCountGreaterThan | sql | count | 
250 | Assert Row Count Less Than | assertRowCountLessThan | sql | count | 
251 | Assert Select Options | assertSelectOptions | locator | text | 
252 | Assert Select Options | assertSelectOptions | parentLocator | locator | text
253 | Assert Select Options Match | assertSelectOptionsMatch | locator | text | 
254 | Assert Select Options Match | assertSelectOptionsMatch | parentLocator | locator | text
255 | Assert Select Options Not Match | assertSelectOptionsNotMatch | locator | text | 
256 | Assert Select Options Not Match | assertSelectOptionsNotMatch | parentLocator | locator | text
257 | Assert Selected Id | assertSelectedId | locator | text | 
258 | Assert Selected Id | assertSelectedId | parentLocator | locator | text
259 | Assert Selected Id Match | assertSelectedIdMatch | locator | text | 
260 | Assert Selected Id Match | assertSelectedIdMatch | parentLocator | locator | text
261 | Assert Selected Id Not Match | assertSelectedIdNotMatch | locator | text | 
262 | Assert Selected Id Not Match | assertSelectedIdNotMatch | parentLocator | locator | text
263 | Assert Selected Ids | assertSelectedIds | locator | text | 
264 | Assert Selected Ids | assertSelectedIds | parentLocator | locator | text
265 | Assert Selected Ids Match | assertSelectedIdsMatch | locator | text | 
266 | Assert Selected Ids Match | assertSelectedIdsMatch | parentLocator | locator | text
267 | Assert Selected Ids Not Match | assertSelectedIdsNotMatch | locator | text | 
268 | Assert Selected Ids Not Match | assertSelectedIdsNotMatch | parentLocator | locator | text
269 | Assert Selected Index | assertSelectedIndex | locator | text | 
270 | Assert Selected Index | assertSelectedIndex | parentLocator | locator | text
271 | Assert Selected Index Match | assertSelectedIndexMatch | locator | text | 
272 | Assert Selected Index Match | assertSelectedIndexMatch | parentLocator | locator | text
273 | Assert Selected Index Not Match | assertSelectedIndexNotMatch | locator | text | 
274 | Assert Selected Index Not Match | assertSelectedIndexNotMatch | parentLocator | locator | text
275 | Assert Selected Indexes | assertSelectedIndexes | locator | text | 
276 | Assert Selected Indexes | assertSelectedIndexes | parentLocator | locator | text
277 | Assert Selected Indexes Match | assertSelectedIndexesMatch | locator | text | 
278 | Assert Selected Indexes Match | assertSelectedIndexesMatch | parentLocator | locator | text
279 | Assert Selected Indexes Not Match | assertSelectedIndexesNotMatch | locator | text | 
280 | Assert Selected Indexes Not Match | assertSelectedIndexesNotMatch | parentLocator | locator | text
281 | Assert Selected Label | assertSelectedLabel | locator | text | 
282 | Assert Selected Label | assertSelectedLabel | parentLocator | locator | text
283 | Assert Selected Label Match | assertSelectedLabelMatch | locator | text | 
284 | Assert Selected Label Match | assertSelectedLabelMatch | parentLocator | locator | text
285 | Assert Selected Label Not Match | assertSelectedLabelNotMatch | locator | text | 
286 | Assert Selected Label Not Match | assertSelectedLabelNotMatch | parentLocator | locator | text
287 | Assert Selected Labels | assertSelectedLabels | locator | text | 
288 | Assert Selected Labels | assertSelectedLabels | parentLocator | locator | text
289 | Assert Selected Labels Match | assertSelectedLabelsMatch | locator | text | 
290 | Assert Selected Labels Match | assertSelectedLabelsMatch | parentLocator | locator | text
291 | Assert Selected Labels Not Match | assertSelectedLabelsNotMatch | locator | text | 
292 | Assert Selected Labels Not Match | assertSelectedLabelsNotMatch | parentLocator | locator | text
293 | Assert Selected Value | assertSelectedValue | locator | text | 
294 | Assert Selected Value | assertSelectedValue | parentLocator | locator | text
295 | Assert Selected Value Match | assertSelectedValueMatch | locator | text | 
296 | Assert Selected Value Match | assertSelectedValueMatch | parentLocator | locator | text
297 | Assert Selected Value Not Match | assertSelectedValueNotMatch | locator | text | 
298 | Assert Selected Value Not Match | assertSelectedValueNotMatch | parentLocator | locator | text
299 | Assert Selected Values | assertSelectedValues | locator | text | 
300 | Assert Selected Values | assertSelectedValues | parentLocator | locator | text
301 | Assert Selected Values Match | assertSelectedValuesMatch | locator | text | 
302 | Assert Selected Values Match | assertSelectedValuesMatch | parentLocator | locator | text
303 | Assert Selected Values Not Match | assertSelectedValuesNotMatch | locator | text | 
304 | Assert Selected Values Not Match | assertSelectedValuesNotMatch | parentLocator | locator | text
305 | Assert Something Selected | assertSomethingSelected | locator |  | 
306 | Assert Something Selected | assertSomethingSelected | parentLocator | locator | 
307 | Assert Table | assertTable | locator | cellAddress | text
308 | Assert Table Match | assertTableMatch | locator | cellAddress | text
309 | Assert Table Not Match | assertTableNotMatch | locator | cellAddress | text
310 | Assert Tag Name | assertTagName | locator | text | 
311 | Assert Tag Name | assertTagName | parentLocator | locator | text
312 | Assert Tag Name Match | assertTagNameMatch | locator | text | 
313 | Assert Tag Name Match | assertTagNameMatch | parentLocator | locator | text
314 | Assert Tag Name Not Match | assertTagNameNotMatch | locator | text | 
315 | Assert Tag Name Not Match | assertTagNameNotMatch | parentLocator | locator | text
316 | Assert Text | assertText | locator | text | 
317 | Assert Text | assertText | parentLocator | locator | text
318 | Assert Text Alignment | assertTextAlignment | locator | text | 
319 | Assert Text Alignment | assertTextAlignment | parentLocator | locator | text
320 | Assert Text Alignment Match | assertTextAlignmentMatch | locator | text | 
321 | Assert Text Alignment Match | assertTextAlignmentMatch | parentLocator | locator | text
322 | Assert Text Alignment Not Match | assertTextAlignmentNotMatch | locator | text | 
323 | Assert Text Alignment Not Match | assertTextAlignmentNotMatch | parentLocator | locator | text
324 | Assert Text Decoration | assertTextDecoration | locator | text | 
325 | Assert Text Decoration | assertTextDecoration | parentLocator | locator | text
326 | Assert Text Decoration Match | assertTextDecorationMatch | locator | text | 
327 | Assert Text Decoration Match | assertTextDecorationMatch | parentLocator | locator | text
328 | Assert Text Decoration Not Match | assertTextDecorationNotMatch | locator | text | 
329 | Assert Text Decoration Not Match | assertTextDecorationNotMatch | parentLocator | locator | text
330 | Assert Text Empty | assertTextEmpty | locator |  | 
331 | Assert Text Empty | assertTextEmpty | parentLocator | locator | 
332 | Assert Text List Order Asc | assertTextListOrderAsc | locator |  | 
333 | Assert Text List Order Asc | assertTextListOrderAsc | parentLocator | locator | 
334 | Assert Text List Order Desc | assertTextListOrderDesc | locator |  | 
335 | Assert Text List Order Desc | assertTextListOrderDesc | parentLocator | locator | 
336 | Assert Text Match | assertTextMatch | locator | text | 
337 | Assert Text Match | assertTextMatch | parentLocator | locator | text
338 | Assert Text Not Match | assertTextNotMatch | locator | text | 
339 | Assert Text Not Match | assertTextNotMatch | parentLocator | locator | text
340 | Assert Text Not Present | assertTextNotPresent | pattern |  | 
341 | Assert Text Present | assertTextPresent | pattern |  | 
342 | Assert Title | assertTitle | text |  | 
343 | Assert Title Match | assertTitleMatch | text |  | 
344 | Assert Title Not Match | assertTitleNotMatch | text |  | 
345 | Assert Value | assertValue | locator | text | 
346 | Assert Value | assertValue | parentLocator | locator | text
347 | Assert Value Empty | assertValueEmpty | locator |  | 
348 | Assert Value Empty | assertValueEmpty | parentLocator | locator | 
349 | Assert Value Match | assertValueMatch | locator | text | 
350 | Assert Value Match | assertValueMatch | parentLocator | locator | text
351 | Assert Value Not Match | assertValueNotMatch | locator | text | 
352 | Assert Value Not Match | assertValueNotMatch | parentLocator | locator | text
353 | Assert Variable | assertVariable | variable | text | 
354 | Assert Visible | assertVisible | locator |  | 
355 | Assert Visible | assertVisible | parentLocator | locator | 
356 | Assert Xpath Count | assertXpathCount | xpath | text | 
357 | Assign Id | assignId | locator | identifier | 
358 | Assign Id | assignId | parentLocator | locator | identifier
359 | Attach File | attachFile | locator | filePath | 
360 | Attach File | attachFile | parentLocator | locator | filePath
361 | Blur | blur | locator |  | 
362 | Blur | blur | parentLocator | locator | 
363 | Capture Element Screenshot | captureElementScreenshot | locator |  | 
364 | Capture Element Screenshot | captureElementScreenshot | parentLocator | locator | 
365 | Capture Screenshot | captureScreenshot |  |  | 
366 | Check | check | locator |  | 
367 | Check | check | parentLocator | locator | 
368 | Choose Cancel Confirmation | chooseCancelConfirmation |  |  | 
369 | Choose Cancel Prompt | chooseCancelPrompt |  |  | 
370 | Choose Ok Alert | chooseOkAlert |  |  | 
371 | Choose Ok Confirmation | chooseOkConfirmation |  |  | 
372 | Clear | clear | locator |  | 
373 | Clear | clear | parentLocator | locator | 
374 | Clear Log | clearLog |  |  | 
375 | Click | click | locator |  | 
376 | Click | click | parentLocator | locator | 
377 | Click At | clickAt | locator | coordString | 
378 | Click At | clickAt | parentLocator | locator | coordString
379 | Click Button | clickButton | indexOrText |  | 
380 | Close | close |  |  | 
381 | Context Menu | contextMenu | locator |  | 
382 | Context Menu | contextMenu | parentLocator | locator | 
383 | Context Menu At | contextMenuAt | locator | coordString | 
384 | Context Menu At | contextMenuAt | parentLocator | locator | coordString
385 | Control Key Down | controlKeyDown |  |  | 
386 | Control Key Up | controlKeyUp |  |  | 
387 | Create Cookie | createCookie | nameValuePair |  | 
388 | Create Cookie | createCookie | nameValuePair | optionsString | 
389 | Delete All Visible Cookies | deleteAllVisibleCookies |  |  | 
390 | Delete Cookie | deleteCookie | name |  | 
391 | Delete Downloaded File | deleteDownloadedFile | filePattern |  | 
392 | Deselect Pop Up | deselectPopUp |  |  | 
393 | Double Click | doubleClick | locator |  | 
394 | Double Click | doubleClick | parentLocator | locator | 
395 | Double Click At | doubleClickAt | locator | coordString | 
396 | Double Click At | doubleClickAt | parentLocator | locator | coordString
397 | Drag And Drop | dragAndDrop | locator | movementsString | 
398 | Drag And Drop | dragAndDrop | parentLocator | locator | movementsString
399 | Drag And Drop To Object | dragAndDropToObject | toBeDraggedObjectLocator | dragDestinationObjectLocator | 
400 | Echo | echo | message |  | 
401 | Execute | execute | action |  | 
402 | Execute Each | executeEach | action | locator | variable
403 | Execute If Alert | executeIfAlert | action | text | 
404 | Execute If Alert Match | executeIfAlertMatch | action | text | 
405 | Execute If Alert Not Match | executeIfAlertNotMatch | action | text | 
406 | Execute If Alert Not Present | executeIfAlertNotPresent | action |  | 
407 | Execute If Alert Present | executeIfAlertPresent | action |  | 
408 | Execute If Body Text | executeIfBodyText | action | text | 
409 | Execute If Body Text Match | executeIfBodyTextMatch | action | text | 
410 | Execute If Body Text Not Match | executeIfBodyTextNotMatch | action | text | 
411 | Execute If Checked | executeIfChecked | action | locator | 
412 | Execute If Checked | executeIfChecked | action | parentLocator | locator
413 | Execute If Confirmation | executeIfConfirmation | action | text | 
414 | Execute If Confirmation Match | executeIfConfirmationMatch | action | text | 
415 | Execute If Confirmation Not Match | executeIfConfirmationNotMatch | action | text | 
416 | Execute If Confirmation Not Present | executeIfConfirmationNotPresent | action |  | 
417 | Execute If Confirmation Present | executeIfConfirmationPresent | action |  | 
418 | Execute If Cookie | executeIfCookie | action | text | 
419 | Execute If Cookie By Name | executeIfCookieByName | action | name | text
420 | Execute If Cookie By Name Match | executeIfCookieByNameMatch | action | name | text
421 | Execute If Cookie By Name Not Match | executeIfCookieByNameNotMatch | action | name | text
422 | Execute If Cookie Match | executeIfCookieMatch | action | text | 
423 | Execute If Cookie Not Match | executeIfCookieNotMatch | action | text | 
424 | Execute If Cookie Not Present | executeIfCookieNotPresent | action | name | 
425 | Execute If Cookie Present | executeIfCookiePresent | action | name | 
426 | Execute If Editable | executeIfEditable | action | locator | 
427 | Execute If Editable | executeIfEditable | action | parentLocator | locator
428 | Execute If Element Not Present | executeIfElementNotPresent | action | locator | 
429 | Execute If Element Not Present | executeIfElementNotPresent | action | parentLocator | locator
430 | Execute If Element Present | executeIfElementPresent | action | locator | 
431 | Execute If Element Present | executeIfElementPresent | action | parentLocator | locator
432 | Execute If Enabled | executeIfEnabled | action | locator | 
433 | Execute If Enabled | executeIfEnabled | action | parentLocator | locator
434 | Execute If Eval | executeIfEval | action | expression | text
435 | Execute If Eval Script | executeIfEvalScript | action | script | text
436 | Execute If Eval Script Match | executeIfEvalScriptMatch | action | script | text
437 | Execute If Eval Script Not Match | executeIfEvalScriptNotMatch | action | script | text
438 | Execute If Exists In Database | executeIfExistsInDatabase | action | sql | 
439 | Execute If Expression | executeIfExpression | action | expression | text
440 | Execute If Expression Match | executeIfExpressionMatch | action | expression | text
441 | Execute If Expression Not Match | executeIfExpressionNotMatch | action | expression | text
442 | Execute If File Downloaded | executeIfFileDownloaded | action | filePattern | 
443 | Execute If List Contain | executeIfListContain | action | variable | text
444 | Execute If List Not Contain | executeIfListNotContain | action | variable | text
445 | Execute If Location | executeIfLocation | action | text | 
446 | Execute If Location Match | executeIfLocationMatch | action | text | 
447 | Execute If Location Not Match | executeIfLocationNotMatch | action | text | 
448 | Execute If Not Alert | executeIfNotAlert | action | text | 
449 | Execute If Not Body Text | executeIfNotBodyText | action | text | 
450 | Execute If Not Checked | executeIfNotChecked | action | locator | 
451 | Execute If Not Checked | executeIfNotChecked | action | parentLocator | locator
452 | Execute If Not Confirmation | executeIfNotConfirmation | action | text | 
453 | Execute If Not Cookie | executeIfNotCookie | action | text | 
454 | Execute If Not Cookie By Name | executeIfNotCookieByName | action | name | text
455 | Execute If Not Editable | executeIfNotEditable | action | locator | 
456 | Execute If Not Editable | executeIfNotEditable | action | parentLocator | locator
457 | Execute If Not Enabled | executeIfNotEnabled | action | locator | 
458 | Execute If Not Enabled | executeIfNotEnabled | action | parentLocator | locator
459 | Execute If Not Eval | executeIfNotEval | action | expression | text
460 | Execute If Not Eval Script | executeIfNotEvalScript | action | script | text
461 | Execute If Not Exists In Database | executeIfNotExistsInDatabase | action | sql | 
462 | Execute If Not Expression | executeIfNotExpression | action | expression | text
463 | Execute If Not File Downloaded | executeIfNotFileDownloaded | action | filePattern | 
464 | Execute If Not Location | executeIfNotLocation | action | text | 
465 | Execute If Not Page Source | executeIfNotPageSource | action | text | 
466 | Execute If Not Prompt | executeIfNotPrompt | action | text | 
467 | Execute If Not QR | executeIfNotQR | action | locator | text
468 | Execute If Not Selected Id | executeIfNotSelectedId | action | locator | text
469 | Execute If Not Selected Index | executeIfNotSelectedIndex | action | locator | text
470 | Execute If Not Selected Label | executeIfNotSelectedLabel | action | locator | text
471 | Execute If Not Selected Value | executeIfNotSelectedValue | action | locator | text
472 | Execute If Not Something Selected | executeIfNotSomethingSelected | action | locator | 
473 | Execute If Not Something Selected | executeIfNotSomethingSelected | action | parentLocator | locator
474 | Execute If Not Tag Name | executeIfNotTagName | action | locator | text
475 | Execute If Not Text | executeIfNotText | action | locator | text
476 | Execute If Not Text Empty | executeIfNotTextEmpty | action | locator | 
477 | Execute If Not Text Empty | executeIfNotTextEmpty | action | parentLocator | locator
478 | Execute If Not Title | executeIfNotTitle | action | text | 
479 | Execute If Not Value | executeIfNotValue | action | locator | text
480 | Execute If Not Value Empty | executeIfNotValueEmpty | action | locator | 
481 | Execute If Not Value Empty | executeIfNotValueEmpty | action | parentLocator | locator
482 | Execute If Not Variable | executeIfNotVariable | action | variable | text
483 | Execute If Not Visible | executeIfNotVisible | action | locator | 
484 | Execute If Not Visible | executeIfNotVisible | action | parentLocator | locator
485 | Execute If Page Source | executeIfPageSource | action | text | 
486 | Execute If Page Source Match | executeIfPageSourceMatch | action | text | 
487 | Execute If Page Source Not Match | executeIfPageSourceNotMatch | action | text | 
488 | Execute If Prompt | executeIfPrompt | action | text | 
489 | Execute If Prompt Match | executeIfPromptMatch | action | text | 
490 | Execute If Prompt Not Match | executeIfPromptNotMatch | action | text | 
491 | Execute If Prompt Not Present | executeIfPromptNotPresent | action |  | 
492 | Execute If Prompt Present | executeIfPromptPresent | action |  | 
493 | Execute If QR | executeIfQR | action | locator | text
494 | Execute If QR Match | executeIfQRMatch | action | locator | text
495 | Execute If QR Not Match | executeIfQRNotMatch | action | locator | text
496 | Execute If Selected Id | executeIfSelectedId | action | locator | text
497 | Execute If Selected Id Match | executeIfSelectedIdMatch | action | locator | text
498 | Execute If Selected Id Not Match | executeIfSelectedIdNotMatch | action | locator | text
499 | Execute If Selected Index | executeIfSelectedIndex | action | locator | text
500 | Execute If Selected Index Match | executeIfSelectedIndexMatch | action | locator | text
501 | Execute If Selected Index Not Match | executeIfSelectedIndexNotMatch | action | locator | text
502 | Execute If Selected Label | executeIfSelectedLabel | action | locator | text
503 | Execute If Selected Label Match | executeIfSelectedLabelMatch | action | locator | text
504 | Execute If Selected Label Not Match | executeIfSelectedLabelNotMatch | action | locator | text
505 | Execute If Selected Value | executeIfSelectedValue | action | locator | text
506 | Execute If Selected Value Match | executeIfSelectedValueMatch | action | locator | text
507 | Execute If Selected Value Not Match | executeIfSelectedValueNotMatch | action | locator | text
508 | Execute If Something Selected | executeIfSomethingSelected | action | locator | 
509 | Execute If Something Selected | executeIfSomethingSelected | action | parentLocator | locator
510 | Execute If Tag Name | executeIfTagName | action | locator | text
511 | Execute If Tag Name Match | executeIfTagNameMatch | action | locator | text
512 | Execute If Tag Name Not Match | executeIfTagNameNotMatch | action | locator | text
513 | Execute If Text | executeIfText | action | locator | text
514 | Execute If Text Empty | executeIfTextEmpty | action | locator | 
515 | Execute If Text Empty | executeIfTextEmpty | action | parentLocator | locator
516 | Execute If Text Match | executeIfTextMatch | action | locator | text
517 | Execute If Text Not Match | executeIfTextNotMatch | action | locator | text
518 | Execute If Text Not Present | executeIfTextNotPresent | action | pattern | 
519 | Execute If Text Present | executeIfTextPresent | action | pattern | 
520 | Execute If Title | executeIfTitle | action | text | 
521 | Execute If Title Match | executeIfTitleMatch | action | text | 
522 | Execute If Title Not Match | executeIfTitleNotMatch | action | text | 
523 | Execute If Value | executeIfValue | action | locator | text
524 | Execute If Value Empty | executeIfValueEmpty | action | locator | 
525 | Execute If Value Empty | executeIfValueEmpty | action | parentLocator | locator
526 | Execute If Value Match | executeIfValueMatch | action | locator | text
527 | Execute If Value Not Match | executeIfValueNotMatch | action | locator | text
528 | Execute If Variable | executeIfVariable | action | variable | text
529 | Execute If Visible | executeIfVisible | action | locator | 
530 | Execute If Visible | executeIfVisible | action | parentLocator | locator
531 | Execute Loop | executeLoop | action | times | 
532 | Fire Event | fireEvent | locator | eventName | 
533 | Fire Event | fireEvent | parentLocator | locator | eventName
534 | Focus | focus | locator |  | 
535 | Focus | focus | parentLocator | locator | 
536 | Go Back | goBack |  |  | 
537 | Go Forward | goForward |  |  | 
538 | Highlight | highlight | locator |  | 
539 | Highlight | highlight | parentLocator | locator | 
540 | Key Down | keyDown | keycode |  | 
541 | Key Down | keyDown | locator | keySequence | 
542 | Key Down | keyDown | parentLocator | locator | keySequence
543 | Key Press | keyPress | keycode |  | 
544 | Key Press | keyPress | locator | keySequence | 
545 | Key Press | keyPress | parentLocator | locator | keySequence
546 | Key Up | keyUp | keycode |  | 
547 | Key Up | keyUp | locator | keySequence | 
548 | Key Up | keyUp | parentLocator | locator | keySequence
549 | Landscape | landscape |  |  | 
550 | Meta Key Down | metaKeyDown |  |  | 
551 | Meta Key Up | metaKeyUp |  |  | 
552 | Mouse Down | mouseDown | locator |  | 
553 | Mouse Down | mouseDown | parentLocator | locator | 
554 | Mouse Down At | mouseDownAt | locator | coordString | 
555 | Mouse Down At | mouseDownAt | parentLocator | locator | coordString
556 | Mouse Move | mouseMove | locator |  | 
557 | Mouse Move | mouseMove | parentLocator | locator | 
558 | Mouse Move At | mouseMoveAt | locator | coordString | 
559 | Mouse Move At | mouseMoveAt | parentLocator | locator | coordString
560 | Mouse Out | mouseOut | locator |  | 
561 | Mouse Out | mouseOut | parentLocator | locator | 
562 | Mouse Over | mouseOver | locator |  | 
563 | Mouse Over | mouseOver | parentLocator | locator | 
564 | Mouse Up | mouseUp | locator |  | 
565 | Mouse Up | mouseUp | parentLocator | locator | 
566 | Mouse Up At | mouseUpAt | locator | coordString | 
567 | Mouse Up At | mouseUpAt | parentLocator | locator | coordString
568 | Open | open | url |  | 
569 | Open Window | openWindow | url |  | 
570 | Open Window | openWindow | url | windowID | 
571 | Pause | pause | waitTime |  | 
572 | Pinch | pinch | scale |  | 
573 | Pinch | pinch | locator | scale | 
574 | Pinch | pinch | parentLocator | locator | scale
575 | Portrait | portrait |  |  | 
576 | Refresh | refresh |  |  | 
577 | Remove All Selections | removeAllSelections | locator |  | 
578 | Remove All Selections | removeAllSelections | parentLocator | locator | 
579 | Remove Selection | removeSelection | locator | optionLocator | 
580 | Remove Selection | removeSelection | parentLocator | locator | optionLocator
581 | Remove Selection Id | removeSelectionId | locator | id | 
582 | Remove Selection Id | removeSelectionId | parentLocator | locator | id
583 | Remove Selection Index | removeSelectionIndex | locator | index | 
584 | Remove Selection Index | removeSelectionIndex | parentLocator | locator | index
585 | Remove Selection Label | removeSelectionLabel | locator | label | 
586 | Remove Selection Label | removeSelectionLabel | parentLocator | locator | label
587 | Remove Selection Value | removeSelectionValue | locator | value | 
588 | Remove Selection Value | removeSelectionValue | parentLocator | locator | value
589 | Rotate | rotate | rotation |  | 
590 | Run Script | runScript | script |  | 
591 | Scroll Down | scrollDown |  |  | 
592 | Scroll Down | scrollDown | locator |  | 
593 | Scroll Down | scrollDown | parentLocator | locator | 
594 | Scroll Down To | scrollDownTo | locator |  | 
595 | Scroll Down To | scrollDownTo | parentLocator | locator | 
596 | Scroll Left | scrollLeft |  |  | 
597 | Scroll Left | scrollLeft | locator |  | 
598 | Scroll Left | scrollLeft | parentLocator | locator | 
599 | Scroll Left To | scrollLeftTo | locator |  | 
600 | Scroll Left To | scrollLeftTo | parentLocator | locator | 
601 | Scroll Right | scrollRight |  |  | 
602 | Scroll Right | scrollRight | locator |  | 
603 | Scroll Right | scrollRight | parentLocator | locator | 
604 | Scroll Right To | scrollRightTo | locator |  | 
605 | Scroll Right To | scrollRightTo | parentLocator | locator | 
606 | Scroll Up | scrollUp |  |  | 
607 | Scroll Up | scrollUp | locator |  | 
608 | Scroll Up | scrollUp | parentLocator | locator | 
609 | Scroll Up To | scrollUpTo | locator |  | 
610 | Scroll Up To | scrollUpTo | parentLocator | locator | 
611 | Select | select | locator | optionLocator | 
612 | Select | select | parentLocator | locator | optionLocator
613 | Select First Window | selectFirstWindow |  |  | 
614 | Select Frame | selectFrame | locator |  | 
615 | Select Id | selectId | locator | id | 
616 | Select Id | selectId | parentLocator | locator | id
617 | Select Index | selectIndex | locator | index | 
618 | Select Index | selectIndex | parentLocator | locator | index
619 | Select Label | selectLabel | locator | label | 
620 | Select Label | selectLabel | parentLocator | locator | label
621 | Select Last Window | selectLastWindow |  |  | 
622 | Select Parent Frame | selectParentFrame |  |  | 
623 | Select Pop Up | selectPopUp | windowID |  | 
624 | Select Value | selectValue | locator | value | 
625 | Select Value | selectValue | parentLocator | locator | value
626 | Select Window | selectWindow | windowID |  | 
627 | Set Cursor Position | setCursorPosition | locator | position | 
628 | Set Cursor Position | setCursorPosition | parentLocator | locator | position
629 | Set Geolocation | setGeolocation | location |  | 
630 | Set Page Load Timeout | setPageLoadTimeout | timeout |  | 
631 | Set Timeout | setTimeout | timeout |  | 
632 | Shift Key Down | shiftKeyDown |  |  | 
633 | Shift Key Up | shiftKeyUp |  |  | 
634 | Store | store | text | variable | 
635 | Store Alert | storeAlert | variable |  | 
636 | Store All Buttons | storeAllButtons | variable |  | 
637 | Store All Fields | storeAllFields | variable |  | 
638 | Store All Links | storeAllLinks | variable |  | 
639 | Store All Window Names | storeAllWindowNames | variable |  | 
640 | Store All Window Titles | storeAllWindowTitles | variable |  | 
641 | Store Attribute | storeAttribute | locator | name | variable
642 | Store Attribute From All Windows | storeAttributeFromAllWindows | attributeName | variable | 
643 | Store Body Text | storeBodyText | variable |  | 
644 | Store Confirmation | storeConfirmation | variable |  | 
645 | Store Cookie | storeCookie | variable |  | 
646 | Store Cookie By Name | storeCookieByName | name | variable | 
647 | Store Current Date | storeCurrentDate | variable |  | 
648 | Store Cursor Position | storeCursorPosition | locator | variable | 
649 | Store Cursor Position | storeCursorPosition | parentLocator | locator | variable
650 | Store Eval | storeEval | expression | variable | 
651 | Store Eval Script | storeEvalScript | script | variable | 
652 | Store Expression | storeExpression | expression | variable | 
653 | Store Location | storeLocation | variable |  | 
654 | Store Page Source | storePageSource | variable |  | 
655 | Store Prompt | storePrompt | variable |  | 
656 | Store Push | storePush | text | variable | 
657 | Store QR | storeQR | locator | variable | 
658 | Store QR | storeQR | parentLocator | locator | variable
659 | Store Select Options | storeSelectOptions | locator | variable | 
660 | Store Select Options | storeSelectOptions | parentLocator | locator | variable
661 | Store Selected Id | storeSelectedId | locator | variable | 
662 | Store Selected Id | storeSelectedId | parentLocator | locator | variable
663 | Store Selected Ids | storeSelectedIds | locator | variable | 
664 | Store Selected Ids | storeSelectedIds | parentLocator | locator | variable
665 | Store Selected Index | storeSelectedIndex | locator | variable | 
666 | Store Selected Index | storeSelectedIndex | parentLocator | locator | variable
667 | Store Selected Indexes | storeSelectedIndexes | locator | variable | 
668 | Store Selected Indexes | storeSelectedIndexes | parentLocator | locator | variable
669 | Store Selected Label | storeSelectedLabel | locator | variable | 
670 | Store Selected Label | storeSelectedLabel | parentLocator | locator | variable
671 | Store Selected Labels | storeSelectedLabels | locator | variable | 
672 | Store Selected Labels | storeSelectedLabels | parentLocator | locator | variable
673 | Store Selected Value | storeSelectedValue | locator | variable | 
674 | Store Selected Value | storeSelectedValue | parentLocator | locator | variable
675 | Store Selected Values | storeSelectedValues | locator | variable | 
676 | Store Selected Values | storeSelectedValues | parentLocator | locator | variable
677 | Store Table | storeTable | locator | cellAddress | variable
678 | Store Tag Name | storeTagName | locator | variable | 
679 | Store Tag Name | storeTagName | parentLocator | locator | variable
680 | Store Text | storeText | locator | variable | 
681 | Store Text | storeText | parentLocator | locator | variable
682 | Store Title | storeTitle | variable |  | 
683 | Store Value | storeValue | locator | variable | 
684 | Store Value | storeValue | parentLocator | locator | variable
685 | Submit | submit | locator |  | 
686 | Submit | submit | parentLocator | locator | 
687 | Swipe Down | swipeDown |  |  | 
688 | Swipe Down | swipeDown | locator |  | 
689 | Swipe Down | swipeDown | parentLocator | locator | 
690 | Swipe Left | swipeLeft |  |  | 
691 | Swipe Left | swipeLeft | locator |  | 
692 | Swipe Left | swipeLeft | parentLocator | locator | 
693 | Swipe Right | swipeRight |  |  | 
694 | Swipe Right | swipeRight | locator |  | 
695 | Swipe Right | swipeRight | parentLocator | locator | 
696 | Swipe Up | swipeUp |  |  | 
697 | Swipe Up | swipeUp | locator |  | 
698 | Swipe Up | swipeUp | parentLocator | locator | 
699 | Type | type | locator | value | 
700 | Type | type | parentLocator | locator | value
701 | Type And Tab | typeAndTab | locator | value | 
702 | Type And Tab | typeAndTab | parentLocator | locator | value
703 | Type Keys | typeKeys | value |  | 
704 | Type Keys | typeKeys | locator | value | 
705 | Type Keys | typeKeys | parentLocator | locator | value
706 | Uncheck | uncheck | locator |  | 
707 | Uncheck | uncheck | parentLocator | locator | 
708 | Verify Alert | verifyAlert | text |  | 
709 | Verify Alert Match | verifyAlertMatch | text |  | 
710 | Verify Alert Not Match | verifyAlertNotMatch | text |  | 
711 | Verify Alert Not Present | verifyAlertNotPresent |  |  | 
712 | Verify Alert Present | verifyAlertPresent |  |  | 
713 | Verify All Buttons | verifyAllButtons | text |  | 
714 | Verify All Buttons Match | verifyAllButtonsMatch | text |  | 
715 | Verify All Buttons Not Match | verifyAllButtonsNotMatch | text |  | 
716 | Verify All Fields | verifyAllFields | text |  | 
717 | Verify All Fields Match | verifyAllFieldsMatch | text |  | 
718 | Verify All Fields Not Match | verifyAllFieldsNotMatch | text |  | 
719 | Verify All Links | verifyAllLinks | text |  | 
720 | Verify All Links Match | verifyAllLinksMatch | text |  | 
721 | Verify All Links Not Match | verifyAllLinksNotMatch | text |  | 
722 | Verify All Window Names | verifyAllWindowNames | text |  | 
723 | Verify All Window Names Match | verifyAllWindowNamesMatch | text |  | 
724 | Verify All Window Names Not Match | verifyAllWindowNamesNotMatch | text |  | 
725 | Verify All Window Titles | verifyAllWindowTitles | text |  | 
726 | Verify All Window Titles Match | verifyAllWindowTitlesMatch | text |  | 
727 | Verify All Window Titles Not Match | verifyAllWindowTitlesNotMatch | text |  | 
728 | Verify Attribute | verifyAttribute | locator | name | text
729 | Verify Attribute From All Windows | verifyAttributeFromAllWindows | attributeName | text | 
730 | Verify Attribute From All Windows Match | verifyAttributeFromAllWindowsMatch | attributeName | text | 
731 | Verify Attribute From All Windows Not Match | verifyAttributeFromAllWindowsNotMatch | attributeName | text | 
732 | Verify Attribute Match | verifyAttributeMatch | locator | name | text
733 | Verify Attribute Not Match | verifyAttributeNotMatch | locator | name | text
734 | Verify Background Color | verifyBackgroundColor | locator | text | 
735 | Verify Background Color | verifyBackgroundColor | parentLocator | locator | text
736 | Verify Body Text | verifyBodyText | text |  | 
737 | Verify Body Text Match | verifyBodyTextMatch | text |  | 
738 | Verify Body Text Not Match | verifyBodyTextNotMatch | text |  | 
739 | Verify Border Color | verifyBorderColor | locator | text | 
740 | Verify Border Color | verifyBorderColor | parentLocator | locator | text
741 | Verify Checked | verifyChecked | locator |  | 
742 | Verify Checked | verifyChecked | parentLocator | locator | 
743 | Verify Color | verifyColor | locator | text | 
744 | Verify Color | verifyColor | parentLocator | locator | text
745 | Verify Confirmation | verifyConfirmation | text |  | 
746 | Verify Confirmation Match | verifyConfirmationMatch | text |  | 
747 | Verify Confirmation Not Match | verifyConfirmationNotMatch | text |  | 
748 | Verify Confirmation Not Present | verifyConfirmationNotPresent |  |  | 
749 | Verify Confirmation Present | verifyConfirmationPresent |  |  | 
750 | Verify Cookie | verifyCookie | text |  | 
751 | Verify Cookie By Name | verifyCookieByName | name | text | 
752 | Verify Cookie By Name Match | verifyCookieByNameMatch | name | text | 
753 | Verify Cookie By Name Not Match | verifyCookieByNameNotMatch | name | text | 
754 | Verify Cookie Match | verifyCookieMatch | text |  | 
755 | Verify Cookie Not Match | verifyCookieNotMatch | text |  | 
756 | Verify Cookie Not Present | verifyCookieNotPresent | name |  | 
757 | Verify Cookie Present | verifyCookiePresent | name |  | 
758 | Verify Css Count | verifyCssCount | css | text | 
759 | Verify Cursor Position | verifyCursorPosition | locator | text | 
760 | Verify Cursor Position | verifyCursorPosition | parentLocator | locator | text
761 | Verify Date List Order Asc | verifyDateListOrderAsc | locator | format | 
762 | Verify Date List Order Asc | verifyDateListOrderAsc | parentLocator | locator | format
763 | Verify Date List Order Desc | verifyDateListOrderDesc | locator | format | 
764 | Verify Date List Order Desc | verifyDateListOrderDesc | parentLocator | locator | format
765 | Verify Editable | verifyEditable | locator |  | 
766 | Verify Editable | verifyEditable | parentLocator | locator | 
767 | Verify Element Height | verifyElementHeight | locator | text | 
768 | Verify Element Height | verifyElementHeight | parentLocator | locator | text
769 | Verify Element Index | verifyElementIndex | locator | text | 
770 | Verify Element Index | verifyElementIndex | parentLocator | locator | text
771 | Verify Element Not Present | verifyElementNotPresent | locator |  | 
772 | Verify Element Not Present | verifyElementNotPresent | parentLocator | locator | 
773 | Verify Element Position Left | verifyElementPositionLeft | locator | text | 
774 | Verify Element Position Left | verifyElementPositionLeft | parentLocator | locator | text
775 | Verify Element Position Top | verifyElementPositionTop | locator | text | 
776 | Verify Element Position Top | verifyElementPositionTop | parentLocator | locator | text
777 | Verify Element Present | verifyElementPresent | locator |  | 
778 | Verify Element Present | verifyElementPresent | parentLocator | locator | 
779 | Verify Element Width | verifyElementWidth | locator | text | 
780 | Verify Element Width | verifyElementWidth | parentLocator | locator | text
781 | Verify Enabled | verifyEnabled | locator |  | 
782 | Verify Enabled | verifyEnabled | parentLocator | locator | 
783 | Verify Eval | verifyEval | expression | text | 
784 | Verify Eval Script | verifyEvalScript | script | text | 
785 | Verify Eval Script Match | verifyEvalScriptMatch | script | text | 
786 | Verify Eval Script Not Match | verifyEvalScriptNotMatch | script | text | 
787 | Verify Exists In Database | verifyExistsInDatabase | sql |  | 
788 | Verify Expression | verifyExpression | expression | text | 
789 | Verify Expression Match | verifyExpressionMatch | expression | text | 
790 | Verify Expression Not Match | verifyExpressionNotMatch | expression | text | 
791 | Verify File Contain Line | verifyFileContainLine | filePattern | charset | text
792 | Verify File Downloaded | verifyFileDownloaded | filePattern |  | 
793 | Verify File First Line | verifyFileFirstLine | filePattern | charset | text
794 | Verify Font Family | verifyFontFamily | locator | text | 
795 | Verify Font Family | verifyFontFamily | parentLocator | locator | text
796 | Verify Font Family Match | verifyFontFamilyMatch | locator | text | 
797 | Verify Font Family Match | verifyFontFamilyMatch | parentLocator | locator | text
798 | Verify Font Family Not Match | verifyFontFamilyNotMatch | locator | text | 
799 | Verify Font Family Not Match | verifyFontFamilyNotMatch | parentLocator | locator | text
800 | Verify Font Size | verifyFontSize | locator | text | 
801 | Verify Font Size | verifyFontSize | parentLocator | locator | text
802 | Verify Font Size Match | verifyFontSizeMatch | locator | text | 
803 | Verify Font Size Match | verifyFontSizeMatch | parentLocator | locator | text
804 | Verify Font Size Not Match | verifyFontSizeNotMatch | locator | text | 
805 | Verify Font Size Not Match | verifyFontSizeNotMatch | parentLocator | locator | text
806 | Verify Font Style | verifyFontStyle | locator | text | 
807 | Verify Font Style | verifyFontStyle | parentLocator | locator | text
808 | Verify Font Style Match | verifyFontStyleMatch | locator | text | 
809 | Verify Font Style Match | verifyFontStyleMatch | parentLocator | locator | text
810 | Verify Font Style Not Match | verifyFontStyleNotMatch | locator | text | 
811 | Verify Font Style Not Match | verifyFontStyleNotMatch | parentLocator | locator | text
812 | Verify Font Weight | verifyFontWeight | locator | text | 
813 | Verify Font Weight | verifyFontWeight | parentLocator | locator | text
814 | Verify Font Weight Match | verifyFontWeightMatch | locator | text | 
815 | Verify Font Weight Match | verifyFontWeightMatch | parentLocator | locator | text
816 | Verify Font Weight Not Match | verifyFontWeightNotMatch | locator | text | 
817 | Verify Font Weight Not Match | verifyFontWeightNotMatch | parentLocator | locator | text
818 | Verify Integer List Order Asc | verifyIntegerListOrderAsc | locator |  | 
819 | Verify Integer List Order Asc | verifyIntegerListOrderAsc | parentLocator | locator | 
820 | Verify Integer List Order Desc | verifyIntegerListOrderDesc | locator |  | 
821 | Verify Integer List Order Desc | verifyIntegerListOrderDesc | parentLocator | locator | 
822 | Verify List Contain | verifyListContain | variable | text | 
823 | Verify List Not Contain | verifyListNotContain | variable | text | 
824 | Verify List Order Asc | verifyListOrderAsc | variable |  | 
825 | Verify List Order Desc | verifyListOrderDesc | variable |  | 
826 | Verify Location | verifyLocation | text |  | 
827 | Verify Location Match | verifyLocationMatch | text |  | 
828 | Verify Location Not Match | verifyLocationNotMatch | text |  | 
829 | Verify Log Contain Line | verifyLogContainLine | text |  | 
830 | Verify Log Not Contain Line | verifyLogNotContainLine | text |  | 
831 | Verify Not Alert | verifyNotAlert | text |  | 
832 | Verify Not All Buttons | verifyNotAllButtons | text |  | 
833 | Verify Not All Fields | verifyNotAllFields | text |  | 
834 | Verify Not All Links | verifyNotAllLinks | text |  | 
835 | Verify Not All Window Names | verifyNotAllWindowNames | text |  | 
836 | Verify Not All Window Titles | verifyNotAllWindowTitles | text |  | 
837 | Verify Not Attribute | verifyNotAttribute | locator | name | text
838 | Verify Not Attribute From All Windows | verifyNotAttributeFromAllWindows | attributeName | text | 
839 | Verify Not Background Color | verifyNotBackgroundColor | locator | text | 
840 | Verify Not Background Color | verifyNotBackgroundColor | parentLocator | locator | text
841 | Verify Not Body Text | verifyNotBodyText | text |  | 
842 | Verify Not Border Color | verifyNotBorderColor | locator | text | 
843 | Verify Not Border Color | verifyNotBorderColor | parentLocator | locator | text
844 | Verify Not Checked | verifyNotChecked | locator |  | 
845 | Verify Not Checked | verifyNotChecked | parentLocator | locator | 
846 | Verify Not Color | verifyNotColor | locator | text | 
847 | Verify Not Color | verifyNotColor | parentLocator | locator | text
848 | Verify Not Confirmation | verifyNotConfirmation | text |  | 
849 | Verify Not Cookie | verifyNotCookie | text |  | 
850 | Verify Not Cookie By Name | verifyNotCookieByName | name | text | 
851 | Verify Not Css Count | verifyNotCssCount | css | text | 
852 | Verify Not Cursor Position | verifyNotCursorPosition | locator | text | 
853 | Verify Not Cursor Position | verifyNotCursorPosition | parentLocator | locator | text
854 | Verify Not Editable | verifyNotEditable | locator |  | 
855 | Verify Not Editable | verifyNotEditable | parentLocator | locator | 
856 | Verify Not Element Height | verifyNotElementHeight | locator | text | 
857 | Verify Not Element Height | verifyNotElementHeight | parentLocator | locator | text
858 | Verify Not Element Index | verifyNotElementIndex | locator | text | 
859 | Verify Not Element Index | verifyNotElementIndex | parentLocator | locator | text
860 | Verify Not Element Position Left | verifyNotElementPositionLeft | locator | text | 
861 | Verify Not Element Position Left | verifyNotElementPositionLeft | parentLocator | locator | text
862 | Verify Not Element Position Top | verifyNotElementPositionTop | locator | text | 
863 | Verify Not Element Position Top | verifyNotElementPositionTop | parentLocator | locator | text
864 | Verify Not Element Width | verifyNotElementWidth | locator | text | 
865 | Verify Not Element Width | verifyNotElementWidth | parentLocator | locator | text
866 | Verify Not Enabled | verifyNotEnabled | locator |  | 
867 | Verify Not Enabled | verifyNotEnabled | parentLocator | locator | 
868 | Verify Not Eval | verifyNotEval | expression | text | 
869 | Verify Not Eval Script | verifyNotEvalScript | script | text | 
870 | Verify Not Exists In Database | verifyNotExistsInDatabase | sql |  | 
871 | Verify Not Expression | verifyNotExpression | expression | text | 
872 | Verify Not File Downloaded | verifyNotFileDownloaded | filePattern |  | 
873 | Verify Not Font Family | verifyNotFontFamily | locator | text | 
874 | Verify Not Font Family | verifyNotFontFamily | parentLocator | locator | text
875 | Verify Not Font Size | verifyNotFontSize | locator | text | 
876 | Verify Not Font Size | verifyNotFontSize | parentLocator | locator | text
877 | Verify Not Font Style | verifyNotFontStyle | locator | text | 
878 | Verify Not Font Style | verifyNotFontStyle | parentLocator | locator | text
879 | Verify Not Font Weight | verifyNotFontWeight | locator | text | 
880 | Verify Not Font Weight | verifyNotFontWeight | parentLocator | locator | text
881 | Verify Not Location | verifyNotLocation | text |  | 
882 | Verify Not Ordered | verifyNotOrdered | firstLocator | secondLocator | 
883 | Verify Not Page Source | verifyNotPageSource | text |  | 
884 | Verify Not Prompt | verifyNotPrompt | text |  | 
885 | Verify Not QR | verifyNotQR | locator | text | 
886 | Verify Not QR | verifyNotQR | parentLocator | locator | text
887 | Verify Not Select Options | verifyNotSelectOptions | locator | text | 
888 | Verify Not Select Options | verifyNotSelectOptions | parentLocator | locator | text
889 | Verify Not Selected Id | verifyNotSelectedId | locator | text | 
890 | Verify Not Selected Id | verifyNotSelectedId | parentLocator | locator | text
891 | Verify Not Selected Ids | verifyNotSelectedIds | locator | text | 
892 | Verify Not Selected Ids | verifyNotSelectedIds | parentLocator | locator | text
893 | Verify Not Selected Index | verifyNotSelectedIndex | locator | text | 
894 | Verify Not Selected Index | verifyNotSelectedIndex | parentLocator | locator | text
895 | Verify Not Selected Indexes | verifyNotSelectedIndexes | locator | text | 
896 | Verify Not Selected Indexes | verifyNotSelectedIndexes | parentLocator | locator | text
897 | Verify Not Selected Label | verifyNotSelectedLabel | locator | text | 
898 | Verify Not Selected Label | verifyNotSelectedLabel | parentLocator | locator | text
899 | Verify Not Selected Labels | verifyNotSelectedLabels | locator | text | 
900 | Verify Not Selected Labels | verifyNotSelectedLabels | parentLocator | locator | text
901 | Verify Not Selected Value | verifyNotSelectedValue | locator | text | 
902 | Verify Not Selected Value | verifyNotSelectedValue | parentLocator | locator | text
903 | Verify Not Selected Values | verifyNotSelectedValues | locator | text | 
904 | Verify Not Selected Values | verifyNotSelectedValues | parentLocator | locator | text
905 | Verify Not Something Selected | verifyNotSomethingSelected | locator |  | 
906 | Verify Not Something Selected | verifyNotSomethingSelected | parentLocator | locator | 
907 | Verify Not Table | verifyNotTable | locator | cellAddress | text
908 | Verify Not Tag Name | verifyNotTagName | locator | text | 
909 | Verify Not Tag Name | verifyNotTagName | parentLocator | locator | text
910 | Verify Not Text | verifyNotText | locator | text | 
911 | Verify Not Text | verifyNotText | parentLocator | locator | text
912 | Verify Not Text Alignment | verifyNotTextAlignment | locator | text | 
913 | Verify Not Text Alignment | verifyNotTextAlignment | parentLocator | locator | text
914 | Verify Not Text Decoration | verifyNotTextDecoration | locator | text | 
915 | Verify Not Text Decoration | verifyNotTextDecoration | parentLocator | locator | text
916 | Verify Not Text Empty | verifyNotTextEmpty | locator |  | 
917 | Verify Not Text Empty | verifyNotTextEmpty | parentLocator | locator | 
918 | Verify Not Title | verifyNotTitle | text |  | 
919 | Verify Not Value | verifyNotValue | locator | text | 
920 | Verify Not Value | verifyNotValue | parentLocator | locator | text
921 | Verify Not Value Empty | verifyNotValueEmpty | locator |  | 
922 | Verify Not Value Empty | verifyNotValueEmpty | parentLocator | locator | 
923 | Verify Not Variable | verifyNotVariable | variable | text | 
924 | Verify Not Visible | verifyNotVisible | locator |  | 
925 | Verify Not Visible | verifyNotVisible | parentLocator | locator | 
926 | Verify Not Xpath Count | verifyNotXpathCount | xpath | text | 
927 | Verify Ordered | verifyOrdered | firstLocator | secondLocator | 
928 | Verify Page Source | verifyPageSource | text |  | 
929 | Verify Page Source Match | verifyPageSourceMatch | text |  | 
930 | Verify Page Source Not Match | verifyPageSourceNotMatch | text |  | 
931 | Verify Prompt | verifyPrompt | text |  | 
932 | Verify Prompt Match | verifyPromptMatch | text |  | 
933 | Verify Prompt Not Match | verifyPromptNotMatch | text |  | 
934 | Verify Prompt Not Present | verifyPromptNotPresent |  |  | 
935 | Verify Prompt Present | verifyPromptPresent |  |  | 
936 | Verify QR | verifyQR | locator | text | 
937 | Verify QR | verifyQR | parentLocator | locator | text
938 | Verify QR Match | verifyQRMatch | locator | text | 
939 | Verify QR Match | verifyQRMatch | parentLocator | locator | text
940 | Verify QR Not Match | verifyQRNotMatch | locator | text | 
941 | Verify QR Not Match | verifyQRNotMatch | parentLocator | locator | text
942 | Verify Row Count | verifyRowCount | sql | count | 
943 | Verify Row Count Greater Than | verifyRowCountGreaterThan | sql | count | 
944 | Verify Row Count Less Than | verifyRowCountLessThan | sql | count | 
945 | Verify Select Options | verifySelectOptions | locator | text | 
946 | Verify Select Options | verifySelectOptions | parentLocator | locator | text
947 | Verify Select Options Match | verifySelectOptionsMatch | locator | text | 
948 | Verify Select Options Match | verifySelectOptionsMatch | parentLocator | locator | text
949 | Verify Select Options Not Match | verifySelectOptionsNotMatch | locator | text | 
950 | Verify Select Options Not Match | verifySelectOptionsNotMatch | parentLocator | locator | text
951 | Verify Selected Id | verifySelectedId | locator | text | 
952 | Verify Selected Id | verifySelectedId | parentLocator | locator | text
953 | Verify Selected Id Match | verifySelectedIdMatch | locator | text | 
954 | Verify Selected Id Match | verifySelectedIdMatch | parentLocator | locator | text
955 | Verify Selected Id Not Match | verifySelectedIdNotMatch | locator | text | 
956 | Verify Selected Id Not Match | verifySelectedIdNotMatch | parentLocator | locator | text
957 | Verify Selected Ids | verifySelectedIds | locator | text | 
958 | Verify Selected Ids | verifySelectedIds | parentLocator | locator | text
959 | Verify Selected Ids Match | verifySelectedIdsMatch | locator | text | 
960 | Verify Selected Ids Match | verifySelectedIdsMatch | parentLocator | locator | text
961 | Verify Selected Ids Not Match | verifySelectedIdsNotMatch | locator | text | 
962 | Verify Selected Ids Not Match | verifySelectedIdsNotMatch | parentLocator | locator | text
963 | Verify Selected Index | verifySelectedIndex | locator | text | 
964 | Verify Selected Index | verifySelectedIndex | parentLocator | locator | text
965 | Verify Selected Index Match | verifySelectedIndexMatch | locator | text | 
966 | Verify Selected Index Match | verifySelectedIndexMatch | parentLocator | locator | text
967 | Verify Selected Index Not Match | verifySelectedIndexNotMatch | locator | text | 
968 | Verify Selected Index Not Match | verifySelectedIndexNotMatch | parentLocator | locator | text
969 | Verify Selected Indexes | verifySelectedIndexes | locator | text | 
970 | Verify Selected Indexes | verifySelectedIndexes | parentLocator | locator | text
971 | Verify Selected Indexes Match | verifySelectedIndexesMatch | locator | text | 
972 | Verify Selected Indexes Match | verifySelectedIndexesMatch | parentLocator | locator | text
973 | Verify Selected Indexes Not Match | verifySelectedIndexesNotMatch | locator | text | 
974 | Verify Selected Indexes Not Match | verifySelectedIndexesNotMatch | parentLocator | locator | text
975 | Verify Selected Label | verifySelectedLabel | locator | text | 
976 | Verify Selected Label | verifySelectedLabel | parentLocator | locator | text
977 | Verify Selected Label Match | verifySelectedLabelMatch | locator | text | 
978 | Verify Selected Label Match | verifySelectedLabelMatch | parentLocator | locator | text
979 | Verify Selected Label Not Match | verifySelectedLabelNotMatch | locator | text | 
980 | Verify Selected Label Not Match | verifySelectedLabelNotMatch | parentLocator | locator | text
981 | Verify Selected Labels | verifySelectedLabels | locator | text | 
982 | Verify Selected Labels | verifySelectedLabels | parentLocator | locator | text
983 | Verify Selected Labels Match | verifySelectedLabelsMatch | locator | text | 
984 | Verify Selected Labels Match | verifySelectedLabelsMatch | parentLocator | locator | text
985 | Verify Selected Labels Not Match | verifySelectedLabelsNotMatch | locator | text | 
986 | Verify Selected Labels Not Match | verifySelectedLabelsNotMatch | parentLocator | locator | text
987 | Verify Selected Value | verifySelectedValue | locator | text | 
988 | Verify Selected Value | verifySelectedValue | parentLocator | locator | text
989 | Verify Selected Value Match | verifySelectedValueMatch | locator | text | 
990 | Verify Selected Value Match | verifySelectedValueMatch | parentLocator | locator | text
991 | Verify Selected Value Not Match | verifySelectedValueNotMatch | locator | text | 
992 | Verify Selected Value Not Match | verifySelectedValueNotMatch | parentLocator | locator | text
993 | Verify Selected Values | verifySelectedValues | locator | text | 
994 | Verify Selected Values | verifySelectedValues | parentLocator | locator | text
995 | Verify Selected Values Match | verifySelectedValuesMatch | locator | text | 
996 | Verify Selected Values Match | verifySelectedValuesMatch | parentLocator | locator | text
997 | Verify Selected Values Not Match | verifySelectedValuesNotMatch | locator | text | 
998 | Verify Selected Values Not Match | verifySelectedValuesNotMatch | parentLocator | locator | text
999 | Verify Something Selected | verifySomethingSelected | locator |  | 
1,000 | Verify Something Selected | verifySomethingSelected | parentLocator | locator | 
1,001 | Verify Table | verifyTable | locator | cellAddress | text
1,002 | Verify Table Match | verifyTableMatch | locator | cellAddress | text
1,003 | Verify Table Not Match | verifyTableNotMatch | locator | cellAddress | text
1,004 | Verify Tag Name | verifyTagName | locator | text | 
1,005 | Verify Tag Name | verifyTagName | parentLocator | locator | text
1,006 | Verify Tag Name Match | verifyTagNameMatch | locator | text | 
1,007 | Verify Tag Name Match | verifyTagNameMatch | parentLocator | locator | text
1,008 | Verify Tag Name Not Match | verifyTagNameNotMatch | locator | text | 
1,009 | Verify Tag Name Not Match | verifyTagNameNotMatch | parentLocator | locator | text
1,010 | Verify Text | verifyText | locator | text | 
1,011 | Verify Text | verifyText | parentLocator | locator | text
1,012 | Verify Text Alignment | verifyTextAlignment | locator | text | 
1,013 | Verify Text Alignment | verifyTextAlignment | parentLocator | locator | text
1,014 | Verify Text Alignment Match | verifyTextAlignmentMatch | locator | text | 
1,015 | Verify Text Alignment Match | verifyTextAlignmentMatch | parentLocator | locator | text
1,016 | Verify Text Alignment Not Match | verifyTextAlignmentNotMatch | locator | text | 
1,017 | Verify Text Alignment Not Match | verifyTextAlignmentNotMatch | parentLocator | locator | text
1,018 | Verify Text Decoration | verifyTextDecoration | locator | text | 
1,019 | Verify Text Decoration | verifyTextDecoration | parentLocator | locator | text
1,020 | Verify Text Decoration Match | verifyTextDecorationMatch | locator | text | 
1,021 | Verify Text Decoration Match | verifyTextDecorationMatch | parentLocator | locator | text
1,022 | Verify Text Decoration Not Match | verifyTextDecorationNotMatch | locator | text | 
1,023 | Verify Text Decoration Not Match | verifyTextDecorationNotMatch | parentLocator | locator | text
1,024 | Verify Text Empty | verifyTextEmpty | locator |  | 
1,025 | Verify Text Empty | verifyTextEmpty | parentLocator | locator | 
1,026 | Verify Text List Order Asc | verifyTextListOrderAsc | locator |  | 
1,027 | Verify Text List Order Asc | verifyTextListOrderAsc | parentLocator | locator | 
1,028 | Verify Text List Order Desc | verifyTextListOrderDesc | locator |  | 
1,029 | Verify Text List Order Desc | verifyTextListOrderDesc | parentLocator | locator | 
1,030 | Verify Text Match | verifyTextMatch | locator | text | 
1,031 | Verify Text Match | verifyTextMatch | parentLocator | locator | text
1,032 | Verify Text Not Match | verifyTextNotMatch | locator | text | 
1,033 | Verify Text Not Match | verifyTextNotMatch | parentLocator | locator | text
1,034 | Verify Text Not Present | verifyTextNotPresent | pattern |  | 
1,035 | Verify Text Present | verifyTextPresent | pattern |  | 
1,036 | Verify Title | verifyTitle | text |  | 
1,037 | Verify Title Match | verifyTitleMatch | text |  | 
1,038 | Verify Title Not Match | verifyTitleNotMatch | text |  | 
1,039 | Verify Value | verifyValue | locator | text | 
1,040 | Verify Value | verifyValue | parentLocator | locator | text
1,041 | Verify Value Empty | verifyValueEmpty | locator |  | 
1,042 | Verify Value Empty | verifyValueEmpty | parentLocator | locator | 
1,043 | Verify Value Match | verifyValueMatch | locator | text | 
1,044 | Verify Value Match | verifyValueMatch | parentLocator | locator | text
1,045 | Verify Value Not Match | verifyValueNotMatch | locator | text | 
1,046 | Verify Value Not Match | verifyValueNotMatch | parentLocator | locator | text
1,047 | Verify Variable | verifyVariable | variable | text | 
1,048 | Verify Visible | verifyVisible | locator |  | 
1,049 | Verify Visible | verifyVisible | parentLocator | locator | 
1,050 | Verify Xpath Count | verifyXpathCount | xpath | text | 
1,051 | Wait For Alert | waitForAlert | text |  | 
1,052 | Wait For Alert Match | waitForAlertMatch | text |  | 
1,053 | Wait For Alert Not Match | waitForAlertNotMatch | text |  | 
1,054 | Wait For Alert Not Present | waitForAlertNotPresent |  |  | 
1,055 | Wait For Alert Present | waitForAlertPresent |  |  | 
1,056 | Wait For All Element Not Present | waitForAllElementNotPresent | locatorArray |  | 
1,057 | Wait For All Element Present | waitForAllElementPresent | locatorArray |  | 
1,058 | Wait For All Text Not Present | waitForAllTextNotPresent | textArray |  | 
1,059 | Wait For All Text Present | waitForAllTextPresent | textArray |  | 
1,060 | Wait For Any Element Not Present | waitForAnyElementNotPresent | locatorArray |  | 
1,061 | Wait For Any Element Present | waitForAnyElementPresent | locatorArray |  | 
1,062 | Wait For Any Text Not Present | waitForAnyTextNotPresent | textArray |  | 
1,063 | Wait For Any Text Present | waitForAnyTextPresent | textArray |  | 
1,064 | Wait For Attribute | waitForAttribute | locator | name | text
1,065 | Wait For Attribute Match | waitForAttributeMatch | locator | name | text
1,066 | Wait For Attribute Not Match | waitForAttributeNotMatch | locator | name | text
1,067 | Wait For Body Text | waitForBodyText | text |  | 
1,068 | Wait For Body Text Match | waitForBodyTextMatch | text |  | 
1,069 | Wait For Body Text Not Match | waitForBodyTextNotMatch | text |  | 
1,070 | Wait For Checked | waitForChecked | locator |  | 
1,071 | Wait For Checked | waitForChecked | parentLocator | locator | 
1,072 | Wait For Condition | waitForCondition | script | timeout | 
1,073 | Wait For Confirmation | waitForConfirmation | text |  | 
1,074 | Wait For Confirmation Match | waitForConfirmationMatch | text |  | 
1,075 | Wait For Confirmation Not Match | waitForConfirmationNotMatch | text |  | 
1,076 | Wait For Confirmation Not Present | waitForConfirmationNotPresent |  |  | 
1,077 | Wait For Confirmation Present | waitForConfirmationPresent |  |  | 
1,078 | Wait For Cookie | waitForCookie | text |  | 
1,079 | Wait For Cookie By Name | waitForCookieByName | name | text | 
1,080 | Wait For Cookie By Name Match | waitForCookieByNameMatch | name | text | 
1,081 | Wait For Cookie By Name Not Match | waitForCookieByNameNotMatch | name | text | 
1,082 | Wait For Cookie Match | waitForCookieMatch | text |  | 
1,083 | Wait For Cookie Not Match | waitForCookieNotMatch | text |  | 
1,084 | Wait For Cookie Not Present | waitForCookieNotPresent | name |  | 
1,085 | Wait For Cookie Present | waitForCookiePresent | name |  | 
1,086 | Wait For Editable | waitForEditable | locator |  | 
1,087 | Wait For Editable | waitForEditable | parentLocator | locator | 
1,088 | Wait For Element Not Present | waitForElementNotPresent | locator |  | 
1,089 | Wait For Element Not Present | waitForElementNotPresent | parentLocator | locator | 
1,090 | Wait For Element Present | waitForElementPresent | locator |  | 
1,091 | Wait For Element Present | waitForElementPresent | parentLocator | locator | 
1,092 | Wait For Enabled | waitForEnabled | locator |  | 
1,093 | Wait For Enabled | waitForEnabled | parentLocator | locator | 
1,094 | Wait For Eval | waitForEval | expression | text | 
1,095 | Wait For Eval Script | waitForEvalScript | script | text | 
1,096 | Wait For Eval Script Match | waitForEvalScriptMatch | script | text | 
1,097 | Wait For Eval Script Not Match | waitForEvalScriptNotMatch | script | text | 
1,098 | Wait For Exists In Database | waitForExistsInDatabase | sql |  | 
1,099 | Wait For Expression | waitForExpression | expression | text | 
1,100 | Wait For Expression Match | waitForExpressionMatch | expression | text | 
1,101 | Wait For Expression Not Match | waitForExpressionNotMatch | expression | text | 
1,102 | Wait For File Downloaded | waitForFileDownloaded | filePattern |  | 
1,103 | Wait For Location | waitForLocation | text |  | 
1,104 | Wait For Location Match | waitForLocationMatch | text |  | 
1,105 | Wait For Location Not Match | waitForLocationNotMatch | text |  | 
1,106 | Wait For Not Alert | waitForNotAlert | text |  | 
1,107 | Wait For Not Attribute | waitForNotAttribute | locator | name | text
1,108 | Wait For Not Body Text | waitForNotBodyText | text |  | 
1,109 | Wait For Not Checked | waitForNotChecked | locator |  | 
1,110 | Wait For Not Checked | waitForNotChecked | parentLocator | locator | 
1,111 | Wait For Not Confirmation | waitForNotConfirmation | text |  | 
1,112 | Wait For Not Cookie | waitForNotCookie | text |  | 
1,113 | Wait For Not Cookie By Name | waitForNotCookieByName | name | text | 
1,114 | Wait For Not Editable | waitForNotEditable | locator |  | 
1,115 | Wait For Not Editable | waitForNotEditable | parentLocator | locator | 
1,116 | Wait For Not Enabled | waitForNotEnabled | locator |  | 
1,117 | Wait For Not Enabled | waitForNotEnabled | parentLocator | locator | 
1,118 | Wait For Not Eval | waitForNotEval | expression | text | 
1,119 | Wait For Not Eval Script | waitForNotEvalScript | script | text | 
1,120 | Wait For Not Exists In Database | waitForNotExistsInDatabase | sql |  | 
1,121 | Wait For Not Expression | waitForNotExpression | expression | text | 
1,122 | Wait For Not File Downloaded | waitForNotFileDownloaded | filePattern |  | 
1,123 | Wait For Not Location | waitForNotLocation | text |  | 
1,124 | Wait For Not Page Source | waitForNotPageSource | text |  | 
1,125 | Wait For Not Prompt | waitForNotPrompt | text |  | 
1,126 | Wait For Not QR | waitForNotQR | locator | text | 
1,127 | Wait For Not QR | waitForNotQR | parentLocator | locator | text
1,128 | Wait For Not Selected Id | waitForNotSelectedId | locator | text | 
1,129 | Wait For Not Selected Id | waitForNotSelectedId | parentLocator | locator | text
1,130 | Wait For Not Selected Index | waitForNotSelectedIndex | locator | text | 
1,131 | Wait For Not Selected Index | waitForNotSelectedIndex | parentLocator | locator | text
1,132 | Wait For Not Selected Label | waitForNotSelectedLabel | locator | text | 
1,133 | Wait For Not Selected Label | waitForNotSelectedLabel | parentLocator | locator | text
1,134 | Wait For Not Selected Value | waitForNotSelectedValue | locator | text | 
1,135 | Wait For Not Selected Value | waitForNotSelectedValue | parentLocator | locator | text
1,136 | Wait For Not Something Selected | waitForNotSomethingSelected | locator |  | 
1,137 | Wait For Not Something Selected | waitForNotSomethingSelected | parentLocator | locator | 
1,138 | Wait For Not Table | waitForNotTable | locator | cellAddress | text
1,139 | Wait For Not Tag Name | waitForNotTagName | locator | text | 
1,140 | Wait For Not Tag Name | waitForNotTagName | parentLocator | locator | text
1,141 | Wait For Not Text | waitForNotText | locator | text | 
1,142 | Wait For Not Text | waitForNotText | parentLocator | locator | text
1,143 | Wait For Not Text Empty | waitForNotTextEmpty | locator |  | 
1,144 | Wait For Not Text Empty | waitForNotTextEmpty | parentLocator | locator | 
1,145 | Wait For Not Title | waitForNotTitle | text |  | 
1,146 | Wait For Not Value | waitForNotValue | locator | text | 
1,147 | Wait For Not Value | waitForNotValue | parentLocator | locator | text
1,148 | Wait For Not Value Empty | waitForNotValueEmpty | locator |  | 
1,149 | Wait For Not Value Empty | waitForNotValueEmpty | parentLocator | locator | 
1,150 | Wait For Not Visible | waitForNotVisible | locator |  | 
1,151 | Wait For Not Visible | waitForNotVisible | parentLocator | locator | 
1,152 | Wait For Page Source | waitForPageSource | text |  | 
1,153 | Wait For Page Source Match | waitForPageSourceMatch | text |  | 
1,154 | Wait For Page Source Not Match | waitForPageSourceNotMatch | text |  | 
1,155 | Wait For Page To Load | waitForPageToLoad | timeout |  | 
1,156 | Wait For Pop Up | waitForPopUp | windowID | timeout | 
1,157 | Wait For Prompt | waitForPrompt | text |  | 
1,158 | Wait For Prompt Match | waitForPromptMatch | text |  | 
1,159 | Wait For Prompt Not Match | waitForPromptNotMatch | text |  | 
1,160 | Wait For Prompt Not Present | waitForPromptNotPresent |  |  | 
1,161 | Wait For Prompt Present | waitForPromptPresent |  |  | 
1,162 | Wait For QR | waitForQR | locator | text | 
1,163 | Wait For QR | waitForQR | parentLocator | locator | text
1,164 | Wait For QR Match | waitForQRMatch | locator | text | 
1,165 | Wait For QR Match | waitForQRMatch | parentLocator | locator | text
1,166 | Wait For QR Not Match | waitForQRNotMatch | locator | text | 
1,167 | Wait For QR Not Match | waitForQRNotMatch | parentLocator | locator | text
1,168 | Wait For Selected Id | waitForSelectedId | locator | text | 
1,169 | Wait For Selected Id | waitForSelectedId | parentLocator | locator | text
1,170 | Wait For Selected Id Match | waitForSelectedIdMatch | locator | text | 
1,171 | Wait For Selected Id Match | waitForSelectedIdMatch | parentLocator | locator | text
1,172 | Wait For Selected Id Not Match | waitForSelectedIdNotMatch | locator | text | 
1,173 | Wait For Selected Id Not Match | waitForSelectedIdNotMatch | parentLocator | locator | text
1,174 | Wait For Selected Index | waitForSelectedIndex | locator | text | 
1,175 | Wait For Selected Index | waitForSelectedIndex | parentLocator | locator | text
1,176 | Wait For Selected Index Match | waitForSelectedIndexMatch | locator | text | 
1,177 | Wait For Selected Index Match | waitForSelectedIndexMatch | parentLocator | locator | text
1,178 | Wait For Selected Index Not Match | waitForSelectedIndexNotMatch | locator | text | 
1,179 | Wait For Selected Index Not Match | waitForSelectedIndexNotMatch | parentLocator | locator | text
1,180 | Wait For Selected Label | waitForSelectedLabel | locator | text | 
1,181 | Wait For Selected Label | waitForSelectedLabel | parentLocator | locator | text
1,182 | Wait For Selected Label Match | waitForSelectedLabelMatch | locator | text | 
1,183 | Wait For Selected Label Match | waitForSelectedLabelMatch | parentLocator | locator | text
1,184 | Wait For Selected Label Not Match | waitForSelectedLabelNotMatch | locator | text | 
1,185 | Wait For Selected Label Not Match | waitForSelectedLabelNotMatch | parentLocator | locator | text
1,186 | Wait For Selected Value | waitForSelectedValue | locator | text | 
1,187 | Wait For Selected Value | waitForSelectedValue | parentLocator | locator | text
1,188 | Wait For Selected Value Match | waitForSelectedValueMatch | locator | text | 
1,189 | Wait For Selected Value Match | waitForSelectedValueMatch | parentLocator | locator | text
1,190 | Wait For Selected Value Not Match | waitForSelectedValueNotMatch | locator | text | 
1,191 | Wait For Selected Value Not Match | waitForSelectedValueNotMatch | parentLocator | locator | text
1,192 | Wait For Something Selected | waitForSomethingSelected | locator |  | 
1,193 | Wait For Something Selected | waitForSomethingSelected | parentLocator | locator | 
1,194 | Wait For Table | waitForTable | locator | cellAddress | text
1,195 | Wait For Table Match | waitForTableMatch | locator | cellAddress | text
1,196 | Wait For Table Not Match | waitForTableNotMatch | locator | cellAddress | text
1,197 | Wait For Tag Name | waitForTagName | locator | text | 
1,198 | Wait For Tag Name | waitForTagName | parentLocator | locator | text
1,199 | Wait For Tag Name Match | waitForTagNameMatch | locator | text | 
1,200 | Wait For Tag Name Match | waitForTagNameMatch | parentLocator | locator | text
1,201 | Wait For Tag Name Not Match | waitForTagNameNotMatch | locator | text | 
1,202 | Wait For Tag Name Not Match | waitForTagNameNotMatch | parentLocator | locator | text
1,203 | Wait For Text | waitForText | locator | text | 
1,204 | Wait For Text | waitForText | parentLocator | locator | text
1,205 | Wait For Text Empty | waitForTextEmpty | locator |  | 
1,206 | Wait For Text Empty | waitForTextEmpty | parentLocator | locator | 
1,207 | Wait For Text Match | waitForTextMatch | locator | text | 
1,208 | Wait For Text Match | waitForTextMatch | parentLocator | locator | text
1,209 | Wait For Text Not Match | waitForTextNotMatch | locator | text | 
1,210 | Wait For Text Not Match | waitForTextNotMatch | parentLocator | locator | text
1,211 | Wait For Text Not Present | waitForTextNotPresent | pattern |  | 
1,212 | Wait For Text Present | waitForTextPresent | pattern |  | 
1,213 | Wait For Title | waitForTitle | text |  | 
1,214 | Wait For Title Match | waitForTitleMatch | text |  | 
1,215 | Wait For Title Not Match | waitForTitleNotMatch | text |  | 
1,216 | Wait For Value | waitForValue | locator | text | 
1,217 | Wait For Value | waitForValue | parentLocator | locator | text
1,218 | Wait For Value Empty | waitForValueEmpty | locator |  | 
1,219 | Wait For Value Empty | waitForValueEmpty | parentLocator | locator | 
1,220 | Wait For Value Match | waitForValueMatch | locator | text | 
1,221 | Wait For Value Match | waitForValueMatch | parentLocator | locator | text
1,222 | Wait For Value Not Match | waitForValueNotMatch | locator | text | 
1,223 | Wait For Value Not Match | waitForValueNotMatch | parentLocator | locator | text
1,224 | Wait For Visible | waitForVisible | locator |  | 
1,225 | Wait For Visible | waitForVisible | parentLocator | locator | 
1,226 | Window Focus | windowFocus |  |  | 
1,227 | Window Maximize | windowMaximize |  |  | 

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

Instructs Selenium to return the specified answer string in response to the prompt.

### Usage

`
answerPrompt(answer)
`

### Parameters

Parameter | Description
--------- | -----------
answer | the answer to give in response to the prompt pop-up

## Assert Alert

Asserts that the message of a alert equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertAlert(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Alert Match

Asserts that the message of a alert matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertAlertMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Alert Not Match

Asserts that the message of a alert not match the given value. When the assert fails, the test is aborted.

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

Asserts that the message of a confirmation dialog equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertConfirmation(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Confirmation Match

Asserts that the message of a confirmation dialog matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertConfirmationMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Confirmation Not Match

Asserts that the message of a confirmation dialog not match the given value. When the assert fails, the test is aborted.

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

## Assert File Contain Line

Verifies the contents of the file contains the given text. This method is useful for testing CSV file's contents.

### Usage

`
assertFileContainLine(filePattern, charset, text)
`

### Parameters

Parameter | Description
--------- | -----------
filePattern | the file name pattern
charset | the charset
text | the text to compare

## Assert File Downloaded

Asserts that a file is downloaded by browser. When the assert fails, the test is aborted.

### Usage

`
assertFileDownloaded(filePattern)
`

### Parameters

Parameter | Description
--------- | -----------
filePattern | the file name pattern

## Assert File First Line

Verifies the first line of the file equals to the given text. This method is useful for testing CSV file's header.

### Usage

`
assertFileFirstLine(filePattern, charset, text)
`

### Parameters

Parameter | Description
--------- | -----------
filePattern | the file name pattern
charset | the charset
text | the text to compare

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

## Assert Log Contain Line

Verifies the console log contains the given text.

### Usage

`
assertLogContainLine(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the text to compare

## Assert Log Not Contain Line

Verifies the console log does not contain the given text.

### Usage

`
assertLogNotContainLine(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the text to compare

## Assert Not Alert

Asserts that the message of a alert not equal to the given value. When the assert fails, the test is aborted.

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

Asserts that the message of a confirmation dialog not equal to the given value. When the assert fails, the test is aborted.

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

## Assert Not File Downloaded

Asserts that a file is not downloaded by browser. When the assert fails, the test is aborted.

### Usage

`
assertNotFileDownloaded(filePattern)
`

### Parameters

Parameter | Description
--------- | -----------
filePattern | the file name pattern

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

Asserts that the message of a question prompt dialog not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotPrompt(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Not QR

Asserts that the QR code's value from the image tag source encoded in Base64 format not equal to the given value. When the assert fails, the test is aborted.

### Usage

`
assertNotQR(locator, text)
`

`
assertNotQR(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
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

Asserts that the message of a question prompt dialog equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertPrompt(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Prompt Match

Asserts that the message of a question prompt dialog matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertPromptMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Assert Prompt Not Match

Asserts that the message of a question prompt dialog not match the given value. When the assert fails, the test is aborted.

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

## Assert QR

Asserts that the QR code's value from the image tag source encoded in Base64 format equals to the given value. When the assert fails, the test is aborted.

### Usage

`
assertQR(locator, text)
`

`
assertQR(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Assert QR Match

Asserts that the QR code's value from the image tag source encoded in Base64 format matches the given value. When the assert fails, the test is aborted.

### Usage

`
assertQRMatch(locator, text)
`

`
assertQRMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Assert QR Not Match

Asserts that the QR code's value from the image tag source encoded in Base64 format not match the given value. When the assert fails, the test is aborted.

### Usage

`
assertQRNotMatch(locator, text)
`

`
assertQRNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

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

## Capture Element Screenshot

Captures an element's screenshot.

### Usage

`
captureElementScreenshot(locator)
`

`
captureElementScreenshot(parentLocator, locator)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator

## Capture Screenshot

Captures full screenshot.

### Usage

`
captureScreenshot()
`

### Parameters

Parameter | Description
--------- | -----------

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

## Clear Log

Clear browser console log.

### Usage

`
clearLog()
`

### Parameters

Parameter | Description
--------- | -----------

## Click

Clicks on a link, button, checkbox or radio button at its center point. If the click action causes a new page to load (like a link usually does), call waitForPageToLoad. <p> On mobile devices, if the element's center point is obscured by another element, an element click intercepted error is returned. If the element is outside the viewport, an element not interactable error is returned. Not all drivers automatically scroll the element into view and may need to be scrolled to in order to interact with it.

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

Create a new cookie whose path and domain are same with those of current page under test.

### Usage

`
createCookie(nameValuePair)
`

### Parameters

Parameter | Description
--------- | -----------
nameValuePair | name and value of the cookie in a format "name=value"

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

Delete a named cookie with specified path and domain. Be careful; to delete a cookie, you need to delete it using the exact same path and domain that were used to create the cookie. If the path is wrong, or the domain is wrong, the cookie simply won't be deleted. Also note that specifying a domain that isn't a subset of the current domain will usually fail. <p> Since there's no way to discover at runtime the original path and domain of a given cookie, we've added an option called 'recurse' to try all sub-domains of the current domain with all paths that are a subset of the current path. Beware; this option can be slow. In big-O notation, it operates in O(n*m) time, where n is the number of dots in the domain name and m is the number of slashes in the path.

### Usage

`
deleteCookie(name)
`

### Parameters

Parameter | Description
--------- | -----------
name | the name of the cookie to be deleted

## Delete Downloaded File

Deletes downloaded files.

### Usage

`
deleteDownloadedFile(filePattern)
`

### Parameters

Parameter | Description
--------- | -----------
filePattern | the file name pattern

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

Executes an action if the message of a alert equals to the given value.

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

Executes an action if the message of a alert matches the given value.

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

Executes an action if the message of a alert not match the given value.

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

Executes an action if the message of a confirmation dialog equals to the given value.

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

Executes an action if the message of a confirmation dialog matches the given value.

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

Executes an action if the message of a confirmation dialog not match the given value.

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

## Execute If File Downloaded

Executes an action if a file is downloaded by browser.

### Usage

`
executeIfFileDownloaded(action, filePattern)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
filePattern | the file name pattern

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

Executes an action if the message of a alert not equal to the given value.

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

Executes an action if the message of a confirmation dialog not equal to the given value.

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

## Execute If Not File Downloaded

Executes an action if a file is not downloaded by browser.

### Usage

`
executeIfNotFileDownloaded(action, filePattern)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
filePattern | the file name pattern

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

Executes an action if the message of a question prompt dialog not equal to the given value.

### Usage

`
executeIfNotPrompt(action, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
text | the value to match with the result

## Execute If Not QR

Executes an action if the QR code's value from the image tag source encoded in Base64 format not equal to the given value.

### Usage

`
executeIfNotQR(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator
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

Executes an action if the message of a question prompt dialog equals to the given value.

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

Executes an action if the message of a question prompt dialog matches the given value.

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

Executes an action if the message of a question prompt dialog not match the given value.

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

## Execute If QR

Executes an action if the QR code's value from the image tag source encoded in Base64 format equals to the given value.

### Usage

`
executeIfQR(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Execute If QR Match

Executes an action if the QR code's value from the image tag source encoded in Base64 format matches the given value.

### Usage

`
executeIfQRMatch(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Execute If QR Not Match

Executes an action if the QR code's value from the image tag source encoded in Base64 format not match the given value.

### Usage

`
executeIfQRNotMatch(action, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
action | the name of the action to execute
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

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

## Landscape

Set the current device/browser orientation to landscape.

### Usage

`
landscape()
`

### Parameters

Parameter | Description
--------- | -----------

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

## Pinch

Performs pinch gesture on the application element.

### Usage

`
pinch(scale)
`

### Parameters

Parameter | Description
--------- | -----------
scale | Pinch scale of type float. Use a scale between 0 and 1 to "pinch close" or zoom out and a scale greater than 1 to "pinch open" or zoom in.

## Pinch

Performs pinch gesture on the given element.

### Usage

`
pinch(locator, scale)
`

`
pinch(parentLocator, locator, scale)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
scale | Pinch scale of type float. Use a scale between 0 and 1 to "pinch close" or zoom out and a scale greater than 1 to "pinch open" or zoom in.

## Portrait

Set the current device/browser orientation to portrait.

### Usage

`
portrait()
`

### Parameters

Parameter | Description
--------- | -----------

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

Scrolls down on the particular screen element. The main difference from swipe call is that scroll will try to move the current viewport exactly to the next/previous page (the term "page" means the content, which fits into a single device screen)

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

Scrolls down on the whole screen to the first visible element in the parent container. Use this method to emulate precise scrolling in tables or collection views, where it is already known to which element the scrolling should be performed. Although, there is one known limitation there: in case it is necessary to perform too many scroll gestures on parent container to reach the necessary child element (tens of them) then the method call may fail.

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

Scrolls left on the particular screen element. The main difference from swipe call is that scroll will try to move the current viewport exactly to the next/previous page (the term "page" means the content, which fits into a single device screen)

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

Scrolls left on the whole screen to the first visible element in the parent container. Use this method to emulate precise scrolling in tables or collection views, where it is already known to which element the scrolling should be performed. Although, there is one known limitation there: in case it is necessary to perform too many scroll gestures on parent container to reach the necessary child element (tens of them) then the method call may fail.

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

Scrolls right on the particular screen element. The main difference from swipe call is that scroll will try to move the current viewport exactly to the next/previous page (the term "page" means the content, which fits into a single device screen)

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

Scrolls right on the whole screen to the first visible element in the parent container. Use this method to emulate precise scrolling in tables or collection views, where it is already known to which element the scrolling should be performed. Although, there is one known limitation there: in case it is necessary to perform too many scroll gestures on parent container to reach the necessary child element (tens of them) then the method call may fail.

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

Scrolls up on the particular screen element. The main difference from swipe call is that scroll will try to move the current viewport exactly to the next/previous page (the term "page" means the content, which fits into a single device screen)

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

Scrolls up on the whole screen to the first visible element in the parent container. Use this method to emulate precise scrolling in tables or collection views, where it is already known to which element the scrolling should be performed. Although, there is one known limitation there: in case it is necessary to perform too many scroll gestures on parent container to reach the necessary child element (tens of them) then the method call may fail.

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

## Select

Select an option from a drop-down using an option locator.

 <p> Option locators provide different ways of specifying options of an HTML Select element (e.g. for selecting a specific option, or for asserting that the selected option satisfies a specification). There are several forms of Select Option Locator. </p> <ul> <li><strong>label</strong>=<em>labelPattern</em>: matches options based on their labels, i.e. the visible text. (This is the default.) <ul class="first last simple"> <li>label=regexp:^[Oo]ther</li> </ul> </li> <li><strong>value</strong>=<em>valuePattern</em>: matches options based on their values. <ul class="first last simple"> <li>value=other</li> </ul> </li> <li><strong>id</strong>=<em>id</em>: <p> matches options based on their ids. <ul class="first last simple"> <li>id=option1</li> </ul> </li> <li><strong>index</strong>=<em>index</em>: matches an option based on its index (offset from zero). <ul class="first last simple"> <li>index=2</li> </ul> </li> </ul> <p> If no option locator prefix is provided, the default behaviour is to match on <strong>label</strong>. </p>

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

 <p> Window locators provide different ways of specifying the window object: by title, by internal JavaScript "name," or by JavaScript variable. </p> <ul> <li><strong>title</strong>=<em>My Special Window</em>: Finds the window using the text that appears in the title bar. Be careful; two windows can share the same title. If that happens, this locator will just pick one.</li> <li><strong>name</strong>=<em>myWindow</em>: Finds the window using its internal JavaScript "name" property. This is the second parameter "windowName" passed to the JavaScript method window.open(url, windowName, windowFeatures, replaceFlag) (which Selenium intercepts).</li> <li><strong>var</strong>=<em>variableName</em>: Some pop-up windows are unnamed (anonymous), but are associated with a JavaScript variable name in the current application window, e.g. "window.foo = window.open(url);". In those cases, you can open the window using "var=foo".</li> </ul> <p> If no window locator prefix is provided, we'll try to guess what you mean like this: </p> <p> 1.) if windowID is null, (or the string "null") then it is assumed the user is referring to the original window instantiated by the browser). </p> <p> 2.) if the value of the "windowID" parameter is a JavaScript variable name in the current application window, then it is assumed that this variable contains the return value from a call to the JavaScript window.open() method. </p> <p> 3.) Otherwise, selenium looks in a hash it maintains that maps string names to window "names". </p> <p> 4.) If <em>that</em> fails, we'll try looping over all of the known windows to try to find the appropriate "title". Since "title" is not necessarily unique, this may have unexpected behavior. </p> <p> If you're having trouble figuring out the name of a window that you want to manipulate, look at the Selenium log messages which identify the names of windows created via window.open (and therefore intercepted by Selenium). You will see messages like the following for each window as it is opened: </p> <p> <code>debug: window.open call intercepted; window ID (which you can use with selectWindow()) is "myNewWindow"</code> </p> <p> In some cases, Selenium will be unable to intercept a call to window.open (if the call occurs during or before the "onLoad" event, for example). (This is bug SEL-339.) In those cases, you can force Selenium to notice the open window's name by using the Selenium openWindow command, using an empty (blank) url, like this: openWindow("", "myFunnyWindow"). </p>

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

## Set Geolocation

Set the current geo location.

### Usage

`
setGeolocation(location)
`

### Parameters

Parameter | Description
--------- | -----------
location | the string of physical location of the browser separated by commas ("latitude,longitude,altitude")

## Set Page Load Timeout

Sets the amount of time to wait for a page load to complete before throwing an error.

### Usage

`
setPageLoadTimeout(timeout)
`

### Parameters

Parameter | Description
--------- | -----------
timeout | a timeout in milliseconds, after which the page load will return with an error

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

Stores the message of a alert in a variable for later access.

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

Stores the message of a confirmation dialog in a variable for later access.

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

Stores the message of a question prompt dialog in a variable for later access.

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

## Store QR

Stores the QR code's value from the image tag source encoded in Base64 format in a variable for later access.

### Usage

`
storeQR(locator, variable)
`

`
storeQR(parentLocator, locator, variable)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
variable | the name of a variable in which the result is to be stored

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

## Swipe Down

Performs a simple "swipe" down gesture on the whole screen. This method does not accept coordinates and simply emulates single swipe with one finger. It might be useful for such cases like album pagination, switching views, etc.

### Usage

`
swipeDown()
`

### Parameters

Parameter | Description
--------- | -----------

## Swipe Down

Performs a simple "swipe" down gesture on the particular screen element. This method does not accept coordinates and simply emulates single swipe with one finger. It might be useful for such cases like album pagination, switching views, etc.

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

Performs a simple "swipe" left gesture on the whole screen. This method does not accept coordinates and simply emulates single swipe with one finger. It might be useful for such cases like album pagination, switching views, etc.

### Usage

`
swipeLeft()
`

### Parameters

Parameter | Description
--------- | -----------

## Swipe Left

Performs a simple "swipe" left gesture on the particular screen element. This method does not accept coordinates and simply emulates single swipe with one finger. It might be useful for such cases like album pagination, switching views, etc.

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

Performs a simple "swipe" right gesture on the whole screen. This method does not accept coordinates and simply emulates single swipe with one finger. It might be useful for such cases like album pagination, switching views, etc.

### Usage

`
swipeRight()
`

### Parameters

Parameter | Description
--------- | -----------

## Swipe Right

Performs a simple "swipe" right gesture on the particular screen element. This method does not accept coordinates and simply emulates single swipe with one finger. It might be useful for such cases like album pagination, switching views, etc.

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

Performs a simple "swipe" up gesture on the whole screen. This method does not accept coordinates and simply emulates single swipe with one finger. It might be useful for such cases like album pagination, switching views, etc.

### Usage

`
swipeUp()
`

### Parameters

Parameter | Description
--------- | -----------

## Swipe Up

Performs a simple "swipe" up gesture on the particular screen element. This method does not accept coordinates and simply emulates single swipe with one finger. It might be useful for such cases like album pagination, switching views, etc.

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

Sends keys to the keyboard representation in the device.

### Usage

`
typeKeys(value)
`

### Parameters

Parameter | Description
--------- | -----------
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

Verifies that the message of a alert equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyAlert(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Alert Match

Verifies that the message of a alert matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyAlertMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Alert Not Match

Verifies that the message of a alert not match the given value. When the verify fails, the test will continue execution, logging the failure.

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

Verifies that the message of a confirmation dialog equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyConfirmation(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Confirmation Match

Verifies that the message of a confirmation dialog matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyConfirmationMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Confirmation Not Match

Verifies that the message of a confirmation dialog not match the given value. When the verify fails, the test will continue execution, logging the failure.

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

## Verify File Contain Line

Verifies the contents of the file contains the given text. This method is useful for testing CSV file's contents.

### Usage

`
verifyFileContainLine(filePattern, charset, text)
`

### Parameters

Parameter | Description
--------- | -----------
filePattern | the file name pattern
charset | the charset
text | the text to compare

## Verify File Downloaded

Verifies that a file is downloaded by browser. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyFileDownloaded(filePattern)
`

### Parameters

Parameter | Description
--------- | -----------
filePattern | the file name pattern

## Verify File First Line

Verifies the first line of the file equals to the given text. This method is useful for testing CSV file's header.

### Usage

`
verifyFileFirstLine(filePattern, charset, text)
`

### Parameters

Parameter | Description
--------- | -----------
filePattern | the file name pattern
charset | the charset
text | the text to compare

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

## Verify Log Contain Line

Verifies the console log contains the given text.

### Usage

`
verifyLogContainLine(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the text to compare

## Verify Log Not Contain Line

Verifies the console log does not contain the given text.

### Usage

`
verifyLogNotContainLine(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the text to compare

## Verify Not Alert

Verifies that the message of a alert not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

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

Verifies that the message of a confirmation dialog not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

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

## Verify Not File Downloaded

Verifies that a file is not downloaded by browser. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotFileDownloaded(filePattern)
`

### Parameters

Parameter | Description
--------- | -----------
filePattern | the file name pattern

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

Verifies that the message of a question prompt dialog not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotPrompt(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Not QR

Verifies that the QR code's value from the image tag source encoded in Base64 format not equal to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyNotQR(locator, text)
`

`
verifyNotQR(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
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

Verifies that the message of a question prompt dialog equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyPrompt(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Prompt Match

Verifies that the message of a question prompt dialog matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyPromptMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Verify Prompt Not Match

Verifies that the message of a question prompt dialog not match the given value. When the verify fails, the test will continue execution, logging the failure.

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

## Verify QR

Verifies that the QR code's value from the image tag source encoded in Base64 format equals to the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyQR(locator, text)
`

`
verifyQR(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Verify QR Match

Verifies that the QR code's value from the image tag source encoded in Base64 format matches the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyQRMatch(locator, text)
`

`
verifyQRMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Verify QR Not Match

Verifies that the QR code's value from the image tag source encoded in Base64 format not match the given value. When the verify fails, the test will continue execution, logging the failure.

### Usage

`
verifyQRNotMatch(locator, text)
`

`
verifyQRNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

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

Waits for the message of a alert equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForAlert(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Alert Match

Waits for the message of a alert matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForAlertMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Alert Not Match

Waits for the message of a alert not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

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

Waits for the message of a confirmation dialog equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForConfirmation(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Confirmation Match

Waits for the message of a confirmation dialog matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForConfirmationMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Confirmation Not Match

Waits for the message of a confirmation dialog not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

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

## Wait For File Downloaded

Waits for a file is downloaded by browser. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForFileDownloaded(filePattern)
`

### Parameters

Parameter | Description
--------- | -----------
filePattern | the file name pattern

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

Waits for the message of a alert not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

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

Waits for the message of a confirmation dialog not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

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

## Wait For Not File Downloaded

Waits for a file is not downloaded by browser. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotFileDownloaded(filePattern)
`

### Parameters

Parameter | Description
--------- | -----------
filePattern | the file name pattern

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

Waits for the message of a question prompt dialog not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotPrompt(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Not QR

Waits for the QR code's value from the image tag source encoded in Base64 format not equal to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForNotQR(locator, text)
`

`
waitForNotQR(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
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

Waits for the message of a question prompt dialog equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForPrompt(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Prompt Match

Waits for the message of a question prompt dialog matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForPromptMatch(text)
`

### Parameters

Parameter | Description
--------- | -----------
text | the value to match with the result

## Wait For Prompt Not Match

Waits for the message of a question prompt dialog not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

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

## Wait For QR

Waits for the QR code's value from the image tag source encoded in Base64 format equals to the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForQR(locator, text)
`

`
waitForQR(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Wait For QR Match

Waits for the QR code's value from the image tag source encoded in Base64 format matches the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForQRMatch(locator, text)
`

`
waitForQRMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

## Wait For QR Not Match

Waits for the QR code's value from the image tag source encoded in Base64 format not match the given value. They will succeed immediately if the condition is already true. However, they will fail and halt the test if the condition does not become true within the current timeout setting.

### Usage

`
waitForQRNotMatch(locator, text)
`

`
waitForQRNotMatch(parentLocator, locator, text)
`

### Parameters

Parameter | Description
--------- | -----------
parentLocator | an element locator of parent element
locator | an element locator
text | the value to match with the result

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

