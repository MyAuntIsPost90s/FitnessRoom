package fitnessroom.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fitness.base.common.RandomNum;
import lingshi.web.model.RequestFile;
import lingshi.web.model.RequestHolder;
import net.coobird.thumbnailator.Thumbnails;

@Controller
public class CommonController {
	
	/**
	 * 上传头像
	 * 
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("uploadhead")
	public void uploadHead(HttpServletRequest request, HttpServletResponse response,String basePath) {
		// 保存图片
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			RequestFile requestFile = requestHolder.getRequestFile();
			if (requestFile != null && !requestFile.isEmpty()) {
				String path =basePath + RandomNum.getLGID() + ".png";
				File file = new File(requestHolder.getRealPathPath(path));
				if (!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();
				}
				Thumbnails.of(requestFile.getFile().getInputStream()).size(500, 500).outputQuality(0.7)
						.outputFormat("png").toFile(file);

				requestHolder.success(path);
				return;
			}
			requestHolder.fail("操作失败");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}
}
