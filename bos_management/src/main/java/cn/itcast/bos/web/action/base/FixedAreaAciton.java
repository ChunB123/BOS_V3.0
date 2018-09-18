package cn.itcast.bos.web.action.base;

import cn.itcast.bos.domain.base.FixedArea;
import cn.itcast.bos.service.base.FixedAreaService;
import cn.itcast.bos.web.action.common.BaseAction;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YaphetS
 * @date 2018/9/18 上午10:46
 */
@ParentPackage("json-default")
@Namespace("/")
@Controller
@Scope("prototype")
public class FixedAreaAciton extends BaseAction<FixedArea> {

	@Autowired
	private FixedAreaService fixedAreaService;

	@Action(value = "fixedArea_save",results = {@Result(name = "success",
			location = "pages/base/fixed_area.html",type = "redirect")})
	public String save(){
		fixedAreaService.save(model);
		return SUCCESS;
	}

	@Action(value = "fixedArea_pageQuery",results = {@Result(name = "success",type = "json")})
	public String pageQuery(){
		//page+rows---->total+rows
		Pageable pageable=new PageRequest(page-1,rows);
		Specification<FixedArea> specification=new Specification<FixedArea>() {
			@Override
			public Predicate toPredicate(Root<FixedArea> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();
				// 构造查询条件
				if (StringUtils.isNotBlank(model.getId())) {
					// 根据 定区编号查询 等值
					Predicate p1 = cb.equal(root.get("id").as(String.class), model.getId());
					list.add(p1);
				}

				if (StringUtils.isNotBlank(model.getCompany())) {
					// 根据公司查询 模糊
					Predicate p2 = cb.like(root.get("company").as(String.class),"%" + model.getCompany() + "%");
					list.add(p2);
				}

				return cb.and(list.toArray(new Predicate[0]));
			}
		};

		Page<FixedArea> pageDate=fixedAreaService.findPageDate(specification,pageable);
		pushPageDataToValueStack(pageDate);
		return SUCCESS;
	}

}
