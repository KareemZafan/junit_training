package org.iti.mobile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmployeeMockedTests {


    private Employee emp;


   @BeforeEach
   void setUp(){
       emp = mock(Employee.class);
   }

    @Test
    void testEmpName(){

        when(emp.getfName()).thenReturn("Kareem");
        assertEquals("Kareem",emp.getfName());
    }

    @Test
    void testSalaryIncrease() {
        when(emp.getSalary()).thenReturn(20000.0);
        when(emp.increaseSalary(10000)).thenCallRealMethod();
        assertEquals(30000,emp.increaseSalary(10000));
        verify(emp).getSalary();
    }


}
