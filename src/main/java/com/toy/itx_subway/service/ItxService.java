package com.toy.itx_subway.service;


import com.toy.itx_subway.domain.ItxTimeData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.LinkedHashMap;

@Service
@RequiredArgsConstructor
public class ItxService {
    private final SubwayService subwayService;
    private final ItxTimeData itxTimeData;

    public LocalTime check(String stationName){
        LocalTime minTime = null;

//        LocalTime subwayTime = subwayService.getRemainTime(stationName);
        LocalTime subwayTime = LocalTime.of(11,18);
        System.out.println("subwayTime = " + subwayTime);
        LinkedHashMap<LocalTime, LocalTime> downTimeTable = itxTimeData.getDownTimeTable();
        for (LocalTime localTime : downTimeTable.keySet()) {
            if (!Duration.between(subwayTime,localTime).isNegative()){
                System.out.println("itxTime = " + localTime);
                return localTime;
            }
        }

        return minTime;
    }
}
