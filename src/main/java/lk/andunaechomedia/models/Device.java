package lk.andunaechomedia.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "device")
@Getter
@Setter
public  class Device implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String device_id;
    private String customer_name;
    private String start_point;
    private String end_point;
    private String device_address;
    private String tel_number;
    private  String status;
    Date publishDate;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "device_group_id", nullable=false)
    private DeviceGroup deviceGroup;

    public Device() {
    }

    @Override
    public String toString() {
        return "Device{" +
                "device_id='" + device_id + '\'' +
                ", customer_name='" + customer_name + '\'' +
                ", start_point='" + start_point + '\'' +
                ", end_point='" + end_point + '\'' +
                ", device_address='" + device_address + '\'' +
                ", tel_number='" + tel_number + '\'' +
                ", status='" + status + '\'' +
                ", publishDate=" + publishDate +
                ", deviceGroup=" + deviceGroup +
                '}';
    }

    public Device(String device_id, String customer_name, String start_point, String end_points, String device_address, String tel_number, Date publish_date) {
        this.setDevice_id(device_id);
        this.setCustomer_name(customer_name);
        this.setStart_point(start_point);
        this.setEnd_point(end_points);
        this.setDevice_address(device_address);
        this.setTel_number(tel_number);
        this.setPublishDate(publish_date);

    }

}

    /*public void updatePartial(Device device, String deice_id){
        Device newDevice = deviceRepo.findOne(device_id);
        if (device.getCustomer_name() != null){
            newDevice.setCustomer_name(device.getCustomer_name());
        }
        if (device.getStart_point() != null){
            newDevice.setStart_point(device.getStart_point());
        }
        if (device.getEnd_point() != null){
            newDevice.setEnd_point(device.getEnd_point());
        }
        if (device.getDevice_address() != null){
            newDevice.setDevice_address(device.getDevice_address());
        }
        if (device.getTel_number() != null){
            newDevice.setTel_number(device.getTel_number());
        }
        if (device.getPublish_date() != null){
            newDevice.setPublish_date(device.getPublish_date());
        }
    }*/

