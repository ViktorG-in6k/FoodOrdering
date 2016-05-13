package com.serviceLayer.spliBillServices;

import com.splitBill.splitBillDTO.user.UserLoginResponceJSON;
import com.splitBill.splitBillDTO.user.UserLoginRequestJSON;
import retrofit.Call;
import retrofit.http.*;

public interface UserSplitBillService {
    @Headers( "Content-Type: application/json" )
    @POST("api/user/login")
    Call<UserLoginResponceJSON> login(@Body UserLoginRequestJSON request);
}
