

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class DLLTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DLLTest
{
    /**
     * Default constructor for test class DLLTest
     */
    public DLLTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    

    @Test
    public void testAppend()
    {
        DLL<String> dLL1 = new DLL<String>();
        dLL1.append("hello");
        dLL1.append("hey");
        assertEquals("hello <-> hey <-> null", dLL1.toString());
    }

    @Test
    public void testInsert()
    {
        DLL<String> dLL1 = new DLL<String>();
        dLL1.append("hello");
        dLL1.append("hey");
        dLL1.insert(1, "hi");
        assertEquals("hello <-> hi <-> hey <-> null", dLL1.toString());
    }

    @Test
    public void testDelete()
    {
        DLL<String> dLL1 = new DLL<String>();
        dLL1.append("hello");
        dLL1.append("hi");
        dLL1.append("hey");
        dLL1.delete(1);
        assertEquals("hello <-> hey <-> null", dLL1.toString());
    }

    @Test
    public void testGetIndex()
    {
        DLL<String> dLL1 = new DLL<String>();
        dLL1.append("hi");
        dLL1.append("hey");
        assertEquals(0, dLL1.getIndex("hi"));
        assertEquals(-1, dLL1.getIndex("Hello"));
    }

    @Test
    public void testShuffle()
    {
        DLL<String> dLL1 = new DLL<String>();
        dLL1.append("hi");
        dLL1.append("hey");
        dLL1.append("hello");
        dLL1.shuffle();
        assertNotSame("hi <-> hey <-> hello <-> null", dLL1.toString());
    }
}












