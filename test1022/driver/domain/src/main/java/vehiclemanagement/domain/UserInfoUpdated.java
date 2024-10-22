package vehiclemanagement.domain;

import java.util.*;
import javax.persistence.*;
import lombok.*;
import vehiclemanagement.domain.*;
import vehiclemanagement.infra.AbstractEvent;

@Data
@ToString
public class UserInfoUpdated extends AbstractEvent {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String juminNum;
    private Object address;
}
