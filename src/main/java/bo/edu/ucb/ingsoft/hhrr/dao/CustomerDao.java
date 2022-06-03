package bo.edu.ucb.ingsoft.hhrr.dao;

import bo.edu.ucb.ingsoft.hhrr.dto.db.FilmDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerDao
{
    @Select("INSERT INTO customer (customer_id,address_id,name,lastname,phone,mail,status,usarname,password,image)" +
            "VALUES (#{customer_id},#{address_id},#{name},#{lastname},#{phone},#{mail},#{usarname},#{password},#{image})")
    List<FilmDto> findfilm(@Param("customer_id") Integer customer_id,
                           @Param("address_id") Integer address_id,
                           @Param("name") Integer name,
                           @Param("lastname") Integer lastname,
                           @Param("phone") Integer phone,
                           @Param("mail") Integer mail,
                           @Param("usarname") Integer usarname,
                           @Param("password") Integer password,
                           @Param("image") Integer image);


}
