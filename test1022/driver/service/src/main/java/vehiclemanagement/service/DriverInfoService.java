package vehiclemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vehiclemanagement.domain.DriverInfo;
import vehiclemanagement.domain.DriverInfoRepository;
import vehiclemanagement.domain.DeleteDriverInfoCommand;
import vehiclemanagement.domain.UserInfoUpdated;

import javax.persistence.EntityNotFoundException;

@Service
public class DriverInfoService {

    private final DriverInfoRepository driverInfoRepository;

    @Autowired
    public DriverInfoService(DriverInfoRepository driverInfoRepository) {
        this.driverInfoRepository = driverInfoRepository;
    }

    public void deleteDriverInfo(String companyName) {
        DriverInfo driverInfo = driverInfoRepository.findById(companyName)
            .orElseThrow(() -> new EntityNotFoundException("DriverInfo not found"));
        driverInfo.deleteDriverInfo(new DeleteDriverInfoCommand());
        driverInfoRepository.save(driverInfo);
    }

    public void updateDriverInfo(String companyName) {
        DriverInfo driverInfo = driverInfoRepository.findById(companyName)
            .orElseThrow(() -> new EntityNotFoundException("DriverInfo not found"));
        driverInfo.updateDriverInfo();
        driverInfoRepository.save(driverInfo);
    }

    public void handleUserInfoUpdated(UserInfoUpdated userInfoUpdated) {
        // UserInfoUpdated 이벤트를 처리하는 로직 구현
        // 예: 관련된 DriverInfo를 찾아 업데이트
        DriverInfo driverInfo = driverInfoRepository.findByUserInfoId(userInfoUpdated.getJuminNum())
            .orElseThrow(() -> new EntityNotFoundException("DriverInfo not found for the given UserInfo"));
        driverInfo.handleUserInfoUpdated(userInfoUpdated);
        driverInfoRepository.save(driverInfo);
    }
}