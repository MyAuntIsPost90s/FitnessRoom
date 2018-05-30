package fitnessroom.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import fitness.base.common.RandomNum;
import fitnessroom.base.dao.ExpectfoodsMapper;
import fitnessroom.base.model.Expectfoods;
import fitnessroom.base.model.Foods;
import fitnessroom.base.model.dto.ExpectfoodsDto;
import fitnessroom.base.model.dto.ExpectfoodsUserDto;
import fitnessroom.service.ExpectfoodsService;
import fitnessroom.service.FoodsService;
import fitnessroom.uimodel.EUIPageList;

@Service
public class ExpectfoodsServiceImpl implements ExpectfoodsService {

	@Resource
	private ExpectfoodsMapper expectfoodsMapper;
	@Resource
	private FoodsService foodsService;

	@Override
	public EUIPageList<ExpectfoodsDto> getList(Expectfoods expectfoods, int page, int rows) {
		expectfoods.setExpectfoodtime(new Date());
		PageList<Expectfoods> pageList = expectfoodsMapper.getListWithPage(expectfoods, new PageBounds(page, rows));
		List<ExpectfoodsDto> result = this.getExpectfoodsDtos(pageList);
		return new EUIPageList<ExpectfoodsDto>(pageList.getPaginator().getTotalCount(), result);
	}

	@Override
	public EUIPageList<ExpectfoodsDto> list4overdue(Expectfoods expectfoods, int page, int rows) {
		PageList<Expectfoods> pageList = expectfoodsMapper.getListWithOverdue(expectfoods, new PageBounds(page, rows));
		List<ExpectfoodsDto> result = this.getExpectfoodsDtos(pageList);
		return new EUIPageList<ExpectfoodsDto>(pageList.getPaginator().getTotalCount(), result);
	}

	@Override
	public List<ExpectfoodsUserDto> list4expect(String foodid) {
		List<ExpectfoodsUserDto> list = expectfoodsMapper.getExpectUser(foodid);
		for (ExpectfoodsUserDto item : list) {
			item.setTotalprice(item.getCount() * item.getFoodprice());
		}
		return list;
	}

	@Override
	public void add(Expectfoods expectfoods) {
		expectfoods.setExpectfoodid(RandomNum.getLGID());
		expectfoodsMapper.insert(expectfoods);
	}

	@Override
	public void delete(List<String> ids) {
		expectfoodsMapper.batchDelete(ids);
	}

	private List<ExpectfoodsDto> getExpectfoodsDtos(List<Expectfoods> list) {
		List<ExpectfoodsDto> result = new ArrayList<ExpectfoodsDto>();
		for (Expectfoods item : list) {
			ExpectfoodsDto expectfoodsDto = new ExpectfoodsDto();
			expectfoodsDto.setExpectfoodid(item.getExpectfoodid());
			expectfoodsDto.setExpectfoodtime(item.getExpectfoodtime());
			expectfoodsDto.setNote(item.getNote());
			expectfoodsDto.setUserid(item.getUserid());
			expectfoodsDto.setFoodid(item.getFoodid());
			Foods foods = foodsService.getSingle(item.getFoodid());
			if (foods == null) {
				foods = new Foods();
			}
			expectfoodsDto.setFoodname(foods.getFoodname());
			expectfoodsDto.setFoodprice(foods.getFoodprice());
			result.add(expectfoodsDto);
		}
		return result;
	}

}
