/*
David Centeno
CS5004 OOD
Final Project
 */
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class WebConnectionTests  {
    public WebConnectionTests() throws IOException {
    }
    WebConnection premade = new WebConnection();
    WebConnection defined = new WebConnection("https://nytimes.com");
    WebListImpl testList = new WebListImpl();

    @Before
    public void setUp() throws IOException {
        testList.addData("This is a test Node");
        testList.addData("Second node");
        testList.addData("Third node");

    }
    @Test
    public void testControllerUser() throws IOException{
        WebConnection testDefine = new WebConnection("https://9to5mac.com");
        assertEquals(testDefine,testDefine);
    }

    @Test
    public void testControllerPre() throws IOException{
        WebConnection preDefined = new WebConnection();
        assertEquals(preDefined,preDefined);
    }


    @Test
    public void testPremadeConstructorUrl() throws IOException{
        assertEquals("https://www.leagueofgraphs.com/champions/builds",premade.getUrl());
    }
    @Test
    public void testUsermadeConstructorUrl() throws IOException{
        assertEquals("https://nytimes.com",defined.getUserUrl());
    }

    @Test
    public void testAddNode(){
        WebListImpl testList2 = new WebListImpl();
        testList2.addData("This is a test Node");
        assertEquals("This is a test Node",testList2.getData(0));
    }

    @Test
    public void testGetNode(){
        assertEquals("Second node",testList.getData(1));
    }

    @Test
    public void testCount(){
        assertEquals(3,testList.count());
    }


}
