package com.splitBill;

import com.splitBill.spliBillServices.BillSplitBillService;
import com.splitBill.spliBillServices.UserSplitBillService;
import com.splitBill.splitBillDTO.LoginDTO;
import com.splitBill.splitBillDTO.Responce;
import com.splitBill.splitBillDTO.UserSplitBillDTO;
import retrofit.JacksonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import java.io.IOException;

public class SplitBillApi {
    private Retrofit retrofit;
    private UserSplitBillService userSplitBillService;
    private BillSplitBillService billSplitBillService;
    private String token;

    public SplitBillApi() {
        retrofit = new Retrofit.Builder()
                                .baseUrl("http://split-bill.herokuapp.com/")
                                .addConverterFactory(JacksonConverterFactory.create())
                                .build();

        userSplitBillService = retrofit.create(UserSplitBillService.class);
        billSplitBillService = retrofit.create(BillSplitBillService.class);
    }

    public void login(String email) throws IOException {
        Response<UserSplitBillDTO> execute = userSplitBillService.login(new LoginDTO(email)).execute();
        token = execute.body().getData();
        System.out.println(execute.body().getData());
    }

    public void newBill(int eventId) throws IOException {
        System.out.println(token);
        Response<Responce> execute =  billSplitBillService.newBill(eventId, token).execute();

        System.out.println(execute.body().getStatus());
        System.out.println(execute.body().getMessage());
        System.out.println(execute.body().getData().getId());
        System.out.println(execute.body().getData().getName());
        System.out.println(execute.body().getData().getEvent().getId());



    }

    public String getToken() {
        return token;
    }
}
