package vehiclemanagement.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import vehiclemanagement.domain.DriverInfoCreated;
import vehiclemanagement.domain.DriverInfoUpdated;

@Entity
@Table(name = "DriverInfo_table")
@Data
//<<< DDD / Aggregate Root
public class DriverInfo {

    @Id
    private String companyName;

    private String affiliation;

    private String contact;

    private String permission;

    private Boolean isActive;

    @Embedded
    private UserInfoId userInfoId;

    @Embedded
    private VehicleInfoId vehicleInfoId;

    @PostPersist
    public void onPostPersist() {
        DriverInfoCreated driverInfoCreated = new DriverInfoCreated(this);
        driverInfoCreated.publishAfterCommit();

        DriverInfoUpdated driverInfoUpdated = new DriverInfoUpdated(this);
        driverInfoUpdated.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    // public static DriverInfoRepository repository() {
    //     DriverInfoRepository driverInfoRepository = DriverApplication.applicationContext.getBean(
    //         DriverInfoRepository.class
    //     );
    //     return driverInfoRepository;
    // }

    //<<< Clean Arch / Port Method
    public void deleteDriverInfo(
        DeleteDriverInfoCommand deleteDriverInfoCommand
    ) {
        //implement business logic here:

        DriverInfoDeleted driverInfoDeleted = new DriverInfoDeleted(this);
        driverInfoDeleted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void updateDriverInfo() {
        //implement business logic here:

    }

    public void handleUserInfoUpdated(UserInfoUpdated userInfoUpdated) {
        // UserInfoUpdated 이벤트를 처리하는 로직 구현
        // 예: 관련 필드 업데이트
        this.userInfoId = new UserInfoId(userInfoUpdated.getId());
        // 필요한 다른 필드들도 업데이트
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void update(UserInfoUpdated userInfoUpdated) {
        //implement business logic here:

        /** Example 1:  new item 
        DriverInfo driverInfo = new DriverInfo();
        repository().save(driverInfo);

        DriverInfoUpdated driverInfoUpdated = new DriverInfoUpdated(driverInfo);
        driverInfoUpdated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(userInfoUpdated.get???()).ifPresent(driverInfo->{
            
            driverInfo // do something
            repository().save(driverInfo);

            DriverInfoUpdated driverInfoUpdated = new DriverInfoUpdated(driverInfo);
            driverInfoUpdated.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
