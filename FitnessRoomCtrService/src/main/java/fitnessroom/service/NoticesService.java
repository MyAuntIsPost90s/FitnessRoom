package fitnessroom.service;

import java.util.List;

import fitnessroom.base.model.Notices;
import fitnessroom.uimodel.EUIPageList;

public interface NoticesService {

	public Notices getSingle(String noticeid);

	public EUIPageList<Notices> getList(Notices notices, int page, int rows);

	public void add(Notices notices);

	public void update(Notices notices);

	public void delete(List<String> ids);

}
