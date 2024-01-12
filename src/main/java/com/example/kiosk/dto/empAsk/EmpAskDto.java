package com.example.kiosk.dto.empAsk;


import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmpAskDto {
    private Long id;
    private String name;
    private int amount;

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;

        EmpAskDto other = (EmpAskDto) obj;
        return id == other.id &&
                name.equals(other.name);
    }
}
