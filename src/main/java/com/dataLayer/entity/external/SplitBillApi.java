package com.dataLayer.entity.external;

import com.serviceLayer.spliBillServices.BillSplitBillService;
import com.serviceLayer.spliBillServices.EventSplitBillService;
import com.serviceLayer.spliBillServices.ProductSplitBillService;
import com.serviceLayer.spliBillServices.UserSplitBillService;
import com.dataLayer.splitBillDTO.bill.BillResponceJSON;
import com.dataLayer.splitBillDTO.event.EventRequestDTO;
import com.dataLayer.splitBillDTO.event.EventResponseDTO;
import com.dataLayer.splitBillDTO.product.ProductRequestJSON;
import com.dataLayer.splitBillDTO.product.ProductResponseJSON;
import com.dataLayer.splitBillDTO.user.UserLoginRequestJSON;
import com.dataLayer.splitBillDTO.user.UserLoginResponceJSON;
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
        Response<ProductResponseJSON> execute = productSplitBillService.addProduct(productRequestJSON, billId, token).execute();
    }

    public String getToken() {
        return token;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public void createEvent(String eventTitle, String eventDate) throws IOException {
        Response<EventResponseDTO> execute = eventSplitBillService.createEvent(token, new EventRequestDTO(eventTitle, eventDate)).execute();
        eventId = execute.body().getData();
    }
}

