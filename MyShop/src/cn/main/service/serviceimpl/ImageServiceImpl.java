package cn.main.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.main.dao.image.ImageMapper;
import cn.main.pojo.Image;
import cn.main.service.ImageService;
@Service
public class ImageServiceImpl implements ImageService {
	@Resource
	private ImageMapper imageMapper;
	
	@Override
	public List<Image> getImageList(Integer id, Integer type, Integer sid,
			String createTime, Integer from, Integer pageSize) {
		// TODO Auto-generated method stub
		return imageMapper.getImageList(id, type, sid, createTime, from, pageSize);
	}

	@Override
	public Integer getListCount(Integer id, Integer type, Integer sid,
			String createTime) {
		// TODO Auto-generated method stub
		return imageMapper.getListCount(id, type, sid, createTime);
	}

}
