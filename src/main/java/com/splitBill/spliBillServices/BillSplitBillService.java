package com.splitBill.spliBillServices;

import com.splitBill.splitBillDTO.bill.BillResponceJSON;
import retrofit.Call;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;

public interface BillSplitBillService {
    @Headers( "Content-Type: application/json" )
    @POST("api/events/{id}/bills")
    Call<BillResponceJSON> newBill(@Path("id") int eventId, @Header("X-AUTH-TOKEN") String token);
}
