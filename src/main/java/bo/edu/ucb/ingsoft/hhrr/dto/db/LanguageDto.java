package bo.edu.ucb.ingsoft.hhrr.dto.db;

public class LanguageDto
{
    private Integer languageId;
    private String language;

    //Constructor 1
    public LanguageDto(Integer languageId)
    {
        this.languageId = languageId;
        if (languageId == 1)
        {
            this.language= "Espaniol";
        }
        if (languageId == 2)
        {
            this.language= "Ingles";
        }
        if (languageId == 3)
        {
            this.language= "Ruso";
        }
        if (languageId == 4)
        {
            this.language = "Chino Mandarin";
        }
    }
    public LanguageDto(Integer languageId, String language) {
        this.languageId = languageId;
        this.language = language;
    }
    //Contructor Vacio
    public LanguageDto() {
        this.languageId = 0;
        this.language = "";
    }

    //Metodos para acceder a los datos
    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    //Metodo para mostrar los objetos de tipo language
    @Override
    public String toString()
    {
        return "\n Lenguaje = ' " + language + " ' ";
    }
}
