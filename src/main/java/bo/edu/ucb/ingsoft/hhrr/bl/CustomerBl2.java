package bo.edu.ucb.ingsoft.hhrr.bl;

import bo.edu.ucb.ingsoft.hhrr.dao.CityDao2;
import bo.edu.ucb.ingsoft.hhrr.dao.CustomerDao2;
import bo.edu.ucb.ingsoft.hhrr.dto.db.CityDto;
import bo.edu.ucb.ingsoft.hhrr.dto.db.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerBl2
{
    @Autowired
    CustomerDao2 customerDao2;
    public CustomerDto findCustomerById(Integer city_id)
    {
        return customerDao2.findCustomerById(city_id);
    }

    public List<CustomerDto> findAllCustomerByStatus(Boolean status) {
        return customerDao2.findAllCustomerByStatus(status);
    }

    public List<CustomerDto> findAllCustomers() {
        return customerDao2.findAllCustomers();
    }

    public CustomerDto crearCustomer(CustomerDto customerDto) {

        return customerDao2.crearCustomer(customerDto);
    }


}
