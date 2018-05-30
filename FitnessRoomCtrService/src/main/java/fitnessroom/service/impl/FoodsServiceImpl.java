package fitnessroom.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import fitness.base.common.RandomNum;
import fitnessroom.base.dao.FoodsMapper;
import fitnessroom.base.model.Foods;
import fitnessroom.service.FoodsService;
import fitnessroom.uimodel.EUIPageList;

@Service
public class FoodsServiceImpl implements FoodsService {

	@Resource
	private FoodsMapper foodsMapper;

	@Override
	public Foods getSingle(String foodid) {
		return foodsMapper.getSingle(foodid);
	}

	@Override
	public EUIPageList<Foods> getList(Foods foods, int page, int rows) {
		PageList<Foods> pageList = foodsMapper.getListWithPage(foods, new PageBounds(page, rows));
		return new EUIPageList<Foods>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	public void add(Foods foods) {
		foods.setFoodid(RandomNum.getLGID());
		foodsMapper.insert(foods);
	}

	@Override
	public void update(Foods foods) {
		foodsMapper.update(foods);
	}

	@Override
	public void delete(List<String> ids) {
		if (ids == null || ids.isEmpty()) {
			return;
		}
		foodsMapper.batchDelete(ids);
	}

}
