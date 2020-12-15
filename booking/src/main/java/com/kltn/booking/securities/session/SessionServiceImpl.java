package com.kltn.booking.securities.session;


import com.kltn.booking.conversions.SessionConversion;
import com.kltn.booking.dtos.basedtos.SessionDto;
import com.kltn.booking.entities.SessionR;
import com.kltn.booking.repositories.CarRepository;
import com.kltn.booking.repositories.RouteRepository;
import com.kltn.booking.repositories.SessionRepository;
import com.kltn.booking.utils.PageUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService{

    private final SessionRepository sessionRepository;

    private final SessionConversion sessionConversion;


    public SessionServiceImpl(SessionRepository sessionRepository, SessionConversion sessionConversion) {
        this.sessionRepository = sessionRepository;
        this.sessionConversion = sessionConversion;
    }

    @Override
    public Page<SessionDto> getAllSessionsPaging(String search, int page, int size, String sort, String column) {
        Pageable pageable = PageUtils.createPageable(page, size, sort, column);
        Page<SessionR> sessionRPage=sessionRepository.getAllSessionsPaging(search, pageable);
        return sessionRPage.map(SessionR->sessionConversion.toSessionDto(SessionR));
    }

    @Override
    public SessionDto createSession(SessionDto dto) {
        SessionR session= sessionConversion.toSessionEntity(dto);
        sessionRepository.save(session);
        return sessionConversion.toSessionDto(session);
    }

    @Override
    public SessionDto updateSession(Long id, SessionDto dto) {
        SessionR session= sessionRepository.getOne(id);
        session=sessionConversion.toSessionEntity(session,dto);
        sessionRepository.save(session);
        return sessionConversion.toSessionDto(session);
    }

    @Override
    public SessionDto getSession(Long id) {
        SessionR session=sessionRepository.getOne(id);
        return sessionConversion.toSessionDto(session);
    }

    @Override
    public String deleteSession(Long id) {
        try {
            sessionRepository.delete(sessionRepository.getOne(id));
            return "OK";
        }
        catch (Exception e){
            System.out.println("Exception "+e);
            return "NO";
        }
    }
}
