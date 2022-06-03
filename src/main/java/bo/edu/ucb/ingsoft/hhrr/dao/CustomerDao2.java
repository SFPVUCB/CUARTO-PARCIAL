package bo.edu.ucb.ingsoft.hhrr.dao;

import bo.edu.ucb.ingsoft.hhrr.dto.db.CityDto;
import bo.edu.ucb.ingsoft.hhrr.dto.db.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerDao2
{
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SequenceDao sequenceDao;

    public CustomerDto crearCustomer (CustomerDto customerdto) {
        customerdto.setCustomer_id(sequenceDao.getPrimaryKeyForTable("customer"));
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO customer VALUES (?,?,?,?,?,?,?,?,?,?) ");
            stmt.setInt(1, customerdto.getCustomer_id());
            stmt.setInt(2, customerdto.getAddress_id());
            stmt.setString(3, customerdto.getName());
            stmt.setString(4, customerdto.getLastname());
            stmt.setInt(5, customerdto.getPhone());
            stmt.setString(6, customerdto.getMail());
            stmt.setBoolean(7, customerdto.getStatus());
            stmt.setString(8, customerdto.getUsarname());
            stmt.setString(9, customerdto.getPassword());
            stmt.setString(10, customerdto.getImage());

            stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException sqex) {
                    // No hacer nada intencionalemte;
                }
            }
        }
        return customerdto;
    }

    public CustomerDto findCustomerById(Integer customer_id) {
        CustomerDto result = new CustomerDto();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * " +
                     "FROM customer WHERE customer_id = ?")
        ) {  // TRY WITH RESOURCES
            pstmt.setInt(1, customer_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setCustomer_id(rs.getInt("customer_id"));
                result.setAddress_id(rs.getInt("address_id"));
                result.setName(rs.getString("name"));
                result.setLastname(rs.getString("lastname"));
                result.setPhone(rs.getInt("phone"));
                result.setMail(rs.getString("mail"));
                result.setStatus(rs.getBoolean("status"));
                result.setUsarname(rs.getString("username"));
                result.setPassword(rs.getString("password"));
                result.setImage(rs.getString("image"));
            } else { // si no hay valores de BBDD
                result = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public List<CustomerDto> findAllCustomerByStatus(Boolean status ) {
        List<CustomerDto> result1 = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * " +
                     "FROM customer WHERE status = ?")
        ) {  // TRY WITH RESOURCES
            pstmt.setBoolean(1, status);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                CustomerDto customer = new CustomerDto();

                customer.setCustomer_id(rs.getInt("customer_id"));
                customer.setAddress_id(rs.getInt("address_id"));
                customer.setName(rs.getString("name"));
                customer.setLastname(rs.getString("lastname"));
                customer.setPhone(rs.getInt("phone"));
                customer.setMail(rs.getString("mail"));
                customer.setStatus(rs.getBoolean("status"));
                customer.setUsarname(rs.getString("username"));
                customer.setPassword(rs.getString("password"));
                customer.setImage(rs.getString("image"));


                result1.add(customer);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result1;

    }
    public List<CustomerDto> findAllCustomers() {
        List<CustomerDto> result = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
            while (rs.next())
            {
                CustomerDto customer = new CustomerDto();
                customer.setCustomer_id(rs.getInt("customer_id"));
                customer.setAddress_id(rs.getInt("address_id"));
                customer.setName(rs.getString("name"));
                customer.setLastname(rs.getString("lastname"));
                customer.setPhone(rs.getInt("phone"));
                customer.setMail(rs.getString("mail"));
                customer.setStatus(rs.getBoolean("status"));
                customer.setUsarname(rs.getString("username"));
                customer.setPassword(rs.getString("password"));
                customer.setImage(rs.getString("image"));
                result.add(customer);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
        //apellidos
    }

}
