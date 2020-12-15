package com.kltn.booking.conversions;

import com.kltn.booking.dtos.basedtos.InfoBuyerDto;
import com.kltn.booking.entities.InfoBuyer;
import org.springframework.stereotype.Component;

@Component
public class BuyerConversion {

    public InfoBuyer toInfoBuyerEntity(InfoBuyerDto infoBuyerDto){
        InfoBuyer infoBuyer=new InfoBuyer();
        infoBuyer.setFullName(infoBuyerDto.getFullName());
        infoBuyer.setNumberPhone(infoBuyerDto.getNumberPhone());
        infoBuyer.setAddress(infoBuyerDto.getAddress());
        infoBuyer.setEmail(infoBuyerDto.getEmail());
        return infoBuyer;
    }
    public InfoBuyerDto toInfoBuyerDto(InfoBuyer infoBuyer){
        InfoBuyerDto infoBuyerDto=new InfoBuyerDto();
        if (infoBuyer.getId()!=null)
        {
            infoBuyerDto.setId(infoBuyer.getId());
        }
        infoBuyerDto.setAddress(infoBuyer.getAddress());
        infoBuyerDto.setEmail(infoBuyer.getEmail());
        infoBuyerDto.setFullName(infoBuyer.getFullName());
        infoBuyerDto.setNumberPhone(infoBuyer.getNumberPhone());
        return infoBuyerDto;
    }

    public InfoBuyer toInfoBuyerEntity(InfoBuyer infoBuyer,InfoBuyerDto infoBuyerDto) {
        infoBuyer.setFullName(infoBuyerDto.getFullName());
        infoBuyer.setNumberPhone(infoBuyerDto.getNumberPhone());
        infoBuyer.setAddress(infoBuyerDto.getAddress());
        infoBuyer.setEmail(infoBuyerDto.getEmail());
        return infoBuyer;
    }
}
