package bo.edu.ucb.ingsoft.hhrr.api;

import bo.edu.ucb.ingsoft.hhrr.bl.CityBl2;
import bo.edu.ucb.ingsoft.hhrr.bl.CustomerBl2;
import bo.edu.ucb.ingsoft.hhrr.dto.db.CityDto;
import bo.edu.ucb.ingsoft.hhrr.dto.db.CustomerDto;
import bo.edu.ucb.ingsoft.hhrr.dto.db.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class CustomerController
{
    @Autowired
    public DataSource dataSource;

    @Autowired
    private CustomerBl2 customerBl2;

    @GetMapping(path = "/customer1/{customer_id}")
    public ResponseDto findCiudadById(@PathVariable Integer customer_id) {
        CustomerDto customer = customerBl2.findCustomerById(customer_id);
        if (customer != null) {
            return new ResponseDto( true, customer, null);
        } else {
            return new ResponseDto( false, null, "");
        }
    }

    @GetMapping(path = "/customer2/{status}")
    public List<CustomerDto> findAllCiudades(@PathVariable Boolean status)
    {
        List<CustomerDto> customer = customerBl2.findAllCustomerByStatus(status);
        return customerBl2.findAllCustomerByStatus(status);
    }
    @GetMapping(path = "/customer3")
    public List<CustomerDto> findAllCustomers()
    {
        return customerBl2.findAllCustomers();
    }

    @PostMapping(path = "/customer4")
    public CustomerDto createMascota(@RequestBody CustomerDto customerDto)
    {

        return customerBl2.crearCustomer(customerDto);
    }
}
