package at.campus02.swe.parser;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;
import static org.mockito.Mockito.*;

import at.campus02.swe.Calculator;
import at.campus02.swe.Calculator.Operation;


public class ParserTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullParser() {
        new Parser(null);
    }

    @Test(expected = FileNotFoundException.class)
    public void testParserInvalidFile() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("invalid"));
    }

    @Test
    public void testParserTest01Xml() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test01.xml"));

        verify(cal).push(1.0);
        verify(cal).push(2.0);
        verify(cal).perform(Operation.add);

        verifyNoMoreInteractions(cal);
    }

    @Test
    public void testParserUebung1() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/parseModuloUebung1.xml"));

        verify(cal).push(8);
        verify(cal).push(3);
        verify(cal).perform(Operation.mod);

        verifyNoMoreInteractions(cal);
    }

    @Test
    public void testParserSinCos() throws Exception {
        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/testSinCos01.xml"));

        verify(cal).push(45.0);
        verify(cal).perform(Operation.sin);
        verify(cal).push(60.0);
        verify(cal).perform(Operation.cos);

        verifyNoMoreInteractions(cal);
    }

    @Test
    public void testSkalarproduct() throws Exception {
        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/testSkalar.xml"));

        verify(cal).push(1);
        verify(cal, times(2)).push(2);
        verify(cal).push(3);
        verify(cal).push(4);
        verify(cal).perform(Operation.skalar);


        verifyNoMoreInteractions(cal);
    }



}