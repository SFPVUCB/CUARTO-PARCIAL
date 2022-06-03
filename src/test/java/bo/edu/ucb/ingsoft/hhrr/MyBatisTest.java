package bo.edu.ucb.ingsoft.hhrr;

import bo.edu.ucb.ingsoft.hhrr.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisTest {

    private EmployeeDao employeeDao;

    @Autowired
    public MyBatisTest(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
/*
    @Test
    public void testSelectAllEmployees() {
        List<EmployeeDto> employeeDtoList = employeeDao.findemploee();
        for( EmployeeDto emp : employeeDtoList) {
            System.out.println("Empleado: " + emp);
        }

    }

 */
}
