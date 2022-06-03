package bo.edu.ucb.ingsoft.hhrr.chat;

import bo.edu.ucb.ingsoft.hhrr.bl.EmployeeBl;
import bo.edu.ucb.ingsoft.hhrr.dto.db.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Service
public class QueryEmployee extends AbstractProcess {

    private EmployeeBl employeeBl;

    @Autowired
    public QueryEmployee(EmployeeBl employeeBl) {
        this.employeeBl = employeeBl;
        this.setName("Consultar solicitudes pasadas");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        //this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    // Retornar un Widget con la información de los permisos solicitados
//    @Override
//    public AbstractWidget onInit() {
//        return null;
//    }

    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, StoreVideoLongPollingBot bot) {
        Long chatId = update.getMessage().getChatId();
        List<EmployeeDto> employeeList = employeeBl.findemployeessByChatId(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("Este año has solicitado " ).append(employeeList.size());
        sb.append(" permisos. Bajo el siguiente detalle\r\n");
        for(EmployeeDto employees: employeeList) {
            sb.append(employees.toString()).append("\n\r");
        }
        sendStringBuffer(bot, chatId, sb);
        return new MenuPrincipal();
    }

    @Override
    public AbstractProcess onError() {
        return null;
    }

    @Override
    public AbstractProcess onSuccess() {
        return null;
    }

    @Override
    public AbstractProcess onTimeout() {
        return null;
    }
}
