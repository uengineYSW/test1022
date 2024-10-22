package vehiclemanagement.domain;

import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vehiclemanagement.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "driverInfos",
    path = "driverInfos"
)
public interface DriverInfoRepository
    extends PagingAndSortingRepository<DriverInfo, String> {
        Optional<DriverInfo> findByUserInfoId(String juminNum);
}
