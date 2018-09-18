package cn.itcast.bos.service.base.Impl;

import cn.itcast.bos.dao.base.FixedAreaRespository;
import cn.itcast.bos.domain.base.FixedArea;
import cn.itcast.bos.service.base.FixedAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author YaphetS
 * @date 2018/9/18 上午10:51
 */

@Service
@Transactional
public class FixedAreaServiceImpl implements FixedAreaService {

	@Autowired
	private FixedAreaRespository fixedAreaRespository;

	@Override
	public void save(FixedArea model) {
		fixedAreaRespository.save(model);
	}

	@Override
	public Page<FixedArea> findPageDate(Specification<FixedArea> specification, Pageable pageable) {
		return fixedAreaRespository.findAll(specification,pageable);
	}
}
