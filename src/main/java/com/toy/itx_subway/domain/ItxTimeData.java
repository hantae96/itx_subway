package com.toy.itx_subway.domain;

import lombok.Getter;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Getter

public class ItxTimeData {
    private LinkedHashMap<LocalTime, LocalTime> downTimeTable = new LinkedHashMap<>();

    public ItxTimeData() {
        downTimeTable.put(LocalTime.of(6, 17),LocalTime.of(6, 38));
        downTimeTable.put(LocalTime.of(7, 15),LocalTime.of(7, 35));
        downTimeTable.put(LocalTime.of(8, 11),LocalTime.of(8, 32));
        downTimeTable.put(LocalTime.of(9, 11),LocalTime.of(9, 32));
        downTimeTable.put(LocalTime.of(11, 17),LocalTime.of(11, 38));
        downTimeTable.put(LocalTime.of(12, 18),LocalTime.of(12, 39));
        downTimeTable.put(LocalTime.of(13, 9),LocalTime.of(13, 30));
        downTimeTable.put(LocalTime.of(14, 17),LocalTime.of(14, 37));
        downTimeTable.put(LocalTime.of(15, 36),LocalTime.of(15, 57));
        downTimeTable.put(LocalTime.of(16, 16),LocalTime.of(16, 37));
        downTimeTable.put(LocalTime.of(17, 17),LocalTime.of(17, 38));
        downTimeTable.put(LocalTime.of(18, 5),LocalTime.of(18, 31));
        downTimeTable.put(LocalTime.of(19, 15),LocalTime.of(19, 41));
        downTimeTable.put(LocalTime.of(20, 17),LocalTime.of(20, 43));
        downTimeTable.put(LocalTime.of(20, 49),LocalTime.of(21, 9));
        downTimeTable.put(LocalTime.of(21, 38),LocalTime.of(21, 58));
        downTimeTable.put(LocalTime.of(23, 25),LocalTime.of(23, 25));
    }
}
