package himedia.project.ver2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.project.ver2.dto.Member;

@Repository
public class MemberJdbcRepository implements MemberRepository{
	
	//연결과 관련된 소tm들
	private final DataSource dataSource;
	
	@Autowired
	public MemberJdbcRepository(DataSource dataSource) {
		// TODO Auto-generated constructor stub
		this.dataSource = dataSource;
	}
	
	@Override
	public Member save(Member member) {
		// TODO Auto-generated method stub
		String sql = "insert into member(name) values(?)";
		Connection con = null;
		// 동적 쿼리 사용을 위한 객체
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 실행 준비
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, member.getName());
			// 쿼리 실행
			pstmt.executeUpdate();
			// 마지막으로 생성된 row하나를 리턴해 rs에 저장
			rs = pstmt.getGeneratedKeys();
			// rs에 저장된 값이 있으면 첫번째 컬럼의 값을 Long타입으로가져와 setId
			if(rs.next()) {	
				member.setId(rs.getLong(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 자원해제
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					con.close();
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Member> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
