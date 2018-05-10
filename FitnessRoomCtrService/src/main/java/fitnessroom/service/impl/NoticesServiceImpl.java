package fitnessroom.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import fitness.base.common.RandomNum;
import fitnessroom.base.dao.NoticesMapper;
import fitnessroom.base.model.Notices;
import fitnessroom.service.NoticesService;
import fitnessroom.uimodel.EUIPageList;

@Service
public class NoticesServiceImpl implements NoticesService {

	@Resource
	private NoticesMapper noticesMapper;

	@Override
	public Notices getSingle(String noticeid) {
		return noticesMapper.getSingle(noticeid);
	}

	@Override
	public EUIPageList<Notices> getList(Notices notices, int page, int rows) {
		PageList<Notices> pageList = noticesMapper.getListWithPage(notices, new PageBounds(page, rows));
		return new EUIPageList<Notices>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	public void add(Notices notices) {
		notices.setNoticeid(RandomNum.getNID());
		notices.setNoticetime(new Date());
		noticesMapper.insert(notices);
	}

	@Override
	public void update(Notices notices) {
		noticesMapper.update(notices);
	}

	@Override
	public void delete(List<String> ids) {
		if (ids == null || ids.isEmpty()) {
			return;
		}
		noticesMapper.batchDelete(ids);
	}

}
