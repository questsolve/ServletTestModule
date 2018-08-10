package com.kosmo.member.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kosmo.member.MemberVO;
import com.kosmo.member.service.MemberDAO;
import com.kosmo.member.service.common.DBManager;

public class MemberDAOImpl implements MemberDAO {

	public MemberDAOImpl() {
		System.out.println(this.getClass().getSimpleName()+" CREATED");
	}

	@Override
	public int insertMember(MemberVO vo) {
		int result = 0;
		DBManager dbm = new DBManager();

		Connection con = null;
		PreparedStatement pstate = null;
		StringBuffer sb = new StringBuffer("INSERT INTO ");
		sb.append("user_member");
		sb.append("(seq,id,pw,name,roll");
		
		if(vo.getRegdate()!=null) {
			sb.append(",regdate");
		}
		
		sb.append(") "); 
		
		sb.append("VALUES ");
		sb.append("(member_seq.nextval,?,?,?,'u'");

		if(vo.getRegdate()!=null) {
			sb.append(",TO_DATE(?,'YYYY/MM/DD')");
		}

		sb.append(")");

		try {
			con = dbm.dbConn();
			pstate = con.prepareStatement(sb.toString());
			pstate.setString(1, vo.getId());
			pstate.setString(2, vo.getPw());
			pstate.setString(3, vo.getName());

			if(vo.getRegdate()!=null) {
				pstate.setString(4, vo.getRegdate());
			}


			result = pstate.executeUpdate();


		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			dbm.dbClose(con, pstate);
		}





		return result;
	}
	
	public MemberVO select(int seq) {
		MemberVO searchedMember = new MemberVO();
		DBManager dbm = new DBManager();
		Connection con=null;
		PreparedStatement pstate =null;
		ResultSet rs = null;
		
		try {
			con = dbm.dbConn();
			String sql = "SELECT seq,id,name,roll,TO_CHAR(regdate,'YYYY/MM/DD') AS regdate FROM user_member WHERE seq =?";
			pstate = con.prepareStatement(sql);
			pstate.setInt(1, seq);
			rs = pstate.executeQuery();
			
			if(rs.next()) {
				searchedMember.setMemberSeq(rs.getInt("seq"));
				searchedMember.setId(rs.getString("id"));
				searchedMember.setName(rs.getString("name"));
				searchedMember.setRoll(rs.getString("roll"));
				searchedMember.setRegdate(rs.getString("regdate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbm.dbClose(con, pstate, rs);
			
		}
		
		
		
		return searchedMember;
	}
	
	
	public MemberVO login(MemberVO vo) {
		MemberVO loginMember = new MemberVO();
		DBManager dbm = new DBManager();
		Connection con=null;
		PreparedStatement pstate =null;
		ResultSet rs = null;
		
		try {
			con = dbm.dbConn();
			String sql = "SELECT seq,id,name,roll FROM user_member WHERE id=? AND pw =?";
			pstate = con.prepareStatement(sql);
			pstate.setString(1, vo.getId());
			pstate.setString(2, vo.getPw());
			rs = pstate.executeQuery();
			
			if(rs.next()) {
				loginMember.setMemberSeq(rs.getInt("seq"));
				loginMember.setId(rs.getString("id"));
				loginMember.setName(rs.getString("name"));
				loginMember.setRoll(rs.getString("roll"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbm.dbClose(con, pstate, rs);
			
		}
		return loginMember;
	}

	public List<MemberVO> listMember(){
		DBManager dbm = new DBManager();
		Connection con=null;
		PreparedStatement pstate =null;
		ResultSet rs = null;
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			con = dbm.dbConn();
			String sql = "SELECT seq,id,name,roll,TO_CHAR(regdate,'YYYY/MM/DD') AS regdate FROM user_member";
			pstate = con.prepareStatement(sql);
			rs = pstate.executeQuery();
			
			while(rs.next()) {
				MemberVO loginMember = new MemberVO();
				loginMember.setMemberSeq(rs.getInt("seq"));
				loginMember.setId(rs.getString("id"));
				loginMember.setName(rs.getString("name"));
				loginMember.setRoll(rs.getString("roll"));
				loginMember.setRegdate(rs.getString("regdate"));
				list.add(loginMember);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbm.dbClose(con, pstate, rs);
			
		}
		return list;
	}
	
	public int update(MemberVO vo){
		int result =0;
		DBManager dbm = new DBManager();

		Connection con = null;
		PreparedStatement pstate = null;
		StringBuffer sb = new StringBuffer("UPDATE ");
		sb.append("user_member ");
		sb.append("SET ");
		sb.append("pw = ?, name= ? ");
		sb.append("WHERE seq = ? ");
		
		
		try {
			con = dbm.dbConn();
			pstate = con.prepareStatement(sb.toString());
			pstate.setString(1, vo.getPw());
			pstate.setString(2, vo.getName());
			pstate.setInt(3, vo.getMemberSeq());

			result = pstate.executeUpdate();


		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			dbm.dbClose(con, pstate);
		}

		
		return result;
	}
	public int delete(int seq) {
		int result =0;
		
		//setting for using DB
		DBManager dbm = new DBManager();
		Connection con =null;
		PreparedStatement pstate = null;
		
		//SQL 
		StringBuffer sb = new StringBuffer();
		sb.append("DELETE FROM ");
		sb.append("user_member ");
		sb.append("WHERE ");
		sb.append("seq = ?");

		
		//
		try {
			con = dbm.dbConn();
			pstate = con.prepareStatement(sb.toString());
			pstate.setInt(1, seq);
			result = pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return result;
	}
}