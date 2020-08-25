package lk.andunaechomedia.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveDeviceDto {
    private String deviceId;
    private String customerName;
    private String deviceAddress;
    private String endPoint;
    private String startPoint;
    private String telNumber;
    private String status;
    private String deviceGroupId;

    @Override
    public String toString() {
        return "SaveDeviceDto{" +
                "deviceId='" + deviceId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", deviceAddress='" + deviceAddress + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", startPoint='" + startPoint + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", status='" + status + '\'' +
                ", deviceGroupId='" + deviceGroupId + '\'' +
                '}';
    }
}
