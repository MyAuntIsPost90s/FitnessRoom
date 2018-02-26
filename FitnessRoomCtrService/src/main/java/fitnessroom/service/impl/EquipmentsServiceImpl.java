package fitnessroom.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import fitness.base.common.RandomNum;
import fitnessroom.base.dao.EquipmentsMapper;
import fitnessroom.base.model.Equipments;
import fitnessroom.service.EquipmentsService;
import fitnessroom.uimodel.EUIPageList;

@Service
public class EquipmentsServiceImpl implements EquipmentsService {

	@Resource
	private EquipmentsMapper equipmentsMapper;

	@Override
	public Equipments getSingle(String equipmentid) {
		return equipmentsMapper.getSingle(equipmentid);
	}

	@Override
	public EUIPageList<Equipments> getList(Equipments equipments, int page, int rows) {
		PageList<Equipments> pageList = equipmentsMapper.getListWithPage(equipments, new PageBounds(page,rows));
		return new EUIPageList<Equipments>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	public void add(Equipments equipments) {
		equipments.setEquipmentid(RandomNum.getEID());
		equipmentsMapper.insert(equipments);
	}

	@Override
	public void update(Equipments equipments) {
		equipmentsMapper.update(equipments);
	}

	@Override
	public void delete(List<String> ids) {
		equipmentsMapper.batchDelete(ids);
	}
	
	
}
