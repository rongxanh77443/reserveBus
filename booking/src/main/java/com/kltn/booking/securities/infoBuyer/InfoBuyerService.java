package com.kltn.booking.securities.infoBuyer;

import com.kltn.booking.dtos.basedtos.InfoBuyerDto;
import com.kltn.booking.entities.InfoBuyer;
import org.springframework.data.domain.Page;

public interface InfoBuyerService {
    Page<InfoBuyer> getAllInfoBuyersPaging(String search, int page, int size, String sort, String column);

    InfoBuyerDto createInfoBuyer(InfoBuyerDto dto);

    InfoBuyerDto updateInfoBuyer(Long id, InfoBuyerDto dto);

    InfoBuyerDto getInfoBuyer(Long id);
}
