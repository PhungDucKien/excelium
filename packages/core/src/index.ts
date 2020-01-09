import TestReader from './reader/TestReader';
import TestReaderFactory from './reader/TestReaderFactory';
import TestWriter from './writer/TestWriter';
import TestWriterFactory from './writer/TestWriterFactory';

export type GenericTestReaderFactory = TestReaderFactory<TestReader<any, any>>;
export type GenericTestWriterFactory = TestWriterFactory<any, TestWriter>;

export { TestReader, TestReaderFactory, TestWriter, TestWriterFactory };

export { default as AbstractTestReader } from './reader/AbstractTestReader';
export { default as AbstractWorkbookReader } from './reader/AbstractWorkbookReader';
export { default as WorkbookReader } from './reader/WorkbookReader';

export { default as AbstractTestWriter } from './writer/AbstractTestWriter';
export { default as AbstractWorkbookWriter } from './writer/AbstractWorkbookWriter';
export { default as WorkbookWriter } from './writer/WorkbookWriter';
