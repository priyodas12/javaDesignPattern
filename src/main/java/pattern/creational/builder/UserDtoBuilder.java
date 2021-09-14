package pattern.creational.builder;

import java.time.LocalDate;

public interface UserDtoBuilder {

    UserDtoBuilder withFirstName(String name);
    UserDtoBuilder withLastName(String name);
    UserDtoBuilder withBirthDay(LocalDate date);
    UserDtoBuilder withAddress(Address address);
    //method to assemble final product.
    UserDto build();
    //get final product.
    UserDto getUserDto();
}
