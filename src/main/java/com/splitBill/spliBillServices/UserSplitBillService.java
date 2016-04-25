package com.splitBill.spliBillServices;

import com.splitBill.splitBillDTO.UserSplitBillDTO;
import com.splitBill.splitBillDTO.loginDTO;
import retrofit.Call;
import retrofit.http.*;

public interface UserSplitBillService {
    @Headers( "Content-Type: application/json" )
    @POST("api/user/login")
    Call<UserSplitBillDTO> login(@Body loginDTO request);
}
