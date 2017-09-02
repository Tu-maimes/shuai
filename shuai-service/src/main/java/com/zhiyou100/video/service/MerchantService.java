package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Merchant;

public interface MerchantService {

	List<Merchant> selectMerchant(Merchant mer);

	void inMerchant(Merchant mer);

	Merchant selectMc(Merchant mer);


}
