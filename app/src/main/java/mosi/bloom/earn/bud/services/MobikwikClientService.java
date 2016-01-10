package mosi.bloom.earn.bud.services;

import mosi.bloom.earn.bud.pojo.MobiKwikUser;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Harendra Kumar on 08-01-2016.
 */
public interface MobikwikClientService {
    //https://walletapi.mobikwik.com/querywallet?checksum=486708b2c7e6c0981284f3e3484cc3e6c62a1d9cc206928ceacf0a02e9d63362&cell=9623280300&msgcode=500&mid=MBK9002&merchantname=Test Merchant&action=existingusercheck
    @GET("/querywallet?checksum=486708b2c7e6c0981284f3e3484cc3e6c62a1d9cc206928ceacf0a02e9d63362&cell={phone}&msgcode=500&mid=MBK9002&merchantname=Test Merchant&action=existingusercheck")
    Call<MobiKwikUser> getMKuser(@Path("phone") String phone);

}
