declare namespace Utils {
  function enhanceElementsArray(
    elements: WebdriverIOAsync.ElementArray,
    parent: any,
    selector: string | null,
    foundWith?: string,
    props?: any[]
  ): WebdriverIOAsync.ElementArray;
}

declare namespace getElementObjectUtils {
  function getElement(selector: string | null, res: any, isReactElement?: boolean): WebdriverIOAsync.Element;
  function getElements(selector: string | null, res: any, isReactElement?: boolean): WebdriverIOAsync.ElementArray;
}

declare module 'webdriverio/build/utils' {
  export = Utils;
}

declare module 'webdriverio/build/utils/getElementObject' {
  export = getElementObjectUtils;
}
