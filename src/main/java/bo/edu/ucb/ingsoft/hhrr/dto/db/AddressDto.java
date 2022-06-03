package bo.edu.ucb.ingsoft.hhrr.dto.db;

public class AddressDto
{
    private Integer address_id;
    private Integer city_id;
    private String firtsAddress;
    private String secondAddress;
    private Integer postalcode;

    public AddressDto(Integer address_id, Integer city_id, String firtsAddress, String secondAddress, Integer postalcode)
    {
        this.address_id = address_id;
        this.city_id = city_id;
        this.firtsAddress = firtsAddress;
        this.secondAddress = secondAddress;
        this.postalcode = postalcode;
    }
    public AddressDto()
    {

    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public String getFirtsAddress() {
        return firtsAddress;
    }

    public void setFirtsAddress(String firtsAddress) {
        this.firtsAddress = firtsAddress;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public void setSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
    }

    public Integer getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(Integer postalcode) {
        this.postalcode = postalcode;
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "address_id=" + address_id +
                ", city_id=" + city_id +
                ", firtsAddress='" + firtsAddress + '\'' +
                ", secondAddress='" + secondAddress + '\'' +
                ", postalcode=" + postalcode +
                '}';
    }
}
