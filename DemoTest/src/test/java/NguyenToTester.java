
import com.nth.services.NguyenToService;
import java.time.Duration;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class NguyenToTester {
   @BeforeAll
   public static void beforeAll(){
       System.out.println("Before All");
   }
   
   @AfterAll
   public static void afterAll(){
       System.out.println("After All");
   }
   
   @ParameterizedTest
   @ValueSource(ints = {2,3,5,7,11,13})
   public void testNumberOdd(int n){
       boolean actual = NguyenToService.isNguyenTo(n);
       boolean expected = true;
       Assertions.assertEquals(expected, actual);
   }
   
   @ParameterizedTest
   @ValueSource(ints = {4,6,8,12,16,100})
   public void testNumberEven(int n){
       boolean actual = NguyenToService.isNguyenTo(n);
       Assertions.assertFalse(actual);
   }
   @ParameterizedTest
   @CsvSource({"2, true", "4, false"})
   public void testNumber(int n, boolean expected){
       boolean actual = NguyenToService.isNguyenTo(n);
       Assertions.assertEquals(expected, actual);
   }
   
   @ParameterizedTest
   @CsvFileSource(resources = "data.csv", numLinesToSkip = 1)
   public void testCSVFile(int n, boolean expected){
       boolean actual = NguyenToService.isNguyenTo(n);
       Assertions.assertEquals(expected, actual);
   }
   
   @ParameterizedTest
   @MethodSource (value = "dataTest")
   public void testMethodSourse(int n, boolean expected){
       boolean actual = NguyenToService.isNguyenTo(n);
       Assertions.assertEquals(expected, actual);
   }
   
   static Stream<Arguments> dataTest(){
       //Doc data tu CSV
       return Stream.of(
               Arguments.arguments(4, false),
               Arguments.arguments(5, true)
       );
   }
   @Test
   @DisplayName("Test Odd Number")
   public void testOddNumber(){
        System.out.println("Test case Odd Number");
        boolean actual = NguyenToService.isNguyenTo(5);
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
   }
   
   @Test
   @DisplayName("Test Odd Number")
   public void testOddNumber_2(){
//        System.out.println("Test case Odd Number");
        boolean actual = NguyenToService.isNguyenTo(2);
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
   }
   
   @Test
   @DisplayName("Test Even Number")
   public void testEvenNumber(){
        boolean actual = NguyenToService.isNguyenTo(4);
        boolean expected = false;
        Assertions.assertEquals(expected, actual, "Cai dat thuat toan sai");
   }
   
   @Test
   public void testException(){
        Assertions.assertThrows(ArithmeticException.class, ()->{
            NguyenToService.isNguyenTo(-1);
        });//Lambda
   }
   
   @Test
   public void testTimeOut(){
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), ()->{
            NguyenToService.isNguyenTo(7);
        });
   }
}
