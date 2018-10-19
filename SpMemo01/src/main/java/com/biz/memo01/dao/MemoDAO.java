package com.biz.memo01.dao;

import java.util.List;

import com.biz.memo01.vo.MemoInfoVO;
import com.biz.memo01.vo.MemoVO;

public interface MemoDAO {

	public void insert(MemoVO vo);
	
	public List<MemoVO> selectAll();
	public MemoVO selectOne(int id);
	
	public List<MemoInfoVO> selectInfoAll();
	
	public void update(MemoVO vo);
	public void delete(int id);
	
}
