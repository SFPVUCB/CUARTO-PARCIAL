package bo.edu.ucb.ingsoft.hhrr.dto.db;

public class CustomerDto
{

    private Integer customer_id;
    private Integer address_id;
    private String name;
    private String lastname;
    private Integer phone;
    private String mail;
    private Boolean status;
    private String usarname;
    private String password;
    private String image;

    public CustomerDto(Integer customer_id, Integer address_id, String name, String lastname, Integer phone, String mail, Boolean status, String usarname, String password, String image) {
        this.customer_id = customer_id;
        this.address_id = address_id;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.mail = mail;
        this.status = status;
        this.usarname = usarname;
        this.password = password;
        this.image = image;
    }
    public CustomerDto()
    {}

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getUsarname() {
        return usarname;
    }

    public void setUsarname(String usarname) {
        this.usarname = usarname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return "CustomerDto{" +
                "customer_id=" + customer_id +
                ", address_id=" + address_id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone=" + phone +
                ", mail='" + mail + '\'' +
                ", status=" + status +
                ", usarname='" + usarname + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
