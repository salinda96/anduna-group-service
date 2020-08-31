package lk.andunaechomedia.dtos.sendDtos;

import lk.andunaechomedia.constant.DeviceStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Enumerated;
@Getter
@Setter
public class SendRPIStatusDto {
    @Enumerated
    DeviceStatus deviceStatus;
}
