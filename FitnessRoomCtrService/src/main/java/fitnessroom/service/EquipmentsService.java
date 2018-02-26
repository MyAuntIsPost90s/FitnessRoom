package fitnessroom.service;

import java.util.List;

import fitnessroom.base.model.Equipments;
import fitnessroom.uimodel.EUIPageList;

public interface EquipmentsService {

	public Equipments getSingle(String equipmentid);

	public EUIPageList<Equipments> getList(Equipments equipments, int page, int rows);

	public void add(Equipments equipments);

	public void update(Equipments equipments);
	
	public void delete(List<String> ids);

}
