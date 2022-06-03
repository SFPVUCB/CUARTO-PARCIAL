package bo.edu.ucb.ingsoft.hhrr.bl;

import bo.edu.ucb.ingsoft.hhrr.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerBl
{
    private CustomerDao customermdao;

    @Autowired
    public CustomerBl(CustomerDao customermdao)
    {
        this.customermdao = customermdao;
    }
    /*

    public List<FilmDto> findFilmByChatId()
    {
        return filmdao.findfilm();
    }
    /*
     */
    /*
    public List<FilmDto> findFilmByTitle(String title)
    {
        return filmdao.findfilmtitle(title);
    }

     */




}
