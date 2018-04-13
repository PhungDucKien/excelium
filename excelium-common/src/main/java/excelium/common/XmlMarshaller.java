/*
 * MIT License
 *
 * Copyright (c) 2018 Excelium
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package excelium.common;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.nio.file.Path;

/**
 * Provides functions for object marshalling.
 *
 * @author PhungDucKien
 * @since 2018.04.09
 */
public class XmlMarshaller {

    /**
     * Unmarshal XML data from the specified file path and return the resulting
     * content tree.
     *
     * @param path The file path to unmarshal XML data from
     * @param clazz java class to be return
     * @return Unmarshalled java object
     * @throws JAXBException if any unexpected errors occur while unmarshalling
     */
    public static Object unmarshall(Path path, Class clazz) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller um = context.createUnmarshaller();
        return um.unmarshal(path.toFile());
    }

    /**
     * Marshal the content tree rooted at <tt>jaxbElement</tt> into a file.
     *
     * @param object the java content tree to be marshalled
     * @param path The file path to marshal to
     * @throws JAXBException if any unexpected problem occurs during the marshalling
     */
    public static void marshall(Object object, Path path) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(object.getClass());

        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        m.marshal(object, path.toFile());
    }
}
