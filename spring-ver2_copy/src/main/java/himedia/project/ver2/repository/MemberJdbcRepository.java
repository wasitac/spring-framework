package himedia.project.ver2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.project.ver2.dto.Member;

@Repository
public class MemberJdbcRepository implements MemberRepository{
	
//	// [방법 1] 생성자 DI
//	//연결과 관련된 소스
//	private final DataSource dataSource;
//	
//	@Autowired
//	public MemberJdbcRepository(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
	
	// [방법 2] 필드 DI
	// final을 붙일 수 없어서 취약점이 있음
	@Autowired
	private DataSource dataSource;
	
	public MemberJdbcRepository() {
		System.out.println("[MemberJdbcRepository] field DI");
	}
	
	private void closeConnection(ResultSet rs, Statement stmt, Connection con) {
		try {
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if(con != null)
				con.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	@Override
	public Long save(Member member) {
		// [매개변수 표시 문자] ?
		String sql = "insert into member(name) values(?)";
		Connection con = null;
		// 동적 쿼리 사용을 위한 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 실행 준비
			con = dataSource.getConnection();
			// Statement.RETURN_GENERATED_KEYS : 자동증가하는 컬럼이 있다
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// 동적 쿼리문의 첫 번째 매개변수에 값 저장
			pstmt.setString(1, member.getName());
			// 쿼리 실행
			pstmt.executeUpdate();
			// 자동 생성된 키를 ResultSet리턴
			// 키가 생성되지 않으면, 빈 ResultSet 리턴
			rs = pstmt.getGeneratedKeys();
			// rs에 저장된 값이 있으면 첫번째 컬럼의 값을 Long타입으로가져와 setId
			if(rs.next()) {	
				member.setId(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원해제
			closeConnection(rs, pstmt, con);
		}
		return member.getId();
	}

// [과제 1] 없는 아이디 또는 이름 검색 시, 에러 해결
	@Override
	public Optional<Member> findById(Long id) {
		// TODO Auto-generated method stub
		String sql = "select * from member where id=(?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setId(rs.getLong(1));
				member.setName(rs.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, pstmt, con);
		}
		return Optional.ofNullable(member);
	}

	@Override
	public Optional<Member> findByName(String name) {
		String sql = "select * from member where name like (?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			// 가장 먼저 검색된 회원으로 출력
			if(rs.next()) {
				member = new Member();
				member.setId(rs.getLong(1));
				member.setName(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, pstmt, con);
		}
		return Optional.ofNullable(member);
	}

	@Override
	public List<Member> findAll() {
		String sql = "select * from member";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Member> members = null;
		try {
			con = dataSource.getConnection();
//			[정적 쿼리]
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
//			[동적 쿼리]
//			정적쿼리를 동적쿼리 처리구문으로 처리하는건 가능하지만 반대는 안된다.
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
			
			members = new ArrayList<Member>();
			
			while(rs.next()) {
				// 컬럼 접근
				// 1. 컬럼 인덱스 : 정수(1부터 시작)
				// 2. 컬럼 레이블: 컬럼명
				Member member = new Member();
//				member.setId(rs.getLong(1));
//				member.setName(rs.getString(2));
				member.setId(rs.getLong("id"));
				member.setName(rs.getString("name"));
				members.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, stmt, con);
		}
		
		return members;
	}
	

}
