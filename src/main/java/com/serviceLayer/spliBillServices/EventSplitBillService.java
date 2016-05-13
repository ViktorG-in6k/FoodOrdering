package com.serviceLayer.spliBillServices;

import com.splitBill.splitBillDTO.event.EventRequestDTO;
import com.splitBill.splitBillDTO.event.EventResponseDTO;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Header;
import retrofit.http.POST;

public interface EventSplitBillService {

    @POST("api/events")
    Call<EventResponseDTO> createEvent(@Header("X-AUTH-TOKEN") String token, @Body EventRequestDTO eventRequestDTO);

}
