package com.maro.common.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.StringReader;

/**
 * Created by alpha on 2018-9-27.
 */
public class JaxbUtil {
    public static <T> T convertToJavaBean(Class<T> clz, String xmlStr) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader sr = new StringReader(xmlStr);
            T t = (T) unmarshaller.unmarshal(sr);
            return t;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
