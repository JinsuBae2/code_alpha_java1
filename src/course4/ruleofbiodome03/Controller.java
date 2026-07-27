package course4.ruleofbiodome03;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Device> devices = new ArrayList<>();

    public void connectDevice(Device device) {
        for (Device value : devices) {
            if (value.getName().equals(device.getName())) {
                System.out.println("이미 연결된 기기입니다.");
                return;
            }
        }
        devices.add(device);
        System.out.println("컨트롤러에 기기가 등록되었습니다 : " + device.getName());
    }

    public void activateSmartFeature(SmartDevice smartDevice) {
        if (!smartDevice.isOn()) {
            System.out.println("전원이 꺼져있어 고급 기능을 활성화할 수 없습니다.");
            return;
        }
        if (smartDevice.getFeature() == null || smartDevice.getFeature().isEmpty()) {
            System.out.println("고급 기능이 설정되지 않았습니다.");
            return;
        }
        smartDevice.activateFeature();
    }

    public void powerOffAll() {
        StringBuilder sb = new StringBuilder("모든 기기 전원을 종료합니다 : ");
        for (int i = 0; i < devices.size(); i++) {
            sb.append(devices.get(i).getName());
            if (i < devices.size() - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }

    public void energySavingOnOff(Device device) {
        device.setEnergySaving(!device.isEnergySaving());
        if (device.isEnergySaving()) {
            System.out.println(device.getName() + "의 절약모드가 활성화 되었습니다.");
        } else {
            System.out.println(device.getName() + "의 절약모드가 비활성화 되었습니다.");
        }
    }

    public void energySavingAll(boolean enable) {
        String isEnable = enable ? "활성화" : "비활성화";
        StringBuilder sb = new StringBuilder("모든 기기의 절약모드가 " + isEnable + " 되었습니다. : ");
        for (int i = 0; i < devices.size(); i++) {
            devices.get(i).setEnergySaving(enable);
            sb.append(devices.get(i).getName());
            if (i < devices.size() - 1) {
                sb.append(", ");
            }
        }

        System.out.println(sb.toString());
    }
}
