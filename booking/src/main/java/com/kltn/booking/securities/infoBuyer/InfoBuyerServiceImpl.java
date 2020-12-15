package com.kltn.booking.securities.infoBuyer;

import com.kltn.booking.conversions.BuyerConversion;
import com.kltn.booking.dtos.basedtos.InfoBuyerDto;
import com.kltn.booking.entities.InfoBuyer;
import com.kltn.booking.repositories.InfoBuyerRepository;
import com.kltn.booking.utils.PageUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InfoBuyerServiceImpl implements InfoBuyerService{

    private final InfoBuyerRepository infoBuyerRepository;

    private final BuyerConversion buyerConversion;

    public InfoBuyerServiceImpl(InfoBuyerRepository infoBuyerRepository, BuyerConversion buyerConversion) {
        this.infoBuyerRepository = infoBuyerRepository;
        this.buyerConversion = buyerConversion;
    }

    @Override
    public Page<InfoBuyer> getAllInfoBuyersPaging(String search, int page, int size, String sort, String column) {
        Pageable pageable = PageUtils.createPageable(page, size, sort, column);
        return infoBuyerRepository.getAllInfoBuyersPaging(search, pageable);
    }

    @Override
    public InfoBuyerDto createInfoBuyer(InfoBuyerDto dto) {
        InfoBuyer infoBuyer=buyerConversion.toInfoBuyerEntity(dto);
        infoBuyerRepository.save(infoBuyer);
        return buyerConversion.toInfoBuyerDto(infoBuyer);
    }

    @Override
    public InfoBuyerDto updateInfoBuyer(Long id, InfoBuyerDto dto) {
        InfoBuyer infoBuyer=infoBuyerRepository.findById(id).get();
        infoBuyer=buyerConversion.toInfoBuyerEntity(infoBuyer,dto);
        infoBuyerRepository.save(infoBuyer);
        return buyerConversion.toInfoBuyerDto(infoBuyer);
    }

    @Override
    public InfoBuyerDto getInfoBuyer(Long id) {
        InfoBuyer infoBuyer=infoBuyerRepository.findById(id).get();
        return buyerConversion.toInfoBuyerDto(infoBuyer);
    }
}
