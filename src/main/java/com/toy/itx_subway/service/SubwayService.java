package com.toy.itx_subway.service;

import com.toy.itx_subway.WebClientUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class SubwayService {


    public LocalTime getRemainTime(String stationName){
        String data = getApi(stationName);
        return calSubwayTime(data);
    }

    public String getApi(String stationName) {
        WebClientUtil webClientUtil = new WebClientUtil();
        String data = webClientUtil.getApiResponse(stationName);

        return data;
    }

    private LocalTime calSubwayTime(String response) {

        final Integer movingTime = 12;

        try {
            JSONParser parser = new JSONParser();

            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("realtimeArrivalList");

            // 탑승 시각 + 열차가 도착하는 시간 -> 현재 시각에서 도착예정 시간을 합산함
            LocalTime now = LocalTime.now();
            LocalTime arriveTime = now.plusSeconds(arriveFirstTime(jsonArray));

            // 출발역에서 도착역까지 걸리는 시간 계산 임시로 값을 넣어놓는다.
            LocalTime departTime = arriveTime.plusMinutes(movingTime);

            return departTime;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Integer arriveFirstTime(JSONArray jsonArray) throws JSONException {
        for (int i = 0;i<jsonArray.length();i++){
            JSONObject json = jsonArray.getJSONObject(i);
            if(Objects.equals(String.valueOf(json.get("subwayId")), "1001")){
                String ordkey = (String) json.get("ordkey");
                if(ordkey.charAt(1) == '1'){
                    log.info("도착 지하철 데이터 {}",json);
                    return Integer.valueOf((String) json.get("barvlDt"));
                }
            }

        }
        return 0;
    }
}