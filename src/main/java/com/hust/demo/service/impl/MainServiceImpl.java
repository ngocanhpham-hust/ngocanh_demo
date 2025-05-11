package com.hust.demo.service.impl;

import com.hust.demo.common.MainValidate;
import com.hust.demo.model.Person;
import com.hust.demo.model.ServiceResponse;
import com.hust.demo.service.MainService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    MainValidate mainValidate;


    private static final Map<String, String> provinceCodes = new HashMap<>();

    static {
        provinceCodes.put("001", "Thành phố Hà Nội");
        provinceCodes.put("002", "Tỉnh Hà Giang");
        provinceCodes.put("004", "Tỉnh Cao Bằng");
        provinceCodes.put("006", "Tỉnh Bắc Kạn");
        provinceCodes.put("008", "Tỉnh Tuyên Quang");
        provinceCodes.put("010", "Tỉnh Lào Cai");
        provinceCodes.put("011", "Tỉnh Điện Biên");
        provinceCodes.put("012", "Tỉnh Lai Châu");
        provinceCodes.put("014", "Tỉnh Sơn La");
        provinceCodes.put("015", "Tỉnh Yên Bái");
        provinceCodes.put("017", "Tỉnh Hoà Bình");
        provinceCodes.put("019", "Tỉnh Thái Nguyên");
        provinceCodes.put("020", "Tỉnh Lạng Sơn");
        provinceCodes.put("022", "Tỉnh Quảng Ninh");
        provinceCodes.put("024", "Tỉnh Bắc Giang");
        provinceCodes.put("025", "Tỉnh Phú Thọ");
        provinceCodes.put("026", "Tỉnh Vĩnh Phúc");
        provinceCodes.put("027", "Tỉnh Bắc Ninh");
        provinceCodes.put("030", "Tỉnh Hải Dương");
        provinceCodes.put("031", "Thành phố Hải Phòng");
        provinceCodes.put("033", "Tỉnh Hưng Yên");
        provinceCodes.put("034", "Tỉnh Thái Bình");
        provinceCodes.put("035", "Tỉnh Hà Nam");
        provinceCodes.put("036", "Tỉnh Nam Định");
        provinceCodes.put("037", "Tỉnh Ninh Bình");
        provinceCodes.put("038", "Tỉnh Thanh Hóa");
        provinceCodes.put("040", "Tỉnh Nghệ An");
        provinceCodes.put("042", "Tỉnh Hà Tĩnh");
        provinceCodes.put("044", "Tỉnh Quảng Bình");
        provinceCodes.put("045", "Tỉnh Quảng Trị");
        provinceCodes.put("046", "Tỉnh Thừa Thiên Huế");
        provinceCodes.put("048", "Thành phố Đà Nẵng");
        provinceCodes.put("049", "Tỉnh Quảng Nam");
        provinceCodes.put("051", "Tỉnh Quảng Ngãi");
        provinceCodes.put("052", "Tỉnh Bình Định");
        provinceCodes.put("054", "Tỉnh Phú Yên");
        provinceCodes.put("056", "Tỉnh Khánh Hòa");
        provinceCodes.put("058", "Tỉnh Ninh Thuận");
        provinceCodes.put("060", "Tỉnh Bình Thuận");
        provinceCodes.put("062", "Tỉnh Kon Tum");
        provinceCodes.put("064", "Tỉnh Gia Lai");
        provinceCodes.put("066", "Tỉnh Đắk Lắk");
        provinceCodes.put("067", "Tỉnh Đắk Nông");
        provinceCodes.put("068", "Tỉnh Lâm Đồng");
        provinceCodes.put("070", "Tỉnh Bình Phước");
        provinceCodes.put("072", "Tỉnh Tây Ninh");
        provinceCodes.put("074", "Tỉnh Bình Dương");
        provinceCodes.put("075", "Tỉnh Đồng Nai");
        provinceCodes.put("077", "Tỉnh Bà Rịa - Vũng Tàu");
        provinceCodes.put("079", "Thành phố Hồ Chí Minh");
        provinceCodes.put("080", "Tỉnh Long An");
        provinceCodes.put("082", "Tỉnh Tiền Giang");
        provinceCodes.put("083", "Tỉnh Bến Tre");
        provinceCodes.put("084", "Tỉnh Trà Vinh");
        provinceCodes.put("086", "Tỉnh Vĩnh Long");
        provinceCodes.put("087", "Tỉnh Đồng Tháp");
        provinceCodes.put("089", "Tỉnh An Giang");
        provinceCodes.put("091", "Tỉnh Kiên Giang");
        provinceCodes.put("092", "Thành phố Cần Thơ");
        provinceCodes.put("093", "Tỉnh Hậu Giang");
        provinceCodes.put("094", "Tỉnh Sóc Trăng");
        provinceCodes.put("095", "Tỉnh Bạc Liêu");
        provinceCodes.put("096", "Tỉnh Cà Mau");
    }

    @Override
    public String getName(String name){
        return "Phúc";
    }

    @Override
    public ServiceResponse saveData(Person person) {
        ServiceResponse serviceResponse = new ServiceResponse();
        // validate

        serviceResponse = mainValidate.validatePerson(person);
        if (serviceResponse.getCode() == 0) {
            return serviceResponse;
        }

        // process logic

    //phan tích idNumber. Trả ra các thong so nhu sau
        //https://thuvienphapluat.vn/phap-luat/ho-tro-phap-luat/ma-63-tinh-thanh-pho-su-dung-tren-the-can-cuoc-cong-dan-gan-chip-y-nghia-ma-so-can-cuoc-cong-dan-ga-986546-31326.html
        //037xxxx


        String idNumber = person.getIdNumber();
        String province = provinceCodes.getOrDefault(provinceCodes, "Mã tỉnh/thành phố không xác định");


        // first 3 digits
        String provinceCode = idNumber.substring(0, 3);

        // 4th digit
        char genderCenturyCode = idNumber.charAt(3);
        String gender = "";
        String century = "";
        switch (genderCenturyCode) {
            case '0':
            case '1':
                century = "Thế kỷ 20";
                gender = (genderCenturyCode == '0') ? "Nam" : "Nữ";
                break;
            case '2':
            case '3':
                century = "Thế kỷ 21";
                gender = (genderCenturyCode == '2') ? "Nam" : "Nữ";
                break;
            case '4':
            case '5':
                century = "Thế kỷ 22";
                gender = (genderCenturyCode == '4') ? "Nam" : "Nữ";
                break;
            case '6':
            case '7':
                century = "Thế kỷ 23";
                gender = (genderCenturyCode == '6') ? "Nam" : "Nữ";
                break;
            case '8':
            case '9':
                century = "Thế kỷ 24";
                gender = (genderCenturyCode == '8') ? "Nam" : "Nữ";
                break;
        }

        // 2 next digit
        String yearCode = idNumber.substring(4, 6);
        int year = (genderCenturyCode - '0') / 2 * 100 + Integer.parseInt(yearCode);

        // last 6 digits
        String randomNumber = idNumber.substring(6);

        return serviceResponse;


    }

}
