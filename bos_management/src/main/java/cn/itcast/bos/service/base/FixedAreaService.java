package cn.itcast.bos.service.base;

import cn.itcast.bos.domain.base.FixedArea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author YaphetS
 * @date 2018/9/18 上午10:49
 */
public interface FixedAreaService {
	void save(FixedArea model);

	Page<FixedArea> findPageDate(Specification<FixedArea> specification, Pageable pageable);
}
