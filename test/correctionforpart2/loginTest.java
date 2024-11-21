/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package correctionforpart2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RC_Student_lab
 */
public class loginTest {
    login myObj = new login();
    public loginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     @Test
    public void TestValidUsername() {
        assertTrue("Usename should be valid",myObj.ValidateUsername("Kyl_1"));
    }
   
    @Test
    public void TestInvalidUsername(){
    assertFalse("Username should be invalid",myObj.ValidateUsername(" Kyle!!!!"));
    }
    
    @Test
    public void TestValidPassword(){
    assertTrue("Password should be valid",myObj.ValidatePassword("Chsec@k9"));
    }
    
   @Test
   public void TestInvalidPassword(){
       assertFalse("Password should be invalid",myObj.ValidatePassword("Password"));
   }
   @Test
   public void TestloginSucceful(){
   String Useraname = "Kyl_1";
   String Password = "Chsec@k9";
   }
   
   @Test
   public  void TestloginFalied(){
   String Username = " Kyle!!!!";
   String Password = "Password";
}
}
