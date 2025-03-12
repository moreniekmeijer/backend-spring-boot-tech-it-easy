package nl.moreniekmeijer.backendspringboottechiteasycontroller.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RemoteControllerInputDto {
    public String compatibleWith;
    public String batteryType;
    @NotBlank(message = "Name cannot be empty")
    public String name;
    public String brand;
    @NotNull(message = "Price cannot be null")
    public Double price;
    public Integer originalStock;
}
