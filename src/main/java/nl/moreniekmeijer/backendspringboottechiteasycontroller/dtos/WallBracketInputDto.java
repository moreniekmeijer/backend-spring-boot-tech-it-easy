package nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class WallBracketInputDto {
    public String size;
    public Boolean adjustable;
    @NotBlank(message = "Name cannot be empty")
    public String name;
    @NotNull(message = "Price cannot be null")
    public Double price;
}
