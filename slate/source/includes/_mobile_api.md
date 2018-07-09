# Mobile API

## Command Table

No | Command | Method | Param 1 | Param 2 | Param 3
--------- | --------- | --------- | --------- | --------- | ---------
1 | Assert Attribute | assertAttribute | locator | name | text
2 | Assert Attribute Match | assertAttributeMatch | locator | name | text
3 | Assert Attribute Not Match | assertAttributeNotMatch | locator | name | text
4 | Assert Background Color | assertBackgroundColor | locator | text | 
5 | Assert Background Color | assertBackgroundColor | parentLocator | locator | text
6 | Assert Border Color | assertBorderColor | locator | text | 
7 | Assert Border Color | assertBorderColor | parentLocator | locator | text
8 | Assert Checked | assertChecked | locator |  | 
9 | Assert Checked | assertChecked | parentLocator | locator | 
10 | Assert Color | assertColor | locator | text | 
11 | Assert Color | assertColor | parentLocator | locator | text
12 | Assert Cursor Position | assertCursorPosition | locator | text | 
13 | Assert Cursor Position | assertCursorPosition | parentLocator | locator | text
14 | Assert Date List Order Asc | assertDateListOrderAsc | locator | format | 
15 | Assert Date List Order Asc | assertDateListOrderAsc | parentLocator | locator | format
16 | Assert Date List Order Desc | assertDateListOrderDesc | locator | format | 
17 | Assert Date List Order Desc | assertDateListOrderDesc | parentLocator | locator | format
18 | Assert Editable | assertEditable | locator |  | 
19 | Assert Editable | assertEditable | parentLocator | locator | 
20 | Assert Element Height | assertElementHeight | locator | text | 
21 | Assert Element Height | assertElementHeight | parentLocator | locator | text
22 | Assert Element Index | assertElementIndex | locator | text | 
23 | Assert Element Index | assertElementIndex | parentLocator | locator | text
24 | Assert Element Position Left | assertElementPositionLeft | locator | text | 
25 | Assert Element Position Left | assertElementPositionLeft | parentLocator | locator | text
26 | Assert Element Position Top | assertElementPositionTop | locator | text | 
27 | Assert Element Position Top | assertElementPositionTop | parentLocator | locator | text
28 | Assert Element Width | assertElementWidth | locator | text | 
29 | Assert Element Width | assertElementWidth | parentLocator | locator | text
30 | Assert Eval | assertEval | expression | text | 
31 | Assert Eval Script | assertEvalScript | script | text | 
32 | Assert Eval Script Match | assertEvalScriptMatch | script | text | 
33 | Assert Eval Script Not Match | assertEvalScriptNotMatch | script | text | 
34 | Assert Exists In Database | assertExistsInDatabase | sql |  | 
35 | Assert Expression | assertExpression | expression | text | 
36 | Assert Expression Match | assertExpressionMatch | expression | text | 
37 | Assert Expression Not Match | assertExpressionNotMatch | expression | text | 
38 | Assert Font Family | assertFontFamily | locator | text | 
39 | Assert Font Family | assertFontFamily | parentLocator | locator | text
40 | Assert Font Family Match | assertFontFamilyMatch | locator | text | 
41 | Assert Font Family Match | assertFontFamilyMatch | parentLocator | locator | text
42 | Assert Font Family Not Match | assertFontFamilyNotMatch | locator | text | 
43 | Assert Font Family Not Match | assertFontFamilyNotMatch | parentLocator | locator | text
44 | Assert Font Size | assertFontSize | locator | text | 
45 | Assert Font Size | assertFontSize | parentLocator | locator | text
46 | Assert Font Size Match | assertFontSizeMatch | locator | text | 
47 | Assert Font Size Match | assertFontSizeMatch | parentLocator | locator | text
48 | Assert Font Size Not Match | assertFontSizeNotMatch | locator | text | 
49 | Assert Font Size Not Match | assertFontSizeNotMatch | parentLocator | locator | text
50 | Assert Font Style | assertFontStyle | locator | text | 
51 | Assert Font Style | assertFontStyle | parentLocator | locator | text
52 | Assert Font Style Match | assertFontStyleMatch | locator | text | 
53 | Assert Font Style Match | assertFontStyleMatch | parentLocator | locator | text
54 | Assert Font Style Not Match | assertFontStyleNotMatch | locator | text | 
55 | Assert Font Style Not Match | assertFontStyleNotMatch | parentLocator | locator | text
56 | Assert Font Weight | assertFontWeight | locator | text | 
57 | Assert Font Weight | assertFontWeight | parentLocator | locator | text
58 | Assert Font Weight Match | assertFontWeightMatch | locator | text | 
59 | Assert Font Weight Match | assertFontWeightMatch | parentLocator | locator | text
60 | Assert Font Weight Not Match | assertFontWeightNotMatch | locator | text | 
61 | Assert Font Weight Not Match | assertFontWeightNotMatch | parentLocator | locator | text
62 | Assert Integer List Order Asc | assertIntegerListOrderAsc | locator |  | 
63 | Assert Integer List Order Asc | assertIntegerListOrderAsc | parentLocator | locator | 
64 | Assert Integer List Order Desc | assertIntegerListOrderDesc | locator |  | 
65 | Assert Integer List Order Desc | assertIntegerListOrderDesc | parentLocator | locator | 
66 | Assert List Contain | assertListContain | variable | text | 
67 | Assert List Not Contain | assertListNotContain | variable | text | 
68 | Assert List Order Asc | assertListOrderAsc | variable |  | 
69 | Assert List Order Desc | assertListOrderDesc | variable |  | 
70 | Assert Not Attribute | assertNotAttribute | locator | name | text
71 | Assert Not Background Color | assertNotBackgroundColor | locator | text | 
72 | Assert Not Background Color | assertNotBackgroundColor | parentLocator | locator | text
73 | Assert Not Border Color | assertNotBorderColor | locator | text | 
74 | Assert Not Border Color | assertNotBorderColor | parentLocator | locator | text
75 | Assert Not Checked | assertNotChecked | locator |  | 
76 | Assert Not Checked | assertNotChecked | parentLocator | locator | 
77 | Assert Not Color | assertNotColor | locator | text | 
78 | Assert Not Color | assertNotColor | parentLocator | locator | text
79 | Assert Not Cursor Position | assertNotCursorPosition | locator | text | 
80 | Assert Not Cursor Position | assertNotCursorPosition | parentLocator | locator | text
81 | Assert Not Editable | assertNotEditable | locator |  | 
82 | Assert Not Editable | assertNotEditable | parentLocator | locator | 
83 | Assert Not Element Height | assertNotElementHeight | locator | text | 
84 | Assert Not Element Height | assertNotElementHeight | parentLocator | locator | text
85 | Assert Not Element Index | assertNotElementIndex | locator | text | 
86 | Assert Not Element Index | assertNotElementIndex | parentLocator | locator | text
87 | Assert Not Element Position Left | assertNotElementPositionLeft | locator | text | 
88 | Assert Not Element Position Left | assertNotElementPositionLeft | parentLocator | locator | text
89 | Assert Not Element Position Top | assertNotElementPositionTop | locator | text | 
90 | Assert Not Element Position Top | assertNotElementPositionTop | parentLocator | locator | text
91 | Assert Not Element Width | assertNotElementWidth | locator | text | 
92 | Assert Not Element Width | assertNotElementWidth | parentLocator | locator | text
93 | Assert Not Eval | assertNotEval | expression | text | 
94 | Assert Not Eval Script | assertNotEvalScript | script | text | 
95 | Assert Not Exists In Database | assertNotExistsInDatabase | sql |  | 
96 | Assert Not Expression | assertNotExpression | expression | text | 
97 | Assert Not Font Family | assertNotFontFamily | locator | text | 
98 | Assert Not Font Family | assertNotFontFamily | parentLocator | locator | text
99 | Assert Not Font Size | assertNotFontSize | locator | text | 
100 | Assert Not Font Size | assertNotFontSize | parentLocator | locator | text
101 | Assert Not Font Style | assertNotFontStyle | locator | text | 
102 | Assert Not Font Style | assertNotFontStyle | parentLocator | locator | text
103 | Assert Not Font Weight | assertNotFontWeight | locator | text | 
104 | Assert Not Font Weight | assertNotFontWeight | parentLocator | locator | text
105 | Assert Not Select Options | assertNotSelectOptions | locator | text | 
106 | Assert Not Select Options | assertNotSelectOptions | parentLocator | locator | text
107 | Assert Not Selected Id | assertNotSelectedId | locator | text | 
108 | Assert Not Selected Id | assertNotSelectedId | parentLocator | locator | text
109 | Assert Not Selected Ids | assertNotSelectedIds | locator | text | 
110 | Assert Not Selected Ids | assertNotSelectedIds | parentLocator | locator | text
111 | Assert Not Selected Index | assertNotSelectedIndex | locator | text | 
112 | Assert Not Selected Index | assertNotSelectedIndex | parentLocator | locator | text
113 | Assert Not Selected Indexes | assertNotSelectedIndexes | locator | text | 
114 | Assert Not Selected Indexes | assertNotSelectedIndexes | parentLocator | locator | text
115 | Assert Not Selected Label | assertNotSelectedLabel | locator | text | 
116 | Assert Not Selected Label | assertNotSelectedLabel | parentLocator | locator | text
117 | Assert Not Selected Labels | assertNotSelectedLabels | locator | text | 
118 | Assert Not Selected Labels | assertNotSelectedLabels | parentLocator | locator | text
119 | Assert Not Selected Value | assertNotSelectedValue | locator | text | 
120 | Assert Not Selected Value | assertNotSelectedValue | parentLocator | locator | text
121 | Assert Not Selected Values | assertNotSelectedValues | locator | text | 
122 | Assert Not Selected Values | assertNotSelectedValues | parentLocator | locator | text
123 | Assert Not Something Selected | assertNotSomethingSelected | locator |  | 
124 | Assert Not Something Selected | assertNotSomethingSelected | parentLocator | locator | 
125 | Assert Not Text | assertNotText | locator | text | 
126 | Assert Not Text | assertNotText | parentLocator | locator | text
127 | Assert Not Text Alignment | assertNotTextAlignment | locator | text | 
128 | Assert Not Text Alignment | assertNotTextAlignment | parentLocator | locator | text
129 | Assert Not Text Decoration | assertNotTextDecoration | locator | text | 
130 | Assert Not Text Decoration | assertNotTextDecoration | parentLocator | locator | text
131 | Assert Not Text Empty | assertNotTextEmpty | locator |  | 
132 | Assert Not Text Empty | assertNotTextEmpty | parentLocator | locator | 
133 | Assert Not Value | assertNotValue | locator | text | 
134 | Assert Not Value | assertNotValue | parentLocator | locator | text
135 | Assert Not Value Empty | assertNotValueEmpty | locator |  | 
136 | Assert Not Value Empty | assertNotValueEmpty | parentLocator | locator | 
137 | Assert Not Variable | assertNotVariable | variable | text | 
138 | Assert Not Visible | assertNotVisible | locator |  | 
139 | Assert Not Visible | assertNotVisible | parentLocator | locator | 
140 | Assert Row Count | assertRowCount | sql | count | 
141 | Assert Row Count Greater Than | assertRowCountGreaterThan | sql | count | 
142 | Assert Row Count Less Than | assertRowCountLessThan | sql | count | 
143 | Assert Select Options | assertSelectOptions | locator | text | 
144 | Assert Select Options | assertSelectOptions | parentLocator | locator | text
145 | Assert Select Options Match | assertSelectOptionsMatch | locator | text | 
146 | Assert Select Options Match | assertSelectOptionsMatch | parentLocator | locator | text
147 | Assert Select Options Not Match | assertSelectOptionsNotMatch | locator | text | 
148 | Assert Select Options Not Match | assertSelectOptionsNotMatch | parentLocator | locator | text
149 | Assert Selected Id | assertSelectedId | locator | text | 
150 | Assert Selected Id | assertSelectedId | parentLocator | locator | text
151 | Assert Selected Id Match | assertSelectedIdMatch | locator | text | 
152 | Assert Selected Id Match | assertSelectedIdMatch | parentLocator | locator | text
153 | Assert Selected Id Not Match | assertSelectedIdNotMatch | locator | text | 
154 | Assert Selected Id Not Match | assertSelectedIdNotMatch | parentLocator | locator | text
155 | Assert Selected Ids | assertSelectedIds | locator | text | 
156 | Assert Selected Ids | assertSelectedIds | parentLocator | locator | text
157 | Assert Selected Ids Match | assertSelectedIdsMatch | locator | text | 
158 | Assert Selected Ids Match | assertSelectedIdsMatch | parentLocator | locator | text
159 | Assert Selected Ids Not Match | assertSelectedIdsNotMatch | locator | text | 
160 | Assert Selected Ids Not Match | assertSelectedIdsNotMatch | parentLocator | locator | text
161 | Assert Selected Index | assertSelectedIndex | locator | text | 
162 | Assert Selected Index | assertSelectedIndex | parentLocator | locator | text
163 | Assert Selected Index Match | assertSelectedIndexMatch | locator | text | 
164 | Assert Selected Index Match | assertSelectedIndexMatch | parentLocator | locator | text
165 | Assert Selected Index Not Match | assertSelectedIndexNotMatch | locator | text | 
166 | Assert Selected Index Not Match | assertSelectedIndexNotMatch | parentLocator | locator | text
167 | Assert Selected Indexes | assertSelectedIndexes | locator | text | 
168 | Assert Selected Indexes | assertSelectedIndexes | parentLocator | locator | text
169 | Assert Selected Indexes Match | assertSelectedIndexesMatch | locator | text | 
170 | Assert Selected Indexes Match | assertSelectedIndexesMatch | parentLocator | locator | text
171 | Assert Selected Indexes Not Match | assertSelectedIndexesNotMatch | locator | text | 
172 | Assert Selected Indexes Not Match | assertSelectedIndexesNotMatch | parentLocator | locator | text
173 | Assert Selected Label | assertSelectedLabel | locator | text | 
174 | Assert Selected Label | assertSelectedLabel | parentLocator | locator | text
175 | Assert Selected Label Match | assertSelectedLabelMatch | locator | text | 
176 | Assert Selected Label Match | assertSelectedLabelMatch | parentLocator | locator | text
177 | Assert Selected Label Not Match | assertSelectedLabelNotMatch | locator | text | 
178 | Assert Selected Label Not Match | assertSelectedLabelNotMatch | parentLocator | locator | text
179 | Assert Selected Labels | assertSelectedLabels | locator | text | 
180 | Assert Selected Labels | assertSelectedLabels | parentLocator | locator | text
181 | Assert Selected Labels Match | assertSelectedLabelsMatch | locator | text | 
182 | Assert Selected Labels Match | assertSelectedLabelsMatch | parentLocator | locator | text
183 | Assert Selected Labels Not Match | assertSelectedLabelsNotMatch | locator | text | 
184 | Assert Selected Labels Not Match | assertSelectedLabelsNotMatch | parentLocator | locator | text
185 | Assert Selected Value | assertSelectedValue | locator | text | 
186 | Assert Selected Value | assertSelectedValue | parentLocator | locator | text
187 | Assert Selected Value Match | assertSelectedValueMatch | locator | text | 
188 | Assert Selected Value Match | assertSelectedValueMatch | parentLocator | locator | text
189 | Assert Selected Value Not Match | assertSelectedValueNotMatch | locator | text | 
190 | Assert Selected Value Not Match | assertSelectedValueNotMatch | parentLocator | locator | text
191 | Assert Selected Values | assertSelectedValues | locator | text | 
192 | Assert Selected Values | assertSelectedValues | parentLocator | locator | text
193 | Assert Selected Values Match | assertSelectedValuesMatch | locator | text | 
194 | Assert Selected Values Match | assertSelectedValuesMatch | parentLocator | locator | text
195 | Assert Selected Values Not Match | assertSelectedValuesNotMatch | locator | text | 
196 | Assert Selected Values Not Match | assertSelectedValuesNotMatch | parentLocator | locator | text
197 | Assert Something Selected | assertSomethingSelected | locator |  | 
198 | Assert Something Selected | assertSomethingSelected | parentLocator | locator | 
199 | Assert Text | assertText | locator | text | 
200 | Assert Text | assertText | parentLocator | locator | text
201 | Assert Text Alignment | assertTextAlignment | locator | text | 
202 | Assert Text Alignment | assertTextAlignment | parentLocator | locator | text
203 | Assert Text Alignment Match | assertTextAlignmentMatch | locator | text | 
204 | Assert Text Alignment Match | assertTextAlignmentMatch | parentLocator | locator | text
205 | Assert Text Alignment Not Match | assertTextAlignmentNotMatch | locator | text | 
206 | Assert Text Alignment Not Match | assertTextAlignmentNotMatch | parentLocator | locator | text
207 | Assert Text Decoration | assertTextDecoration | locator | text | 
208 | Assert Text Decoration | assertTextDecoration | parentLocator | locator | text
209 | Assert Text Decoration Match | assertTextDecorationMatch | locator | text | 
210 | Assert Text Decoration Match | assertTextDecorationMatch | parentLocator | locator | text
211 | Assert Text Decoration Not Match | assertTextDecorationNotMatch | locator | text | 
212 | Assert Text Decoration Not Match | assertTextDecorationNotMatch | parentLocator | locator | text
213 | Assert Text Empty | assertTextEmpty | locator |  | 
214 | Assert Text Empty | assertTextEmpty | parentLocator | locator | 
215 | Assert Text List Order Asc | assertTextListOrderAsc | locator |  | 
216 | Assert Text List Order Asc | assertTextListOrderAsc | parentLocator | locator | 
217 | Assert Text List Order Desc | assertTextListOrderDesc | locator |  | 
218 | Assert Text List Order Desc | assertTextListOrderDesc | parentLocator | locator | 
219 | Assert Text Match | assertTextMatch | locator | text | 
220 | Assert Text Match | assertTextMatch | parentLocator | locator | text
221 | Assert Text Not Match | assertTextNotMatch | locator | text | 
222 | Assert Text Not Match | assertTextNotMatch | parentLocator | locator | text
223 | Assert Value | assertValue | locator | text | 
224 | Assert Value | assertValue | parentLocator | locator | text
225 | Assert Value Empty | assertValueEmpty | locator |  | 
226 | Assert Value Empty | assertValueEmpty | parentLocator | locator | 
227 | Assert Value Match | assertValueMatch | locator | text | 
228 | Assert Value Match | assertValueMatch | parentLocator | locator | text
229 | Assert Value Not Match | assertValueNotMatch | locator | text | 
230 | Assert Value Not Match | assertValueNotMatch | parentLocator | locator | text
231 | Assert Variable | assertVariable | variable | text | 
232 | Assert Visible | assertVisible | locator |  | 
233 | Assert Visible | assertVisible | parentLocator | locator | 
234 | Echo | echo | message |  | 
235 | Execute | execute | action |  | 
236 | Execute Each | executeEach | action | locator | variable
237 | Execute If Checked | executeIfChecked | action | locator | 
238 | Execute If Checked | executeIfChecked | action | parentLocator | locator
239 | Execute If Editable | executeIfEditable | action | locator | 
240 | Execute If Editable | executeIfEditable | action | parentLocator | locator
241 | Execute If Eval | executeIfEval | action | expression | text
242 | Execute If Eval Script | executeIfEvalScript | action | script | text
243 | Execute If Eval Script Match | executeIfEvalScriptMatch | action | script | text
244 | Execute If Eval Script Not Match | executeIfEvalScriptNotMatch | action | script | text
245 | Execute If Exists In Database | executeIfExistsInDatabase | action | sql | 
246 | Execute If Expression | executeIfExpression | action | expression | text
247 | Execute If Expression Match | executeIfExpressionMatch | action | expression | text
248 | Execute If Expression Not Match | executeIfExpressionNotMatch | action | expression | text
249 | Execute If List Contain | executeIfListContain | action | variable | text
250 | Execute If List Not Contain | executeIfListNotContain | action | variable | text
251 | Execute If Not Checked | executeIfNotChecked | action | locator | 
252 | Execute If Not Checked | executeIfNotChecked | action | parentLocator | locator
253 | Execute If Not Editable | executeIfNotEditable | action | locator | 
254 | Execute If Not Editable | executeIfNotEditable | action | parentLocator | locator
255 | Execute If Not Eval | executeIfNotEval | action | expression | text
256 | Execute If Not Eval Script | executeIfNotEvalScript | action | script | text
257 | Execute If Not Exists In Database | executeIfNotExistsInDatabase | action | sql | 
258 | Execute If Not Expression | executeIfNotExpression | action | expression | text
259 | Execute If Not Selected Id | executeIfNotSelectedId | action | locator | text
260 | Execute If Not Selected Index | executeIfNotSelectedIndex | action | locator | text
261 | Execute If Not Selected Label | executeIfNotSelectedLabel | action | locator | text
262 | Execute If Not Selected Value | executeIfNotSelectedValue | action | locator | text
263 | Execute If Not Something Selected | executeIfNotSomethingSelected | action | locator | 
264 | Execute If Not Something Selected | executeIfNotSomethingSelected | action | parentLocator | locator
265 | Execute If Not Text | executeIfNotText | action | locator | text
266 | Execute If Not Text Empty | executeIfNotTextEmpty | action | locator | 
267 | Execute If Not Text Empty | executeIfNotTextEmpty | action | parentLocator | locator
268 | Execute If Not Value | executeIfNotValue | action | locator | text
269 | Execute If Not Value Empty | executeIfNotValueEmpty | action | locator | 
270 | Execute If Not Value Empty | executeIfNotValueEmpty | action | parentLocator | locator
271 | Execute If Not Variable | executeIfNotVariable | action | variable | text
272 | Execute If Not Visible | executeIfNotVisible | action | locator | 
273 | Execute If Not Visible | executeIfNotVisible | action | parentLocator | locator
274 | Execute If Selected Id | executeIfSelectedId | action | locator | text
275 | Execute If Selected Id Match | executeIfSelectedIdMatch | action | locator | text
276 | Execute If Selected Id Not Match | executeIfSelectedIdNotMatch | action | locator | text
277 | Execute If Selected Index | executeIfSelectedIndex | action | locator | text
278 | Execute If Selected Index Match | executeIfSelectedIndexMatch | action | locator | text
279 | Execute If Selected Index Not Match | executeIfSelectedIndexNotMatch | action | locator | text
280 | Execute If Selected Label | executeIfSelectedLabel | action | locator | text
281 | Execute If Selected Label Match | executeIfSelectedLabelMatch | action | locator | text
282 | Execute If Selected Label Not Match | executeIfSelectedLabelNotMatch | action | locator | text
283 | Execute If Selected Value | executeIfSelectedValue | action | locator | text
284 | Execute If Selected Value Match | executeIfSelectedValueMatch | action | locator | text
285 | Execute If Selected Value Not Match | executeIfSelectedValueNotMatch | action | locator | text
286 | Execute If Something Selected | executeIfSomethingSelected | action | locator | 
287 | Execute If Something Selected | executeIfSomethingSelected | action | parentLocator | locator
288 | Execute If Text | executeIfText | action | locator | text
289 | Execute If Text Empty | executeIfTextEmpty | action | locator | 
290 | Execute If Text Empty | executeIfTextEmpty | action | parentLocator | locator
291 | Execute If Text Match | executeIfTextMatch | action | locator | text
292 | Execute If Text Not Match | executeIfTextNotMatch | action | locator | text
293 | Execute If Value | executeIfValue | action | locator | text
294 | Execute If Value Empty | executeIfValueEmpty | action | locator | 
295 | Execute If Value Empty | executeIfValueEmpty | action | parentLocator | locator
296 | Execute If Value Match | executeIfValueMatch | action | locator | text
297 | Execute If Value Not Match | executeIfValueNotMatch | action | locator | text
298 | Execute If Variable | executeIfVariable | action | variable | text
299 | Execute If Visible | executeIfVisible | action | locator | 
300 | Execute If Visible | executeIfVisible | action | parentLocator | locator
301 | Execute Loop | executeLoop | action | times | 
302 | Go Back | goBack |  |  | 
303 | Go Forward | goForward |  |  | 
304 | Highlight | highlight | locator |  | 
305 | Highlight | highlight | parentLocator | locator | 
306 | Pause | pause | waitTime |  | 
307 | Refresh | refresh |  |  | 
308 | Run Script | runScript | script |  | 
309 | Set Timeout | setTimeout | timeout |  | 
310 | Store | store | text | variable | 
311 | Store Attribute | storeAttribute | locator | name | variable
312 | Store Current Date | storeCurrentDate | variable |  | 
313 | Store Cursor Position | storeCursorPosition | locator | variable | 
314 | Store Cursor Position | storeCursorPosition | parentLocator | locator | variable
315 | Store Eval | storeEval | expression | variable | 
316 | Store Eval Script | storeEvalScript | script | variable | 
317 | Store Expression | storeExpression | expression | variable | 
318 | Store Push | storePush | text | variable | 
319 | Store Select Options | storeSelectOptions | locator | variable | 
320 | Store Select Options | storeSelectOptions | parentLocator | locator | variable
321 | Store Selected Id | storeSelectedId | locator | variable | 
322 | Store Selected Id | storeSelectedId | parentLocator | locator | variable
323 | Store Selected Ids | storeSelectedIds | locator | variable | 
324 | Store Selected Ids | storeSelectedIds | parentLocator | locator | variable
325 | Store Selected Index | storeSelectedIndex | locator | variable | 
326 | Store Selected Index | storeSelectedIndex | parentLocator | locator | variable
327 | Store Selected Indexes | storeSelectedIndexes | locator | variable | 
328 | Store Selected Indexes | storeSelectedIndexes | parentLocator | locator | variable
329 | Store Selected Label | storeSelectedLabel | locator | variable | 
330 | Store Selected Label | storeSelectedLabel | parentLocator | locator | variable
331 | Store Selected Labels | storeSelectedLabels | locator | variable | 
332 | Store Selected Labels | storeSelectedLabels | parentLocator | locator | variable
333 | Store Selected Value | storeSelectedValue | locator | variable | 
334 | Store Selected Value | storeSelectedValue | parentLocator | locator | variable
335 | Store Selected Values | storeSelectedValues | locator | variable | 
336 | Store Selected Values | storeSelectedValues | parentLocator | locator | variable
337 | Store Text | storeText | locator | variable | 
338 | Store Text | storeText | parentLocator | locator | variable
339 | Store Value | storeValue | locator | variable | 
340 | Store Value | storeValue | parentLocator | locator | variable
341 | Verify Attribute | verifyAttribute | locator | name | text
342 | Verify Attribute Match | verifyAttributeMatch | locator | name | text
343 | Verify Attribute Not Match | verifyAttributeNotMatch | locator | name | text
344 | Verify Background Color | verifyBackgroundColor | locator | text | 
345 | Verify Background Color | verifyBackgroundColor | parentLocator | locator | text
346 | Verify Border Color | verifyBorderColor | locator | text | 
347 | Verify Border Color | verifyBorderColor | parentLocator | locator | text
348 | Verify Checked | verifyChecked | locator |  | 
349 | Verify Checked | verifyChecked | parentLocator | locator | 
350 | Verify Color | verifyColor | locator | text | 
351 | Verify Color | verifyColor | parentLocator | locator | text
352 | Verify Cursor Position | verifyCursorPosition | locator | text | 
353 | Verify Cursor Position | verifyCursorPosition | parentLocator | locator | text
354 | Verify Date List Order Asc | verifyDateListOrderAsc | locator | format | 
355 | Verify Date List Order Asc | verifyDateListOrderAsc | parentLocator | locator | format
356 | Verify Date List Order Desc | verifyDateListOrderDesc | locator | format | 
357 | Verify Date List Order Desc | verifyDateListOrderDesc | parentLocator | locator | format
358 | Verify Editable | verifyEditable | locator |  | 
359 | Verify Editable | verifyEditable | parentLocator | locator | 
360 | Verify Element Height | verifyElementHeight | locator | text | 
361 | Verify Element Height | verifyElementHeight | parentLocator | locator | text
362 | Verify Element Index | verifyElementIndex | locator | text | 
363 | Verify Element Index | verifyElementIndex | parentLocator | locator | text
364 | Verify Element Position Left | verifyElementPositionLeft | locator | text | 
365 | Verify Element Position Left | verifyElementPositionLeft | parentLocator | locator | text
366 | Verify Element Position Top | verifyElementPositionTop | locator | text | 
367 | Verify Element Position Top | verifyElementPositionTop | parentLocator | locator | text
368 | Verify Element Width | verifyElementWidth | locator | text | 
369 | Verify Element Width | verifyElementWidth | parentLocator | locator | text
370 | Verify Eval | verifyEval | expression | text | 
371 | Verify Eval Script | verifyEvalScript | script | text | 
372 | Verify Eval Script Match | verifyEvalScriptMatch | script | text | 
373 | Verify Eval Script Not Match | verifyEvalScriptNotMatch | script | text | 
374 | Verify Exists In Database | verifyExistsInDatabase | sql |  | 
375 | Verify Expression | verifyExpression | expression | text | 
376 | Verify Expression Match | verifyExpressionMatch | expression | text | 
377 | Verify Expression Not Match | verifyExpressionNotMatch | expression | text | 
378 | Verify Font Family | verifyFontFamily | locator | text | 
379 | Verify Font Family | verifyFontFamily | parentLocator | locator | text
380 | Verify Font Family Match | verifyFontFamilyMatch | locator | text | 
381 | Verify Font Family Match | verifyFontFamilyMatch | parentLocator | locator | text
382 | Verify Font Family Not Match | verifyFontFamilyNotMatch | locator | text | 
383 | Verify Font Family Not Match | verifyFontFamilyNotMatch | parentLocator | locator | text
384 | Verify Font Size | verifyFontSize | locator | text | 
385 | Verify Font Size | verifyFontSize | parentLocator | locator | text
386 | Verify Font Size Match | verifyFontSizeMatch | locator | text | 
387 | Verify Font Size Match | verifyFontSizeMatch | parentLocator | locator | text
388 | Verify Font Size Not Match | verifyFontSizeNotMatch | locator | text | 
389 | Verify Font Size Not Match | verifyFontSizeNotMatch | parentLocator | locator | text
390 | Verify Font Style | verifyFontStyle | locator | text | 
391 | Verify Font Style | verifyFontStyle | parentLocator | locator | text
392 | Verify Font Style Match | verifyFontStyleMatch | locator | text | 
393 | Verify Font Style Match | verifyFontStyleMatch | parentLocator | locator | text
394 | Verify Font Style Not Match | verifyFontStyleNotMatch | locator | text | 
395 | Verify Font Style Not Match | verifyFontStyleNotMatch | parentLocator | locator | text
396 | Verify Font Weight | verifyFontWeight | locator | text | 
397 | Verify Font Weight | verifyFontWeight | parentLocator | locator | text
398 | Verify Font Weight Match | verifyFontWeightMatch | locator | text | 
399 | Verify Font Weight Match | verifyFontWeightMatch | parentLocator | locator | text
400 | Verify Font Weight Not Match | verifyFontWeightNotMatch | locator | text | 
401 | Verify Font Weight Not Match | verifyFontWeightNotMatch | parentLocator | locator | text
402 | Verify Integer List Order Asc | verifyIntegerListOrderAsc | locator |  | 
403 | Verify Integer List Order Asc | verifyIntegerListOrderAsc | parentLocator | locator | 
404 | Verify Integer List Order Desc | verifyIntegerListOrderDesc | locator |  | 
405 | Verify Integer List Order Desc | verifyIntegerListOrderDesc | parentLocator | locator | 
406 | Verify List Contain | verifyListContain | variable | text | 
407 | Verify List Not Contain | verifyListNotContain | variable | text | 
408 | Verify List Order Asc | verifyListOrderAsc | variable |  | 
409 | Verify List Order Desc | verifyListOrderDesc | variable |  | 
410 | Verify Not Attribute | verifyNotAttribute | locator | name | text
411 | Verify Not Background Color | verifyNotBackgroundColor | locator | text | 
412 | Verify Not Background Color | verifyNotBackgroundColor | parentLocator | locator | text
413 | Verify Not Border Color | verifyNotBorderColor | locator | text | 
414 | Verify Not Border Color | verifyNotBorderColor | parentLocator | locator | text
415 | Verify Not Checked | verifyNotChecked | locator |  | 
416 | Verify Not Checked | verifyNotChecked | parentLocator | locator | 
417 | Verify Not Color | verifyNotColor | locator | text | 
418 | Verify Not Color | verifyNotColor | parentLocator | locator | text
419 | Verify Not Cursor Position | verifyNotCursorPosition | locator | text | 
420 | Verify Not Cursor Position | verifyNotCursorPosition | parentLocator | locator | text
421 | Verify Not Editable | verifyNotEditable | locator |  | 
422 | Verify Not Editable | verifyNotEditable | parentLocator | locator | 
423 | Verify Not Element Height | verifyNotElementHeight | locator | text | 
424 | Verify Not Element Height | verifyNotElementHeight | parentLocator | locator | text
425 | Verify Not Element Index | verifyNotElementIndex | locator | text | 
426 | Verify Not Element Index | verifyNotElementIndex | parentLocator | locator | text
427 | Verify Not Element Position Left | verifyNotElementPositionLeft | locator | text | 
428 | Verify Not Element Position Left | verifyNotElementPositionLeft | parentLocator | locator | text
429 | Verify Not Element Position Top | verifyNotElementPositionTop | locator | text | 
430 | Verify Not Element Position Top | verifyNotElementPositionTop | parentLocator | locator | text
431 | Verify Not Element Width | verifyNotElementWidth | locator | text | 
432 | Verify Not Element Width | verifyNotElementWidth | parentLocator | locator | text
433 | Verify Not Eval | verifyNotEval | expression | text | 
434 | Verify Not Eval Script | verifyNotEvalScript | script | text | 
435 | Verify Not Exists In Database | verifyNotExistsInDatabase | sql |  | 
436 | Verify Not Expression | verifyNotExpression | expression | text | 
437 | Verify Not Font Family | verifyNotFontFamily | locator | text | 
438 | Verify Not Font Family | verifyNotFontFamily | parentLocator | locator | text
439 | Verify Not Font Size | verifyNotFontSize | locator | text | 
440 | Verify Not Font Size | verifyNotFontSize | parentLocator | locator | text
441 | Verify Not Font Style | verifyNotFontStyle | locator | text | 
442 | Verify Not Font Style | verifyNotFontStyle | parentLocator | locator | text
443 | Verify Not Font Weight | verifyNotFontWeight | locator | text | 
444 | Verify Not Font Weight | verifyNotFontWeight | parentLocator | locator | text
445 | Verify Not Select Options | verifyNotSelectOptions | locator | text | 
446 | Verify Not Select Options | verifyNotSelectOptions | parentLocator | locator | text
447 | Verify Not Selected Id | verifyNotSelectedId | locator | text | 
448 | Verify Not Selected Id | verifyNotSelectedId | parentLocator | locator | text
449 | Verify Not Selected Ids | verifyNotSelectedIds | locator | text | 
450 | Verify Not Selected Ids | verifyNotSelectedIds | parentLocator | locator | text
451 | Verify Not Selected Index | verifyNotSelectedIndex | locator | text | 
452 | Verify Not Selected Index | verifyNotSelectedIndex | parentLocator | locator | text
453 | Verify Not Selected Indexes | verifyNotSelectedIndexes | locator | text | 
454 | Verify Not Selected Indexes | verifyNotSelectedIndexes | parentLocator | locator | text
455 | Verify Not Selected Label | verifyNotSelectedLabel | locator | text | 
456 | Verify Not Selected Label | verifyNotSelectedLabel | parentLocator | locator | text
457 | Verify Not Selected Labels | verifyNotSelectedLabels | locator | text | 
458 | Verify Not Selected Labels | verifyNotSelectedLabels | parentLocator | locator | text
459 | Verify Not Selected Value | verifyNotSelectedValue | locator | text | 
460 | Verify Not Selected Value | verifyNotSelectedValue | parentLocator | locator | text
461 | Verify Not Selected Values | verifyNotSelectedValues | locator | text | 
462 | Verify Not Selected Values | verifyNotSelectedValues | parentLocator | locator | text
463 | Verify Not Something Selected | verifyNotSomethingSelected | locator |  | 
464 | Verify Not Something Selected | verifyNotSomethingSelected | parentLocator | locator | 
465 | Verify Not Text | verifyNotText | locator | text | 
466 | Verify Not Text | verifyNotText | parentLocator | locator | text
467 | Verify Not Text Alignment | verifyNotTextAlignment | locator | text | 
468 | Verify Not Text Alignment | verifyNotTextAlignment | parentLocator | locator | text
469 | Verify Not Text Decoration | verifyNotTextDecoration | locator | text | 
470 | Verify Not Text Decoration | verifyNotTextDecoration | parentLocator | locator | text
471 | Verify Not Text Empty | verifyNotTextEmpty | locator |  | 
472 | Verify Not Text Empty | verifyNotTextEmpty | parentLocator | locator | 
473 | Verify Not Value | verifyNotValue | locator | text | 
474 | Verify Not Value | verifyNotValue | parentLocator | locator | text
475 | Verify Not Value Empty | verifyNotValueEmpty | locator |  | 
476 | Verify Not Value Empty | verifyNotValueEmpty | parentLocator | locator | 
477 | Verify Not Variable | verifyNotVariable | variable | text | 
478 | Verify Not Visible | verifyNotVisible | locator |  | 
479 | Verify Not Visible | verifyNotVisible | parentLocator | locator | 
480 | Verify Row Count | verifyRowCount | sql | count | 
481 | Verify Row Count Greater Than | verifyRowCountGreaterThan | sql | count | 
482 | Verify Row Count Less Than | verifyRowCountLessThan | sql | count | 
483 | Verify Select Options | verifySelectOptions | locator | text | 
484 | Verify Select Options | verifySelectOptions | parentLocator | locator | text
485 | Verify Select Options Match | verifySelectOptionsMatch | locator | text | 
486 | Verify Select Options Match | verifySelectOptionsMatch | parentLocator | locator | text
487 | Verify Select Options Not Match | verifySelectOptionsNotMatch | locator | text | 
488 | Verify Select Options Not Match | verifySelectOptionsNotMatch | parentLocator | locator | text
489 | Verify Selected Id | verifySelectedId | locator | text | 
490 | Verify Selected Id | verifySelectedId | parentLocator | locator | text
491 | Verify Selected Id Match | verifySelectedIdMatch | locator | text | 
492 | Verify Selected Id Match | verifySelectedIdMatch | parentLocator | locator | text
493 | Verify Selected Id Not Match | verifySelectedIdNotMatch | locator | text | 
494 | Verify Selected Id Not Match | verifySelectedIdNotMatch | parentLocator | locator | text
495 | Verify Selected Ids | verifySelectedIds | locator | text | 
496 | Verify Selected Ids | verifySelectedIds | parentLocator | locator | text
497 | Verify Selected Ids Match | verifySelectedIdsMatch | locator | text | 
498 | Verify Selected Ids Match | verifySelectedIdsMatch | parentLocator | locator | text
499 | Verify Selected Ids Not Match | verifySelectedIdsNotMatch | locator | text | 
500 | Verify Selected Ids Not Match | verifySelectedIdsNotMatch | parentLocator | locator | text
501 | Verify Selected Index | verifySelectedIndex | locator | text | 
502 | Verify Selected Index | verifySelectedIndex | parentLocator | locator | text
503 | Verify Selected Index Match | verifySelectedIndexMatch | locator | text | 
504 | Verify Selected Index Match | verifySelectedIndexMatch | parentLocator | locator | text
505 | Verify Selected Index Not Match | verifySelectedIndexNotMatch | locator | text | 
506 | Verify Selected Index Not Match | verifySelectedIndexNotMatch | parentLocator | locator | text
507 | Verify Selected Indexes | verifySelectedIndexes | locator | text | 
508 | Verify Selected Indexes | verifySelectedIndexes | parentLocator | locator | text
509 | Verify Selected Indexes Match | verifySelectedIndexesMatch | locator | text | 
510 | Verify Selected Indexes Match | verifySelectedIndexesMatch | parentLocator | locator | text
511 | Verify Selected Indexes Not Match | verifySelectedIndexesNotMatch | locator | text | 
512 | Verify Selected Indexes Not Match | verifySelectedIndexesNotMatch | parentLocator | locator | text
513 | Verify Selected Label | verifySelectedLabel | locator | text | 
514 | Verify Selected Label | verifySelectedLabel | parentLocator | locator | text
515 | Verify Selected Label Match | verifySelectedLabelMatch | locator | text | 
516 | Verify Selected Label Match | verifySelectedLabelMatch | parentLocator | locator | text
517 | Verify Selected Label Not Match | verifySelectedLabelNotMatch | locator | text | 
518 | Verify Selected Label Not Match | verifySelectedLabelNotMatch | parentLocator | locator | text
519 | Verify Selected Labels | verifySelectedLabels | locator | text | 
520 | Verify Selected Labels | verifySelectedLabels | parentLocator | locator | text
521 | Verify Selected Labels Match | verifySelectedLabelsMatch | locator | text | 
522 | Verify Selected Labels Match | verifySelectedLabelsMatch | parentLocator | locator | text
523 | Verify Selected Labels Not Match | verifySelectedLabelsNotMatch | locator | text | 
524 | Verify Selected Labels Not Match | verifySelectedLabelsNotMatch | parentLocator | locator | text
525 | Verify Selected Value | verifySelectedValue | locator | text | 
526 | Verify Selected Value | verifySelectedValue | parentLocator | locator | text
527 | Verify Selected Value Match | verifySelectedValueMatch | locator | text | 
528 | Verify Selected Value Match | verifySelectedValueMatch | parentLocator | locator | text
529 | Verify Selected Value Not Match | verifySelectedValueNotMatch | locator | text | 
530 | Verify Selected Value Not Match | verifySelectedValueNotMatch | parentLocator | locator | text
531 | Verify Selected Values | verifySelectedValues | locator | text | 
532 | Verify Selected Values | verifySelectedValues | parentLocator | locator | text
533 | Verify Selected Values Match | verifySelectedValuesMatch | locator | text | 
534 | Verify Selected Values Match | verifySelectedValuesMatch | parentLocator | locator | text
535 | Verify Selected Values Not Match | verifySelectedValuesNotMatch | locator | text | 
536 | Verify Selected Values Not Match | verifySelectedValuesNotMatch | parentLocator | locator | text
537 | Verify Something Selected | verifySomethingSelected | locator |  | 
538 | Verify Something Selected | verifySomethingSelected | parentLocator | locator | 
539 | Verify Text | verifyText | locator | text | 
540 | Verify Text | verifyText | parentLocator | locator | text
541 | Verify Text Alignment | verifyTextAlignment | locator | text | 
542 | Verify Text Alignment | verifyTextAlignment | parentLocator | locator | text
543 | Verify Text Alignment Match | verifyTextAlignmentMatch | locator | text | 
544 | Verify Text Alignment Match | verifyTextAlignmentMatch | parentLocator | locator | text
545 | Verify Text Alignment Not Match | verifyTextAlignmentNotMatch | locator | text | 
546 | Verify Text Alignment Not Match | verifyTextAlignmentNotMatch | parentLocator | locator | text
547 | Verify Text Decoration | verifyTextDecoration | locator | text | 
548 | Verify Text Decoration | verifyTextDecoration | parentLocator | locator | text
549 | Verify Text Decoration Match | verifyTextDecorationMatch | locator | text | 
550 | Verify Text Decoration Match | verifyTextDecorationMatch | parentLocator | locator | text
551 | Verify Text Decoration Not Match | verifyTextDecorationNotMatch | locator | text | 
552 | Verify Text Decoration Not Match | verifyTextDecorationNotMatch | parentLocator | locator | text
553 | Verify Text Empty | verifyTextEmpty | locator |  | 
554 | Verify Text Empty | verifyTextEmpty | parentLocator | locator | 
555 | Verify Text List Order Asc | verifyTextListOrderAsc | locator |  | 
556 | Verify Text List Order Asc | verifyTextListOrderAsc | parentLocator | locator | 
557 | Verify Text List Order Desc | verifyTextListOrderDesc | locator |  | 
558 | Verify Text List Order Desc | verifyTextListOrderDesc | parentLocator | locator | 
559 | Verify Text Match | verifyTextMatch | locator | text | 
560 | Verify Text Match | verifyTextMatch | parentLocator | locator | text
561 | Verify Text Not Match | verifyTextNotMatch | locator | text | 
562 | Verify Text Not Match | verifyTextNotMatch | parentLocator | locator | text
563 | Verify Value | verifyValue | locator | text | 
564 | Verify Value | verifyValue | parentLocator | locator | text
565 | Verify Value Empty | verifyValueEmpty | locator |  | 
566 | Verify Value Empty | verifyValueEmpty | parentLocator | locator | 
567 | Verify Value Match | verifyValueMatch | locator | text | 
568 | Verify Value Match | verifyValueMatch | parentLocator | locator | text
569 | Verify Value Not Match | verifyValueNotMatch | locator | text | 
570 | Verify Value Not Match | verifyValueNotMatch | parentLocator | locator | text
571 | Verify Variable | verifyVariable | variable | text | 
572 | Verify Visible | verifyVisible | locator |  | 
573 | Verify Visible | verifyVisible | parentLocator | locator | 
574 | Wait For All Element Not Present | waitForAllElementNotPresent | locatorArray |  | 
575 | Wait For All Element Present | waitForAllElementPresent | locatorArray |  | 
576 | Wait For All Text Not Present | waitForAllTextNotPresent | textArray |  | 
577 | Wait For All Text Present | waitForAllTextPresent | textArray |  | 
578 | Wait For Any Element Not Present | waitForAnyElementNotPresent | locatorArray |  | 
579 | Wait For Any Element Present | waitForAnyElementPresent | locatorArray |  | 
580 | Wait For Any Text Not Present | waitForAnyTextNotPresent | textArray |  | 
581 | Wait For Any Text Present | waitForAnyTextPresent | textArray |  | 
582 | Wait For Attribute | waitForAttribute | locator | name | text
583 | Wait For Attribute Match | waitForAttributeMatch | locator | name | text
584 | Wait For Attribute Not Match | waitForAttributeNotMatch | locator | name | text
585 | Wait For Checked | waitForChecked | locator |  | 
586 | Wait For Checked | waitForChecked | parentLocator | locator | 
587 | Wait For Condition | waitForCondition | script | timeout | 
588 | Wait For Editable | waitForEditable | locator |  | 
589 | Wait For Editable | waitForEditable | parentLocator | locator | 
590 | Wait For Eval | waitForEval | expression | text | 
591 | Wait For Eval Script | waitForEvalScript | script | text | 
592 | Wait For Eval Script Match | waitForEvalScriptMatch | script | text | 
593 | Wait For Eval Script Not Match | waitForEvalScriptNotMatch | script | text | 
594 | Wait For Exists In Database | waitForExistsInDatabase | sql |  | 
595 | Wait For Expression | waitForExpression | expression | text | 
596 | Wait For Expression Match | waitForExpressionMatch | expression | text | 
597 | Wait For Expression Not Match | waitForExpressionNotMatch | expression | text | 
598 | Wait For Not Attribute | waitForNotAttribute | locator | name | text
599 | Wait For Not Checked | waitForNotChecked | locator |  | 
600 | Wait For Not Checked | waitForNotChecked | parentLocator | locator | 
601 | Wait For Not Editable | waitForNotEditable | locator |  | 
602 | Wait For Not Editable | waitForNotEditable | parentLocator | locator | 
603 | Wait For Not Eval | waitForNotEval | expression | text | 
604 | Wait For Not Eval Script | waitForNotEvalScript | script | text | 
605 | Wait For Not Exists In Database | waitForNotExistsInDatabase | sql |  | 
606 | Wait For Not Expression | waitForNotExpression | expression | text | 
607 | Wait For Not Selected Id | waitForNotSelectedId | locator | text | 
608 | Wait For Not Selected Id | waitForNotSelectedId | parentLocator | locator | text
609 | Wait For Not Selected Index | waitForNotSelectedIndex | locator | text | 
610 | Wait For Not Selected Index | waitForNotSelectedIndex | parentLocator | locator | text
611 | Wait For Not Selected Label | waitForNotSelectedLabel | locator | text | 
612 | Wait For Not Selected Label | waitForNotSelectedLabel | parentLocator | locator | text
613 | Wait For Not Selected Value | waitForNotSelectedValue | locator | text | 
614 | Wait For Not Selected Value | waitForNotSelectedValue | parentLocator | locator | text
615 | Wait For Not Something Selected | waitForNotSomethingSelected | locator |  | 
616 | Wait For Not Something Selected | waitForNotSomethingSelected | parentLocator | locator | 
617 | Wait For Not Text | waitForNotText | locator | text | 
618 | Wait For Not Text | waitForNotText | parentLocator | locator | text
619 | Wait For Not Text Empty | waitForNotTextEmpty | locator |  | 
620 | Wait For Not Text Empty | waitForNotTextEmpty | parentLocator | locator | 
621 | Wait For Not Value | waitForNotValue | locator | text | 
622 | Wait For Not Value | waitForNotValue | parentLocator | locator | text
623 | Wait For Not Value Empty | waitForNotValueEmpty | locator |  | 
624 | Wait For Not Value Empty | waitForNotValueEmpty | parentLocator | locator | 
625 | Wait For Not Visible | waitForNotVisible | locator |  | 
626 | Wait For Not Visible | waitForNotVisible | parentLocator | locator | 
627 | Wait For Selected Id | waitForSelectedId | locator | text | 
628 | Wait For Selected Id | waitForSelectedId | parentLocator | locator | text
629 | Wait For Selected Id Match | waitForSelectedIdMatch | locator | text | 
630 | Wait For Selected Id Match | waitForSelectedIdMatch | parentLocator | locator | text
631 | Wait For Selected Id Not Match | waitForSelectedIdNotMatch | locator | text | 
632 | Wait For Selected Id Not Match | waitForSelectedIdNotMatch | parentLocator | locator | text
633 | Wait For Selected Index | waitForSelectedIndex | locator | text | 
634 | Wait For Selected Index | waitForSelectedIndex | parentLocator | locator | text
635 | Wait For Selected Index Match | waitForSelectedIndexMatch | locator | text | 
636 | Wait For Selected Index Match | waitForSelectedIndexMatch | parentLocator | locator | text
637 | Wait For Selected Index Not Match | waitForSelectedIndexNotMatch | locator | text | 
638 | Wait For Selected Index Not Match | waitForSelectedIndexNotMatch | parentLocator | locator | text
639 | Wait For Selected Label | waitForSelectedLabel | locator | text | 
640 | Wait For Selected Label | waitForSelectedLabel | parentLocator | locator | text
641 | Wait For Selected Label Match | waitForSelectedLabelMatch | locator | text | 
642 | Wait For Selected Label Match | waitForSelectedLabelMatch | parentLocator | locator | text
643 | Wait For Selected Label Not Match | waitForSelectedLabelNotMatch | locator | text | 
644 | Wait For Selected Label Not Match | waitForSelectedLabelNotMatch | parentLocator | locator | text
645 | Wait For Selected Value | waitForSelectedValue | locator | text | 
646 | Wait For Selected Value | waitForSelectedValue | parentLocator | locator | text
647 | Wait For Selected Value Match | waitForSelectedValueMatch | locator | text | 
648 | Wait For Selected Value Match | waitForSelectedValueMatch | parentLocator | locator | text
649 | Wait For Selected Value Not Match | waitForSelectedValueNotMatch | locator | text | 
650 | Wait For Selected Value Not Match | waitForSelectedValueNotMatch | parentLocator | locator | text
651 | Wait For Something Selected | waitForSomethingSelected | locator |  | 
652 | Wait For Something Selected | waitForSomethingSelected | parentLocator | locator | 
653 | Wait For Text | waitForText | locator | text | 
654 | Wait For Text | waitForText | parentLocator | locator | text
655 | Wait For Text Empty | waitForTextEmpty | locator |  | 
656 | Wait For Text Empty | waitForTextEmpty | parentLocator | locator | 
657 | Wait For Text Match | waitForTextMatch | locator | text | 
658 | Wait For Text Match | waitForTextMatch | parentLocator | locator | text
659 | Wait For Text Not Match | waitForTextNotMatch | locator | text | 
660 | Wait For Text Not Match | waitForTextNotMatch | parentLocator | locator | text
661 | Wait For Value | waitForValue | locator | text | 
662 | Wait For Value | waitForValue | parentLocator | locator | text
663 | Wait For Value Empty | waitForValueEmpty | locator |  | 
664 | Wait For Value Empty | waitForValueEmpty | parentLocator | locator | 
665 | Wait For Value Match | waitForValueMatch | locator | text | 
666 | Wait For Value Match | waitForValueMatch | parentLocator | locator | text
667 | Wait For Value Not Match | waitForValueNotMatch | locator | text | 
668 | Wait For Value Not Match | waitForValueNotMatch | parentLocator | locator | text
669 | Wait For Visible | waitForVisible | locator |  | 
670 | Wait For Visible | waitForVisible | parentLocator | locator | 

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

