package com.splitBill;

import com.splitBill.spliBillServices.EventSplitBillService;
import com.splitBill.spliBillServices.UserSplitBillService;
import com.splitBill.splitBillDTO.EventRequestDTO;
import com.splitBill.splitBillDTO.EventResponseDTO;
import com.splitBill.splitBillDTO.UserSplitBillDTO;
import com.splitBill.splitBillDTO.loginDTO;
import retrofit.Callback;
import retrofit.JacksonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import java.io.IOException;

public class SplitBillApi {
    private Retrofit retrofit;
    private UserSplitBillService userSplitBillService;
    private EventSplitBillService eventSplitBillService;
    private String token;
    private int eventId;

    public SplitBillApi() {
        retrofit = new Retrofit.Builder()
                                .baseUrl("http://split-bill.herokuapp.com/")
                                .addConverterFactory(JacksonConverterFactory.create())
                                .build();

        userSplitBillService = retrofit.create(UserSplitBillService.class);
        eventSplitBillService = retrofit.create(EventSplitBillService.class);
    }

    public void login(String email){
        userSplitBillService.login(new loginDTO(email)).enqueue(new Callback<UserSplitBillDTO>() {
            @Override
            public void onResponse(Response<UserSplitBillDTO> response, Retrofit retrofit) {
                System.out.println(response);
                System.out.println(response.body().getData());
                token = response.body().getData();
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("fail");
            }
        });
    }

    public void createEvent(String eventTitle, String eventDate) throws IOException {
        Response<EventResponseDTO> execute = eventSplitBillService.createEvent(token, new EventRequestDTO(eventTitle, eventDate)).execute();
        eventId = execute.body().getData();
    }


}
