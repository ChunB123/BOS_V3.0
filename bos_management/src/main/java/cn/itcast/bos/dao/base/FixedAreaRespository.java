package cn.itcast.bos.dao.base;

import cn.itcast.bos.domain.base.FixedArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author YaphetS
 * @date 2018/9/18 上午10:57
 */

public interface FixedAreaRespository extends JpaRepository<FixedArea,String>,JpaSpecificationExecutor<FixedArea> {
}
