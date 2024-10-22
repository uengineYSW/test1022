package vehiclemanagement.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vehiclemanagement.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/driverInfos")
@Transactional
public class DriverInfoController {

    @Autowired
    DriverInfoRepository driverInfoRepository;

    @RequestMapping(
        value = "/driverInfos/{id}//driver/delete",
        method = RequestMethod.DELETE,
        produces = "application/json;charset=UTF-8"
    )
    public DriverInfo deleteDriverInfo(
        @PathVariable(value = "id") String id,
        @RequestBody DeleteDriverInfoCommand deleteDriverInfoCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /driverInfo/deleteDriverInfo  called #####");
        Optional<DriverInfo> optionalDriverInfo = driverInfoRepository.findById(
            id
        );

        optionalDriverInfo.orElseThrow(() -> new Exception("No Entity Found"));
        DriverInfo driverInfo = optionalDriverInfo.get();
        driverInfo.deleteDriverInfo(deleteDriverInfoCommand);

        driverInfoRepository.delete(driverInfo);
        return driverInfo;
    }

    @RequestMapping(
        value = "/driverInfos/{id}/updatedriverinfo",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public DriverInfo updateDriverInfo(
        @PathVariable(value = "id") String id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /driverInfo/updateDriverInfo  called #####");
        Optional<DriverInfo> optionalDriverInfo = driverInfoRepository.findById(
            id
        );

        optionalDriverInfo.orElseThrow(() -> new Exception("No Entity Found"));
        DriverInfo driverInfo = optionalDriverInfo.get();
        driverInfo.updateDriverInfo();

        driverInfoRepository.save(driverInfo);
        return driverInfo;
    }
}
//>>> Clean Arch / Inbound Adaptor
