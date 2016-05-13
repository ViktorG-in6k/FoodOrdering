package com.serviceLayer.spliBillServices;

import com.dataLayer.splitBillDTO.user.UserLoginResponceJSON;
import com.dataLayer.splitBillDTO.user.UserLoginRequestJSON;
import retrofit.Call;
import retrofit.http.*;

public interface UserSplitBillService {
    @Headers( "Content-Type: application/json" )
    @POST("api/user/login")
    Call<UserLoginResponceJSON> login(@Body UserLoginRequestJSON request);
}
