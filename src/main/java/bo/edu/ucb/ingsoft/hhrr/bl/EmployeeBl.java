package bo.edu.ucb.ingsoft.hhrr.bl;

import bo.edu.ucb.ingsoft.hhrr.dao.EmployeeDao;
import bo.edu.ucb.ingsoft.hhrr.dto.db.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeBl
{
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeBl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<EmployeeDto> findemployeessByChatId(Long chatId)
    {
        return employeeDao.findemploee(chatId+"");
    }
}
