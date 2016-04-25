package com.serviceLayer.service.splitBill;

import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

public class SplitBillApi {
    private Retrofit retrofit;

    public SplitBillApi() {
        retrofit = new Retrofit.Builder()
                                .baseUrl("http://split-bill.herokuapp.com/")
                                .addConverterFactory(JacksonConverterFactory.create())
                                .build();
    }

}
