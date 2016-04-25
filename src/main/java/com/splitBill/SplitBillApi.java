package com.splitBill;


import com.splitBill.spliBillServices.BillSplitBillService;
import com.splitBill.spliBillServices.EventSplitBillService;
import com.splitBill.spliBillServices.ProductSplitBillService;
import com.splitBill.spliBillServices.UserSplitBillService;
import com.splitBill.splitBillDTO.bill.BillResponceJSON;
import com.splitBill.splitBillDTO.event.EventRequestDTO;
import com.splitBill.splitBillDTO.event.EventResponseDTO;
import com.splitBill.splitBillDTO.product.ProductRequestJSON;
import com.splitBill.splitBillDTO.product.ProductResponseJSON;
import com.splitBill.splitBillDTO.user.UserLoginRequestJSON;
import com.splitBill.splitBillDTO.user.UserLoginResponceJSON;
import retrofit.JacksonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import java.io.IOException;

public class SplitBillApi {
    private Retrofit retrofit;
    private UserSplitBillService userSplitBillService;
    private EventSplitBillService eventSplitBillService;
    private BillSplitBillService billSplitBillService;
    private ProductSplitBillService productSplitBillService;
    private String token;
    private int eventId;
    private int billId;

    public SplitBillApi() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://split-bill.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        userSplitBillService = retrofit.create(UserSplitBillService.class);
        eventSplitBillService = retrofit.create(EventSplitBillService.class);
        billSplitBillService = retrofit.create(BillSplitBillService.class);
        productSplitBillService = retrofit.create(ProductSplitBillService.class);
    }

    public void login(String email) throws IOException {
        Response<UserLoginResponceJSON> execute = userSplitBillService.login(new UserLoginRequestJSON(email)).execute();
        token = execute.body().getData();
    }

    public void newBill(int eventId) throws IOException {
        Response<BillResponceJSON> execute = billSplitBillService.newBill(eventId, token).execute();
        billId = execute.body().getData().getId();
    }

    public void newProduct(ProductRequestJSON productRequestJSON) throws IOException {
        System.out.println(token);
        System.out.println(billId);
        Response<ProductResponseJSON> execute = productSplitBillService.addProduct(productRequestJSON,billId, token).execute();
        System.out.println(execute.body().getStatus());
        System.out.println(execute.body().getMessage());
        System.out.println(execute.body().getData().getTitle());
        System.out.println(execute.body().getData().getAmount());
        System.out.println(execute.body().getData().getPrice());
    }

    public String getToken() {
        return token;
    }

    public void createEvent(String eventTitle, String eventDate) throws IOException {
        Response<EventResponseDTO> execute = eventSplitBillService.createEvent(token, new EventRequestDTO(eventTitle, eventDate)).execute();
        eventId = execute.body().getData();
    }
}

