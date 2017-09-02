package com.zhiyou100.video.service.MerchantImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.MerchantMapper;
import com.zhiyou100.video.model.Merchant;
import com.zhiyou100.video.model.MerchantExample;
import com.zhiyou100.video.service.MerchantService;
@Service
public class MerchantImpl implements MerchantService {
		@Autowired
		MerchantMapper mm;

		@Override
		public List<Merchant> selectMerchant(Merchant mer) {
			MerchantExample example = new MerchantExample();
			example.createCriteria().andMerchantEqualTo(mer.getMerchant()).andLegalpersonEqualTo(mer.getLegalperson());
			return mm.selectByExample(example);
		}

		@Override
		public void inMerchant(Merchant mer) {
			mm.updateByPrimaryKeySelective(mer);
		}

		@Override
		public Merchant selectMc(Merchant mer) {
			return mm.selectByPrimaryKey(mer.getId());
		}
}
