package ma.chu.CHU_emergency.dto;

public class HopitalServiceDTO {
    private String codeService;
    private String nomService;

    public HopitalServiceDTO() {}

    public HopitalServiceDTO(String codeService, String nomService) {
        this.codeService = codeService;
        this.nomService = nomService;
    }

    // Getters & Setters
    public String getCodeService() { return codeService; }
    public void setCodeService(String codeService) { this.codeService = codeService; }

    public String getNomService() { return nomService; }
    public void setNomService(String nomService) { this.nomService = nomService; }
}
