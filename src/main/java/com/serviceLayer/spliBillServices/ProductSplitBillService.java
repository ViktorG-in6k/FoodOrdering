package com.serviceLayer.spliBillServices;

import com.splitBill.splitBillDTO.product.ProductRequestJSON;
import com.splitBill.splitBillDTO.product.ProductResponseJSON;
import retrofit.Call;
import retrofit.http.*;

public interface ProductSplitBillService {
    @Headers("Content-Type: application/json")
    @PUT("api/bills/{id}/products")
    Call<ProductResponseJSON> addProduct(@Body ProductRequestJSON product, @Path("id") int billId,
                                         @Header("X-AUTH-TOKEN") String token);
}

