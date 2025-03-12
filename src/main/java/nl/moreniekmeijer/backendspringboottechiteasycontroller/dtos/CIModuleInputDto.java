package nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CIModuleInputDto {
    @NotBlank(message = "Name cannot be empty")
    public String name;
    public String type;
    @NotNull(message = "Price cannot be null")
    public Double price;
}
