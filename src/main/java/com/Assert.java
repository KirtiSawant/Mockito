package com;

import org.junit.Test;

import static org.junit.Assert.*;



public class Assert {
    @Test
    public void testAssert(){
        String str=new String("trisha");
        String str1=new String("trisha");
        String str2=null;
        String str3="ovi";
        String  str4="ovi";
        int val=8;
        int val1=6;
        String[] expectedArray={"one","two","three"};
        String[] resultArray={"one","two","three"};
        assertEquals(str,str1);
        //check for true
        assertTrue(val>val1);
        //check for false
        assertFalse(val<val1);
        //check assert for null
        assertNotNull(str);
        //check if it is null
        assertNull(str2);
        assertSame(str3,str4);
        assertArrayEquals(expectedArray,resultArray);
    }
}
