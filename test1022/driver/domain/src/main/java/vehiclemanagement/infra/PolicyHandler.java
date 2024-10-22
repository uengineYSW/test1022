package vehiclemanagement.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import vehiclemanagement.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DriverInfoRepository driverInfoRepository;

    // @StreamListener(KafkaProcessor.INPUT)
    // public void whatever(@Payload String eventString) {}

    // @StreamListener(
    //     value = KafkaProcessor.INPUT,
    //     condition = "headers['type']=='UserInfoUpdated'"
    // )
    // public void wheneverUserInfoUpdated_Update(
    //     @Payload UserInfoUpdated userInfoUpdated
    // ) {
    //     UserInfoUpdated event = userInfoUpdated;
    //     System.out.println(
    //         "\n\n##### listener Update : " + userInfoUpdated + "\n\n"
    //     );

    //     // Sample Logic //
    //     DriverInfo.update(event);
    // }
}
//>>> Clean Arch / Inbound Adaptor
