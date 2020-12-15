package com.kltn.booking.securities.session;


import com.kltn.booking.dtos.basedtos.SessionDto;
import com.kltn.booking.entities.SessionR;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SessionService {

    Page<SessionDto> getAllSessionsPaging(String search, int page, int size, String sort, String column);

    SessionDto createSession(SessionDto dto);

    SessionDto updateSession(Long id, SessionDto dto);

    SessionDto getSession(Long id);

    String deleteSession(Long id);
}
