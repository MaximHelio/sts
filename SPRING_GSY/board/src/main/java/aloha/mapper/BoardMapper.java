package aloha.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import aloha.domain.Board;

@Mapper
public interface BoardMapper {

	public List<Board> list() throws Exception;

	public void insert(Board board) throws Exception;
	
}
