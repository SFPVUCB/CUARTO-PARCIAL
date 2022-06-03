package bo.edu.ucb.ingsoft.hhrr.dto.db;


public class CityDto
{
    private Integer city_id;
    private String cityname;
    //Contructor 1
    public CityDto()
    {

    }
    public CityDto(Integer city_id, String city)
    {
        this.city_id = city_id;
        this.cityname = city;
    }
    public CityDto(Integer city_id)
    {
        this.city_id = city_id;
        if(city_id == 1)
        {
            this.cityname= "La Paz";
        }
        if(city_id == 2)
        {
            this.cityname= "Cochabamba";
        }
        if(city_id == 3)
        {
            this.cityname= "Oruro";
        }
        if(city_id == 4)
        {
            this.cityname= "Sucre";
        }
        if(city_id == 5)
        {
            this.cityname= "Tarija";
        }
        if(city_id == 6)
        {
            this.cityname= "Potosi";
        }
        if(city_id == 7)
        {
            this.cityname= "Pando";
        }
        if(city_id == 8)
        {
            this.cityname= "Beni";
        }
        if(city_id == 9)
        {
            this.cityname= "Santa Cruz";
        }
    }
    //getters and setters

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public String getCity() {
        return cityname;
    }

    public void setCity(String city) {
        this.cityname = city;
    }

    //Constructor Vacio

    //Metodo para mostrar el objeto cityDto
    @Override
    public String toString() {
        return "Ciudad " +
                "\n{" +
                "\n Numero= ' " + city_id +" ' " +
                "\n Ciudad= ' " + cityname+" ' " +
                "\n}\n";
    }
}

