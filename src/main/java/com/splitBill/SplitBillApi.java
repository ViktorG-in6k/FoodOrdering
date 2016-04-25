package com.splitBill;


import com.splitBill.spliBillServices.EventSplitBillService;
import com.splitBill.spliBillServices.UserSplitBillService;
import com.splitBill.splitBillDTO.event.EventRequestDTO;
import com.splitBill.splitBillDTO.event.EventResponseDTO;
import com.splitBill.spliBillServices.BillSplitBillService;
import com.splitBill.splitBillDTO.login.LoginDTO;
import com.splitBill.splitBillDTO.bill.BillResponceJSON;
import com.splitBill.splitBillDTO.user.UserSplitBillDTO;
import retrofit.JacksonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import java.io.IOException;

public class SplitBillApi {
    private Retrofit retrofit;
    private UserSplitBillService userSplitBillService;
    private EventSplitBillService eventSplitBillService;
    private BillSplitBillService billSplitBillService;
    private String token;
    private int eventId;


    public SplitBillApi() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://split-bill.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        userSplitBillService = retrofit.create(UserSplitBillService.class);
        eventSplitBillService = retrofit.create(EventSplitBillService.class);
        billSplitBillService = retrofit.create(BillSplitBillService.class);
    }

    public void login(String email) throws IOException {
        Response<UserSplitBillDTO> execute = userSplitBillService.login(new LoginDTO(email)).execute();
        token = execute.body().getData();
    }

    public void newBill(int eventId) throws IOException {
        System.out.println(token);
        Response<BillResponceJSON> execute = billSplitBillService.newBill(eventId, token).execute();
    }

    public String getToken() {
        return token;
    }

    public void createEvent(String eventTitle, String eventDate) throws IOException {
        Response<EventResponseDTO> execute = eventSplitBillService.createEvent(token, new EventRequestDTO(eventTitle, eventDate)).execute();
        eventId = execute.body().getData();
    }
}

