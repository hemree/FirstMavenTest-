package day07_Junit;

import org.junit.*;

public class C04_BeforeClassAfterClass {
    /*
    @Before Class ve After Class methodları sadece statik methodlar ile calisir.

     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("tüm testlerden önce bir kez calisir");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("tüm testlerden sonra bir kez calisir");
        
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("her test methodundan önce");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("her test methodundan sonra");
    }

    @Test
    public void test01() {
        System.out.println("ilk test");
    }

    @Test
    public void test02() {
        System.out.println("son test");
    }
}
