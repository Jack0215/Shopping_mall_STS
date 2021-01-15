package com.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.dto.GoodsDTO;
 
@Repository
public class GoodsDAO {
@Autowired
SqlSessionTemplate template;
	public GoodsDTO goodsRetrieve( String gCode) {
		GoodsDTO list = 
				template.selectOne("GoodsMapper.goodsRetrieve", gCode);
		   return list;
	   }
   public List<GoodsDTO> goodsList( String gCategory) {
	   List<GoodsDTO> list = 
			   template.selectList("GoodsMapper.goodsList", gCategory);
	   return list;
   }
} 
 