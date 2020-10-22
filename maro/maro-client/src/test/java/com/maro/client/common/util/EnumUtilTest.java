package com.maro.client.common.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EnumUtilTest {


    @Test
    public void testCreateEnumSqlScript(){
        try {
            EnumUtil.createEnumSqlScript();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        ;
    }

}
